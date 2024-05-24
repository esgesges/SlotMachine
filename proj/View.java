package proj;


import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JLabel rullo1, rullo2, rullo3;
    private JButton btnPiu, btnMeno, btnSpin;
    private JTextField txtScommessa, txtVittoria;

    public View() {
        setTitle("Slot Machine");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        ImageIcon icon = new ImageIcon(getClass().getResource("ima.jpeg"));
        
        if(icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
    		JOptionPane.showMessageDialog(null, "image loaded");
        } else {
    		JOptionPane.showMessageDialog(null, "image NOT loaded");

        }
        // Create a JButton with the ImageIcon

        // Pannello per i rulli
        JPanel reelsPanel = new JPanel(new GridLayout(1, 3));
        rullo1 = new JLabel(icon, SwingConstants.CENTER);
        rullo2 = new JLabel(icon, SwingConstants.CENTER);
        rullo3 = new JLabel(icon, SwingConstants.CENTER);
        reelsPanel.add(rullo1);
        reelsPanel.add(rullo2);
        reelsPanel.add(rullo3);

        // Pannello per i pulsanti e il campo di testo della scommessa
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

        // Etichetta per la vincita
        txtVittoria = new JTextField("VINCITA");
        txtVittoria.setEditable(false);
        txtVittoria.setHorizontalAlignment(SwingConstants.CENTER);

        // Aggiunta dei pannelli al frame
        add(reelsPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(txtVittoria, BorderLayout.NORTH);

        // Impostazione della visibilità della finestra
        setVisible(true);
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

    public void setRullo1(ImageIcon doritos) {
        rullo1.setText(String.valueOf(doritos));
    }

    public void setRullo2(ImageIcon doritos) {
        rullo2.setText(String.valueOf(doritos));
    }

    public void setRullo3(ImageIcon doritos) {
        rullo3.setText(String.valueOf(doritos));
    }

    public void updateScommessa(double valore) {
        txtScommessa.setText("Scommessa: " + valore);
    }

    public void updateVittoria(String messaggio) {
        txtVittoria.setText(messaggio);
    }
}


 