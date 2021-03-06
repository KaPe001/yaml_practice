package TestBase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yaml.BaseYamlReader;
import yaml.BrowserRunner;
import yaml.YamlSystemProperties;

import java.io.IOException;

public class TestBase extends BaseYamlReader {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    public static WebDriver driver;
    public static YamlSystemProperties yamlSystemProperties;
    public static BrowserRunner browserRunner;

    @BeforeAll
    static void setUp() throws IOException {
        yamlSystemProperties = new YamlSystemProperties();
        logger.info("WebDriver initialized");
    }

    @BeforeEach
    void beforeEach()  {
        browserRunner = new BrowserRunner();
        logger.debug("Driver initialized");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.debug("Driver closed");
    }
}
