package pupkin;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


/**
 * Created by ramzes on 25.08.2016.
 */
public class FileMagerOperations {


    //You need have: same icons and Data in Vector<File> format
    public static void drawFoldersAndFiles(JList listPar, File filePar){
        File[] tempFiles = filePar.listFiles();
        if (listPar.equals(GUI_Filemanager.list1)){
            System.out.println("yes");
            GUI_Filemanager.label_disk_left.setText(filePar.getPath());
        }
            else{
            GUI_Filemanager.label_disk_right.setText(filePar.getPath());

        }
        DefaultListModel listModel = new DefaultListModel();
        Set<File> fileSet  = new TreeSet<File>();
        Set<File> dirSet  = new TreeSet<File>();
        for (File file : tempFiles) {
            if (file.isDirectory()) {  dirSet.add(file); }
            else { fileSet.add(file); }
        }

        for (File filee : dirSet) {    listModel.addElement(filee);}
        for (File filee : fileSet) {   listModel.addElement(filee);}
        listPar.setModel(listModel);


        listPar.setCellRenderer(
                new DefaultListCellRenderer() {
                    public Component getListCellRendererComponent(
                            JList list,Object value, int index, boolean isSelected,boolean cellHasFocus) {

                        Component component = super.getListCellRendererComponent(
                                list,value, index, isSelected, cellHasFocus);


                        JLabel label = (JLabel) component;
                        URL imgUrl = getClass().getResource("icon_small.png");
                        ImageIcon icon = new ImageIcon(imgUrl);

                        URL imgUrl2 = getClass().getResource("folder-green.png");
                        ImageIcon icon2 = new ImageIcon(imgUrl2);

                        //to display only name of file (without parent)
                        label.setText(((File)value).getName());

                        //To display icons of folders
                        if (((File) value).isDirectory()){
                            label.setIcon(icon);
                        }
                         return label;
                    }
                });




    }//end of method


    public static void metod() throws IOException {
         File[] root_C = File.listRoots();

        //when disk only one -  show it on two subwindows
        if (root_C.length < 2) {
            drawFoldersAndFiles(GUI_Filemanager.list1, root_C[0]);
            drawFoldersAndFiles(GUI_Filemanager.list2, root_C[0]);

        } else {
           drawFoldersAndFiles(GUI_Filemanager.list1, root_C[0]);
           drawFoldersAndFiles(GUI_Filemanager.list2, root_C[1]);
 //            fileVectorRightDrive.add(0,new File("..."));
        }


    }


    public static void main(String[] args) throws IOException {
        metod();

    }//main

}//class 
