package kpi.ua;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int rows, columns;

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Matrix Rows and Columns :  ");
//        rows = scanner.nextInt();
//        columns = scanner.nextInt();
//        System.out.printf("You inputted, %d rows and %d columns\n", rows, columns);
//        int[][] matrix = new int[rows][columns];

//        //Task 1
//        random(rows, columns, matrix);
//        matrixOutput(matrix);
//        rowCol(matrix);

        //Task 2

//        for(int i = 0; i < matrix.length/2; i++){
//            for (int j = matrix.length/2; j<matrix.length -i; j++){
//                int tmp = matrix[i][j];
//                matrix[i] = matrix[j];
//                matrix[j] = tmp;
//            }
//        }
//        System.out.println("\n");;


        int[][] matrix = {{20, 18, 22, 20},
                {18, 20, 18, 21},
                {16, 18, 16, 20},
                {25, 24, 22, 24}
        };
        matrixOutput(matrix);
        System.out.println("\n");
        int temp;
        for(int j=0; j< matrix.length; j++) {
            for (int i = j; i < matrix.length/2; i++) {
                temp=matrix[j][i];
                matrix[j][i]=matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i]=temp;
            }
        }
        matrixOutput(matrix);


    }

    private static void matrixOutput(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%-3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void rowSum(int[][] matrix) {
        double rowSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rowSum += matrix[i][j];
            }
            System.out.printf("The Sum of Matrix Items in Rows %d = %.0f\n", i + 1, rowSum);
            rowSum = 0;
        }
    }

    private static void colSum(int[][] matrix) {
        double sumCols;
        for (int i = 0; i < matrix.length; i++) {
            sumCols = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sumCols = sumCols + matrix[j][i];
            }
            System.out.printf("The Sum of Matrix Items in Column %d = %.0f\n", i + 1, sumCols);
        }
    }

    private static void random(int rows, int columns, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = ((int) (Math.random() * 10));
            }
        }
    }

    private static void rowCol(int[][] matrix) {
        int rowSum = 0, colSum = 0, colNumb = 1;

        //цикл обрахунку суми елементів вибраного стовбця
        for (int i = 0; i < colNumb; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                colSum = colSum + matrix[j][i];
            }
            System.out.printf("The Sum of Matrix Items in Column %d = %d\n", i + 1, colSum);
        }
        System.out.println("" + colSum);

        //цикл обрахунку суми елементів кожного рядка
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum < colSum) {
                inTen(matrix, i);
            }
            System.out.printf("The Sum of Matrix Items in Rows %d = %d\n", i + 1, rowSum);
            rowSum = 0;
        }
        matrixOutput(matrix);

    }

    private static void inTen(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] += 10;
        }
    }


}
