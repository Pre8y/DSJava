package in.practice.bst;

public class BSTTest {
    public static void main(String... args){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(50);
        bst.add(40);
        bst.add(70);
        bst.add(60);
        bst.add(80);
        System.out.println(bst.inOrder());

        bst.delete(50);
        System.out.println(bst.inOrder());
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
        bst1.add(60);
        bst1.add(30);
        bst1.add(70);
        bst1.add(20);
        bst1.add(50);
        bst1.add(40);
        bst1.leftView();
    }

//            60
//        /       \
//        40       70
//                /   \
//                  80
}
