/**
 * generated by Xtext 2.22.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.AttributeAndValue;
import de.acegen.aceGen.SelectByExpectation;
import de.acegen.aceGen.SelectByUniqueAttribute;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Select By Unique Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.SelectByUniqueAttributeImpl#getAttributeAndValue <em>Attribute And Value</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.SelectByUniqueAttributeImpl#getExpected <em>Expected</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectByUniqueAttributeImpl extends PersistenceVerificationExpressionImpl implements SelectByUniqueAttribute
{
  /**
   * The cached value of the '{@link #getAttributeAndValue() <em>Attribute And Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeAndValue()
   * @generated
   * @ordered
   */
  protected AttributeAndValue attributeAndValue;

  /**
   * The cached value of the '{@link #getExpected() <em>Expected</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpected()
   * @generated
   * @ordered
   */
  protected SelectByExpectation expected;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelectByUniqueAttributeImpl()
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
    return AceGenPackage.Literals.SELECT_BY_UNIQUE_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AttributeAndValue getAttributeAndValue()
  {
    return attributeAndValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAttributeAndValue(AttributeAndValue newAttributeAndValue, NotificationChain msgs)
  {
    AttributeAndValue oldAttributeAndValue = attributeAndValue;
    attributeAndValue = newAttributeAndValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__ATTRIBUTE_AND_VALUE, oldAttributeAndValue, newAttributeAndValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAttributeAndValue(AttributeAndValue newAttributeAndValue)
  {
    if (newAttributeAndValue != attributeAndValue)
    {
      NotificationChain msgs = null;
      if (attributeAndValue != null)
        msgs = ((InternalEObject)attributeAndValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__ATTRIBUTE_AND_VALUE, null, msgs);
      if (newAttributeAndValue != null)
        msgs = ((InternalEObject)newAttributeAndValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__ATTRIBUTE_AND_VALUE, null, msgs);
      msgs = basicSetAttributeAndValue(newAttributeAndValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__ATTRIBUTE_AND_VALUE, newAttributeAndValue, newAttributeAndValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SelectByExpectation getExpected()
  {
    return expected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpected(SelectByExpectation newExpected, NotificationChain msgs)
  {
    SelectByExpectation oldExpected = expected;
    expected = newExpected;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__EXPECTED, oldExpected, newExpected);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpected(SelectByExpectation newExpected)
  {
    if (newExpected != expected)
    {
      NotificationChain msgs = null;
      if (expected != null)
        msgs = ((InternalEObject)expected).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__EXPECTED, null, msgs);
      if (newExpected != null)
        msgs = ((InternalEObject)newExpected).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__EXPECTED, null, msgs);
      msgs = basicSetExpected(newExpected, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__EXPECTED, newExpected, newExpected));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__ATTRIBUTE_AND_VALUE:
        return basicSetAttributeAndValue(null, msgs);
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__EXPECTED:
        return basicSetExpected(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__ATTRIBUTE_AND_VALUE:
        return getAttributeAndValue();
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__EXPECTED:
        return getExpected();
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
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__ATTRIBUTE_AND_VALUE:
        setAttributeAndValue((AttributeAndValue)newValue);
        return;
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__EXPECTED:
        setExpected((SelectByExpectation)newValue);
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
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__ATTRIBUTE_AND_VALUE:
        setAttributeAndValue((AttributeAndValue)null);
        return;
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__EXPECTED:
        setExpected((SelectByExpectation)null);
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
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__ATTRIBUTE_AND_VALUE:
        return attributeAndValue != null;
      case AceGenPackage.SELECT_BY_UNIQUE_ATTRIBUTE__EXPECTED:
        return expected != null;
    }
    return super.eIsSet(featureID);
  }

} //SelectByUniqueAttributeImpl
