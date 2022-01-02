
/**
 * Recursion runner tests all three methods from the recursion assignment,
 *
 * @author (your name)
 * @version 2/23/2021
 */
import java.lang.Math;
import java.util.*;
public class RecursionRunner
{
    public static void main(String[] args) {
     System.out.println("Testing the handshake method: ");
    System.out.println("Trying the handshake method for 1 person, we get " + 
    Handshakes.handshake(1) + ".");
    System.out.println("Trying the handshake method for 2 persons, we get " + 
    Handshakes.handshake(2) + ".");
    System.out.println("Trying the handshake method for 5 persons, we get " + 
    Handshakes.handshake(5) + ".");
    System.out.println("Trying the handshake method for 15 persons, we get " + 
    Handshakes.handshake(15) + ".");
    System.out.println("Trying the handshake method on for 100 persons, we get " + 
    Handshakes.handshake(100) + ".");
    System.out.println("Now testing the jumpIt method: ");
    //0 	3	80	6	57	10
    int[] board1= {0,3,80,6,57,10};
    System.out.println("The method jumpIt on board1" +
    "([0,3,80,6,57,10]) returns " + 
    + Jump_It.jumpIt(board1) + ".");
    //int[] board2 = new int[100];
    //for (int i = 1; i < 100; i++) {
    //board2[i] = (int)(Math.floor(Math.random()*100));
    //}
    // System.out.println("The method jumpIt on board2 of size " + board2.length + ": " + Arrays.toString(board2) + " returns " 
    // + Jump_It.jumpIt(board2) + ".");
    //The solution is not scalable for n=100 and my computer started to 
    //overheat when I
    //tried and array of size 100.
    int[] board3 = new int[20];
    for (int i = 1; i < 20; i++) {
     board3[i] = (int)(Math.floor(Math.random()*100));
    }
    System.out.println("The method jumpIt on board3 of size " + board3.length + ": " + Arrays.toString(board3) + " returns " 
    + Jump_It.jumpIt(board3) + ".");
    int[] board4 = new int[25];
    for (int i = 1; i < 25; i++) {
     board4[i] = (int)(Math.floor(Math.random()*100));
    }
    System.out.println("The method jumpIt on board4 of size " + board4.length + ": " + Arrays.toString(board4) + " returns " 
    + Jump_It.jumpIt(board4) + ".");
    int[] board5 = new int[30];
    for (int i = 1; i < 30; i++) {
     board5[i] = (int)(Math.floor(Math.random()*100));
    }
    System.out.println("The method jumpIt on board5 of size " + board5.length + ": " + Arrays.toString(board5) + " returns " 
    + Jump_It.jumpIt(board5) + ".");
    // Hangs on board of size 50
    // int[] board6 = new int[50];
    // for (int i = 1; i < 50; i++) {
     // board6[i] = (int)(Math.floor(Math.random()*100));
    // }
     // System.out.println("The method jumpIt on board6 of size " + board6.length + ": " + Arrays.toString(board6) + " returns " 
    // + Jump_It.jumpIt(board6) + ".");
    //The solution is not scalable for n=100 and my computer started to 
    //overheat when I tried and array of size 50.
    
    int[] board7 = new int[40];
    for (int i = 1; i < 40; i++) {
     board7[i] = (int)(Math.floor(Math.random()*100));
    }
    System.out.println("The method jumpIt on board7 of size " + board7.length + ": " + Arrays.toString(board7) + " returns " 
    + Jump_It.jumpIt(board7) + ".");
    /* Hangs on board of size 45 on my machine
    *int[] board8 = new int[45];
    *for (int i = 1; i < 45; i++) {
    * board8[i] = (int)(Math.floor(Math.random()*100));
    *}
    * System.out.println("The method jumpIt on board8 of size " + board8.length + ": " + Arrays.toString(board8) + " returns " 
    * + Jump_It.jumpIt(board8) + ".");
    *The solution is not scalable for n=100 and my computer started to 
    *overheat when I tried and array of size 45.
    */
    System.out.println("Now testing the contains method: ");
    System.out.println("Checking Contains.contains(\"Java programming\",\""
    + "ogr\"), we get " + Contains.contains("Java programming", "ogr") + ".");
    System.out.println("Checking Contains.contains(\"Java programming\",\""
    + "grammy\"), we get " + Contains.contains("Java programming", "grammy") + ".");
     System.out.println("Checking Contains.contains(\"Java\",\""
    + "Jaa\"), we get " + Contains.contains("Java", "Jaa") + ".");
    }
}
