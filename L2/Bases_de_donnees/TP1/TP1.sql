CREATE TABLE acteur
(
idA NUMERIC(5) PRIMARY KEY,
nom CHARACTER(40),
prenom CHARACTER(40),
nationalite CHARACTER(40)
);

insert into acteur values(1,'durand','bruno','francais');
insert into acteur values(2,'pacino','al','italien');


create table genre
(
idG numeric(5) primary key,
description character(40)
);

insert into genre values(1,'comedie');
insert into genre values(2,'policier');
insert into genre values(3,'comedie musicale');

create table realisateur
(
idR numeric(5) primary key,
nom character(40),
prenom character(40),
nationalite character (40)
);

insert into realisateur values (1,'daroussin','truc','francais');
insert into realisateur values(2,'lafitte','gregory','francais');

create table film
(
idF numeric(5) primary key,
titre character(40),
annee numeric(4),
pays character(40),
nbspectateurs numeric check(nbspectateurs>0),
idRealisateur numeric(5) references realisateur(idR),
idGenre numeric(5) references genre(idG)
);

insert into film values(1,'UnTitreComique',2002,'France',20000,1,1);
insert into film values(2,'AutreFilmComique',1999,'France',11000,1,1);
insert into film values(3,'Comedie_Musicale',2012,'France',5000,2,3);
insert into film values(4,'Film_Policier',1980,'France',11,2,2);

create table jouer
(
idActeur numeric(5) references acteur(idA),
idFilm numeric(5) references film(idF),
primary key (idActeur, idFilm),
salaire numeric check(salaire>0)
);

insert into jouer values(2,4,20);
insert into jouer values(2,1,30);
insert into jouer values(1,3,12);

