package com.prepared.leetCode;


import java.util.*;

/**
 * leetcode problem 933
 *
 * Write a class RecentCounter to count recent requests.
 *
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 *
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 *
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 *
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 *
 * example :
 *
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * Output: [null,1,2,3,3]
 */
public class Day06NumberOfRecentCalls93303 {

    public static void main(String[] args) {
        Day06NumberOfRecentCalls93303 day = new Day06NumberOfRecentCalls93303();
//        for(int i = 0; i < 3003; i++) {
//            System.out.println(day.ping(i));
//        }
        System.out.println(day.ping(0));
        System.out.println(day.ping(1));
        System.out.println(day.ping(100));
        System.out.println(day.ping(3001));
        System.out.println(day.ping(3002));

    }

    List<Integer> list;

    public Day06NumberOfRecentCalls93303() {
        list = new ArrayList<>();
    }


    public int ping(int t) {
        list.add(t);
        //Searches the specified list for the specified object using the binary search algorithm.
        int i = Collections.binarySearch(list, t - 3000);
        // if not exist
        if(i < 0) i = -i - 1;

        return list.size() -i;
    }
}
