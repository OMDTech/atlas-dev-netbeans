/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesoft.plugin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Abdulrahman
 */
public class FileWork {
      ArrayList<String> list = new ArrayList();
     public  void  readFile(File f) throws FileNotFoundException, IOException{
     BufferedReader reader = new BufferedReader(new FileReader(f));
     String s; 
     while((s=reader.readLine())!=null){
         list.add(s);
     }
   System.out.println(  list.get(list.size()-1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        list.remove(list.size()-1);
      for (int i =0;i<list.size();i++){
          writer.append(list.get(i)+"\n");
          if (list.get(i).contains("<dependencies>")){
                writer.append("\n<dependency>" + 
"            \n<groupId>jta</groupId>\n" +
"            <artifactId>jta</artifactId>\n" +
"            <version>1.0.1b</version>\n" +
"            <scope>provided</scope>\n" + "</dependency>\n");
                writer.append("\n<dependency>" + 
"            \n<groupId>jndi</groupId>\n" +
"            <artifactId>jndi</artifactId>\n" +
"            <version>1.2.1</version>\n" +
"            <scope>provided</scope>\n" + "</dependency>\n");
            }
      }
      
      writer.append(" <repositories>\n" +
"         <repository>\n" +
"            <id>atlassian</id>\n" +
"            <name>Atlassian Repository</name>    \n" +
"               <url>https://maven.atlassian.com/content/groups/public/</url>\n" +
"            <snapshots>\n" +
"                <enabled>true</enabled>\n" +
"            </snapshots>\n" +
"            <releases>\n" +
"                <enabled>true</enabled>\n" +
"            </releases>\n" +
"        </repository>\n" +
"    </repositories>\n "
              + "<pluginRepositories>\n" +
"        <pluginRepository>\n" +
"            <id>atlassian-public</id>\n" +
"            <url>https://m2proxy.atlassian.com/repository/public/</url>\n" +
"            <releases>\n" +
"                <enabled>true</enabled>\n" +
"            </releases>\n" +
"            <snapshots>\n" +
"                <enabled>true</enabled>\n" +
"            </snapshots> \n" +
"        </pluginRepository>\n" +
"    </pluginRepositories>"+"\n"+
              "</project>");
        reader.close();
        writer.close();

    }
}
