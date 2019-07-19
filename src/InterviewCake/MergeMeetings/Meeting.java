package InterviewCake.MergeMeetings;

/**
 * Created by mashashtutman on 2019-05-28.
 */
public class Meeting{
    long start;
    long end;
    long getStart(){
        return start;
    }
    Meeting(long start, long end) {
        this.start = start;
        this.end = end;
    }
    public String toString(){
        return this.start + " " + this.end;
    }
}