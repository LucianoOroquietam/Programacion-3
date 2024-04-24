public class Main {
    public static void main(String[] args) {
        // Ejemplo de construcción de un árbol

        //raiz del arbol
        Tree root = new Tree();
        //subarbol le agregamos valores tanto a la izq como a la derecha
        root.add(6);
        root.add(3);
        root.add(7);
        root.add(1);
        root.add(5);
        root.add(4);
        root.add(7);
        root.add(9);



        System.out.println( root.getRoot());

        System.out.println(root.hasElement(10));

        System.out.println(root.isEmpty(root));

        System.out.println(root.getHeight());


        System.out.println("Recorrido en orden (in-order traversal):" );
        root.printInOrder();

        System.out.println("Recorrido en orden (pre-order ):");
        root.printPreOrder();

    }


}