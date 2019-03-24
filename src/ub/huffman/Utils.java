package ub.huffman;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Utils {

    /**
     * File format: <symbol>,<probability>
     *     Example: D,30
     *              A,20
     *              .
     *              .
     *              .
     * @param a
     * @return
     */
    public static ArrayList<Node> parseAlphabet(File a){
        ArrayList<Node> alphabet = new ArrayList();
        try {
            List<String> lines = Files.readAllLines(a.toPath());
            for(String line : lines){
                line = line.replaceAll(" ","");
                String [] key_value = line.split(",");

                alphabet.add(new Node(key_value[0],Float.parseFloat(key_value[1])/100, null));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(alphabet);

        return alphabet;
    }


    public static double log(double num, int base){
        return (Math.log(num)/Math.log(base));
    }


    public static String randomMessage(String [][] symbols, int len){
        if (len % symbols.length != 0){
            System.err.println("Len must be multiple of 100 to match probabilities");
            return null;
        }
        ArrayList<String> totalSymbols = new ArrayList<>();
        for(int i = 0; i < symbols.length; i++){
            for(int j = 0; j < (int)((Float.parseFloat(symbols[i][2]))*len); j++){
                totalSymbols.add(symbols[i][0]);
            }
        }

        String text = "";
        while(!totalSymbols.isEmpty()){
            int s = (int)Math.round(Math.random()*(totalSymbols.size()-1));
            text = text + totalSymbols.get(s);
            totalSymbols.remove(s);
        }

        return text;
    }


}
