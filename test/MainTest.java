import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MainTest {

    @Test

    void gameTest() {

        Set<Integer> randomSet = Main.gen(9);
        Set<Integer> userSet = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertEquals(randomSet.size(), userSet.size());
        Set<Integer> s = new HashSet<Integer>();
        int count=0;
        for(Integer value: randomSet)
        {
            if(userSet.contains(value)) {
                s.add(value);
                count++;
            }
        }
        assertEquals(s.size()<=userSet.size(), true);
        assertEquals(count, s.size());
        assertEquals(count, Main.match(randomSet,userSet));
        int res = count*count*count*1000;
        assertEquals(res, Main.win(count));

        s.clear();

        randomSet = Main.gen(20);
        userSet = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        assertEquals(randomSet.size(), userSet.size());
        count=0;
        for(Integer value: randomSet)
        {
            if(userSet.contains(value)) {
                s.add(value);
                count++;
            }
        }
        assertNotEquals(s.size()<=userSet.size(), false);
        assertEquals(count, Main.match(randomSet,userSet));
        res = count*count*count*1000;
        assertEquals(res, Main.win(count));

        s.clear();

        randomSet = Main.gen(4);
        userSet = new HashSet<Integer>(Arrays.asList(1, 2, 3, 3));
        assertNotEquals(randomSet.size(), userSet.size());
        count=0;
        for(Integer value: randomSet)
        {
            if(userSet.contains(value)) {
                s.add(value);
                count++;
            }
        }
        assertEquals(s.size()<=userSet.size(), true);
        assertEquals(count, Main.match(randomSet,userSet));
        res = count*count*count*1000;
        assertEquals(res, Main.win(count));

        s.clear();
    }
}

