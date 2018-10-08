.data
input: .asciiz "Entrez un entier n : "
pair: .asciiz "Entier pair"
impair: .asciiz "Entier impair"

.text
main:	li, $v0, 4 #Affiche input
	la, $a0, input
	syscall
	
	li $v0, 5 #Récupère l'entier dans s0
	syscall
	move $s0, $v0
	
	li $t0, 2 #Division par 2
	div $s0, $t0
	
	mfhi $t1 #Récupère le reste et teste si = 0	
	beqz $t1, npair
	
	li, $v0, 4 #Entier impair
	la, $a0, impair
	syscall
	
	j exit
	
npair:	li, $v0, 4 #Entier pair
	la, $a0, pair
	syscall

exit: 	li $v0, 10
	syscall

end:	jr $ra
