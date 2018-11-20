/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodge2_7seg;
import java.util.*;

/**
 *
 * @author Sagjig
 */
public class Bodge2_7seg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String charsToArray = "ABCDEFGHIJLNOPQRSTUYZ1234567890";
        String[] charArray = new String[charsToArray.length()];
        for (int i=0;i<charsToArray.length();i++){
            charArray[i] = charsToArray.substring(i,i+1);
        }
        //Create array "charArray" of 7seg-compatible characters, including 0-9 from a string "charsToArray"
        
        String binToArray = "1110111001111110011100111101100111110001111011110011011101111000001110000111011101101111110110011111100110000101101101100011110111110011101111011011111110000011011011011111001011001110110111011111111000011111111111011";
        String[] binArray = new String[binToArray.length()/7];
        for (int i=0;i<binToArray.length()/7;i++){
            binArray[i] = (binToArray.substring(i,i+7)+"0");
        }
        /*Create array "binArray" of binary values from string "binToArray", adding a 0 as the LSB for the decimal point. 
        (i.e. A B C D E F G + DP); see i.imgur.com/1SdDrbQ.jpg */
        
        Scanner scan = new Scanner(System.in);
        //Boilerplate bs for Java.util.Scanner (reads input)
        
        System.out.println("What are the words you can type on a 4-char 7seg display?");
        System.out.println("Enter string: ");
        String testStr = scan.nextLine();
        //Read input
        String output = " can be displayed!";
        if (testStr.length() > 4)
            output = " cannot be displayed (greater than 4 chars)";
        else
            for (int i=0;i<testStr.length();i++){
                if (testStr.substring(i,i+1).matches("k|m|v|w|x|"))
                        output = " cannot be displayed (illegal char)";
            }
        System.out.println(testStr.toUpperCase() + output + "\nThis would be encoded as:");
        String encoded = "";
        for (int i=0;i<testStr.length();i++){ //I know nested for loops are bad practice but I'm really just bodging this together right now
            for (int a=0;a < charArray.length; a++){
                if (testStr.toUpperCase().substring(i,i+1).contains(charArray[a])){
                    encoded += (binArray[a] + " ");
                    break;}
            }
            
        }
        System.out.println(encoded);
       
    }
    
}
