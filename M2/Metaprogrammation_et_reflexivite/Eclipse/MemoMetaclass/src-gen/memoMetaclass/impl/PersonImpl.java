/**
 */
package memoMetaclass.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import memoMetaclass.Automobile;
import memoMetaclass.MemoMetaclassPackage;
import memoMetaclass.Person;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link memoMetaclass.impl.PersonImpl#getAge <em>Age</em>}</li>
 *   <li>{@link memoMetaclass.impl.PersonImpl#getAutomobiles <em>Automobiles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonImpl extends NamedElementImpl implements Person {
	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected int age = AGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAutomobiles() <em>Automobiles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutomobiles()
	 * @generated
	 * @ordered
	 */
	protected EList<Automobile> automobiles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MemoMetaclassPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAge() {
		return age;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAge(int newAge) {
		int oldAge = age;
		age = newAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoMetaclassPackage.PERSON__AGE, oldAge, age));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Automobile> getAutomobiles() {
		if (automobiles == null) {
			automobiles = new EObjectResolvingEList<Automobile>(Automobile.class, this,
					MemoMetaclassPackage.PERSON__AUTOMOBILES);
		}
		return automobiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void birthday()
	{
		age++;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MemoMetaclassPackage.PERSON__AGE:
			return getAge();
		case MemoMetaclassPackage.PERSON__AUTOMOBILES:
			return getAutomobiles();
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
		case MemoMetaclassPackage.PERSON__AGE:
			setAge((Integer) newValue);
			return;
		case MemoMetaclassPackage.PERSON__AUTOMOBILES:
			getAutomobiles().clear();
			getAutomobiles().addAll((Collection<? extends Automobile>) newValue);
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
		case MemoMetaclassPackage.PERSON__AGE:
			setAge(AGE_EDEFAULT);
			return;
		case MemoMetaclassPackage.PERSON__AUTOMOBILES:
			getAutomobiles().clear();
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
		case MemoMetaclassPackage.PERSON__AGE:
			return age != AGE_EDEFAULT;
		case MemoMetaclassPackage.PERSON__AUTOMOBILES:
			return automobiles != null && !automobiles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case MemoMetaclassPackage.PERSON___BIRTHDAY:
			birthday();
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (age: ");
		result.append(age);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
