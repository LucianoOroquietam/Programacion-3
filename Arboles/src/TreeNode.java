public class TreeNode {

    //clase para insertar nodos al arbol
    private int valorNodo;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int valor){
        this.valorNodo = valor;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public void setRight(TreeNode right){
        this.right = right;
    }

    public int getValue() {
        return valorNodo;
    }

    public void setValue(int valorNodo) {
        this.valorNodo = valorNodo;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return
                "valorNodo=" + valorNodo +
                ", left=" + left +
                ", right=" + right
                ;
    }
}
