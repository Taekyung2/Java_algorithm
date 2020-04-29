package boj_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class _11404_플로이드 {
	final static int INF = 1000000000;
	static int V, E;
	static int[][] adj;
	
	static void floyd() {
		for(int i = 0; i < V; i++) adj[i][i] = 0;
		for(int k = 0; k < V; k++)
			for(int i = 0; i < V; i++)
				for(int j = 0; j < V; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new int[V][V];
		for(int i = 0; i < V; i++)
			Arrays.fill(adj[i], INF);
		
		for(int i = 0; i < E; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int w = sc.nextInt();
			adj[u][v] = Math.min(adj[u][v], w);
		}
		floyd();
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				if(adj[i][j] == INF) System.out.print(0 + " ");
				else System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
