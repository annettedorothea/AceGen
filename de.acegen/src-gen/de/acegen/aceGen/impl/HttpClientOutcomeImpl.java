/**
 * generated by Xtext 2.25.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpClientStateFunction;
import de.acegen.aceGen.TriggerdAceOperation;

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
 * An implementation of the model object '<em><b>Http Client Outcome</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientOutcomeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientOutcomeImpl#getListeners <em>Listeners</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientOutcomeImpl#getTriggerdAceOperations <em>Triggerd Ace Operations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpClientOutcomeImpl extends MinimalEObjectImpl.Container implements HttpClientOutcome
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getListeners() <em>Listeners</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getListeners()
   * @generated
   * @ordered
   */
  protected EList<HttpClientStateFunction> listeners;

  /**
   * The cached value of the '{@link #getTriggerdAceOperations() <em>Triggerd Ace Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggerdAceOperations()
   * @generated
   * @ordered
   */
  protected EList<TriggerdAceOperation> triggerdAceOperations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HttpClientOutcomeImpl()
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
    return AceGenPackage.Literals.HTTP_CLIENT_OUTCOME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT_OUTCOME__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<HttpClientStateFunction> getListeners()
  {
    if (listeners == null)
    {
      listeners = new EObjectContainmentEList<HttpClientStateFunction>(HttpClientStateFunction.class, this, AceGenPackage.HTTP_CLIENT_OUTCOME__LISTENERS);
    }
    return listeners;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<TriggerdAceOperation> getTriggerdAceOperations()
  {
    if (triggerdAceOperations == null)
    {
      triggerdAceOperations = new EObjectContainmentEList<TriggerdAceOperation>(TriggerdAceOperation.class, this, AceGenPackage.HTTP_CLIENT_OUTCOME__TRIGGERD_ACE_OPERATIONS);
    }
    return triggerdAceOperations;
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
      case AceGenPackage.HTTP_CLIENT_OUTCOME__LISTENERS:
        return ((InternalEList<?>)getListeners()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_CLIENT_OUTCOME__TRIGGERD_ACE_OPERATIONS:
        return ((InternalEList<?>)getTriggerdAceOperations()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.HTTP_CLIENT_OUTCOME__NAME:
        return getName();
      case AceGenPackage.HTTP_CLIENT_OUTCOME__LISTENERS:
        return getListeners();
      case AceGenPackage.HTTP_CLIENT_OUTCOME__TRIGGERD_ACE_OPERATIONS:
        return getTriggerdAceOperations();
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
      case AceGenPackage.HTTP_CLIENT_OUTCOME__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_OUTCOME__LISTENERS:
        getListeners().clear();
        getListeners().addAll((Collection<? extends HttpClientStateFunction>)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_OUTCOME__TRIGGERD_ACE_OPERATIONS:
        getTriggerdAceOperations().clear();
        getTriggerdAceOperations().addAll((Collection<? extends TriggerdAceOperation>)newValue);
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
      case AceGenPackage.HTTP_CLIENT_OUTCOME__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.HTTP_CLIENT_OUTCOME__LISTENERS:
        getListeners().clear();
        return;
      case AceGenPackage.HTTP_CLIENT_OUTCOME__TRIGGERD_ACE_OPERATIONS:
        getTriggerdAceOperations().clear();
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
      case AceGenPackage.HTTP_CLIENT_OUTCOME__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.HTTP_CLIENT_OUTCOME__LISTENERS:
        return listeners != null && !listeners.isEmpty();
      case AceGenPackage.HTTP_CLIENT_OUTCOME__TRIGGERD_ACE_OPERATIONS:
        return triggerdAceOperations != null && !triggerdAceOperations.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //HttpClientOutcomeImpl
