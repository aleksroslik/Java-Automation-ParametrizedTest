import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParametrizedTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(ParametrizedTest.class);

    @Test
    @DisplayName("Check title")
    @Tag("regression")
    void checkTitle() {
        logger.info(">>>> Start test >>>>>");
        String actualTitle = driver.getTitle();
        logger.info("Actual title: {}", actualTitle);
        logger.info("Expected title: {}", System.getProperty("title"));
        assertThat(actualTitle).isEqualTo(System.getProperty("title"));
    }
}
