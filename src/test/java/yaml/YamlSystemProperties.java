package yaml;

import yaml.model.EnvironmentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class YamlSystemProperties {
    YamlReader yamlReader = new YamlReader();
    Logger logger = LoggerFactory.getLogger(YamlSystemProperties.class);

    public YamlSystemProperties() throws IOException {
        setSystemPropertiesFromYamlEnvironment();
    }
    public void setSystemPropertiesFromYamlEnvironment() throws IOException {
        List<EnvironmentModel> listOfEnvironments = yamlReader.getConfig().getEnvironment().getListOfEnvironments();
        boolean foundActiveEnvironment = false;
        for(EnvironmentModel environmentModel : listOfEnvironments){
            if(environmentModel.isActive()){
                foundActiveEnvironment = true;
                Map<String, Object> environmentProperties = environmentModel.getProperties();
                for (Map.Entry entry : environmentProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    logger.info("Loaded environment property: {} = {}", entry.getKey().toString(), entry.getValue().toString());
                }
                logger.info("Loaded environment properties total: {}", environmentProperties.size());
            }
        }
        if (foundActiveEnvironment == false) loadDefaultEnvironment();
    }

    private void loadDefaultEnvironment() {
        logger.info("No environment was specified in config-local.yaml file");
        Map<String, Object> environmentProperties = new YamlReader().getConfig().getEnvironment().getDemo().getProperties();

        for (Map.Entry entry : environmentProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Loaded environment property: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
        logger.info("Loaded environment properties total: {}", environmentProperties.size());
    }
}
