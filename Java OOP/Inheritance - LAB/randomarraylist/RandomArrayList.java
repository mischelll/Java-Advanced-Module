package javaooplabs.randomarraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    public T getRandomElement(){
        Random random = new Random();

        return super.remove(random.nextInt(getSize()));
    }

    private int getSize(){
        return super.size();
    }

}
