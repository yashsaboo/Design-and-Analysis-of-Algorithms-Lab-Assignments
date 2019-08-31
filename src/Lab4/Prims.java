/*
 * Prim's algorithm is a minimum spanning tree algorithm that takes a graph as input
 * and finds the subset of the edges of that graph which
 * forms a tree that includes every vertex and
 * has the minimum sum of weights among all the trees that can be formed from the graph
 */

package Lab4;

public class Prims {

	int adj[][] = new int[][] { 
		{ -1, 1, -1, 4, -1, -1, -1 }, 
		{ 1, -1, 2, 6, 4, -1, -1 },
		{ -1, 2, -1, -1, 5, 6, -1 },
		{ 4, 6, -1, -1, 3, -1, 4 },
		{ -1, 4, 5, 3, -1, 8, 7 },
		{ -1, 1, 6, -1, 8, -1, 3 },
		{ -1, 1, -1, 4, 7, 3, -1 }
		};

	int x = adj.length;
	int key[] = new int[x];
	int mst[] = new int[x];
	int par[] = new int[x];

	void initialise() {
		key[0] = 0;
		mst[0] = 0;
		par[0] = -1;
		for (int i = 1; i < x; i++) {
			key[i] = 999;
			mst[i] = 0;
			par[i] = 999;
		}
	}

	void prim() {
		for (int i = 0; i < x - 1; i++) {
			int current = min();
			for (int j = 0; j < x; j++) {
				if ((key[j] > adj[current][j]) && (mst[j] == 0) && (adj[current][j]!=-1)) {
					key[j] = adj[current][j];
					par[j] = current;
				}
				mst[current]=1;
			}
		}
	}

	private int min() {
		int min = 9999;
		int minver = -1;
		for (int i = 0; i < x; i++) {
			if ((mst[i] == 0) && (min > key[i])) {
				min = key[i];
				minver = i;
			}
		}
		return minver;
	}

	void print() {
		System.out.println();
		for (int i = 0; i < x; i++) {
			System.out.print(key[i]+" \t");
		}
		System.out.println();
		for (int i = 0; i < x; i++) {
			System.out.print(par[i]+" \t");
		}
		System.out.println();
		System.out.print("0 \t");
		for (int i = 1; i < x; i++) {
			System.out.print(adj[par[i]][key[i]]+" \t");
		}
		System.out.println();
		//System.out.println();
		for (int i = 0; i < x; i++) {
			System.out.print(mst[i]+" \t");
		}
	}

	public static void main(String args[]) {
		Prims obj = new Prims();
		obj.initialise();
		obj.prim();
		obj.print();

	}

}
