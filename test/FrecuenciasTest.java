import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class FrecuenciasTest {
    Frecuencias frec;

    public FrecuenciasTest(){
        frec = new Frecuencias();
    }

    @Test
    public void kMaximunFrecuenciesTest() {
        System.out.println("test kMaximunFrecuencies");
        Integer array1 [] = {7, 3, 5, 12, 4, 7, 2, 1, 3, 9};
        List<Integer> list1 = Arrays.asList(array1);
        List<Integer> return1 = frec.kMaximunFrecuencies(list1, 2);
        Set<Integer> mySet1 = new HashSet<>(return1);
        assertEquals(mySet1, Set.of(new Integer[]{7, 3}));

        Integer array2 [] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9, 10, 11, 7};
        List<Integer> list2 = Arrays.asList(array2);
        List<Integer> return2 = frec.kMaximunFrecuencies(list2, 4);
        Set<Integer> mySet2 = new HashSet<>(return2);
        assertEquals(mySet2, Set.of(new Integer[]{5, 11, 7, 10}));
    }
}