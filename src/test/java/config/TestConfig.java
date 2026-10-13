package config;

import java.io.InputStream;
import java.util.Properties;

public final class TestConfig {

    private static final Properties PROPS = new Properties();

    static {
        try (InputStream in = TestConfig.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (in == null) {
                throw new IllegalStateException("application.properties not found");
            }
            PROPS.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    private TestConfig() {
    }

    public static String baseUrl() {
        return PROPS.getProperty("base.url");
    }

    public static String apiUrl() {
        return PROPS.getProperty("api.url");
    }

    public static int timeoutMs() {
        return Integer.parseInt(PROPS.getProperty("timeout.ms", "15000"));
    }

    public static boolean logRequests() {
        return Boolean.parseBoolean(PROPS.getProperty("log.requests", "true"));
    }
}