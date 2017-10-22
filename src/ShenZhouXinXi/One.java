package ShenZhouXinXi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dina on 17/10/15.
 */
public class One {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String in = cin.nextLine();

        char[] arr = in.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(char c : arr) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int min = arr.length;
        for(int cur : map.values()) {
            min = Math.min(min, cur);
        }

        List<Character> minList = new ArrayList<>();
        List<Integer> values = new ArrayList<>(map.values());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (min == entry.getValue()) {
                minList.add(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<in.length(); i++) {
            if(!minList.contains(in.charAt(i))) {
                sb.append(in.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
