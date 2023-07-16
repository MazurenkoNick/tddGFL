package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    private final double a = 1.5;
    private final double EPS = 1e-6;

    public double secondFunction(double x) {
        double res;

        if (x < 1.7) {
            double xSquared = Math.pow(x, 2);
            res = Math.PI * xSquared - 7 / xSquared;
        }
        else if (Math.abs(x - 1.7) < EPS) {
            res = a * Math.pow(x, 3) + 7 * Math.sqrt(x);
        }
        else {
            res = Math.log10(x + 7 * Math.sqrt(x));
        }
        return res;
    }


    public int countSteps(double start, double end, double step) {
        return (int) Math.round((end - start) / step);
    }

    public double[] getArrayOfXinRange(double start, double end, double step) {
        int arrLength = countSteps(start, end, step) + 1;
        double[] result = new double[arrLength];

        for (int i = 0; i < arrLength; i++) {
            result[i] = start + i * step;
        }

        return result;
    }

    public double[] getArrayOfYinRange(double start, double end, double step) {
        double[] arrayOfX = getArrayOfXinRange(start, end, step);
        double[] arrayOfY = new double[arrayOfX.length];

        for (int i = 0; i < arrayOfX.length; i++) {
            arrayOfY[i] = secondFunction(arrayOfX[i]);
        }
        return arrayOfY;
    }

    public double findMaxValueInRange(double start, double end, double step) {
        double[] arrayOfY = getArrayOfYinRange(start, end, step);
        return Arrays.stream(arrayOfY).max().orElse(Double.MIN_VALUE);
    }

    public double findMinValueInRange(double start, double end, double step) {
        double[] arrayOfY = getArrayOfYinRange(start, end, step);
        return Arrays.stream(arrayOfY).min().orElse(Double.MAX_VALUE);
    }

    public double findAverageValueInRange(double start, double end, double step) {
        double[] arrayOfY = getArrayOfYinRange(start, end, step);
        return Arrays.stream(arrayOfY).average().orElse(Double.MAX_VALUE);
    }

    public double findSumInRange(double start, double end, double step) {
        double[] arrayOfY = getArrayOfYinRange(start, end, step);
        return Arrays.stream(arrayOfY).sum();
    }

    public void printMaxValueInRange(double start, double end, double step) {
        double[] arrayOfY = getArrayOfYinRange(start, end, step);

        int maxIndex = IntStream.range(0, arrayOfY.length)
                .reduce((i, j) -> arrayOfY[i] > arrayOfY[j] ? i : j)
                .orElse(-1);

        System.out.printf("Start=%f, End=%f, Step=%f\n", start, end, step);
        printValue("Max Value", maxIndex, arrayOfY[maxIndex]);
    }

    public void printMinValueInRange(double start, double end, double step) {
        double[] arrayOfY = getArrayOfYinRange(start, end, step);

        // Find the index of the minimum value
        int minIndex = IntStream.range(0, arrayOfY.length)
                .reduce((i, j) -> arrayOfY[i] < arrayOfY[j] ? i : j)
                .orElse(-1);

        System.out.printf("Start=%f, End=%f, Step=%f\n", start, end, step);
        printValue("Min Value", minIndex, arrayOfY[minIndex]);
    }

    private void printValue(String valueName, int idx, double value) {
        if (idx != -1) {
            System.out.println("Index: " + idx);
            System.out.println(valueName + ": " + value);
        }
        else {
            System.out.println("No minimum value found.");
        }
    }
}
