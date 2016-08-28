package pupkin;


import java.io.BufferedReader;
import java.io.*;
import java.nio.file.Files;

/**
 * Created by ramzes on 22.08.2016.
 */
public class FileManeger {

    //напсиать список методов которые будут выпонять действия по работе с файлами
    // создать , удалить , переименовать

    //create method
    public static  void CreateFile(String FileNamePar){
        try {
            FileWriter writter = new FileWriter(FileNamePar);
            System.out.println("Ok,your file --"+ FileNamePar+ "-- created!");

        } catch (IOException e) {
            System.out.println("Sorry, something wrong");
        }

    }
    // /dellete method
    public static  void DelleteFile(String FileNamePar){
             File f = new File(FileNamePar);

           if( f.delete()){
               System.out.println("File was deleted");
           }
        else{
               System.out.println("File was not deleted");
           }

        System.out.println("Ok,your file --"+ FileNamePar+ "-- created!");

    }




    public static void main(String[] args) {
        CreateFile("F:\\1.txt");
        DelleteFile("F:\\1.txt");

    }
}//class 
