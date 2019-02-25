
import java.util.ArrayList;

public class Conjunto {
    String nome;
    ArrayList<Integer> elementos = new ArrayList<>();

    public Conjunto(String linha) {
        nome = ""+linha.charAt(0);
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

    public void imprimeItens() {
        System.out.print("{");
        for (int i = 0; i < elementos.size(); i++) {
            System.out.print(elementos.get(i));
            if (i!=elementos.size()-1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    @Override
    public String toString() {
        return nome;
    }

}
