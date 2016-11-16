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
        String lineOfText = "";
        
        final String nounPlaceholder, verbPlaceholder;
        nounPlaceholder = "#";
        verbPlaceholder = "%";
        int i=0;
        
        ArrayList<String> verbs = new ArrayList();
        ArrayList<String> nouns = new ArrayList();
        
        try{
            //Read the verb file
            in = new FileReader(verbFile);
            readFile = new BufferedReader(in);
            
            //Do while loop to fill the verbs arraylist with the verb values
            do{
                //Add the element on each line into the verbs arraylist
                verbs.add(i,readFile.readLine());
                i++;
            }
            //Stop the do-while when the last element in the array is null
            while(verbs.get(i-1) != null);
            //The last element in the arraylist is null so remove that element
            verbs.remove(i-1);
           
            
            //Read the noun file
            in = new FileReader(nounFile);
            readFile = new BufferedReader(in);
            
            //Do while loop to fill the nouns arraylist with the noun values
            i=0;
            do{
                //Add the element on each line into the nouns arraylist
                nouns.add(i,readFile.readLine());
                i++;
            }
            //Stop the do-while when the last element in the array is null
            while(nouns.get(i-1) != null);
            //The last element in the arraylist is null so remove that element
            nouns.remove(i-1);
            
            
            
            //Read the text file
            in = new FileReader(textFile);
            readFile = new BufferedReader(in);
            do{
                lineOfText += readFile.readLine()+"\n";
                
            }while((readFile.readLine())!=null);
            System.out.println(lineOfText);
            
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
