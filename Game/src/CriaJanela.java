import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriaJanela {
    private int currentPage = 0;
    private JTextArea textArea;
    private Jogador jogador;

    Auxiliar aux = new Auxiliar();
    
    
    public void criarJanela(int NumeroPagina, int contDecisao) {
        
        currentPage = NumeroPagina;
        jogador = new Jogador();
        // SeqDecisoes seq = new SeqDecisoes();

        // Cria o frame principal
        JFrame janela = new JFrame("Missão da Vida");
        janela.setSize(400, 300);
        janela.setLayout(new BorderLayout());   // Define o layout do frame como BorderLayout

        // Cria uma área de texto para mostrar a história
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        

        JScrollPane scrollPane = new JScrollPane(textArea);
        janela.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        // JButton prevButton = new JButton("Anterior");
        JButton nextButton = new JButton("Próximo");
        // buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        janela.add(buttonPanel, BorderLayout.SOUTH);


        // prevButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         if (currentPage > 0) {
        //             currentPage--;
        //             updateTextArea(jogador.getNome());
        //             System.out.println(currentPage);
        //         }
        //     }
        // });
        
        if (contDecisao == 0) {
            updateTextArea("Anônimo");
        } else if (contDecisao == 1 ) {
            decisao1("Anônimo");
        } else if (contDecisao == 2 ) {
            decisao2("Anônimo");
        } else if (contDecisao == 3 ) {
            decisao3("Anônimo");
        } else if (contDecisao == 4 ) {
            decisao4("Anônimo");
        } else if (contDecisao == 5 ) {
            decisao5("Anônimo");
        } else if (contDecisao == 6 ) {
            decisao6("Anônimo");
        } else if (contDecisao == 7 ) {
            decisao7("Anônimo");
        }

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentPage < Textos.getPrimeiraParte().length - 1) {
                    currentPage++;
                    // updateTextArea(jogador.getNome());
                    System.out.println(currentPage);


                    if (contDecisao == 0) {
                        updateTextArea("Anônimo");
                    } else if (contDecisao ==1 ) {
                        decisao1("Anônimo");
                        if (currentPage == Textos.getPrimeiraDecisao().length - 1) {
                            janela.setVisible(false);
                            criarJanela(11, 0);
                        }  
                    } else if (contDecisao == 2 ) {
                        decisao2("Anônimo");
                        if (currentPage == Textos.getDecisao2().length - 1) {
                            janela.setVisible(false);
                            morteAviso();
                        }  
                    } else if (contDecisao == 3) {              
                        decisao3("Anônimo");
                        if (currentPage == Textos.getDecisao3().length - 1) {
                            janela.setVisible(false);
                            criarJanela(20, 0);
                        }  
                    } else if (contDecisao == 4 ) {
                        decisao4("Anônimo");
                        if (currentPage == Textos.getDecisao4().length - 1) {
                            janela.setVisible(false);
                            morteAviso();
                        } 
                    } else if (contDecisao == 5 ) {
                        decisao5("Anônimo");
                        if (currentPage == Textos.getDecisao5().length - 1) {
                            janela.setVisible(false);
                            morteAviso();

                        } 
                    } else if (contDecisao == 6 ) {
                        decisao6("Anônimo");
                        if (currentPage == Textos.getDecisao6().length - 1) {
                            janela.setVisible(false);
                            morteAviso();

                        } 
                    } else if (contDecisao == 7 ) {
                        decisao7("Anônimo");
                        if (currentPage == Textos.getDecisao7().length - 1) {
                            janela.setVisible(false);
                            morteAviso();

                        } 
                    }
                }

                if (currentPage == 7) {                                 // inserir nome de jogador
                    janela.setVisible(false);   
                    jogador.defineNomeJogador();
                    updateTextArea(jogador.getNome());
                    janela.setVisible(true);
                } else if (currentPage == 9) {                          // decisao de olhar a estante
                    janela.setVisible(false);   

                    String[] decisoes1 = { "Perguntar sobre do que se trata a foto.", "Olhar a estante."};
                    String escolha1 = caixaDecisao("Decisão", "Ele te mostra uma fotografia, você de começo nem reconhece o que é isso.", decisoes1);

                    if (escolha1.equalsIgnoreCase(decisoes1[0])) {
                        criarJanela(9, 0);
                    } else if (escolha1.equalsIgnoreCase(decisoes1[1])) {
                        criarJanela(0, 1);
                    }
                } else if (currentPage == 14) {                         // Janela de 1d20
                    janela.setVisible(false);
                    caixaAviso("Atenção Jogador", "Jogador, nesse momento você irá rodar um dado 1d20 para testar sua habilidade, caso obtenha o valor de 12 ou mais, terá sucesso, caso contrário, falhará no teste");
                    caixaAviso("Jogue o Dado", "Clique em OK para jogar o dado para tentar acalmar Walter ou não");

                    int valorObtido = aux.InteiroAleatorio(1, 20);
                    if (aux.dado1d20(valorObtido) == "Você conseguiu!") {
                        criarJanela(14, 0);
                    } else if (aux.dado1d20(valorObtido) == "Você Falhou") {
                        criarJanela(0, 2);     
                    }

                    caixaAviso("Resultado", "Você obteve o valor: "+ valorObtido + " " + aux.dado1d20(valorObtido));
                } else if (currentPage == 16) {                         // decisão de atirar ou esperar (Guardas)
                    janela.setVisible(false);
                    
                    String[] decisoes2 = { "Atirar na porta e tentar incapacitar os Agentes.", "Esperar os Agentes quebrar a porta e atirar em seguida."};
                    String escolha2 = caixaDecisao("Decisão", "Sabendo disso, o que você faz?", decisoes2);

                    if (escolha2.equalsIgnoreCase(decisoes2[0])) { 
                        combate();
                        
                    } else if (escolha2.equalsIgnoreCase(decisoes2[1])) {
                        combate();
                    }
                } else if (currentPage == 18) {                         // decisão de perguntar sobre movimento ou missao
                    janela.setVisible(false);

                    String[] decisoes3 = { "Perguntar sobre o que aconteceu com o Movimento Verde.", "Perguntar sobre missão"};
                    String escolha3 = caixaDecisao("Decisão", "O que voce faz?", decisoes3);
                   
                    if (escolha3.equalsIgnoreCase(decisoes3[0])) {  //
                        criarJanela(18, 0);
                    } else if (escolha3.equalsIgnoreCase(decisoes3[1])) {
                        criarJanela(0, 3);
                    }
                } else if ( currentPage == 26) {                        // decisao de qual nome de disfarce
                    janela.setVisible(false);
                    String[] decisoes4 = { "Breno", "Bruno"};
                    String escolha4 = caixaDecisao("Decisão", "Qual é o seu nome de Disfarce?", decisoes4);

                    if (escolha4.equalsIgnoreCase(decisoes4[0])) {  //
                        criarJanela(0, 4);
                    } else if (escolha4.equalsIgnoreCase(decisoes4[1])) {
                        criarJanela(26, 0);
                    }
                   
                } else if (currentPage == 28) {                         // teste 1d20 de hackear as cameras
                    janela.setVisible(false);

                    caixaAviso("Jogue o Dado", "Clique em OK para jogar o dado para tentar Hackear \n as câmeras");

                    int valorObtido = aux.InteiroAleatorio(1, 20);
    
                    if (aux.dado1d20(valorObtido) == "Você conseguiu!") {
                        caixaAviso("Resultado", "Você obteve o valor: "+ valorObtido + "Você conseguiu! ");
                        // caixaAviso("Resultado", " Você consegue colocar uma imagem falsa nas cameras e você consegue tempo para hackear a cancela.");
                        criarJanela(28, 0); // =============
                    } else if (aux.dado1d20(valorObtido) == "Você Falhou") {
                        caixaAviso("Resultado", "Você obteve o valor: "+ valorObtido + "Você Falhou ");
                        criarJanela(0, 5);     
                    }

                    
                } else if (currentPage == 29) {                          // teste 1d20 de hackear a cancela
                    janela.setVisible(false);

                    caixaAviso("Jogue o Dado", "Clique em OK para jogar o dado para tentar Hackear \n a cancela");

                    int valorObtido = aux.InteiroAleatorio(1, 20);
    
                    if (aux.dado1d20(valorObtido) == "Você conseguiu!") {
                        caixaAviso("Resultado", "Você obteve o valor: "+ valorObtido + "Você conseguiu! ");
                        caixaAviso("Resultado", "Você consegue hackear a cancela, vocês entraram no estacionamento.");
                        criarJanela(29, 0); // =============
                    } else if (aux.dado1d20(valorObtido) == "Você Falhou") {
                        caixaAviso("Resultado", "Você obteve o valor: "+ valorObtido + "Você Falhou ");
                        criarJanela(0, 6);     
                    }
                } else if (currentPage == 31) {                         // teste 1d20 para tentar abrir o cofre
                    janela.setVisible(false);

                    caixaAviso("Jogue o Dado", "Clique em OK para jogar o dado para tentar abrir o Cofre");

                    int valorObtido = aux.InteiroAleatorio(1, 20);
    
                    if (aux.dado1d20(valorObtido) == "Você conseguiu!") {
                        caixaAviso("Resultado", "Você obteve o valor: "+ valorObtido + "Você conseguiu! ");
                        criarJanela(31, 0); // =============
                    } else if (aux.dado1d20(valorObtido) == "Você Falhou") {
                        caixaAviso("Resultado", "Você obteve o valor: "+ valorObtido + "Você Falhou ");
                        criarJanela(0, 7);     
                    }
                }
            }   
        });
        


        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public String caixaDecisao (String titulo, String msg, String[] opcoes) {
		String txt = "";
		Object selec = JOptionPane.showInputDialog(null, msg,
				titulo, JOptionPane.INFORMATION_MESSAGE, null, opcoes,
				opcoes[0]);
		txt = selec.toString();
		return txt;
	}
    public void caixaAviso (String titulo, String msg) {
		JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
    public void morteAviso() {
        JOptionPane.showMessageDialog(null, "Você Morreu", "Você Morreu", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    
    private int vida = 100;
    private int vidaGuarda = 100;



//========combate arrumar ==============================================================================================================================================================================
    // private boolean atacaGuarda() {
    //     if (vidaGuarda > 0) {
    //         int hit = aux.InteiroAleatorio(20, 34);
    //         vidaGuarda = vidaGuarda - hit;
    //         JOptionPane.showMessageDialog(null, "Voce deu um tiro no Guarda e causou " + hit + " de dano, \n agora ele esta com  " + vidaGuarda +  "de vida ", "Voce atacou o Guarda" , JOptionPane.INFORMATION_MESSAGE);
    //         System.out.println("vida do guarda: " + vidaGuarda);
    //         return true;
    //     } else {
    //         criarJanela(18, 0);
    //         return false;
    //     }
    // }
    // private void atacaJogador() {
    //     if (vida > 0) {
    //         int hit = aux.InteiroAleatorio(10, 15);
    //         vida = vida - hit;
    //         JOptionPane.showMessageDialog(null, "Oh nao!! o guarda te atacou e causou " + hit + " de dano, \n agora VOCE esta com  " + vida +  "de vida ", "Voce atacou o Guarda" , JOptionPane.ERROR_MESSAGE);
    //     } else {
    //        morteAviso();
    //     }
    // }

    public void combate() {
        boolean verif = true;
        while (verif) {
            if (vidaGuarda > 0) {
                int hit = aux.InteiroAleatorio(17, 25);
                vidaGuarda = vidaGuarda - hit;
                if (vidaGuarda < 0) { vidaGuarda = 0;}
                JOptionPane.showMessageDialog(null, "Voce deu um tiro no Guarda e causou " + hit + " de dano, \n agora ele esta com  " + vidaGuarda +  "de vida ", "Voce atacou o Guarda" , JOptionPane.INFORMATION_MESSAGE);
                System.out.println("vida do guarda: " + vidaGuarda);
            } else {
                criarJanela(16, 0);
                verif = false;
            }
            if (vida > 0) {
                int hit = aux.InteiroAleatorio(15, 20);
                vida = vida - hit;
                String[] teste ={ "Oh nao!! o guarda te atacou e causou", "Você está sangrando... "};
                if (verif) { JOptionPane.showMessageDialog(null, teste[0] + hit + " de dano, \n agora VOCE esta com  " + vida +  "de vida ", "Voce atacou o Guarda" , JOptionPane.ERROR_MESSAGE); }
                else { JOptionPane.showMessageDialog(null, teste[1] + hit + " de dano, \n agora VOCE esta com  " + vida +  "de vida ", "Voce atacou o Guarda" , JOptionPane.ERROR_MESSAGE);}
                
            } else {
               morteAviso();
            }
        }
    }

    //============================================================================================================================================================================================




    private void updateTextArea(String playerName) {
        String pageText = Textos.getPrimeiraParte()[currentPage].replace("{PLAYER_NAME}", playerName);
        textArea.setText(pageText);
    }
    private void decisao1(String playerName) {
        String paget = Textos.getPrimeiraDecisao()[currentPage].replace("{PLAYER_NAME}", playerName);
        textArea.setText(paget);
    }
    private void decisao2(String playerName) {
        String paget = Textos.getDecisao2()[currentPage].replace("{PLAYER_NAME}", playerName);
        textArea.setText(paget);
    }
    private void decisao3(String playerName) {
        String paget = Textos.getDecisao3()[currentPage].replace("{PLAYER_NAME}", playerName);
        textArea.setText(paget);
    }
    private void decisao4(String playerName) {
        String paget = Textos.getDecisao4()[currentPage].replace("{PLAYER_NAME}", playerName);
        textArea.setText(paget);
    }
    private void decisao5(String playerName) {
        String paget = Textos.getDecisao5()[currentPage].replace("{PLAYER_NAME}", playerName);
        textArea.setText(paget);
    }
    private void decisao6(String playerName) {
        String paget = Textos.getDecisao6()[currentPage].replace("{PLAYER_NAME}", playerName);
        textArea.setText(paget);
    }
    private void decisao7(String playerName) {
        String paget = Textos.getDecisao7()[currentPage].replace("{PLAYER_NAME}", playerName);
        textArea.setText(paget);
    }
}
