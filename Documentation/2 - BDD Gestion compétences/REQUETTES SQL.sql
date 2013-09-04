--FAIT
--1'. Lire les compétences des volontaires -  DAO competences (à FAIT 

SELECT utilisateur.nom, utilisateur.prenom, competence.nom as competence, niveau.valeur as niveau
FROM competence
	INNER JOIN competence_util ON
	competence.num=competence_util.num_competence

	INNER JOIN utilisateur ON
	utilisateur.num=competence_util.num_util

	INNER JOIN niveau ON
	niveau.num=competence_util.num_niveau
ORDER BY utilisateur.nom




--1.Lire les compétences des membres du même groupe - DAO niveau ?

SELECT projet.intitule as projet, utilisateur.nom, utilisateur.prenom, competence.nom as competence, niveau.valeur as niveau
FROM competence
	LEFT JOIN competence_util ON
	competence.num=competence_util.num_competence

	INNER JOIN utilisateur ON
	utilisateur.num=competence_util.num_util

	INNER JOIN niveau ON
	niveau.num=competence_util.num_niveau

	INNER JOIN projet_util ON
	projet_util.num_util=utilisateur.num

	INNER JOIN projet ON
	projet_util.num_projet=projet.num
		
		WHERE projet.intitule='Java entreprise'


		
	
