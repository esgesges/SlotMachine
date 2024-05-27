package proj;


import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JLabel rullo1, rullo2, rullo3;
    private JButton btnPiu, btnMeno, btnSpin, add10, add20, add50, secBtn;
    private JTextField txtScommessa, txtVittoria, txtCredito;
    private ImageIcon spin = new ImageIcon(getClass().getResource("spin_rs.png"));
    private Color sfondo = new Color(9,9,9);
    
    public View() {
        setTitle("Slot Machine");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel reelsPanel = new JPanel(new GridLayout(1, 3));
        rullo1 = new JLabel(spin, SwingConstants.CENTER);
        rullo2 = new JLabel(spin, SwingConstants.CENTER);
        rullo3 = new JLabel(spin, SwingConstants.CENTER);
        reelsPanel.add(rullo1);
        reelsPanel.add(rullo2);
        reelsPanel.add(rullo3);

        JPanel controlPanel = new JPanel(new GridLayout(1, 4));
        btnPiu = new JButton("+");
        txtScommessa = new JTextField("IMPORTO SCOMMESSO", SwingConstants.CENTER);
        btnMeno = new JButton("-");
        btnSpin = new JButton("Spin");
        txtScommessa.setEditable(false);
        controlPanel.add(btnPiu);
        controlPanel.add(txtScommessa);
        controlPanel.add(btnMeno);
        controlPanel.add(btnSpin);
        
        JPanel vc = new JPanel();
        txtVittoria = new JTextField("VINCITA");
        txtVittoria.setEditable(false);
        txtCredito = new JTextField("CREDITO");
        txtCredito.setEditable(false);
        add10 = new JButton("+10$");
        add20 = new JButton("+20$");
        add50 = new JButton("+50$");
        secBtn = new JButton("");
        secBtn.setBackground(sfondo);
        secBtn.setBorderPainted(false);
        vc.add(txtVittoria);
        vc.add(txtCredito);
        vc.add(add10);
        vc.add(add20);
        vc.add(add50);
        vc.add(secBtn);
        
        add(reelsPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(vc, BorderLayout.NORTH);

        reelsPanel.setBackground(sfondo);
        vc.setBackground(sfondo);
        setVisible(true);
    }

    public JButton getSecBtn() {
		return secBtn;
	}

	public void setSecBtn(JButton secBtn) {
		this.secBtn = secBtn;
	}

	public JButton getAdd10() {
		return add10;
	}

	public void setAdd10(JButton add10) {
		this.add10 = add10;
	}

	public JButton getAdd20() {
		return add20;
	}

	public void setAdd20(JButton add20) {
		this.add20 = add20;
	}

	public JButton getAdd50() {
		return add50;
	}

	public void setAdd50(JButton add50) {
		this.add50 = add50;
	}

	public JTextField getTxtCredito() {
		return txtCredito;
	}

	public void setTxtCredito(double d) {
		txtCredito.setText(String.valueOf(d));
	}

	public JLabel getRullo1() {
        return rullo1;
    }

    public JLabel getRullo2() {
        return rullo2;
    }

    public JLabel getRullo3() {
        return rullo3;
    }

    public JButton getBtnPiu() {
        return btnPiu;
    }

    public JButton getBtnMeno() {
        return btnMeno;
    }

    public JButton getBtnSpin() {
        return btnSpin;
    }

    public void setRullo1(ImageIcon a) {
        rullo1.setIcon(a);
    }

    public void setRullo2(ImageIcon a) {
        rullo2.setIcon(a);
    }

    public void setRullo3(ImageIcon a) {
        rullo3.setIcon(a);
    }

    public void updateScommessa(double valore) {
        txtScommessa.setText("Scommessa: " + valore);
    }

    public void updateVittoria(String messaggio) {
        txtVittoria.setText(messaggio);
    }
}


 