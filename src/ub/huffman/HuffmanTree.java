package ub.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class HuffmanTree {
    Node root;
    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<String> alphabet = new ArrayList<>();
    String[][] table;

    public HuffmanTree(ArrayList<Node> a) {
        //Guardem l'alfabet inicial
        for(Node n : a ){
            alphabet.add(n.key);
        }

        table = new String[alphabet.size()][3];

        //Generem l'arbre
        boolean last = false;
        while (a.size() != 0 && !last){
            if(a.size() == 1) last = true;
            a = combineLastTwo(a);
        }
        nodes.remove(0);
        root = nodes.get(0);
        root.parent = null;

        //Generem la taula de codis
        for(int i = 0; i < alphabet.size(); i++){
            String code = generateCode(alphabet.get(i));
            table[i][0] = alphabet.get(i);
            table[i][1] = code;
            table[i][2] = searchNode(root,alphabet.get(i)).value+"";
        }
    }

    private Node searchNode(Node node, String key){

        if(node != null){
            //Si trobem el node retornem de la recursivitat
            if(node.key.equals(key)){
                return node;
            } else {
                //Busquem per l'esquerra
                Node foundNode = searchNode(node.left, key);

                //Si no el trobem busquem per la dreta
                if(foundNode == null) {
                    foundNode = searchNode(node.right, key);
                }

                //Retornem el node
                return foundNode;
            }
        } else {
            return null;
        }
    }

    private String generateCode(String key){
        //Busquem el node que volem el codi
        Node n = searchNode(root, key);
        String code = "";

        //Recorrem els pares formant el codi
        while (n.parent != null){
            code = code + n.bit;
            n = n.parent;
        }

        //Retornem el codi invertit ja que l'hem creat d'abaix cap a d'alt
        return new StringBuilder(code).reverse().toString();
    }

    @Override
    public String toString() {
        String out = "";
        for (Node n : nodes){
            out = out + n.key+":"+n.value+" is child of: "+n.parent.key+"\n";
        }
        return out;
    }

    private ArrayList<Node> combineLastTwo(ArrayList<Node> a){
        int i = 0;
        float new_probability = 0;
        String new_letter = "";
        Node izquierdo = null;
        Node derecho = null;

        Iterator it = a.iterator();

        //Per als dos primers nodes de la llista ordenada de menys probabilitat a menys
        while (it.hasNext() && i < 2){
            Node node = (Node) it.next();

            //Calculem la nova probabilitat i la nova clau
            new_probability = new_probability + node.value;
            new_letter = new_letter + node.key;

            //Si es el primer sera el mes petati per tant sera l'esquerra
            if (i ==0){
                izquierdo = node;
            }

            //Sino sera el dret
            else {
                derecho = node;
            }
            i++;
            //Eliminem els nodes de la llista
            it.remove();
        }

        //Creem el nou node
        Node nuevo = new Node(new_letter,new_probability,null);

        //Actualitzem els punters dels nodes i afegim el seu bit
        if(izquierdo != null){
            nuevo.left = izquierdo;
            izquierdo.parent = nuevo;
            izquierdo.bit = 0;
        }
        if(derecho != null){
            nuevo.right = derecho;
            derecho.parent = nuevo;
            derecho.bit = 1;
        }

        //Afegim els nodes a la llista(arbre)
        nodes.add(0,izquierdo);
        nodes.add(0,derecho);

        //Afegim el nou node creat per a la propera iteracio
        a.add(nuevo);

        //Reoordenem la llista
        Collections.sort(a);

        return a;
    }

    public String[][] getTable(){
        return table;
    }


    public String getCode(String key){
        //Recorrem la taula fins trobar el simbol i retornem el codi
        for(int i = 0; i < table.length; i++){
            if (table[i][0].equals(key)){
                return table[i][1];
            }
        }
        return null;
    }

    public String getCode(char[] key_char){
        //Recorrem la taula fins trobar el simbol i retornem el codi
        String key = new String(key_char);
        for(int i = 0; i < table.length; i++){
            if (table[i][0].equals(key)){
                return table[i][1];
            }
        }
        return null;
    }

    public String getCode(char key_char){
        //Recorrem la taula fins trobar el simbol i retornem el codi
        String key = "" + key_char;
        for(int i = 0; i < table.length; i++){
            if (table[i][0].equals(key)){
                return table[i][1];
            }
        }
        return null;
    }

    public String getSymbol(String code){
        //Recorrem la taula fins trobar el codi i retornem el simbol
        for(int i = 0; i < table.length; i++){
            if (table[i][1].equals(code)){
                return table[i][0];
            }
        }
        return null;
    }

    public String getSymbol(char[] code_char){
        //Recorrem la taula fins trobar el codi i retornem el simbol
        String code = new String(code_char);
        for(int i = 0; i < table.length; i++){
            if (table[i][1].equals(code)){
                return table[i][0];
            }
        }
        return null;
    }

    public String getSymbol(char code_char){
        //Recorrem la taula fins trobar el codi i retornem el simbol
        String code = "" + code_char;
        for(int i = 0; i < table.length; i++){
            if (table[i][1].equals(code)){
                return table[i][0];
            }
        }
        return null;
    }

    public boolean isInAlphabet(String key){
        for(int i = 0; i < table.length; i++){
            if (table[i][0].equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean isInAlphabet(char[] key_char){
        String key = new String(key_char);
        for(int i = 0; i < table.length; i++){
            if (table[i][0].equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean isInAlphabet(char key_char){
        String key = ""+key_char;
        for(int i = 0; i < table.length; i++){
            if (table[i][0].equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean isInTable(String code){
        for(int i = 0; i < table.length; i++){
            if (table[i][1].equals(code)){
                return true;
            }
        }
        return false;
    }

    public boolean isInTable(char[] code_char){
        String code = new String(code_char);
        for(int i = 0; i < table.length; i++){
            if (table[i][1].equals(code)){
                return true;
            }
        }
        return false;
    }

    public boolean isInTable(char code_char){
        String code = ""+code_char;
        for(int i = 0; i < table.length; i++){
            if (table[i][1].equals(code)){
                return true;
            }
        }
        return false;
    }

    public String encode(String text){
        int i;
        String code = "";

        //Recorrem el text
        for (i = 0; i < text.length(); i++){
            String symbol = "";
            symbol = symbol + text.charAt(i);

            //Si el simbol no es troba al alfabet vol dir que ocupa mes d'un caracter
            while (!isInAlphabet(symbol)){
                i++;
                symbol = symbol+text.charAt(i);
            }

            //Concatenem el codi
            code = code + getCode(symbol);
        }
        return code;
    }

    public String decode(String code){
        int i;
        String decoded = "";
        //Recorrem el codi
        for (i = 0; i < code.length(); i++){
            String c = "";
            c = c + code.charAt(i);
            //Si el codi no esta a la taula agafem un caracter mes fins coincidir
            while (!isInTable(c)){
                i++;
                c = c+code.charAt(i);
            }

            //Concatenem el simbol
            decoded = decoded + getSymbol(c);
        }
        return decoded;
    }

    public double averageBits(){
        double sum = 0;
        //Per a cada simbol fem sumatori del nombre de bits que ocupa per la seva probabilitat
        for (String s : alphabet){
            sum = sum + getCode(s).length() * searchNode(root,s).value;
        }

        return sum;
    }

    public double enthropy(){
        double sum = 0;
        //Per a cada simbol fem sumatori de la seva probabilitat per el log2 de la probabilitat
        for (String s : alphabet){
            double prob = searchNode(root,s).value;
            sum = (sum + prob * Utils.log(prob,2));
        }

        return -sum;
    }

    public int getNumBits(){
        int bits = 1;
        while (Math.pow(2,bits) < alphabet.size()){
            bits ++;
        }
        return bits;
    }

    public double compressionRatio(){
        return getNumBits()/averageBits();
    }
}
