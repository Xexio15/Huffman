package ub.huffman;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList a = Utils.parseAlphabet(new File(args[0]));
        HuffmanTree t = new HuffmanTree(a);

        System.out.println("Symbol Code");
        for(int i = 0; i < t.getTable().length; i++){
            System.out.println(t.getTable()[i][0]+" "+t.getTable()[i][1]);
        }

        String text = "KDQKKD9D10JDDQKDJQ1010JKDJQDJDJJQQDQKQKJK10QKQKDQQDDKDK910JKDDQQ10KKDQQDJDKJQ10DKK10DJDDKDKDQ10JDQD109DJ99JQDD"; //Demo.txt
        //String text = "DD9Q9DDD910KD10KQDDQQD10DDD10DJKDDKDDDKDDDDJDKDDKQDDDKDKKDDJ9DDDDDQKDDDQKDQDDDDDDQJKKKDKDKD10JQDDDDK9DDKK"; //Demo2.txt
        System.out.println("Text: "+text);
        String coded = t.encode(text);
        System.out.println("Coded Text: "+coded);

        String decoded = t.decode(coded);
        System.out.println("Decoded Text: "+decoded);

        assert text.equals(decoded);

        System.out.println("Average used bits: " + t.averageBits()+ " bits");
        System.out.println("Enthropy (Theoric minimum): " + t.enthropy()+ " bits");
        System.out.println("Compression Ratio: " + t.compressionRatio());
    }
}
