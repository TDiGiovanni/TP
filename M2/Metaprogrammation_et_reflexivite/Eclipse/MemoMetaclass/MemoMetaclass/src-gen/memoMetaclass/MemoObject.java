/**
 */
package memoMetaclass;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Memo Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link memoMetaclass.MemoObject#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @see memoMetaclass.MemoMetaclassPackage#getMemoObject()
 * @model abstract="true"
 * @generated
 */
public interface MemoObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' attribute list.
	 * @see memoMetaclass.MemoMetaclassPackage#getMemoObject_Instances()
	 * @model derived="true"
	 * @generated
	 */
	EList<Object> getInstances();

} // MemoObject
