/* 
TUPLES POUR LES DIFFERENTES RELATIONS.
Attention, les valeurs sont rentrées en majuscules et il n'y a pas d'accents
*/

/*
Pour mettre les dates au format date avec numéro JJ-MM-AAAA
*/
ALTER session SET NLS_DATE_FORMAT='DD-MM-YYYY';


prompt -----------------------------------------------;
prompt -----  Suppression des anciens tuples  --------;
prompt -----------------------------------------------;

DELETE FROM CARACTERISE;
DELETE FROM EMPRUNT;
DELETE FROM EXEMPLAIRE;
DELETE FROM ABONNE;
DELETE FROM ECRIT;
DELETE FROM LIVRE;
DELETE FROM MOT_CLE;
DELETE FROM AUTEUR;


prompt -------------------------------------------------;
prompt -------  Insertion des nouveaux tuples  ---------;
prompt -------------------------------------------------;

prompt ----------------------------------------------;
prompt --------    Insertion mot-clés    ------------;
prompt ----------------------------------------------;

INSERT INTO MOT_CLE VALUES('ROOT',NULL);
INSERT INTO MOT_CLE VALUES('MEDECINE','ROOT');
INSERT INTO MOT_CLE VALUES('LITTERATURE','ROOT');
INSERT INTO MOT_CLE VALUES('ROMAN','LITTERATURE');
INSERT INTO MOT_CLE VALUES('NOUVELLE','LITTERATURE');
INSERT INTO MOT_CLE VALUES('POEME','LITTERATURE');
INSERT INTO MOT_CLE VALUES('SCIENCES','ROOT');
INSERT INTO MOT_CLE VALUES('HISTOIRE','ROOT');
INSERT INTO MOT_CLE VALUES('INFORMATIQUE','SCIENCES');
INSERT INTO MOT_CLE VALUES('PROGRAMMATION','INFORMATIQUE');
INSERT INTO MOT_CLE VALUES('BASE_DE_DONNEES','PROGRAMMATION');
INSERT INTO MOT_CLE VALUES('MODELE_RELATIONNEL','BASE_DE_DONNEES');
INSERT INTO MOT_CLE VALUES('MODELE_ORIENTE_OBJET','BASE_DE_DONNEES');


prompt -----------------------------------------------;
prompt ----------    Insertion auteurs    ------------;
prompt -----------------------------------------------;

INSERT INTO AUTEUR VALUES(101,'DUMAS','ALEXANDRE','FRANCAISE');
INSERT INTO AUTEUR VALUES(102,'SARTRE','JEAN-PAUL','FRANCAISE');
INSERT INTO AUTEUR VALUES(103,'GENEY','JEAN','FRANCAISE');
INSERT INTO AUTEUR VALUES(104,'VALLES','JULES','FRANCAISE');
INSERT INTO AUTEUR VALUES(105,'VILLON','FRANCOIS','FRANCAISE');
INSERT INTO AUTEUR VALUES(106,'ECO','UMBERTO','ITALIENNE');
INSERT INTO AUTEUR VALUES(107,'GARY','ROMAIN','FRANCAISE');
INSERT INTO AUTEUR VALUES(108,'ROCHEFORT','CHRISTIANE','FRANCAISE');
INSERT INTO AUTEUR VALUES(109,'STEINBECK','JOHN','AMERICAIN');
INSERT INTO AUTEUR VALUES(110,'HOFSTADTER','DOUGLAS','ALLEMAND');
INSERT INTO AUTEUR VALUES(111,'BOUZEGHOUB','MOKRANE','TUNISIENNE');
INSERT INTO AUTEUR VALUES(112,'GARDARIN','GEORGES','FRANCAISE');
INSERT INTO AUTEUR VALUES(113,'VALDURIEZ','PATRICK','FRANCAISE');
INSERT INTO AUTEUR VALUES(114,'ULLMAN','JEFFREY','AMERICAINE');
INSERT INTO AUTEUR VALUES(115,'DELOBEL','CLAUDE','FRANCAISE');
INSERT INTO AUTEUR VALUES(116,'DATE','JC','AMERICAINE');
INSERT INTO AUTEUR VALUES(117,'GELENBE','EROL','INDIENNE');
INSERT INTO AUTEUR VALUES(118,'FLORY','ANDRE','FRANCAISE');


