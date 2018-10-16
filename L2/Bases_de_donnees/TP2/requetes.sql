select nom, sum(quantite) from operateur, piece where (numero=numero_op) group by numero, nom;

select nom from operateur, piece where (numero=numero_op) group by numero, nom having (sum(quantite)>500);

select designationM, count(numero_op) from machine, qualifie_sur where (referenceM=reference_m) group by referenceM, designationM;

select designationM, count(referenceP) from machine, piece where (referenceM=reference_m) group by referenceM, designationM;

select nom, count(reference_m) from operateur, qualifie_sur where (numero=numero_op) group by numero, nom;

select designationM, sum(quantite) from machine, piece where (referenceM= reference_m) group by referenceM, designationM;
