/**
 * generated by Xtext 2.24.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Client</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpClient#isReact16_8 <em>React16 8</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClient#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClient#getAceOperations <em>Ace Operations</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClient#getContainer <em>Container</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClient#getScenarios <em>Scenarios</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpClient()
 * @model
 * @generated
 */
public interface HttpClient extends EObject
{
  /**
   * Returns the value of the '<em><b>React16 8</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>React16 8</em>' attribute.
   * @see #setReact16_8(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClient_React16_8()
   * @model
   * @generated
   */
  boolean isReact16_8();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClient#isReact16_8 <em>React16 8</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>React16 8</em>' attribute.
   * @see #isReact16_8()
   * @generated
   */
  void setReact16_8(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClient_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClient#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Ace Operations</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpClientAce}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ace Operations</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClient_AceOperations()
   * @model containment="true"
   * @generated
   */
  EList<HttpClientAce> getAceOperations();

  /**
   * Returns the value of the '<em><b>Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Container</em>' containment reference.
   * @see #setContainer(SingleClientAttribute)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClient_Container()
   * @model containment="true"
   * @generated
   */
  SingleClientAttribute getContainer();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClient#getContainer <em>Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Container</em>' containment reference.
   * @see #getContainer()
   * @generated
   */
  void setContainer(SingleClientAttribute value);

  /**
   * Returns the value of the '<em><b>Scenarios</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.ClientScenario}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenarios</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClient_Scenarios()
   * @model containment="true"
   * @generated
   */
  EList<ClientScenario> getScenarios();

} // HttpClient
