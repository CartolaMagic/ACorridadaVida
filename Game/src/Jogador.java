import javax.swing.*;

public class Jogador {
    private String nome;


    public void defineNomeJogador() {
        JOptionPane.showInputDialog("Digite seu nome");
    }

    public String getNome() {
        return nome != null ? nome : "Anônimo";
    }


    
}
