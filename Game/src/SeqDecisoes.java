// import javax.swing.JFrame;
// // import javax.swing.JOptionPane;

// public class SeqDecisoes{

//     private JFrame janela;
//     public void setReferenciaFrame(JFrame jan) {
//         this.janela = jan;
//     }
//     CriaJanela cjan = new CriaJanela();

    
//     public void fazerDecisao(int currentPage) {
//         if (currentPage == 13) {
//             janela.setVisible(false);
//             cjan.caixaAviso("Atenção Jogador", "Jogador, nesse momento você irá rodar um dado 1d20 para testar sua habilidade, caso obtenha o valor de 12 ou mais, terá sucesso, caso contrário, falhará no teste");
//             cjan.criarJanela(14);
//         } else if (currentPage == 9) {
//             janela.setVisible(false);

//             String[] decisoes1 = { "Perguntar sobre do que se trata a foto.", "Olhar a estante."};
//             String escolha1 = cjan.caixaDecisao("Decisão", "Ele te mostra uma fotografia, você de começo nem reconhece o que é isso.", decisoes1);


//             if (escolha1.equalsIgnoreCase(decisoes1[0])) {
//                 cjan.criarJanela(9);
//             } else if (escolha1.equalsIgnoreCase(decisoes1[1])) {
//                 // this.seq03(jog);
//             }
//         } else if (currentPage == 13) {
//             janela.setVisible(false);
//             cjan.caixaAviso("Jogue o Dado", "Clique em OK para jogar o dado e descobrir se você ouviu algo ou não");
//         }
//     }
// }

