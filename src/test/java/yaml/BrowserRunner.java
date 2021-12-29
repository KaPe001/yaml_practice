package yaml;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserRunner extends BaseYamlReader {
    WebDriver driver;

    public WebDriver runBrowser() {
        switch (this.getActiveObject().getBrowser()) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                driver.get(setCurrentEnvironmentUrl());
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.chromedriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                driver.get(System.getProperty("appUrl"));
                break;
            case "edge":
                EdgeOptions edgeOption= new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                edgeOption.addArguments("start-maximized");
                driver = new EdgeDriver(edgeOption);
                driver.get(setCurrentEnvironmentUrl());
            default:
                WebDriverManager.iedriver().setup();
                driver.get(setCurrentEnvironmentUrl());
        }
        return this.driver;
    }
}
