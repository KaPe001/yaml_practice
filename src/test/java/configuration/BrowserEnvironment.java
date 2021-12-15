package configuration;

import configuration.yaml.YamlReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.IOException;

public class BrowserEnvironment {
    private String browserName = "chrome";
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private int webBrowserImplicitTimeOut;
    private boolean attachScreenShot;
    private WebDriver webdriver;
    private EventFiringWebDriver driver;

    public BrowserEnvironment() {
        this.headlessBrowser = false;
        this.webElementTimeOut = 10;
        this.webBrowserImplicitTimeOut = 5;
        this.attachScreenShot = true;
        this.browserName = PropertyStore.BROWSER.isSpecified() ? PropertyStore.BROWSER.getStringValue() : this.browserName;
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
//        this.webElementTimeOut = PropertyStore.BROWSER_WEBELEMENT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_WEBELEMENT_TIMEOUT.getIntValue() : this.webElementTimeOut;
//        this.webBrowserImplicitTimeOut = PropertyStore.BROWSER_IMPLICIT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_IMPLICIT_TIMEOUT.getIntValue() : this.webBrowserImplicitTimeOut;
//        this.attachScreenShot = PropertyStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertyStore.BROWSER_ATTACH_SCREENSHOT.getBoolean() : this.attachScreenShot;
//        this.headlessBrowser = PropertyStore.BROWSER_HEADLESS.getBoolean();
    }

    public WebDriver getDriver() throws IOException {
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                webdriver = new ChromeDriver(optionsChrome);
                driver = new EventFiringWebDriver(webdriver);
//                YamlReader yamlReader = new YamlReader();
                driver.get(System.getProperty("webUrl"));
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.chromedriver().setup();
                optionsFirefox.addArguments("start-maximized");
//                webDriver = new FireFoxDriver(optionsFirefox);
//                webDriver.get(System.getProperty("appUrl"));
                break;
            default:
                WebDriverManager.iedriver().setup();
                webdriver.get(System.getProperty("appUrl"));
        }
        this.driver = driver;
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