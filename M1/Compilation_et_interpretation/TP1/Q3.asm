.data
input: .asciiz "Entrez un entier n : "
incr: .asciiz "Entiers de 1 à n : \n"
line: .asciiz "\n"

.text
main:	li $v0, 4 #Affiche input
	la $a0, input
	syscall
	
	li $v0, 5 #Récupère un entier dans s0
	syscall
	move $s0, $v0
	
	li $v0, 4 #Affiche incr
	la $a0, incr
	syscall
	
	li $s1, 1 #Entier à afficher jusqu'à n (s0)
	
print:	li $v0, 1 #Affiche s1
	move $a0, $s1
	syscall
	
	li $v0, 4 #Retour à la ligne
	la $a0, line
	syscall
	
	addi $s1, $s1, 1 #Incrémente s1 de 1

	ble $s1, $s0, print #Teste si s1 <= s0

exit: 	li $v0, 10
	syscall

end:	jr $ra