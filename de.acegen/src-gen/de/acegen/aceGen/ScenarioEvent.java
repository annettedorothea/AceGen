/**
 * generated by Xtext 2.16.0
 */
package de.acegen.aceGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.acegen.aceGen.ScenarioEvent#getOutcome <em>Outcome</em>}</li>
 *   <li>{@link de.acegen.aceGen.ScenarioEvent#getDataDefinition <em>Data Definition</em>}</li>
 * </ul>
 *
 * @see de.acegen.aceGen.AceGenPackage#getScenarioEvent()
 * @model
 * @generated
 */
public interface ScenarioEvent extends EObject
{
  /**
   * Returns the value of the '<em><b>Outcome</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outcome</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outcome</em>' reference.
   * @see #setOutcome(HttpServerOutcome)
   * @see de.acegen.aceGen.AceGenPackage#getScenarioEvent_Outcome()
   * @model
   * @generated
   */
  HttpServerOutcome getOutcome();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ScenarioEvent#getOutcome <em>Outcome</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outcome</em>' reference.
   * @see #getOutcome()
   * @generated
   */
  void setOutcome(HttpServerOutcome value);

  /**
   * Returns the value of the '<em><b>Data Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Definition</em>' containment reference.
   * @see #setDataDefinition(DataDefinition)
   * @see de.acegen.aceGen.AceGenPackage#getScenarioEvent_DataDefinition()
   * @model containment="true"
   * @generated
   */
  DataDefinition getDataDefinition();

  /**
   * Sets the value of the '{@link de.acegen.aceGen.ScenarioEvent#getDataDefinition <em>Data Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Definition</em>' containment reference.
   * @see #getDataDefinition()
   * @generated
   */
  void setDataDefinition(DataDefinition value);

} // ScenarioEvent