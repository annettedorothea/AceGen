/**
 * generated by Xtext 2.24.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Persistence Verification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.PersistenceVerification#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.PersistenceVerification#getModel <em>Model</em>}</li>
 *   <li>{@link de.acegen.aceGen.PersistenceVerification#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getPersistenceVerification()
 * @model
 * @generated
 */
public interface PersistenceVerification extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.acegen.aceGen.AceGenPackage#getPersistenceVerification_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.PersistenceVerification#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' reference.
   * @see #setModel(Model)
   * @see de.acegen.aceGen.AceGenPackage#getPersistenceVerification_Model()
   * @model
   * @generated
   */
  Model getModel();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.PersistenceVerification#getModel <em>Model</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' reference.
   * @see #getModel()
   * @generated
   */
  void setModel(Model value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(PersistenceVerificationExpression)
   * @see de.acegen.aceGen.AceGenPackage#getPersistenceVerification_Expression()
   * @model containment="true"
   * @generated
   */
  PersistenceVerificationExpression getExpression();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.PersistenceVerification#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(PersistenceVerificationExpression value);

} // PersistenceVerification
