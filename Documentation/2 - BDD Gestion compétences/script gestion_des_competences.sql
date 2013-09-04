

--CREATION DES TABLES


-- SERVICE UTILISATEUR
CREATE TABLE UTILISATEUR(
Num SERIAL NOT NULL,
Nom VARCHAR NOT NULL,
Prenom VARCHAR NOT NULL,
Adresse VARCHAR NULL,
Mail VARCHAR NULL,
Tel NUMERIC NULL,
Date_naissance Date NULL,
Num_promotion INTEGER,
Login VARCHAR NULL,
PRIMARY KEY (Num));

CREATE TABLE PROMOTION(
Num SERIAL NOT NULL,
Intitule VARCHAR NOT NULL,
Annee INTEGER NOT NULL,
PRIMARY KEY (Num));


-- SERVICE PROJET
CREATE TABLE PROJET(
Num SERIAL NOT NULL,
Intitule VARCHAR NOT NULL,
Description VARCHAR,
Num_statut INTEGER,
Num_util INTEGER,
PRIMARY KEY (Num));

CREATE TABLE PROJET_UTIL(
Num SERIAL NOT NULL,
Num_util INTEGER NOT NULL,
Num_projet INTEGER NOT NULL,
UNIQUE (Num_util, Num_projet),
PRIMARY KEY (Num));

CREATE TABLE STATUT (
Num SERIAL NOT NULL,
Valeur VARCHAR NULL,
PRIMARY KEY (Num));

CREATE TABLE INVITATION(
Num SERIAL NOT NULL,
Num_projet INTEGER NOT NULL,
Num_util INTEGER NOT NULL,
Message VARCHAR,
Reponse BOOLEAN,
Date DATE NULL,
PRIMARY KEY (Num));


-- SERVICE COMPETENCE
CREATE TABLE COMPETENCE(
Num SERIAL NOT NULL,
Nom VARCHAR NOT NULL,
Competence_domaine INTEGER,
PRIMARY KEY (Num));

CREATE TABLE COMPETENCE_UTIL(
Num SERIAL NOT NULL,
Num_util INTEGER NOT NULL,
Num_competence INTEGER NOT NULL,
Num_niveau INTEGER NOT NULL,
UNIQUE (Num_util, Num_competence, Num_niveau),
PRIMARY KEY (Num));

CREATE TABLE NIVEAU(
Num SERIAL NOT NULL,
Num_valeur INTEGER NOT NULL,
Valeur VARCHAR NULL,
PRIMARY KEY (Num));


-- SERVICE PROFIL
CREATE TABLE PROFIL(
Num SERIAL NOT NULL,
Nom VARCHAR NOT NULL,
profil_domaine INTEGER,
PRIMARY KEY (Num));

CREATE TABLE PROFIL_UTIL(
Num SERIAL NOT NULL,
Num_util INTEGER NOT NULL,
Num_profil INTEGER NOT NULL,
UNIQUE (Num_util, Num_profil),
PRIMARY KEY (Num));

CREATE TABLE FONCTION(
Num SERIAL NOT NULL,
Nom VARCHAR NOT NULL,
PRIMARY KEY (Num));

CREATE TABLE NATURE_DU_DROIT(
Num SERIAL NOT NULL,
Nom VARCHAR NOT NULL,
PRIMARY KEY (Num));

CREATE TABLE DROIT_PROFIL(
Num SERIAL NOT NULL,
Num_profil INTEGER NOT NULL,
Num_fonction INTEGER NOT NULL,
Num_nature INTEGER NOT NULL,
UNIQUE (Num_profil, Num_fonction, Num_nature),
PRIMARY KEY (Num));



--MISE A JOUR DES TABLES AVEC LES CLES ETRANGERES

ALTER TABLE UTILISATEUR
ADD FOREIGN KEY (Num_promotion) REFERENCES PROMOTION;

ALTER TABLE PROJET
ADD FOREIGN KEY (Num_statut) REFERENCES STATUT,
ADD FOREIGN KEY (Num_util) REFERENCES UTILISATEUR;

ALTER TABLE PROJET_UTIL
ADD FOREIGN KEY (Num_util) REFERENCES UTILISATEUR,
ADD FOREIGN KEY (Num_projet) REFERENCES PROJET;

ALTER TABLE INVITATION
ADD FOREIGN KEY (Num_projet) REFERENCES PROJET,
ADD FOREIGN KEY (Num_util) REFERENCES UTILISATEUR;

ALTER TABLE COMPETENCE
ADD FOREIGN KEY (Competence_domaine) REFERENCES COMPETENCE;

ALTER TABLE COMPETENCE_UTIL
ADD FOREIGN KEY (Num_util) REFERENCES UTILISATEUR,
ADD FOREIGN KEY (Num_competence) REFERENCES COMPETENCE,
ADD FOREIGN KEY (Num_niveau) REFERENCES NIVEAU;

