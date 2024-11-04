import java.util.Random;

/** Project 1 skeleton code.
 *  Definition: Proj1.java is a console-based, menu-driven program that contains
 *  many useful and fun methods to modify a user's text. After prompting the 
 *  user to input a line of text, Proj1.java provides the user with options to 
 *  change the text, perform a find and replace, transform the text through a
 *  random choice of three modifiers, view statistics about the text, or to exit
 *  the program. The program continues, providing the user with the menu after
 *  their selection completes, until the user chooses to exit the program from
 *  the menu.
 *  @author Leo Abubucker
 *  Date: 7/10/2024
 * NOTE TO STUDENTS: OUTPUT SHOULD IDENTICALLY MATCH SAMPLE OUTPUT WHEN PROVIDED SAMPLE INPUT
 */
 
public class Proj1 {
   /** Defining the only Random variable you may (and must) use. 
   DO NOT CHANGE THIS LINE OF CODE.
   */
   static Random gen = new Random(10);
   
   /**
    * This method prints menu options in the following format:
    * Line 1: Empty Line
    * Line 2: u/U: Update
    * Line 3: f/F: Find & Replace
    * Line 4: s/S: Statistics
    * Line 5: e/E: Exit
    * Line 6: -------------
    * Line 7: Enter your choice:
    */
   public static void printMenu() {//complete
     System.out.println("\n u/U: Update \n f/F: Find & Replace \n s/S: Statistics \n e/E: Exit \n ------------- \n Enter your choice:");
   }

   /**
    * This method determines if a character is special character or not.
    * A character is considered special if it is not a letter, not
    * a digit and not a punctuation.
    * @param c the character
    * @return true if the character is special character, false otherwise.
    */
   public static boolean isSpecial(char c) { //complete not optimized
     if(isPunctuation(c)||isDigit(c)||isLetter(c)){
          return false;
     }
    return true; //REPLACE THIS
   }

     public static boolean isLetter(char c){
          char[] normalChars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
     for(char i:normalChars){
          if(i==c){
               return true;
          }
     }
     return false;
     }

     public static boolean isDigit(char c){
          char[] digits = {'1','2','3','4','5','6','7','8','9','0'};
          for(char i:digits){
               if(i==c){
                    return true;
               }
          }
          return false;
     }

   /**
    * This method determines if a character is special character or not.
    * Punctuation characters are !?.,'":;-_
    * @param c the character
    * @return true if the character is punctuation, false otherwise.
    */
   public static boolean isPunctuation(char c) {// complete not optimized
          char[] punctuationList = {'!','?','.',',','\'','\"',':',';','-','_'};
          for(char i:punctuationList){
               if(i==c){
                    return true;
               }
          }
        return false; //REPLACE THIS
   }

   /**
    * This method counts a particular category of characters
    * in a given peice of text.
    * @param text the input text
    * @param category specifies what to count in the input text.
    * @return the count for the particular character category
    */
   public static int count(String text, char category) {// maybe done 
   /*Categories:
   *any =A
   *letters = L
   *digits = D
   * special characters = S
   * punctuation characters = P
   */
     char[] list =text.toCharArray();
     int counter = 0;
     for(int i=0;i<list.length;i++){
          if(category=='A'){
               counter++;
               continue;
          } else if(category=='L'&& isLetter(list[i])) {
               counter++;
               continue;
          } else if(category=='D'&& isDigit(list[i])){
               counter++;
               continue;
          } else if(category=='S'&& isSpecial(list[i])){
               counter++;
               continue;
          } else if(category=='P'&& isPunctuation(list[i])){
               counter++;
               continue;
          }
     }
      return counter; //REPLACE THIS
   }

   /**
    * This method prints the basic statistics (i.e., count
    * and overall percentage) for different character categories
    * in a piece of text.
    * Statistics should be printed in the following format:
    * Line 1: There are a total of {characters} characters in the text.
    * Line 2: Letter characters account for {pct letter characters rounded to 2 decimal places} percent in the text.
    * Line 3: Digit characters account for {pct letter characters rounded to 2 decimal places} percent in the text.
    * Line 4: Special characters account for {pct letter characters rounded to 2 decimal places} percent in the text.
    * Line 5: Punctuation characters account for {pct letter characters rounded to 2 decimal places} percent in the text.
    * Line 6: Empty Line
    * @param length
    * @param letterCount
    * @param digitsCount
    * @param specialsCount
    * @param punctuationsCount
    */
   public static void printStats(int length, int letterCount, int digitsCount,
                                 int specialsCount, int punctuationsCount) {
          double l = length;
          double lCount = Math.round((letterCount/l)*10000)/100.0;
          double dCount = Math.round((digitsCount/l)*10000)/100.0;
          double sCount = Math.round((specialsCount/l)*10000)/100.0;
          double pCount = Math.round((punctuationsCount/l)*10000)/100.0;

          System.out.println("There are a total of "+length+" character in the text.");
          System.out.println("Letter characters account for "+lCount+" percent in the text.");
          System.out.println("Digit characters account for "+dCount+" percent in the text.");
          System.out.println("Special characters account for "+sCount+" percent in the text.");
          System.out.println("Punctuation characters account for "+pCount+" percent in the text.");
          System.out.println();
   }

   /**
    * This method breaks the input text into two halves, then reverse each half
    * and finally put them back together.
    * Examples: reverseHalves("hello") --> eholl, reverseHalves("keep") --> ekpe
    * @param text the input text
    * @return the "reversed halves" string
    */
    public static String reverseHalves(String text){
        char[] mainList = text.toCharArray();
        String result = "";
        for(int i=(int)Math.floor(text.length()/2);i>0;i--){
            result += mainList[i-1];
        }
        for(int i=text.length();i>Math.floor(text.length()/2);i--){
            result += mainList[i-1];
        }
        return result;
    }

   /**
    * This method reverse halves of the input text by putting the first
    * and last character next to each other, then the second and
    * second last, third and third last, so on so forth...
    * Examples: scramble("hello") --> hoell, scramble("world") --> wdolr
    * @param text the input text
    * @return the scrambled string
    */
   public static String scramble(String text) {
        return ""; //REPLACE THIS
   }

   /**
    * This method weaves the input text by putting
    * 1st and 3rd, 2nd and 4th, 5th and 7th etc. characters
    * of the input text next to each other.
    * Examples: weave("hello") --> hlelo, weave("keep") --> keep
    * @param text
    * @return input text weaved
    */
   public static String weave(String text){
        return ""; //REPLACE THIS
   }

   /**
    * The main method should:
    * 1. Request the user for text by printing: "Please enter the text: "
    * 2. Store the received text
    * 3. Until the user exits the program by typing e or E, the user should be:
    *   a) Shown the menu
        b) Prompted to respond to the menu
        c) Directed to the appropriate section based on their selection
        d) Repeat Steps a-d when the selection finishes
    *
    * @param args commandline args
    */
   public static void main(String[] args) {
     printStats(13,3,4,5,6);
   }
}