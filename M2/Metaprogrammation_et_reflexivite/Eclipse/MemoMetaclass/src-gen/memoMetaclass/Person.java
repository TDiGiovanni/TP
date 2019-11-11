/**
 */
package memoMetaclass;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link memoMetaclass.Person#getAge <em>Age</em>}</li>
 *   <li>{@link memoMetaclass.Person#getAutomobiles <em>Automobiles</em>}</li>
 * </ul>
 *
 * @see memoMetaclass.MemoMetaclassPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see memoMetaclass.MemoMetaclassPackage#getPerson_Age()
	 * @model
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link memoMetaclass.Person#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Automobiles</b></em>' reference list.
	 * The list contents are of type {@link memoMetaclass.Automobile}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automobiles</em>' reference list.
	 * @see memoMetaclass.MemoMetaclassPackage#getPerson_Automobiles()
	 * @model
	 * @generated
	 */
	EList<Automobile> getAutomobiles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void birthday();

} // Person
