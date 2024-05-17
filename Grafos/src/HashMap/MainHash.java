package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MainHash {
    public static void main(String[] args) {
        Map<Integer,String> mapaEmpleados = new HashMap<>();

        mapaEmpleados.put(1,"Luciano");
        mapaEmpleados.put(2, "Miquela");
        mapaEmpleados.put(3, "EL TOMIIII");
        mapaEmpleados.put(4,"el saimonn");
        mapaEmpleados.put(5,"el luchoooo");
        mapaEmpleados.put(6,"la oli");

        System.out.println(mapaEmpleados.values());
        System.out.println(mapaEmpleados.keySet());

        String empleado = mapaEmpleados.get(1);
        System.out.println("el empleado buscado es " + empleado);

        for (Map.Entry<Integer, String> entry : mapaEmpleados.entrySet()) {
            Integer clave = entry.getKey();
            String valor = entry.getValue();
            System.out.println("Clave: " + clave + ", Valor: " + valor);
        }


        HashSet<String> cars = new HashSet<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars);

        Map<Integer,HashSet<String>> mapaP = new HashMap<>();
        mapaP.put(1,cars);
        mapaP.get(1).add("chevrolet");

        //para agregarle referencia a un vertice

        System.out.println(cars);


    }
}
