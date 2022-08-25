import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParametrizedTest extends BaseTest {

    public static Logger logger = LoggerFactory.getLogger(ParametrizedTest.class);

    @ParameterizedTest
    @ValueSource(strings = {"Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska"})
    @DisplayName("Test - Check title for Sii")
    @Tags(value={@Tag("sii"), @Tag("regression")})
    void checkTitleSii(String expectedTitle) {
        logger.info("Checking title for Sii");
        driver.get("https://sii.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Onet – Jesteś na bieżąco"})
    @DisplayName("Test - Check title for Onet.pl")
    @Tags(value={@Tag("onet"), @Tag("regression")})
    void checkTitleOnet(String expectedTitle) {
        logger.info("Checking title for Onet");
        driver.get("https://www.onet.pl/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
    @DisplayName("Test - Check title for Kotuszkowo")
    @Tags(value={@Tag("kotuszkowo"), @Tag("regression")})
    void checkTitleKotuszkowo(String expectedTitle) {
        logger.info("Checking title for Kotuszkowo");
        driver.get("http://kotuszkowo.pl/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    @DisplayName("Test - Check title for FilmWeb")
    @Tags(value={@Tag("film"), @Tag("regression")})
    void checkTitleFilmWeb(String expectedTitle) {
        logger.info("Checking title for Filmweb");
        driver.get("https://www.filmweb.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"WebDriver | Selenium"})
    @DisplayName("Test - Check title for Selenium")
    @Tags(value={@Tag("selenium"), @Tag("regression")})
    void checkTitleSelenium(String expectedTitle) {
        logger.info("Checking title for Selenium");
        driver.get("https://www.selenium.dev/documentation/en/webdriver/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
