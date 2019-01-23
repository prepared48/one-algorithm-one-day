package com.parepared.leetCode;


import java.util.LinkedList;
import java.util.Queue;

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
public class Day06NumberOfRecentCalls93302 {

    public static void main(String[] args) {
        Day06NumberOfRecentCalls93302 day = new Day06NumberOfRecentCalls93302();
        System.out.println(day.ping(3002));
    }

    Queue<Integer> q;

    public Day06NumberOfRecentCalls93302() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        // add the element t to the queue
        q.offer(t);
        // peek() get the head of the queue
        // poll() get the head of the queue and remove the head
        while (q.peek() < t - 3000) { q.poll(); }
        return q.size();
    }
}
