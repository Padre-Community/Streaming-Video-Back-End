package api.core.streamx.archtest.analytics;

//@AnalyzeClasses(packages = "api.core.streamx.modules.analytics", importOptions = ImportOption.DoNotIncludeTests.class)
public class AnalyticsArchTest {
/*
    //Layer
    @ArchTest
    static ArchRule layerTest = layeredArchitecture()
            .consideringAllDependencies()
            .layer("Controller").definedBy("..controller..")
            .layer("Service").definedBy("..services..")
            .layer("Validation").definedBy("..utils..")
            .layer("Repository").definedBy("..repository..")

            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Validation").mayOnlyBeAccessedByLayers("Service")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service", "Validation");

    //Controller
    @ArchTest
    static ArchRule controllerTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(RestController.class)
            .should().resideInAPackage("..controller..")
            .andShould().haveSimpleNameEndingWith("Controller")
            .andShould().haveSimpleNameNotEndingWith("RestController");


    @ArchTest
    static ArchRule controllerDoNotCallRepositoryTest = ArchRuleDefinition.noClasses()
            .that().resideInAPackage("..controller..")
            .should().dependOnClassesThat().resideInAPackage("..repository..")
            .because("Controller não pode chamar diretamente o repository.");


    @ArchTest
    static ArchRule controllerMethodsTest = ArchRuleDefinition.noMethods()
            .that().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
            .should().beAnnotatedWith(RequestMapping.class)
            .andShould().beAnnotatedWith(RestController.class);

    //DTO
    @ArchTest
    static ArchRule dtoTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..dto..", "..request..", "..response..")
            .should()
            .beRecords()
            .because("Classe responsável pela transferência de dados entre cliente e camada de modelo");

    //Exception
    @ArchTest
    static ArchRule exceptionTest = ArchRuleDefinition.classes()
            .that()
            .areAnnotatedWith(RestControllerAdvice.class)
            .should()
            .resideInAPackage("..exception..")
            .because("Pertencem a um pacote de controle de exceções")
            .allowEmptyShould(true);

    @ArchTest
    static ArchRule exceptionMethodTest = ArchRuleDefinition.methods()
            .that().areAnnotatedWith(ExceptionHandler.class)
            .should().bePublic()
            .because("Metódos Responsáveis por controle e devolutiva de exceção")
            .allowEmptyShould(true);

    //Model
    @ArchTest
    static ArchRule entityTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Entity.class)
            .should().resideInAPackage("..model..")
            .because("Classe responsável pela camada de modelo e persistência");

    @ArchTest
    static ArchRule inheritanceEntityTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Entity.class)
            .should().resideInAPackage("..model..")
            .andShould().implement(Serializable.class)
            .because("Classe responsável pela camada de modelo e persistência");

    @ArchTest
    static ArchRule fieldsEntityTest = ArchRuleDefinition.fields()
            .that().areDeclaredInClassesThat()
            .resideInAPackage("..model..")
            .should().bePrivate()
            .because("atributos devem ser privados e acessados via método/encapsulamento");

    //Repository
    @ArchTest
    static ArchRule repositoryTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..repository..").should()
            .beAnnotatedWith(Repository.class)
            .because("Repository é uma classe/interface de persistência @Repository");

    @ArchTest
    static ArchRule repositoryClassInterface = ArchRuleDefinition.classes()
            .that().resideInAPackage("..repository..")
            .should().beAnnotatedWith(Repository.class)
            .andShould().beInterfaces().because("Classe de contrato com a data base");

    @ArchTest
    static ArchRule mustRepositoryInterfacesMustExtendJpaRepository = ArchRuleDefinition.classes()
            .that().haveSimpleNameEndingWith("Repository")
            .should().beInterfaces().andShould().beAssignableTo(JpaRepository.class)
            .because("Interfaces que fazem abstração ao banco de dados, devem herdar os métodos de manipulação e persistência");


    //Service
    @ArchTest
    static ArchRule servicesTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..services..")
            .should().beAnnotatedWith(Service.class);

    @ArchTest
    static ArchRule serviceNameHaveBeenFinallyService = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Service.class)
            .should().haveSimpleNameEndingWith("Services");

    @ArchTest
    static ArchRule serviceFieldsHasBeenPrivate = ArchRuleDefinition.fields()
            .that().areDeclaredInClassesThat()
            .areAnnotatedWith(Service.class)
            .should().bePrivate()
            .because("Instâncias e Objetos devem ser privados em sua declaração");

    @ArchTest
    static ArchRule componentIsNotAllowed = ArchRuleDefinition.classes()
            .that().resideInAPackage("..services..")
            .should().notBeAnnotatedWith(Component.class)
            .because("Anotação 'Component' não é permitida no pacote services");

    //Utils
    @ArchIgnore
    @ArchTest
    static ArchRule utilsValidateParameterTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..utils..")
            .should().haveSimpleName("ValidateParameter")
            .because("Classe utilitária para conversão de tipo String/Long e seu tratamento em caso de erro");


    @ArchTest
    static ArchRule utilsValidateTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..utils..")
            .should().haveOnlyPrivateConstructors();

    //Logs
    @ArchTest
    static ArchRule logTest = ArchRuleDefinition.fields()
            .that().haveRawType(Logger.class)
            .should().bePrivate()
            .andShould().beStatic()
            .andShould().beFinal()
            .allowEmptyShould(true);

    @ArchTest
    static ArchRule log2Test = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    @ArchTest
    static ArchRule injectionDependencyTest = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchTest
    static ArchRule genericExceptionsTest = GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
    */
}
