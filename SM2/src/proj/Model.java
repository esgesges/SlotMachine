package proj;

import javax.swing.ImageIcon;

public class Model {
    private double scommessaAttuale;
    private String txtVittoria;
    private ImageIcon mela = new ImageIcon(getClass().getResource("mela.png"));
	private ImageIcon arancia = new ImageIcon(getClass().getResource("arancia.png"));
    private ImageIcon cocco = new ImageIcon(getClass().getResource("cocco.png"));
    private double credito = 150;
    public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public ImageIcon getMela() {
		return mela;
	}

	public void setMela(ImageIcon mela) {
		this.mela = mela;
	}

	public ImageIcon getArancia() {
		return arancia;
	}

	public void setArancia(ImageIcon arancia) {
		this.arancia = arancia;
	}

	public ImageIcon getCocco() {
		return cocco;
	}

	public void setCocco(ImageIcon cocco) {
		this.cocco = cocco;
	}


    public double getScommessaAttuale() {
        return scommessaAttuale;
    }

    public void setScommessaAttuale(double scommessaAttuale) {
        this.scommessaAttuale = scommessaAttuale;
    }

    public String getTxtVittoria() {
        return txtVittoria;
    }

    public void setTxtVittoria(String txtVittoria) {
        this.txtVittoria = txtVittoria;
    }
}
