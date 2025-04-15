package cucumber.utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    public ConfigLoader(Properties properties) {
        this.properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader(new Properties());
        }
        return configLoader;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getBaseURL() {
        String baseURL = properties.getProperty("baseURL");
        if (baseURL == null) {
            throw new RuntimeException("Base URL not found in properties file");
        }
        return baseURL;
    }

}
