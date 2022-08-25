import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    public static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    WebDriver driver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        logger.info("setup");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void close() {
        logger.info("quit");
        driver.quit();
    }
}
