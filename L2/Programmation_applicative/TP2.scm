; Di Giovanni Thomas GR. A

(require racket/set)

(define LVal '(1 2 3 4 5 6 7 8 9 10 25 50 75 100))
(define Op '(+ * - /))
(define Nb '(10 3 7))

(define (make-cible)
  (+ 100 (random 1000)))

(define make-tirage (lambda (n)
                      (let ([val (random 100)])
                      (if (= n 0)

                          ()
                          
                          (if (member val LVal)
                              (cons val (make-tirage (- n 1)))
                              (make-tirage n))))))

(define (affiche l)
  (if (null? l)
      ()
      (cons (caar l) (affiche (cdr l)))))

(define (estdans? n List)
  (if (null? List)
      #f
      (if (= n (car List))
          #t
          (estdans? n (cdr List)))))

(define (sortdans n List)
      (if (= n (caar List))
          (car List)
          (sortdans n (cdr List))))

(define (estValide? o n1 n2)
  (if (and (= 0 n2) (equal? o /))
      #f
      (if (> 0 ((eval o) n1 n2))
          #f
          (if (integer? ((eval o) n1 n2))
          #t
          #f))))

(define (opere Op a b)
  (if (null? Op)
      ()
      (cond
        ((equal? (eval (car Op)) +)
         (if (estValide? + (car a) (car b))
              (cons (list (+ (car a) (car b)) (set-union (cons (car Op) (cdr b)) (cdr a))) (opere (cdr Op) a b))))
        ((equal? (eval (car Op)) *)
         (if (estValide? * (car a) (car b))
             (cons (list (* (car a) (car b)) (set-union (cons (car Op) (cdr b)) (cdr a))) (opere (cdr Op) a b))
             (else (opere (cdr Op) a b))))
        ((equal? (eval (car Op)) -)
         (cond
           ((estValide? - (car a) (car b))
             (cons (list (- (car a) (car b)) (set-union (cons (car Op) (cdr b)) (cdr a))) (opere (cdr Op) a b)))
           ((estValide? - (car b) (car a))
             (cons (list (- (car b) (car a)) (set-union (cons (car Op) (cdr a)) (cdr b))) (opere (cdr Op) a b)))
           (else (opere (cdr Op) a b))))
        ((equal? (eval (car Op)) /)
         (cond
           ((estValide? / (car a) (car b))
             (cons (list (/ (car a) (car b)) (set-union (cons (car Op) (cdr b)) (cdr a))) (opere (cdr Op) a b)))
           ((estValide? / (car b) (car a))
             (cons (list (/ (car b) (car a)) (set-union (cons (car Op) (cdr a)) (cdr b))) (opere (cdr Op) a b)))
           (else (opere (cdr Op) a b))))
        (else (opere (cdr Op) a b)))))



(define genere-plaque
  (lambda (op l)
    (letrec ((reste (lambda (l a b)
                (cond ((null? l) '())
                      ((eq? (car l) (car a)) (reste (cdr l) a b))
                      ((eq? (car l) (car b)) (reste (cdr l) a b))
                      (else (cons (car l) (reste (cdr l) a b))))))
             (plaques (lambda (result rest)
                (cond ((null? result) '())
                      (else (cons (append (list (car result)) rest) (plaques (cdr result) rest))))))
             (parcours (lambda (op l a b)
                (cond ((and (null? a) (null?  b)) '())
                      ((null? b)
                       (if (not (null? (cdr a)))
                           (parcours op l (cdr a) (cddr a))
                           '()))
                      (else (append (plaques (opere op (car a) (car b)) (reste l a b)) (parcours op l a (cdr b))))))))
      (parcours op l l (cdr l)))))
                        



(define (ceb op l nbr)
  (if (or (estdans? nbr l) (cebBool op (genere-plaque op l) nbr))
      (display "Le compte est bon")
      (display "Le compte n’est pas bon")))


(define (cebBool op l nbr)
  (if (null? l)
      #f
      (if (estdans? nbr (car l))
          #t
          (if (null? (cdar l))
              (cebBool op (cdr l) nbr)
              (or (cebBool op (genere-plaque op (car l)) nbr) (cebBool op (cdr l) nbr))))))

(define (cebProche op l nbr)
  (begin
      (display "avec le tirage : ")
      (display (affiche l))
      (display " ,le résultat qui s'apporche le plus de ")
      (display nbr)
      (display " est : \n")
      (cebRapproche op (genere-plaque op l) nbr '(-10000 (-10000)))))

(define (cebRapproche op l nbr appro)
  (if (null? l)
      appro
      (if (estdans? nbr (car l))
          (sortdans nbr (car l))
          (if (null? (cdar l))
              (distance (caar l) (cebRapproche op (cdr l) nbr appro) nbr)
              (distance (cebRapproche op (genere-plaque op (car l)) nbr (plusProche? (car l) nbr appro)) (cebRapproche op (cdr l) nbr appro) nbr)))))

(define (plusProche? l nbr appro)
  (if (null? l)
      appro
      (if (< (abs (- (caar l) nbr)) (abs (- nbr (car appro))))
          (plusProche? (cdr l) nbr (car l))
          (plusProche? (cdr l) nbr appro))))

(define (distance nbr1 nbr2 nbr)
  (if (< (abs(- (car nbr1) nbr)) (abs(- (car nbr2) nbr)))
      nbr1
      nbr2))

;(cebProche Op (make-tirage) (make-cible))    ->   fonction à utliser

; TP noté
; Exercice 3: (make-tirage 5)
; Exercice 4: 