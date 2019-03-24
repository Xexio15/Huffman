package ub.huffman;

public class Node implements Comparable{
    public String key;
    public float value;
    public Node parent;
    public Node left = null;
    public Node right = null;
    public int bit;

    public Node(String key, float value, Node parent){
        this.key = key;
        this.value = value;
        this.parent = parent;
    }


    @Override
    public int compareTo(Object o) {
        if (this.value <= ((Node)o).value){
            return -1;
        }else if(this.value > ((Node)o).value){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return key+":"+value;
    }
}