prompt ------------------------------------------------;
prompt ----------     Insertion livres     ------------;
prompt ------------------------------------------------;

INSERT INTO LIVRE VALUES('1_104_1050_2','LE MUR',20,'NOUVELLE'); 
INSERT INTO LIVRE VALUES('0_15_270500_3','LE MIRACLE DE LA ROSE',20,'ROMAN');
INSERT INTO LIVRE VALUES('0_85_4107_3','L ENFANT',19,'ROMAN'); 
INSERT INTO LIVRE VALUES('0_112_3785_5','POESIES COMPLETES', 15,'POEME');
INSERT INTO LIVRE VALUES('0_201_14439_5','AN INTRODUCTION TO DATABASE SYSTEMS',20,'SCIENCES'); 
INSERT INTO LIVRE VALUES('0_12_27550_2','NEW APPLICATIONS OF DATABASES',20,'SCIENCES');
INSERT INTO LIVRE VALUES('0_8_7707_2','BASES DE DONNEES RELATIONNELLES',20,'SCIENCES');
INSERT INTO LIVRE VALUES('1_22_1721_3','LE NOM DE LA ROSE',20,'ROMAN');
INSERT INTO LIVRE VALUES('3_505_13700_5','LE GRAND VESTIAIRE',20,'ROMAN');
INSERT INTO LIVRE VALUES('0_18_47892_2','UNE ROSE POUR MORRISSON',20,'ROMAN');
INSERT INTO LIVRE VALUES('9_782070_36','LA PERLE',20,'ROMAN'); 
INSERT INTO LIVRE VALUES('2_7296_0040','GODEL ESCHER BACH : LES BRINS D UNE GUIRLANDE',20,'HISTOIRE'); 
INSERT INTO LIVRE VALUES('0_26_28079_6','OBJET, DE MERISE A C++',20,'SCIENCES'); 


prompt ----------------------------------------------;
prompt -----------    Insertion écrit    ------------;
prompt ----------------------------------------------;

INSERT INTO ECRIT VALUES(102,'1_104_1050_2');
INSERT INTO ECRIT VALUES(103,'0_15_270500_3');
INSERT INTO ECRIT VALUES(104,'0_85_4107_3');
INSERT INTO ECRIT VALUES(105,'0_112_3785_5');
INSERT INTO ECRIT VALUES(116,'0_201_14439_5');
INSERT INTO ECRIT VALUES(112,'0_12_27550_2');
INSERT INTO ECRIT VALUES(117,'0_12_27550_2');
INSERT INTO ECRIT VALUES(111,'0_8_7707_2');
INSERT INTO ECRIT VALUES(118,'0_8_7707_2');
INSERT INTO ECRIT VALUES(106,'1_22_1721_3');
INSERT INTO ECRIT VALUES(107,'3_505_13700_5');
INSERT INTO ECRIT VALUES(108,'0_18_47892_2');
INSERT INTO ECRIT VALUES(109,'9_782070_36');
INSERT INTO ECRIT VALUES(110,'2_7296_0040');
INSERT INTO ECRIT VALUES(111,'0_26_28079_6');
INSERT INTO ECRIT VALUES(112,'0_26_28079_6');
INSERT INTO ECRIT VALUES(113,'0_26_28079_6');


prompt ------------------------------------------------;
prompt -----------    Insertion abonnés    ------------;
prompt ------------------------------------------------;

INSERT INTO ABONNE VALUES(000001,'DURAND','BRUNO','MONTPELLIER','21-04-1977','A PROBLEME',NULL,NULL,NULL);
INSERT INTO ABONNE VALUES(000002,'LETOILE','PATRICK','MONTPELLIER','01-01-2000','A PROBLEME',NULL,NULL,NULL);
