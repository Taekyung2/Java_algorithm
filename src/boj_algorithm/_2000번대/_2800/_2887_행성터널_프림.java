package boj_algorithm._2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2887_행성터널_프림 {
	
    static int V;
    static Pos[] poss;
    static ArrayList<Pair>[] adj;
    
    static class Pair {
		int first, second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
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
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        poss = new Pos[V];
        adj = new ArrayList[V];
        	for(int i = 0; i < V; i++) adj[i] = new ArrayList<Pair>();
        int a, b, c;
        StringTokenizer st;
        for (int i = 0; i < V ; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            poss[i] = new Pos(a, b, c, i);
        }

        // x based sort
        Comparator<Pos> cmp = (o1,o2)-> o1.x-o2.x;
        Arrays.sort(poss,cmp);
        for (int i = 1; i < V ; i++) {
            adj[poss[i - 1].id].add(new Pair(poss[i].id, Math.abs(poss[i].x-poss[i-1].x)));
        }

        // y based sort
        cmp = (o1,o2)-> o1.y-o2.y;
        Arrays.sort(poss,cmp);
        for (int i = 1; i <V ; i++) {
            adj[poss[i - 1].id].add(new Pair(poss[i].id, Math.abs(poss[i].y-poss[i-1].y)));
        }

        // z based sort
        cmp = (o1,o2)-> o1.z-o2.z;
        Arrays.sort(poss,cmp);
        for (int i = 1; i <V ; i++) {
            adj[poss[i - 1].id].add(new Pair(poss[i].id, Math.abs(poss[i].z-poss[i-1].z)));
        }
        
        	System.out.println(prim(new ArrayList<Pair>()));
    }
    
    
	static int prim(ArrayList<Pair> selected) {
		selected.clear();
		boolean[] added = new boolean[V];
		int[] minWeight = new int[V];
		int[] parent = new int[V];
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		int ret = 0;
		minWeight[0] = parent[0] = 0;
		for(int iter = 0; iter < V; iter++) {
			//다음에 트리에추가할 정점 u를 찾는다.
			int u = -1;
			for(int v = 0; v < V; v++)
				if(!added[v] && (u == -1 || minWeight[u] > minWeight[v]))
					u = v;
			if(parent[u] != u)
				selected.add(new Pair(parent[u], u));
			ret += minWeight[u];
			added[u] = true;
			
			for(int i = 0; i < adj[u].size(); i++) {
				int v = adj[u].get(i).first, weight = adj[u].get(i).second;
				if(!added[v] && minWeight[v] > weight) {
					parent[v] = u;
					minWeight[v] = weight;
				}
			}
		}
		return ret;
	}
}
