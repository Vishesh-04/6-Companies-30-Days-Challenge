/**    2526. Find Consecutive Integers from a Data Stream

For a stream of integers, implement a data structure that checks if the last k integers parsed in the stream are equal to value.

Implement the DataStream class:

DataStream(int value, int k) Initializes the object with an empty integer stream and the two integers value and k.
boolean consec(int num) Adds num to the stream of integers. Returns true if the last k integers are equal to value, and false otherwise. If there are less than k integers, the condition does not hold true, so returns false.**/

import java.util.*;
class DataStream {
    int value;
    int k;
    Queue<Integer> q = new LinkedList<>();
    public DataStream(int value, int k) {
        this.k = k;
        this.value = value;
    }
    
    public  boolean consec(int num) {
        if(num==value)
            q.add(num);
        else
            q=new LinkedList<>();
        return q.size()>=k;
    }
}
