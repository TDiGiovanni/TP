.data


.text
main:	li $s0, 2
	li $s1, 3
	
	move $t1, $s0
	move $s0, $s1
	move $s1, $t1

exit: 	li $v0, 10
	syscall

end:	jr $ra