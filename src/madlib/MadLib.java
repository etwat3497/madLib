/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madlib;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
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
        String newText = "";
        
        final String nounPlaceholder, verbPlaceholder;
        nounPlaceholder = "#";
        verbPlaceholder = "%";
        int i=0;
        
        ArrayList<String> verbs = new ArrayList();
        ArrayList<String> nouns = new ArrayList();
        ArrayList<String> text = new ArrayList();
        
        Random rand = new Random();
        

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
            
            //Do while loop to fill the text arraylist with the verb values
            i=0;
            do{
                //Add the element on each line into the text arraylist
                text.add(i,readFile.readLine());
                i++;
            }
            //Stop the do-while when the last element in the array is null
            while(text.get(i-1) != null);
            //The last element in the arraylist is null so remove that element
            text.remove(i-1);
            
            //For loop run for the size of the text arraylist
            for(int j=0;j<text.size();j++){

                //Set a temporary string at the index of j
                newText = text.get(j);
                    
                //Determine how many nouns are in the temporary string
                int nounCounter = 0;
                for( int k=0; k<newText.length(); k++ ) {
                    if(newText.charAt(k) == '#') {
                    nounCounter++;
                    } 
                }

                //Determine how many verbs are in the temporary string
                int verbCounter = 0;
                for( int k=0; k<newText.length(); k++ ) {
                    if(newText.charAt(k) == '%') {
                        verbCounter++;
                    } 
                }
                    
                //In this temporary string replace all the noun and verb placeholders with random nouns and verbs
                for(int k=0;k<nounCounter;k++){
                    //Set random numbers based on the size of the noun arraylist
                    int randomNoun = rand.nextInt(nouns.size());
                    //Replace the first noun placeholder available with a random noun
                    newText = newText.replaceFirst(nounPlaceholder, nouns.get(randomNoun));
                }
                    
                for(int k=0;k<nounCounter;k++){
                    //Set random numbers based on the size of the verb arraylist
                    int randomVerb = rand.nextInt(verbs.size());
                    //Replace the first verb placeholder available with a random verb
                    newText = newText.replaceFirst(verbPlaceholder, verbs.get(randomVerb));
                }
                    
                //Set the temporary string as the new element at the index j
                text.set(j,newText);
            }
            
            //Print the modified arraylist
            for(int k=0;k<text.size();k++){
                System.out.println(text.get(k));
            }
            
            //Close the buffered reader and file reader
            readFile.close();
            in.close();
        }
        //Catch a file not found exception and print the error message
        catch(FileNotFoundException e){
            System.out.println("File does not exist or could not be found.");
            System.err.println("IOException: "+e.getMessage());
        }
        //Catch an io exception and print the error message
        catch(IOException e){
            System.out.println("Problem reading file.");
            System.err.println("IOException: "+e.getMessage());
        }
    }
    
}
