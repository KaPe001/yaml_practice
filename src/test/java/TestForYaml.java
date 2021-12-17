import TestBase.TestBase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestForYaml extends TestBase {

    @Test
    public void goToWebSite() {
        assertThat(driver.getTitle(), equalTo(getActiveObject().getTitle()));
    }
}