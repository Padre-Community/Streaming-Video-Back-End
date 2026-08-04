package api.core.streamx.archtest.audit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Component;

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
}
