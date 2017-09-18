package Sorting;

public class InsertionSort implements SortInterface{
	@Override
	public void sort(int[] data) {
		if (data == null || data.length < 2)
			return;
		for (int i = 1; i < data.length; i++) {
			int current = data[i];
			int j = 0;
			while(j < i && data[j] < current) {
				j++;
			}
			for(int k = j; k < i; k++) {
				data[k+1] = data[k];
			}
			data[j] = current;
		}
	}
}
