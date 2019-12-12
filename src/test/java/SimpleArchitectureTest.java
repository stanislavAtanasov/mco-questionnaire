import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;

public class SimpleArchitectureTest extends ArchitectureTest {
	
    @Test
    public void testLayerSeparation() {
        ArchRule rule = ArchRuleDefinition.classes()
                .that().resideInAPackage(DOMAIN_LAYER_PACKAGES)
                .should().onlyDependOnClassesThat()
                .resideInAnyPackage(DOMAIN_LAYER_PACKAGES, "java..", "org.slf4j..", "org.apache.commons..", "com.example.mco.config..");
        rule.check(classes);
    }
}