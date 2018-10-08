;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname TP3) (read-case-sensitive #t) (teachpacks ((lib "draw.rkt" "teachpack" "htdp"))) (htdp-settings #(#t constructor repeating-decimal #t #t none #f ((lib "draw.rkt" "teachpack" "htdp")) #f)))
; Di Giovanni Thomas GR. A

; Constructeur domino
(define make-domino (lambda (a b)
                      (if (and (>= a 0) (>= b 0) (<= a 6) (<= b 6))
                          (list a b)
                          (display "Erreur: mauvaises valeurs"))))

; Accesseurs domino
(define partie-gauche (lambda (d)
                     (car d)))

(define partie-droite (lambda (d)
                     (cadr d)))

; Constructeur jeu
(define make-jeu (lambda (dominos)
                   dominos))

; Accesseurs jeu
(define premier-jeu (lambda (jeu)
                    (car jeu)))

(define reste-jeu (lambda (jeu)
                    (cdr jeu)))

;
(define est-double (lambda (d)
                     (if (= (partie-gauche d) (partie-droite d))
                         #t
                         #f)))

(define vide? (lambda (jeu)
                (null? jeu)))

(define doubles (lambda (jeu)
                  (cond ((vide? jeu) '())
                        ((est-double (premier-jeu jeu)) (cons (premier-jeu jeu) (doubles (reste-jeu jeu))))
                        (else (doubles (reste-jeu jeu))))))

(define retourner (lambda (d)
                    (make-domino (partie-droite d)
                                 (partie-gauche d))))

(define peut-jouer? (lambda (n jeu)
                       (cond ((vide? jeu) #f)
                             ((or (= n (partie-gauche (premier-jeu jeu))) (= n (partie-droite (premier-jeu jeu)))) #t)
                             (else (peut-jouer? n (reste-jeu jeu))))))

(define extraire (lambda (n jeu)
                   (cond ((or (= n (partie-gauche (premier-jeu jeu))) (= n (partie-droite (premier-jeu jeu)))) (premier-jeu jeu))
                         (else (extraire n (reste-jeu jeu))))))

(define chaine-valide? (lambda (c)
                         (cond ((vide? (cdr c)) #t)
                               ((= (cdar c) (caadr c)) (chaine-valide? (cdr c)))
                               (else #f))))

(define ext-g (lambda (c)
                (caar c)))

(define ext-d (lambda (c)
                (if (vide? (cdr c))
                    (cdar c)
                    (ext-d (cdr c)))))

(define supprimer (lambda (d jeu)
                    (if (and (= (partie-gauche (premier-jeu jeu)) (partie-gauche d)) (= (partie-droite (premier-jeu jeu)) (partie-droite d)))
                        (reste-jeu jeu)
                        (cons (premier-jeu jeu) (supprimer d (reste-jeu jeu))))))

(define ajouter (lambda (d c)
                  (cond ((= (partie-gauche d) (ext-g c)) (cons (retourner d) c))
                        ((= (partie-droite d) (ext-g c)) (cons d c))
                        ((= (partie-gauche d) (ext-d c)) (cons c (retourner d)))
                        ((= (partie-droite d) (ext-d c)) (cons c d)))))

(define pose (lambda (jeu-c)
               (cond ((peut-jouer? (ext-g (cadr jeu-c)) (car jeu-c)) (cons (supprimer (extraire (ext-g (cadr jeu-c)) (car jeu-c)) (car jeu-c))
                                                                                (ajouter (extraire (ext-g (cadr jeu-c)) (car jeu-c)))))
                     ((peut-jouer? (ext-d (cadr jeu-c)) (car jeu-c)) (cons (supprimer (extraire (ext-d (cadr jeu-c)) (car jeu-c)) (car jeu-c))
                                                                                (ajouter (extraire (ext-d (cadr jeu-c)) (car jeu-c)))))
                     (else jeu-c))))

; Partie graphique
(define dessiner-gros-point (lambda (pos)
                              (draw-solid-disk pos 2)))

(define dessiner-rectangle (lambda (pos1 pos2)
                             (begin
                               (draw-solid-line pos1 (make-posn (posn-x pos2)
                                                                (posn-y pos1)))
                               (draw-solid-line pos1 (make-posn (posn-x pos1)
                                                                (posn-y pos2)))
                               (draw-solid-line pos2 (make-posn (posn-x pos1)
                                                                (posn-y pos2)))
                               (draw-solid-line pos2 (make-posn (posn-x pos2)
                                                                (posn-y pos1))))))

(define dessiner-demi-domino (lambda (pos nombre)
                                (begin
                                  ; On commence par dessiner le rectangle
                                  (dessiner-rectangle (make-posn (- (posn-x pos) 24) (- (posn-y pos) 24)) (make-posn (+ (posn-x pos) 24) (+ (posn-y pos) 24)))

                                  ; Puis on dessine les points en fonction du nombre
                                  (cond ((= nombre 1) (dessiner-gros-point pos))
                                        ((= nombre 2) (begin
                                                        (dessiner-gros-point (make-posn (- (posn-x pos) 15) (+ (posn-y pos) 15)))
                                                        (dessiner-gros-point (make-posn (+ (posn-x pos) 15) (- (posn-y pos) 15)))))
                                        ((= nombre 3) (begin
                                                        (dessiner-gros-point (make-posn (- (posn-x pos) 15) (+ (posn-y pos) 15)))
                                                        (dessiner-gros-point pos)
                                                        (dessiner-gros-point (make-posn (+ (posn-x pos) 15) (- (posn-y pos) 15)))))
                                        ((= nombre 4) (begin
                                                        (dessiner-gros-point (make-posn (- (posn-x pos) 15) (- (posn-y pos) 15)))
                                                        (dessiner-gros-point (make-posn (- (posn-x pos) 15) (+ (posn-y pos) 15)))
                                                        (dessiner-gros-point (make-posn (+ (posn-x pos) 15) (- (posn-y pos) 15)))
                                                        (dessiner-gros-point (make-posn (+ (posn-x pos) 15) (+ (posn-y pos) 15)))))
                                        ((= nombre 5) (begin
                                                        (dessiner-gros-point (make-posn (- (posn-x pos) 15) (- (posn-y pos) 15)))
                                                        (dessiner-gros-point (make-posn (- (posn-x pos) 15) (+ (posn-y pos) 15)))
                                                        (dessiner-gros-point pos)
                                                        (dessiner-gros-point (make-posn (+ (posn-x pos) 15) (- (posn-y pos) 15)))
                                                        (dessiner-gros-point (make-posn (+ (posn-x pos) 15) (+ (posn-y pos) 15)))))
                                        ((= nombre 6) (begin
                                                        (dessiner-gros-point (make-posn (- (posn-x pos) 15) (- (posn-y pos) 15)))
                                                        (dessiner-gros-point (make-posn (- (posn-x pos) 15) (posn-y pos)))
                                                        (dessiner-gros-point (make-posn (- (posn-x pos) 15) (+ (posn-y pos) 15)))
                                                        (dessiner-gros-point (make-posn (+ (posn-x pos) 15) (- (posn-y pos) 15)))
                                                        (dessiner-gros-point (make-posn (+ (posn-x pos) 15) (posn-y pos)))
                                                        (dessiner-gros-point (make-posn (+ (posn-x pos) 15) (+ (posn-y pos) 15)))))
                                        (else (display "Erreur: mauvais nombre"))))))

(define dessiner-domino (lambda (pos domino)
                           (begin
                             (dessiner-demi-domino (make-posn (+ (posn-x pos) 24) (+ (posn-y pos) 24)) (partie-gauche domino))
                             (dessiner-demi-domino (make-posn (+ (posn-x pos) 72) (+ (posn-y pos) 24)) (partie-droite domino)))))

(define dessiner-jeu (lambda (jeu nombre dom_places)
                               (cond ((and (not (vide? jeu)) (= nombre 1))
                                      (begin
                                        (dessiner-domino (make-posn (* (+ 96 1) (quotient dom_places 5)) (- (- 256 48) (* 48 (remainder dom_places 5)))) (premier-jeu jeu))
                                        (dessiner-jeu (supprimer (premier-jeu jeu) jeu) nombre (+ dom_places 1))))
                               
                                     ((and (not (vide? jeu)) (= nombre 2))
                                      (begin
                                        (dessiner-domino (make-posn (- (- 342 96 ) (* (+ 96 1) (quotient dom_places 5))) (- (- 256 48) (* 48 (remainder dom_places 5)))) (premier-jeu jeu))
                                        (dessiner-jeu (supprimer (premier-jeu jeu) jeu) nombre (+ dom_places 1))))
                                     
                                     ((not (vide? jeu)) (display "Erreur: numéro de joueur inexistant (2 joueurs seulement)"))
                                     (else (display "Affichage du jeu du joueur terminé")))))

(define dessiner-jeu-dominos (lambda (jeu nombre)
                               (dessiner-jeu jeu nombre 0)))
                               
; Tests
(define d1-test (make-domino 1 3))
(define d2-test (make-domino 4 3))
(define d3-test (make-domino 1 6))
(define d4-test (make-domino 5 5))
(define d5-test (make-domino 2 1))
(define d6-test (make-domino 6 4))
(define d7-test (make-domino 6 5))
(define d8-test (make-domino 3 1))
(define j1-test (make-jeu (list d1-test d2-test d3-test d4-test)))
(define j2-test (make-jeu (list d1-test d2-test d3-test d4-test d5-test d6-test d7-test d8-test)))
(define j3-test (make-jeu (list d1-test d2-test d3-test d4-test d5-test d6-test d7-test d8-test d1-test d2-test d3-test d4-test)))
(start 342 256)

(define dessiner-chaine (lambda (chaine x y retourne)
                          (cond ((vide? chaine) (display "Affichage de la chaine terminé"))
                                
                                ((eq? retourne #f) (if (<= (+ x 96) 342)
                                                      (begin
                                                        (dessiner-domino (make-posn x y) (car chaine))
                                                        (dessiner-chaine (cdr chaine) (+ x 97) y retourne))
                                                      (begin
                                                        ; Sinon dessiner le domino en vertical
                                                        (dessiner-chaine (cdr chaine) (- x 97) (+ y 48) (not retourne)))))
                                                  
                                ((eq? retourne #t) (if (>= x 0)
                                                       (begin
                                                         (dessiner-domino (make-posn x y) (car chaine))
                                                         (dessiner-chaine (cdr chaine) (- x 97) y retourne))
                                                       (begin
                                                         ; Sinon dessiner le domino en vertical
                                                         (dessiner-chaine (cdr chaine) (+ x 48) (+ y 48) (not retourne))))))))
                                  
(define dessiner-chaine-dominos (lambda (chaine)
                                  (dessiner-chaine chaine 0 0 #f)))

; TP noté
; Exercice 5: (peut-jouer? 0 '((1 1) (0 1) (3 5) (3 3))) -> vrai
;             (peut-jouer? 1 '((1 1) (0 1) (3 5) (3 3))) -> vrai
;             (peut-jouer? 2 '((1 1) (0 1) (3 5) (3 3))) -> faux
;             (peut-jouer? 3 '((1 1) (0 1) (3 5) (3 3))) -> vrai
;             (peut-jouer? 4 '((1 1) (0 1) (3 5) (3 3))) -> faux
;             (peut-jouer? 5 '((1 1) (0 1) (3 5) (3 3))) -> vrai
;             (peut-jouer? 6 '((1 1) (0 1) (3 5) (3 3))) -> faux
; Exercice 6:
; Exercice 7:
; Exercice 8: 