import configuration.yaml.YamlReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        YamlReader yr = new YamlReader();

        System.out.println(yr.getConfigModel().getEnvironment());
        System.out.println(yr.getConfigModel().getEnvironment().switchTo().getUrl());
    }
}
