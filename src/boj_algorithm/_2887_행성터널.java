package boj_algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2887_행성터널 {
    static int N;
    static Pos[] poss;
    static DJS djs;
    static ArrayList<Edge> edges;
    
    static class DJS{
        int[] mom;
        DJS(int n) {
            mom = new int[n+1];
            for (int i = 1; i <= n ; i++) mom[i] = i;
        }
        public int find(int n) {
            if(n==mom[n]) return n;
            return mom[n] = find(mom[n]);
        }
        public boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if(a==b) return false;
            mom[b] = a;
            return true;
        }
    }
    
    static class Pos {
        int x, y, z, id;
        Pos(int x, int y, int z, int id) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.id = id;
        }
    }
    static class Edge implements Comparable<Edge> {
        int s, e, v;
        Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        poss = new Pos[N];
        edges = new ArrayList<>();
        int a, b, c;
        StringTokenizer st;
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            poss[i] = new Pos(a, b, c, i);
        }

        // x based sort
        Comparator<Pos> cmp = (o1,o2)-> o1.x-o2.x;
        Arrays.sort(poss,cmp);
        for (int i = 1; i <N ; i++) {
            edges.add(new Edge(poss[i-1].id, poss[i].id, Math.abs(poss[i].x-poss[i-1].x)));
        }

        // y based sort
        cmp = (o1,o2)-> o1.y-o2.y;
        Arrays.sort(poss,cmp);
        for (int i = 1; i <N ; i++) {
            edges.add(new Edge(poss[i-1].id, poss[i].id, Math.abs(poss[i].y-poss[i-1].y)));
        }

        // z based sort
        cmp = (o1,o2)-> o1.z-o2.z;
        Arrays.sort(poss,cmp);
        for (int i = 1; i <N ; i++) {
            edges.add(new Edge(poss[i-1].id, poss[i].id, Math.abs(poss[i].z-poss[i-1].z)));
        }

        Collections.sort(edges);

        djs = new DJS(N);
        long result=0;
        for (Edge ed:edges) {
            if(djs.union(ed.s, ed.e)) {
                result += ed.v;
            }
        }
        System.out.println(result);
    }
}