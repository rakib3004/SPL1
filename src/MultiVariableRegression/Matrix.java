package MultiVariableRegression;

import FilePackage.DateTimeWriter;
import ObjectOriented.PriorityData;

public class Matrix {
    int iterator;
    double[][] matrix = new double[3][3];

    double determinantT, determinantX, determinantY, determinantZ;
    double betaZero, betaOne, betaTwo, betaThree;

    MatrixDeterminant matrixDeterminant = new MatrixDeterminant();
    CalculateWeight calculateWeight = new CalculateWeight();

    public PriorityData[] evaluateMatrix(double[] a_array, double[] b_array,
            double[] c_array, double[] d_array, PriorityData[] priorityData,
            int numberOfBooks, double y_mean) {

        String className = this.getClass().getSimpleName();
        DateTimeWriter dateTimeWriter = new DateTimeWriter();
        dateTimeWriter.dateTimeWriterMethods(className);

        for (iterator = 0; iterator < 3; iterator++) {
            matrix[iterator][0] = a_array[iterator];
        }
        for (iterator = 0; iterator < 3; iterator++) {
            matrix[iterator][1] = b_array[iterator];
        }
        for (iterator = 0; iterator < 3; iterator++) {
            matrix[iterator][2] = c_array[iterator];
        }
        determinantT = matrixDeterminant.calculateDeterminant(matrix);
        for (iterator = 0; iterator < 3; iterator++) {
            matrix[iterator][0] = d_array[iterator];
        }
        determinantX = matrixDeterminant.calculateDeterminant(matrix);
        for (iterator = 0; iterator < 3; iterator++) {
            matrix[iterator][0] = a_array[iterator];
        }
        for (iterator = 0; iterator < 3; iterator++) {
            matrix[iterator][1] = d_array[iterator];
        }
        determinantY = matrixDeterminant.calculateDeterminant(matrix);
        for (iterator = 0; iterator < 3; iterator++) {
            matrix[iterator][1] = b_array[iterator];
        }
        for (iterator = 0; iterator < 3; iterator++) {
            matrix[iterator][2] = d_array[iterator];
        }
        determinantZ = matrixDeterminant.calculateDeterminant(matrix);
        for (iterator = 0; iterator < 3; iterator++) {
            matrix[iterator][2] = c_array[iterator];
        }

        betaOne = determinantT / determinantX;
        betaTwo = determinantT / determinantY;
        betaThree = determinantT / determinantZ;

        betaZero = y_mean - betaOne - betaTwo - betaThree;

        priorityData = calculateWeight.calculateWeightMethods(betaZero, betaOne, betaTwo, betaThree, priorityData,
                numberOfBooks);
        /*
         * betaOne = Math.pow(betaOne,-1);
         * betaTwo = Math.pow(betaTwo,-1);
         * betaThree = Math.pow(betaThree,-1);
         */
        return priorityData;
    }

    public static class MatrixDeterminant {
        double determinant;
        int iterator;

        public double calculateDeterminant(double[][] a) {
            for (iterator = 0; iterator < 3; iterator++) {
                determinant = determinant + (a[0][iterator] * (a[1][(iterator + 1) % 3] * a[2][(iterator + 2) % 3]
                        - a[1][(iterator + 2) % 3] * a[2][(iterator + 1) % 3]));
            }
            return determinant;
        }
    }
}
