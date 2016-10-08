/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HS_Solution;

/**
 *
 * @author NURSYAHRINA
 */
public class HyperSudoku {
    
    protected int[][] data;
    protected int[][] fixed;
    protected int assign;
    
    public HyperSudoku() {
       this.data = new int[9][9];
       this.fixed = new int[9][9];
       this.assign = 0;
    }
    
    public boolean isElementFixed(HyperSudoku HS, int i, int j){
        boolean isFixed;
        
        //System.out.println("hoho" + i + j);
        isFixed = (HS.fixed[i][j] == 1);
        
        return isFixed;
    }
    
    public boolean isInHorizontal(HyperSudoku HS, int i, int j) {
        
        int k = 0;
        boolean inHorizontal = false;
        
        while((!inHorizontal) && (k <= 8)) {
            
            if ((HS.data[i][j] == HS.data[i][k]) && (j != k))
                inHorizontal = true;
            k++;
        }
        
        return inHorizontal;
    }
    
    public boolean isInVertical(HyperSudoku HS, int i, int j) {
        
        int k = 0;
        boolean inVertical = false;
        while((!inVertical) && (k <= 8)) {
            if ((HS.data[i][j] == HS.data[k][j]) && (k != i))
                inVertical = true;
            k++;
        }
        
        return inVertical;
    
    }
    
    public int coloredSquare(HyperSudoku HS, int i, int j) {
        
        int block = 0;
        /*
        if ((i == 0) || (j == 0) || (i == 4) || (j == 4) || (i == 8) || (j == 8))
            block = 0;
        else 
        */              //elemen matriks[i][j] tidak berada di matriks warna manapun
        
        
        if ((i > 0) && (i <= 3) && (j > 0) && (j <= 3))
            block = 1;
        else if ((i > 0) && (i <= 3) && (j > 4) && (j <= 7))
            block = 2;
        else if ((i > 4) && (i <= 7) && (j > 0) && (j <= 3))
            block = 3;
        else if ((i > 4) && (i <= 7) && (j > 4) && (j <= 7))
            block = 4;
        
        return block;
    }
    
