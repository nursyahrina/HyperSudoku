/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HS_Solution;
import java.io.*;
/**
 *
 * @author NURSYAHRINA
 */
public class IO extends HyperSudoku {

public static final String NORMAL = "\u001b[0m";
public static final String BOLD = "\033[1m";
public static final String BLACK = "\u001B[30m";
public static final String RED = "\u001B[31m";
public static final String GREEN = "\u001B[32m";
public static final String YELLOW = "\u001B[33m";
public static final String BLUE = "\u001B[34m";
public static final String MAGENTA = "\u001B[35m";
public static final String CYAN = "\u001B[36m";
public static final String WHITE = "\u001B[37m";

public static final String BACKGROUND_BLACK = "\u001B[40m";
public static final String BACKGROUND_RED = "\u001B[41m";
public static final String BACKGROUND_GREEN = "\u001B[42m";
public static final String BACKGROUND_YELLOW = "\u001B[43m";
public static final String BACKGROUND_BLUE = "\u001B[44m";
public static final String BACKGROUND_MAGENTA = "\u001B[45m";
public static final String BACKGROUND_CYAN = "\u001B[46m";
public static final String BACKGROUND_WHITE = "\u001B[47m";    
    
    public IO() {}
    
    public String readFile(String InputFile)
    {
        String content = null;
        File file = new File(InputFile);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
    
    public void readTXT(String namaFile){
	String input = readFile(namaFile);
	
        int pos = 0;
	for(int i = 0; i < 9; i++){            
            for(int j = 0; j < 9; j++){
		char temp;
                if((input.charAt(pos) != '\n') && (input.charAt(pos) != ' ')){
                    temp = input.charAt(pos);
                    pos++;
                    if (pos == input.length()){
                        break;
                    }
                    this.data[i][j] = toInt(temp);
                    
                    if ((input.charAt(pos) == '\n') || (input.charAt(pos) == ' ')){
                        pos++;
                        if (pos == input.length()){
                            break;
                        }						
                    }
                }
            }
	}
    }
    
    public int toInt(char inputChar){
        int X = 0;
        switch(inputChar) {
            case '1' : X = 1; break;
            case '2' : X = 2; break;
            case '3' : X = 3; break;
            case '4' : X = 4; break;
            case '5' : X = 5; break;
            case '6' : X = 6; break;
            case '7' : X = 7; break;
            case '8' : X = 8; break;
            case '9' : X = 9; break;
        }
        return X;
    }
    
    public void writeCMD(){
        
        System.out.println("                    =====================================");
        for (int i = 0; i < 9; i++){
            System.out.print("                    ");
            for (int j = 0; j < 9; j++){
                if ((j == 0) || (j == 3) || (j == 6)) {
                    System.out.print(BOLD + "|" + NORMAL);
                }
                else
                    System.out.print(" ");
                if ((i != 0) && (i != 4) && (i != 8) && (j != 0) && (j != 4) && (j != 8)){
                    if (!this.isElementFixed(this, i, j)) {
                        if (this.data[i][j] == 0)
                            System.out.print(BACKGROUND_CYAN + "   " + NORMAL);
                        else
                            System.out.print(BACKGROUND_CYAN + " " + this.data[i][j] + " " + NORMAL);
                    }
                    else System.out.print(BACKGROUND_CYAN + RED + " " + this.data[i][j] + " " + NORMAL);
                } else {
                    if (!this.isElementFixed(this, i, j)) {
                        if (this.data[i][j] == 0)
                            System.out.print(BACKGROUND_WHITE + "   " + NORMAL);
                        else
                            System.out.print(BACKGROUND_WHITE + " " + this.data[i][j] + " " + NORMAL);
                    }
                    else System.out.print(BACKGROUND_WHITE + RED + " " + this.data[i][j] + " " + NORMAL);
                }
                
            }
            System.out.println(BOLD + "|" + NORMAL);
            //System.out.println("");
            if ((i == 2) || (i == 5) || (i == 8)) {
                System.out.println("                    =====================================");
            }
            else 
                System.out.println("                    -------------------------------------");
        }
    }
    
    public void fillFixed(){  
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (this.data[i][j] != 0)
                    this.fixed[i][j] = 1;
                else
                    this.fixed[i][j] = 0;
            }
        }
    }
    
}
