
import javax.swing.JOptionPane;

public class Auxiliar {

	
    public String decisaoInput (String titulo, String msg, String[] opcoes) {
		String txt = "";
		Object selec = JOptionPane.showInputDialog(null, msg,
				titulo, JOptionPane.INFORMATION_MESSAGE, null, opcoes,
				opcoes[0]);
		txt = selec.toString();
		return txt;
	}
	public int InteiroAleatorio (int min, int max) {
		int ale = (int)(1000000000 * Math.random());
		int num = ale%(max-min+1) + min;
		return num;
	}
	public String dado1d20(int Resultado) {
		String txt;
		if (Resultado >= 1) {
			txt = "Você conseguiu!";
		} else {
			txt = "Você Falhou";
		}
		return txt;
	}

	

	

}
