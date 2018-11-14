(defun fact (n)
    (if (<= n 0)
        1
        (* n (fact (- n 1)))
    )
)

(defun member (x l)
    (if (eql (car l) x)
            l
            (member x (cdr l))
    )
)

(defun calcul (expr)
    (if (atom expr)

        expr

        (eval (list
            (cadr expr)
            (calcul (car expr))
            (calcul (cddr expr))
            ))

    )
)

(defun backquotify (expr)

)