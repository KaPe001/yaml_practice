package configuration.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.yaml.model.ConfigModel;

import java.io.File;
import java.io.IOException;

public class YamlReader {

    private ConfigModel configModel;

    public ConfigModel getConfigModel() {
        return configModel;
    }

    public YamlReader() throws IOException {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        this.configModel = mapper.readValue(new File("src/main/resources/config-local.yaml"), ConfigModel.class);
    }
}
