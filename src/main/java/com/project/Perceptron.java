package com.project;

class Perceptron {
    private double[] weights;
    private double bias;
    private double learningRate;

    public Perceptron(int inputSize) {
        weights = new double[inputSize];
        bias = 0.0;
        learningRate = 0.1;

        // Inicialización aleatoria de los pesos
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random() - 0.5;
        }
    }

    private int activate(double sum) {
        return sum >= 0 ? 1 : 0;
    }

    private int predict(int[] inputs) {
        double sum = bias;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * inputs[i];
        }
        return activate(sum);
    }

    public void train(int[][] inputData, int[] labels, int epochs) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < inputData.length; i++) {
                int prediction = predict(inputData[i]);
                int error = labels[i] - prediction;

                // Actualizar pesos y bias
                for (int j = 0; j < weights.length; j++) {
                    weights[j] += learningRate * error * inputData[i][j];
                }
                bias += learningRate * error;
            }
        }
    }

    public double testAccuracy(int[][] inputData, int[] labels) {
        int correct = 0;
        for (int i = 0; i < inputData.length; i++) {
            int prediction = predict(inputData[i]);
            if (prediction == labels[i]) {
                correct++;
            }
        }
        return (correct / (double) inputData.length) * 100.0;
    }
}