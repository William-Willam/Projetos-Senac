package Sistema;

import java.util.ArrayList;

public class VeiculoManager {
    private ArrayList<Veiculo> lista = new ArrayList<>();

    public void adicionar(Veiculo v) {
        lista.add(v);
    }

    public void remover(int index) {
        if (index >= 0 && index < lista.size()) lista.remove(index);
    }

    public ArrayList<Veiculo> listarTodos() {
        return lista;
    }

    public ArrayList<Veiculo> listarDisponiveis() {
        ArrayList<Veiculo> disp = new ArrayList<>();
        for (Veiculo v : lista) {
            if (v.disponivel) disp.add(v);
        }
        return disp;
    }
}