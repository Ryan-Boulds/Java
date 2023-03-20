public class InitArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        int[] array2 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.printf("%s%8s%n", "Index", "Value");
       /* for (int counter = 0; counter < array.length; counter++) {
            System.out.printf("%5d%8d%n", counter, array[counter]);
        }*/
        for (int counter2 = 0; counter2 < array2.length; counter2++) {
            System.out.printf("%5d%8d%n", counter2, array2[counter2]);

        }
    }
}
