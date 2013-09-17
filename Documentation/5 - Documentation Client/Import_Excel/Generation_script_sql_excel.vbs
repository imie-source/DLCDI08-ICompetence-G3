'------------------------------------------------------------------------------------------------
'
' Usage: Generation_script_sql_excel
'              <--input|-i fichier_input>
'              <--output|-o fichier_output>
'    		   [--verbose|-v]
'              [--help|-?]
'
' Exemple 1: Generation_script_sql_excel -i test.csv -o test.sql -t table_test

' Creation : Michel HARDY
' Date creation : 22/05/2013
'
'------------------------------------------------------------------------------------------------

' Force explicit declaration of all variables
Option Explicit

On Error Resume Next

Const ForReading = 1, ForWriting = 2
Const Erreur_Fic_manquant = "Impossible de trouver le fichier"


Dim oArgs, ArgNum
Dim verbose
Dim ArgFicInput
Dim ArgFicOutput
Dim sCurDir
Dim Xlapp 'Excel
Dim wb 'le classeur
Dim cListe  'Pas possible en VBScript de récupérer un collection en référence
Dim iNbWorksheet


verbose = false			'Affiche les traces à l'écran : True/False
ArgNum = 0

'class struct
	'Dim table
'	Dim Entete
'	Dim Valeurs
'end class

Set oArgs = WScript.Arguments

While ArgNum < oArgs.Count
	Select Case LCase(oArgs(ArgNum))
		Case "--input", "-i":
			ArgNum = ArgNum + 1
			ArgFicInput = oArgs(ArgNum)
		Case "--output", "-o":
			ArgNum = ArgNum + 1
			ArgFicOutput = oArgs(ArgNum)
		Case "--verbose", "-v":
			verbose = true
		Case "--help","-?":
			Call DisplayUsage
		Case Else:
			Call DisplayUsage
	End Select
	ArgNum = ArgNum + 1
Wend

If (ArgFicInput="" or ArgFicOutput="") Then
	Call DisplayUsage
	Else
	sCurDir = Left(wscript.ScriptFullname,Len(wscript.ScriptFullname) - Len(wscript.ScriptName))

	Trace("Main() :: Répertoire : " & sCurDir)
	Trace("Main() :: Fic d'entree : " & ArgFicInput)
	Trace("Main() :: Fic de sortie : " & ArgFicOutput)

	Call Generation(ArgFicInput,ArgFicOutput,sCurDir)
End If

'-------------------------------------------
' Generation
'-------------------------------------------
Sub Generation(sFicEntre,sFicSortie,sCurDir)
	Dim oFSO
	Dim oTsOut
	Dim iCompteurWS
	Dim iBoucle

	On Error Resume Next

	Set oFSO = CreateObject("Scripting.FileSystemObject")

	'-------------------------------------------
	'Verification du fichier d'entree
	'-------------------------------------------

	If ExisteFichier(sCurDir & sFicEntre) = False Then
		Trace("Generation :: " & Erreur_Fic_manquant)
		wscript.quit
	End If

    '-------------------------------------------
    'Ouverture du fichier EXCEL et récupération du nombre de Worksheet
    '-------------------------------------------
	Trace("Generation :: Ouverture EXCEL")
	Call OuvertureExcel(sCurDir & sFicEntre)
	Trace("Generation :: Nombre de Worksheet : " & iNbWorksheet)

    '-------------------------------------------
    'Ouverture en écriture du fichier plat CSV
    '-------------------------------------------
	Trace("Generation :: Ouverture fichier de sortie")
	Set oTsOut=oFSO.CreateTextFile(sCurDir & sFicSortie, ForWriting)

    '-------------------------------------------
    'Récupération d'une collection : NomTable (= Nom de la Worksheet) + string d'entete + données
    '-------------------------------------------
	for iCompteurWS = 1 to iNbWorksheet	'Boucle sur le nombre de Worksheet
		'-------------------------------------------
		' Ecriture dans un fichier plat CSV
		'-------------------------------------------
		Trace("Generation :: Récupération du Worksheet n° : " & iCompteurWS)
		Call RecupDataExcel(iCompteurWS)
		Trace("Generation : Table : " & cListe.item(cstr(1)))
		oTsOut.WriteLine "/* Table : " & cListe.item(cstr(1)) & " */"
		'oTsOut.WriteLine "TRUNCATE TABLE " & cListe.item(cstr(1)) & " CASCADE;"
		oTsOut.WriteLine "DELETE FROM " & cListe.item(cstr(1)) & ";"
	
		for iBoucle = 3 to cListe.count  'Ne commence qu'a 3 debut des INSERT
			'Trace("Generation :: INSERT INTO " & cListe.item(cstr(1)) & " (" & cListe.item(cstr(2)) & ") VALUES(" & cListe.item(cstr(iBoucle)) & ");")
			oTsOut.WriteLine "INSERT INTO " & cListe.item(cstr(1)) & " (" & cListe.item(cstr(2)) & ") VALUES(" & cListe.item(cstr(iBoucle)) & ");"
		next
	next

    '-------------------------------------------
	' Procédure pour fermer EXCEL
    '-------------------------------------------
	Trace("Generation : Fermeture EXCEL + Désinstancier tous les objets utilisés")

	wb.close false 'ferme sans sauver
	XlApp.quit 'quitte excel
	Set Wb = Nothing
	Set XlApp = Nothing	

    '-------------------------------------------
	' Désinstancier tous les objets utilisés
    '-------------------------------------------
	oTsOut.Close
	Set oTsOut = nothing
	Set oFSO = nothing
	set cListe = nothing

	'MsgBox "Traitement terminé !"
	wscript.quit 0 'renvoyant un code d'erreur égal à n
	' Sous DOS, ce code d'erreur peut être testé avec l'instruction if ERRORLEVEL n

