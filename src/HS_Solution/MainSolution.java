
package HS_Solution;

import java.io.*;
import java.util.*;
//import java.awt.*;

/**
 *
 * @author NURSYAHRINA
 */
public class MainSolution {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static final String NORMAL = "\u001b[0m";
    public static final String RED = "\u001b[31m";   
    public static final String BLUE = "\u001b[34m";
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        IO matriksHS = new IO();
        IO solutionHS = new IO();
        long start = 0;
        long end = 0;
        long diff = 0;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n\n                                 " + BLUE + "HYPER-SUDOKU" + NORMAL +"\n");
        System.out.println("                 Choose to Solve Hyper-Sudoku 1 , 2, 3, or 4!");
        System.out.println("                          Enter number 1, 2, 3 or 4.");
        System.out.print("                                  " + RED + "Choice = "+ NORMAL);
        int choice = scan.nextInt();
        
        switch (choice) {
            case 1 :    matriksHS.readTXT("sudoku1.txt");
                        break;
            case 2 :    matriksHS.readTXT("sudoku2.txt");
                        break;
            case 3 :    matriksHS.readTXT("sudoku3.txt");
                        break;
            case 4 :    matriksHS.readTXT("sudoku4.txt");
                        break;            
        }
        //Mengisi matriks fixed untuk elemen yang merupakan bagian dari hypersudoku awal
        matriksHS.fillFixed();
        
        //Display HyperSudoku yang masih kosong
        matriksHS.writeCMD();
        
        System.out.println("");
        try {
            start = System.currentTimeMillis( ); //mulai mencatat waktu penyelesaian
            
            //Penyelesaian HyperSudoku
            solutionHS = matriksHS.Solution(matriksHS); 
            
            end = System.currentTimeMillis( ); //waktu selesai
            diff = end - start; //lama waktu penyelesaian
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
        System.out.println("                           Hyper-Sudoku " + BLUE + choice + NORMAL + " Solution : \n");
        solutionHS.writeCMD();
        System.out.println("");
        System.out.print("                   ");
        System.out.println("Solved in " + BLUE + diff + NORMAL + " ms with " + RED + solutionHS.assign + NORMAL + " assignments.\n");
        
    }

}
