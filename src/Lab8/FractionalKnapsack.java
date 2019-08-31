/* 
 * Fractional Knapsack:
 * Find the maximum benefit subset that does not exceed a given weight W, 
 * allowing for fractional items.
 */

package Lab8;

public class FractionalKnapsack {

	int n;
	double ratio[] = new double[10];
	int item[] = new int[10];
	int wt[] = new int[10];
	int worth[] = new int[10];
	int check[] = new int[10];

	public void perform(int n1, int wt1[], int worth1[], int limit) {
		n = n1;
		for (int i = 0; i < n; i++) {
			ratio[i] = (double) worth1[i] / wt1[i];
		}
		print(ratio);
		sort(n1, wt1, worth1);
		for (int i = 0; i < n; i++) {
			ratio[i] = (double) worth[i] / wt[i];
		}
		print(ratio);
		print(item);
		
		int counter=0;
		int profit=0;
		int k=0;
		System.out.println("Items included are : ");
		for(int i=0; i<n;i++)
		{
			if(counter==limit)
				break;
			if((limit-counter)>=wt[i])
			{
				System.out.println("In if");
				counter += wt[i];
				check[k++] = item[i];
				profit+=worth[i];
			}
			else
			{
				profit+=ratio[i]*(limit-counter);
				counter=limit;
				check[k++] = item[i];				
			}
		}
		print(check);
		System.out.println("Total profit: "+profit);
	}

	public void sort(int n1, int wt1[], int worth1[]) {
		for(int i=0; i<n;i++)
		{
			int max=0;
			for(int j=1;j<n;j++)
			{	
				//System.out.println("min:"+(max+1)+"  ");
				if((ratio[j]!=0)&&(ratio[max]<ratio[j]))
						{
							max=j;
						}
				if(ratio[max]==0)
				{
					max=j;
				}
			}
			//System.out.println("Swap");
			item[i] = max+1;
			wt[i] = wt1[max];
			worth[i] = worth1[max];
			ratio[max] = 0;
		}
	}
	
	public void print(double x[])
	{
		System.out.print("Ratio: ");
		for (int i = 0; i < n; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
	public void print(int x[])
	{
		System.out.print("Items: ");
		for (int i = 0; i < n; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}

}

