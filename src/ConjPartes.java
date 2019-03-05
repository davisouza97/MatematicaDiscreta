
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import org.apache.commons.lang3.SerializationUtils;

public class ConjPartes implements Serializable {

    void teste(ArrayList<Integer> entrada) {
        ArrayList<TreeSet<Integer>> x = new ArrayList<>();

        for (Integer integer : entrada) {
            x.add(new TreeSet<>());
            x.get(x.size() - 1).add(integer);
        }

        for (int i = 0; i < entrada.size(); i++) {
            List<TreeSet<Integer>> controle = SerializationUtils.clone(x);
            for (TreeSet antes : controle) {
                TreeSet agora = SerializationUtils.clone(antes);
                agora.add(entrada.get(i));
                if (!x.contains(agora)) {
                    x.add(agora);
                }
            }
        }
        x.add(new TreeSet());
        System.out.println("Conjunto das partes: "+x);
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Reverter operação?(s/n)");
        String reverter = input.next();
        if (reverter.equalsIgnoreCase("s")) {
        TreeSet resultado = new TreeSet();
            for (TreeSet arvore: x) {
                for (int i = 0; i < arvore.size(); i++) {
                    resultado.add(arvore.first());
                    arvore.remove(arvore.first());
                }
            }
            System.out.println("Resultado : "+resultado);
        }
    }
}