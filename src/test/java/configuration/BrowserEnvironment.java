package configuration;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserEnvironment {

    private String browserName = "chrome";
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private int webBrowserImplicitTimeOut;
    private boolean attachScreenShot;
    private Logger logger;
    private WebDriver driver;

    public BrowserEnvironment() {
    this.headlessBrowser = false;
    this.webElementTimeOut = 10;
    this.webBrowserImplicitTimeOut = 5;
    this.attachScreenShot = true;
    logger = LoggerFactory.getLogger(BrowserEnvironment.class);
    this.browserName = PropertiesStore.BROWSER.isSpecified() ? PropertiesStore.BROWSER.getValue() : this.browserName;
    // BrowserType.setBrowser(this.browserName.toUpperCase());
    //this.setEnvironmentName(PropertyStore.BROWSER_ENVIRONMENT.isSpecified() ? PropertyStore.BROWSER_ENVIRONMENT.getValue().toUpperCase() : "LOCAL");
    this.initBrowserSettings();
}

    public String getBrowserName() {
        return this.browserName;
    }

    public boolean isHeadlessBrowser() {
        return this.headlessBrowser;
    }
    public int getWebBrowserImplicitTimeOut() {
        return this.webBrowserImplicitTimeOut;
    }

    public boolean isAttachScreenShotEnabled() {
        return this.attachScreenShot;
    }
    public int getWebElementTimeOut() {
        return this.webElementTimeOut;
    }
    private void initBrowserSettings() {
        this.webElementTimeOut = PropertiesStore.BROWSER_WEBELEMENT_TIMEOUT.isSpecified() ? PropertiesStore.BROWSER_WEBELEMENT_TIMEOUT.getIntValue() : this.webElementTimeOut;
        this.webBrowserImplicitTimeOut = PropertiesStore.BROWSER_WEBELEMENT_TIMEOUT.isSpecified() ? PropertiesStore.BROWSER_WEBELEMENT_TIMEOUT.getIntValue() : this.webBrowserImplicitTimeOut;
        this.attachScreenShot = PropertiesStore.BROWSER_ATTACHSCREENSHOT.isSpecified() ? PropertiesStore.BROWSER_ATTACHSCREENSHOT.getBoolean() : this.attachScreenShot;
        this.headlessBrowser = PropertiesStore.BROWSER_HEADLESS.getBoolean();
    }
    public WebDriver getDriver() {
        WebDriver driver;
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                driver.get(System.getProperty("appUrl"));
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                driver.get(System.getProperty("appUrl"));
                break;
            default:
                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsDefault);
                driver.get(System.getProperty("appUrl"));
        }
        this.driver=driver;
        return this.driver;
    }
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setHeadlessBrowser(boolean headlessBrowser) {
        this.headlessBrowser = headlessBrowser;
    }
    public void setWebElementTimeOut(int webElementTimeOut) {
        this.webElementTimeOut = webElementTimeOut;
    }
    public void setWebBrowserImplicitTimeOut(int webBrowserImplicitTimeOut) {
        this.webBrowserImplicitTimeOut = webBrowserImplicitTimeOut;
    }
    public void setAttachScreenShot(boolean attachScreenShot) {
        this.attachScreenShot = attachScreenShot;
    }
}