End Sub

'---------------------------------------------------------------------
' Verification de l'existence d'un fichier
'---------------------------------------------------------------------
Function ExisteFichier(ByVal sFic)
    Dim oFSO

    Set oFSO = CreateObject("Scripting.FileSystemObject")
    If oFSO.FileExists(sFic) Then
        ExisteFichier = True
    Else
        ExisteFichier = False
    End If
    Set oFSO = Nothing
End Function

'-------------------------------------------
'Affichage de message
'-------------------------------------------
Sub Display(Msg)
	WScript.Echo Now & ". Error Code: " & Hex(Err) & " - " & Msg
End Sub

'-------------------------------------------
'Affichage de traces
'-------------------------------------------
Sub Trace(Msg)
	if verbose = true then  WScript.Echo Now & " : " & Msg
End Sub

'-------------------------------------------
'Affichage de l'usage à l'utilisateur
'-------------------------------------------
Sub DisplayUsage()
	WScript.Echo "Usage: Generation_script_sql_excel <--input|-i fichier input>" & vbcrlf & _
	"                 <--output|-o fichier output>" & vbcrlf & _
	"                 [--verbose|-v]" & vbcrlf & _
	"                 [--help|-?]" & vbcrlf & _
	"Exemple 1: Generation_script_sql_excel -i test.csv -o test.sql"

	WScript.Quit (1)
End Sub

'-------------------------------------------
'Construire une string à partir d'un collection
'-------------------------------------------
Function ContruireStringAvecCollection (cListe, iEntete)
	Dim iBoucle
	Dim sRetour
	
	sRetour=""
	'Trace("ContruireStringAvecCollection :: entete : " & iEntete)
	for iBoucle = 1 to cListe.count
		'Trace("ContruireStringAvecCollection :: for : iBoucle = " & iBoucle & "; element Liste : " & cListe.item(cstr(iBoucle)))
		if iEntete = 1 then  'Cas de l'entete qui est différent du reste
			if iBoucle>1 then
				sRetour = sRetour & ", " & cListe.item(cstr(iBoucle))
			else
				sRetour = cListe.item(cstr(iBoucle))
			end if
		else
			if iBoucle>1 then
				sRetour = sRetour & ", " & Formatage(cListe.item(cstr(iBoucle)))
			else
				sRetour = Formatage(cListe.item(cstr(iBoucle)))
			end if
		end if
	next
	ContruireStringAvecCollection=sRetour
end function

