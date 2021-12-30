package yaml;

import yaml.model.EnvironmentModel;

import java.util.List;

public class BaseYamlReader {
    private YamlReader yamlReader;
    List<EnvironmentModel> environmentList;

    public String setCurrentEnvironmentUrl(){
        String url = null;
        url = System.getProperty("url");
        return url;
    }

    public EnvironmentModel getActiveObject(){
        EnvironmentModel e = null;
        yamlReader = new YamlReader();
        environmentList = yamlReader.getConfig().getEnvironment().getListOfEnvironments();
        for(EnvironmentModel env : environmentList){
            if(env.isActive()){
                e = env;
                break;
            }
        }
        return e;
    }
}
