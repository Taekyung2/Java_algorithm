package ssafy_repeat;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10);
        for(int i = 0; i < 10; i++) {
            tree.add((char)('A' + i));
        }

        tree.searchBFS2();
        tree.searchPreOrder(1);
        System.out.println();
        tree.searchInOrder(1);
        System.out.println();
        tree.searchPostOrder(1);
    }
}
