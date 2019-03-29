package ub.huffman;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList a;
        Scanner sc = new Scanner(System.in);
        if(args.length != 0)  a = Utils.parseAlphabet(new File(args[0]));
        else{
            System.out.println("Enter symbols file: ");
            a = Utils.parseAlphabet(new File(sc.nextLine()));
        }
        HuffmanTree t = new HuffmanTree(a);

        System.out.println("Symbol Code Probability");
        for(int i = 0; i < t.getTable().length; i++){
            System.out.println(t.getTable()[i][0]+"      "+t.getTable()[i][1]+"      "+t.getTable()[i][2]);
        }

        //String text = "KDQKKD9D10JDDQKDJQ1010JKDJQDJDJJQQDQKQKJK10QKQKDQQDDKDK910JKDDQQ10KKDQQDJDKJQ10DKK10DJDDKDKDQ10JDQD109DJ99JQDD"; //Demo.txt
        //String text = "DD9Q9DDD910KD10KQDDQQD10DDD10DJKDDKDDDKDDDDJDKDDKQDDDKDKKDDJ9DDDDDQKDDDQKDQDDDDDDQJKKKDKDKD10JQDDDDK9DDKK"; //Demo2.txt


        System.out.println("Enter message size:");
        int len = sc.nextInt();
        String text = Utils.randomMessage(t.table,len);
        System.out.println("\nText: "+text);
        String encoded = t.encode(text);
        System.out.println("Encoded Text: "+encoded);

        String decoded = t.decode(encoded);
        System.out.println("Decoded Text: "+decoded+"\n");

        assert text.equals(decoded);

        System.out.println("Average used bits: " + t.averageBits()+ " bits");
        System.out.println("Enthropy (Theoric minimum): " + t.enthropy()+ " bits");
        System.out.println("Needed bits without compression: "+ t.getNumBits());
        System.out.println("Compression Ratio: " + t.compressionRatio());
    }
}
