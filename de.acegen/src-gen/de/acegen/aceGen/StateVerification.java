/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Verification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.StateVerification#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.StateVerification#getStateRef <em>State Ref</em>}</li>
 *   <li>{@link de.acegen.aceGen.StateVerification#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getStateVerification()
 * @model
 * @generated
 */
public interface StateVerification extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getStateVerification_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.StateVerification#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>State Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Ref</em>' reference.
   * @see #setStateRef(SingleClientAttribute)
   * @see de.acegen.aceGen.AceGenPackage#getStateVerification_StateRef()
   * @model
   * @generated
   */
  SingleClientAttribute getStateRef();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.StateVerification#getStateRef <em>State Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Ref</em>' reference.
   * @see #getStateRef()
   * @generated
   */
  void setStateRef(SingleClientAttribute value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(JsonValueClient)
   * @see de.acegen.aceGen.AceGenPackage#getStateVerification_Value()
   * @model containment="true"
   * @generated
   */
  JsonValueClient getValue();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.StateVerification#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(JsonValueClient value);

} // StateVerification
