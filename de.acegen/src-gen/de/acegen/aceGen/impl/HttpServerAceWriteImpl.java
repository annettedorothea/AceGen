/**
 * generated by Xtext 2.22.0
 */
package de.acegen.aceGen.impl;

import de.acegen.aceGen.AceGenPackage;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.HttpServerOutcome;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Http Server Ace Write</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.impl.HttpServerAceWriteImpl#getOutcomes <em>Outcomes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpServerAceWriteImpl extends HttpServerAceImpl implements HttpServerAceWrite
{
  /**
   * The cached value of the '{@link #getOutcomes() <em>Outcomes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutcomes()
   * @generated
   * @ordered
   */
  protected EList<HttpServerOutcome> outcomes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HttpServerAceWriteImpl()
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
    return AceGenPackage.Literals.HTTP_SERVER_ACE_WRITE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<HttpServerOutcome> getOutcomes()
  {
    if (outcomes == null)
    {
      outcomes = new EObjectContainmentEList<HttpServerOutcome>(HttpServerOutcome.class, this, AceGenPackage.HTTP_SERVER_ACE_WRITE__OUTCOMES);
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
      case AceGenPackage.HTTP_SERVER_ACE_WRITE__OUTCOMES:
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
      case AceGenPackage.HTTP_SERVER_ACE_WRITE__OUTCOMES:
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
      case AceGenPackage.HTTP_SERVER_ACE_WRITE__OUTCOMES:
        getOutcomes().clear();
        getOutcomes().addAll((Collection<? extends HttpServerOutcome>)newValue);
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
      case AceGenPackage.HTTP_SERVER_ACE_WRITE__OUTCOMES:
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
      case AceGenPackage.HTTP_SERVER_ACE_WRITE__OUTCOMES:
        return outcomes != null && !outcomes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //HttpServerAceWriteImpl
