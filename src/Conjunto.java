
import java.util.ArrayList;
import java.util.Objects;

public class Conjunto {

    String nome;
    ArrayList<Integer> elementos = new ArrayList<>();

    public Conjunto(String linha) {
        nome = "" + linha.charAt(0);
        String numero = "";
        linha = linha.replace(" ", "");       //remove todos s espacos
        for (int i = 0; i < linha.length(); i++) {
            if (Character.isDigit(linha.charAt(i)) || linha.charAt(i) == '-') {
                numero += linha.charAt(i);
            } else if (linha.charAt(i) == ',' || linha.charAt(i) == '}') {
                if (!numero.equals("")) {        //se entrar aqui mas o conjunto estiver vazio nao faz nada
                    elementos.add(Integer.parseInt(numero));
                    numero = "";
                }
            }

        }
    }

    public Conjunto() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public void addElemento(Integer elemento){
        boolean adicionar = true;
        for (Integer e : elementos) {
            if (Objects.equals(elemento, e)) {
                adicionar = false;
                break;
            }
        }
        if (adicionar) {
            elementos.add(elemento);
        }
    }
    public String imprime() {
        String impresao = this.nome;
        impresao += " = {";
        for (int i = 0; i < elementos.size(); i++) {
            impresao += elementos.get(i);
            if (i != elementos.size() - 1) {
                impresao += ",";
            }
        }
        impresao += "}";
        return impresao;
    }

    @Override
    public String toString() {
        return nome;
    }

}
