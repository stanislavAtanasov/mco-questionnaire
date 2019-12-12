import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.Location;
import org.junit.BeforeClass;

public abstract class ArchitectureTest {
	
	static final String CONFIG_PACKAGES = "com.example.mco.config..";
    static final String DOMAIN_LAYER_PACKAGES = "com.example.mco.core..";
    static final String APPLICATION_LAYER_PACKAGES = "com.example.mco.application..";

    static JavaClasses classes;

	private static final ImportOption IGNORE_GENERATED_FILES = new ImportOption() {
	    @Override
	    public boolean includes(Location location) {
	        return !location.contains("/generated/"); // ignore any URI to sources that contains '/test/'
	    }
	};
    
    @BeforeClass
    public static void setUp() {
        classes = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
                .withImportOption(IGNORE_GENERATED_FILES)
                .importPackages(CONFIG_PACKAGES, DOMAIN_LAYER_PACKAGES, APPLICATION_LAYER_PACKAGES);

        System.out.println("Finished loading classes");
    }
}