/**
 * generated by Xtext 2.25.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Json Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.JsonArray#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getJsonArray()
 * @model
 * @generated
 */
public interface JsonArray extends JsonValue
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.JsonValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getJsonArray_Values()
   * @model containment="true"
   * @generated
   */
  EList<JsonValue> getValues();

} // JsonArray
