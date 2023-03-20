public class array {
    public static void main(String[] args){
        String[] colors = {"Blue", "Green", "Red", "Yellow"};
        int[] byFives = new int[10];


        /*for (int i=0; i<10; i++){
            byFives[i] = i*5;
            System.out.print(byFives[i]+ " ");
        }
        */

        for (int i=0; i<byFives.length; i++){
            byFives[i] = i*5;
            System.out.print(byFives[i]+ " ");
        }


        System.out.printf("%n"+ colors[1] +"%n");

        System.out.println(byFives[5]);
    }

}
