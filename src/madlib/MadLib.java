/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madlib;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author etwat3497
 */
public class MadLib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File verbFile = new File("verbs.txt");
        File nounFile = new File("nouns.txt");
        File textFile = new File("story.txt");
        FileReader in;
        BufferedReader readFile;
        String lineOfText;
        
        ArrayList<String> verbs = new ArrayList();
        ArrayList<String> nouns = new ArrayList();
        
        try{
            //Read the verb file
            in = new FileReader(verbFile);
            readFile = new BufferedReader(in);
            //Get this to add all the verbs to the verb arraylist and replace
            
            
            //Read the text file
            in = new FileReader(textFile);
            readFile = new BufferedReader(in);
            while((lineOfText = readFile.readLine())!=null){
                System.out.println(lineOfText);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File does not exist or could not be found.");
            System.err.println("IOException: "+e.getMessage());
        }
        catch(IOException e){
            System.out.println("Problem reading file.");
            System.err.println("IOException: "+e.getMessage());
        }
    }
    
}
