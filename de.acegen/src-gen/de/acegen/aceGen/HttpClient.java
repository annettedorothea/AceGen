/**
 * generated by Xtext 2.22.0
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
 *   <li>{@link de.acegen.aceGen.HttpClient#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClient#getAceOperations <em>Ace Operations</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClient#isAppStatePresent <em>App State Present</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClient#getAppState <em>App State</em>}</li>
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
   * Returns the value of the '<em><b>App State Present</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>App State Present</em>' attribute.
   * @see #setAppStatePresent(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClient_AppStatePresent()
   * @model
   * @generated
   */
  boolean isAppStatePresent();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClient#isAppStatePresent <em>App State Present</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>App State Present</em>' attribute.
   * @see #isAppStatePresent()
   * @generated
   */
  void setAppStatePresent(boolean value);

  /**
   * Returns the value of the '<em><b>App State</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.ClientAttribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>App State</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClient_AppState()
   * @model containment="true"
   * @generated
   */
  EList<ClientAttribute> getAppState();

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
