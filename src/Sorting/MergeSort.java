package Sorting;

public class MergeSort implements SortInterface{
	
	public void mergeSort(int[] numbers, int low, int high) {
		if (numbers == null || low >= high) {
			return;
		}
		int middle = low + (high - low) / 2;
		mergeSort(numbers, low, middle);
		mergeSort(numbers, middle + 1, high);
		merge(numbers, low, middle + 1, high);
	}
	public void merge(int[] numbers, int low, int middle, int high) {
		int[] helperArr = new int[high - low + 1];
		int j = low;
		int k = middle;
		for (int i = 0; i < helperArr.length; i++) {
			if (k > high || j < middle && numbers[j] < numbers[k]) {
				helperArr[i] = numbers[j++];
			}
			else {
				if (j >= middle || k <= high && numbers[j] >= numbers[k]) {
					helperArr[i] = numbers[k++];
				}
			}
		}
		for (int i = 0; i < helperArr.length; i++) {
			numbers[low + i] = helperArr[i];
		}
	}
	@Override
	public void sort(int[] numbers) {
		mergeSort(numbers, 0, numbers.length - 1);
	}
}
