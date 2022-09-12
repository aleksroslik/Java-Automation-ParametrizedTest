import configuration.BrowserEnvironment;
import configuration.EnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public static WebDriver driver;
    private static BrowserEnvironment browserEnvironment;
    public static EnvironmentProperties environmentProperties;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        environmentProperties = EnvironmentProperties.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        logger.debug("Driver started successfully");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        logger.debug("Driver closed");
    }
}
