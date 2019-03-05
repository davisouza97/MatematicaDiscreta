
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import org.apache.commons.lang3.SerializationUtils;

public class ListaControle implements Serializable {

    String nome;
    ArrayList<Integer> lista = new ArrayList();

    public ListaControle(Integer i) {
        lista.add(i);
        nome = "" + lista;
    }

    public ListaControle() {

    }

    public void adicionar(Integer i) {
        if (lista.contains(i)) {
        } else {
            lista.add(i);
            Collections.sort(lista);
        }
        nome = "" + lista;
    }

    @Override
    public String toString() {
        String valor = "";
        if (lista.isEmpty()) {
            valor = "\u29b0";
        } else {
            for (Integer integer : lista) {
                valor += " " + integer + " ";
            }
        }
        return valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.lista);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        nome = "" + lista;
        if (obj instanceof ListaControle) {
            if (((ListaControle) obj).nome.equalsIgnoreCase(this.nome)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    void adicionar(ArrayList<Integer> entrada) {
        
    }

}
