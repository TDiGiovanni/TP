#lang racket

(define puis2 (lambda (x)
                (* x x)))

(define puis4 (lambda (x)
                (puis2 (puis2 x))))

(define e (expt 12345 12345))

(define t (truncate 3.5))

(define divisible? (lambda (x y)
                     (= 0 (modulo x y))))

(define expression (lambda (x)
              (cond ((= x 5) 3)
                    ((>= x 8) (* x x))
                    ((= x 6) 'toto)
                    ((= x 7) #t)
                    (else #f))))