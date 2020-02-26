package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SimpleListTest2 {
	
	/*
	 * This method is used to compare two arrays for equality.
	 * The method takes in 2 arrays to be compared, and returns
	 * true if all elements of array "array1" match all elements in 
	 * array "array2" in order.
	 * @param array1 is an array that is to be compared to array2
	 * @param array2 is an array that is to be compared to array1
	 * @return a boolean value, indicating whether or not array1 and array2 are equal.
	 */
	boolean equals(int array1[], int array2[]) {

		boolean isEqual = true;
		int index = 0;

		if(array1.length != array2.length)
			isEqual = false;

		while(isEqual && index < array1.length) {

			if(array1[index] != array2[index])
				isEqual = false;

			index += 1;
		}
		
		return isEqual;
	}

	// test case when list is empty and one element is added
	@Test
	void testAdd1() {
		int expectedCount;
		int actualCount;
		boolean passTest;

		// check the element is being added to list correctly
		SimpleList list1 = new SimpleList();
		list1.add(69);
		int expectedList1[] = {69, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int actualList1[] = list1.getList();
		
		// check if count is updated correctly
		expectedCount = 1;
		actualCount = list1.count();
		
		passTest = expectedCount == actualCount && Arrays.equals(expectedList1, actualList1);
		assertTrue(passTest);
	}
	
	// test case when more than 1 element is added to list
	@Test
	void testAdd2() {
		boolean passTest;
		// check if the elements are being added to list correctly
		SimpleList list2 = new SimpleList();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		int expectedList2[] = {3, 2, 1, 0, 0, 0, 0, 0, 0, 0};
		int actualList2[] = list2.getList();
		
		// check if count is updated correctly
		int expectedCount = 3;
		int actualCount = list2.count();

		passTest = expectedCount == actualCount && Arrays.equals(expectedList2, actualList2);
		
		assertTrue(passTest);
	}
	
	// test case when list has 10 elements and another element is 
	// added to it
	@Test
	void testAdd3() {
		boolean passTest;
		// check if the element is being added to list correctly
		SimpleList list3 = new SimpleList();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(6);
		list3.add(7);
		list3.add(8);
		list3.add(9);
		list3.add(10);
		list3.add(11);
		list3.add(12);
		int expectedList3[] = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0, 0};
		int actualList3[] = list3.getList();
		
		// check if count is updated correctly
		int expectedCount = 12;
		int actualCount = list3.count();

		passTest = expectedCount == actualCount && Arrays.equals(expectedList3, actualList3);

		assertTrue(passTest);
	}

	@Test
	// test case when list is empty and an element removal is attempted
	void testRemove1() {
		int expectedCount;
		int actualCount;
		boolean passTest;

		// check if the element is removed from the list correctly
		SimpleList list1 = new SimpleList();
		list1.remove(69);
		int expectedList1[] = {0, 0, 0, 0, 0, 0, 0};
		int actualList1[] = list1.getList();
		
		// check if count is correct
		expectedCount = 0;
		actualCount = list1.count();

		passTest = expectedCount == actualCount && Arrays.equals(expectedList1, actualList1);
		
		assertTrue(passTest);
	}
	
	// test case when list has one element, and that element is removed
	@Test
	void testRemove2() {
		boolean passTest;

		// check if the element is removed from the list correctly
		SimpleList list2 = new SimpleList();
		list2.add(69);
		list2.remove(69);
		int expectedList2[] = {0, 0, 0, 0, 0, 0, 0};
		int actualList2[] = list2.getList();
		
		// check if count is correct
		int expectedCount = 0;
		int actualCount = list2.count();
		
		passTest = expectedCount == actualCount && Arrays.equals(expectedList2, actualList2);
		
		assertTrue(passTest);
	}
	
	// test case when removing an element that is not in non-empty list
	@Test
	void testRemove3() {
		boolean passTest;
		
		// check if the element is being removed from list correctly
		SimpleList list3 = new SimpleList();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.remove(314);
		int expectedList3[] = {3, 2, 1, 0, 0, 0, 0};
		int actualList3[] = list3.getList();
		
		// check if count is correct
		int expectedCount = 3;
		int actualCount = list3.count();

		passTest = expectedCount == actualCount && Arrays.equals(expectedList3, actualList3);
		
		assertTrue(passTest);
	}
	
	// test case when an element is removed from the beginning of 
	// a non-empty list
	@Test
	void testRemove4() {
		boolean passTest;

		// check if the element is being added to list correctly
		SimpleList list4 = new SimpleList();
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list4.remove(3);
		int expectedList4[] = {2, 1, 0, 0, 0, 0, 0};
		int actualList4[] = list4.getList();
		
		// check if count is correct
		int expectedCount = 2;
		int actualCount = list4.count();
		
		passTest = expectedCount == actualCount && Arrays.equals(expectedList4, actualList4);

		assertTrue(passTest);
	}
	
	// test case when an element is removed from the end of a non-empty list
	@Test
	void testRemove5() {
		boolean passTest;
		
		// check if the element is being added to list correctly
		SimpleList list5 = new SimpleList();
		list5.add(1);
		list5.add(2);
		list5.add(3);
		list5.remove(1);
		int expectedList5[] = {3, 2, 0, 0, 0, 0, 0};
		int actualList5[] = list5.getList();
	
		// check if count is correct
		int expectedCount = 2;
		int actualCount = list5.count();

		passTest = expectedCount == actualCount && Arrays.equals(expectedList5, actualList5);

		assertTrue(passTest);
	}
	
	// test case when an element is removed from within a non-empty list
	@Test
	void testRemove6() {
		boolean passTest;
		
		// check if the element is being added to list correctly
		SimpleList list6 = new SimpleList();
		list6.add(1);
		list6.add(2);
		list6.add(3);
		list6.remove(2);
		int expectedList6[] = {3, 1, 0, 0, 0, 0, 0};
		int actualList6[] = list6.getList();
	
		// check if count is correct
		int expectedCount = 2;
		int actualCount = list6.count();

		passTest = expectedCount == actualCount && Arrays.equals(expectedList6, actualList6);
		assertTrue(passTest);
	}
	
	// test case when list has 10 elements and the last element is removed
	@Test
	void testRemove7() {
		boolean passTest;
		
		// check if the element is being added to list correctly
		SimpleList list7 = new SimpleList();
		list7.add(1);
		list7.add(2);
		list7.add(3);
		list7.add(4);
		list7.add(5);
		list7.add(6);
		list7.add(7);
		list7.add(8);
		list7.add(9);
		list7.add(10);
		list7.add(11);
		list7.add(12);
		list7.remove(3);
		int expectedList7[] = {12, 11, 10, 9, 8, 7, 6, 5, 4, 2, 1, 0, 0, 0, 0};
		int actualList7[] = list7.getList();
		
		// check if count is correct
		int expectedCount = 11;
		int actualCount = list7.count();

		passTest = expectedCount == actualCount && Arrays.equals(expectedList7, actualList7);
		
		assertTrue(passTest);
	}

	// test case when a duplicate integer is added, and then removed 
	// (should remove only the first occurence)	
	@Test
	void testRemove8() {
		boolean passTest;
		
		// check if the element is being added to list correctly
		SimpleList list8 = new SimpleList();
		list8.add(1);
		list8.add(2);
		list8.add(3);
		list8.add(2);
		list8.add(12);
		list8.remove(2);
		int expectedList8[] = {12, 3, 2, 1, 0, 0, 0};
		int actualList8[] = list8.getList();
		
		// check if count is correct
		int expectedCount = 4;
		int actualCount = list8.count();

		passTest = expectedCount == actualCount && Arrays.equals(expectedList8, actualList8);
		
		assertTrue(passTest);

	}

	// test case when list is empty
	@Test
	void testCount1() {
		int expectedOutput;
		int actualOutput;

		SimpleList list1 = new SimpleList();
		expectedOutput = 0;
		actualOutput = list1.count();
		assertEquals(expectedOutput, actualOutput);
	}
	
	// test case when list is not empty, but has <10 elements added to it
	@Test
	void testCount2() {
		SimpleList list2 = new SimpleList();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		int expectedOutput = 3;
		int actualOutput = list2.count();
		assertEquals(expectedOutput, actualOutput);
		
	}
	
	// test case when list has >10 elements added to it
	@Test
	void testCount3() {
		SimpleList list3 = new SimpleList();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(6);
		list3.add(7);
		list3.add(8);
		list3.add(9);
		list3.add(10);
		list3.add(11);
		list3.add(12);
		int expectedOutput = 12;
		int actualOutput = list3.count();
		assertEquals(expectedOutput, actualOutput);
	}
	
	// test case when list is empty
	@Test
	void testToString1() {
		String expectedOutput;
		String actualOutput;
		
		SimpleList list1 = new SimpleList();
		expectedOutput = "";
		actualOutput = list1.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	// test case when list is not empty, but has <10 elements added to it
	@Test
	void testToString2() {
		SimpleList list2 = new SimpleList();
		list2.add(3);
		list2.add(2);
		list2.add(1);
		String expectedOutput = "1 2 3";
		String actualOutput = list2.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	// test case when list has >10 elements added to it
	@Test
	void testToString3() {
		SimpleList list3 = new SimpleList();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(6);
		list3.add(7);
		list3.add(8);
		list3.add(9);
		list3.add(10);
		list3.add(11);
		list3.add(12);
		String expectedOutput = "12 11 10 9 8 7 6 5 4 3 2 1";
		String actualOutput = list3.toString();
		assertEquals(expectedOutput, actualOutput);
	}

	// test case when list is empty
	@Test
	void testSearch1() {
		int expectedOutput;
		int actualOutput;

		SimpleList list1 = new SimpleList();
		expectedOutput = -1;
		actualOutput = list1.search(420);
		assertEquals(expectedOutput, actualOutput);
	}
	
	// test case when the parameter is not contained within non-empty list
	@Test
	void testSearch2() {
		SimpleList list2 = new SimpleList();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		int expectedOutput = -1;
		int actualOutput = list2.search(420);
		assertEquals(expectedOutput, actualOutput);
	}
	
	// test case when the list contains the parameter
	@Test
	void testSearch3() {
		SimpleList list3 = new SimpleList();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		int expectedOutput = 1;
		int actualOutput = list3.search(2);
		assertEquals(expectedOutput, actualOutput);
	}
	
	// test case when the list contains more than 1 of the given parameter
	@Test
	void testSearch4() {
		SimpleList list4 = new SimpleList();
		list4.add(3);
		list4.add(4);
		list4.add(3);
		list4.add(2);
		list4.add(1);
		int expectedOutput = 2;
		int actualOutput = list4.search(3);
		assertEquals(expectedOutput, actualOutput);
	}

}
