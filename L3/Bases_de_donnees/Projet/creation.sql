/*
Fichier creation.sql
20140438 Legrand Marie
21505926 Di Giovanni Thomas
*/


CREATE TABLE UTILISATEUR (
       EMAIL VARCHAR(30) NOT NULL,
       NOM VARCHAR(20) NOT NULL,
       PRENOM VARCHAR(20) NOT NULL,
       NAISSANCE DATE NOT NULL,
       ADRESSE VARCHAR(100) NOT NULL,
       TELEPHONE NUMERIC(10,0) NOT NULL,
       STATUT VARCHAR(10) DEFAULT 'MEMBRE',
       NOTE NUMERIC(2,1),
       
       CONSTRAINT PK_UTILISATEUR PRIMARY KEY(EMAIL),
       CONSTRAINT DOM_STATUT CHECK IN ('ADMIN','MEMBRE')
);

CREATE TABLE VEHICULE (
       ID NUMERIC(4,0),
       MARQUE VARCHAR(20),
       MODELE VARCHAR(20),
       NB_PLACES NUMERIC(1,0),
       COULEUR VARCHAR(15),
       ANNEE DATE,
       PROPRIETAIRE VARCHAR(30),

       CONSTRAINT PK_VEHICULE PRIMARY KEY(ID),
       CONSTRAINT FK_VEHICULE FOREIGN KEY(PROPRIETAIRE) REFERENCES UTILISATEUR(EMAIL)
);

CREATE TABLE TRAJET (
       ID NUMERIC(4,0),
       DEPART VARCHAR(30),
       ARRIVEE VARCHAR(30),
       DISTANCE NUMERIC(6,2),
       TEMPS TIME,
       ID_VEHICULE NUMERIC(4,0),
       CONDUCTEUR VARCHAR(30),
       PRIX NUMERIC(2,0),

       CONSTRAINT PK_TRAJET PRIMARY KEY(ID),
       CONSTRAINT FK_TRAJET_VEHICULE FOREIGN KEY(ID_VEHICULE) REFERENCES VEHICULE(ID),
       CONSTRAINT FK_TRAJET_CONDUCTEUR FOREIGN KEY(CONDUCTEUR) REFERENCES UTILISATEUR(EMAIL)
);

CREATE TABLE AVIS (
       ID_TRAJET NUMERIC(4,0),
       USER_NOTANT VARCHAR(30),
       USER_NOTE VARCHAR(30),
       NOTE NUMERIC(2,1) NOT NULL,
       COMMENTAIRE VARCHAR(50),

       CONSTRAINT PK_AVIS PRIMARY KEY(ID_TRAJET,USER_NOTANT,USER_NOTE),
       CONSTRAINT FK_AVIS_TRAJET FOREIGN KEY(ID_TRAJET) REFERENCES TRAJET(ID),
       CONSTRAINT FK_AVIS_USER_NOTANT FOREIGN KEY(USER_NOTANT) REFERENCES UTILISATEUR(EMAIL),
       CONSTRAINT FK_AVIS_USER_NOTE FOREIGN KEY(USER_NOTE) REFERENCES UTILISATEUR(EMAIL),
       CONSTRAINT DOM_NOTE CHECK (NOTE<=5 AND NOTE >0)
);

CREATE TABLE ACHETE (
       ID_TRAJET NUMERIC(4,0),
       PASSAGER VARCHAR(30),

       CONSTRAINT PK_ACHETE PRIMARY KEY(ID_TRAJET,PASSAGER),
       CONSTRAINT FK_ID_TRAJET FOREIGN KEY(ID_TRAJET) REFERENCES TRAJET(ID),
       CONSTRAINT FK_ID_PASSAGER FOREIGN KEY(PASSAGER) REFERENCES UTILISATEUR(EMAIL)
);
