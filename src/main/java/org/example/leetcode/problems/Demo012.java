package org.example.leetcode.problems;

/**
 * 整数转罗马数字      https://leetcode-cn.com/problems/integer-to-roman/
 * @author zhoujian
 * @date 2020/4/10
 */
public class Demo012 {
    public static void main(String[] args) {
        int num = 1999;
        System.out.println(intToRoman(num));
        System.out.println(intToRomanV2(num));
        System.out.println(intToRomanV3(num));
    }

    /**
     * 使用贪心算法，每次尽可能使用大的数值
     * @param num
     * @return
     */
    public static String intToRomanV3(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num >= nums[index]) {
                builder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return builder.toString();
    }


    /**
     * 使用条件判断来处理
     * @param num
     * @return
     */
    public static String intToRomanV2(int num) {
        StringBuilder builder = new StringBuilder();
        if (num >= 1000) {
            num = mod(num, 1000, "M", builder);
        }

        if (num >= 900) {
            num = sub(num, 900, "CM", builder);
        }

        if (num >= 500) {
            num = sub(num, 500, "D", builder);
        }

        if (num >= 400) {
            num = sub(num, 400, "CD", builder);
        }

        if (num >= 100) {
            num = mod(num, 100, "C", builder);
        }

        if (num >= 90) {
            num = sub(num, 90, "XC", builder);
        }

        if (num >= 50) {
            num = sub(num, 50, "L", builder);
        }

        if (num >= 40) {
            num = sub(num, 40, "XL", builder);
        }

        if (num >= 10) {
            num = mod(num, 10, "X", builder);
        }

        if (num >= 9) {
            num = sub(num, 9, "IX", builder);
        }

        if (num >= 5) {
            num = sub(num, 5, "V", builder);
        }

        if (num >= 4) {
            num = sub(num, 4, "IV", builder);
        }

        if (num >= 1) {
            mod(num, 1, "I", builder);
        }
        return builder.toString();
    }

    private static int mod(int num, int value, String roman, StringBuilder builder) {
        for (int i = 0; i < num / value; i++) {
            builder.append(roman);
        }
        return num % value;
    }

    private static int sub(int num, int value, String roman, StringBuilder builder) {
        builder.append(roman);
        return num - value;
    }

    public static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i++) {
                builder.append("M");
            }
            num %= 1000;
        }

        if (num >= 900) {
            builder.append("CM");
            num -= 900;
        }

        if (num >= 500) {
            builder.append("D");
            num -= 500;
        }

        if (num >= 400) {
            builder.append("CD");
            num -= 400;
        }

        if (num >= 100) {
            for (int i = 0; i < num / 100; i++) {
                builder.append("C");
                num %= 100;
            }
        }

        if (num >= 90) {
            builder.append("XC");
            num -= 90;
        }

        if (num >= 50) {
            builder.append("L");
            num -= 50;
        }

        if (num >= 40) {
            builder.append("XL");
            num -= 40;
        }

        if (num >= 10) {
            for (int i = 0; i < num / 10; i++) {
                builder.append("X");
                num %= 10;
            }
        }

        if (num >= 9) {
            builder.append("IX");
            num -= num;
        }

        if (num >= 5) {
            builder.append("V");
            num -= 5;
        }

        if (num >= 4) {
            builder.append("IV");
            num -= 4;
        }

        if (num >= 1) {
            for (int i = 0; i < num; i++) {
                builder.append("I");
            }
        }
        return builder.toString();
    }
}
