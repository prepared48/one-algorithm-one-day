package com.prepared.leetCode;

/**
 * leetcode problem 985:
 *
 * We have an array A of integers, and an array queries of queries.
 *
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
 *
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 *
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 *
 * Example 1:
 *
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 */
public class Day08SumOfEvenNumbersAfterQueries985 {

    public static void main(String[] args) {

        int [] A = {1,2,3,4};
        int [][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        System.out.println(solution1(A, queries));

    }

    /**
     * 暴力破解
     * @param A
     * @param queries
     * @return
     */
    public static String solution1(int [] A, int[][] queries ) {
        int [] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
            for(int j = 0; j < A.length; j++) {
                if (isEven(A[j])) {
                    result[i] += A[j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int k = 0; k < result.length; k++) {
            if(k == result.length - 1) {
                sb.append(result[k]);
            }else {
                sb.append(result[k] + ", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static boolean isEven(int a) {
        return a%2==0;
    }

}
