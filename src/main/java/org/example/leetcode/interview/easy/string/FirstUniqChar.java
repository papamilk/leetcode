package org.example.leetcode.interview.easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Marcoo
 * @Date 2020/1/9 21:46
 */
public class FirstUniqChar {

    public static void main(String[] args) {
//        String s = "leetcode";
        String s = "loveleetcode";
//        String s = "";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqCharV2(s));
        System.out.println(firstUniqCharV3(s));

        System.out.println((int) 'b');
    }

    public static int firstUniqCharV3(String s) {
        int res = -1;
        for (int ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }

    public static int firstUniqCharV2(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int index = c - 97;
            arr[index]++;
        }
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 97;
            if (arr[index] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>(chars.length);
        for (char ch : chars) {
            map.merge(ch, 1, Integer::sum);
        }

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            Integer value = map.get(ch);
            if (value == 1) {
                return i;
            }
        }
        return -1;
    }

}
