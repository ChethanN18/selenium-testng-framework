package com.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

	    private static Properties props;

	    public static void load(String env) {
	        props = new Properties();
	        try (InputStream is = ConfigLoader.class.getClassLoader().getResourceAsStream("Configuration/" + env + ".properties")) {

	            if (is == null) {
	                throw new RuntimeException("Configuration file not found for env: " + env);
	            }

	            props.load(is);

	        } catch (IOException e) {
	            throw new RuntimeException("Config load failed for environment: " + env, e);
	        }
	    }

	    public static String getProperty(String key) {
	        return props.getProperty(key);
	   }
}
