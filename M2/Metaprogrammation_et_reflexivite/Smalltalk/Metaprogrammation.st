PackageManifest subclass: #ManifestMetaprogrammation
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-Manifest'!
!ManifestMetaprogrammation commentStamp: 'ThomasDiGiovanni 9/26/2019 14:00' prior: 0!
HMIN305 - Metaprogrammation et reflexivite!

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

ManifestMetaprogrammation class
	instanceVariableNames: ''!

!ManifestMetaprogrammation class methodsFor: 'code-critics' stamp: 'ThomasDiGiovanni 9/27/2019 12:36'!
ruleRBBadMessageRuleV1FalsePositive
	^ #(#(#(#RGClassDefinition #(#Inspecter)) #'2019-09-27T12:36:13.763624+02:00') )! !

!ManifestMetaprogrammation class methodsFor: 'code-critics' stamp: 'ThomasDiGiovanni 9/27/2019 11:44'!
ruleRBCodeCruftLeftInMethodsRuleV1FalsePositive
	^ #(#(#(#RGClassDefinition #(#Inspecter)) #'2019-09-27T11:44:03.468624+02:00') )! !

!ManifestMetaprogrammation class methodsFor: 'code-critics' stamp: 'ThomasDiGiovanni 9/27/2019 12:36'!
ruleRBUtilityMethodsRuleV1FalsePositive
	^ #(#(#(#RGClassDefinition #(#Inspecter)) #'2019-09-27T12:36:43.094624+02:00') )! !

!ManifestMetaprogrammation class methodsFor: 'code-critics' stamp: 'ThomasDiGiovanni 10/11/2019 12:20'!
ruleRBRefersToClassRuleV1FalsePositive
	^ #(#(#(#RGMethodDefinition #(#'Animal class' #new #true)) #'2019-10-11T12:20:22.960371+02:00') )! !

!ManifestMetaprogrammation class methodsFor: 'code-critics' stamp: 'ThomasDiGiovanni 10/11/2019 12:35'!
ruleReTestClassNotInPackageWithTestEndingNameV1FalsePositive
	^ #(#(#(#RGPackage #(#Metaprogrammation)) #'2019-09-27T10:33:24.180624+02:00') )! !

!ManifestMetaprogrammation class methodsFor: 'code-critics' stamp: 'ThomasDiGiovanni 1/2/2020 14:44'!
ruleRBClassNotReferencedRuleV1FalsePositive
	^ #(#(#(#RGClassDefinition #(#Counter)) #'2020-01-02T14:43:58.600952+01:00') #(#(#RGClassDefinition #(#Chat)) #'2020-01-02T14:44:02.130952+01:00') #(#(#RGClassDefinition #(#Chien)) #'2020-01-02T14:44:05.016952+01:00') #(#(#RGPackage #(#Metaprogrammation)) #'2020-01-02T14:44:42.850952+01:00') )! !
Object subclass: #Animal
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!Animal commentStamp: 'ThomasDiGiovanni 10/11/2019 10:14' prior: 0!
Abstract class representing an animal.!

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

Animal class
	instanceVariableNames: ''!

!Animal class methodsFor: 'instance creation' stamp: 'ThomasDiGiovanni 10/11/2019 12:05'!
new
	self = Animal
		ifTrue: [ self
				error: 'Cannot instanciate an abstract class (' , self name , ')' ]
		ifFalse: [ ^ super new ]! !


Object subclass: #Cell
	instanceVariableNames: 'value formula internalFormula'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!Cell commentStamp: 'ThomasDiGiovanni 10/4/2019 12:34' prior: 0!
Implementation of a cell in a spreadsheet.!


!Cell methodsFor: 'compiling' stamp: 'ThomasDiGiovanni 10/11/2019 10:43'!
executeFormula
	formula isNil
		ifTrue: [ self error ]
		ifFalse: [ UndefinedObject
				addSelector: #executeFormula
				withMethod: internalFormula.
			^ nil executeFormula ]! !

!Cell methodsFor: 'compiling' stamp: 'ThomasDiGiovanni 10/4/2019 12:02'!
compileFormula: string
	! !


Animal subclass: #Chat
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!Chat commentStamp: 'ThomasDiGiovanni 10/11/2019 10:14' prior: 0!
Representation of a cat.!


Animal subclass: #Chien
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!Chien commentStamp: 'ThomasDiGiovanni 10/11/2019 10:14' prior: 0!
Representation of a dog.!


Object subclass: #Citoyen
	instanceVariableNames: ''
	classVariableNames: 'President'
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!Citoyen commentStamp: 'ThomasDiGiovanni 10/11/2019 09:56' prior: 0!
Implementation of a citizen.!