    public boolean isInColoredSquare (HyperSudoku HS, int i, int j){
        int ii, jj;
        int cblock;
        cblock = HS.coloredSquare(HS,i,j);
        boolean inColoredSquare = false;
        
        switch (cblock) {
            case 1   :  ii = 1; 
                        while((ii <= 3) && (!inColoredSquare)) {
                            jj = 1;
                            while ((jj <= 3) && (!inColoredSquare)) {
                                inColoredSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 2   :  ii = 1;
                        while((ii <= 3) && (!inColoredSquare)) {
                            jj = 5;
                            while ((jj <= 7) && (!inColoredSquare)) {
                                inColoredSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 3   :  ii = 5;
                        while((ii <= 7) && (!inColoredSquare)) {
                            jj = 1;
                            while ((jj <= 3) && (!inColoredSquare)) {
                                inColoredSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 4   :  ii = 5;
                        while((ii <= 7) && (!inColoredSquare)) {
                            jj = 5;
                            while ((jj <= 7) && (!inColoredSquare)) {
                                inColoredSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
        }
        
        return inColoredSquare;
    }
    
    public int whiteSquare(HyperSudoku HS, int i, int j) {
        
        int block;
        
        if ((i >= 0) && (i < 3) && (j >= 0) && (j < 3))
            block = 1;
        else if ((i >= 0) && (i < 3) && (j >= 3) && (j < 6))
            block = 2;
        else if ((i >= 0) && (i < 3) && (j >= 6) && (j < 9))
            block = 3;
        else if ((i >= 3) && (i < 6) && (j >= 0) && (j < 3))
            block = 4;
        else if ((i >= 3) && (i < 6) && (j >= 3) && (j < 6))
            block = 5;
        else if ((i >= 3) && (i < 6) && (j >= 6) && (j < 9))
            block = 6;
        else if ((i >= 6) && (i < 9) && (j >= 0) && (j < 3))
            block = 7;
        else if ((i >= 6) && (i < 9) && (j >= 3) && (j < 6))
            block = 8;
        else // if ((i >= 6) && (i < 9) && (j >= 6) && (j < 9))
            block = 9;
        
        return block;
    }
    
    public boolean isInWhiteSquare(HyperSudoku HS, int i, int j){
        
        int ii, jj;
        int wblock;
        wblock = HS.whiteSquare(HS, i, j);
        boolean inWhiteSquare = false;
        
        switch (wblock) {
            case 1   :  ii = 0; //System.out.println("block 1");
                        while((ii <= 2) && (!inWhiteSquare)) {
                            jj = 0;
                            while ((jj <= 2) && (!inWhiteSquare)) {
                                inWhiteSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 2   :  ii = 0; 
                        while((ii <= 2) && (!inWhiteSquare)) {
                            jj = 3;
                            while ((jj <= 5) && (!inWhiteSquare)) {
                                inWhiteSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 3   :  ii = 0; 
                        while((ii <= 2) && (!inWhiteSquare)) {
                            jj = 6;
                            while ((jj <= 8) && (!inWhiteSquare)) {
                                inWhiteSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 4   :  ii = 3; 
                        while((ii <= 5) && (!inWhiteSquare)) {
                            jj = 0;
                            while ((jj <= 2) && (!inWhiteSquare)) {
                                inWhiteSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 5   :  ii = 3; 
                        while((ii <= 5) && (!inWhiteSquare)) {
                            jj = 3;
                            while ((jj <= 5) && (!inWhiteSquare)) {
                                inWhiteSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 6   :  ii = 3; 
                        while((ii <= 5) && (!inWhiteSquare)) {
                            jj = 6;
                            while ((jj <= 8) && (!inWhiteSquare)) {
                                inWhiteSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 7   :  ii = 6; 
                        while((ii <= 8) && (!inWhiteSquare)) {
                            jj = 0;
                            while ((jj <= 2) && (!inWhiteSquare)) {
                                inWhiteSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 8   :  ii = 6; 
                        while((ii <= 8) && (!inWhiteSquare)) {
                            jj = 3;
                            while ((jj <= 5) && (!inWhiteSquare)) {
                                inWhiteSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
            case 9   :  ii = 6; 
                        while((ii <= 8) && (!inWhiteSquare)) {
                            jj = 6;
                            while ((jj <= 8) && (!inWhiteSquare)){
                                inWhiteSquare = !( ((HS.data[ii][jj] != HS.data[i][j]) || ((ii == i)&&(jj == j)) ) );
                                jj++;
                            }
                            ii++;
                        }
                        break;
        }
        
        return inWhiteSquare;
    }
    
    public IO Solution(IO HS) {
        
        IO solution = new IO();
        solution = HS;
        
        int i = 0;
        int j = 0;
        boolean back = false;
        
        while(i <= 8) {
            if (!HS.isElementFixed(HS, i, j))
            {            
                if (solution.data[i][j] <= 8){
                    back = false;
                    solution.data[i][j] += 1;
                    solution.assign += 1;
                    
                    if (!(solution.isInHorizontal(solution, i, j))) {
                        
                        if (!(solution.isInVertical(solution, i, j))) {
                            
                            if (!(solution.isInWhiteSquare(solution, i, j))) {
                                
                                if (!(solution.isInColoredSquare(solution, i, j))) {
                                    
                                    if (j == 8){ //pass karena lolos semua syarat
                                        i++;
                                        j = 0;
                                    }
                                    else j++; 
                                }
                            }
                        }
                    }
                }
                else { //back karena solusi sudah mencapai 9
                    back = true;
                    solution.data[i][j] = 0;
                    if (j == 0){
                        i--;
                        j = 8;   
                    }
                    else j--;
                        
                }
            }
            else {
                if (!back){
                    if (j == 8){  //pass karena termasuk elemen fixed
                        i++;
                        j = 0;
                    }
                    else j++;
                }
                else {
                    if (j == 0){
                        i--;
                        j = 8;   
                    }
                    else j--;
                }
                
            }
           
        }//close while      
        return solution;
    }
    
}
    