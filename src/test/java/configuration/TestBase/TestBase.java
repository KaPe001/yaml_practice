package configuration.TestBase;

import configuration.BrowserEnvironment;
import configuration.yaml.YamlSystemProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected WebDriver driver;
    private static BrowserEnvironment browserEnvironment;

    @BeforeAll
    static void setDriver() throws IOException {
        browserEnvironment = new BrowserEnvironment();
        new YamlSystemProperties();
        logger.debug("WebDriver initialized");
    }

    @BeforeEach
    public void setUp() throws IOException {
        driver = browserEnvironment.getDriver();
        logger.debug("Timeout");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
        logger.debug("WebDriver closed properly");
    }
}
