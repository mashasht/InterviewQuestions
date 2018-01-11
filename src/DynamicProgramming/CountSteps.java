package DynamicProgramming;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.google.common.collect.Lists;

public class CountSteps {
	public static int countStepCombinations(int n) {
		Set<List<Integer>> previousCombinations = new HashSet<>();
		Set<List<Integer>> currentCombinations = new HashSet<>();
		previousCombinations.add(Lists.newArrayList(1));
		previousCombinations.add(Lists.newArrayList(2));
		previousCombinations.add(Lists.newArrayList(3));
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return previousCombinations.size();
		}
		for (int i = 1; i < n; i++) {
				for (List<Integer> combination: previousCombinations) {
					for (int j = 1; j <= 3; j++) {
						combination.add(j);
						currentCombinations.add(combination);
					}
					
				}
				previousCombinations =  currentCombinations;
			}
		return currentCombinations.size();
	}
	public static void main(String[] args) {
		System.out.println(countStepCombinations(2));
	}
	
}
