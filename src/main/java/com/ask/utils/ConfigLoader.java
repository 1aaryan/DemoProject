package com.ask.utils;

import com.ask.constants.EnvType;
import org.checkerframework.checker.units.qual.C;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env=System.getProperty("env", String.valueOf(EnvType.DEV));
        switch (EnvType.valueOf(env)){
            case STAGE ->  properties= PropertyUtils.propertyLoader("/Users/aaryanfueled/IdeaProjects/DemoProject/src/main/resources/stgConfig.properties");

            case DEV ->  properties= PropertyUtils.propertyLoader("/Users/aaryanfueled/IdeaProjects/DemoProject/src/main/resources/config.properties");

            case PROD ->  properties= PropertyUtils.propertyLoader("/Users/aaryanfueled/IdeaProjects/DemoProject/src/main/resources/prodConfig.properties");

            default -> throw new IllegalStateException("invalid env type" + env);
        }
    }

    public static ConfigLoader getInstance(){

        if(configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
    }

    public String getUrl(){
        return properties.getProperty("baseUrl");
    }
}
