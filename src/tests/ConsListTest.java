package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import types.BuiltIn;
import types.ConsList;
import types.Parser;

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
		
	}
	
	@Test
	void testFromIterable() {
		
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
		ConsList thirdVer2 = ConsList.fromIterable(test3, 0);
		
		assertTrue(third.getCar().equals(temp));
		assertTrue(third.getCdr().getCar().equals(temp2));
		assertTrue(third.getCdr().getCdr().getCar().equals(temp3));
		assertTrue(third.getCdr().getCdr().getCdr().getCar().equals(temp4));
		assertTrue(third.getCdr().getCdr().getCdr().getCdr().getCar().equals(temp5));
		assertTrue(third.getCdr().getCdr().getCdr().getCdr().getCdr() == null);
		
		assertTrue(third.equals(thirdVer2));
		
		Object[] test4 = new Object[5];
		ConsList temp6 = new ConsList(1);
		ConsList temp7 = new ConsList(2);
		ConsList temp8 = new ConsList(3);
		ConsList temp9 = new ConsList(4);
		ConsList temp10 = new ConsList(5);
		test4[0] = temp6;
		test4[1] = temp7;
		test4[2] = temp8;
		test4[3] = temp9;
		test4[4] = temp10;
		ConsList fourth = ConsList.fromIterable(test4, 0);
		ConsList fourthVer2 = ConsList.fromIterable(test4, 0);
		
		assertTrue(fourth.getCar().equals(temp6));
		assertTrue(fourth.getCdr().getCar().equals(temp7));
		assertTrue(fourth.getCdr().getCdr().getCar().equals(temp8));
		assertTrue(fourth.getCdr().getCdr().getCdr().getCar().equals(temp9));
		assertTrue(fourth.getCdr().getCdr().getCdr().getCdr().getCar().equals(temp10));
		assertTrue(fourth.getCdr().getCdr().getCdr().getCdr().getCdr() == null);

		assertTrue(fourth.equals(fourthVer2));
		
	}
	
	@Test
	void testGetItem() {
		
		ArrayList<Object> test = new ArrayList<Object>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		ConsList first = ConsList.fromIterable(test, 0);
		
		assertTrue(first.getItem(0).equals(1));
		assertTrue(first.getItem(1).equals(2));
		assertTrue(first.getItem(2).equals(3));
		assertTrue(first.getItem(3).equals(4));
		assertTrue(first.getItem(4).equals(5));
		
		Object[] test2 = new Object[5];
		test2[0] = 1;
		test2[1] = 2;
		test2[2] = 3;
		test2[3] = 4;
		test2[4] = 5;
		ConsList second = ConsList.fromIterable(test2,0);
		
		assertTrue(second.getItem(0).equals(1));
		assertTrue(second.getItem(1).equals(2));
		assertTrue(second.getItem(2).equals(3));
		assertTrue(second.getItem(3).equals(4));
		assertTrue(second.getItem(4).equals(5));
		
		ConsList third = new ConsList(4);
		
		assertEquals(third.getItem(0), 4);
		
		for(int i = 1; i <= 100; i++) {
			
			assertEquals(third.getItem(i), null);
			
		}
		
		for(int i = 5; i <= 100; i++) {
			
			assertEquals(first.getItem(i), null);
			assertEquals(second.getItem(i), null);
			
		}
		
	}
	
	@Test
	void testIterate() {
		
		ArrayList<Object> test = new ArrayList<Object>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		ConsList first = ConsList.fromIterable(test, 0);
		ArrayList<Object> firstResult = first.iterate();
		
		assertEquals(firstResult.size(), 5);
		assertTrue(test.get(0).equals(firstResult.get(0)));
		assertTrue(test.get(1).equals(firstResult.get(1)));
		assertTrue(test.get(2).equals(firstResult.get(2)));
		assertTrue(test.get(3).equals(firstResult.get(3)));
		assertTrue(test.get(4).equals(firstResult.get(4)));
		
		Object[] test2 = new Object[5];
		test2[0] = 1;
		test2[1] = 2;
		test2[2] = 3;
		test2[3] = 4;
		test2[4] = 5;
		ConsList second = ConsList.fromIterable(test2,0);
		ArrayList<Object> secondResult = second.iterate();
		
		assertEquals(secondResult.size(), 5);
		assertTrue(test2[0].equals(secondResult.get(0)));
		assertTrue(test2[1].equals(secondResult.get(1)));
		assertTrue(test2[2].equals(secondResult.get(2)));
		assertTrue(test2[3].equals(secondResult.get(3)));
		assertTrue(test2[4].equals(secondResult.get(4)));
		
	}
	
	@Test
	void testCells() {
		
		ArrayList<Object> test = new ArrayList<Object>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		ConsList first = ConsList.fromIterable(test, 0);
		ArrayList<Object> firstResult = first.cells();
		
		assertEquals(firstResult.size(), 5);
		assertTrue(first.equals(firstResult.get(0)));
		assertTrue(first.getCdr().equals(firstResult.get(1)));
		assertTrue(first.getCdr().getCdr().equals(firstResult.get(2)));
		assertTrue(first.getCdr().getCdr().getCdr().equals(firstResult.get(3)));
		assertTrue(first.getCdr().getCdr().getCdr().getCdr().equals(firstResult.get(4)));
		
		Object[] test2 = new Object[5];
		test2[0] = 1;
		test2[1] = 2;
		test2[2] = 3;
		test2[3] = 4;
		test2[4] = 5;
		ConsList second = ConsList.fromIterable(test2,0);
		ArrayList<Object> secondResult = second.cells();
		
		assertEquals(secondResult.size(), 5);
		assertTrue(second.equals(secondResult.get(0)));
		assertTrue(second.getCdr().equals(secondResult.get(1)));
		assertTrue(second.getCdr().getCdr().equals(secondResult.get(2)));
		assertTrue(second.getCdr().getCdr().getCdr().equals(secondResult.get(3)));
		assertTrue(second.getCdr().getCdr().getCdr().getCdr().equals(secondResult.get(4)));
		
	}
	
	@Test
	void testLength() {
		
		ArrayList<Object> test = new ArrayList<Object>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		ConsList first = ConsList.fromIterable(test, 0);
		
		assertEquals(first.length(), 5);
		
		Object[] test2 = new Object[5];
		test2[0] = 1;
		test2[1] = 2;
		test2[2] = 3;
		test2[3] = 4;
		test2[4] = 5;
		ConsList second = ConsList.fromIterable(test2,0);
		
		assertEquals(second.length(), 5);
		
		ConsList third = new ConsList(0);
		ConsList original = third;
		
		for(int i = 1; i < 100; i++) {
			
			third.setCdr(new ConsList(i));
			third = third.getCdr();
			
		}
		
		assertEquals(original.length(), 100);
		
	}
	
	@Test
	void testContains() {
		
		ArrayList<Object> test = new ArrayList<Object>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		ConsList first = ConsList.fromIterable(test, 0);
		ConsList item1 = new ConsList(1);
		ConsList item2 = new ConsList(2);
		ConsList item3 = new ConsList(3);
		ConsList item4 = new ConsList(4);
		ConsList item5 = new ConsList(5);
		
		assertTrue(first.contains(item1));
		assertTrue(first.contains(item2));
		assertTrue(first.contains(item3));
		assertTrue(first.contains(item4));
		assertTrue(first.contains(item5));
		
		Object[] test2 = new Object[5];
		test2[0] = 1;
		test2[1] = 2;
		test2[2] = 3;
		test2[3] = 4;
		test2[4] = 5;
		ConsList second = ConsList.fromIterable(test2,0);
		ConsList item6 = new ConsList(1);
		ConsList item7 = new ConsList(2);
		ConsList item8 = new ConsList(3);
		ConsList item9 = new ConsList(4);
		ConsList item10 = new ConsList(5);
		
		assertTrue(second.contains(item6));
		assertTrue(second.contains(item7));
		assertTrue(second.contains(item8));
		assertTrue(second.contains(item9));
		assertTrue(second.contains(item10));
		
	}
	
	@Test
	void testReversed() {
		
		ArrayList<Object> test = new ArrayList<Object>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		ConsList first = ConsList.fromIterable(test, 0);
		ArrayList<Object> result = first.reversed();
		ArrayList<Object> test2 = new ArrayList<Object>();
		test2.add(5);
		test2.add(4);
		test2.add(3);
		test2.add(2);
		test2.add(1);
		
		assertEquals(result,test2);
		
	}


	@Test
	void testParsed() {

		String line = "(define (do-123 fun) \n (map fun '(1 2 3.0))) \n";
		Parser p = new Parser();
		Vector check = new Vector();
		check = p.Parsestr(line);
		System.out.println(check);
		Vector temp = new Vector();
		temp.add("(");
		temp.add("define");
		temp.add("(");
		temp.add("do-123");
		temp.add("fun");
		temp.add(")");
		temp.add("(");
		temp.add("map");
		temp.add("fun");
		temp.add("'");
		temp.add("(");
		temp.add("1");
		temp.add("2");
		temp.add("3.0");
		temp.add(")");
		temp.add(")");
		temp.add(")");
		assertEquals(check,temp);
	}

	@Test
	void testAdd() {

		BuiltIn b = new BuiltIn();
		Vector check = new Vector();
		check.add(1);
		Number test = b.add(check);
//		assertEquals(test,1.0);
		check.add(2);
		Number test1 = b.add(check);
//		assertEquals(test1,3.0);
	}
	
}
