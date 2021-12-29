import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import yaml.BrowserRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestForYaml extends TestBase {

    @Test
    public void goToWebSite() {
        BrowserRunner browserRunner = new BrowserRunner();
        driver = browserRunner.runBrowser();
        assertTrue(true);
        assertThat(driver.getTitle(), equalTo(getActiveObject().getTitle()));
    }
}