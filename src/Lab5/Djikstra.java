/* Djikstra's Algorithm */

package Lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Djikstra {

	public static void main(String args[]) throws NumberFormatException, IOException {
		int adjMat[][] = new int[10][10];
		int dist[] = new int[10];
		int visited[] = new int[10];
		int startNode = 0, i, j, n, v;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the number of nodes\n");
		n = Integer.parseInt(br.readLine());
		// Entering the adjacency matrix
		System.out.println("Enter the adjacency matrix\n");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.println("From " + i + " to " + j);
				adjMat[i][j] = Integer.parseInt(br.readLine());
			}
		}

		// now calculating distance from starting node to all vertices
		dist[0] = 0;
		for (i = 1; i < n; i++) {
			dist[i] = adjMat[startNode][i];
			visited[i] = -1;
		}

		for (i = 1; i < n; i++) {
			// finding the minimum most distance
			int min = 999, u = 0;
			for (j = 1; j < n; j++) {
				if (dist[j] < min && visited[j] == -1) {
					u = j;
					min = dist[j];
				}
			}
			visited[u] = 1;
			// mark the node with the smallest distance visited
			// we will visit that node next

			for (v = 1; v < n; v++) {
				if (dist[u] + adjMat[u][v] < dist[v] && visited[v] == -1) {
					dist[v] = dist[u] + adjMat[u][v];
				}
			}
		}

		// Now printing the shortest distance from starting node to all other nodes
		System.out.println("Printing the shortest distances:\n");
		for (i = 0; i < n; i++) {
			System.out.println(dist[i] + "\t");
		}

	}
}
