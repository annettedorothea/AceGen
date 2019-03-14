/**
 * generated by Xtext 2.16.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.Verification#getAction <em>Action</em>}</li>
 *   <li>{@link de.acegen.aceGen.Verification#getDataDefinition <em>Data Definition</em>}</li>
 *   <li>{@link de.acegen.aceGen.Verification#getAuthorization <em>Authorization</em>}</li>
 *   <li>{@link de.acegen.aceGen.Verification#getResponse <em>Response</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getVerification()
 * @model
 * @generated
 */
public interface Verification extends EObject
{
  /**
   * Returns the value of the '<em><b>Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' reference.
   * @see #setAction(HttpServerAceRead)
   * @see de.acegen.aceGen.AceGenPackage#getVerification_Action()
   * @model
   * @generated
   */
  HttpServerAceRead getAction();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Verification#getAction <em>Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' reference.
   * @see #getAction()
   * @generated
   */
  void setAction(HttpServerAceRead value);

  /**
   * Returns the value of the '<em><b>Data Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Definition</em>' containment reference.
   * @see #setDataDefinition(DataDefinition)
   * @see de.acegen.aceGen.AceGenPackage#getVerification_DataDefinition()
   * @model containment="true"
   * @generated
   */
  DataDefinition getDataDefinition();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Verification#getDataDefinition <em>Data Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Definition</em>' containment reference.
   * @see #getDataDefinition()
   * @generated
   */
  void setDataDefinition(DataDefinition value);

  /**
   * Returns the value of the '<em><b>Authorization</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Authorization</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Authorization</em>' containment reference.
   * @see #setAuthorization(Authorization)
   * @see de.acegen.aceGen.AceGenPackage#getVerification_Authorization()
   * @model containment="true"
   * @generated
   */
  Authorization getAuthorization();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Verification#getAuthorization <em>Authorization</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Authorization</em>' containment reference.
   * @see #getAuthorization()
   * @generated
   */
  void setAuthorization(Authorization value);

  /**
   * Returns the value of the '<em><b>Response</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Response</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Response</em>' containment reference.
   * @see #setResponse(AttributeDefinitionList)
   * @see de.acegen.aceGen.AceGenPackage#getVerification_Response()
   * @model containment="true"
   * @generated
   */
  AttributeDefinitionList getResponse();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Verification#getResponse <em>Response</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Response</em>' containment reference.
   * @see #getResponse()
   * @generated
   */
  void setResponse(AttributeDefinitionList value);

} // Verification