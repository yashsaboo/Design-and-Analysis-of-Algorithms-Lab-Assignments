/*
 * Kruskal's algorithm is a minimum spanning tree algorithm that takes a graph as input and 
 * finds the subset of the edges of that graph 
 * which form a tree that includes every vertex and 
 * has the minimum sum of weights among all the trees that can be formed from the graph
 */

package Lab4;

public class EasyKruskals {

	static int i, j, k, a, b, u, v, n = 6, ne = 1;
	static int min, mincost = 0;
	static int cost[][] = new int[][] { { 999, 1, 999, 4, 999, 999, 999 }, { 1, 999, 2, 6, 4, 999, 999 },
			{ 999, 2, 999, 999, 5, 6, 999 }, { 4, 6, 999, 999, 3, 999, 4 }, { 999, 4, 5, 3, 999, 8, 7 },
			{ 999, 1, 6, 999, 8, 999, 3 }, { 999, 1, 999, 4, 7, 3, 999 } };
	static int parent[] = new int[9];

	public static void main(String args[]) {
		System.out.println("Implementation of Kruskal's algorithm");
		System.out.println("The edges of Minimum Cost Spanning Tree are\n");
		while (ne < n) {
			for (i = 1, min = 999; i <= n; i++) {
				for (j = 1; j <= n; j++) {
					if (cost[i][j] < min) {
						min = cost[i][j];
						a = u = i;
						b = v = j;
					}
				}
			}
			u = find(u);
			v = find(v);
			if (uni(u, v) == 1) {
				System.out.println(ne++ + " edge (" + a + "," + b + ") = " + min);
				mincost += min;
			}
			cost[a][b] = cost[b][a] = 999;
		}
		System.out.println("Minimum cost = " + mincost);
	}

	static int find(int i) {
		while (parent[i] == 1)
			i = parent[i];
		return i;
	}

	static int uni(int i, int j) {
		if (i != j) {
			parent[j] = i;
			return 1;
		}
		return 0;
	}

}
