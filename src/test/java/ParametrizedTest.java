import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParametrizedTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska"})
    @DisplayName("Check title for Sii")
    @Tag("Sii") @Tag("Regression")
    void checkTitleSii(String expectedTitle) {
        driver.get("https://sii.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
    @ParameterizedTest
    @ValueSource(strings = {"Onet – Jesteś na bieżąco"})
    @DisplayName("Check title for Onet.pl")
    @Tag("Onet") @Tag("Regression")
    void checkTitleOnet(String expectedTitle) {
        driver.get("https://www.onet.pl/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
    @ParameterizedTest
    @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
    @DisplayName("Check title for Kotuszkowo")
    @Tag("Kotuszkowo") @Tag("Regression")
    void checkTitleKotuszkowo(String expectedTitle) {
        driver.get("http://kotuszkowo.pl/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("Check title for FilmWeb")
    @Tag("Film") @Tag("Regression")
    void checkTitleFilmWeb(String expectedTitle) {
        driver.get("kttps://www.filmweb.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"WebDriver | Selenium"})
    @DisplayName("Check title for Selenium")
    @Tag("Selenium") @Tag("Regression")
    void checkTitleSelenium(String expectedTitle) {
        driver.get("https://www.selenium.dev/documentation/en/webdriver/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
