import java.util.Random;
import java.util.Scanner;

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
     System.out.println("\nu/U: Update \nf/F: Find & Replace \nt/T: Transform \ns/S: Statistics \ne/E: Exit \n ------------- \n Enter your choice:");
   }

   /**
    * This method determines if a character is special character or not.
    * A character is considered special if it is not a letter, not
    * a digit and not a punctuation.
    * @param c the character
    * @return true if the character is special character, false otherwise.
    */
   public static boolean isSpecial(char c) { //complete not optimized
     if(isPunctuation(c)||Character.isDigit(c)||Character.isLetter(c)||c==' '){
          return false;
     }
    return true; //REPLACE THIS
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
          } else if(category=='L'&& Character.isLetter(list[i])) {
               counter++;
          } else if(category=='D'&& Character.isDigit(list[i])){
               counter++;
          } else if(category=='S'&& isSpecial(list[i])){
               counter++;
          } else if(category=='P'&& isPunctuation(list[i])){
               counter++;
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
          System.out.println("Punctuation characters account for "+pCount+" percent in the text.\n");
   }

   /**
    * This method breaks the input text into two halves, then reverse each half
    * and finally put them back together.
    * Examples: reverseHalves("hello") --> eholl, reverseHalves("keep") --> ekpe
    * @param text the input text
    * @return the "reversed halves" string
    */
    public static String reverseHalves(String text){ // maybe done
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
   public static String scramble(String text) { //maybe done
     String result ="";
     char[] list = text.toCharArray();
     if(text.length()==1){
          return text;
          }
     for(int i=0;i<Math.floor(text.length()/2);i++){
          result += list[i];
          result += list[text.length()-i-1];
     }
     if(text.length()%2==1){
          result += list[(int)Math.ceil(text.length()/2)];
     }
        return result; //REPLACE THIS
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
     String result="";
     char[] list = text.toCharArray();
     if(text.length()==1){return text;}
     int loops= (int)Math.floor(text.length()/4);
     for(int i =0;i <=loops-1;i++){// optmize
          for(int j = 0; j<1;j++){
          result += list[(j)+(i*4)];
          result += list[(j+2)+(i*4)];
          result += list[(j+1)+(i*4)];
          result += list[(j+3)+(i*4)];
          }
     }
     if(text.length()%4==3){
          result +=list[((loops+1)*4)-4];
          result +=list[((loops+1)*4)-2];
          result +=list[((loops+1)*4)-3];
     }else if(text.length()%4==2){
          result +=list[((loops+1)*4)-4];
          result +=list[((loops+1)*4)-3];
     }else if(text.length()%4==1){
          result +=list[text.length()-1];
         
     }
     return result;//REPLACE THIS
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
     args= new String[2];
    Scanner myObj = new Scanner(System.in);  
    System.out.println("Please enter the text: ");
    args[0] = myObj.nextLine();
    String userInput="";
    while(!(userInput.equalsIgnoreCase("e"))){
     printMenu();
     args[1]= myObj.nextLine();
     userInput= args[1];
     if(userInput.equalsIgnoreCase("u")){ //update
          System.out.println("Please enter the text: ");
          args[0] = myObj.nextLine();
          System.out.println("The new text is: "+args[0]);

     }else if(userInput.equalsIgnoreCase("f")){//find and replace

          System.out.println("Please enter the character sequence to find:");
          String oldString = myObj.nextLine();
          System.out.println("Please enter the replacement sequence:");
          String newString = myObj.nextLine();
          args[0] = args[0].replaceAll(oldString,newString);


          System.out.println("The new text is: "+args[0]);
     }else if(userInput.equalsIgnoreCase("s")){//statistics
          int l=count(args[0],'L'); int d=count(args[0],'D'); int s=count(args[0],'S'); int p=count(args[0],'P');
          printStats(args[0].length(),l,d,s,p);
     }else if(userInput.equalsIgnoreCase("t")){//transform
          int rand = gen.nextInt(3);
          if(rand==0){
               args[0] = reverseHalves(args[0]);
          }else if(rand==1){
               args[0] = scramble(args[0]);
          }else if(rand==2){
               args[0] = weave(args[0]);
          }
          System.out.println("The new text is: "+args[0]);
     }else if(userInput.equalsIgnoreCase("e")){
          //lol
     }else{
          System.out.println("Invalid option! Try again!");
     }
    }
     myObj.close();//very important
   }
}