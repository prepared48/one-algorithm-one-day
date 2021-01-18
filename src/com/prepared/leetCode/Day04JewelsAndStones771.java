package com.prepared.leetCode;

/**
 * leetcode problem 771:
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 */
public class Day04JewelsAndStones771 {

    /**
     * 暴力破解
     *
     * @param jewels
     * @param stones
     * @return
     */
    public static int numJewelsInStones(String jewels, String stones) {
        int num = 0;
        for(int i = 0; i < jewels.length(); i++) {
            for(int j = 0; j < stones.length(); j++) {
                if(stones.charAt(j) == jewels.charAt(i)) {
                    num++;
                }
            }
        }
        return num;
    }

    public static int method2(String jewels, String stones) {
        int num = 0;
        for(int i = 0; i < jewels.length(); i++) {
            for(int j = 0; j < stones.length(); j++) {
                if(stones.charAt(j) == jewels.charAt(i)) {
                    num++;
                }
            }
        }
        return num;
    }

}
