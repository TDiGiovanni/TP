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
(defgeneric toString (object)
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


;; The memo-class example
;; Defining the meta-class
(defclass memo-class(standard-class)
  ((instances :accessor getInstances
              :initform nil))
  (:metaclass standard-class))

(defmethod make-instance ((newClass memo-class) &rest args)
  )

(defmethod sb-mop:validate-superclass ((class memo-class)
                                       (superclass standard-class))
  )

(defmethod sb-mop:validate-superclass ((class standard-class)
                                       (superclass memo-class))
  )

;; Defining a memo-class, for example a stack
(defclass stack(standard-object)
  ()
  (:metaclass memo-class))

;; Testing
(defparameter firstInstance (make-instance 'stack))

;; The animal and abstract-class example
;; Defining the class abstract-class
(defclass abstract-class (standard-class)
  ((instance :initform nil)))

(defmethod sb-mop:validate-superclass ((class abstract-class)
                                (superclass standard-class))
  t)

(defmethod sb-mop:validate-superclass ((class standard-class)
                                (superclass abstract-class))
  t)

(defmethod make-instance ((newClass abstract-class) &rest args)
  (format t "Error: cannot instanciate an abstract class"))

;; Defining the class animal
(defclass animal (standard-object)
  ()
  (:metaclass abstract-class))

;; Defining the subclasses
(defclass cat (animal)
  ())

(defclass dog (animal)
  ())

;; Testing
(defparameter anAnimal (make-instance 'animal))

(defparameter aCat (make-instance 'cat))

(defparameter aDog (make-instance 'dog))
