select titre from film group by idF, titre having (sum(nbspectateurs)>(select avg(nbspectateurs) from film ));

select nom, prenom from realisateur, film where (idR=idRealisateur) group by idR, nom, prenom having (max(nbspectateurs)> (select avg(nbspectateurs) from film));

select nom, prenom from acteur, film, jouer where (idA=idActeur) and (idF=idFilm) group by idA, nom, prenom having (idF= (select idF from film where (nbSpectateurs>
