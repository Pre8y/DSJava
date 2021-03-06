package in.practice.bst;

public class BinarySearchTree<T extends Comparable> {
    Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    void add(T data) {
         root =  add(root, data);
    }

    private Node add(Node<T> node, T data) {
        if (node == null) {
            return new Node(data);
        } else if (data.compareTo(node.data) <= 0) {
            if (node.left == null) {
                node.left = new Node<T>(data);
            } else {
                node.left = add(node.left, data);
            }
        } else if (data.compareTo(node.data) > 0) {
            if (node.right == null) {
                node.right = new Node<T>(data);
            } else {
                node.right = add(node.right, data);
            }
        }
        return node;
    }
    void delete(T data){
        delete(root, data);
    }

    private Node delete(Node<T> node, T data) {
        if(node!=null){
            if(data.compareTo(node.data)<0){
                node.left = delete(node.left, data);
            }else if(data.compareTo(node.data)>0){
                node.right = delete(node.right, data);
            }else{
                if(node.left==null){
                    node = node.right;
                }else if(node.right==null){
                    node = node.left;
                }else{
                    node.data = minVal(node.right);
                    node.right = delete(node.right, node.data);
                }
            }
        }
        return node;
    }

    private T minVal(Node<T> node) {
        if(node==null) return null;
        T min = node.data;
        while (node.left!=null){
            node = node.left;
            min = node.data;
        }

        return min;
    }

    public String inOrder() {
        return inOrder(root);
    }

    private String inOrder(Node node) {
        if (node == null) return "";
        StringBuffer result = new StringBuffer();
        result.append("[")
                .append(inOrder(node.left))
                .append(",")
                .append(node.data.toString())
                .append(",")
                .append(inOrder(node.right))
                .append("]");
        return result.toString();

    }

/*
  //1 2 L 1 3 R 2 4 L 2 5 R 5 6 L
      60
    /  \
    30  70
    /\
    20 50
      /
      40
 */
int level = 0;
    public void leftView() {
        if(root==null) return;
       leftView(root, level+1);

    }
    private void leftView(Node<T> node, int nextLevel) {
        if (node == null) return;
        if(nextLevel>level) {
            System.out.print(node.data.toString() + " ");
            level = nextLevel;
        }
        if(node.left!=null){
            leftView(node.left, nextLevel+1);
        }
        if(node.right!=null){
            leftView(node.right, nextLevel+1);
        }
    }


    }
