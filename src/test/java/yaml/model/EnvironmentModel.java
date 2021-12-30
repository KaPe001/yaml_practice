package yaml.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class EnvironmentModel {
    private boolean active;
    Map<String,Object> properties = new HashMap<>();

    public boolean isActive() {
        return active;
    }

    @JsonAnySetter
    void setProperties(String key, Object value){
        properties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getProperties(){
        return properties;
    }
}
