/*Insertion Sort*/

package Lab1;

public class InsertionSort
{
	int swaps=0;
    /*Function to sort array using insertion sort*/
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                swaps++;
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
 
    
    public void perform(int[] arr)
    {       
    	
        InsertionSort ob = new InsertionSort();        
        ob.sort(arr);
        
    }
    
    public static void main(String[] args) {
    	
    	int arr2[] = new int[32];
		for (int i = arr2.length; i >0; i--)
		{
			arr2[i-1] = i;
		}
		
    	InsertionSort ob = new InsertionSort();        
        ob.sort(new int[] {9,7,8,6,5,8,3,4,1});
    	System.out.println("Swaps:" + ob.swaps);
	}
}
