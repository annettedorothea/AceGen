/**
 * generated by Xtext 2.10.0
 */
package com.anfelisa.ace;

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
 *   <li>{@link com.anfelisa.ace.Model#isPersistent <em>Persistent</em>}</li>
 *   <li>{@link com.anfelisa.ace.Model#getName <em>Name</em>}</li>
 *   <li>{@link com.anfelisa.ace.Model#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link com.anfelisa.ace.Model#getModels <em>Models</em>}</li>
 * </ul>
 *
 * @see com.anfelisa.ace.AcePackage#getModel()
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
   * @see com.anfelisa.ace.AcePackage#getModel_Persistent()
   * @model
   * @generated
   */
  boolean isPersistent();

  /**
   * Sets the value of the '{@link com.anfelisa.ace.Model#isPersistent <em>Persistent</em>}' attribute.
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
   * @see com.anfelisa.ace.AcePackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.anfelisa.ace.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link com.anfelisa.ace.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see com.anfelisa.ace.AcePackage#getModel_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference list.
   * The list contents are of type {@link com.anfelisa.ace.ModelRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference list.
   * @see com.anfelisa.ace.AcePackage#getModel_Models()
   * @model containment="true"
   * @generated
   */
  EList<ModelRef> getModels();

} // Model