ALTER TABLE PROFIL
ADD FOREIGN KEY (profil_domaine) REFERENCES PROFIL;

ALTER TABLE PROFIL_UTIL
ADD FOREIGN KEY (Num_util) REFERENCES UTILISATEUR,
ADD FOREIGN KEY (Num_profil) REFERENCES PROFIL;

ALTER TABLE DROIT_PROFIL
ADD FOREIGN KEY (Num_profil) REFERENCES PROFIL,
ADD FOREIGN KEY (Num_fonction) REFERENCES FONCTION,
ADD FOREIGN KEY (Num_nature) REFERENCES NATURE_DU_DROIT;



--CREATION DU JEU DE TEST

insert into promotion (intitule, annee) values
('dl',2013),
('dl',2013),
('rzo',2013),
('cdi',2013),
('cdi',2012),
('rzo',2012),
('dl',2012);

insert into statut (valeur) values
('ouvert'),
('complet'),
('en_cours'),
('fermé');

insert into niveau (num_valeur, valeur) values
(1 ,'débutant'),
(2 ,'intermédiaire'),
(2 ,'avancé'),
(3 ,'expert');

insert into utilisateur (nom, prenom, adresse, date_naissance, num_promotion, login) values
('BEYNEL', 'julien', '17 rue des lilas', '1986-10-01', 1, 'beynelj'),
('KOBRYNETS', 'elena', '2 impasse des pommes', '1982-10-01', 2, 'kobrynetse'),
('BEKKOUR', 'julien', '5 avenue des tulipes', '1983-09-09', 3, 'bekkourj'),
('DEVIE', 'perrine', '8 allée des champs', '1983-10-01', 4, 'deviep'),
('HERISSON', 'naen', '12 allée des roses', '1986-10-01', 5, 'herissonn'),
('BATMAN', 'bruce', 'manoir wayne, gotham city', '1970-10-01', 2, 'batmanb'),
('SKYWALKER', 'luke', 'adresse inconnue', '8560-10-01', 4, 'skywalkerl');

insert into projet (intitule, description, num_statut, num_util) values
('Gestion competences', 'projet école', 1, 5),
('Java entreprise', 'projet entreprise', 2, 4),
('Developpement reseau', 'mise en place serveur', 3, 3),
('Gestion des cours', 'plannification', 1, 2),
('Gestion des classes', '', 2, 1),
('Livraison fourniture', 'commandes', 3, 4),
('Gestion emploi du temps', 'on part quand en vacances', 1, 5),
('Relation entreprise', 'trouver des stages', 2, 2),
('ProjetToto', 'pour créer des histoires drôles de Toto', 1, 2);

insert into projet_util (num_util, num_projet) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(1,2),
(2,3),
(3,4),
(4,5),
(2,5),
(3,1);

insert into invitation(num_projet, num_util, message, reponse) values
(1, 1, 'Souhaitez-vous participer au projet n°1', false),
(1, 2, 'Souhaitez-vous participer au projet n°1', false),
(2, 3, 'Merci de confirmer votre participation au projet n°2', false),
(2, 4, 'Merci de confirmer votre participation au projet n°2', false);

insert into competence (nom) values 
('langage'),
('sgbd'),
('office'),
('edi'),
('alm'),
('dev. web');

insert into competence (nom, competence_domaine) values 
('c++',1),
('java',1),
('word',3),
('mysql',2),
('php',6),
('uml',5),
('eclipse',4),
('J2EE',8),
('JSP',14),
('JDBC',14);

insert into competence_util (num_util, num_competence, num_niveau) values
(1,1,1),
(2,2,2),
(3,3,3),
(4,4,4),
(5,5,2),
(1,2,3),
(2,3,4),
(3,4,4),
(2,4,2),
(3,5,3),
(1,2,1),
(5,5,1),
(4,4,1),
(4,5,2),
(3,3,1),
(3,1,2),
(2,1,4);

insert into fonction (nom) values
('afficher_projets'),
('afficher_utilisateurs'),
('ajouter_competences'),
('ajouter_utilisateur');

insert into nature_du_droit (nom) values
('ecriture'),
('execution'),
('lecture'),
('suppression');

insert into profil (nom) values
('user');

insert into profil (nom, profil_domaine) values
('volontaire',1),
('administrateur',1),
('super_admin',1),
('chef_de_projet',1);

insert into droit_profil (num_profil, num_fonction, num_nature) values
(1,1,1),
(2,2,2),
(3,3,3),
(4,4,4),
(1,2,3),
(2,3,1),
(3,2,1),
(2,2,1),
(2,2,3),
(3,3,1),
(3,3,2);

insert into profil_util (num_util, num_profil) values
(1,1),
(2,2),
(3,3),
(4,4),
(1,2),
(1,3),
(2,3),
(4,1);


