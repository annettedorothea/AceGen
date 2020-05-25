/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.AuthUser;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerView;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.Scenario;

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
 * An implementation of the model object '<em><b>Http Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerImpl#getAuthUser <em>Auth User</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerImpl#getAuthUserRef <em>Auth User Ref</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerImpl#getAceOperations <em>Ace Operations</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerImpl#getViews <em>Views</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerImpl#getModels <em>Models</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerImpl#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpServerImpl extends MinimalEObjectImpl.Container implements HttpServer
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

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
   * The cached value of the '{@link #getAuthUser() <em>Auth User</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthUser()
   * @generated
   * @ordered
   */
  protected AuthUser authUser;

  /**
   * The cached value of the '{@link #getAuthUserRef() <em>Auth User Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthUserRef()
   * @generated
   * @ordered
   */
  protected AuthUser authUserRef;

  /**
   * The cached value of the '{@link #getAceOperations() <em>Ace Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAceOperations()
   * @generated
   * @ordered
   */
  protected EList<HttpServerAce> aceOperations;

  /**
   * The cached value of the '{@link #getViews() <em>Views</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getViews()
   * @generated
   * @ordered
   */
  protected EList<HttpServerView> views;

  /**
   * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModels()
   * @generated
   * @ordered
   */
  protected EList<Model> models;

  /**
   * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenarios()
   * @generated
   * @ordered
   */
  protected EList<Scenario> scenarios;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HttpServerImpl()
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
    return AceGenPackage.Literals.HTTP_SERVER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AuthUser getAuthUser()
  {
    return authUser;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAuthUser(AuthUser newAuthUser, NotificationChain msgs)
  {
    AuthUser oldAuthUser = authUser;
    authUser = newAuthUser;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER__AUTH_USER, oldAuthUser, newAuthUser);
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
  public void setAuthUser(AuthUser newAuthUser)
  {
    if (newAuthUser != authUser)
    {
      NotificationChain msgs = null;
      if (authUser != null)
        msgs = ((InternalEObject)authUser).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.HTTP_SERVER__AUTH_USER, null, msgs);
      if (newAuthUser != null)
        msgs = ((InternalEObject)newAuthUser).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AceGenPackage.HTTP_SERVER__AUTH_USER, null, msgs);
      msgs = basicSetAuthUser(newAuthUser, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER__AUTH_USER, newAuthUser, newAuthUser));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AuthUser getAuthUserRef()
  {
    if (authUserRef != null && authUserRef.eIsProxy())
    {
      InternalEObject oldAuthUserRef = (InternalEObject)authUserRef;
      authUserRef = (AuthUser)eResolveProxy(oldAuthUserRef);
      if (authUserRef != oldAuthUserRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.HTTP_SERVER__AUTH_USER_REF, oldAuthUserRef, authUserRef));
      }
    }
    return authUserRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AuthUser basicGetAuthUserRef()
  {
    return authUserRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAuthUserRef(AuthUser newAuthUserRef)
  {
    AuthUser oldAuthUserRef = authUserRef;
    authUserRef = newAuthUserRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER__AUTH_USER_REF, oldAuthUserRef, authUserRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<HttpServerAce> getAceOperations()
  {
    if (aceOperations == null)
    {
      aceOperations = new EObjectContainmentEList<HttpServerAce>(HttpServerAce.class, this, AceGenPackage.HTTP_SERVER__ACE_OPERATIONS);
    }
    return aceOperations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<HttpServerView> getViews()
  {
    if (views == null)
    {
      views = new EObjectContainmentEList<HttpServerView>(HttpServerView.class, this, AceGenPackage.HTTP_SERVER__VIEWS);
    }
    return views;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Model> getModels()
  {
    if (models == null)
    {
      models = new EObjectContainmentEList<Model>(Model.class, this, AceGenPackage.HTTP_SERVER__MODELS);
    }
    return models;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Scenario> getScenarios()
  {
    if (scenarios == null)
    {
      scenarios = new EObjectContainmentEList<Scenario>(Scenario.class, this, AceGenPackage.HTTP_SERVER__SCENARIOS);
    }
    return scenarios;
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
      case AceGenPackage.HTTP_SERVER__AUTH_USER:
        return basicSetAuthUser(null, msgs);
      case AceGenPackage.HTTP_SERVER__ACE_OPERATIONS:
        return ((InternalEList<?>)getAceOperations()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_SERVER__VIEWS:
        return ((InternalEList<?>)getViews()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_SERVER__MODELS:
        return ((InternalEList<?>)getModels()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_SERVER__SCENARIOS:
        return ((InternalEList<?>)getScenarios()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.HTTP_SERVER__TYPE:
        return getType();
      case AceGenPackage.HTTP_SERVER__NAME:
        return getName();
      case AceGenPackage.HTTP_SERVER__AUTH_USER:
        return getAuthUser();
      case AceGenPackage.HTTP_SERVER__AUTH_USER_REF:
        if (resolve) return getAuthUserRef();
        return basicGetAuthUserRef();
      case AceGenPackage.HTTP_SERVER__ACE_OPERATIONS:
        return getAceOperations();
      case AceGenPackage.HTTP_SERVER__VIEWS:
        return getViews();
      case AceGenPackage.HTTP_SERVER__MODELS:
        return getModels();
      case AceGenPackage.HTTP_SERVER__SCENARIOS:
        return getScenarios();
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
      case AceGenPackage.HTTP_SERVER__TYPE:
        setType((String)newValue);
        return;
      case AceGenPackage.HTTP_SERVER__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.HTTP_SERVER__AUTH_USER:
        setAuthUser((AuthUser)newValue);
        return;
      case AceGenPackage.HTTP_SERVER__AUTH_USER_REF:
        setAuthUserRef((AuthUser)newValue);
        return;
      case AceGenPackage.HTTP_SERVER__ACE_OPERATIONS:
        getAceOperations().clear();
        getAceOperations().addAll((Collection<? extends HttpServerAce>)newValue);
        return;
      case AceGenPackage.HTTP_SERVER__VIEWS:
        getViews().clear();
        getViews().addAll((Collection<? extends HttpServerView>)newValue);
        return;
      case AceGenPackage.HTTP_SERVER__MODELS:
        getModels().clear();
        getModels().addAll((Collection<? extends Model>)newValue);
        return;
      case AceGenPackage.HTTP_SERVER__SCENARIOS:
        getScenarios().clear();
        getScenarios().addAll((Collection<? extends Scenario>)newValue);
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
      case AceGenPackage.HTTP_SERVER__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER__AUTH_USER:
        setAuthUser((AuthUser)null);
        return;
      case AceGenPackage.HTTP_SERVER__AUTH_USER_REF:
        setAuthUserRef((AuthUser)null);
        return;
      case AceGenPackage.HTTP_SERVER__ACE_OPERATIONS:
        getAceOperations().clear();
        return;
      case AceGenPackage.HTTP_SERVER__VIEWS:
        getViews().clear();
        return;
      case AceGenPackage.HTTP_SERVER__MODELS:
        getModels().clear();
        return;
      case AceGenPackage.HTTP_SERVER__SCENARIOS:
        getScenarios().clear();
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
      case AceGenPackage.HTTP_SERVER__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case AceGenPackage.HTTP_SERVER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.HTTP_SERVER__AUTH_USER:
        return authUser != null;
      case AceGenPackage.HTTP_SERVER__AUTH_USER_REF:
        return authUserRef != null;
      case AceGenPackage.HTTP_SERVER__ACE_OPERATIONS:
        return aceOperations != null && !aceOperations.isEmpty();
      case AceGenPackage.HTTP_SERVER__VIEWS:
        return views != null && !views.isEmpty();
      case AceGenPackage.HTTP_SERVER__MODELS:
        return models != null && !models.isEmpty();
      case AceGenPackage.HTTP_SERVER__SCENARIOS:
        return scenarios != null && !scenarios.isEmpty();
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
    result.append(" (type: ");
    result.append(type);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //HttpServerImpl
