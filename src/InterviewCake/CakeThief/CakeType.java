package InterviewCake.CakeThief;

/**
 * Created by mashashtutman on 2019-05-28.
 */
public class CakeType {

    final int weight;
    final int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value  = value;
    }

    public String toString(){
        return this.weight + " " + this.value;
    }
}