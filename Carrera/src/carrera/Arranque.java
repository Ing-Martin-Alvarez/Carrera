//Martin Alvarez Salazar 19460870
package carrera;

import javax.swing.JLabel;


public class Arranque extends Thread{
    private int posicioninicialx, limitepista, velocidad;
    private JLabel auto;
    
    public Arranque(int posicioninicialx, int limitepista, JLabel auto, int velocidad){
        this.posicioninicialx=posicioninicialx;
        this.limitepista = limitepista;
        this.auto = auto;
        this.velocidad = velocidad;
    }
    @Override
    public void run(){
        for(int i=limitepista; i > 0;i--){
            auto.setBounds(posicioninicialx, i, 100, 100);
            try{
                sleep(200/velocidad);
            }catch(InterruptedException e){
                System.out.println("Exception "+e);
            }
        }
    }
}
