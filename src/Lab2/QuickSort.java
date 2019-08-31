/* Quick Sort using middle element as Pivot */

package Lab2;

public class QuickSort {

	private int array[];
	private int length;
	static int values = 5000;
	static int datasetNumbers = 100;
	static int counter = 1;// for Printing
	int swaps=0;

	public void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {

		// //To Print each Iteration
		// print();

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which is greater
			 * then the pivot value, and also we will identify a number from right side
			 * which is less then the pivot value. Once the search is done, then we exchange
			 * both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				// move index to next position on both sides
				i++;
				j--;
				swaps++;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	private void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void perform(int[] arr) {

		QuickSort ob = new QuickSort();
		ob.sort(arr);
	}

	public void print() {
		// System.out.println("No. "+ counter+++" iteration");
		for (int i = 0; i < array.length; i++) {
			System.out.print("" + array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr2[] = new int[32];
		for (int i = arr2.length; i >0; i--)
		{
			arr2[i-1] = i;
		}
		QuickSort obj = new QuickSort();

		long startTimeNano = System.nanoTime();
		obj.sort(new int[] {9,7,8,6,5,8,3,4,1});
		long endTimeNano = System.nanoTime();

		System.out.println("Time taken in nano:" + (endTimeNano - startTimeNano) + "    nanoseconds");
		obj.print();
		System.out.println("Swaps:" + obj.swaps);
	}
}
