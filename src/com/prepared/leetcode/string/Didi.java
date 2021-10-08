package com.prepared.leetcode.string;

/**
 * 滴滴算法题，在source字符串中，找到sub字符串第一次出现的位置，以及出现的次数
 *
 */
public class Didi {

    public static void main(String[] args) {
        Didi didi = new Didi();
//        didi.func("xxb abbbb ccc add adddxdd", "addd");
        didi.func("xxb abbbb ccc add adddxdd", "addd");
    }

    public void func(String source, String sub) {


        int sum = 0;
        int firstPos = source.indexOf(sub);

        if(firstPos != -1) {
            sum++;
            source = source.replaceFirst(sub, "#");
            while (source.indexOf(sub) != -1) {
                sum++;
            }
        }
        System.out.println(firstPos);
        System.out.println(sum);
    }

    /**
     * KMP 算法解决 时间复杂度 O(m+n)
     * m = func.length() n = sub.length()
     *
     * @param source
     * @param sub
     * @return
     */
    public int[] func2(String source, String sub) {
        int sum = 0;
        int [] res = new int[2];
        int[] next  = new int[sub.length()];
        boolean firstFlag = true;
        getNext(next, sub);
        int j = -1;
        for(int i = 0; i < source.length(); i++) {
            while (j >= 0 && source.charAt(i) != sub.charAt(j + 1)) {
                // 跳过最长公共前后缀个字符
                j = next[j];
            }
            if(source.charAt(i) == sub.charAt(j+1)) {
                j++;
            }
            // 匹配完sub字符，返回位置
            if(j == sub.length() - 1) {
                sum ++;
                if(firstFlag) {
                    res[0] = i - sub.length() + 1;
                    firstFlag = false;
                }
                j = -1;
            }
        }
        res[1] = sum;
        return res;
    }

    /**
     * 获取next数组。不加1
     *
     * @param next
     * @param sub
     */
    public void getNext(int[] next, String sub) {
        int j = -1;
        next[0] = j;
        for(int i = 1; i < sub.length(); i++) {
            while (j >= 0 && sub.charAt(i) != sub.charAt(j+1)) {
                j = next[j];
            }
            if(sub.charAt(i) == sub.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }
}
