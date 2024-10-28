package com.project;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<int[]> matrices = generateAllMatrices();

        // Crear instancias de la clase Perceptron
        Perceptron perceptronDiagonal = new Perceptron(9); // Diagonal
        Perceptron perceptronVertical = new Perceptron(9); // Vertical
        Perceptron perceptronHorizontal = new Perceptron(9); // Horizontal

        // Inicializar etiquetas para cada perceptrón
        int[] diagonalLabels = new int[512];
        int[] verticalLabels = new int[512];
        int[] horizontalLabels = new int[512];

        // Asignar etiquetas a las matrices
        for (int i = 0; i < matrices.size(); i++) {
            int[] matrix = matrices.get(i);

            // Etiquetas diagonales
            int primaryDiagonal = (matrix[0] == 1 ? 1 : 0) + (matrix[4] == 1 ? 1 : 0) + (matrix[8] == 1 ? 1 : 0);
            int secondaryDiagonal = (matrix[2] == 1 ? 1 : 0) + (matrix[4] == 1 ? 1 : 0) + (matrix[6] == 1 ? 1 : 0);
            diagonalLabels[i] = (primaryDiagonal == 3 || secondaryDiagonal == 3) ? 1 : 0;

            // Etiquetas verticales
            int col1 = (matrix[0] == 1 ? 1 : 0) + (matrix[3] == 1 ? 1 : 0) + (matrix[6] == 1 ? 1 : 0);
            int col2 = (matrix[1] == 1 ? 1 : 0) + (matrix[4] == 1 ? 1 : 0) + (matrix[7] == 1 ? 1 : 0);
            int col3 = (matrix[2] == 1 ? 1 : 0) + (matrix[5] == 1 ? 1 : 0) + (matrix[8] == 1 ? 1 : 0);
            verticalLabels[i] = (col1 == 3 || col2 == 3 || col3 == 3) ? 1 : 0;

            // Etiquetas horizontales
            int row1 = (matrix[0] == 1 ? 1 : 0) + (matrix[1] == 1 ? 1 : 0) + (matrix[2] == 1 ? 1 : 0);
            int row2 = (matrix[3] == 1 ? 1 : 0) + (matrix[4] == 1 ? 1 : 0) + (matrix[5] == 1 ? 1 : 0);
            int row3 = (matrix[6] == 1 ? 1 : 0) + (matrix[7] == 1 ? 1 : 0) + (matrix[8] == 1 ? 1 : 0);
            horizontalLabels[i] = (row1 == 3 || row2 == 3 || row3 == 3) ? 1 : 0;
        }

        // Entrenar y evaluar con diferentes épocas
        int[][] inputData = matrices.toArray(new int[0][0]);
        for (int epochs : new int[]{1, 2, 5, 50, 300}) {
            System.out.println("EPOCH: " + epochs);

            perceptronDiagonal.train(inputData, diagonalLabels, epochs);
            double accuracyDiagonal = perceptronDiagonal.testAccuracy(inputData, diagonalLabels);
            System.out.printf("Perceptron Diagonal Accuracy: %.2f%%\n", accuracyDiagonal);

            perceptronVertical.train(inputData, verticalLabels, epochs);
            double accuracyVertical = perceptronVertical.testAccuracy(inputData, verticalLabels);
            System.out.printf("Perceptron Vertical Accuracy: %.2f%%\n", accuracyVertical);

            perceptronHorizontal.train(inputData, horizontalLabels, epochs);
            double accuracyHorizontal = perceptronHorizontal.testAccuracy(inputData, horizontalLabels);
            System.out.printf("Perceptron Horizontal Accuracy: %.2f%%\n", accuracyHorizontal);
        }
    }

    public static List<int[]> generateAllMatrices() {
        List<int[]> matrices = new ArrayList<>();

        for (int i = 0; i < 512; i++) {
            int[] matrix = new int[9];
            String binary = String.format("%9s", Integer.toBinaryString(i)).replace(' ', '0');

            for (int j = 0; j < 9; j++) {
                matrix[j] = binary.charAt(j) - '0';
            }

            matrices.add(matrix);
        }

        return matrices;
    }
}