package jd.piano.programa;

import jd.piano.teclas.Piano;
import jd.piano.teclas.Tecla;

import javax.sound.midi.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMidi implements Receiver {
    private static final Color[] COLORES = {
            Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
            Color.ORANGE, Color.PINK, Color.CYAN, Color.MAGENTA,
            Color.WHITE, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY,
            Color.DARK_GRAY, new Color(255, 0, 255), new Color(0, 255, 255), new Color(255, 255, 0)
    };

    private Piano piano;

    public ReproductorMidi() {
        this.piano = null;
    }

    public void conectar(Piano piano) {
        this.piano = piano;
    }

    public void reproducir(String rutaMidi)  {
        try {
            Sequence sequence = MidiSystem.getSequence(new File(rutaMidi));
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Transmitter transmitter = sequencer.getTransmitter();
            transmitter.setReceiver(this);

            sequencer.setSequence(sequence);
            sequencer.start();

            long duracion = sequence.getMicrosecondLength();
            Thread.sleep(duracion / 1000);

            transmitter.close();
            sequencer.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        if (!(message instanceof ShortMessage)) return;

        ShortMessage sm = (ShortMessage) message;
        int canal = sm.getChannel();

        if (canal == 9) return;

        int nota = sm.getData1();
        if (piano == null) return;

        Tecla tecla = piano.getTecla(canal,nota);
        if (tecla == null) return;

        int comando = sm.getCommand();
        if (comando == ShortMessage.NOTE_ON) {
            int velocidad = sm.getData2();
            if (velocidad > 0) {
                tecla.setColorPulsado(COLORES[canal % COLORES.length]);
                tecla.pulsar();
            } else {
                tecla.soltar();
            }
        } else if (comando == ShortMessage.NOTE_OFF) {
            tecla.soltar();
        }

        tecla.dibujar();
    }

    @Override
    public void close() {
    }
}