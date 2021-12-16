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
//        BrowserType.setBrowser(this.browserName.toUpperCase());
//        this.setEnvironmentName(PropertyStore.BROWSER_ENVIRONMENT.isSpecified() ? PropertyStore.BROWSER_ENVIRONMENT.getValue().toUpperCase() : "LOCAL");
    }


    public WebDriver getDriver() throws IOException {
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                webdriver = new ChromeDriver(optionsChrome);
                driver = new EventFiringWebDriver(webdriver);
                YamlReader yamlReader = new YamlReader();
                String url = yamlReader.getConfigModel().getEnvironment().switchTo().getUrl();
                driver.get(System.getProperty("appUrl"));
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
}