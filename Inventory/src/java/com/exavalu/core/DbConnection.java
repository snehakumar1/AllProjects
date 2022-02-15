/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.core;

/**
 *
 * @author Lenovo
 */
import java.util.*;
// Importing the FileWriter class  
import java.io.FileWriter;   
   
// Importing the IOException class for handling errors  
import java.io.IOException;  
import java.util.logging.Level;
import java.util.logging.Logger;
public class DbConnection {  //this is singleton class
    public static DbConnection fileConnection;
    private DbConnection(){
        System.out.println("Message from constructor");
    }
    public static DbConnection getInstances(){
        if(fileConnection == null){
            fileConnection = new DbConnection();
        }
        return fileConnection;
    }
    
    public void getDbConnection(){
        ConfigFileReader configFileReader=new ConfigFileReader();
        /*try {
            //ConfigParam configParam=configFileReader.getConfigParam();
            //System.out.println("UserId: "+configParam.getUserid());
        } catch (IOException ex) {
            //Logger.getLogger(FileConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("IO Exception");
        }*/
    }
    
    public void WriteEmployeeInfo(ArrayList list){
        System.out.println("All employee information");
         
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
             try {
      FileWriter myWriter = new FileWriter("Employee.txt",true);
      myWriter.write(list.get(i).toString()+"\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        }
    }
    
}
