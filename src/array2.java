import java.util.Arrays;

public class array2 {
    public static void main(String[] args) {

        //Broken
       /* char[] letters = new char[26];
        for (int i = 0, j = 97; j < 122; i++, j++){
            letters[i] = (char) i;
        }
        letters[18] = 'g';
        letters[19] = 'h';
        System.out.println(Arrays.toString(letters));*/

        char[] lowercase = new char[26];
        char x = 'a';
        for(int i=0; i<26; i++){
            lowercase[i] = x;
            x++;
        }
        for(int i=0; i<26; i++) {
            System.out.print(lowercase[i] + " ");
        }
        System.out.println(lowercase);
    }
}
