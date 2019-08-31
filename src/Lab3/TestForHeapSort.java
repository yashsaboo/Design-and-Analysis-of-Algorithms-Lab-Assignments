/*Test Complexity for Heap Sort */

package Lab3;

import java.util.Random;

public class TestForHeapSort {
	static int values = 1500;
	static int datasetNumbers = 35;
	
	public static void main(String[] args) {
		int[] list = new int[5000000];
		int find = 499;
		Random rd = new Random();

		long[][] dataset = new long[datasetNumbers][2];

		for (int i = 0; i < datasetNumbers; i++) {
			
			
			values = values + 1500;
			dataset[i][0] = values;

			for (int j = 0; j < values; j++) {
				list[j
				     ] = rd.nextInt(values * 10) + 1;
			}
			
			long startTimeNano = System.nanoTime();
			new HeapSort().heap(list);
			long endTimeNano = System.nanoTime();
			
			System.out.println("Time taken in nano:" + (endTimeNano - startTimeNano) + "    nanoseconds");
			
			System.out.println(startTimeNano);
			System.out.println(endTimeNano);

			dataset[i][1] = (endTimeNano - startTimeNano);

		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < 30; i++) {
			System.out.print(""+dataset[i][0]);
			double x = dataset[i][1];
					///1000;
			System.out.println("\t"+x/10);


		}

	}

}

