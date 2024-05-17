import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, HashSet<Arco<T>>> vertices;

    public GrafoDirigido(){
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int nuevoVertice) {

        //Gracias IA
        //this.vertices.putIfAbsent(nuevoVertice, new HashSet<>());

        if (!this.vertices.containsKey(nuevoVertice))
            this.vertices.put(nuevoVertice,new HashSet<>());

    }


    @Override
    public void borrarVertice(int verticeId) {
      if (cantidadArcos() > 0){
          Iterator<Arco<T>> arcoIterator = obtenerArcos(verticeId);
          while (arcoIterator.hasNext()){
              arcoIterator.next();
              arcoIterator.remove();
          }
      }

      this.vertices.remove(verticeId);

    }

    @Override
    public void agregarArco(int vertice1, int vertice2, T etiqueta) {
        if (!existeArco(vertice1,vertice2)){
            Arco<T> arco = new Arco<>(vertice1,vertice2,etiqueta);
            //el hash set permite que el vertice tenga muchos arcos
            this.vertices.get(vertice1).add(arco);
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        Iterator<Arco<T>> arcoI = obtenerArcos(verticeId1);
        while (arcoI.hasNext()){
           Arco<T> arco = arcoI.next();
          if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2){
              arcoI.remove();
          }
        }

    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.containsKey(verticeId);
    }

    public boolean contieneKeys(int verticeId1, int verticeId2){
        return this.vertices.containsKey(verticeId1) && this.vertices.containsKey(verticeId2);
    }

    @Override
    public boolean existeArco(int vertice1, int vertice2) {
        if (contieneKeys(vertice1, vertice2)){
            Iterator<Arco<T>> arcos = this.vertices.get(vertice1).iterator();
            while (arcos.hasNext()){
                Arco<T> arco = arcos.next();
                return arco.getVerticeOrigen() == vertice1 && arco.getVerticeDestino() == vertice2;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int vertice1, int vertice2) {
        if (existeArco(vertice1,vertice2)){
            Iterator<Arco<T>> arcos = this.vertices.get(vertice1).iterator();
            while (arcos.hasNext()){
               Arco<T> arco = arcos.next();
              if(arco.getVerticeOrigen() == vertice1 && arco.getVerticeDestino() == vertice2){
                  return arco;
              }
            }
        }

        return null;
    }

    @Override
    public int cantidadVertices() {
        return this.vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int cont = 0;
        for (HashSet<Arco<T>> i: vertices.values() ){

            System.out.println(i + " " );
            System.out.println(i.size());
            cont += i.size();
        }
        return cont;
        //return vertices.values().size();
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        ArrayList<Integer> vertices = new ArrayList<>(this.vertices.keySet());
        return vertices.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {

        Iterator<Arco<T>> arcoIterator = vertices.get(verticeId).iterator();
        HashSet<Integer> adyacentes = new HashSet<>();

        while (arcoIterator.hasNext()){
            Arco<T> arco = arcoIterator.next();
            adyacentes.add(arco.getVerticeDestino());

        }
        return adyacentes.iterator();

    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {

        HashSet<Arco<T>> arcos = new HashSet<>();
        for (HashSet<Arco<T>> i: vertices.values() ){
            arcos.addAll(i);
        }

        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return this.vertices.get(verticeId).iterator();
    }

}