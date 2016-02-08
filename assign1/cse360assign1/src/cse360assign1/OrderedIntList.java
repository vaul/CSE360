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
		int insertIndex = getInsertIndex(value);
		
		if (insertIndex > 9 || data[insertIndex] == value)
		{
			//do nothing if insertIndex is larger than array 
			// or if value is not unique
			return;
		}
		else if (count < 10)
		{
			//shift memory only for what is in the array
			shift(insertIndex, count);
						
			//increment count
			count = count + 1;
		}
		else if(count == 10)
		{
			//shift all memory
			shift(insertIndex, 9);
		}

		//store data
		data[insertIndex] = value;
	}

	private int getInsertIndex(int value) {
		int insertIndex = 0;
		for (int index = 0; index < count && value > data[index]; index++)
		{
			insertIndex++;
		}
		return insertIndex;
	}

	private void shift(int insertIndex, int count) {
		for (int index = count; index > insertIndex; index--)
		{
			data[index] = data[index - 1];
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
				System.out.print("\r\n");
			}
			else if (index < count)
			{
				System.out.print("\t");
			}			
		}
	}
}