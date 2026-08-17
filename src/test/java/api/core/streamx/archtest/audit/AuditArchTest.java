package api.core.streamx.archtest.audit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "api.core.streamx.modules.audit", importOptions = ImportOption.DoNotIncludeTests.class)
public class AuditArchTest {

    @ArchTest
    static ArchRule layerTest = layeredArchitecture()
            .consideringAllDependencies()
            .layer("Config").definedBy("..config..")
            .layer("Processor").definedBy("..processor..")

            .whereLayer("Config").mayNotBeAccessedByAnyLayer()
            .whereLayer("Processor").mayOnlyBeAccessedByLayers("Config");

    @ArchTest
    static ArchRule processorTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(Component.class)
            .should().resideInAPackage("..processor..")
            .andShould().haveSimpleNameEndingWith("Interceptor");

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
}
