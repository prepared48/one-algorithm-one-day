package com.parepared.leetCode;


import java.util.TreeMap;

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
public class Day06NumberOfRecentCalls93301 {

    public static void main(String[] args) {
        Day06NumberOfRecentCalls93301 day = new Day06NumberOfRecentCalls93301();
        System.out.println(day.ping(3002));
    }

    TreeMap<Integer, Integer> tm;

    public Day06NumberOfRecentCalls93301() {
        tm = new TreeMap<>();
    }

    public int ping(int t) {
        tm.put(t, 1 + tm.size());
        System.out.println("tmsize="+ tm.size());
        //tailMap(K fromkey): Returns a view of the portion of this map whose keys are greater than or equal to fromKey.
        return tm.tailMap(t - 3000).size();
    }
}