Object subclass: #Counter
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!Counter commentStamp: 'ThomasDiGiovanni 9/27/2019 10:45' prior: 0!
Standart implementation of a counter.!

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

Counter class
	instanceVariableNames: ''!

!Counter class methodsFor: 'operations' stamp: 'ThomasDiGiovanni 9/27/2019 10:11'!
create
	| x |
	x := 0.
	^ [ x := x + 1 ]! !


Object subclass: #IDM
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!IDM commentStamp: 'ThomasDiGiovanni 10/11/2019 10:32' prior: 0!
Refactoring stuff.!

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

IDM class
	instanceVariableNames: ''!

!IDM class methodsFor: 'creating' stamp: 'ThomasDiGiovanni 10/11/2019 10:32'!
idmPile
	| growingPileClass growMethod pushMethod |
	"Adds a new class"
	Pile
		subclass: #GrowingPile
		instanceVariableNames: ''
		classVariableNames: ''
		package: 'Metaprogrammation-TP1'.
	growingPileClass := Smalltalk classNamed: #GrowingPile.

	"Moves the grow method"
	growMethod := OpalCompiler new
		source: (Pile compiledMethodAt: #grow) sourceCode;
		class: growingPileClass;
		compile.
	growingPileClass addSelector: #grow withMethod: growMethod.
	Pile removeSelector: #grow.

	"Redefines the push method"
	pushMethod := OpalCompiler new
		source:
			'push: object
			self isFull
			ifTrue: [ self grow. ].
			contenu at: index put: object.
			index := index + 1' withCRs;
		class: growingPileClass;
		compile.
	growingPileClass addSelector: #push: withMethod: pushMethod! !


Object subclass: #Inspecter
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!Inspecter commentStamp: 'ThomasDiGiovanni 9/27/2019 11:39' prior: 0!
Class able to inspect any object and print its attributes names and values in the transcript.!


!Inspecter methodsFor: 'actions' stamp: 'ThomasDiGiovanni 9/28/2019 00:08'!
inspect: object
	Transcript
		show: object className , ' attributes are: ';
		cr.
	object class allInstVarNames
		do: [ :varName | 
			Transcript
				show: varName , ' ' , (object instVarNamed: varName asSymbol) asString;
				cr ]! !


Object subclass: #List
	instanceVariableNames: 'head tail'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!List commentStamp: 'ThomasDiGiovanni 9/27/2019 10:46' prior: 0!
Standart implementation of a linked list.!


!List methodsFor: 'accessing' stamp: 'ThomasDiGiovanni 9/27/2019 10:37'!
head: newHead tail: newTail
head := newHead.
tail := newTail.! !

!List methodsFor: 'accessing' stamp: 'ThomasDiGiovanni 9/27/2019 10:04'!
tail
	^ tail! !

!List methodsFor: 'accessing' stamp: 'ThomasDiGiovanni 9/27/2019 10:47'!
append: list
	^ (tail append: list) addFirst: head! !

!List methodsFor: 'accessing' stamp: 'ThomasDiGiovanni 9/27/2019 10:04'!
head
	^ head! !

!List methodsFor: 'accessing' stamp: 'ThomasDiGiovanni 9/27/2019 10:04'!
length 
^1 + self tail length! !


!List methodsFor: 'enumerating' stamp: 'ThomasDiGiovanni 9/28/2019 20:01'!
do: block
	block value: head.
	block value: tail! !


!List methodsFor: 'adding' stamp: 'ThomasDiGiovanni 9/28/2019 20:07'!
addFirst: element
	^ self class new head: element tail: self! !


Object subclass: #Pile
	instanceVariableNames: 'contenu index capacite'
	classVariableNames: 'DefaultSize'
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!Pile commentStamp: 'ThomasDiGiovanni 10/11/2019 10:03' prior: 0!
Classic implementation of a stack!


!Pile methodsFor: 'removing' stamp: 'ThomasDiGiovanni 9/20/2019 12:13'!
pop
	self isEmpty
		ifTrue: [ self error: 'pile is empty' ]
		ifFalse: [ index := index - 1 ]! !


!Pile methodsFor: 'testing' stamp: 'ThomasDiGiovanni 10/4/2019 11:36'!
isFull
	^ index = (capacite + 1)! !

!Pile methodsFor: 'testing' stamp: 'ThomasDiGiovanni 10/4/2019 11:35'!
isEmpty
	^ index = 1! !


!Pile methodsFor: 'printing' stamp: 'ThomasDiGiovanni 10/4/2019 11:38'!
printOn: aStream
	aStream nextPutAll: 'Pile de taille '.
	capacite printOn: aStream.
	aStream nextPutAll: ' contenant '.
	index - 1 printOn: aStream.
	aStream nextPutAll: ' objets : ('.
	contenu
		do: [ :each | 
			each printOn: aStream.
			aStream space ].
	aStream nextPut: $).
	aStream nextPut: $.! !


