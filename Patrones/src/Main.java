import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>();

        array.add("Java");
        array.add("Spring");
        array.add("Jakarta");
        array.add("Jpa");


        Iterator<String> it = array.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}