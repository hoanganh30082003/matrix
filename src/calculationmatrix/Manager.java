/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculationmatrix;

/**
 *
 * @author tudo766
 */
public class Manager {

    Validation val = new Validation();

    public void menu() {
        System.out.println("======Calculation Program=========" 
                + "\n1. Addition Matrix"
                + "\n2. Subtraction Matrix"
                + "\n3. Multiplication Matrix"
                + "\n4. Quit"
                + "\nYour choice:");
    }

    //DisplayMatrix
    void displayMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("[" + a[i][j] + "]");
            }
            System.out.println("");
        }
    }

    //Enter Matrix
    int[][] enterMatrix(String mess) {
        //Number of row and columm
        System.out.print("Enter Row " + mess + " :");
        int row = val.enterValue("Must be positive interger!");
        System.out.print("Enter Columm " + mess + " :");
        int col = val.enterValue("Must be positive interger!");
        
        int[][] ret = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter " + mess + "[" + i + "]" + "[" + j + "]" + ": ");
                ret[i][j] = val.enterValue("Values of matrix is digit");
            }
        }
        return ret;
    }

    //Add
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        //check valid matrix to add
        if (!val.validMatrixforSubandAdd(matrix1, matrix2)) {
            System.out.println("Can't calculate!");
            return null;
        }
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] += matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    //Subtration
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (!val.validMatrixforSubandAdd(matrix1, matrix2)) {
            System.out.println("Can't calculate!");
            return null;
        }
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] += matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    //Multiply
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if (!val.validMatrixforMultiply(matrix1, matrix2)) {
            System.out.println("Can't calculate!");
            return null;
        }
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                //nhân từng phần tử của 2 ma trận
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
//display calculation

    public void displayCaculation(int[][] matrix1, int[][] matrix2, int[][] result, String operation) {
        System.out.println("------Result-------");
        displayMatrix(matrix1);
        System.out.println(operation);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    public void displayAll() {
        while (true) {
            menu();
            int[][] matrix1;
            int[][] matrix2;
            int[][] result;
            int choice = val.choose(1, 4, "Enter 1->4");
            switch (choice) {
                case 1:
                    System.out.println("-----Addition-------");
                    matrix1 = enterMatrix("Matrix1");
                    matrix2 = enterMatrix("Matrix2");
                    result = additionMatrix(matrix1, matrix2);
                    if (result == null) {
                        break;
                    }
                    displayCaculation(matrix1, matrix2, result, "+");
                    break;
                case 2:
                    System.out.println("-----Addition-------");
                    matrix1 = enterMatrix("Matrix1");
                    matrix2 = enterMatrix("Matrix2");
                    result = subtractionMatrix(matrix1, matrix2);
                    if (result == null) {
                        break;
                    }
                    displayCaculation(matrix1, matrix2, result, "-");
                    break;
                case 3:
                    System.out.println("-----Addition-------");
                    matrix1 = enterMatrix("Matrix1");
                    matrix2 = enterMatrix("Matrix2");
                    result = multiplicationMatrix(matrix1, matrix2);
                    if (result == null) {
                        break;
                    }
                    displayCaculation(matrix1, matrix2, result, "*");
                    break;
                case 4:
                    return;
            }

        }
    }
}
