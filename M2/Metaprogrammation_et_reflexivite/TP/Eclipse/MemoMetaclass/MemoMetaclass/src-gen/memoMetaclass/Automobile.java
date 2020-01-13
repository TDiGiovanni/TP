/**
 */
package memoMetaclass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Automobile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link memoMetaclass.Automobile#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see memoMetaclass.MemoMetaclassPackage#getAutomobile()
 * @model
 * @generated
 */
public interface Automobile extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link memoMetaclass.AutomobileType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see memoMetaclass.AutomobileType
	 * @see #setType(AutomobileType)
	 * @see memoMetaclass.MemoMetaclassPackage#getAutomobile_Type()
	 * @model
	 * @generated
	 */
	AutomobileType getType();

	/**
	 * Sets the value of the '{@link memoMetaclass.Automobile#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see memoMetaclass.AutomobileType
	 * @see #getType()
	 * @generated
	 */
	void setType(AutomobileType value);

} // Automobile
