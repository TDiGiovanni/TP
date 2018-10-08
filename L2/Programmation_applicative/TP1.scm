; Di Giovanni Thomas GR. A

(define x 5)
(define (f x) (* x x))

(define d 1)
(define (plusd x) (+ x d))


(define g (lambda (x) (+ (h x) 1)))
(define h (lambda (x) (* x x)))

(define monabs (lambda (x)
                       (if (< x 0)
                           (- 0 x)
                           x)))

(define care-div (lambda (x y)
                   (if (= y 0)
                       (display "Erreur: impossible de diviser par 0")
                       (/ x y))))

; Exercice 9
(define vals (lambda (s)
               (cond ((<= -3 s -1) 1)
                     ((<= 2 s 4) 2)
                     (else 0))))

(define placement (lambda (capital taux annees)
                    (expt (+ capital taux) annees)))


(require (lib "turtles.ss" "graphics"))

(define carre (lambda (lgr)
                (draw lgr)
                (turn 90)
                (draw lgr)
                (turn 90)
                (draw lgr)
                (turn 90)
                (draw lgr)))

(define hexagone (lambda (lgr)
                   (draw lgr)
                   (turn (/ 360 6))
                   (draw lgr)
                   (turn (/ 360 6))
                   (draw lgr)
                   (turn (/ 360 6))
                   (draw lgr)
                   (turn (/ 360 6))
                   (draw lgr)
                   (turn (/ 360 6))
                   (draw lgr)))

(define figure (lambda (n cotes lgr)
                 (draw lgr)
                 (turn (/ 360 cotes))
                 (if (= n 0)
                     (move 1)
                     (figure (- n 1) cotes lgr))))

(define bissextile? (lambda (a)
                      (if (= 0 (modulo a 400))
                          #t
                          (if (and (= 0 (modulo a 4)) (not (= 0 (modulo a 100))))
                              #t
                              #f))))

(define nb-annees-bissextiles (lambda (a)
                                (if (>= a 1900)
                                    (if (bissextile? a)
                                        (+ (nb-annees-bissextiles (- a 1)) 1)
                                        (nb-annees-bissextiles (- a 1)))
                                    0)))

(define nb-jours-au-1-jan (lambda (m)
                            (cond ((= m 1) 0)
                                  ((= m 2) 31)
                                  ((= m 3) (+ 28 (nb-jours-au-1-jan (- m 1))))
                                  ((= m 4) (+ 31 (nb-jours-au-1-jan (- m 1))))
                                  ((= m 5) (+ 30 (nb-jours-au-1-jan (- m 1))))
                                  ((= m 6) (+ 31 (nb-jours-au-1-jan (- m 1))))
                                  ((= m 7) (+ 30 (nb-jours-au-1-jan (- m 1))))
                                  ((= m 8) (+ 31 (nb-jours-au-1-jan (- m 1))))
                                  ((= m 9) (+ 31 (nb-jours-au-1-jan (- m 1))))
                                  ((= m 10) (+ 30 (nb-jours-au-1-jan (- m 1))))
                                  ((= m 11) (+ 31 (nb-jours-au-1-jan (- m 1))))
                                  ((= m 12) (+ 30 (nb-jours-au-1-jan (- m 1))))
                                  (else (display "Erreur: l'argument passé n'est pas un mois")))))

(define nb-jours (lambda (j m a)
                   (if (and (bissextile? a) (> m 2))
                       (+ (- j 1) (nb-jours-au-1-jan m) (* 365 (- 1900 a)) (- (nb-annees-bissextiles a) 1))
                       (+ (- j 1) (nb-jours-au-1-jan m) (* 365 (- 1900 a)) (nb-annees-bissextiles a)))))
  
(define jour-de-semaine (lambda (j m a)
                          (cond ((= 0 (modulo (nb-jours j m a) 7)) 'Lundi)
                                ((= 1 (modulo (nb-jours j m a) 7)) 'Mardi)
                                ((= 2 (modulo (nb-jours j m a) 7)) 'Mercredi)
                                ((= 3 (modulo (nb-jours j m a) 7)) 'Jeudi)
                                ((= 4 (modulo (nb-jours j m a) 7)) 'Vendredi)
                                ((= 5 (modulo (nb-jours j m a) 7)) 'Samedi)
                                ((= 6 (modulo (nb-jours j m a) 7)) 'Dimanche))))

(define einstein (lambda (u v)
                   (let ([c 300000])
                     (/ (+ u v) (+ 1 (/ (* u v) (* c c)))))))

; TP noté
; Exercice 1: (map vals '(-5 -4 -3 -2 -1 0 1 2 3 4 5)), ce qui donne (0 0 1 1 1 0 0 2 2 2 0).
; Exercice 2: (bissextile? 1408) -> 1408 est une année bissextile,
;             (bissextile? 1500) -> pas 1500,
;             (jour-de-semaine 13 01 2408) -> nous serons un dimanche le 13 Janvier 2408.