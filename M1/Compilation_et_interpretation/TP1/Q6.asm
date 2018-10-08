.data
input: .asciiz "Entrez deux entiers a et b: "
sqr: .asciiz "sqr(a) + sqr(b) = "

.text
main:	li $v0, 4 #Affiche input
	la $a0, input
	syscall
	
	li $v0, 5 #1er entier
	syscall
	move $s0, $v0
	
	li $v0, 5 #2nd entier
	syscall
	move $s1, $v0

	mul $t0, $s0, $s0
	mul $t1, $s1, $s1
	add $s2, $t0, $t1
	
	li $v0, 4 #Affiche sqr
	la $a0, sqr
	syscall

	li $v0, 1 #Affiche le résultat
	move $a0, $s2
	syscall

exit: 	li $v0, 10
	syscall
		
end:	jr $ra