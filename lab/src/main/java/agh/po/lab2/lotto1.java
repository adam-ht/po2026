package agh.po.lab2;

import java.util.ArrayList;
import java.util.Random;

public class lotto1 {
    public static void main(String[] args) {
        // Inicjalizujemy dwie tablice: jedna do przechowywania wylosowanych liczb, druga do przechowywania typów użytkownika
        ArrayList<Integer> arr = new ArrayList<>();

        // Generator liczb losowych
        Random r = new Random();
        int num;
        int n;
        boolean is;

        // Główna pętla do losowania 6 liczb
        for(int j = 0; j < 6; j++) {
            num = r.nextInt(1, 49);
            if(arr.contains(num))
                arr.add(r.nextInt(1,49));
            else {
                arr.add(num);
            }
        }

        System.out.println("Wylosowane liczby: " + arr);
    }
}
