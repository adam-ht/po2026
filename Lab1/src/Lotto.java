import java.util.ArrayList;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random r = new Random();

        for(int j = 0; j <= 6; j++)
            arr.add(r.nextInt(50));

        System.out.println(arr);
    }
}
