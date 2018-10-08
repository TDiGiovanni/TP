.data
array: .word 1, 2, 3

.text
main:	la $s0, array #Récupère le tableau dans s0
	
	lw $t0, ($s0) #Récupère les 3 valeurs de array dans t0 t1 t2
	lw $t1, 4($s0)
	lw $t2, 8($s0)
	
	sw $t0, 4($s0) #Permute les valeurs de array avec les valeurs stockées dans t0 t1 t2
	sw $t1, 8($s0)
	sw $t2, ($s0)
	
	j exit
	
		
end:	jr $ra


exit: 	li $v0, 10
	syscall
