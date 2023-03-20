public class ArrayProcess {
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10};

        for (int counter = 1; counter < array.length; counter = counter + 2) {
            array[counter] *= 2;
        }
        for (int counter = 0; counter < array.length; counter++) {
            System.out.printf("%5d%8d%n", counter, array[counter]);
        }
    }
}

