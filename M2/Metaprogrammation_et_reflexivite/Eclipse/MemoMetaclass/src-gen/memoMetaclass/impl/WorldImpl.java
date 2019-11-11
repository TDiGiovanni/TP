/**
 */
package memoMetaclass.impl;

import java.util.Collection;

import memoMetaclass.Automobile;
import memoMetaclass.MemoMetaclassPackage;
import memoMetaclass.Person;
import memoMetaclass.World;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link memoMetaclass.impl.WorldImpl#getPopulation <em>Population</em>}</li>
 *   <li>{@link memoMetaclass.impl.WorldImpl#getAutomobiles <em>Automobiles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorldImpl extends MemoObjectImpl implements World {
	/**
	 * The cached value of the '{@link #getPopulation() <em>Population</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPopulation()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> population;

	/**
	 * The cached value of the '{@link #getAutomobiles() <em>Automobiles</em>}' containment reference list.
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
	protected WorldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MemoMetaclassPackage.Literals.WORLD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getPopulation() {
		if (population == null) {
			population = new EObjectContainmentEList<Person>(Person.class, this,
					MemoMetaclassPackage.WORLD__POPULATION);
		}
		return population;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Automobile> getAutomobiles() {
		if (automobiles == null) {
			automobiles = new EObjectContainmentEList<Automobile>(Automobile.class, this,
					MemoMetaclassPackage.WORLD__AUTOMOBILES);
		}
		return automobiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MemoMetaclassPackage.WORLD__POPULATION:
			return ((InternalEList<?>) getPopulation()).basicRemove(otherEnd, msgs);
		case MemoMetaclassPackage.WORLD__AUTOMOBILES:
			return ((InternalEList<?>) getAutomobiles()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MemoMetaclassPackage.WORLD__POPULATION:
			return getPopulation();
		case MemoMetaclassPackage.WORLD__AUTOMOBILES:
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
		case MemoMetaclassPackage.WORLD__POPULATION:
			getPopulation().clear();
			getPopulation().addAll((Collection<? extends Person>) newValue);
			return;
		case MemoMetaclassPackage.WORLD__AUTOMOBILES:
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
		case MemoMetaclassPackage.WORLD__POPULATION:
			getPopulation().clear();
			return;
		case MemoMetaclassPackage.WORLD__AUTOMOBILES:
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
		case MemoMetaclassPackage.WORLD__POPULATION:
			return population != null && !population.isEmpty();
		case MemoMetaclassPackage.WORLD__AUTOMOBILES:
			return automobiles != null && !automobiles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WorldImpl
