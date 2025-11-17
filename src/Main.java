import javax.swing.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        // --- FILECHOOSER PER SELEZIONARE FILE DI OUTPUT ---
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleziona il file in cui salvare l'output della gara dei cavalli");

        int scelta = fileChooser.showSaveDialog(null);

        if (scelta != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null,
                    "Nessun file selezionato. Programma terminato.");
            return;
        }

        File fileOutput = fileChooser.getSelectedFile();

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileOutput));

            GaraWriter gw = new GaraWriter(writer);

            GaraCavalli gara = new GaraCavalli(gw);
            gara.avviaGara();

            writer.close();

            JOptionPane.showMessageDialog(null,
                    "Gara terminata!\nFile salvato in:\n" + fileOutput.getAbsolutePath());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore nella scrittura del file!");
            e.printStackTrace();
        }
    }
}

