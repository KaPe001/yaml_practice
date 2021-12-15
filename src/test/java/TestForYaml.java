import configuration.TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestForYaml extends TestBase {

    @Test
    public void goToWebSite() {

        String expectedTitle = System.getProperty("webTitle");
        String actualTitle = driver.getTitle();

        assertThat(actualTitle, equalTo(expectedTitle));
    }
}
