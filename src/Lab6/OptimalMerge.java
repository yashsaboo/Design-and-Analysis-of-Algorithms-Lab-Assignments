/*
 * Optimal Merge Pattern using Heaps
 * When two or more sorted files are to be merged all together to form a single file, 
 * the minimum computations done to reach this file are known as Optimal Merge Pattern.
 */

package Lab6;

public class OptimalMerge{
	TreeNode head = new TreeNode();
    public void initialise(int arr[])
    {
    	TreeNode prv= new TreeNode();
    	prv=null;
        for(int i=0;i<arr.length;i++)
        {
        	
        	TreeNode nxt = new TreeNode();
        	nxt.data=arr[i];
        	nxt.left=null;
        	nxt.right=null;
        	nxt.next=null;
        	if(i==0)
        	{
        		head=nxt;
        	}
        	else
        	{
        		prv.next=nxt;
        	}
        	prv=nxt;
        }
    }
    
    public void print()
    {
    	TreeNode counter= head;
    	while(counter!=null)
    	{
    		System.out.print(counter.data+" ");
    		counter=counter.next;
    	}
    	System.out.println();
    }
    
    
    
    public void perform(int arr[])
    {
            initialise(arr);
            print();
            
            while((head!=null)&&(head.next!=null))
            {
            	//System.out.println("In first while");
            	TreeNode first = head;
            	TreeNode second = head.next;
            	TreeNode cbn = new TreeNode();
            	cbn.data=first.data+second.data;
            	cbn.left=first;
            	cbn.right=second;
            	cbn.next=null;
            	
            	if(head.next.next!=null)//More than 2 Nodes were available before combination
            	{
            		//System.out.println("1");
            		head = head.next.next;
            		TreeNode counter= head;
            		TreeNode prvcounter= head;
            		if((head!=null)&&(head.data>cbn.data))//If new combination value is less than first node value
        			{
            			//System.out.println("2");
            			//Insertion in start
        				cbn.next=head;
        				head=cbn;
        			}
            		else
            		{
            			//System.out.println("3");
            			if(head.next==null)//Only one node is present and combine value is more than that node value
            				head.next=cbn;
            			else
            			{
            				//System.out.println("4");
	            			counter=head.next;
	                		prvcounter= head;
		            		while(counter!=null)
		            		{
		            				if(counter.data>cbn.data)//Insertion between two nodes
		            				{
		            					//System.out.println("5");
		            					cbn.next=counter;
		            					prvcounter.next=cbn;
		            					break;
		            				}
		            				else
		            				{
		            					//System.out.println("6");
		            					if(counter.next==null)//Insertion in the end
		            					{
		            						counter.next=cbn;
		            						break;
		            					}
		            					else//Move to next node
		            					{
		            						prvcounter = counter;
		            						counter = counter.next;
		            					}
		            				}		
		            		}
            			}
            		}
            	}
            	else
            	{
            		head = cbn;
            	}
                print();
            }
            
    }
    
    public static void main(String[] args) {
		
	}
    
}
