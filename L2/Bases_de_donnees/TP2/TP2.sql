alter session set nls_date_format= 'dd/mm/yy';

drop table operateur cascade;
create table operateur
(
numero character(5) primary key,
nom character(40),
age numeric(2)
);

insert into operateur values('OP42','Robert',32);
insert into operateur values('OP10','Sophie',41);
insert into operateur values('OP78','Lucette',25);
insert into operateur values('OP22','Robert',25);
insert into operateur values('OP57','Marc',38);

drop table machine cascade;
create table machine
(
referenceM character(5) primary key,
designationM character(40)
);

insert into machine values('M12','Perceuse');
insert into machine values('M13','Ponceuse');
insert into machine values('M14','Tour numerique');

drop table piece cascade;
create table piece
(
referenceP character(5) primary key,
desigantionP character(40),
reference_m character(5) references machine(referenceM),
numero_op character(5) references operateur(numero),
quantite numeric(5)
);

insert into piece values('P1','Piece1','M12','OP10',250);
insert into piece values('P2','Piece2','M12','OP22',600);
insert into piece values('P3','Piece3','M14','OP22',200);
insert into piece values('P4','Piece4','M13','OP78',150);

drop table qualifie_sur cascade;
create table qualifie_sur
(
numero_op character(5) references operateur(numero),
reference_m character(5) references machine(referenceM),
primary key (numero_op reference_m),
jour date
);

insert into qualifie_sur values('OP10','M12','15/01/00');
insert into qualifie_sur values('OP22','M12','20/05/01');
insert into qualifie_sur values('OP10','M13','10/10/99');
insert into qualifie_sur values('OP42','M13','17/01/02');
insert into qualifie_sur values('OP78','M12','19/07/98');
insert into qualifie_sur values('OP10','M14','04/05/01');
