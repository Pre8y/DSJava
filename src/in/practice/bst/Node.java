package in.practice.bst;

public class Node<T extends Comparable> {
    T data;
    Node<T> left, right;
    Node(T data){
        this.data = data;
        left = right = null;
    }
}
