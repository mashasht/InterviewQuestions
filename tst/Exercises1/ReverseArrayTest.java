package Exercises1;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ReverseArrayTest {
	public ReverseArray classUnerTest = new ReverseArray();
	fsgjsdgkjhsjgh
	@Test
	public void reverseNull() {
		int[] arr = null;
		classUnerTest.reverse(arr);
	}
	@Test
	public void reverseEmptyArray() {
		int[] arr = new int[0];
		classUnerTest.reverse(arr);
	}
	@Test
	public void reverseArrayOfTwo() {
		int[] arr = {2, 3};
		int[] res = {3, 2};
		classUnerTest.reverse(arr);
		assertArrayEquals(arr, res);
	}
	@Test
	public void reverseArrayOfThree() {
		int[] arr = {2, 3, 10};
		int[] res = {10, 3, 2};
		classUnerTest.reverse(arr);
		assertArrayEquals(arr, res);
	}
}
