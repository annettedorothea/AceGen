/**
 * generated by Xtext 2.24.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Client Then Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.ClientThenBlock#getStateVerifications <em>State Verifications</em>}</li>
 *   <li>{@link de.acegen.aceGen.ClientThenBlock#getVerifications <em>Verifications</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getClientThenBlock()
 * @model
 * @generated
 */
public interface ClientThenBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>State Verifications</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.StateVerification}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Verifications</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getClientThenBlock_StateVerifications()
   * @model containment="true"
   * @generated
   */
  EList<StateVerification> getStateVerifications();

  /**
   * Returns the value of the '<em><b>Verifications</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verifications</em>' attribute list.
   * @see de.acegen.aceGen.AceGenPackage#getClientThenBlock_Verifications()
   * @model unique="false"
   * @generated
   */
  EList<String> getVerifications();

} // ClientThenBlock
