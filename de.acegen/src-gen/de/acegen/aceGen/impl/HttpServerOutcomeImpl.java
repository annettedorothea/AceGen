/**
 * generated by Xtext 2.14.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;
import de.acegen.aceGen.HttpServerViewFunction;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Http Server Outcome</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerOutcomeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerOutcomeImpl#getListeners <em>Listeners</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerOutcomeImpl#getAceOperations <em>Ace Operations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpServerOutcomeImpl extends MinimalEObjectImpl.Container implements HttpServerOutcome
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
   * The cached value of the '{@link #getListeners() <em>Listeners</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getListeners()
   * @generated
   * @ordered
   */
  protected EList<HttpServerViewFunction> listeners;

  /**
   * The cached value of the '{@link #getAceOperations() <em>Ace Operations</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAceOperations()
   * @generated
   * @ordered
   */
  protected EList<HttpServerAceWrite> aceOperations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HttpServerOutcomeImpl()
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
    return AceGenPackage.Literals.HTTP_SERVER_OUTCOME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER_OUTCOME__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<HttpServerViewFunction> getListeners()
  {
    if (listeners == null)
    {
      listeners = new EObjectResolvingEList<HttpServerViewFunction>(HttpServerViewFunction.class, this, AceGenPackage.HTTP_SERVER_OUTCOME__LISTENERS);
    }
    return listeners;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<HttpServerAceWrite> getAceOperations()
  {
    if (aceOperations == null)
    {
      aceOperations = new EObjectResolvingEList<HttpServerAceWrite>(HttpServerAceWrite.class, this, AceGenPackage.HTTP_SERVER_OUTCOME__ACE_OPERATIONS);
    }
    return aceOperations;
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
      case AceGenPackage.HTTP_SERVER_OUTCOME__NAME:
        return getName();
      case AceGenPackage.HTTP_SERVER_OUTCOME__LISTENERS:
        return getListeners();
      case AceGenPackage.HTTP_SERVER_OUTCOME__ACE_OPERATIONS:
        return getAceOperations();
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
      case AceGenPackage.HTTP_SERVER_OUTCOME__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_OUTCOME__LISTENERS:
        getListeners().clear();
        getListeners().addAll((Collection<? extends HttpServerViewFunction>)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_OUTCOME__ACE_OPERATIONS:
        getAceOperations().clear();
        getAceOperations().addAll((Collection<? extends HttpServerAceWrite>)newValue);
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
      case AceGenPackage.HTTP_SERVER_OUTCOME__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER_OUTCOME__LISTENERS:
        getListeners().clear();
        return;
      case AceGenPackage.HTTP_SERVER_OUTCOME__ACE_OPERATIONS:
        getAceOperations().clear();
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
      case AceGenPackage.HTTP_SERVER_OUTCOME__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.HTTP_SERVER_OUTCOME__LISTENERS:
        return listeners != null && !listeners.isEmpty();
      case AceGenPackage.HTTP_SERVER_OUTCOME__ACE_OPERATIONS:
        return aceOperations != null && !aceOperations.isEmpty();
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

} //HttpServerOutcomeImpl