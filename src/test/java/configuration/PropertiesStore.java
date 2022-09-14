package configuration;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public enum PropertiesStore {
    BROWSER("browser"),
    BROWSER_WEBELEMENT_TIMEOUT("browser.webelement.timeout"),
    BROWSER_HEADLESS("browser.headless"),
    BROWSER_ATTACHSCREENSHOT("browser.attachscreenshot"),
    ENVIRONMENT("environment");

    private String value;
    private String propertyKey; // mapowanie properties ktore skladaja sie z key i values

    public static final String CONFIG_PROPERTIES = "config.properties"; // link do pliku config w resources

    private static Properties properties = null; // klasa pozwalajaca na obslugiwanie properties

    private PropertiesStore(String key) { // tylko key ze względu na różne typy (int, string, boolean)
        this.propertyKey = key;
        this.value = this.retrieveValue(key);
    }

    private String retrieveValue(String key) {
        return System.getProperty(key) != null ? System.getProperty(key) : getValueFromConfigFile(key); // metoda pobierajaca wartosc dla danego klucza
    }

    private String getValueFromConfigFile(String key) { // ladowanie properties z pliku
        if (properties == null) {
           properties = loadConfigFile(); 
        } 
        Object objectFromFile = properties.get(key);
        return objectFromFile != null ? Objects.toString(objectFromFile) : null; 
    }

    private Properties loadConfigFile() { // laczy sie z plikiem i pobiera, tylko raz i to wystarczy
        Properties copy = null;
        try {
            InputStream configFileStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
            try {
                Properties properties = new Properties();
                properties.load(configFileStream);
                copy = properties;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (configFileStream != null) {
                    try {
                        configFileStream.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copy;
    }
    // sprawdzanie czy nie jest pusta wartosc - isSpecified()
    public boolean isSpecified() {
        return StringUtils.isNotEmpty(this.value);
    }
    public String getValue() {
        return this.retrieveValue(this.propertyKey);
    }
    public int getIntValue() {
        return Integer.parseInt(this.retrieveValue(this.propertyKey));
    }
    public boolean getBoolean() {
        return this.isSpecified() && Boolean.parseBoolean(this.value);
    }
}
