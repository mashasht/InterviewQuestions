package SimpleDataStructures;

/**
 * Created by mashashtutman on 2019-05-05.
 */
public class UniqueLetters {
    private static boolean hasLetter(int counter, int letter){
        System.out.println("Pow " + Math.pow(2, (Character.toLowerCase(letter) - 'a')));
        System.out.println("Has " + counter % (int) Math.pow(2, (Character.toLowerCase(letter) - 'a' + 1)) / (int) Math.pow(2, (Character.toLowerCase(letter) - 'a')));
        return (counter % (int) Math.pow(2, (Character.toLowerCase(letter) - 'a' + 1))) / (int) Math.pow(2, (Character.toLowerCase(letter) - 'a')) == 1;
    }
    private static int increaseCounter(int counter, int letter){
        counter += Math.pow(2, Character.toLowerCase(letter) - 'a');
        return counter;
    }
    public static boolean hasUniqueCharacters(String str){
        int counter = 0;
      for (char c: str.toCharArray()){
          if (hasLetter(counter, c)){
              return false;
          }
          counter = increaseCounter(counter, c);
      }
      return true;
    }
    public static void main(String[] args){
        String alphabet = "abcdefghijkcclmnopqrstuvwxyz";
        System.out.println(hasUniqueCharacters(alphabet));
    }
}
