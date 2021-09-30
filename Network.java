import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Network {
    public static void main(String[] args) {
        double[] inputs = { 0, 2, -1, 3.3, -2.7, 1.1, 2.2, -53 };
        ArrayList<Double> outputs = ReLU(inputs); 
        
        System.out.println("Hello world!");
        System.out.println(outputs.toString());
        
        // double[][] X = { { 4.3, 2.1, 8.4 }, { -1.0, 5.0, 2.0 }, { 0.1, 0.17, -0.26 } };
        // DenseLayer LayerOne = new DenseLayer(3, 5);
        // DenseLayer LayerTwo = new DenseLayer(5, 2);

        // LayerOne.forward(X);
        // LayerTwo.forward(LayerOne.getOutput());

        // System.out.print(Arrays.deepToString(LayerTwo.getOutput()));
    }

    public static ArrayList<Double> ReLU (double[] inputs) {
        ArrayList<Double> outputs = new ArrayList<Double>();

        for (double i : inputs) {
            outputs.add(Math.max(0, i));
        }

        return outputs;
    }
}


class DenseLayer {
    private static final Random random = new Random(0);

    private double[][] weights;
    private double[][] output;
    private double[] biases;

    public DenseLayer(int inputs, int neurons) {
        this.weights = randn(inputs, neurons);
        this.biases = new double[neurons];
    }

    public void forward(double[][] input) {
        output = add(dotProduct(input, weights), biases);
    }

    public double[][] getOutput() {
        return output;
    }

    public double[][] randn(int rows, int cols) {
        double[][] output = new double[rows][cols];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                output[i][j] = 0.1 * random.nextGaussian();
            }
        }
        return output;
    }

    
    private static double[][] dotProduct(double[][] input, double[][] other) {
        double[][] output = new double[input.length][other[0].length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                double value = 0;
                for (int k = 0; k < input[0].length; k++) {
                    value += input[i][k] * other[k][j];
                }
                output[i][j] = value;
            }
        }
        return output;
    }

    private static double[][] add(double[][] input, double[] other) {
        double[][] output = new double[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                output[i][j] = input[i][j] + other[j];
            }
        }
        return output;
    }
}
