/*Binary Search using Recursive Technique*/

package Lab1;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchRecursive {

	static int values = 500;
	static int datasetNumbers = 30;

	static int binarySearch(int[] list, int find, int start, int end) {
		int mid = (start + end) / 2;
		while (start <= end) {
			if (list[mid] == find) {
				return 1;
			} else if (list[mid] < find) {
				return binarySearch(list, find, mid + 1, end);
			} else {
				return binarySearch(list, find, start, mid - 1);
			}
		}
		return 0;
	}


	static int binarySearch(int[] list, int find) {
		int start = 0;
		int end = values - 1;
		int mid = (start + end) / 2;

		while (start <= end) {
			mid = (start + end) / 2;
			if (list[mid] == find) {
				return 1;
			} else if (list[mid] < find) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] list = new int[5000000];
		int find = 499;
		Random rd = new Random();

		long[][] dataset = new long[datasetNumbers][2];

		for (int i = 0; i < datasetNumbers; i++) {

			values = values + 10000;
			dataset[i][0] = values;

			for (int j = 0; j < values; j++) {
				list[i] = rd.nextInt(values * 10) + 1;
			}

			// find = list[2];

			Arrays.sort(list);

			long startTimeNano = System.nanoTime();
			// long startTime = System.currentTimeMillis();
			int result = binarySearch(list, find, 0, values-1);
			// long endTime = System.currentTimeMillis();
			long endTimeNano = System.nanoTime();
			if (result == 1)
				System.out.println("Successful");
			else
				System.out.println("Unsuccessful");

			// System.out.println("Time taken:" + (endTime - startTime));
			System.out.println("Time taken in nano:" + (endTimeNano - startTimeNano) + "    nanoseconds");
			// System.out.println(startTime);
			// System.out.println(endTime);
			System.out.println(startTimeNano);
			System.out.println(endTimeNano);

			dataset[i][1] = (endTimeNano - startTimeNano);
			// dataset[i][1] = (endTime - startTime);

		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < 30; i++) {
			System.out.print("" + dataset[i][0]);
			double x = dataset[i][1];
			/// 1000;
			System.out.println("\t" + x / 1000);

		}

	}
}
