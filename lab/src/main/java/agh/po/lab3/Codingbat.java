package agh.po.lab3;

import java.util.Map;
import java.util.HashMap;

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

    public Map<String, String> mapAB(Map<String, String> map) {
        if(map.containsKey("a") && map.containsKey("b")){
            map.put("ab", map.get("a") + map.get("b"));
        }

        return map;
    }

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> changedWordLen = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            changedWordLen.put(s, s.length());
        }

//        for (String s : strings) {
//            changedWordLen.put(s, s.length());
//        }

        return changedWordLen;
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
