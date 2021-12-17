package yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import yaml.model.Config;

import java.io.File;

public class YamlReader {

    private Config config;

    public Config getConfig() {
        return config;
    }

    public YamlReader() {

        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.config = mapper.readValue(new File("src/main/resources/config-local.yaml"), Config.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}