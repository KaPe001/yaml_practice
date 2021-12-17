package TestBase;

import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yaml.BaseYamlReader;

import java.io.IOException;

public class TestBase extends BaseYamlReader {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected WebDriver driver;
    public static BrowserEnvironment browserEnvironment;
    public static EnvironmentProperty environmentProperty;

    @BeforeAll
    static void setUp() {
        environmentProperty = EnvironmentProperty.getInstance();
        browserEnvironment = new BrowserEnvironment();
        logger.info("WebDriver initialized");
    }

    @BeforeEach
    void beforeEach() throws IOException {
        driver = browserEnvironment.getDriver();
//        basePage = new BasePage(driver);
        logger.debug("Driver initialized");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.debug("Driver closed");
    }
}
