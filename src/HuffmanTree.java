import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import material.Position;
import material.tree.binarytree.BinaryTree;
import material.tree.binarytree.LinkedBinaryTree;

/**
 *
 * @author jvelez
 */
public class HuffmanTree {
    
    /**
     * Creates the Huffman tree.
     * @param text 
     */
    public HuffmanTree(String text) {
        Map<Character, Integer> frec = new HashMap<>();

        for (Character c : text.toCharArray()){
            if (frec.containsKey(c)){
                int n = frec.get(c);
                frec.put(c, n + 1);
            }else{
                frec.put(c, 1);
            }
        }

        PriorityQueue<LinkedBinaryTree<Nodo>> queue = new PriorityQueue<>();

    }
    
    /**
     * Encodes a text into a binary array using a Huffman tree.
     * @param text
     * @return 
     */
    byte [] encoding(String text) {
       throw new RuntimeException("Not implemented yet");
    }
    
    /**
     * Decodes a binary array into a text using a Huffman tree.
     * @param code
     * @return 
     */
    String decoding(byte [] code) {
        throw new RuntimeException("Not implemented yet");
    }


    private class Nodo implements Comparator<Nodo>{
        private int f; // Frecuencia

        public Nodo(int f){
            this.f = f;
        }

        @Override
        public int compare(Nodo o1, Nodo o2) {
            return o1.f - o2.f;
        }
    }

    private class Hoja extends Nodo{
        private int c;  // caracter

        public Hoja(int f, Character c){
            super(f);
            this.c = c;
        }
    }
}
