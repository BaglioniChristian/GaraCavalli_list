import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String primo = "";
    static FileWriter file; // writer globale in stile C

    public static void main(String[] args) {
        try {
            file = new FileWriter("gara_cavalli.txt"); // apertura file
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            input.nextLine(); // consuma il \n
            Cavallo c = new Cavallo(tmpS, tmp, file); // passiamo writer
            listaCavallo.add(c);
        }

        for (Cavallo c : listaCavallo) {
            c.start();
        }

        Random r = new Random();
        int indexAzzoppato = r.nextInt(listaCavallo.size());
        Cavallo cavalloAzzoppato = listaCavallo.get(indexAzzoppato);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            file.write(" Il cavallo " + cavalloAzzoppato.getNameCavallo() + " è stato azzoppato!\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        cavalloAzzoppato.interrupt();

        for (Cavallo c : listaCavallo) {
            try {
                c.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            file.write("Il primo cavallo: " + primo + "\n");
            file.close(); // chiusura file
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
