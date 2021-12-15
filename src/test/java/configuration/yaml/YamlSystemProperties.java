package configuration.yaml;

import java.io.IOException;

public class YamlSystemProperties {
    public YamlSystemProperties() throws IOException {
        setSystemProperties();
    }
    public void setSystemProperties() throws IOException {
        YamlReader yamlReader = new YamlReader();
        String webTitle = yamlReader.getConfigModel().getEnvironment().switchTo().getTitle();
        String webUrl = yamlReader.getConfigModel().getEnvironment().switchTo().getUrl();

        System.setProperty("webTitle", webTitle);
        System.setProperty("webUrl", webUrl);
    }
}
