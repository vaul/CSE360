package cse360assign1;

/** Ordered list of up to 10 integers
 * @author Vaul Demar Kranak
 * @version Jan 19, 2016
 * 
 */
public class OrderedIntList
{
	private int[] data;
	private int count;
	
	/** Create an empty list */
	OrderedIntList()
	{
		data = new int[10];
		count = 0;
	}
	
	/** Insert unique integer 
	 *  @param value	integer added to array
	 */
	public void insert(int value) 
	{
		int insertIndex = 0;
		
		//find insert location
		for (int index = 0; index < count && value > data[index]; index++)
		{
			insertIndex++;
		}
		
		//do nothing if insertIndex is larger than array or if not unique
		if (insertIndex < 10 && data[insertIndex] != value)
		{
			//shift memory
			int startIndex = count > 9 ? 9 : count; //the largest index to shift is 9
			for (int index = startIndex; index > insertIndex; index--)
			{
				data[index] = data[index - 1];
			}
			
			//store data
			data[insertIndex] = value;
			
			//increment count
			count = count + 1;
			
			//count can never be more than 10;
			if (count > 10)
			{
				count = 10;
			}
		}
	}
	
	/** Displays the list */
	public void print() 
	{
		for (int index = 0; index < count; index++)
		{
			System.out.print(data[index]);
			
			if(index == count - 1)
			{
			}
			else if ((index + 1) % 5 == 0)
			{
				System.out.println();
			}
			else if (index < count)
			{
				System.out.print("\t");
			}			
		}
	}
}