--JULIEN DAO competences
--2.CRUD les compétences (pour l'administrateur =>ajouter ou modifier la liste des compétences) - 

SELECT * FROM competence -- afficher la liste des compétences, prévoir un affichage avec l'arborescence!!!

INSERT into  competence(nom, competence_domaine) VALUES('JEE', 8)--insertion d'une compétence. Comment savoir dans quelle autre compétence la placer?

UPDATE competence SET nom='J2EE' WHERE num=14

DELETE FROM competence WHERE nom ='J2EE'


-- A FAIRE
-- DAO projet 
--3. CRUD PROJET  =>Droits ADMIN 
--PROJET
--READ lecture projet
SELECT num, intitule, num_statut FROM projet;

--CREATE Création du projet
INSERT INTO projet (intitule, num_statut) VALUES('ProjetTOTO1', 1)

--UPDATE modif projet
UPDATE projet SET intitule='projet test' WHERE num=9
--DELETE
DELETE FROM projet WHERE intitule='projet test'


--???????
--AFFECTATION DES VOLONTAIRES AU PROJET - ?
--READ 
SELECT projet.num, intitule as projet, nom, prenom FROM utilisateur
	INNER JOIN projet_util ON
	projet_util.num_util=utilisateur.num

	INNER JOIN projet ON
	projet_util.num_projet=projet.num
	WHERE projet.intitule='Gestion competences'
	
--CREATE AND UPDATE
INSERT INTO projet_util VALUES (2,1)--1 correspond à la personne n°1 et le 2 au projet n°2

-- DELETE
DELETE FROM projet_util WHERE num_util=2 AND num_projet=1

-- + MODIFIER LE PROFIL DE USER VERS VOLONTAIRE!!!




--5 PAS BON CU des projets sauf affectation du chef de projet=> Droits CHEF DE PROJET 
--READ 

SELECT projet.num, intitule as projet FROM projet
	
--CREATE AND UPDATE
INSERT INTO projet_util VALUES (2,1)--1 correspond à la personne n°1 et le 2 au projet n°2


-- DELETE
DELETE FROM projet_util WHERE num_util=2 AND num_projet=1


--6 A FAIRE avec la table invitation


--7 ADMIN affecte le CHEF DE PROJET à un PROJET et l'informe
--affectation de l'utilisateur au projet en tant que CHEF DE PROJET
--A FAIRE DAO projet
UPDATE projet SET num_util='1'  WHERE intitule='Gestion competences'

--A FAIRE DAO à venir
--mise à jour du profil uitlisateur en tant que chef de projet=> on donne à l'utilisateur un profil supplémentaire via INSERT et non UPDATE
INSERT INTO profil_util VALUES (1,5)
--ajouter une condition si plusieurs profils afin de supprimer les profils inutils!!!

SELECT * FROM profil_util



--A FAIRE DAO projet
--8 VOLONTAIRE => Read sur les groupes et les volontaires qui les composent

SELECT projet.num, intitule as projet, nom, prenom FROM utilisateur
	RIGHT JOIN projet_util ON
	projet_util.num_util=utilisateur.num

	RIGHT JOIN projet ON
	projet_util.num_projet=projet.num

	ORDER BY projet.intitule
	
	
-- FAIT DAO user, comptences, niveau
--9 VOLONTAIRE =>CRUD des volontaires sur ces données
--READ
SELECT promotion.intitule as promotion, utilisateur.nom, prenom, adresse, mail, tel, date_naissance, competence.nom as competence, niveau.valeur as niveau 
FROM utilisateur 
INNER JOIN promotion ON 
	promotion.num=utilisateur.num_promotion
INNER JOIN competence_util ON
	utilisateur.num=competence_util.num_util
INNER JOIN niveau ON
	niveau.num=competence_util.num_niveau
INNER JOIN competence ON
	competence.num=competence_util.num_competence

ORDER BY utilisateur.nom



-- A FAIRE DAO projet
--11 Consulatation des indicateurs : nombre de prjets/nbr personnes par projet/etat projet
SELECT projet.intitule as projet, COUNT(projet_util.num_util) as participant, statut.valeur as statut
FROM projet 
LEFT JOIN statut ON
	statut.num=projet.num_statut
LEFT JOIN projet_util ON
	projet.num=projet_util.num_projet
GROUP BY projet.intitule, statut.valeur


--A FAIRE DAO Projet
--12 READ et UPDATE du projet
SELECT projet.intitule as projet, statut.valeur 
FROM projet
LEFT JOIN statut ON
		projet.num_statut=statut.num

-- UPDATE état du projet
UPDATE projet SET num_statut=3 WHERE intitule='ProjetToto'


--Version détaillée READ - ne sert pas
SELECT projet.intitule as projet, utilisateur.nom, utilisateur.prenom, statut.valeur as statut, projet.num_util,
	(SELECT utilisateur.nom FROM utilisateur 
	where utilisateur.num=projet.num_util) as chef_projet
FROM projet
INNER JOIN projet_util ON
		projet.num=projet_util.num_projet
INNER JOIN utilisateur ON
		utilisateur.num=projet_util.num_util
INNER JOIN statut ON
		projet.num_statut=statut.num
ORDER BY projet.intitule




--FAIT DAO user
--13 CRUD données USER = > rôle administrateur 
--READ
SELECT utilisateur.num, utilisateur.nom, utilisateur.prenom, utilisateur.adresse, utilisateur.mail, utilisateur.tel, utilisateur.date_naissance, promotion.intitule as promotion
FROM utilisateur
LEFT JOIN promotion ON
		utilisateur.num_promotion=promotion.num
ORDER BY utilisateur.nom, utilisateur.prenom

	
--CREATE utilisateur - insérer un nouvel utilisateur
INSERT INTO utilisateur (nom, prenom, adresse, mail, tel, date_naissance, num_promotion) VALUES('Stark', 'Tony', 'Malibu', 'ironman@yahoo.com', '0978465459','1965-09-25','6')

--UPDATE - modifier les données de l'utilisateur
UPDATE utilisateur SET mail='tito@yahoo.com"', tel='0645896345' WHERE nom='KOBRYNETS'

--DELETE - supprimer un utilisateur
DELETE FROM utilisateur WHERE nom='Stark'


-- A FAIRE - DAO projet
--14 READ de la liste des mails d'un groupe=> rôle volontaire
SELECT utilisateur.nom, utilisateur.prenom, utilisateur.mail
FROM utilisateur
INNER JOIN projet_util ON
	utilisateur.num=projet_util.num_util
INNER JOIN projet ON
projet_util.num_projet=projet.num
WHERE projet.intitule='Java entreprise'


-- A redemander au client
--15 UPDATE info de son projet = >rôle volontaire
UPDATE projet SET description='blabla blabla bla bla bla'
WHERE intitule='Java entreprise'



--16 READ infos de tous les projets = >rôle volontaire
SELECT intitule as projet, description FROM projet

-- 17 Informe le changement de chef de projet => rôle administrateur
SELECT projet.intitule, CONCAT(utilisateur.nom, ' ', utilisateur.prenom) as chef_de_projet
FROM projet
	INNER JOIN utilisateur ON projet.num_util=utilisateur.num
WHERE intitule='Developpement reseau' 



--18 Gestion des invitations = > DAO invitation
--Etape 1 Envoi de l'invitation
INSERT INTO invitation (num_projet, num_util, message, reponse) VALUES (3, 5, "Souhaitez-vous participez au projet n°3", false)
--Etape 2 Réponse à l'invitation
--TODO
--Etape 3 Si réponse positive =>repponse pass à TRUE
--TODO

-- Afficher les utilisateurs invitatés pour un projet
SELECT utilisateur.nom, utilisateur.prenom FROM invitation 
INNER JOIN utilisateur ON
	invitation.num_util = utilisateur.num
WHERE num_projet = 1

-- Afficher les projets avec les invitations pour un utilisateur
SELECT projet.intitule, invitation.message FROM projet
INNER JOIN invitation ON
	projet.num = invitation.num_projet
WHERE invitation.num_util = 1
	
	

