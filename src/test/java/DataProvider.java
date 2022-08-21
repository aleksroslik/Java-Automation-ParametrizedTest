import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("https://sii.pl", "Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska"),
                Arguments.of("https://www.onet.pl/", "Onet – Jesteś na bieżąco"),
                Arguments.of("http://kotuszkowo.pl/", "Kotuszkowo- blog o kotach"),
                Arguments.of("https://www.filmweb.pl", "Filmweb - filmy takie jak Ty!"),
                Arguments.of("https://www.selenium.dev/documentation/en/webdriver/", "WebDriver | Selenium")
        );
    }
}
