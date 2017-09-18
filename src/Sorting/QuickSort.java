package Sorting;

public class QuickSort implements SortInterface{
	private static void quickSort(int[] numbers, int low, int high){
		if (numbers == null || low >= high) {
			return;
		}
		int pivot = numbers[high];
		int j = low; 
		int i = low - 1;
		for (; j < high; j++) {
			if (numbers[j] <= pivot) {
				i++;
				swap(numbers, i, j);
			}
		}
		swap(numbers, i + 1, high);
		quickSort(numbers, low, i);
		quickSort(numbers, i + 2, high);
	}
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	@Override
	public void sort(int[] numbers) {
		quickSort(numbers, 0, numbers.length - 1);
	}
}
