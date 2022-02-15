/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Lenovo
 */
public class ConfigFileReader {
    public ConfigParam getConfigParam() throws IOException{
        ConfigParam configParam=new ConfigParam();
        //Here I will read the file and bound all the param
        Properties prop = new Properties();
	String propFileName = "db_config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            prop.load(inputStream);//load method of properties class given by java
            String userid = prop.getProperty("userid");
             String password = prop.getProperty("password");
             String host = prop.getProperty("host");
             String port = prop.getProperty("ports");
             String dbName = prop.getProperty("dbName");
             
             configParam.setUserid(userid);
             configParam.setPassword(password);
             configParam.setPort(port);
             configParam.setHost(host);
             configParam.setDbName(dbName);
             
	} else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
	}
        return configParam;
    }
}
