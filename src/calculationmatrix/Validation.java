/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculationmatrix;

import java.util.Scanner;

/**
 *
 * @author tudo766
 */
public class Validation {

    Scanner sc = new Scanner(System.in);
    //Input choice of user
    int choose(int a,int b,String mess){
        while (true) {
            try {
                String value = sc.nextLine();
                int ret=Integer.parseInt(value);
                if (ret<a||ret>b) {
                    System.err.println(mess);
                }else
                    return ret;
            } catch (Exception e) {
                System.err.println("Enter integer number!");
            }
        }
    }
    //Enter value of matrix
    int enterValue(String mess) {
        while (true) {
            try {
                String value = sc.nextLine();
                int ret=Integer.parseInt(value);
                if (ret<Integer.MIN_VALUE&ret>Integer.MAX_VALUE) {
                    System.err.println(mess);
                }else
                    return ret;
            } catch (Exception e) {
                System.err.println(mess);
            }
        }
    }
    //check for sub and add
    //number col and row of matrix 1 = matrix2
    boolean validMatrixforSubandAdd(int [][]a,int[][]b){
        if (a.length==b.length&&a[0].length==b[0].length) {
            return true;
        }
        return false;
    }
    //check for multiply
    //number of columm matrix 1 = number row of matrix 2
    boolean validMatrixforMultiply(int [][]a,int[][]b){
        if (a[0].length==b.length) {
            return true;
        }
        return false;
    }
    
}
