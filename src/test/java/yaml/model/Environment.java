package yaml.model;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    private EnvironmentModel demo;
    private EnvironmentModel uat;
    private EnvironmentModel prod;

    public EnvironmentModel getDemo() {
        return demo;
    }

    public EnvironmentModel getUat() {
        return uat;
    }

    public EnvironmentModel getProd() {
        return prod;
    }

    public List<EnvironmentModel> getListOfEnvironments(){
        List<EnvironmentModel> environments = new ArrayList<>();
        environments.add(getDemo());
        environments.add(getUat());
        environments.add(getProd());

        return environments;
    }
}
