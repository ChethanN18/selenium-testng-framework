package com.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

	    private static Properties props;

	    public static void load(String env) {
	        props = new Properties();
	        try (InputStream is =
	            ConfigLoader.class
	                .getClassLoader()
	                .getResourceAsStream("config/" + env + ".properties")) {

	            props.load(is);
	        } catch (Exception e) {
	            throw new RuntimeException("Config load failed", e);
	        }
	    }

	    public static String getProperty(String key) {
	        return props.getProperty(key);
	   }
}
