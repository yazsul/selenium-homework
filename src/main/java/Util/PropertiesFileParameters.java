package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileParameters {
    private final String CONFIG_PROPERTIES_PATH = "src\\main\\resources\\configuration.properties";

    private final String USERNAME = "username";
    private final String PASSWORD = "password";
    private final String SUT_URL = "sut.url";

    private String username;
    private String password;
    private String sutUrl;

    private Properties properties;

    public PropertiesFileParameters() {
        properties = new Properties();

        try (InputStream input = new FileInputStream(CONFIG_PROPERTIES_PATH)) {
            properties.load(input);
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        username = properties.getProperty(USERNAME);
        password = properties.getProperty(PASSWORD);
        sutUrl = properties.getProperty(SUT_URL);
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getSutUrl(){
        return this.sutUrl;
    }
}
