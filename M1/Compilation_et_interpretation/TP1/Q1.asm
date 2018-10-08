.data
input: .asciiz "Entrez un entier n : "
abs: .asciiz "Valeur absolue de n : "

.text
main:	li $v0, 4 #Affiche input
	la $a0, input
	syscall

	li $v0, 5 #Récupère un entier
	syscall
	
	li $v0, 4 #Affiche abs
	la $a0, abs
	syscall
	
	bltz $v0, neg #Vérifie s'il est négatif (si oui go sur neg)
	
	move $s0, $v0 #Move l'entier dans s0
	la $a0, ($s0) #Adresse de s0 dans a0
	
	li $v0, 1 #Affiche a0
	syscall
	
	j exit
	
neg:	neg $t0, $v0 #Fait la négation de v0 dans t0

	la $a0, ($t0) #Adresse de t0 dans a0

	li $v0, 1 #Affiche a0
	syscall
	
	j exit

exit: 	li $v0, 10
	syscall

end:	jr $ra