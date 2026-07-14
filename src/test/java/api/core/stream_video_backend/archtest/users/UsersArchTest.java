package api.core.stream_video_backend.archtest.users;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchIgnore;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.GeneralCodingRules;
import jakarta.persistence.Entity;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "api.core.stream_video_backend.modules.users", importOptions = ImportOption.DoNotIncludeTests.class)
public class UsersArchTest {

    //Layer
    @ArchTest
    static ArchRule layerTest = layeredArchitecture()
            .consideringAllDependencies()
            .layer("Controller").definedBy("..controller..")
            .layer("Services").definedBy("..services..")
            .layer("Repository").definedBy("..repository..")

            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Services");

    //Api
    @ArchIgnore
    @ArchTest
    static ArchRule controllerTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(RestController.class)
            .should().resideInAPackage("..controller..")
            .andShould().haveSimpleNameEndingWith("Controller")
            .andShould().haveSimpleNameNotEndingWith("RestController");

    @ArchIgnore
    @ArchTest
    static ArchRule controllerDoNotCallRepositoryTest = ArchRuleDefinition.noClasses()
            .that().resideInAPackage("..controller..")
            .should().dependOnClassesThat().resideInAPackage("..repository..")
            .because("Controller não pode chamar diretamente o repository.");

    @ArchIgnore
    @ArchTest
    static ArchRule controllerMethodsTest = ArchRuleDefinition.noMethods()
            .that().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
            .should().beAnnotatedWith(RequestMapping.class)
            .andShould().beAnnotatedWith(RestController.class);

    //DTO
    @ArchIgnore
    @ArchTest
    static ArchRule dtoTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..dto..")
            .should()
            .beRecords()
            .because("Classe responsável pela transferência de dados entre cliente e camada de modelo");

    //Exception
    @ArchIgnore
    @ArchTest
    static ArchRule exceptionTest = ArchRuleDefinition.classes()
            .that()
            .areAnnotatedWith(RestControllerAdvice.class)
            .should()
            .resideInAPackage("..exception..")
            .because("Pertencem a um pacote de controle de exceções");

    @ArchIgnore
    @ArchTest
    static ArchRule exceptionMethodTest = ArchRuleDefinition.methods()
            .that().areAnnotatedWith(ExceptionHandler.class)
            .should().bePublic()
            .because("Metódos Responsáveis por controle e devolutiva de exceção");

    //Model
    @ArchIgnore
    @ArchTest
    static ArchRule entityTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Entity.class)
            .should().resideInAPackage("..model..")
            .because("Classe responsável pela camada de modelo e persistência");

    @ArchIgnore
    @ArchTest
    static ArchRule inheritanceEntityTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Entity.class)
            .should().resideInAPackage("..model..")
            .andShould().implement(Serializable.class)
            .because("Classe responsável pela camada de modelo e persistência");

    @ArchTest
    @ArchIgnore
    static ArchRule fieldsEntityTest = ArchRuleDefinition.fields()
            .that().areDeclaredInClassesThat()
            .resideInAPackage("..model..")
            .should().bePrivate()
            .because("atributos devem ser privados e acessados via método/encapsulamento");

    //Repository
    @ArchIgnore
    @ArchTest
    static ArchRule repositoryTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..repository..").should()
            .beAnnotatedWith(Repository.class)
            .because("Repository é uma classe/interface de persistência @Repository");

    @ArchIgnore
    @ArchTest
    static ArchRule repositoryClassInterface = ArchRuleDefinition.classes()
            .that().resideInAPackage("..repository..")
            .should().beAnnotatedWith(Repository.class)
            .andShould().beInterfaces().because("Classe de contrato com a data base");

    //Service
    @ArchIgnore
    @ArchTest
    static ArchRule servicesTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..services..")
            .should().beAnnotatedWith(Service.class);

    @ArchIgnore
    @ArchTest
    static ArchRule serviceNameHaveBeenFinallyService = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Service.class)
            .should().haveSimpleNameEndingWith("Services");

    @ArchIgnore
    @ArchTest
    static ArchRule serviceFieldsHasBeenPrivate = ArchRuleDefinition.fields()
            .that().areDeclaredInClassesThat()
            .areAnnotatedWith(Service.class)
            .should().bePrivate()
            .because("Instâncias e Objetos devem ser privados em sua declaração");

    @ArchIgnore
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

    @ArchIgnore
    @ArchTest
    static ArchRule utilsValidateTest = ArchRuleDefinition.classes()
            .that().resideInAPackage("..utils..")
            .should().haveOnlyPrivateConstructors();

    //Logs
    @ArchIgnore
    @ArchTest
    static ArchRule logTest = ArchRuleDefinition.fields()
            .that().haveRawType(Logger.class)
            .should().bePrivate()
            .andShould().beStatic()
            .andShould().beFinal()
            .allowEmptyShould(true);

    @ArchIgnore
    @ArchTest
    static ArchRule log2Test = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    @ArchIgnore
    @ArchTest
    static ArchRule injectionDependencyTest = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
}
