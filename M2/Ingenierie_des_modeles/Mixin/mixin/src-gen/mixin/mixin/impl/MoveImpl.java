/**
 * generated by Xtext 2.19.0
 */
package mixin.mixin.impl;

import mixin.mixin.MixinPackage;
import mixin.mixin.Move;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Move</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mixin.mixin.impl.MoveImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link mixin.mixin.impl.MoveImpl#getSourceCup <em>Source Cup</em>}</li>
 *   <li>{@link mixin.mixin.impl.MoveImpl#getDestinationCup <em>Destination Cup</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MoveImpl extends InstructionImpl implements Move
{
  /**
   * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuantity()
   * @generated
   * @ordered
   */
  protected static final int QUANTITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuantity()
   * @generated
   * @ordered
   */
  protected int quantity = QUANTITY_EDEFAULT;

  /**
   * The default value of the '{@link #getSourceCup() <em>Source Cup</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceCup()
   * @generated
   * @ordered
   */
  protected static final int SOURCE_CUP_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSourceCup() <em>Source Cup</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceCup()
   * @generated
   * @ordered
   */
  protected int sourceCup = SOURCE_CUP_EDEFAULT;

  /**
   * The default value of the '{@link #getDestinationCup() <em>Destination Cup</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestinationCup()
   * @generated
   * @ordered
   */
  protected static final int DESTINATION_CUP_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDestinationCup() <em>Destination Cup</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestinationCup()
   * @generated
   * @ordered
   */
  protected int destinationCup = DESTINATION_CUP_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MoveImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MixinPackage.Literals.MOVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getQuantity()
  {
    return quantity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQuantity(int newQuantity)
  {
    int oldQuantity = quantity;
    quantity = newQuantity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MixinPackage.MOVE__QUANTITY, oldQuantity, quantity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getSourceCup()
  {
    return sourceCup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSourceCup(int newSourceCup)
  {
    int oldSourceCup = sourceCup;
    sourceCup = newSourceCup;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MixinPackage.MOVE__SOURCE_CUP, oldSourceCup, sourceCup));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getDestinationCup()
  {
    return destinationCup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDestinationCup(int newDestinationCup)
  {
    int oldDestinationCup = destinationCup;
    destinationCup = newDestinationCup;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MixinPackage.MOVE__DESTINATION_CUP, oldDestinationCup, destinationCup));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MixinPackage.MOVE__QUANTITY:
        return getQuantity();
      case MixinPackage.MOVE__SOURCE_CUP:
        return getSourceCup();
      case MixinPackage.MOVE__DESTINATION_CUP:
        return getDestinationCup();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MixinPackage.MOVE__QUANTITY:
        setQuantity((Integer)newValue);
        return;
      case MixinPackage.MOVE__SOURCE_CUP:
        setSourceCup((Integer)newValue);
        return;
      case MixinPackage.MOVE__DESTINATION_CUP:
        setDestinationCup((Integer)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MixinPackage.MOVE__QUANTITY:
        setQuantity(QUANTITY_EDEFAULT);
        return;
      case MixinPackage.MOVE__SOURCE_CUP:
        setSourceCup(SOURCE_CUP_EDEFAULT);
        return;
      case MixinPackage.MOVE__DESTINATION_CUP:
        setDestinationCup(DESTINATION_CUP_EDEFAULT);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MixinPackage.MOVE__QUANTITY:
        return quantity != QUANTITY_EDEFAULT;
      case MixinPackage.MOVE__SOURCE_CUP:
        return sourceCup != SOURCE_CUP_EDEFAULT;
      case MixinPackage.MOVE__DESTINATION_CUP:
        return destinationCup != DESTINATION_CUP_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (quantity: ");
    result.append(quantity);
    result.append(", sourceCup: ");
    result.append(sourceCup);
    result.append(", destinationCup: ");
    result.append(destinationCup);
    result.append(')');
    return result.toString();
  }

} //MoveImpl
