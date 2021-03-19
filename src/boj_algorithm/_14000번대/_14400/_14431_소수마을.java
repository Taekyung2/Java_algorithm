package boj_algorithm._14400;


import java.util.*;

public class _14431_소수마을 {
    static class Pair implements Comparable<Pair> {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.first, o.first);
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Point S, E;
    static int N;
    static Point[] v_arr;
    static ArrayList<Pair>[] adj;

    static boolean[] prime = new boolean[100000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = new Point(sc.nextInt(), sc.nextInt());
        E = new Point(sc.nextInt(), sc.nextInt());
        N = sc.nextInt();
        v_arr = new Point[N + 2];
        adj = new ArrayList[N + 2];
        for(int i = 0; i < N + 2; i++)
            adj[i] = new ArrayList<>();
        v_arr[0] = S;
        v_arr[N + 1] = E;
        for(int i = 1; i < N + 1; i++)
            v_arr[i] = new Point(sc.nextInt(), sc.nextInt());
        setPrime();
        for(int i = 0; i < N + 2; i++) {
            for(int j = i + 1; j < N + 2; j++) {
                int distance = (int) Math.floor(Math.sqrt(Math.pow(v_arr[i].y - v_arr[j].y, 2) + Math.pow(v_arr[i].x - v_arr[j].x, 2)));
                if(!prime[distance]) {
                    adj[i].add(new Pair(j, distance));
                    adj[j].add(new Pair(i, distance));
                }
            }
        }
        int[] ret = dijkstra();
        System.out.println(ret[N + 1] > 1000000000 ? -1 : ret[N + 1]);
    }

    static int[] dijkstra() {
        int[] dist = new int[N + 2];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int here = p.first;
            int cost = -p.second;
            if(dist[here] < cost) continue;

            for(int i = 0; i < adj[here].size(); ++i) {
                int there = adj[here].get(i).first;
                int nextDist = cost + adj[here].get(i).second;

                if(dist[there] > nextDist) {
                    dist[there] = nextDist;
                    pq.add(new Pair(there, -nextDist));
                }
            }
        }
        return dist;
    }

    private static void setPrime() {
        prime[0] = prime[1] = true;
        for(int i = 2; i < 100000; i++) {
            if(prime[i]) continue;
            for(int j = i + i; j < 100000; j += i) {
                prime[j] = true;
            }
        }
    }
}