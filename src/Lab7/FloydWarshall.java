/*
 * Implement Floyd’s Algorithm to find a shortest path between each pair of vertices in a weighted graph.
 * Display the results as a distance matrix.
 */

package Lab7;

public class FloydWarshall {
	public static void main(String args[]) {
		// first accepting the matrix;
		int i, j, k;
		int matrix[][] = { { 0, 8, 3, 5, 999 }, { 8, 0, 2, 999, 5 }, { 999, 1, 0, 3, 4 }, { 6, 999, 999, 0, 7 },
				{ 999, 5, 999, 999, 0 } };

		int d[][] = new int[5][5];

		// for D0
		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				d[i][j] = matrix[i][j];
			}
		}
		// printing D0
		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println("\n");
		}

		System.out.println("It is printing till here\n");

		// For D1 to D5

		for (k = 0; k < 5; k++) {
			System.out.println("D: " + k);
			for (i = 0; i < 5; i++) {
				for (j = 0; j < 5; j++) {
					if (d[i][j] > (d[i][k] + d[k][j])) {
						d[i][j] = (d[i][k] + d[k][j]);
					}
					System.out.print(d[i][j] + " \t");
				}
				System.out.println("\n\n");
			}
		}
	}
}
