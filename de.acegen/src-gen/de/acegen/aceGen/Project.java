/**
 * generated by Xtext 2.24.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.Project#getHttpClient <em>Http Client</em>}</li>
 *   <li>{@link de.acegen.aceGen.Project#getHttpServer <em>Http Server</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject
{
  /**
   * Returns the value of the '<em><b>Http Client</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Http Client</em>' containment reference.
   * @see #setHttpClient(HttpClient)
   * @see de.acegen.aceGen.AceGenPackage#getProject_HttpClient()
   * @model containment="true"
   * @generated
   */
  HttpClient getHttpClient();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Project#getHttpClient <em>Http Client</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Http Client</em>' containment reference.
   * @see #getHttpClient()
   * @generated
   */
  void setHttpClient(HttpClient value);

  /**
   * Returns the value of the '<em><b>Http Server</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Http Server</em>' containment reference.
   * @see #setHttpServer(HttpServer)
   * @see de.acegen.aceGen.AceGenPackage#getProject_HttpServer()
   * @model containment="true"
   * @generated
   */
  HttpServer getHttpServer();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Project#getHttpServer <em>Http Server</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Http Server</em>' containment reference.
   * @see #getHttpServer()
   * @generated
   */
  void setHttpServer(HttpServer value);

} // Project
