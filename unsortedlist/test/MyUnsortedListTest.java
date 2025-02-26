import static org.junit.Assert.*;
import org.junit.Test;

import datastruct.*;

public class MyUnsortedListTest {
	/* 
	 * 1.  Test empty and size methods
	 * 
	 */
	
	@Test
	public void testIsEmptyOnEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue("Test isEmpty method on empty list", list.isEmpty());
		assertEquals("Test size method on empty list", 0, list.size());
	}
	
	@Test
	public void testIsEmptyOnNonEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of(1);
		assertFalse("Is empty test on non-empty list", list.isEmpty());
		assertEquals("List size of 1 element should be 1", 1, list.size());
	}
	
	@Test
	public void testAppendOneElement() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.append(5);
		assertFalse("Is empty test after add 1 elt on empty list", l.isEmpty());
		assertEquals("List size after add 1 elt on empty list", 1, l.size());
	}
	
	@Test
	public void testAppendTwoElement() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.append(5);
		l.append(4);
		assertFalse("Is empty test after add 2 elements", l.isEmpty());
		assertEquals("List size after add 2 elts", 2, l.size());
	}
	
	/*
	 * 2.  Test of prepend and pop methods
	 * 
	 */
	
	@Test
	public void testPrependOnEmptyList() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.prepend(2);
		assertEquals("Size after one prepend on empty list", 1, l.size());
	}
	
	
	@Test(expected = EmptyListException.class)
	public void testPopElementInEmptyList() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.pop();
	}
	
	@Test
	public void testPopOnSize1List() {
		UnsortedList<Integer> l = MyUnsortedList.of(10);
		Integer a = l.pop();
		assertEquals("Retrieved element should be the previous single element in the list", 10, a.intValue());
		assertEquals("New size of list of size 1 after one pop", 0, l.size());
	}
	
    @Test
    public void testTwoPrependAndTwoPop() {
    	UnsortedList<Integer> l = MyUnsortedList.of();
    	l.prepend(5);
    	l.prepend(10);
    	Integer a = l.pop();
    	Integer b = l.pop();
    	assertEquals("First pop value should be the latest prepend value", 10, a.intValue());
    	assertEquals("Second pop elt should be the first preprend element", 5, b.intValue());
    	assertTrue("List is empty after two prepend and two pop", l.isEmpty());
    }
	
	
	/* 
	 * 3.  Test append and pop methods
	 * 
	 */
    
	@Test
	public void testAppendOnEmptyList() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.append(2);
		assertEquals("Size after one append on empty list", 1, l.size());
	}
    
    @Test
    public void testTwoAppendAndTwoPop() {
    	UnsortedList<Integer> l = MyUnsortedList.of();
    	l.append(45);
    	l.append(58);
    	
    	int a = l.pop();
    	assertEquals("First pop value should be the first append value", 45, a);
    	assertEquals("Check that size is decremented after a call to pop", 1, l.size());
    	
    	int b = l.pop();
    	assertEquals("Poplast second elt", 58, b);
    	assertTrue("List is empty after two append and two pop", l.isEmpty());
    }
    
    
    /*
     * 4.  Test of popLast method
     *  
     */
    
	@Test(expected = EmptyListException.class)
	public void testPopLastElementInEmptyList() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.popLast();
	}
	
    @Test
    public void testTwoPrependAndTwoPopLast() {
    	UnsortedList<Integer> l = MyUnsortedList.of();
    	l.prepend(5);
    	l.prepend(10);
    	Integer a = l.popLast();
    	Integer b = l.popLast();
    	assertEquals("First popLast value should be the first prepend value", 5, a.intValue());
    	assertEquals("Second popLast elt should be the lastest preprend element", 10, b.intValue());
    	assertTrue("List is empty after two prepend and two popLast", l.isEmpty());
    }
    
    
    @Test
    public void testTwoAppendAndTwoPopLast() {
    	UnsortedList<Integer> l = MyUnsortedList.of();
    	l.append(1005);
    	l.append(10);
    	Integer a = l.popLast();
    	Integer b = l.popLast();
    	assertEquals("First popLast value should be the second append value", 10, a.intValue());
    	assertEquals("Second popLast elt should be the first apprend element", 1005, b.intValue());
    	assertTrue("List is empty after two append and two popLast", l.isEmpty());
    }
    
    
    /*
     * 5.  Test of insert method
     *  
     */
    
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertAfterListSizePosition() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.insert(10, l.size()+1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertBeforeFirstElement() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.insert(0, -1);
	}
	
	@Test
	public void testInsertEltInEmptyList() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.insert(-2, 0);
		assertEquals("list size after insert one elt", 1, l.size());
		assertFalse("Is empty test after insert one elt", l.isEmpty());
	}
	
	@Test
	public void testTwoInsertHeadInEmptyList() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.insert(-2, 0);
		l.insert(-7, 0);
		int a = l.pop();
		int b = l.pop();
		assertEquals("First pop value", -7, a);
		assertEquals("Second pop value", -2, b);
	}
	
	@Test
	public void testTwoInsertPosition1InSize2List() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.insert(-2, 0);
		l.insert(10, 1);
		l.insert(-7, 2);
		l.insert(9, 1);
		
		int a = l.pop();
		assertEquals("First pop value", -2, a);
		a = l.pop();
		assertEquals("Second pop value", 9, a);
		a = l.pop();
		assertEquals("Third pop value", 10, a);
		a = l.pop();
		assertEquals("Third pop value", -7, a);
	}
    
	
    /*
     * 6. Test of remove method 
     * 
     */
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveAfterLastElement() {
		UnsortedList<Integer> l = MyUnsortedList.of(5, 6, 7);
		l.remove(l.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveBeforeFirstElement() {
		UnsortedList<Integer> l = MyUnsortedList.of(5, 6, 7);
		l.remove(-1);
	}
	
	/* Helper */
    private void removeHelper(int index) {
    	UnsortedList<Integer> l = MyUnsortedList.of(1,2,3);
    	l.remove(index);
    	int actual = l.pop();
    	int expected = (index == 0 ? 2 : 1);
    	assertEquals("List [1,2,3] after remove(" + index + "): fst pop", expected, actual);
    	actual = l.pop();
    	expected = (index == 2 ? 2 : 3);
    	assertEquals("List [1,2,3] after remove(" + index + "): snd pop", expected, actual);
    }
	
    @Test
    public void testRemoveFirstElement() {
    	removeHelper(0);
    }
    
    @Test
    public void testRemoveAndPop() {
    	removeHelper(1);
    }
    
    @Test
    public void testRemoveLastElement() {
    	removeHelper(2);
    }
    
    @Test(expected = EmptyListException.class)
    public void testOneRemoveAndThreePopOnSize3List() {
    	UnsortedList<Integer> l = MyUnsortedList.of(1,2,3);
    	l.remove(l.size() - 1);
    	l.pop();
    	l.pop();
    	l.pop();
    }
	
    
    /* 
     * 7.  Test of toString method
     * 
     */
	
    @Test
    public void testToStringOnEmptyList() {
    	UnsortedList<Integer> l = MyUnsortedList.of();
    	String exp = "MyUnsortedList { size = 0, [] }";
    	assertEquals("Test empty list to string", exp, l.toString());
    }
    
    @Test
    public void testToStringOnIntegerList() {
    	UnsortedList<Integer> l = MyUnsortedList.of(7, 4, 6);
    	String exp = "MyUnsortedList { size = 3, [7, 4, 6] }";
    	assertEquals("Test [7,4,6] to string", exp, l.toString());
    }
	
    @Test
    public void testToStringOnStringList() {
    	UnsortedList<String> l = MyUnsortedList.of("to", "ti");
    	String exp = "MyUnsortedList { size = 2, [to, ti] }";
    	assertEquals("Test [\"to\",\"ti\"] to string", exp, l.toString());
    }
    
    
    /* 
     * 8. test of equals method
     * 
     */
    
	@Test
    public void testEqualsOnEmptyListsOfInteger() {
    	UnsortedList<Integer> l1 = MyUnsortedList.of();
    	UnsortedList<Integer> l2 = MyUnsortedList.of();
    	assertEquals("Test of the equality on two empty lists of integers", l1, l2);
    }
    
    @Test
    public void testEqualsOnEmptyListsOfDifferentType() {
    	UnsortedList<Integer> l1 = MyUnsortedList.of();
    	UnsortedList<String> l2 = MyUnsortedList.of();
    	assertEquals("Test of equality on two empty lists of integers and strings respectively", l1, l2);
    }
    
    @Test
    public void testEqualsOnListsOfDifferentTypes() {
    	UnsortedList<Integer> l1 = MyUnsortedList.of(1, 2, 5);
    	UnsortedList<String> l2 = MyUnsortedList.of("ti", "to", "ta");
    	assertNotEquals("Test of equality on two non-empty lists of integers and strings respectively", l1, l2);
    }
    
    @Test
    public void testEqualsEmptyAndNoEmptyLists() {
    	UnsortedList<Integer> l1 = MyUnsortedList.of();
    	UnsortedList<Integer> l2 = MyUnsortedList.of(1, 2, 5);
    	assertNotEquals("Test of the equality of two different lists of integers", l1, l2);
    }
    
    @Test
    public void testEqualsOnSameObject() {
    	UnsortedList<Integer> l = MyUnsortedList.of(1, 2, 5);
    	assertEquals("Test of equality on the same list object", l, l);
    }
    
    @Test
    public void testEqualsOnSameList() {
    	UnsortedList<Integer> l1 = MyUnsortedList.of(1, 2, 5);
    	UnsortedList<Integer> l2 = MyUnsortedList.of(1, 2, 5);
    	assertEquals("Test of equality of two same lists", l1, l2);
    }
    
    @Test
    public void testEqualsDifferentListOfSameSize() {
    	UnsortedList<Integer> l1 = MyUnsortedList.of(1, 2, 5);
    	UnsortedList<Integer> l2 = MyUnsortedList.of(1, 2, 3);
    	assertNotEquals("Test of equality on lists of integers of same length", l1, l2);
    }
    
    @Test
    public void testEqualsDifferentListOfDifferentSize() {
    	UnsortedList<Integer> l1 = MyUnsortedList.of(1, 2, 5);
    	UnsortedList<Integer> l2 = MyUnsortedList.of(1, 2);
    	assertNotEquals("Test of equality on lists of diffent types (string and integer)", l1, l2);
    }
    
    @Test
    public void testEqualsListAndInteger() {
    	UnsortedList<Integer> l1 = MyUnsortedList.of(1, 2, 5);
    	assertNotEquals("Compararaison between a list and an integer", l1, 125);
    }
    
    @Test
    public void testEqualsCommutativity() {
    	UnsortedList<Integer> l1 = MyUnsortedList.of(1, 2, 4);
    	UnsortedList<Integer> l2 = MyUnsortedList.of(1, 2, 4);
    	UnsortedList<Integer> l3 = MyUnsortedList.of(1, 2, 7);
    	
    	assertTrue("Test the commutativity of equals on two identical lists", l1.equals(l2) == l2.equals(l1));
    	assertTrue("Test the commutativity of equals on two different lists", l1.equals(l3) == l3.equals(l1));
    }
}
