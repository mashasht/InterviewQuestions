package Exercises1;

public class ReverseArray {
	public void reverse(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}
}
