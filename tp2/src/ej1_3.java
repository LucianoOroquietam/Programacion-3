
class Nodo {
    int valor;
    Nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class Main {
    public static void main(String[] args) {
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        Nodo nodo4 = new Nodo(4);
        Nodo nodo5 = new Nodo(5);

        nodo1.siguiente = nodo2;
        nodo2.siguiente = nodo3;
        nodo3.siguiente = nodo4;
        nodo4.siguiente = nodo5;

        if (estaListaOrdenada(nodo1)) {
            System.out.println("La lista está ordenada.");
        } else {
            System.out.println("La lista no está ordenada.");
        }
    }


    public static boolean estaListaOrdenada(Nodo nodo) {
        if (nodo == null || nodo.siguiente == null) {
            return true; // Caso base: lista vacía o lista de un solo nodo, considerada ordenada
        }

        // Verificar si el nodo actual y su sucesor están ordenados
        if (nodo.valor > nodo.siguiente.valor) {
            return false; // La lista no está ordenada
        }

        // Llamar recursivamente para el siguiente nodo
        return estaListaOrdenada(nodo.siguiente);
    }
}


