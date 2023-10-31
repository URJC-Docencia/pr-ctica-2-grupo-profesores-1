
import java.util.HashMap;
import java.util.List;
import java.util.*;


/**
 *
 * @author mayte
 */
public class Frecuencias {

    /**
     *
     * @param l
     * @param k
     * @return
     */
    public List<Integer> kMaximunFrecuencies(List<Integer> l, int k){
        Map<Integer, Integer> frec = new HashMap<>();

        for (Integer dato : l){
            if (frec.containsKey(dato)){
                int n = frec.get(dato);
                frec.put(dato, n + 1);
            }else{
                frec.put(dato, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet =  frec.entrySet();
        List entryList = Arrays.asList(entrySet.toArray());
        Collections.sort(entryList,  new SortbyOcurrences());

        List<Integer> returnList = new LinkedList<>();

        for(int i=0; i<k; i++){
            Map.Entry<Integer, Integer> auxEntry = (Map.Entry<Integer, Integer>) entryList.get(i);
            returnList.add(0, auxEntry.getKey());
        }

        return returnList;
    }

    private class SortbyOcurrences implements Comparator<Map.Entry<Integer, Integer>>
    {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    }
}
