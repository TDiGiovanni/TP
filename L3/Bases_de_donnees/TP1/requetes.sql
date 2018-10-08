/*
Q1
select nom, prenom
from abonne
where ville = 'MONTPELLIER';

Q2
select *
from exemplaire
where code_pret = 'EMPRUNTABLE';

Q3
select titre, categorie
from livre
where categorie not in('MEDECINE','SCIENCES','LOISIR')
order by categorie;

Q4
select *
from emprunt
where d_ret_reel is null;

Q5
select emprunt.num_ex, emprunt.d_emprunt
from emprunt, abonne
where abonne.num_ab=emprunt.num_ab
and abonne.prenom='JEAN'
and abonne.nom='DUPONT'
order by d_emprunt;

Q6
select numero, code_pret, etat
from emprunt, exemplaire, livre
where livre.isbn=exemplaire.isbn
and exemplaire.numero=emprunt.num_ex
and livre.titre='LE MUR';

Q7
select numero
from exemplaire
where isbn= (select isbn
      	    from exemplaire
	    where numero=4112)
and etat='BON'
and numero <>4112;

Q8
select categorie
from livre
where isbn
group by categorie
having categorie not in(select categorie
       		     	from livre, exemplaire, emprunt
			where livre.isbn=exemplaire.isbn
			and exemplaire.numero=emprunt.num_ex
			group by categorie);


Q9
select count(*) as Nb_emp
from abonne, emprunt
where abonne.num_ab=emprunt.num_ab
and nom='RENARD'
and prenom='ALBERT';

Q10
select min(tarif)
from abonne;

Q11
select distinct numero
from exemplaire, emprunt
where emprunt.num_ex=exemplaire.numero
and etat='ABIME';

Q12
select mot
from mot_clef
where mot not in(select distinct categorie
      	      		from livre);

Q13
select livre.categorie, abonne.num_ab, abonne.nom, count(*) as nb_emprunts
from abonne, emprunt, exemplaire, livre
where abonne.num_ab=emprunt.num_ab
and emprunt.num_ex=exemplaire.numero
and exemplaire.isbn=livre.isbn
group by livre.categorie, abonne.num_ab, abonne.nom
order by livre.categorie, abonne.num_ab;

Q14
select isbn, avg(prix) as prix_moyen
from exemplaire
group by isbn
having count(*)>2;

Q15
select isbn, titre
from livre
where isbn != '0_8_7707_2'
and categorie = (select categorie
      		  from livre
		  where isbn='0_8_7707_2');

Q16 */
select livre.categorie
from livre, exemplaire, emprunt
where emprunt.num_ex=exemplaire.numero
and livre.isbn=exemplaire.isbn
group by categorie
having emprunt.num_ab = (select num_ab
       		      	from abonne);
