/**
 * generated by Xtext 2.25.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select By Primary Keys</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.SelectByPrimaryKeys#getAttributeAndValues <em>Attribute And Values</em>}</li>
 *   <li>{@link de.acegen.aceGen.SelectByPrimaryKeys#getExpected <em>Expected</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getSelectByPrimaryKeys()
 * @model
 * @generated
 */
public interface SelectByPrimaryKeys extends PersistenceVerificationExpression
{
  /**
   * Returns the value of the '<em><b>Attribute And Values</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.AttributeAndValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute And Values</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getSelectByPrimaryKeys_AttributeAndValues()
   * @model containment="true"
   * @generated
   */
  EList<AttributeAndValue> getAttributeAndValues();

  /**
   * Returns the value of the '<em><b>Expected</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expected</em>' containment reference.
   * @see #setExpected(SelectByExpectation)
   * @see de.acegen.aceGen.AceGenPackage#getSelectByPrimaryKeys_Expected()
   * @model containment="true"
   * @generated
   */
  SelectByExpectation getExpected();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.SelectByPrimaryKeys#getExpected <em>Expected</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expected</em>' containment reference.
   * @see #getExpected()
   * @generated
   */
  void setExpected(SelectByExpectation value);

} // SelectByPrimaryKeys
