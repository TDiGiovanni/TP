/**
 */
package memoMetaclass;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link memoMetaclass.World#getPopulation <em>Population</em>}</li>
 *   <li>{@link memoMetaclass.World#getAutomobiles <em>Automobiles</em>}</li>
 * </ul>
 *
 * @see memoMetaclass.MemoMetaclassPackage#getWorld()
 * @model
 * @generated
 */
public interface World extends MemoObject {
	/**
	 * Returns the value of the '<em><b>Population</b></em>' containment reference list.
	 * The list contents are of type {@link memoMetaclass.Person}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population</em>' containment reference list.
	 * @see memoMetaclass.MemoMetaclassPackage#getWorld_Population()
	 * @model containment="true"
	 * @generated
	 */
	EList<Person> getPopulation();

	/**
	 * Returns the value of the '<em><b>Automobiles</b></em>' containment reference list.
	 * The list contents are of type {@link memoMetaclass.Automobile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automobiles</em>' containment reference list.
	 * @see memoMetaclass.MemoMetaclassPackage#getWorld_Automobiles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Automobile> getAutomobiles();

} // World
