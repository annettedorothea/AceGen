/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.AttributeParamRef;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.Model;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Http Server Ace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#isProxy <em>Proxy</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#getModel <em>Model</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#isAuthorize <em>Authorize</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#getPathParams <em>Path Params</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#getQueryParams <em>Query Params</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#getPayload <em>Payload</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceImpl#getResponse <em>Response</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpServerAceImpl extends MinimalEObjectImpl.Container implements HttpServerAce
{
  /**
   * The default value of the '{@link #isProxy() <em>Proxy</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isProxy()
   * @generated
   * @ordered
   */
  protected static final boolean PROXY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isProxy() <em>Proxy</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isProxy()
   * @generated
   * @ordered
   */
  protected boolean proxy = PROXY_EDEFAULT;

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
   * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModel()
   * @generated
   * @ordered
   */
  protected Model model;

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
   * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrl()
   * @generated
   * @ordered
   */
  protected static final String URL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrl()
   * @generated
   * @ordered
   */
  protected String url = URL_EDEFAULT;

  /**
   * The default value of the '{@link #isAuthorize() <em>Authorize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAuthorize()
   * @generated
   * @ordered
   */
  protected static final boolean AUTHORIZE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAuthorize() <em>Authorize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAuthorize()
   * @generated
   * @ordered
   */
  protected boolean authorize = AUTHORIZE_EDEFAULT;

  /**
   * The cached value of the '{@link #getPathParams() <em>Path Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPathParams()
   * @generated
   * @ordered
   */
  protected EList<AttributeParamRef> pathParams;

  /**
   * The cached value of the '{@link #getQueryParams() <em>Query Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQueryParams()
   * @generated
   * @ordered
   */
  protected EList<AttributeParamRef> queryParams;

  /**
   * The cached value of the '{@link #getPayload() <em>Payload</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPayload()
   * @generated
   * @ordered
   */
  protected EList<AttributeParamRef> payload;

  /**
   * The cached value of the '{@link #getResponse() <em>Response</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResponse()
   * @generated
   * @ordered
   */
  protected EList<Attribute> response;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HttpServerAceImpl()
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
    return AceGenPackage.Literals.HTTP_SERVER_ACE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isProxy()
  {
    return proxy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProxy(boolean newProxy)
  {
    boolean oldProxy = proxy;
    proxy = newProxy;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER_ACE__PROXY, oldProxy, proxy));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER_ACE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Model getModel()
  {
    if (model != null && model.eIsProxy())
    {
      InternalEObject oldModel = (InternalEObject)model;
      model = (Model)eResolveProxy(oldModel);
      if (model != oldModel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.HTTP_SERVER_ACE__MODEL, oldModel, model));
      }
    }
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model basicGetModel()
  {
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setModel(Model newModel)
  {
    Model oldModel = model;
    model = newModel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER_ACE__MODEL, oldModel, model));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER_ACE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getUrl()
  {
    return url;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUrl(String newUrl)
  {
    String oldUrl = url;
    url = newUrl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER_ACE__URL, oldUrl, url));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAuthorize()
  {
    return authorize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAuthorize(boolean newAuthorize)
  {
    boolean oldAuthorize = authorize;
    authorize = newAuthorize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.HTTP_SERVER_ACE__AUTHORIZE, oldAuthorize, authorize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AttributeParamRef> getPathParams()
  {
    if (pathParams == null)
    {
      pathParams = new EObjectContainmentEList<AttributeParamRef>(AttributeParamRef.class, this, AceGenPackage.HTTP_SERVER_ACE__PATH_PARAMS);
    }
    return pathParams;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AttributeParamRef> getQueryParams()
  {
    if (queryParams == null)
    {
      queryParams = new EObjectContainmentEList<AttributeParamRef>(AttributeParamRef.class, this, AceGenPackage.HTTP_SERVER_ACE__QUERY_PARAMS);
    }
    return queryParams;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AttributeParamRef> getPayload()
  {
    if (payload == null)
    {
      payload = new EObjectContainmentEList<AttributeParamRef>(AttributeParamRef.class, this, AceGenPackage.HTTP_SERVER_ACE__PAYLOAD);
    }
    return payload;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Attribute> getResponse()
  {
    if (response == null)
    {
      response = new EObjectResolvingEList<Attribute>(Attribute.class, this, AceGenPackage.HTTP_SERVER_ACE__RESPONSE);
    }
    return response;
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
      case AceGenPackage.HTTP_SERVER_ACE__PATH_PARAMS:
        return ((InternalEList<?>)getPathParams()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_SERVER_ACE__QUERY_PARAMS:
        return ((InternalEList<?>)getQueryParams()).basicRemove(otherEnd, msgs);
      case AceGenPackage.HTTP_SERVER_ACE__PAYLOAD:
        return ((InternalEList<?>)getPayload()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.HTTP_SERVER_ACE__PROXY:
        return isProxy();
      case AceGenPackage.HTTP_SERVER_ACE__NAME:
        return getName();
      case AceGenPackage.HTTP_SERVER_ACE__MODEL:
        if (resolve) return getModel();
        return basicGetModel();
      case AceGenPackage.HTTP_SERVER_ACE__TYPE:
        return getType();
      case AceGenPackage.HTTP_SERVER_ACE__URL:
        return getUrl();
      case AceGenPackage.HTTP_SERVER_ACE__AUTHORIZE:
        return isAuthorize();
      case AceGenPackage.HTTP_SERVER_ACE__PATH_PARAMS:
        return getPathParams();
      case AceGenPackage.HTTP_SERVER_ACE__QUERY_PARAMS:
        return getQueryParams();
      case AceGenPackage.HTTP_SERVER_ACE__PAYLOAD:
        return getPayload();
      case AceGenPackage.HTTP_SERVER_ACE__RESPONSE:
        return getResponse();
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
      case AceGenPackage.HTTP_SERVER_ACE__PROXY:
        setProxy((Boolean)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__NAME:
        setName((String)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__MODEL:
        setModel((Model)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__TYPE:
        setType((String)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__URL:
        setUrl((String)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__AUTHORIZE:
        setAuthorize((Boolean)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__PATH_PARAMS:
        getPathParams().clear();
        getPathParams().addAll((Collection<? extends AttributeParamRef>)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__QUERY_PARAMS:
        getQueryParams().clear();
        getQueryParams().addAll((Collection<? extends AttributeParamRef>)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__PAYLOAD:
        getPayload().clear();
        getPayload().addAll((Collection<? extends AttributeParamRef>)newValue);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__RESPONSE:
        getResponse().clear();
        getResponse().addAll((Collection<? extends Attribute>)newValue);
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
      case AceGenPackage.HTTP_SERVER_ACE__PROXY:
        setProxy(PROXY_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__MODEL:
        setModel((Model)null);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__URL:
        setUrl(URL_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__AUTHORIZE:
        setAuthorize(AUTHORIZE_EDEFAULT);
        return;
      case AceGenPackage.HTTP_SERVER_ACE__PATH_PARAMS:
        getPathParams().clear();
        return;
      case AceGenPackage.HTTP_SERVER_ACE__QUERY_PARAMS:
        getQueryParams().clear();
        return;
      case AceGenPackage.HTTP_SERVER_ACE__PAYLOAD:
        getPayload().clear();
        return;
      case AceGenPackage.HTTP_SERVER_ACE__RESPONSE:
        getResponse().clear();
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
      case AceGenPackage.HTTP_SERVER_ACE__PROXY:
        return proxy != PROXY_EDEFAULT;
      case AceGenPackage.HTTP_SERVER_ACE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AceGenPackage.HTTP_SERVER_ACE__MODEL:
        return model != null;
      case AceGenPackage.HTTP_SERVER_ACE__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case AceGenPackage.HTTP_SERVER_ACE__URL:
        return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
      case AceGenPackage.HTTP_SERVER_ACE__AUTHORIZE:
        return authorize != AUTHORIZE_EDEFAULT;
      case AceGenPackage.HTTP_SERVER_ACE__PATH_PARAMS:
        return pathParams != null && !pathParams.isEmpty();
      case AceGenPackage.HTTP_SERVER_ACE__QUERY_PARAMS:
        return queryParams != null && !queryParams.isEmpty();
      case AceGenPackage.HTTP_SERVER_ACE__PAYLOAD:
        return payload != null && !payload.isEmpty();
      case AceGenPackage.HTTP_SERVER_ACE__RESPONSE:
        return response != null && !response.isEmpty();
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
    result.append(" (proxy: ");
    result.append(proxy);
    result.append(", name: ");
    result.append(name);
    result.append(", type: ");
    result.append(type);
    result.append(", url: ");
    result.append(url);
    result.append(", authorize: ");
    result.append(authorize);
    result.append(')');
    return result.toString();
  }

} //HttpServerAceImpl
