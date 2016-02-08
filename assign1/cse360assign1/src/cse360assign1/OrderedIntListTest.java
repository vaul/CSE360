package cse360assign1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderedIntListTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void emptyList() {
		OrderedIntList oList = new OrderedIntList();
		
		oList.print();
		
		assertEquals("", outContent.toString());
	}

	@Test
	public void singleInt() {
		OrderedIntList oList = new OrderedIntList();
		oList.insert(3);
		oList.print();
		
		assertEquals("3", outContent.toString());
	}
	
	@Test
	public void inOrder() {
		OrderedIntList oList = new OrderedIntList();
		int startValue = 4;
		
		for (int value = 0; value < 12; value++)
		{
			oList.insert(startValue + value);
		}
		
		oList.print();
		
		assertEquals("4\t5\t6\t7\t8\r\n9\t10\t11\t12\t13", outContent.toString());
	}
	
	@Test
	public void reverseOrder() {
		OrderedIntList oList = new OrderedIntList();
		int startValue = 4;
		
		for (int value = 0; value < 11; value++)
		{
			oList.insert(startValue - value);
		}
		
		oList.print();
		
		assertEquals("-6\t-5\t-4\t-3\t-2\r\n-1\t0\t1\t2\t3", outContent.toString());
	}
	
	@Test
	public void unique() {
		OrderedIntList oList = new OrderedIntList();
		
		for (int value = 0; value < 3; value++)
		{
			oList.insert(55);
		}
		
		oList.print();
		
		assertEquals("55", outContent.toString());
	}
	
	@Test
	public void outOfOrder() {
		OrderedIntList list = new OrderedIntList();
		
		list.insert(5);
		list.insert(7);
		list.insert(4);
		list.insert(1);
		list.insert(8);				
		list.insert(9);
		list.insert(2);
		list.insert(10);
		list.insert(6);
		list.insert(3);
		
		list.print();
		
		assertEquals("1\t2\t3\t4\t5\r\n6\t7\t8\t9\t10", outContent.toString());
	}
	
	@Test
	public void threeInserts() {
		OrderedIntList list = new OrderedIntList();
		
		list.insert(4);
		list.insert(9);
		list.insert(1);
		
		list.print();
		
		assertEquals("1\t4\t9", outContent.toString());
	}
	
	@Test
	public void sevenInserts() {
		OrderedIntList list = new OrderedIntList();
		
		list.insert(10);
		list.insert(80);				
		list.insert(90);
		list.insert(20);
		list.insert(100);
		list.insert(60);
		list.insert(30);
				
		list.print();
		
		assertEquals("10\t20\t30\t60\t80\r\n90\t100", outContent.toString());
	}
}
