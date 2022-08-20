import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParametrizedTest extends BaseTest {

    DataProvider data = new DataProvider();

    @ParameterizedTest
    @ValueSource(strings = {"Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska"})
    @DisplayName("Check title for Sii")
    @Tags(value={@Tag("sii"), @Tag("regression")})
    void checkTitleSii(String expectedTitle) {
        driver.get(data.getSiiUrl());
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Onet – Jesteś na bieżąco"})
    @DisplayName("Check title for Onet.pl")
    @Tags(value={@Tag("onet"), @Tag("regression")})
    void checkTitleOnet(String expectedTitle) {
        driver.get(data.getOnetUrl());
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
    @DisplayName("Check title for Kotuszkowo")
    @Tags(value={@Tag("kotuszkowo"), @Tag("regression")})
    void checkTitleKotuszkowo(String expectedTitle) {
        driver.get(data.getKotuszkowoUrl());
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    @DisplayName("Check title for FilmWeb")
    @Tags(value={@Tag("film"), @Tag("regression")})
    void checkTitleFilmWeb(String expectedTitle) {
        driver.get(data.getFilmWebUrl());
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"WebDriver | Selenium"})
    @DisplayName("Check title for Selenium")
    @Tags(value={@Tag("selenium"), @Tag("regression")})
    void checkTitleSelenium(String expectedTitle) {
        driver.get(data.getSeleniumUrl());
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
