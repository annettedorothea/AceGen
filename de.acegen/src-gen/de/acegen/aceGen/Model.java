/**
 * generated by Xtext 2.14.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.Model#isPersistent <em>Persistent</em>}</li>
 *   <li>{@link de.acegen.aceGen.Model#getName <em>Name</em>}</li>
 *   <li>{@link de.acegen.aceGen.Model#getSuperModels <em>Super Models</em>}</li>
 *   <li>{@link de.acegen.aceGen.Model#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Persistent</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Persistent</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Persistent</em>' attribute.
   * @see #setPersistent(boolean)
   * @see de.acegen.aceGen.AceGenPackage#getModel_Persistent()
   * @model
   * @generated
   */
  boolean isPersistent();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Model#isPersistent <em>Persistent</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Persistent</em>' attribute.
   * @see #isPersistent()
   * @generated
   */
  void setPersistent(boolean value);

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
   * @see de.acegen.aceGen.AceGenPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Super Models</b></em>' reference list.
   * The list contents are of type {@link de.acegen.aceGen.Model}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Models</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Models</em>' reference list.
   * @see de.acegen.aceGen.AceGenPackage#getModel_SuperModels()
   * @model
   * @generated
   */
  EList<Model> getSuperModels();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link de.acegen.aceGen.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see de.acegen.aceGen.AceGenPackage#getModel_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

} // Model