/* Quick sort using Random Pivot */

package Lab2;

import java.util.Random;

public class Randomized_Quick_Sort {
	public static int N = 20;
	public static int[] sequence = new int[N];
	static int counter = 1;//for Printing
	
	public void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		Randomized_Quick_Sort.sequence = inputArr;
		int length = inputArr.length;
		QuickSort(0, length - 1);
	}

	public static void QuickSort(int left, int right) {
		////To Print each Iteration 
		//		print();
		if (right - left <= 0)
			return;
		else {
			Random rand = new Random();
			int pivotIndex = left + rand.nextInt(right - left + 1);
			swap(pivotIndex, right);

			int pivot = sequence[right];
			int partition = partitionIt(left, right, pivot);
			QuickSort(left, partition - 1);
			QuickSort(partition + 1, right);
		}
	}

	public static int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while (true) {
			while (sequence[++leftPtr] < pivot)
				;
			while (rightPtr > 0 && sequence[--rightPtr] > pivot)
				;

			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr;
	}

	public static void swap(int dex1, int dex2) {
		int temp = sequence[dex1];
		sequence[dex1] = sequence[dex2];
		sequence[dex2] = temp;
	}

	static void printSequence(int[] sorted_sequence) {
		for (int i = 0; i < sorted_sequence.length; i++)
			System.out.print(sorted_sequence[i] + " ");
	}
	
	public static void print()
	{
		System.out.println("No. "+ counter+++" iteration");
		for(int i=0;i<sequence.length;i++)
		{
			System.out.print(""+sequence[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		int arr2[] = {99,2,3,4,55,6,7,8};
		Randomized_Quick_Sort obj = new Randomized_Quick_Sort();
		
		long startTimeNano = System.nanoTime();
		obj.sort(arr2);
		long endTimeNano = System.nanoTime();
		
		System.out.println("Time taken in nano:" + (endTimeNano - startTimeNano) + "    nanoseconds");
		obj.print();
	}
}