package algorithm_skill;

public class Floyd {
	static int V = 100;
	static int[][] adj = new int[100][100];
	
	static void floyd() {
		for(int i = 0; i < V; i++) adj[i][i] = 0;
		for(int k = 0; k < V; k++)
			for(int i = 0; i < V; i++) {
				if(adj[i][k] == 0) continue;
				for(int j = 0; j < V; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
			}
	}
}