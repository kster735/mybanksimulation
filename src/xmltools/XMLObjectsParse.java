/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author E2
 */
public class XMLObjectsParse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Person takis = new Person("Takis", "Takis", 78);
//        Person lakis = new Person("Lakis", "Lakis", 56);
//        Person makis = new Person("Makis", "Makis", 43);
//
//        ArrayList<Person> persons = new ArrayList<>();
//        persons.add(takis);
//        persons.add(lakis);
//        persons.add(makis);
//        
//        File f = new File("Persons.xml");
//        
//        try {
//            writePersonsToXML(f, persons);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        Hashtable<String, Hashtable<String, String>> myobjects = new Hashtable<String, Hashtable<String, String>>();
        

        try {
            Scanner fis = new Scanner(new FileInputStream("Persons.xml")); 
            myobjects = readObjectsFromXML(fis);
            fis.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
        
        System.out.println(myobjects);
    }
    
    public static <T> void writeObjectsToXML(File f, ArrayList<T> objects) throws IOException {
        FileOutputStream fos = new FileOutputStream(f);
        PrintWriter pwc = new PrintWriter(fos);
        pwc.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        for (T o : objects){
           pwc.print(o.toString());
        }
        pwc.close();
    }
    
     public static HashMap<String, Object> readObjectsFromXML_withmap(Scanner fis){
        String line, content, openningTag, closingTag, text, objectType, element;
        HashMap<String, Object> objects = new HashMap<String, Object>();
        //Hashtable<String, String> tempObject = new Hashtable<String, String>();

        // Counter is needed to store multiple objects of the same type
        int objectCounter=0;
        
        while (fis.hasNextLine()){
            boolean hasText = false;
            // Store next line of xml to process
            line = fis.nextLine().trim();
            
            // Don't do anything with xml heading
            if (line.startsWith("<?")){
                continue;
            }
            
            // if line starts with closing tag store the object.
            if (line.startsWith("</")){
                closingTag = line;
                objectType = closingTag.substring(2, closingTag.length() - 1) + objectCounter++;                
                objects.put(objectType, null);
                continue;
            }
                
            // Find and store next openning tag and it's content and store them
            int i = line.indexOf(">");
            openningTag = line.substring(0,i+1);
            content = line.substring(i+1);
            
            // Find and store text if the current xml element has one.
            int j = content.indexOf("</");
            if (j !=-1) {                
                text = content.substring(0,j);
                element = openningTag.substring(1,openningTag.length()-1);
                // build the the object by storing the field element and its value to a temp Hashtable
//                tempObject.put(element, text);
            }
            
        }
        return objects;
         
     }
    
    public static Hashtable<String, Hashtable<String, String>> readObjectsFromXML(Scanner fis){
        String line, content, openningTag, closingTag, text, objectType, element;
        Hashtable<String, Hashtable<String, String>> objects = new Hashtable<String, Hashtable<String, String>>();
        Hashtable<String, String> tempObject = new Hashtable<String, String>();

        // Counter is needed to store multiple objects of the same type
        int objectCounter=0;
        
        while (fis.hasNextLine()){
            boolean hasText = false;
            // Store next line of xml to process
            line = fis.nextLine().trim();
            
            // Don't do anything with xml heading
            if (line.startsWith("<?")){
                continue;
            }
            
            // if line starts with closing tag store the object.
            if (line.startsWith("</")){
                closingTag = line;
                objectType = closingTag.substring(2, closingTag.length() - 1) + objectCounter++;                
                objects.put(objectType, (Hashtable<String,String>) tempObject.clone());
                tempObject.clear();
                continue;
            }
                
            // Find and store next openning tag and it's content and store them
            int i = line.indexOf(">");
            openningTag = line.substring(0,i+1);
            content = line.substring(i+1);
            
            // Find and store text if the current xml element has one.
            int j = content.indexOf("</");
            if (j !=-1) {                
                text = content.substring(0,j);
                element = openningTag.substring(1,openningTag.length()-1);
                // build the the object by storing the field element and its value to a temp Hashtable
                tempObject.put(element, text);
            }
            
        }
        return objects;
    }

}


