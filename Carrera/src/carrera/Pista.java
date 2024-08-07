//Martin Alvarez Salazar 19460870
package carrera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Pista extends JFrame {
    private JLabel lblAuto1, lblAuto2, lblAuto3, lblpista;
    private JButton btninicio;
    private int x=500, y=0, ancho=500,alto=700;
    private int aleatorio1, aleatorio2, aleatorio3;
    
    public Pista(){
        super("Carrera --> Formaula 1");
        inicializapista();
        pulsainicio();
    }
    private void inicializapista(){
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(x, y, alto, ancho);
        this.setResizable(false);
        this.setSize(500, 900);
        this.setTitle("Copa Formula 1");
        
        lblpista = new JLabel();
        this.getContentPane().add(lblpista);
        lblpista.setIcon(new ImageIcon(getClass().getResource("/imagenes/CarreteraAnimada.gif")));
        lblpista.setBounds(100, 0, 300, 700);
        
        lblAuto1 = new JLabel();
        lblpista.add(lblAuto1);
        lblAuto1.setIcon(new ImageIcon(getClass().getResource("/imagenes/AutoAzulp.png")));
        lblAuto1.setBounds(30, alto-140, 100, 100);
        
        lblAuto2 = new JLabel();
        lblpista.add(lblAuto2);
        lblAuto2.setIcon(new ImageIcon(getClass().getResource("/imagenes/AutoRojop.png")));
        lblAuto2.setBounds(130, alto-140, 100, 100);

        lblAuto3 = new JLabel();
        lblpista.add(lblAuto3);
        lblAuto3.setIcon(new ImageIcon(getClass().getResource("/imagenes/AutoVerdep.png")));
        lblAuto3.setBounds(230, alto-140, 100, 100);        
        
        btninicio = new JButton("Inicio");
        this.getContentPane().add(btninicio);
        btninicio.setBounds(0, 0, 100, 50);
    }
    private void pulsainicio(){
        btninicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Inicia la Carrera");
                aleatorio1 = (int)((Math.random()*100)+1);
                aleatorio2 = (int)((Math.random()*100)+1);
                aleatorio3 = (int)((Math.random()*100)+1);
                
                Arranque hiloAuto1 = new Arranque(30, alto, lblAuto1, aleatorio1);
                Arranque hiloAuto2 = new Arranque(130, alto, lblAuto2, aleatorio2);
                Arranque hiloAuto3 = new Arranque(230, alto, lblAuto3, aleatorio3);
                
                hiloAuto1.start();
                hiloAuto2.start();
                hiloAuto3.start();
            }
        });
    }
}

