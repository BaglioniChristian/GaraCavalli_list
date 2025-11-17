import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String primo = "";
    static FileWriter file; // writer globale

    public static void main(String[] args) {

        // --- FILECHOOSER PER SCEGLIERE IL FILE DI OUTPUT ---
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Scegli il file di output della gara");
        int scelta = chooser.showSaveDialog(null);

        if (scelta != JFileChooser.APPROVE_OPTION) {
            System.out.println("Nessun file selezionato. Programma terminato.");
            return;
        }

        File fileSelezionato = chooser.getSelectedFile();

        try {
            file = new FileWriter(fileSelezionato);
        } catch (IOException e) {
            System.out.println("Errore nell'apertura del file.");
            return;
        }

        Scanner input = new Scanner(System.in);
        String tmpS;
        int tmp;
        ArrayList<Cavallo> listaCavallo = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            System.out.println("Inserisci il nome del cavallo " + i);
            tmpS = input.nextLine();
            System.out.println("Inserisci la lentezza del cavallo " + i);
            tmp = input.nextInt();
            input.nextLine(); // consuma ritorno a capo

            Cavallo c = new Cavallo(tmpS, tmp, file);
            listaCavallo.add(c);
        }

        // avvio dei thread
        for (Cavallo c : listaCavallo) {
            c.start();
        }

        // cavallo azzoppato
        Random r = new Random();
        int indexAzzoppato = r.nextInt(listaCavallo.size());
        Cavallo cavalloAzzoppato = listaCavallo.get(indexAzzoppato);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            file.write("Il cavallo " + cavalloAzzoppato.getNameCavallo() + " è stato azzoppato!\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        cavalloAzzoppato.interrupt();

        // attesa fine thread
        for (Cavallo c : listaCavallo) {
            try {
                c.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            file.write("Il primo cavallo: " + primo + "\n");
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPrimo() {
        return primo;
    }

    public static void setPrimo(String primo) {
        Main.primo = primo;
    }
}
