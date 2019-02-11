/**
 * generated by Xtext 2.14.0
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
 *   <li>{@link de.acegen.aceGen.HttpClient#getAppState <em>App State</em>}</li>
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
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
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
   * <p>
   * If the meaning of the '<em>Ace Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ace Operations</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClient_AceOperations()
   * @model containment="true"
   * @generated
   */
  EList<HttpClientAce> getAceOperations();

  /**
   * Returns the value of the '<em><b>App State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>App State</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>App State</em>' containment reference.
   * @see #setAppState(HttpClientStateElement)
   * @see de.acegen.aceGen.AceGenPackage#getHttpClient_AppState()
   * @model containment="true"
   * @generated
   */
  HttpClientStateElement getAppState();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClient#getAppState <em>App State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>App State</em>' containment reference.
   * @see #getAppState()
   * @generated
   */
  void setAppState(HttpClientStateElement value);

} // HttpClient
