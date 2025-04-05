package jd.piano.programa;

import jd.piano.teclas.Piano;
import jd.piano.teclas.Tecla;

import javax.sound.midi.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMidi implements Receiver {
    private static final Color[] COLORES= {
            new Color(255, 0, 0),
            new Color(255, 64, 0),
            new Color(255, 128, 0),
            new Color(255, 191, 0),
            new Color(255, 255, 0),
            new Color(191, 255, 0),
            new Color(128, 255, 0),
            new Color(64, 255, 0),
            new Color(0, 255, 0),
            new Color(0, 255, 128),
            new Color(0, 255, 255),
            new Color(0, 128, 255),
            new Color(0, 0, 255),
            new Color(64, 0, 191),
            new Color(128, 0, 255),
            new Color(191, 0, 255)
    };

    private Piano piano;

    public ReproductorMidi(){
        this.piano= null;
    }

    public void reproducir(String ruta){
        try {
            Sequence sq = MidiSystem.getSequence(new File(ruta));
            Sequencer sr = MidiSystem.getSequencer();

            sr.open();
            Transmitter tr = sr.getTransmitter();

            tr.setReceiver(this);
            sr.setSequence(sq);
            sr.start();

            wait(sq.getMicrosecondLength()/1000);
            tr.close();
            sr.close();

        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void conectar(Piano p){
        this.piano=p;
    }


    @Override
    public void send(MidiMessage message, long timeStamp) {
        if(message instanceof ShortMessage m){
            if(m.getChannel()!=9){
                m.getCommand();
                Tecla tecla = this.piano.getTecla(m.getChannel(),m.getData1());
                if(tecla!=null){
                    int sm = m.getCommand();
                    if(sm==ShortMessage.NOTE_ON){
                        int volumen = m.getData2();
                        if(volumen>0){
                            tecla.setColorPulsado(COLORES[volumen-1]);
                            tecla.pulsar();
                            if(volumen==0 && sm==ShortMessage.NOTE_OFF){
                                tecla.soltar();
                                tecla.dibujar();
                            }
                        }

                    }
                }
            }
        }
    }

    @Override
    public void close() {

    }
}
