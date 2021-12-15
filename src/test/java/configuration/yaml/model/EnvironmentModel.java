package configuration.yaml.model;

import configuration.PropertyStore;
import lombok.Data;

@Data
public class EnvironmentModel {
    private BaseModel demo;
    private BaseModel uat;
    private BaseModel prod;

    private BaseModel baseModel;

    public BaseModel getBaseModel() {
        return baseModel;
    }

    public BaseModel getUat() {
        return uat;
    }

    public BaseModel getDemo() {
        return demo;
    }

    public void setDemo(BaseModel demo) {
        this.demo = demo;
    }

    public BaseModel getProd() {
        return prod;
    }

    public void setProd(BaseModel prod) {
        this.prod = prod;
    }

    public BaseModel switchTo(){
        String env = PropertyStore.ENVIRONMENT.getStringValue();

        switch(env){
            case "demo":
                baseModel = demo;
                break;
            case "uat":
                baseModel = uat;
                break;
            case "prod":
                baseModel = prod;
                break;
        }
        return baseModel;
    }
}
