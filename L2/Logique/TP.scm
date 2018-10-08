#lang racket

; 4 FBFs
(define F1 '(<-> (^ a b) (v (! a) b)))
(define F2 '(v (! (^ a (! b))) (! (-> a b))))
(define F3 '(^ (! (-> a (v a b))) (! (! (^ a (v b (! c)))))))
(define F4 '(^ (v (! a) (v b d)) (^ (v (! d) c) (^ (v c a) (^ (v (! c) b) (^ (v (! c) (! b)) (v (! b) d)))))))
(define F5 '(-> q (v p (! p))))
(define F6 '(! (^ r (! r))))

; Fonction vérifiant si f est une négation
(define neg? (lambda (f)
               (eq? f '!)))

; Fonction vérifiant si f est un connecteur et
(define and? (lambda (f)
               (eq? f '^)))

; Fonction vérifiant si f est un connecteur ou
(define or? (lambda (f)
               (eq? f 'v)))

; Fonction vérifiant si f est un connecteur implique
(define imp? (lambda (f)
               (eq? f '->)))

; Fonction vérifiant si f est un connecteur équivalent
(define equ? (lambda (f)
               (eq? f '<->)))

; Fonction vérifiant si f est toujours vrai
(define top? (lambda (f)
               (eq? f 'T)))

; Fonction vérifiant si f est toujours faux
(define bot? (lambda (f)
               (eq? f 'B)))

(define symbLog? (lambda (f)
                   (or (equ? f) (imp? f) (or? f) (and? f) (neg? f))))
(define symbProp? (lambda (f)
                    (and (symbol? f) (not (symbLog? f)))))
(define atomicFbf? (lambda (f)
                     (or (symbProp? f) (top? f) (bot? f))))
(define conBin? (lambda (f)
                  (or (and? f) (or? f) (imp? f) (equ? f))))

; Vérifie si c'est une FBF
(define fbf? (lambda (f)
               (cond ((symbol? f) (if (atomicFbf? f) #t #f))
                     ((and (list? f) (not (null? f))) (cond ((and (neg? (car f)) (= (length f) 2)) (fbf? (cadr f)))
                                                            ((and (conBin? (car f)) (= (length f) 3)) (and (fbf? (cadr f)) (fbf? (caddr f))))
                                                            (#t #f)))
                     (#t #f))))

; Renvoie le connecteur racine
(define conRac (lambda (f)
                 (car f)))

; Renvoie le fils d'une FBF avec un connecteur unaire
(define fils (lambda (f)
                 (cadr f)))

; Renvoie le fils gauche d'une FBF avec un connecteur binaire
(define filsG (lambda (f)
                 (cadr f)))

; Renvoie le fils droit d'une FBF avec un connecteur binaire
(define filsD (lambda (f)
                 (caddr f)))

; Teste si une FBF a une négation comme racine
(define negFbf? (lambda (f)
                 (and (not (atomicFbf? f))
                      (neg? (conRac f)))))

; Retourne le nombre de connecteurs
(define nbc (lambda (f)
              (if (not (atomicFbf? f))
                  (if (negFbf? f)
                      (+ (nbc (fils f)) 1)
                      (+ (nbc (filsG f)) (nbc (filsD f)) 1))
                  0)))

; Retourne la profondeur de f
(define prof (lambda (f)
               (if (not (atomicFbf? f))
                  (if (negFbf? f)
                      (+ (prof (fils f)) 1)
                      (+ (max (prof (filsG f)) (prof (filsD f))) 1))
                  0)))

; Retourne l'ensemble des symboles propositionnels
(define ensSP (lambda (f)
                (cond ((symbProp? f) (cons f '() ))
                      ((or (top? f) (bot? f)) (cons '() ))
                      ((negFbf? f) (ensSP (fils f)))
                      (else (set-union (ensSP (filsG f))
                                       (ensSP (filsD f)))))))

; 3 interprétations
(define I1 (list (cons 'a 1) (cons 'b 0) (cons 'c 1)))
(define I2 (list (cons 'a 0) (cons 'b 0) (cons 'c 0)))
(define I3 (list (cons 'a 1) (cons 'b 1) (cons 'c 1)))

; Retourne la valeur d'interprétation de s dans I
(define intSymb (lambda (I s)
                  (if (equal? (caar I) s)
                      (cdar I)
                      (intSymb (cdr I) s))))

;
(define intNeg (lambda (a)
                 (if (= 0 a)
                     1
                     0)))

(define intAnd (lambda (a b)
                 (if (= 1 a b)
                     1
                     0)))

(define intOr (lambda (a b)
                 (if (or (= 1 a) (= 1 b))
                     1
                     0)))

(define intImp (lambda (a b)
                 (if (and (= 1 a) (= 0 b))
                     0
                     1)))

(define intEqu (lambda (a b)
                 (if (= a b)
                     1
                     0)))

(define intTop (lambda ()
                 1))

(define intBot (lambda ()
                 0))

; Calcule la valeur de vérité de f pour I
(define valV (lambda (I f)
               (cond ((symbProp? f) (intSymb I f))
                     ((bot? f) (intBot))
                     ((top? f) (intTop))
                     ((negFbf? f) (intNeg (valV I (fils f))))
                     ((or? (conRac f)) (intOr (valV I (filsG f)) (valV I (filsD f))))
                     ((and? (conRac f)) (intAnd (valV I (filsG f)) (valV I (filsD f))))
                     ((imp? (conRac f)) (intImp (valV I (filsG f)) (valV I (filsD f))))
                     ((equ? (conRac f)) (intEqu (valV I (filsG f)) (valV I (filsD f)))))))


; Vérifie si I est un modèle de f
(define modele? (lambda (I f)
                     (if (= 1 (valV I f))
                         #t
                         #f)))

; Interprétations
(define I4 (list (cons 'p 0) (cons 'q 0)))
(define I5 (list (cons 'p 0) (cons 'q 1)))
(define I6 (list (cons 'p 1) (cons 'q 0)))
(define I7 (list (cons 'p 1) (cons 'q 1)))
(define EI1 (list I4 I5 I6 I7))

; Retourne l'ensemble de toutes les interprétations des symboles propositionnels de ens
(define ensInt (lambda (ens)
                 (if (empty? ens)
                     
                     (list '())
                     
                     (let ((e (car ens))
                           (EI (ensInt (cdr ens))))
                       (append (map (lambda (I) (cons (cons e 0) I)) EI)
                               (map (lambda (I) (cons (cons e 1) I)) EI))))))


(define satisfiable? (lambda (f)
                       (let ((EI (ensInt (ensSP f))))
                         (ormap (lambda (I) (modele? I f)) EI))))

(define valide? (lambda (f)
                       (let ((EI (ensInt (ensSP f))))
                         (andmap (lambda (I) (modele? I f)) EI))))

(define insatisfiable? (lambda (f)
                         (let ((EI (ensInt (ensSP f))))
                         (if (empty? (filter (lambda (I) (modele? I f)) EI))
                             #t
                             #f))))

; Tests
(define test1 '(v (v a b) (! a)))
(define test2 '(! (^ (! c) (^ c d))))

(define equivalent1? (lambda (f1 f2)
                       (let*((eSP (set-union (ensSP f1) (ensSP f2)))
                             (EI (ensInt eSP)))
                         (andmap (lambda (I) (equal? (modele? I f1) (modele? I f2))) EI))))

(define equivalent2? (lambda (f1 f2)
                       (valide? (list '<-> f1 f2))))

(define consequenceL? (lambda (f1 f2)
                        (valide? (list '-> f1 f2))))

;Ensemble de FBFs
(define EF1 (list F1 F2 F3 F4))

(define ensSP_AllFbf (lambda (ens)
                       (if (empty? ens)
                           '()
                           (set-union (ensSP (car ens))
                                      (ensSP_AllFbf (cdr ens))))))

(define modeleCommun? (lambda (I ens)
                        (andmap (lambda (f) (modele? I f)) ens)))

(define contradictoire? (lambda (ens)
                          (let ((EI (ensInt (ensSP_AllFbf ens))))
                            (not (ormap (lambda (I) (modeleCommun? I ens)) EI)))))

(define test3 '((^ a b) (! a) (-> b d)))
(define test4 '(-> c d))

(define consequence? (lambda (ens F)
                       (let* ((EI (ensInt (ensSP_AllFbf (cons F ens))))
                              (M (filter (lambda (I) (modeleCommun? I ens)) EI)))
                              (andmap (lambda (I) modele? I F) M))))

(define conjonction (lambda (ens)
                      (if (empty? (cdr ens))
                          (car ens)
                          (list '^ (car ens) (conjonction (cdr ens))))))

(define consequenceV? (lambda (ens F)
                      (valide? (list '-> (conjonction ens) F))))

(define consequenceI? (lambda (ens F)
                        (insatisfiable? (list '^ (conjonction ens) (list '! F)))))

(define oteEqu (lambda (F)
                 (cond ((or (symbProp? F) (top? F) (bot? F)) F)
                       ((negFbf? F) (list '! (oteEqu (fils F))))
                       ((equ? (conRac F)) (list '^ (list '-> (oteEqu (filsG F)) (oteEqu (filsD F)))
                                                   (list '-> (oteEqu (filsD F)) (oteEqu (filsG F)))))
                       (else (list (conRac F) (oteEqu (filsD F)) (oteEqu (filsG F)))))))

(define oteImp (lambda (F)
                 (cond ((or (symbProp? F) (top? F) (bot? F)) F)
                       ((negFbf? F) (list '! (oteImp (fils F))))
                       ((imp? (conRac F)) (list 'v (list '! (oteImp (filsG F)))
                                                   (oteImp (filsD F))))
                       (else (list (conRac F) (oteImp (filsD F)) (oteImp (filsG F)))))))

(define oteCste (lambda (F)
                  (cond ((symbProp? F) F)
                        ((top? F) (list 'v 'p (list '! 'p)))
                        ((bot? F) (list '^ 'p (list '! 'p)))
                        ((negFbf? F) (list '! (oteCste (fils F))))
                        (else (list (conRac F) (oteCste (filsD F)) (oteCste (filsG F)))))))

(define redNeg (lambda (F)
                 (cond ((or (symbProp? F) (top? F) (bot? F)) F)
                       ((and (negFbf? F) (symbProp? (fils F))) F)
                       ((and (negFbf? F) (negFbf? (fils F))) (redNeg (fils (fils F))))
                       ((and (negFbf? F) (or? (conRac (fils F)))) (list '^ (redNeg (list '! (filsG (fils F)))) (redNeg (list '! (filsD (fils F))))))
                       ((and (negFbf? F) (and? (conRac (fils F)))) (list 'v (redNeg (list '! (filsG (fils F)))) (redNeg (list '! (filsD (fils F))))))
                       (else (list (conRac F) (redNeg (filsG F)) (redNeg (filsD F)))))))

(define distOu (lambda (F)
                 (cond ((or (symbProp? F) (top? F) (bot? F) (negFbf? F)) F)
                       ((and (or? (conRac F)) (or (symbProp? (filsG F)) (negFbf? (filsG F))) (or (symbProp? (filsD F)) (negFbf? (filsD F)))) F)
                       ((and (or? (conRac F)) (or (symbProp? (filsG F)) (negFbf? (filsG F))) (and? (conRac (filsD F)))) (list '^ (distOu (list 'v (filsG F) (filsG (filsD F))))
                                                                                                                         (distOu (list 'v (filsG F) (filsD (filsD F))))))
                       ((and (or? (conRac F)) (or (symbProp? (filsD F)) (negFbf? (filsD F))) (and? (conRac (filsG F)))) (list '^ (distOu (list 'v (filsD F) (filsG (filsG F))))
                                                                                                                         (distOu (list 'v (filsD F) (filsD (filsG F))))))
                       ((and (or? (conRac F)) (not (atomicFbf? (filsG F))) (not (atomicFbf? (filsD F))) (and? (conRac (filsG F))) (and? (conRac (filsD F)))) (list '^ (list '^ (distOu (list 'v (filsG (filsG F)) (filsG (filsD F))))
                                                                                                                                                                               (distOu (list 'v (filsG (filsG F)) (filsD (filsD F)))))
                                                                                                                                                                      (list '^ (distOu (list 'v (filsD (filsG F)) (filsG (filsD F))))
                                                                                                                                                                               (distOu (list 'v (filsD (filsG F)) (filsD (filsD F)))))))
                       (else (list '^ (distOu (filsG F)) (distOu (filsD F)))))))

(define formeConj (lambda (F)
                    (distOu (redNeg (oteCste (oteImp (oteEqu F)))))))

(define test5 '(v (v a b) (v c a)))
(define test6 '(^ (v a b) (v c a)))

(define transClause (lambda (F)
                      (cond ((or (symbProp? F) (negFbf? F)) (list F))
                            ((or? (conRac F)) (set-union (transClause (filsG F)) (transClause (filsD F)))))))

(define transEnsClause (lambda (F)
                         (cond ((or (symbProp? F) (negFbf? F)) (list F))
                               ((or? (conRac F)) (list (transClause F)))
                               ((and? (conRac F)) (set-union (transEnsClause (filsG F)) (transEnsClause (filsD F)))))))
                               
(define formeClausale (lambda (F)
                        (transEnsClause (formeConj F))))


; TP noté
; Question 1
(nbc '(^ a b))
; 1

; Question 2
(define G '(-> (! a) (v (! b) (^ c (<-> a b)))))
; 

; Question 3
(fbf? G)
; #t

; Question 4
(define J1 (list (cons 'a 0) (cons 'b 0) (cons 'c 1)))
(define J2 (list (cons 'a 1) (cons 'b 0) (cons 'c 1)))
;

; Question 5

;

; Question 6
(valV J1 G)
; 1

; Question 7
(valV J1 G)
; 1

; Question 8
(satisfiable? G)
; #t

; Question 9
(satisfiable? '(<-> (^ p q) (-> p (! q))))
; #f

; Question 10
(valide? G)
; #f

; Question 11
(valide? '(-> p (-> q p)))
; #t

; Question 12
(equivalent1? '(v a (^ b (! b))) '(v a (^ c (! c))))
; #t

; Question 13
(equivalent1? 'p '(^ p (v q (! q))))
; #t

; Question 14
(equivalent1? '(^ p q) '(v p q))
; #f

; Question 15
(consequenceV? '((-> a b) (-> b c)) '(-> a c))
; #t

; Question 16
(consequenceV? '(a (v a b) (-> b c)) 'b)
; #f

; Question 17
(consequenceV? '(p (v a b) (! p)) 'q)
; #t

; Question 18
(distOu'(^ (v (^ (^ (v (^ a b) c) a) b) c) (v a b)))
; '(^ (^ (^ (^ c (^ (v c a) (v c b))) (v c a)) (v c b)) (v a b))

; Question 19
(formeConj '(-> (-> p q) p))
; '(^ (v p (! q)) (! p))

; Question 20
(formeClausale '(^ (! (^ q (! r))) (-> p (v q (^ r (! p))))))
; '(((! q) r) ((! q) p) ((! r) p) p)

; Question 21

;

; Modélisation
(define H1 '(v (v (^ (^ H (! A)) (! D)) (^ (^ (! H) A) (! D))) (^ (^ (! H) (! A)) D)))
(define H2 '(v (v (^ (^ V (! C)) (! U)) (^ (^ (! V) C) (! U))) (^ (^ (! V) (! C)) U)))
(define H3 '(-> B (! A)))
(define H4 '(-> R (^ C (! D))))
(define H5 '(-> M (! A)))
(define H6 '(v (! R) (! M)))
(define H7 '(-> (! R) (v U A)))
(define H8 '(<-> V A))
(define H9 '(-> (v (! H) O) R))
(define H10 '(v (^ U (! C) (^ (! U) C))))
(define H11 '(-> C D))
(define H12 '(v O (v R M)))

