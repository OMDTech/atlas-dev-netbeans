package com.scolution.plugin;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import org.openide.awt.ActionID;
import javax.swing.JOptionPane;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Bugtracking",
        id = "com.scolution.plugin.AddDependenceyMenuItem"
)
@ActionRegistration(
        displayName = "#CTL_AddDependenceyMenuItem"
)
@ActionReference(path = "Menu/File", position = -100)
@Messages("CTL_AddDependenceyMenuItem=Add Atlassian Dependency")
public final class AddDependenceyMenuItem implements ActionListener {
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String path = PathFinder.getProjects().get(0);
        File f = new File(path+"\\pom.xml");
        FileWork fileWork= new FileWork();
        if (f.exists()){
            try {
                if (!fileWork.readFile(f))
                {
                    JOptionPane.showMessageDialog(null, "already exists");
                }else{
                JOptionPane.showMessageDialog(null, "dependency added successfully");

                }

            } catch (IOException ex ) {
                Exceptions.printStackTrace(ex);
               JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }else{
            JOptionPane.showMessageDialog(null , "Couldnt finde Pom File");
        }
    }
    
   
}
