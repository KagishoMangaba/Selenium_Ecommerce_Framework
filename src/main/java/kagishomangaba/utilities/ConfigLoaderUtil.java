package kagishomangaba.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoaderUtil {

    private static Properties properties;

    private ConfigLoaderUtil() {}

    public static Properties getProperties() {
        if (properties == null) {
            loadProperties();
        }
        return properties;
    }

    private static void loadProperties() {
        try (InputStream input = ConfigLoaderUtil.class.getClassLoader()
                .getResourceAsStream("config/Globaldata.properties")) {

            if (input == null) {
                throw new RuntimeException("Unable to find Globaldata.properties in resources!");
            }

            properties = new Properties();
            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }
}
