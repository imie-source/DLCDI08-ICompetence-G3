@echo off
rem --------------------------------------
rem Parametre
rem --------------------------------------

rem Generation de script
cscript Generation_script_sql_excel.vbs -i data_gestion_competences_v2.4.xls -o data_gestion_competences_v2.4.sql -v

if ERRORLEVEL 0 echo Tout est bien fini
pause