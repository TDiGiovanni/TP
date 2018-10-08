; Di Giovanni Thomas GR. A

; Questions générales:
; Exercice 9:
(define genliste (lambda (d f p)
                   (let ((acc d) (liste (cons d '())))
                     (if (<= (+ acc p) f)
                         (append liste (genliste (+ acc p) f p))
                         liste))))

; Exercice 10:
