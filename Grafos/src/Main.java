public class Main {
    public static void main(String[] args) {
        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Float> grafito = new GrafoDirigido<Float>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        //grafito.agregarVertice(5);

        grafito.agregarArco(1, 2, 3F);
        grafito.agregarArco(1,3,4F);
        grafito.agregarArco(2,3,5f);
        grafito.agregarArco(1,4,10f);
        grafito.agregarArco(1,1,5F);
        grafito.agregarArco(3,1,8F);


        System.out.println(grafito.obtenerVertices());

        System.out.println(grafito.cantidadArcos());

    }
}