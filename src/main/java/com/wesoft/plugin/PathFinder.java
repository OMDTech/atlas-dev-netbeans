/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesoft.plugin;

import java.io.File; 
import java.util.ArrayList;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ui.OpenProjects;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;



/**
 *
 * @author Abdulrahman
 */
public class PathFinder {
static  ArrayList<String> list = new ArrayList<String>();

    
    public static File getMainProjectRoot(){
        try {
            Project project = OpenProjects.getDefault().getMainProject();
            FileObject root = project.getProjectDirectory();
            return FileUtil.toFile(root);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String getMainProjectRootPath(){
        try {
            return getMainProjectRoot().getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static ArrayList<String> getProjects(){
        
         for (Project p :OpenProjects.getDefault().getOpenProjects()){
            FileObject root = p.getProjectDirectory();
            list.add(FileUtil.toFile(root).getAbsolutePath());
         }
        return list;
    }
}
