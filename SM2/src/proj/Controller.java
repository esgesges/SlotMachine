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
    private int totVincita;
    

    
    public Controller(Model model, View view) {
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
        view.getAdd10().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setCredito(model.getCredito() + 10);
                JOptionPane.showMessageDialog(null, "ATTENZIONE\n 10$ sono stati prelevati ed inseriti al credito");
            	view.setTxtCredito(model.getCredito());

            }
        });
        view.getAdd20().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setCredito(model.getCredito() + 20);
                JOptionPane.showMessageDialog(null, "ATTENZIONE\n 20$ sono stati prelevati ed inseriti al credito");
            	view.setTxtCredito(model.getCredito());

            }
        });
        view.getAdd50().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setCredito(model.getCredito() + 50);
                JOptionPane.showMessageDialog(null, "ATTENZIONE\n 50$ sono stati prelevati ed inseriti al credito");
            	view.setTxtCredito(model.getCredito());

            }
        });
        view.getSecBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Il bottone segreto è stato utilizzato!!\n                        ALL - IN");
                valoreScommesso = model.getCredito();
                view.updateScommessa(model.getCredito());
                model.setScommessaAttuale(model.getCredito());
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
    	view.setTxtCredito(model.getCredito());
        spinRulli();
        view.setTxtCredito(model.getCredito() - model.getScommessaAttuale());
        model.setCredito(model.getCredito() - model.getScommessaAttuale());
        if (controllaVincita()) {
            double vincita = calcolaVincita();
            JOptionPane.showMessageDialog(null, "Hai vinto: " + vincita + "!!");
            totVincita += vincita;
            view.updateVittoria("VINCITA: " + totVincita);
            model.setCredito(model.getCredito() + vincita);
            view.setTxtCredito(model.getCredito() + vincita);

        }
    	if(model.getCredito() <= valoreScommesso) {
            JOptionPane.showMessageDialog(null, "ATTENZIONE\n continuando a giocare il tuo credito diventerà negativo e sarai in debito con il casinò!" + "!!");
        }
    }

    private void spinRulli() {
        rullo1Valore = random.nextInt(3);
        System.out.println(rullo1Valore);
        rullo2Valore = random.nextInt(3);
        System.out.println(rullo2Valore);
        rullo3Valore = random.nextInt(3);
        System.out.println(rullo3Valore);

        switch(rullo1Valore) {
        case 0:
        	view.setRullo1(model.getMela());
        break;
        case 1:
        	view.setRullo1(model.getArancia());
        break;
        case 2:
        	view.setRullo1(model.getCocco());
        break;
        }
        
        switch(rullo2Valore) {
        case 0:
        	view.setRullo2(model.getMela());
        break;
        case 1:
        	view.setRullo2(model.getArancia());
        break;
        case 2:
        	view.setRullo2(model.getCocco());
        break;
        }
        
        switch(rullo3Valore) {
        case 0:
        	view.setRullo3(model.getMela());
        break;
        case 1:
        	view.setRullo3(model.getArancia());
        break;
        case 2:
        	view.setRullo3(model.getCocco());
        break;
        }
    }

    private boolean controllaVincita() {

    	if(rullo1Valore == rullo2Valore && rullo1Valore == rullo3Valore) {
    	    try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	} else {
    	    try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

    	}
        return rullo1Valore == rullo2Valore && rullo1Valore == rullo3Valore;
    }

    private double calcolaVincita() {
        valoreScommesso = model.getScommessaAttuale();
        if(rullo1Valore == 1) {
        	return valoreScommesso * 5;
        } else if(rullo1Valore == 0) {
        	return valoreScommesso * 7;        	
        } else if(rullo1Valore == 2) {
        	return valoreScommesso * 3;
        }
        return 0;
    }
}

