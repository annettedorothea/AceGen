/**
 * generated by Xtext 2.22.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.InputValue;
import de.acegen.aceGen.TriggeredAction;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Triggered Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.TriggeredActionImpl#getHttpClientAce <em>Http Client Ace</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.TriggeredActionImpl#getInputValues <em>Input Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TriggeredActionImpl extends MinimalEObjectImpl.Container implements TriggeredAction
{
  /**
   * The cached value of the '{@link #getHttpClientAce() <em>Http Client Ace</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHttpClientAce()
   * @generated
   * @ordered
   */
  protected HttpClientAce httpClientAce;

  /**
   * The cached value of the '{@link #getInputValues() <em>Input Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputValues()
   * @generated
   * @ordered
   */
  protected EList<InputValue> inputValues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TriggeredActionImpl()
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
    return AceGenPackage.Literals.TRIGGERED_ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpClientAce getHttpClientAce()
  {
    if (httpClientAce != null && httpClientAce.eIsProxy())
    {
      InternalEObject oldHttpClientAce = (InternalEObject)httpClientAce;
      httpClientAce = (HttpClientAce)eResolveProxy(oldHttpClientAce);
      if (httpClientAce != oldHttpClientAce)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.TRIGGERED_ACTION__HTTP_CLIENT_ACE, oldHttpClientAce, httpClientAce));
      }
    }
    return httpClientAce;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HttpClientAce basicGetHttpClientAce()
  {
    return httpClientAce;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setHttpClientAce(HttpClientAce newHttpClientAce)
  {
    HttpClientAce oldHttpClientAce = httpClientAce;
    httpClientAce = newHttpClientAce;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.TRIGGERED_ACTION__HTTP_CLIENT_ACE, oldHttpClientAce, httpClientAce));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InputValue> getInputValues()
  {
    if (inputValues == null)
    {
      inputValues = new EObjectContainmentEList<InputValue>(InputValue.class, this, AceGenPackage.TRIGGERED_ACTION__INPUT_VALUES);
    }
    return inputValues;
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
      case AceGenPackage.TRIGGERED_ACTION__INPUT_VALUES:
        return ((InternalEList<?>)getInputValues()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.TRIGGERED_ACTION__HTTP_CLIENT_ACE:
        if (resolve) return getHttpClientAce();
        return basicGetHttpClientAce();
      case AceGenPackage.TRIGGERED_ACTION__INPUT_VALUES:
        return getInputValues();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AceGenPackage.TRIGGERED_ACTION__HTTP_CLIENT_ACE:
        setHttpClientAce((HttpClientAce)newValue);
        return;
      case AceGenPackage.TRIGGERED_ACTION__INPUT_VALUES:
        getInputValues().clear();
        getInputValues().addAll((Collection<? extends InputValue>)newValue);
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
      case AceGenPackage.TRIGGERED_ACTION__HTTP_CLIENT_ACE:
        setHttpClientAce((HttpClientAce)null);
        return;
      case AceGenPackage.TRIGGERED_ACTION__INPUT_VALUES:
        getInputValues().clear();
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
      case AceGenPackage.TRIGGERED_ACTION__HTTP_CLIENT_ACE:
        return httpClientAce != null;
      case AceGenPackage.TRIGGERED_ACTION__INPUT_VALUES:
        return inputValues != null && !inputValues.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TriggeredActionImpl
