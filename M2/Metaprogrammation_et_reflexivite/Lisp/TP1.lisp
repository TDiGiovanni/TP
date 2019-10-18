;; The person and child example
;; Defining the class person
(defclass person (standard-object)
  ((name :initarg :name
         :initform 'Unknown
         :accessor name)
   
   (species :initform 'Homo-sapiens
            :accessor species
            :allocation :class)))

;; Defining the class child
(defclass child (person)
  ())

;; Defining the toString method
(defgeneric toString(object)
  (:documentation "Says hello to an object"))

(defmethod toString ((p person))
  (format t "Hello ~a!~%" (name p)))

(defmethod toString ((c child))
  (call-next-method c)
  (format t "Young friend!~%"))

;; Testing
(defparameter pierre (make-instance 'person :name 'Pierre))
(toString pierre)

(defparameter lisa (make-instance 'child :name 'Lisa))
(toString lisa)


;; The animal and abstract-class example
;; Defining the class animal
(defclass animal (standard-object)
  ())

;; Defining the class abstract-class
(defclass abstract-class (standard-class)
  ())

;; Testing

