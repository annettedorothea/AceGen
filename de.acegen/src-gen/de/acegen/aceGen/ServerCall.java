/**
 * generated by Xtext 2.22.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Server Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.ServerCall#getJsonObject <em>Json Object</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getServerCall()
 * @model
 * @generated
 */
public interface ServerCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Json Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Json Object</em>' containment reference.
   * @see #setJsonObject(JsonObject)
   * @see de.acegen.aceGen.AceGenPackage#getServerCall_JsonObject()
   * @model containment="true"
   * @generated
   */
  JsonObject getJsonObject();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ServerCall#getJsonObject <em>Json Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Json Object</em>' containment reference.
   * @see #getJsonObject()
   * @generated
   */
  void setJsonObject(JsonObject value);

} // ServerCall
