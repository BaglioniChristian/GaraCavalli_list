import java.io.FileWriter;
import java.io.IOException;

public class Cavallo extends Thread {

    private final String name;
    private int lentezza;
    private FileWriter file;

    public Cavallo(String name, int lentezza, FileWriter file) {
        super();
        this.name = name;
        this.lentezza = lentezza;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            file.write("Cavallo " + name + " comincia il suo galoppo\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 1; i <= 10; i++) {
            try {
                sleep(lentezza);
            } catch (InterruptedException e) {
                try {
                    file.write(" Cavallo " + name + " è stato azzoppato e si ferma!\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                return;
            }
            try {
                file.write(name + " cavalca - passo: " + i + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (Main.getPrimo().equals("")) {
            Main.setPrimo(this.name);
        }
    }

    protected int getLentezza() {
        return lentezza;
    }

    protected void setLentezza(int lentezza) {
        this.lentezza = lentezza;
    }

    protected String getNameCavallo() {
        return name;
    }
}
