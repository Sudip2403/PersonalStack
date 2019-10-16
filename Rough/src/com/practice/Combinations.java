package com.practice;

public class Combinations {
	public static void main(String[] args) {
        String[] basket = new String[] { "APPLE", "GRAPE", "BANANA", "ORANGE" };
        Combinations driver = new Combinations();
        driver.combinations(basket);
    }
    private void combinations(String[] elements) {
        int N = elements.length;
        StringBuilder sb = new StringBuilder("0000");
        // N << 1 is equal to Math.pow(2, N)
        for (int i = 0; i < N << 2; i++) {
            String binaryString = Integer.toBinaryString(i);
            sb.append(binaryString);
            String substring = sb.substring(sb.length() - 4, sb.length());
            char[] charArray = substring.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == '1')
                    System.out.print(elements[j]+" ");
            }
            System.out.println();
        }
    }
}
