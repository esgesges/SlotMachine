package proj;


import java.awt.MediaTracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Controller {
    private Random random;
    private int rullo1Valore;
    private int rullo2Valore;
    private int rullo3Valore;
    private double valoreScommesso;
    private Model model;
    private View view;
    private ImageIcon doritos;
    private ImageIcon minSkin;
    
    

    
    public Controller(Model model, View view) {
        ImageIcon doritos = new ImageIcon(getClass().getResource("ima.jpeg"));
        ImageIcon minSkin = new ImageIcon(getClass().getResource("asd.jpeg"));

        this.model = model;
        this.view = view;
        this.random = new Random();

        view.getBtnPiu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentaScommessa();
            }
        });
        view.getBtnMeno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diminuisciScommessa();
            }
        });
        view.getBtnSpin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spin();
            }
        });

        rullo1Valore = 0;
        rullo2Valore = 0;
        rullo3Valore = 0;
    }

    private void aumentaScommessa() {
        valoreScommesso = model.getScommessaAttuale();

        if (valoreScommesso == 0) {
            valoreScommesso = 0.20;
        } else if (valoreScommesso == 0.20) {
            valoreScommesso = 0.50;
        } else if (valoreScommesso == 0.50) {
            valoreScommesso = 1.00;
        } else if (valoreScommesso == 1.00) {
            valoreScommesso = 2.00;
        } else if (valoreScommesso == 2.00) {
            valoreScommesso = 5.00;
        } else if (valoreScommesso == 5.00) {
            valoreScommesso = 15.0;
        }

        model.setScommessaAttuale(valoreScommesso);
        view.updateScommessa(valoreScommesso);
    }

    private void diminuisciScommessa() {
        valoreScommesso = model.getScommessaAttuale();

        if (valoreScommesso == 0.20) {
            valoreScommesso = 0;
        } else if (valoreScommesso == 0.50) {
            valoreScommesso = 0.20;
        } else if (valoreScommesso == 1.00) {
            valoreScommesso = 0.50;
        } else if (valoreScommesso == 2.00) {
            valoreScommesso = 1.00;
        } else if (valoreScommesso == 5.00) {
            valoreScommesso = 2.00;
        } else if (valoreScommesso == 15.0) {
            valoreScommesso = 5.00;
        }

        model.setScommessaAttuale(valoreScommesso);
        view.updateScommessa(valoreScommesso);
    }

    private void spin() {
        spinRulli();
        if (controllaVincita()) {
            double vincita = calcolaVincita();
            model.setTxtVittoria("Hai vinto " + vincita + "!");
        } else {
            model.setTxtVittoria("Nessuna vincita.");
        }
    }

    private void spinRulli() {
        rullo1Valore = random.nextInt(2);
        System.out.println(rullo1Valore);
        rullo2Valore = random.nextInt(2);
        System.out.println(rullo2Valore);
        rullo3Valore = random.nextInt(2);
        System.out.println(rullo3Valore);

        if(rullo1Valore == 0) {
            view.setRullo1(doritos);
        } else {
            view.setRullo1(minSkin);

        }
        if(rullo2Valore == 0) {
            view.setRullo2(doritos);
        } else {
            view.setRullo2(minSkin);

        }
        if(rullo3Valore == 0) {
            view.setRullo3(doritos);
        } else {
            view.setRullo3(minSkin);

        }

    }

    private boolean controllaVincita() {

    	if(rullo1Valore == rullo2Valore && rullo1Valore == rullo3Valore) {
    	    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		JOptionPane.showMessageDialog(null, "Hai vinto.");
    	} else {
    	    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		JOptionPane.showMessageDialog(null, "Hai perso.");

    	}
        return rullo1Valore == rullo2Valore && rullo1Valore == rullo3Valore;
    }

    private double calcolaVincita() {
        if (rullo1Valore >= 0 && rullo1Valore <= 3) {
            return valoreScommesso * 2;
        } else if (rullo1Valore >= 4 && rullo1Valore <= 7) {
            return valoreScommesso * 4;
        } else {
            return valoreScommesso * 6;
        }
    }
}

