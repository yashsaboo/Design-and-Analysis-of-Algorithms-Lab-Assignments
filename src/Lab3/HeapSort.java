/*
 * Implement the “Heapsort” algorithm. The “heapify” process should be implemented as a separate method
 */

package Lab3;

public class HeapSort {
	
	void heap(int[] x)
	{
		int len = x.length;
		
		for(int i=len/2-1; i>=0;i--)
		{
			heapify(x, len, i);
		}
		
		
		for(int i=len-1; i>=0; i--)
		{
			System.out.println(x[0]);
			x[0]=x[i];
			heapify(x, i, 0);
		}
		
	}

	private void heapify(int[] x, int len, int i) {
		
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left<len && x[left]>x[largest])
		{
			largest = left;
		}
		
		if(right<len && x[right]>x[largest])
		{
			largest = right;
		}
		
		if(largest != i )
		{
			int temp = x[i];
			x[i] = x[largest];
			x[largest] = temp;
			
			heapify(x, len, largest );
		}		
		
	}
	public static void main(String args[]) {
		
		int[] arr = {1,2,3,6,4,5}; 
		
		new HeapSort().heap(arr);
	}

}