/**
 * generated by Xtext 2.22.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.ClientAttribute;
import de.acegen.aceGen.Model;
import de.acegen.aceGen.SingleClientAttribute;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Client Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.SingleClientAttributeImpl#isNotNull <em>Not Null</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.SingleClientAttributeImpl#isList <em>List</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.SingleClientAttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.SingleClientAttributeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.SingleClientAttributeImpl#isHash <em>Hash</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.SingleClientAttributeImpl#isStorage <em>Storage</em>}</li>
 *   <li>{@link de.acegen.aceGen.impl.SingleClientAttributeImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleClientAttributeImpl extends ClientAttributeImpl implements SingleClientAttribute
{
  /**
   * The default value of the '{@link #isNotNull() <em>Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNotNull()
   * @generated
   * @ordered
   */
  protected static final boolean NOT_NULL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNotNull() <em>Not Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNotNull()
   * @generated
   * @ordered
   */
  protected boolean notNull = NOT_NULL_EDEFAULT;

  /**
   * The default value of the '{@link #isList() <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isList()
   * @generated
   * @ordered
   */
  protected static final boolean LIST_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isList() <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isList()
   * @generated
   * @ordered
   */
  protected boolean list = LIST_EDEFAULT;

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
   * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModel()
   * @generated
   * @ordered
   */
  protected Model model;

  /**
   * The default value of the '{@link #isHash() <em>Hash</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHash()
   * @generated
   * @ordered
   */
  protected static final boolean HASH_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHash() <em>Hash</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHash()
   * @generated
   * @ordered
   */
  protected boolean hash = HASH_EDEFAULT;

  /**
   * The default value of the '{@link #isStorage() <em>Storage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStorage()
   * @generated
   * @ordered
   */
  protected static final boolean STORAGE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStorage() <em>Storage</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStorage()
   * @generated
   * @ordered
   */
  protected boolean storage = STORAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<ClientAttribute> attributes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleClientAttributeImpl()
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
    return AceGenPackage.Literals.SINGLE_CLIENT_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isNotNull()
  {
    return notNull;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNotNull(boolean newNotNull)
  {
    boolean oldNotNull = notNull;
    notNull = newNotNull;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__NOT_NULL, oldNotNull, notNull));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isList()
  {
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setList(boolean newList)
  {
    boolean oldList = list;
    list = newList;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__LIST, oldList, list));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__TYPE, oldType, type));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__MODEL, oldModel, model));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__MODEL, oldModel, model));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isHash()
  {
    return hash;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setHash(boolean newHash)
  {
    boolean oldHash = hash;
    hash = newHash;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__HASH, oldHash, hash));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isStorage()
  {
    return storage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStorage(boolean newStorage)
  {
    boolean oldStorage = storage;
    storage = newStorage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__STORAGE, oldStorage, storage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ClientAttribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<ClientAttribute>(ClientAttribute.class, this, AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__ATTRIBUTES);
    }
    return attributes;
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
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__NOT_NULL:
        return isNotNull();
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__LIST:
        return isList();
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__TYPE:
        return getType();
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__MODEL:
        if (resolve) return getModel();
        return basicGetModel();
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__HASH:
        return isHash();
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__STORAGE:
        return isStorage();
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__ATTRIBUTES:
        return getAttributes();
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
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__NOT_NULL:
        setNotNull((Boolean)newValue);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__LIST:
        setList((Boolean)newValue);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__TYPE:
        setType((String)newValue);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__MODEL:
        setModel((Model)newValue);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__HASH:
        setHash((Boolean)newValue);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__STORAGE:
        setStorage((Boolean)newValue);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends ClientAttribute>)newValue);
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
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__NOT_NULL:
        setNotNull(NOT_NULL_EDEFAULT);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__LIST:
        setList(LIST_EDEFAULT);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__MODEL:
        setModel((Model)null);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__HASH:
        setHash(HASH_EDEFAULT);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__STORAGE:
        setStorage(STORAGE_EDEFAULT);
        return;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__ATTRIBUTES:
        getAttributes().clear();
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
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__NOT_NULL:
        return notNull != NOT_NULL_EDEFAULT;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__LIST:
        return list != LIST_EDEFAULT;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__MODEL:
        return model != null;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__HASH:
        return hash != HASH_EDEFAULT;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__STORAGE:
        return storage != STORAGE_EDEFAULT;
      case AceGenPackage.SINGLE_CLIENT_ATTRIBUTE__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
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
    result.append(" (notNull: ");
    result.append(notNull);
    result.append(", list: ");
    result.append(list);
    result.append(", type: ");
    result.append(type);
    result.append(", hash: ");
    result.append(hash);
    result.append(", storage: ");
    result.append(storage);
    result.append(')');
    return result.toString();
  }

} //SingleClientAttributeImpl
