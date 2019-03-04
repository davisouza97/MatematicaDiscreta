
import java.util.ArrayList;

public class ClasseConjuntoPartes {

    ArrayList<String> itens = new ArrayList<>();

    ClasseConjuntoPartes(Conjunto a) {
        itens.add("\u2205");
        for (int i = 0; i < a.elementos.size(); i++) {
            adicionaElemento(a.elementos, i);
        }

    }

    void adicionaElemento(ArrayList a, Integer combinacoes) {
        if (combinacoes == 1) {
            for (int i = 0; i < a.size(); i++) {
                itens.add(a.get(i) + "");
            }
        }
        if (combinacoes > 1 && combinacoes < a.size()) {
           
        }
        if (combinacoes == a.size()) {
            String todos = " ";
            for (int i = 0; i < a.size(); i++) {
                todos += a.get(i) + " ";
            }
            itens.add(todos);
        }
    }
}
