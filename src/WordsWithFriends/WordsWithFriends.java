package WordsWithFriends;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WordsWithFriends {
	class WordPrefix{
		Coordinate coordinate;
		String prefix;
		WordPrefix(char firstLetter, int first, int second){
			this(String.valueOf(firstLetter), first, second);
		}
		WordPrefix(String prefix, int first, int second){
			this.prefix = prefix;
			coordinate = new Coordinate(first, second);
		}
	}
	class Coordinate{
		Integer first;
		Integer second;
		Coordinate(int first, int second){
			this.first = first;
			this.second = second;
		}
	}
	public Set<String> findWords(char[][] letters, Dictionary dict){	
		Set<String> words = new HashSet<>();
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < letters[i].length; j++) {	
				words.addAll(findWordsFromLetter(letters, dict, i, j));
			}
		}
		return words;
		
	}
	private Set<String> findWordsFromLetter(char[][] letters, Dictionary dict, int i, int j){
		Set<String> words = new HashSet<>();
		Stack<WordPrefix> stackPrefices = new Stack<>();
		boolean[][] visited = new boolean[letters.length][letters[0].length];
		if (!dict.isPrefix(String.valueOf(letters[i][j]))) {
			return words;
		}
		stackPrefices.push(new WordPrefix(letters[i][j], i, j));
		while(!stackPrefices.isEmpty()) {
			WordPrefix current = stackPrefices.peek();
			visited[current.coordinate.first][current.coordinate.second] = true;	
			Set<Coordinate> unvisitedCoordinates = getUnvisited(current.coordinate.first, current.coordinate.second, visited);
			if (unvisitedCoordinates.isEmpty()) {
				stackPrefices.pop();
				continue;
			}
			stackPrefices.pop();
			for (Coordinate unvisitedCoordinate : unvisitedCoordinates) {
				String newWord = current.prefix + letters[unvisitedCoordinate.first][unvisitedCoordinate.second];
				if (dict.isWord(newWord)) {
					words.add(newWord);
				}
				if (dict.isPrefix(newWord)) {
					stackPrefices.push(new WordPrefix(newWord, unvisitedCoordinate.first, unvisitedCoordinate.second));
				}
			}
		}
		return words;
	}
	private Set<Coordinate> getUnvisited(int i, int j, boolean[][] visited) {
		Set<Coordinate> unvisited = new HashSet<>();
		if (i + 1 < visited.length) {
			if (!visited[i + 1][j]) {
				unvisited.add(new Coordinate(i + 1, j));
			}
			if (j + 1 < visited[i].length && !visited[i + 1][j + 1]) {
				unvisited.add(new Coordinate(i + 1, j + 1));
			}
			if (j - 1 >= 0 && !visited[i + 1][j - 1]) {
				unvisited.add(new Coordinate(i + 1, j - 1));
			}
			
		}
		if (i - 1 >= 0) {
			if (!visited[i - 1][j]) {
				unvisited.add(new Coordinate(i - 1, j));
			}
			if (j + 1 < visited[i - 1].length && !visited[i - 1][j + 1]) {
				unvisited.add(new Coordinate(i - 1, j + 1));
			}
			if (j - 1 >= 0 && !visited[i - 1][j - 1]) {
				unvisited.add(new Coordinate(i - 1, j - 1));
			}
		}
		if (j - 1 >= 0 && !visited[i][j - 1]) {
			unvisited.add(new Coordinate(i, j - 1));
		}
		if (j + 1 < visited[i].length && !visited[i][j + 1]) {
			unvisited.add(new Coordinate(i, j + 1));
		}
		return unvisited;
	}
	public static void main(String[] args) {
		char[][] letters = new char[4][5];
		letters[0][0] = 'm';
		letters[0][1] = 'r';
		letters[0][2] = 'p';
		letters[0][3] = 'q';
		letters[0][4] = 'f';
		letters[1][0] = 'o';
		letters[1][1] = 'a';
		letters[1][2] = 'k';
		letters[1][3] = 'e';
		letters[1][4] = 'w';
		letters[2][0] = 'd';
		letters[2][1] = 'p';
		letters[2][2] = 'p';
		letters[2][3] = 'l';
		letters[2][4] = 'e';
		letters[3][0] = 'k';
		letters[3][1] = 'l';
		letters[3][2] = 'e';
		letters[3][3] = 'y';
		letters[3][4] = 'd';
		Dictionary dict = new Dictionary();		
		Set<String> words = new WordsWithFriends().findWords(letters, dict);
		System.out.println(words);
	}
}
