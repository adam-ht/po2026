package agh.po.lab3;

public class Codingbat {
    public boolean loneTeen(int a, int b) {
        if(a >= 13 && a <= 19 && b>=13 && b <= 19 || a==b){
            return false;
        }
        return true;
    }

    public boolean startHi(String str) {
        if(str.startsWith("hi")){
            return true;
        }
        return false;
    }

    public int countEvens(int[] nums) {
        int size = nums.length;
        int even = 0;
        for(int i = 0; i < size; i++){
            if((nums[i] % 2) == 0){
                even++;
            }
        }
        return even;
    }

    public String firstHalf(String str) {
        int size = str.length();
        return str.substring(0, size/2);
    }

    public void main(){
        Codingbat cb = new Codingbat();
        System.out.println(cb.loneTeen(13, 99));
        System.out.println(cb.loneTeen(21, 19));
        System.out.println(cb.loneTeen(13, 13));

        System.out.println(cb.startHi("hi there"));
        System.out.println(cb.startHi("hi"));
        System.out.println(cb.startHi("hello hi"));

        System.out.println(cb.countEvens(new int[]{1, 2, 3, 4}));
    }

}
