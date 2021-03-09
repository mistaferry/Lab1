package kpi.ua;
import java.lang.Math;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        int rows, columns;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Matrix Rows and Columns :  ");
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        System.out.printf("You inputted, %d rows and %d columns\n", rows, columns);
        int[][] matrix = new int[rows][columns];

        long start = System.nanoTime();

        System.out.println("\nTASK 1");
        random(rows, columns, matrix);
        matrixOutput(matrix);
        rowCol(matrix);

        System.out.println("\nTASK 2");
        random(rows, columns, matrix);
        matrixOutput(matrix);
        exchange(matrix);

        long end = System.nanoTime() - start;
        long durationInMs = TimeUnit.NANOSECONDS.toMillis(end);

        System.out.println("Time = "+ durationInMs +" ms");
    }

    private static void exchange(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length / 2; j++) {
                replaceFun(matrix, i, j);
            }

        }
        for (int i = matrix.length - 1; i > matrix.length / 2 - 1; i--) {
            for (int j = i; j > matrix.length / 2 - 1; j--) {
                replaceFun(matrix, i, j);
            }
        }
        System.out.println("Matrix after changes:");
        matrixOutput(matrix);
    }

    private static void replaceFun(int[][] matrix, int i, int j) {
        int temp;
        temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - 1 - j];
        matrix[i][matrix.length - 1 - j] = temp;
    }


    private static void matrixOutput(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%-3d", matrix[i][j]);
            }
            System.out.println();
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

        for (int i = 0; i < colNumb; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                colSum = colSum + matrix[j][i];
            }
            System.out.printf("The sum of matrix items in the Column %d = %d\n", i + 1, colSum);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum < colSum) {
                inTen(matrix, i);
            }
            System.out.printf("The sum of matrix items in the Row %d = %d\n", i + 1, rowSum);
            rowSum = 0;
        }
        System.out.println("Matrix after changes:");
        matrixOutput(matrix);

    }

    private static void inTen(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] += 10;
        }
    }


}
