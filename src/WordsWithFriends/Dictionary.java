package WordsWithFriends;

import java.util.Set;

import com.google.common.collect.Sets;

public class Dictionary {
	private Set<String> dictionary = Sets.newHashSet("apple", "maple", "eye", "omr");
	public boolean isWord(String word) {
		return dictionary.contains(word);
	}
	public boolean isPrefix(String word) {
		return dictionary.stream().anyMatch(w -> w.startsWith(word));
	}
}
