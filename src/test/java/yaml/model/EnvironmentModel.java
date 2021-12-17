package yaml.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
public class EnvironmentModel {
    private String url;
    private String title;
    private String browser;
    private boolean active;

    private String defaultBrowser = "chrome";

    public String getBrowser() {
        return StringUtils.isEmpty(browser) ? (this.browser = defaultBrowser) : this.browser;
    }

    public boolean isActive() {
        return active;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, String> getProperties(){
        Map<String,String> properties = new HashMap<>();
        properties.put("url", getUrl());
        properties.put("browser", getBrowser());

        return properties;
    }
}
