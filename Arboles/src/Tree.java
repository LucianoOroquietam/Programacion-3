public class Tree {

    //metodos para el arbol
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public int getRoot(){
        return this.root.getValue();
    }


    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    public void delete(Integer value) {
        delete(this.root,value);
    }

    private boolean delete(TreeNode root, Integer value){

        if (root == null){
            return false;

        }
        //1 caso cuando me pasan una hoja
        if (value < root.getValue()){
            boolean deleted = delete(root.getLeft(), value);
            //ajustamos las referencias del padre del nodo 1 para que ya no apunten a él.
            // En este caso, el nodo padre del nodo 1 es el nodo con el valor 3.
            if (deleted && root.getLeft() != null) {
                root.setLeft(null);
            }
        }else if(value > root.getValue()){
            boolean deleted = delete(root.getRight(),value);
            if (deleted && root.getRight() != null) {
                root.setRight(null); // Ajusta la referencia del padre al hijo restante
            }
        }else {
            // Caso cuando el nodo encontrado tiene un solo hijo
            if (root.getLeft() == null && root.getRight() != null) {
                // Ajustamos las referencias del padre para que apunten al hijo derecho
                //seteo el valor a eliminar con su hijo derecho
                root.setValue(root.getRight().getValue());
                root.setRight(root.getRight().getRight());
            } else if (root.getLeft() != null && root.getRight() == null) {
                // Ajustamos las referencias del padre para que apunten al hijo izquierdo

                //seteo el valor a eliminar con su hijo izq
                root.setValue(root.getLeft().getValue());
                //a la izquierda del padre voy a tener el valor a la izquierda del hijo que voy a borrar
                root.setLeft(root.getLeft().getLeft());
            }else{
                // Otros caso (nodo hoja)
                return root.getLeft() == null && root.getRight() == null;
            }
        }
        return false;
    }

    public  int getHeight(){
        return getHeight(this.root);
    }
    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        int subArbolIzquierdo = getHeight(root.getLeft());
        int subArbolDerecho = getHeight(root.getRight());


        return Math.max(subArbolIzquierdo,subArbolDerecho) + 1;
    }

    public boolean isEmpty(Tree root){
        return root == null;
    }

    public boolean hasElement (Integer value) {
        return hasElement(this.root,value);
    }
    private boolean hasElement(TreeNode root, Integer value){
        //chqueamos que exista una raiz y cuando llegue a null porque no encontro valor directamente me retorne false
        if (root == null){
            return false;
        }
        //caso base
        if (root.getValue() == value){
            return true;
        }

        //buscamos el elemento
        if (value < root.getValue()){
            return hasElement(root.getLeft(),value);
        }else{
            return hasElement(root.getRight(),value);
        }
    }

    // Método para imprimir el árbol utilizando recorrido en orden (in-order traversal)
    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.getLeft()); // Imprime los nodos del subárbol izquierdo
            System.out.println(root.getValue() + " "); // Imprime la raíz
            printInOrder(root.getRight()); // Imprime los nodos del subárbol derecho
        }
    }

    public void printPreOrder(){
        printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode root){

        if (root == null){
            System.out.println("-");
            return;
        }

            System.out.println(root.getValue());
            printPreOrder(root.getLeft());
            printPreOrder(root.getRight());



        /*    if (root.getLeft() == null){
                System.out.println("-");
            } else if (root.getRight()==null) {
                System.out.println("-");
            }*/


    }

    @Override
    public String toString() {
        return
                "root=" + root
                ;
    }
}