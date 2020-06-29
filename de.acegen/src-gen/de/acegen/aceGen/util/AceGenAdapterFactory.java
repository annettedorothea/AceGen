/**
 * generated by Xtext 2.21.0
 */
package de.acegen.aceGen.util;

import de.acegen.aceGen.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.acegen.aceGen.AceGenPackage
 * @generated
 */
public class AceGenAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AceGenPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AceGenAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AceGenPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AceGenSwitch<Adapter> modelSwitch =
    new AceGenSwitch<Adapter>()
    {
      @Override
      public Adapter caseProject(Project object)
      {
        return createProjectAdapter();
      }
      @Override
      public Adapter caseHttpClient(HttpClient object)
      {
        return createHttpClientAdapter();
      }
      @Override
      public Adapter caseHttpClientAce(HttpClientAce object)
      {
        return createHttpClientAceAdapter();
      }
      @Override
      public Adapter caseInput(Input object)
      {
        return createInputAdapter();
      }
      @Override
      public Adapter caseHttpClientOutcome(HttpClientOutcome object)
      {
        return createHttpClientOutcomeAdapter();
      }
      @Override
      public Adapter caseHttpClientStateFunction(HttpClientStateFunction object)
      {
        return createHttpClientStateFunctionAdapter();
      }
      @Override
      public Adapter caseClientAttribute(ClientAttribute object)
      {
        return createClientAttributeAdapter();
      }
      @Override
      public Adapter caseSingleClientAttribute(SingleClientAttribute object)
      {
        return createSingleClientAttributeAdapter();
      }
      @Override
      public Adapter caseGroupedClientAttribute(GroupedClientAttribute object)
      {
        return createGroupedClientAttributeAdapter();
      }
      @Override
      public Adapter caseClientScenario(ClientScenario object)
      {
        return createClientScenarioAdapter();
      }
      @Override
      public Adapter caseClientWhenBlock(ClientWhenBlock object)
      {
        return createClientWhenBlockAdapter();
      }
      @Override
      public Adapter caseInputValue(InputValue object)
      {
        return createInputValueAdapter();
      }
      @Override
      public Adapter caseClientThenBlock(ClientThenBlock object)
      {
        return createClientThenBlockAdapter();
      }
      @Override
      public Adapter caseServerCall(ServerCall object)
      {
        return createServerCallAdapter();
      }
      @Override
      public Adapter caseTriggeredAction(TriggeredAction object)
      {
        return createTriggeredActionAdapter();
      }
      @Override
      public Adapter caseStateVerification(StateVerification object)
      {
        return createStateVerificationAdapter();
      }
      @Override
      public Adapter caseJsonObjectClient(JsonObjectClient object)
      {
        return createJsonObjectClientAdapter();
      }
      @Override
      public Adapter caseJsonMemberClient(JsonMemberClient object)
      {
        return createJsonMemberClientAdapter();
      }
      @Override
      public Adapter caseJsonValueClient(JsonValueClient object)
      {
        return createJsonValueClientAdapter();
      }
      @Override
      public Adapter caseJsonArrayClient(JsonArrayClient object)
      {
        return createJsonArrayClientAdapter();
      }
      @Override
      public Adapter caseHttpServer(HttpServer object)
      {
        return createHttpServerAdapter();
      }
      @Override
      public Adapter caseHttpServerAce(HttpServerAce object)
      {
        return createHttpServerAceAdapter();
      }
      @Override
      public Adapter caseHttpServerAceWrite(HttpServerAceWrite object)
      {
        return createHttpServerAceWriteAdapter();
      }
      @Override
      public Adapter caseHttpServerOutcome(HttpServerOutcome object)
      {
        return createHttpServerOutcomeAdapter();
      }
      @Override
      public Adapter caseHttpServerAceRead(HttpServerAceRead object)
      {
        return createHttpServerAceReadAdapter();
      }
      @Override
      public Adapter caseAttributeParamRef(AttributeParamRef object)
      {
        return createAttributeParamRefAdapter();
      }
      @Override
      public Adapter caseHttpServerView(HttpServerView object)
      {
        return createHttpServerViewAdapter();
      }
      @Override
      public Adapter caseHttpServerViewFunction(HttpServerViewFunction object)
      {
        return createHttpServerViewFunctionAdapter();
      }
      @Override
      public Adapter caseAuthUser(AuthUser object)
      {
        return createAuthUserAdapter();
      }
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseScenario(Scenario object)
      {
        return createScenarioAdapter();
      }
      @Override
      public Adapter caseGivenRef(GivenRef object)
      {
        return createGivenRefAdapter();
      }
      @Override
      public Adapter caseWhenBlock(WhenBlock object)
      {
        return createWhenBlockAdapter();
      }
      @Override
      public Adapter caseThenBlock(ThenBlock object)
      {
        return createThenBlockAdapter();
      }
      @Override
      public Adapter casePersistenceVerification(PersistenceVerification object)
      {
        return createPersistenceVerificationAdapter();
      }
      @Override
      public Adapter casePersistenceVerificationExpression(PersistenceVerificationExpression object)
      {
        return createPersistenceVerificationExpressionAdapter();
      }
      @Override
      public Adapter caseSelectByPrimaryKeys(SelectByPrimaryKeys object)
      {
        return createSelectByPrimaryKeysAdapter();
      }
      @Override
      public Adapter caseSelectByUniqueAttribute(SelectByUniqueAttribute object)
      {
        return createSelectByUniqueAttributeAdapter();
      }
      @Override
      public Adapter caseCount(Count object)
      {
        return createCountAdapter();
      }
      @Override
      public Adapter caseAttributeAndValue(AttributeAndValue object)
      {
        return createAttributeAndValueAdapter();
      }
      @Override
      public Adapter caseVerification(Verification object)
      {
        return createVerificationAdapter();
      }
      @Override
      public Adapter caseSelectByExpectation(SelectByExpectation object)
      {
        return createSelectByExpectationAdapter();
      }
      @Override
      public Adapter caseDataDefinition(DataDefinition object)
      {
        return createDataDefinitionAdapter();
      }
      @Override
      public Adapter caseAuthorization(Authorization object)
      {
        return createAuthorizationAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseJsonDateTime(JsonDateTime object)
      {
        return createJsonDateTimeAdapter();
      }
      @Override
      public Adapter caseJsonObject(JsonObject object)
      {
        return createJsonObjectAdapter();
      }
      @Override
      public Adapter caseJsonMember(JsonMember object)
      {
        return createJsonMemberAdapter();
      }
      @Override
      public Adapter caseJsonValue(JsonValue object)
      {
        return createJsonValueAdapter();
      }
      @Override
      public Adapter caseJsonArray(JsonArray object)
      {
        return createJsonArrayAdapter();
      }
      @Override
      public Adapter caseStringType(StringType object)
      {
        return createStringTypeAdapter();
      }
      @Override
      public Adapter caseBooleanType(BooleanType object)
      {
        return createBooleanTypeAdapter();
      }
      @Override
      public Adapter caseNullType(NullType object)
      {
        return createNullTypeAdapter();
      }
      @Override
      public Adapter caseUndefinedType(UndefinedType object)
      {
        return createUndefinedTypeAdapter();
      }
      @Override
      public Adapter caseLongType(LongType object)
      {
        return createLongTypeAdapter();
      }
      @Override
      public Adapter casePrimitiveValue(PrimitiveValue object)
      {
        return createPrimitiveValueAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.Project <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.Project
   * @generated
   */
  public Adapter createProjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpClient <em>Http Client</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpClient
   * @generated
   */
  public Adapter createHttpClientAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpClientAce <em>Http Client Ace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpClientAce
   * @generated
   */
  public Adapter createHttpClientAceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.Input <em>Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.Input
   * @generated
   */
  public Adapter createInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpClientOutcome <em>Http Client Outcome</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpClientOutcome
   * @generated
   */
  public Adapter createHttpClientOutcomeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpClientStateFunction <em>Http Client State Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpClientStateFunction
   * @generated
   */
  public Adapter createHttpClientStateFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.ClientAttribute <em>Client Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.ClientAttribute
   * @generated
   */
  public Adapter createClientAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.SingleClientAttribute <em>Single Client Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.SingleClientAttribute
   * @generated
   */
  public Adapter createSingleClientAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.GroupedClientAttribute <em>Grouped Client Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.GroupedClientAttribute
   * @generated
   */
  public Adapter createGroupedClientAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.ClientScenario <em>Client Scenario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.ClientScenario
   * @generated
   */
  public Adapter createClientScenarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.ClientWhenBlock <em>Client When Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.ClientWhenBlock
   * @generated
   */
  public Adapter createClientWhenBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.InputValue <em>Input Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.InputValue
   * @generated
   */
  public Adapter createInputValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.ClientThenBlock <em>Client Then Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.ClientThenBlock
   * @generated
   */
  public Adapter createClientThenBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.ServerCall <em>Server Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.ServerCall
   * @generated
   */
  public Adapter createServerCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.TriggeredAction <em>Triggered Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.TriggeredAction
   * @generated
   */
  public Adapter createTriggeredActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.StateVerification <em>State Verification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.StateVerification
   * @generated
   */
  public Adapter createStateVerificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.JsonObjectClient <em>Json Object Client</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.JsonObjectClient
   * @generated
   */
  public Adapter createJsonObjectClientAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.JsonMemberClient <em>Json Member Client</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.JsonMemberClient
   * @generated
   */
  public Adapter createJsonMemberClientAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.JsonValueClient <em>Json Value Client</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.JsonValueClient
   * @generated
   */
  public Adapter createJsonValueClientAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.JsonArrayClient <em>Json Array Client</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.JsonArrayClient
   * @generated
   */
  public Adapter createJsonArrayClientAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpServer <em>Http Server</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpServer
   * @generated
   */
  public Adapter createHttpServerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpServerAce <em>Http Server Ace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpServerAce
   * @generated
   */
  public Adapter createHttpServerAceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpServerAceWrite <em>Http Server Ace Write</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpServerAceWrite
   * @generated
   */
  public Adapter createHttpServerAceWriteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpServerOutcome <em>Http Server Outcome</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpServerOutcome
   * @generated
   */
  public Adapter createHttpServerOutcomeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpServerAceRead <em>Http Server Ace Read</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpServerAceRead
   * @generated
   */
  public Adapter createHttpServerAceReadAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.AttributeParamRef <em>Attribute Param Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.AttributeParamRef
   * @generated
   */
  public Adapter createAttributeParamRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpServerView <em>Http Server View</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpServerView
   * @generated
   */
  public Adapter createHttpServerViewAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.HttpServerViewFunction <em>Http Server View Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.HttpServerViewFunction
   * @generated
   */
  public Adapter createHttpServerViewFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.AuthUser <em>Auth User</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.AuthUser
   * @generated
   */
  public Adapter createAuthUserAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.Scenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.Scenario
   * @generated
   */
  public Adapter createScenarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.GivenRef <em>Given Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.GivenRef
   * @generated
   */
  public Adapter createGivenRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.WhenBlock <em>When Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.WhenBlock
   * @generated
   */
  public Adapter createWhenBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.ThenBlock <em>Then Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.ThenBlock
   * @generated
   */
  public Adapter createThenBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.PersistenceVerification <em>Persistence Verification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.PersistenceVerification
   * @generated
   */
  public Adapter createPersistenceVerificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.PersistenceVerificationExpression <em>Persistence Verification Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.PersistenceVerificationExpression
   * @generated
   */
  public Adapter createPersistenceVerificationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.SelectByPrimaryKeys <em>Select By Primary Keys</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.SelectByPrimaryKeys
   * @generated
   */
  public Adapter createSelectByPrimaryKeysAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.SelectByUniqueAttribute <em>Select By Unique Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.SelectByUniqueAttribute
   * @generated
   */
  public Adapter createSelectByUniqueAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.Count <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.Count
   * @generated
   */
  public Adapter createCountAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.AttributeAndValue <em>Attribute And Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.AttributeAndValue
   * @generated
   */
  public Adapter createAttributeAndValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.Verification <em>Verification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.Verification
   * @generated
   */
  public Adapter createVerificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.SelectByExpectation <em>Select By Expectation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.SelectByExpectation
   * @generated
   */
  public Adapter createSelectByExpectationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.DataDefinition <em>Data Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.DataDefinition
   * @generated
   */
  public Adapter createDataDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.Authorization <em>Authorization</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.Authorization
   * @generated
   */
  public Adapter createAuthorizationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.JsonDateTime <em>Json Date Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.JsonDateTime
   * @generated
   */
  public Adapter createJsonDateTimeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.JsonObject <em>Json Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.JsonObject
   * @generated
   */
  public Adapter createJsonObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.JsonMember <em>Json Member</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.JsonMember
   * @generated
   */
  public Adapter createJsonMemberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.JsonValue <em>Json Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.JsonValue
   * @generated
   */
  public Adapter createJsonValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.JsonArray <em>Json Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.JsonArray
   * @generated
   */
  public Adapter createJsonArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.StringType
   * @generated
   */
  public Adapter createStringTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.BooleanType
   * @generated
   */
  public Adapter createBooleanTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.NullType <em>Null Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.NullType
   * @generated
   */
  public Adapter createNullTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.UndefinedType <em>Undefined Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.UndefinedType
   * @generated
   */
  public Adapter createUndefinedTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.LongType <em>Long Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.LongType
   * @generated
   */
  public Adapter createLongTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.acegen.aceGen.PrimitiveValue <em>Primitive Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.acegen.aceGen.PrimitiveValue
   * @generated
   */
  public Adapter createPrimitiveValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AceGenAdapterFactory