'-------------------------------------------
'Ouvrir Formatage de la colonne : NULL si vide et Attention au BOOLEEN (VRAI et FAUX)
'-------------------------------------------
Function Formatage(sCol)
	sCol = trim(sCol)
	if sCol <>"" then
		if sCol = "TRUE" or sCol = "FALSE" then
			Formatage = sCol
		else
			Formatage = "'" & replace(sCol,"'","''") & "'"
		end if
	else
		Formatage = "NULL"
	end if
end function

'-------------------------------------------
'Ouvrir EXCEL
'-------------------------------------------
Function OuvertureExcel(sFichier)
	Set xlapp = CreateObject("Excel.Application")
	Set Wb = XlApp.Workbooks.Open(sFichier)	' Ouverture du classeur
	xlapp.Visible = True
	
	'Désactiver le mode de calcul
	'Désactiver la mise à jour à l'écran
	'Désaciver les évènements
	
	iNbWorksheet = Wb.Sheets.Count
end function

'-------------------------------------------
'Récupère les données à partir du numéro de Worksheet
'-------------------------------------------
Function RecupDataExcel(iCompteurWS)
' Rectourne un collection d'objets
	Dim cData	'Collection de données; la construction des INSERT se fara dans la foulée pour éviter de manipuler un autre objet
	Dim intRow, intCol
	Dim cCol	'Collection de sous-données "colonne"
	Dim sVal
	Dim iMaxCol
	Dim sTable
	Dim iListe
	Dim sValeur
	
	'Détermine le nombre de colonnes à partir des entetes
	sTable = Wb.Sheets(iCompteurWS).Name
	Trace("RecupDataExcel :: Table : " & sTable)	
	'-----------------------------------------
	'          ENTETE
	'-----------------------------------------
	intCol=1
	Set cCol = CreateObject("Scripting.Dictionary")
	Do Until (Wb.Sheets(iCompteurWS).Cells(1,intCol).Value = "")	'Boucle sur le nombre de colonnes du Worksheet
	    cCol.Item(cstr(intCol)) = cstr(Wb.Sheets(iCompteurWS).Cells(1,intCol).Value)
		'Trace("RecupDataExcel :: Donnee recuperee " & cstr(intCol) & " : " & cCol.Item(cstr(intCol)) & " ; cell = " & cstr(Wb.Sheets(iCompteurWS).Cells(1,intCol).Value))
		intCol = intCol + 1
	loop
	iMaxCol = cCol.count
	'Trace("RecupDataExcel :: Nombre de colonnes : " & iMaxCol)
	' Construire la string d'entete
	sVal = ContruireStringAvecCollection(cCol, 1)
	Set cCol = nothing
	Trace("RecupDataExcel :: Entete : " & sVal)
	'-----------------------------------------
	'          FIN ENTETE
	'-----------------------------------------
		
	'-----------------------------------------
	'          Construction de la collection globale : NomTable + Entete + data
	'-----------------------------------------
	Set cListe = CreateObject("Scripting.Dictionary")
	iListe = 1
	cListe.Item(cstr(iListe)) = cstr(sTable)
	iListe = 2
	cListe.Item(cstr(iListe)) = cstr(sVal)
	iListe = 3

	'-----------------------------------------
	'         CORPS
	'-----------------------------------------
	intRow = 2
	Do Until (Wb.Sheets(iCompteurWS).Cells(intRow,1).Value = "")	'Boucle sur le nombre de lignes de chaque Worksheet
		Set cCol = CreateObject("Scripting.Dictionary")
		for intCol = 1 to iMaxCol
			cCol.Item(cstr(intCol)) = cstr(Wb.Sheets(iCompteurWS).Cells(intRow,intCol).Value)
			'Trace("RecupDataExcel :: Donnee recuperee " & cstr(intCol) & " : " & cCol.Item(cstr(intCol)) & " ; cell = " & cstr(Wb.Sheets(iCompteurWS).Cells(intRow,intCol).Value))
		next
		sValeur = ContruireStringAvecCollection(cCol, 0)
		'Trace("RecupDataExcel :: sValeur : " & sValeur)
		Set cCol = nothing
		intRow = intRow + 1
		cListe.Item(cstr(iListe)) = sValeur
		iListe = iListe + 1			
	loop 
	'-----------------------------------------
	' /*         FIN CORPS
	'-----------------------------------------
	
end function
