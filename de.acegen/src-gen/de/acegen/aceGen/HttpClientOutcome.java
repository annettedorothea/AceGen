/**
 * generated by Xtext 2.14.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Http Client Outcome</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.HttpClientOutcome#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientOutcome#getListeners <em>Listeners</em>}</li>
 *   <li>{@link de.acegen.aceGen.HttpClientOutcome#getAceOperations <em>Ace Operations</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getHttpClientOutcome()
 * @model
 * @generated
 */
public interface HttpClientOutcome extends EObject
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
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientOutcome_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.HttpClientOutcome#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Listeners</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpClientStateFunction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Listeners</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Listeners</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientOutcome_Listeners()
   * @model containment="true"
   * @generated
   */
  EList<HttpClientStateFunction> getListeners();

  /**
   * Returns the value of the '<em><b>Ace Operations</b></em>' reference list.
   * The list contents are of type {@link de.acegen.aceGen.HttpClientAce}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ace Operations</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ace Operations</em>' reference list.
   * @see de.acegen.aceGen.AceGenPackage#getHttpClientOutcome_AceOperations()
   * @model
   * @generated
   */
  EList<HttpClientAce> getAceOperations();

} // HttpClientOutcome
