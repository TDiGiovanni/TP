/**
 */
package memoMetaclass.impl;

import java.util.Collection;

import memoMetaclass.MemoMetaclassPackage;
import memoMetaclass.MemoObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memo Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link memoMetaclass.impl.MemoObjectImpl#getInstances <em>Instances</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MemoObjectImpl extends MinimalEObjectImpl.Container implements MemoObject {
	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated NOT
	 * @ordered
	 */
	protected static EList<Object> instances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MemoObjectImpl() {
		super();
		getInstances().add(this);
		System.out.println("New instance of MemoObject created.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MemoMetaclassPackage.Literals.MEMO_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getInstances() {
		if (instances == null) {
			instances = new EDataTypeUniqueEList<Object>(Object.class, this,
					MemoMetaclassPackage.MEMO_OBJECT__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MemoMetaclassPackage.MEMO_OBJECT__INSTANCES:
			return getInstances();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MemoMetaclassPackage.MEMO_OBJECT__INSTANCES:
			getInstances().clear();
			getInstances().addAll((Collection<? extends Object>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MemoMetaclassPackage.MEMO_OBJECT__INSTANCES:
			getInstances().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MemoMetaclassPackage.MEMO_OBJECT__INSTANCES:
			return instances != null && !instances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		//result.append(" (instances: ");
		//result.append(instances);
		result.append(')');
		return result.toString();
	}

} //MemoObjectImpl
