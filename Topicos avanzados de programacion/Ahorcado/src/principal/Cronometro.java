/*
 * Cronometro para el juego
 */

package principal;

/**
 *
 * @author Paulo Andrade
 */

import javax.swing.JLabel;

public class Cronometro extends JLabel implements Runnable
{
    public static int onoff = 0;
    JLabel tiempo;
    Thread hilo;
    boolean cronometroActivo, pausar, ctrPausa = false;
    
    // Constructor
    public Cronometro()
    {
        super("00:00:000");
    }

    @Override
    public void run()
    {
        Integer minutos = 0 , segundos = 0, milesimas = 0;
        //min es minutos, seg es segundos y mil es milesimas de segundo
        String min="", seg="", mil="";
        
        try {
            while(pausar){
            //Mientras cronometroActivo sea verdadero entonces seguira
            //aumentando el tiempo
                while( cronometroActivo ) {
                    Thread.sleep( 4 );
                    //Incrementamos 4 milesimas de segundo
                    milesimas += 4;
                    //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                    //y las milesimas de segundo de nuevo a 0
                    if( milesimas == 1000 ) {
                        milesimas = 0;
                        segundos += 1;
                        //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                        //y los segundos vuelven a 0
                        if( segundos == 60 )
                        {
                            segundos = 0;
                            minutos++;
                        }
                    }

                    //Esto solamente es estetica para que siempre este en formato
                    //00:00:000
                    if( minutos < 10 ) min = "0" + minutos;
                    else min = minutos.toString();
                    if( segundos < 10 ) seg = "0" + segundos;
                    else seg = segundos.toString();

                    if( milesimas < 10 ) mil = "00" + milesimas;
                    else if( milesimas < 100 ) mil = "0" + milesimas;
                    else mil = milesimas.toString();

                    //Colocamos en la etiqueta la informacion
                    setText( min + ":" + seg + ":" + mil );
                    /*while(pausar){
                        tiempo.setText( min + ":" + seg + ":" + mil );
                    }*/
                }
            setText( min + ":" + seg + ":" + mil );
            }
        }catch(Exception e){
            System.out.println("Ya valió :P, error en el run");
        }
        
        //Cuando se reincie se coloca nuevamente en 00:00:000
        setText( "00:00:000" );
    }

    //Iniciar el cronometro poniendo cronometroActivo 
    //en verdadero para que entre en el while
    public void iniciarCronometro() {
    	if(ctrPausa){
        	cronometroActivo = true;
        	pausar = true;
        	ctrPausa = false;
        } else {
        	cronometroActivo = true;
        	pausar = true;
        	hilo = new Thread( this );
        	hilo.start();
        }
    }

    //Esto es para parar el cronometro
    public void pararCronometro(){
        cronometroActivo = false;
        pausar = true ;
        ctrPausa = true;
    }

    public void reiniciarCronometro(){
        cronometroActivo = false;
        pausar = false;
        ctrPausa = false;
    }
}