!Pile methodsFor: 'initialization' stamp: 'ThomasDiGiovanni 10/4/2019 11:36'!
initialize: taille
	index := 1.
	capacite := taille.

	"Le contenu est stocke dans un tableau"
	contenu := Array new: capacite! !


!Pile methodsFor: 'accessing' stamp: 'ThomasDiGiovanni 9/20/2019 12:11'!
top
	^ contenu at: index! !


!Pile methodsFor: 'adding' stamp: 'ThomasDiGiovanni 10/4/2019 11:36'!
push: object
	self isFull
		ifTrue: [ self error: 'pile is full' ]
		ifFalse: [ contenu at: index put: object.
			index := index + 1 ]! !

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

Pile class
	instanceVariableNames: 'instanceList'!

!Pile class methodsFor: 'class initialization' stamp: 'ThomasDiGiovanni 10/11/2019 10:02'!
initialize
	DefaultSize := 5.
	instanceList := LinkedList new! !


!Pile class methodsFor: 'example' stamp: 'ThomasDiGiovanni 9/27/2019 11:27'!
example
	| testPile |
	testPile := self new.
	self assert: testPile isEmpty.
	testPile push: 1.
	testPile push: 2.
	testPile pop.
	testPile push: 3.
	testPile inspect! !


!Pile class methodsFor: 'instance creation' stamp: 'ThomasDiGiovanni 10/11/2019 09:58'!
new
	| newInstance |
	newInstance := super new initialize: DefaultSize.
	
	instanceList add: newInstance.
	
	^ newInstance! !

!Pile class methodsFor: 'instance creation' stamp: 'ThomasDiGiovanni 10/11/2019 10:00'!
instances
	^ instanceList! !


Pile subclass: #GrowingPile
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!GrowingPile commentStamp: 'ThomasDiGiovanni 10/4/2019 12:01' prior: 0!
Class created programmatically by the call "IDM idmPile".!


!GrowingPile methodsFor: 'adding'!
grow
	| tmp1 tmp2 tmp3 tmp4 tmp5 |
	tmp1 := capacite.
	tmp2 := contenu.
	capacite := capacite * 2.
	contenu := Array new: capacite.
	index := 0.
	tmp3 := tmp1.
	tmp4 := tmp3.
	tmp5 := tmp4.
	1 to: tmp5 do: [ :tmp6 | self push: (tmp2 at: tmp6) ]! !

!GrowingPile methodsFor: 'adding'!
push: arg1
	self isFull
		ifTrue: [ self grow ].
	contenu at: index put: arg1.
	index := index + 1! !


TestCase subclass: #PileTest
	instanceVariableNames: 'emptyInstance fullInstance'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!PileTest commentStamp: 'ThomasDiGiovanni 9/27/2019 10:45' prior: 0!
Jeux de test de la classe Pile!


!PileTest methodsFor: 'running' stamp: 'ThomasDiGiovanni 9/27/2019 10:44'!
setUp
	super setUp.
	emptyInstance := Pile new initialize: 2.
	fullInstance := Pile new initialize: 2.
	fullInstance push: 'Test'.
	fullInstance push: 'Pile'! !


!PileTest methodsFor: 'tests' stamp: 'ThomasDiGiovanni 9/27/2019 10:58'!
testIsFull
	self deny: emptyInstance isFull.
	self assert: fullInstance isFull.! !

!PileTest methodsFor: 'tests' stamp: 'ThomasDiGiovanni 9/27/2019 10:58'!
testIsEmpty
	self assert: emptyInstance isEmpty.
	self deny: fullInstance isEmpty! !


Object subclass: #SalleCours
	instanceVariableNames: ''
	classVariableNames: ''
	poolDictionaries: ''
	category: 'Metaprogrammation-TP'!
!SalleCours commentStamp: 'ThomasDiGiovanni 10/11/2019 10:05' prior: 0!
Implementation of a university room.!

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

SalleCours class
	instanceVariableNames: 'maxRooms roomCount'!

!SalleCours class methodsFor: 'instance creation' stamp: 'ThomasDiGiovanni 10/11/2019 10:12'!
new
	roomCount + 1 <= maxRooms
		ifTrue: [ roomCount := roomCount + 1.
			^ super new ]
		ifFalse: [ self error: 'Max capacity reached.' ]! !


!SalleCours class methodsFor: 'class initialization' stamp: 'ThomasDiGiovanni 10/11/2019 10:11'!
initialize
	maxRooms := 5.
	roomCount := 0! !

Pile initialize!
SalleCours initialize!