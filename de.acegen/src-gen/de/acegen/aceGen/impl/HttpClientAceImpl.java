/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.FromAppStateRef;
import de.acegen.aceGen.HttpClientAce;
import de.acegen.aceGen.HttpClientOutcome;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.Input;
import de.acegen.aceGen.SingleClientAttribute;

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
 * An implementation of the model object '<em><b>Http Client Ace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientAceImpl#isAsync <em>Async</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientAceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientAceImpl#getInput <em>Input</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientAceImpl#getRefs <em>Refs</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientAceImpl#getServerCall <em>Server Call</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientAceImpl#getLoadingFlag <em>Loading Flag</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpClientAceImpl#getOutcomes <em>Outcomes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpClientAceImpl extends MinimalEObjectImpl.Container implements HttpClientAce
{
  /**
   * The default value of the '{@link #isAsync() <em>Async</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAsync()
   * @generated
   * @ordered
   */
  protected static final boolean ASYNC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAsync() <em>Async</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAsync()
   * @generated
   * @ordered
   */
  protected boolean async = ASYNC_EDEFAULT;

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
   * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInput()
   * @generated
   * @ordered
   */
  protected EList<Input> input;

  /**
   * The cached value of the '{@link #getRefs() <em>Refs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefs()
   * @generated
   * @ordered
   */
  protected EList<FromAppStateRef> refs;

  /**
   * The cached value of the '{@link #getServerCall() <em>Server Call</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServerCall()
   * @generated
   * @ordered
   */
  protected HttpServerAce serverCall;

  /**
   * The cached value of the '{@link #getLoadingFlag() <em>Loading Flag</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoadingFlag()
   * @generated
   * @ordered
   */
  protected SingleClientAttribute loadingFlag;

  /**
   * The cached value of the '{@link #getOutcomes() <em>Outcomes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutcomes()
   * @generated
   * @ordered
   */
  protected EList<HttpClientOutcome> outcomes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HttpClientAceImpl()
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
    return AceGenPackage.Literals.HTTP_CLIENT_ACE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAsync()
  {
    return async;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAsync(boolean newAsync)
  {
    boolean oldAsync = async;
    async = newAsync;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT_ACE__ASYNC, oldAsync, async));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT_ACE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Input> getInput()
  {
    if (input == null)
    {
      input = new EObjectContainmentEList<Input>(Input.class, this, AceGenPackage.HTTP_CLIENT_ACE__INPUT);
    }
    return input;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<FromAppStateRef> getRefs()
  {
    if (refs == null)
    {
      refs = new EObjectContainmentEList<FromAppStateRef>(FromAppStateRef.class, this, AceGenPackage.HTTP_CLIENT_ACE__REFS);
    }
    return refs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HttpServerAce getServerCall()
  {
    if (serverCall != null && serverCall.eIsProxy())
    {
      InternalEObject oldServerCall = (InternalEObject)serverCall;
      serverCall = (HttpServerAce)eResolveProxy(oldServerCall);
      if (serverCall != oldServerCall)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.HTTP_CLIENT_ACE__SERVER_CALL, oldServerCall, serverCall));
      }
    }
    return serverCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HttpServerAce basicGetServerCall()
  {
    return serverCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setServerCall(HttpServerAce newServerCall)
  {
    HttpServerAce oldServerCall = serverCall;
    serverCall = newServerCall;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT_ACE__SERVER_CALL, oldServerCall, serverCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SingleClientAttribute getLoadingFlag()
  {
    if (loadingFlag != null && loadingFlag.eIsProxy())
    {
      InternalEObject oldLoadingFlag = (InternalEObject)loadingFlag;
      loadingFlag = (SingleClientAttribute)eResolveProxy(oldLoadingFlag);
      if (loadingFlag != oldLoadingFlag)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.HTTP_CLIENT_ACE__LOADING_FLAG, oldLoadingFlag, loadingFlag));
      }
    }
    return loadingFlag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleClientAttribute basicGetLoadingFlag()
  {
    return loadingFlag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLoadingFlag(SingleClientAttribute newLoadingFlag)
  {
    SingleClientAttribute oldLoadingFlag = loadingFlag;
    loadingFlag = newLoadingFlag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_CLIENT_ACE__LOADING_FLAG, oldLoadingFlag, loadingFlag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<HttpClientOutcome> getOutcomes()
  {
    if (outcomes == null)
    {
      outcomes = new EObjectContainmentEList<HttpClientOutcome>(HttpClientOutcome.class, this, AceGenPackage.HTTP_CLIENT_ACE__OUTCOMES);
    }
    return outcomes;
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
      case AceGenPackage.HTTP_CLIENT_ACE__INPUT:
        return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_CLIENT_ACE__REFS:
        return ((InternalEList<?>)getRefs()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_CLIENT_ACE__OUTCOMES:
        return ((InternalEList<?>)getOutcomes()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.HTTP_CLIENT_ACE__ASYNC:
        return isAsync();
      case AceGenPackage.HTTP_CLIENT_ACE__NAME:
        return getName();
      case AceGenPackage.HTTP_CLIENT_ACE__INPUT:
        return getInput();
      case AceGenPackage.HTTP_CLIENT_ACE__REFS:
        return getRefs();
      case AceGenPackage.HTTP_CLIENT_ACE__SERVER_CALL:
        if (resolve) return getServerCall();
        return basicGetServerCall();
      case AceGenPackage.HTTP_CLIENT_ACE__LOADING_FLAG:
        if (resolve) return getLoadingFlag();
        return basicGetLoadingFlag();
      case AceGenPackage.HTTP_CLIENT_ACE__OUTCOMES:
        return getOutcomes();
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
      case AceGenPackage.HTTP_CLIENT_ACE__ASYNC:
        setAsync((Boolean)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__INPUT:
        getInput().clear();
        getInput().addAll((Collection<? extends Input>)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__REFS:
        getRefs().clear();
        getRefs().addAll((Collection<? extends FromAppStateRef>)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__SERVER_CALL:
        setServerCall((HttpServerAce)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__LOADING_FLAG:
        setLoadingFlag((SingleClientAttribute)newValue);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__OUTCOMES:
        getOutcomes().clear();
        getOutcomes().addAll((Collection<? extends HttpClientOutcome>)newValue);
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
      case AceGenPackage.HTTP_CLIENT_ACE__ASYNC:
        setAsync(ASYNC_EDEFAULT);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__INPUT:
        getInput().clear();
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__REFS:
        getRefs().clear();
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__SERVER_CALL:
        setServerCall((HttpServerAce)null);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__LOADING_FLAG:
        setLoadingFlag((SingleClientAttribute)null);
        return;
      case AceGenPackage.HTTP_CLIENT_ACE__OUTCOMES:
        getOutcomes().clear();
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
      case AceGenPackage.HTTP_CLIENT_ACE__ASYNC:
        return async != ASYNC_EDEFAULT;
      case AceGenPackage.HTTP_CLIENT_ACE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.HTTP_CLIENT_ACE__INPUT:
        return input != null && !input.isEmpty();
      case AceGenPackage.HTTP_CLIENT_ACE__REFS:
        return refs != null && !refs.isEmpty();
      case AceGenPackage.HTTP_CLIENT_ACE__SERVER_CALL:
        return serverCall != null;
      case AceGenPackage.HTTP_CLIENT_ACE__LOADING_FLAG:
        return loadingFlag != null;
      case AceGenPackage.HTTP_CLIENT_ACE__OUTCOMES:
        return outcomes != null && !outcomes.isEmpty();
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
    result.append(" (async: ");
    result.append(async);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //HttpClientAceImpl
