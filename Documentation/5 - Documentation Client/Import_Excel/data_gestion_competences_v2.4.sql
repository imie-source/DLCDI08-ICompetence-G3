/* Table : CURSUS */
DELETE FROM CURSUS;
INSERT INTO CURSUS (CUR_ID, CUR_Libelle) VALUES('1', 'CDI');
INSERT INTO CURSUS (CUR_ID, CUR_Libelle) VALUES('2', 'DL');
INSERT INTO CURSUS (CUR_ID, CUR_Libelle) VALUES('3', 'WEB');
INSERT INTO CURSUS (CUR_ID, CUR_Libelle) VALUES('4', 'ADMIN');
/* Table : ADRESSE */
DELETE FROM ADRESSE;
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('1', '11 rue la chenaie', 'lieu dit la boulaie', '44001', 'NANTES1');
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('2', '12 rue la chenaie', NULL, '44002', 'NANTES2');
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('3', '13 rue la chenaie', NULL, '44003', 'NANTES3');
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('4', '14 rue la chenaie', 'bis', '44004', 'NANTES4');
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('5', '15 rue la chenaie', NULL, '44005', 'NANTES5');
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('6', '16 rue la chenaie', 'lieu dit la chambarderie', '44006', 'NANTES6');
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('7', '17 rue la chenaie', NULL, '44007', 'NANTES7');
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('8', '18 rue la chenaie', NULL, '44008', 'NANTES8');
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('9', '19 rue la chenaie', 'lieu dit la cascade', '44009', 'NANTES9');
INSERT INTO ADRESSE (ADR_ID, ADR_Rue, ADR_Complement, ADR_CP, ADR_Ville) VALUES('10', '20 rue la chenaie', NULL, '44010', 'NANTES10');
/* Table : PROFIL */
DELETE FROM PROFIL;
INSERT INTO PROFIL (PRO_ID, PRO_Nom, PRO_Libelle) VALUES('1', 'Créateur Projet', 'Libelle createur de projet');
INSERT INTO PROFIL (PRO_ID, PRO_Nom, PRO_Libelle) VALUES('2', 'Volontaire', 'Libelle volontaire');
INSERT INTO PROFIL (PRO_ID, PRO_Nom, PRO_Libelle) VALUES('3', 'Super Admin', 'libelle super admin');
INSERT INTO PROFIL (PRO_ID, PRO_Nom, PRO_Libelle) VALUES('4', 'Chef de Projet', 'libelle chef de projet');
/* Table : UTILISATEUR */
DELETE FROM UTILISATEUR;
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('1', 'HARDY', 'Michel', '01/09/1980', 'michel.hardy@imie.fr', '0101010101', '1111111111', '1', '1', 'mha01', 'mha01', '2', '1');
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('2', 'Chaillou', 'Guillaume', '01/10/1981', 'guillaume.chaillou@imie.fr', '0202020202', '2222222222', '0', '1', 'gch02', 'gch02', '4', '2');
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('3', 'Mischler', 'David', '01/11/1982', 'david.mischler@imie.fr', '0303030303', '3333333333', '1', '1', 'dmi03', 'dmi03', NULL, '3');
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('4', 'Korbynets', 'Elena', '02/12/1983', 'elena.korbynets@imie.fr', '0404040404', '4444444444', '0', '1', 'eko04', 'eko04', '2', '4');
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('5', 'Corsini', 'Emmanuel', '02/12/1983', 'emmanuel.corsini@imie.fr', '0505050505', '5555555555', '1', '1', 'eco05', 'eco05', NULL, '5');
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('6', 'Eschrich', 'Jean-Phillipe', '03/01/1986', 'Jean-philippe.eschrich@imie.fr', '0606060606', '6666666666', '0', '1', 'jes06', 'jes06', '2', '6');
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('7', 'Ndiaye', 'Fatou Marie', '04/02/1986', 'Fatou-marie.ndiaye@imie.fr', '0707070707', '7777777777', '1', '1', 'fnd07', 'fnd07', '2', '7');
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('8', 'Baron', 'Freddy', '05/03/1987', 'freddy.baron@imie.fr', '0808080808', '8888888888', '0', '1', 'fba08', 'fba08', NULL, '8');
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('9', 'Neau', 'Frederic', '06/03/1988', 'Frederic.neau@imie.fr', '0909090909', '9999999999', '0', '0', 'fne09', 'fne09', NULL, '9');
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('10', 'Dequeant', 'Johan', '05/03/1984', 'Johan.dequeant@imie.fr', '1010101010', '1000000000', '1', '0', 'joh10', 'joh10', '2', NULL);
INSERT INTO UTILISATEUR (USR_ID, USR_Nom, USR_Prenom, USR_DateN, USR_Mail, USR_Tel, USR_Fax, USR_EstEnFormation, USR_EstDisponible, USR_Login, USR_Pass, CUR_ID, ADR_ID) VALUES('11', 'HARDY', 'Olivier', NULL, NULL, NULL, NULL, '1', '1', 'a', 'a', NULL, NULL);
/* Table : STATUT */
DELETE FROM STATUT;
INSERT INTO STATUT (STA_ID, STA_Libelle) VALUES('1', 'Création');
INSERT INTO STATUT (STA_ID, STA_Libelle) VALUES('2', 'En cours');
INSERT INTO STATUT (STA_ID, STA_Libelle) VALUES('3', 'Finalisé');
INSERT INTO STATUT (STA_ID, STA_Libelle) VALUES('4', 'Livré');
/* Table : FENETRE */
DELETE FROM FENETRE;
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('1', 'securité');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('2', 'adresse');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('3', 'utilisateur');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('4', 'groupes de travail');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('5', 'administration des statuts');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('6', 'administration des fonctions');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('7', 'administration des cursus');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('8', 'administration des domaines');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('9', 'administration des niveaux de compétences');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('10', 'administration de la nature des droits');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('11', 'administration des profils');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('12', 'compétences');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('13', 'utilisateurs');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('14', 'groupes de travail');
INSERT INTO FENETRE (FEN_ID, FEN_Description) VALUES('15', 'recherche de compétences');
/* Table : FONCTION */
DELETE FROM FONCTION;
INSERT INTO FONCTION (FCT_ID, FCT_Libelle, FCT_Action, FEN_ID) VALUES('1', 'mettre à jour la sécurité', '1', '1');
INSERT INTO FONCTION (FCT_ID, FCT_Libelle, FCT_Action, FEN_ID) VALUES('2', 'ajouter  la sécurité', '2', '1');
INSERT INTO FONCTION (FCT_ID, FCT_Libelle, FCT_Action, FEN_ID) VALUES('3', 'supprimer  la sécurité', '3', '1');
INSERT INTO FONCTION (FCT_ID, FCT_Libelle, FCT_Action, FEN_ID) VALUES('4', 'mettre à jour un utilisateur', '1', '3');
INSERT INTO FONCTION (FCT_ID, FCT_Libelle, FCT_Action, FEN_ID) VALUES('5', 'ajouter un utilisateur', '2', '3');
INSERT INTO FONCTION (FCT_ID, FCT_Libelle, FCT_Action, FEN_ID) VALUES('6', 'supprimer un utilisateur', '3', '3');
INSERT INTO FONCTION (FCT_ID, FCT_Libelle, FCT_Action, FEN_ID) VALUES('7', 'mettre à jour un groupe de travail', '1', '4');
INSERT INTO FONCTION (FCT_ID, FCT_Libelle, FCT_Action, FEN_ID) VALUES('8', 'ajouter un groupe de travail', '2', '4');
INSERT INTO FONCTION (FCT_ID, FCT_Libelle, FCT_Action, FEN_ID) VALUES('9', 'supprimer un groupe de travail', '3', '4');
/* Table : KEYWORD */
DELETE FROM KEYWORD;
INSERT INTO KEYWORD (KEY_ID, KEY_Libelle) VALUES('1', 'java');
INSERT INTO KEYWORD (KEY_ID, KEY_Libelle) VALUES('2', 'UML');
INSERT INTO KEYWORD (KEY_ID, KEY_Libelle) VALUES('3', 'PHP');
INSERT INTO KEYWORD (KEY_ID, KEY_Libelle) VALUES('4', 'Servlet');
/* Table : COMPETENCE */
DELETE FROM COMPETENCE;
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('13', 'Support fonctionnel', NULL);
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('14', 'Développement logiciel et web', NULL);
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('15', 'Développement hardware', NULL);
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('16', 'Développement jeux vidéos', NULL);
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('17', 'Administration , réseaux', NULL);
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('18', 'utilisation logiciels dessins et vidéos', NULL);
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('19', 'Administration', '17');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('20', 'réseaux', '17');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('21', 'logiciel dessin', '18');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('11', 'management', '13');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('12', 'Développement logiciel', '14');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('22', 'Développement web', '12');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('1', 'Management entre 1 et 10 personnes', '20');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('2', 'langage SQL', '12');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('3', 'langage C++', '15');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('4', 'langage python', '16');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('5', 'réseaux', '20');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('6', 'Logiciel autocad', '21');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('7', 'SQL', '12');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('8', 'Java', '12');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('9', 'JSP', '22');
INSERT INTO COMPETENCE (COM_ID, COM_Libelle, COM_ID1) VALUES('10', 'Internet', '9');
/* Table : NIVEAU */
DELETE FROM NIVEAU;
INSERT INTO NIVEAU (NIV_ID, NIV_Evaluation, NIV_Description) VALUES('1', '1', 'Débutant');
INSERT INTO NIVEAU (NIV_ID, NIV_Evaluation, NIV_Description) VALUES('2', '2', 'Intermédiaire');
INSERT INTO NIVEAU (NIV_ID, NIV_Evaluation, NIV_Description) VALUES('3', '3', 'Avancé');
/* Table : NATURE */
DELETE FROM NATURE;
INSERT INTO NATURE (NAT_ID, NAT_Libelle, NAT_Code) VALUES('1', 'Read', 'R');
INSERT INTO NATURE (NAT_ID, NAT_Libelle, NAT_Code) VALUES('2', 'Execute', 'E');
/* Table : GROUPE */
DELETE FROM GROUPE;
INSERT INTO GROUPE (GRP_ID, GRP_Avancement, GRP_Nom, GRP_Description, GRP_Resume, STA_ID, USR_ID) VALUES('1', '10', 'Projet A', 'Description Projet A', 'Resume Projet A', '2', '4');
INSERT INTO GROUPE (GRP_ID, GRP_Avancement, GRP_Nom, GRP_Description, GRP_Resume, STA_ID, USR_ID) VALUES('2', '20', 'Projet B', 'Description Projet B', 'Resume Projet B', '2', '6');
INSERT INTO GROUPE (GRP_ID, GRP_Avancement, GRP_Nom, GRP_Description, GRP_Resume, STA_ID, USR_ID) VALUES('3', '0', 'Projet C', 'Description Projet C', 'Resume Projet C', '1', '4');
INSERT INTO GROUPE (GRP_ID, GRP_Avancement, GRP_Nom, GRP_Description, GRP_Resume, STA_ID, USR_ID) VALUES('4', '95', 'Projet D', 'Description Projet D', 'Resume Projet D', '3', '7');
INSERT INTO GROUPE (GRP_ID, GRP_Avancement, GRP_Nom, GRP_Description, GRP_Resume, STA_ID, USR_ID) VALUES('5', '100', 'Projet E', 'Description Projet E', 'Resume Projet E', '4', '4');
/* Table : GRP_USER */
DELETE FROM GRP_USER;
INSERT INTO GRP_USER (USR_ID, GRP_ID) VALUES('1', '1');
INSERT INTO GRP_USER (USR_ID, GRP_ID) VALUES('5', '2');
INSERT INTO GRP_USER (USR_ID, GRP_ID) VALUES('5', '1');
INSERT INTO GRP_USER (USR_ID, GRP_ID) VALUES('6', '1');
/* Table : PRO_USER */
DELETE FROM PRO_USER;
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('1', '1');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('2', '3');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('3', '4');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('4', '2');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('5', '1');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('6', '2');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('7', '2');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('8', '3');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('9', '1');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('10', '4');
INSERT INTO PRO_USER (USR_ID, PRO_ID) VALUES('11', '1');
/* Table : DROIT */
DELETE FROM DROIT;
INSERT INTO DROIT (FCT_ID, NAT_ID, PRO_ID) VALUES('1', '2', '3');
INSERT INTO DROIT (FCT_ID, NAT_ID, PRO_ID) VALUES('2', '2', '3');
INSERT INTO DROIT (FCT_ID, NAT_ID, PRO_ID) VALUES('3', '2', '3');
INSERT INTO DROIT (FCT_ID, NAT_ID, PRO_ID) VALUES('4', '2', '2');
INSERT INTO DROIT (FCT_ID, NAT_ID, PRO_ID) VALUES('4', '2', '4');
INSERT INTO DROIT (FCT_ID, NAT_ID, PRO_ID) VALUES('5', '2', '3');
INSERT INTO DROIT (FCT_ID, NAT_ID, PRO_ID) VALUES('6', '2', '3');
/* Table : COM_USER */
DELETE FROM COM_USER;
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('1', '1', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('1', '2', '1');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('1', '3', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('1', '4', '3');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('1', '5', '1');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('2', '2', '1');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('2', '4', '1');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('2', '6', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('2', '7', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('3', '3', '3');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('3', '4', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('4', '8', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('5', '8', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('6', '8', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('7', '8', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('7', '9', '3');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('8', '8', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('10', '8', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('10', '9', '2');
INSERT INTO COM_USER (USR_ID, COM_ID, NIV_ID) VALUES('10', '10', '2');
/* Table : INVITATION */
DELETE FROM INVITATION;
INSERT INTO INVITATION (INV_ID, INV_DATE, INV_Reponse, GRP_ID, USR_ID) VALUES('1', '04/07/2013', 'true', '1', '1');
INSERT INTO INVITATION (INV_ID, INV_DATE, INV_Reponse, GRP_ID, USR_ID) VALUES('2', '10/07/2013', 'false', '2', '2');
INSERT INTO INVITATION (INV_ID, INV_DATE, INV_Reponse, GRP_ID, USR_ID) VALUES('3', '15/07/2013', 'true', '3', '3');
INSERT INTO INVITATION (INV_ID, INV_DATE, INV_Reponse, GRP_ID, USR_ID) VALUES('4', '14/07/2013', 'false', '4', '4');
INSERT INTO INVITATION (INV_ID, INV_DATE, INV_Reponse, GRP_ID, USR_ID) VALUES('5', '07/07/2013', 'true', '5', '5');
/* Table : COM_KEY */
DELETE FROM COM_KEY;
INSERT INTO COM_KEY (COM_ID, KEY_ID) VALUES('1', '2');
INSERT INTO COM_KEY (COM_ID, KEY_ID) VALUES('2', '1');
INSERT INTO COM_KEY (COM_ID, KEY_ID) VALUES('3', '3');
INSERT INTO COM_KEY (COM_ID, KEY_ID) VALUES('4', '4');
