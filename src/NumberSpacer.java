public class NumberSpacer {
    public static void main(String[] args) {
        System.out.printf("%-10s%-10s%-10s%-10s", "N", "10*N", "100*N", "1000*N");

        for (int number = 1; number < 6; number++) {
            System.out.printf("%n%-10s%-10s%-10s%-10s", number, number * 10, number * 100, number * 1000);
        }
    }
}
