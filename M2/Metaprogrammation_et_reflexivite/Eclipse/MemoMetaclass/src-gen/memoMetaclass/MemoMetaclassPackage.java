/**
 */
package memoMetaclass;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see memoMetaclass.MemoMetaclassFactory
 * @model kind="package"
 * @generated
 */
public interface MemoMetaclassPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "memoMetaclass";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/memoMetaclass";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "memoMetaclass";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MemoMetaclassPackage eINSTANCE = memoMetaclass.impl.MemoMetaclassPackageImpl.init();

	/**
	 * The meta object id for the '{@link memoMetaclass.impl.MemoObjectImpl <em>Memo Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see memoMetaclass.impl.MemoObjectImpl
	 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getMemoObject()
	 * @generated
	 */
	int MEMO_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMO_OBJECT__INSTANCES = 0;

	/**
	 * The number of structural features of the '<em>Memo Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMO_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Memo Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMO_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link memoMetaclass.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see memoMetaclass.impl.NamedElementImpl
	 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__INSTANCES = MEMO_OBJECT__INSTANCES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = MEMO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = MEMO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = MEMO_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link memoMetaclass.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see memoMetaclass.impl.PersonImpl
	 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 2;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__INSTANCES = NAMED_ELEMENT__INSTANCES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__AGE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Automobiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__AUTOMOBILES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Birthday</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON___BIRTHDAY = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link memoMetaclass.impl.AutomobileImpl <em>Automobile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see memoMetaclass.impl.AutomobileImpl
	 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getAutomobile()
	 * @generated
	 */
	int AUTOMOBILE = 3;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE__INSTANCES = NAMED_ELEMENT__INSTANCES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Automobile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Automobile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOMOBILE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link memoMetaclass.impl.WorldImpl <em>World</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see memoMetaclass.impl.WorldImpl
	 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getWorld()
	 * @generated
	 */
	int WORLD = 4;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD__INSTANCES = MEMO_OBJECT__INSTANCES;

	/**
	 * The feature id for the '<em><b>Population</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD__POPULATION = MEMO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Automobiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD__AUTOMOBILES = MEMO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>World</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_FEATURE_COUNT = MEMO_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>World</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_OPERATION_COUNT = MEMO_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link memoMetaclass.AutomobileType <em>Automobile Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see memoMetaclass.AutomobileType
	 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getAutomobileType()
	 * @generated
	 */
	int AUTOMOBILE_TYPE = 5;

	/**
	 * Returns the meta object for class '{@link memoMetaclass.MemoObject <em>Memo Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memo Object</em>'.
	 * @see memoMetaclass.MemoObject
	 * @generated
	 */
	EClass getMemoObject();

	/**
	 * Returns the meta object for the attribute list '{@link memoMetaclass.MemoObject#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Instances</em>'.
	 * @see memoMetaclass.MemoObject#getInstances()
	 * @see #getMemoObject()
	 * @generated
	 */
	EAttribute getMemoObject_Instances();

	/**
	 * Returns the meta object for class '{@link memoMetaclass.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see memoMetaclass.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link memoMetaclass.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see memoMetaclass.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link memoMetaclass.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see memoMetaclass.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link memoMetaclass.Person#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see memoMetaclass.Person#getAge()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Age();

	/**
	 * Returns the meta object for the reference list '{@link memoMetaclass.Person#getAutomobiles <em>Automobiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Automobiles</em>'.
	 * @see memoMetaclass.Person#getAutomobiles()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Automobiles();

	/**
	 * Returns the meta object for the '{@link memoMetaclass.Person#birthday() <em>Birthday</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Birthday</em>' operation.
	 * @see memoMetaclass.Person#birthday()
	 * @generated
	 */
	EOperation getPerson__Birthday();

	/**
	 * Returns the meta object for class '{@link memoMetaclass.Automobile <em>Automobile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Automobile</em>'.
	 * @see memoMetaclass.Automobile
	 * @generated
	 */
	EClass getAutomobile();

	/**
	 * Returns the meta object for the attribute '{@link memoMetaclass.Automobile#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see memoMetaclass.Automobile#getType()
	 * @see #getAutomobile()
	 * @generated
	 */
	EAttribute getAutomobile_Type();

	/**
	 * Returns the meta object for class '{@link memoMetaclass.World <em>World</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>World</em>'.
	 * @see memoMetaclass.World
	 * @generated
	 */
	EClass getWorld();

	/**
	 * Returns the meta object for the containment reference list '{@link memoMetaclass.World#getPopulation <em>Population</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Population</em>'.
	 * @see memoMetaclass.World#getPopulation()
	 * @see #getWorld()
	 * @generated
	 */
	EReference getWorld_Population();

	/**
	 * Returns the meta object for the containment reference list '{@link memoMetaclass.World#getAutomobiles <em>Automobiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Automobiles</em>'.
	 * @see memoMetaclass.World#getAutomobiles()
	 * @see #getWorld()
	 * @generated
	 */
	EReference getWorld_Automobiles();

	/**
	 * Returns the meta object for enum '{@link memoMetaclass.AutomobileType <em>Automobile Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Automobile Type</em>'.
	 * @see memoMetaclass.AutomobileType
	 * @generated
	 */
	EEnum getAutomobileType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MemoMetaclassFactory getMemoMetaclassFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link memoMetaclass.impl.MemoObjectImpl <em>Memo Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see memoMetaclass.impl.MemoObjectImpl
		 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getMemoObject()
		 * @generated
		 */
		EClass MEMO_OBJECT = eINSTANCE.getMemoObject();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMO_OBJECT__INSTANCES = eINSTANCE.getMemoObject_Instances();

		/**
		 * The meta object literal for the '{@link memoMetaclass.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see memoMetaclass.impl.NamedElementImpl
		 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link memoMetaclass.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see memoMetaclass.impl.PersonImpl
		 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__AGE = eINSTANCE.getPerson_Age();

		/**
		 * The meta object literal for the '<em><b>Automobiles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__AUTOMOBILES = eINSTANCE.getPerson_Automobiles();

		/**
		 * The meta object literal for the '<em><b>Birthday</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERSON___BIRTHDAY = eINSTANCE.getPerson__Birthday();

		/**
		 * The meta object literal for the '{@link memoMetaclass.impl.AutomobileImpl <em>Automobile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see memoMetaclass.impl.AutomobileImpl
		 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getAutomobile()
		 * @generated
		 */
		EClass AUTOMOBILE = eINSTANCE.getAutomobile();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTOMOBILE__TYPE = eINSTANCE.getAutomobile_Type();

		/**
		 * The meta object literal for the '{@link memoMetaclass.impl.WorldImpl <em>World</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see memoMetaclass.impl.WorldImpl
		 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getWorld()
		 * @generated
		 */
		EClass WORLD = eINSTANCE.getWorld();

		/**
		 * The meta object literal for the '<em><b>Population</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORLD__POPULATION = eINSTANCE.getWorld_Population();

		/**
		 * The meta object literal for the '<em><b>Automobiles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORLD__AUTOMOBILES = eINSTANCE.getWorld_Automobiles();

		/**
		 * The meta object literal for the '{@link memoMetaclass.AutomobileType <em>Automobile Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see memoMetaclass.AutomobileType
		 * @see memoMetaclass.impl.MemoMetaclassPackageImpl#getAutomobileType()
		 * @generated
		 */
		EEnum AUTOMOBILE_TYPE = eINSTANCE.getAutomobileType();

	}

} //MemoMetaclassPackage
