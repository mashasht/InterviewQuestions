package Exercises1;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ReverseArrayTest {
	public ReverseArray classUnderTest = new ReverseArray();
	
	@Test
	public void reverseNull() {
		int[] arr = null;
		classUnderTest.reverse(arr);
	}
	
	@Test
	public void reverseEmptyArray() {
		int[] arr = new int[0];
		classUnderTest.reverse(arr);
	}
	
	@Test
	public void reverseArrayOfTwo() {
		int[] arr = {2, 3};
		int[] res = {3, 2};
		classUnderTest.reverse(arr);
		assertArrayEquals(arr, res);
	}
	
	@Test
	public void reverseArrayOfThree() {
		int[] arr = {2, 3, 10};
		int[] res = {10, 3, 2};
		classUnderTest.reverse(arr);
		assertArrayEquals(arr, res);
	}
}
