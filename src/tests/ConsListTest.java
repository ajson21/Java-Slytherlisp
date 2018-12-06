package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import types.ConsList;

class ConsListTest {

	@Test
	void testEquals() {
		
		ConsList first = new ConsList(1);
		ConsList second = new ConsList(1);
		ConsList third = new ConsList(3);
		
		ConsList fourth = new ConsList(4, new ConsList(3));
		ConsList fifth = new ConsList(4, new ConsList(3));
		
		ConsList sixth = new ConsList(4, fifth);
		ConsList seventh = new ConsList(4, fifth);
		
		ConsList eighth = new ConsList(4, new ConsList(4, new ConsList(3)));

		assertTrue(!(first == second));
		
		assertTrue(first.equals(second));
		assertTrue(!third.equals(fourth));
		assertTrue(!second.equals(third));
		assertTrue(!first.equals(fourth));
		
		assertTrue(fourth.equals(fifth));
		assertTrue(sixth.equals(seventh));
		
		assertTrue(eighth.equals(seventh));
		assertTrue(eighth.equals(sixth));	
		
		ConsList str1 = new ConsList("hey");
		ConsList str2 = new ConsList("hi");
		
		
		
		
	}
	
	@Test
	void fromIterable() {
		
		ArrayList<Object> test = new ArrayList<Object>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		
		ConsList first = ConsList.fromIterable(test, 0);
		assertTrue(first.getCar().equals(1));
		assertTrue(first.getCdr().getCar().equals(2));
		assertTrue(first.getCdr().getCdr().getCar().equals(3));
		assertTrue(first.getCdr().getCdr().getCdr().getCar().equals(4));
		assertTrue(first.getCdr().getCdr().getCdr().getCdr().getCar().equals(5));
		assertTrue(first.getCdr().getCdr().getCdr().getCdr().getCdr() == null);
		
		Object[] test2 = new Object[5];
		test2[0] = 1;
		test2[1] = 2;
		test2[2] = 3;
		test2[3] = 4;
		test2[4] = 5;
		
		ConsList second = ConsList.fromIterable(test2,0);
		assertTrue(second.getCar().equals(1));
		assertTrue(second.getCdr().getCar().equals(2));
		assertTrue(second.getCdr().getCdr().getCar().equals(3));
		assertTrue(second.getCdr().getCdr().getCdr().getCar().equals(4));
		assertTrue(second.getCdr().getCdr().getCdr().getCdr().getCar().equals(5));
		
		assertTrue(first.equals(second));
		
		ArrayList<Object> test3= new ArrayList<Object>();
		ConsList temp = new ConsList(1);
		ConsList temp2 = new ConsList(2);
		ConsList temp3 = new ConsList(3);
		ConsList temp4 = new ConsList(4);
		ConsList temp5 = new ConsList(5);
		test3.add(temp);
		test3.add(temp2);
		test3.add(temp3);
		test3.add(temp4);
		test3.add(temp5);
		
		ConsList third = ConsList.fromIterable(test3, 0);
		assertTrue(third.getCar().equals(temp));
		assertTrue(third.getCdr().getCar().equals(temp2));
		assertTrue(third.getCdr().getCdr().getCar().equals(temp3));
		assertTrue(third.getCdr().getCdr().getCdr().getCar().equals(temp4));
		assertTrue(third.getCdr().getCdr().getCdr().getCdr().getCar().equals(temp5));
		assertTrue(third.getCdr().getCdr().getCdr().getCdr().getCdr() == null);
		
		Object[] test4 = new Object[5];
		ConsList temp6 = new ConsList(1);
		ConsList temp7 = new ConsList(2);
		ConsList temp8 = new ConsList(3);
		ConsList temp9 = new ConsList(4);
		ConsList temp10 = new ConsList(5);
		test4[0] = temp;
		
	}

}
