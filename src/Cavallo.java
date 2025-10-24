public class Cavallo extends Thread{

    private final String name;
    private int lentezza;
    public Cavallo(String name, int lentezza) {
        super();
        this.name = name;
        this.lentezza = lentezza;
    }
    /**override del metodo run */
    @Override
    public void run(){
        System.out.println("Cavallo " +
                name + " comincia il suo galoppo");
        for (int i = 1; i <= 10; i++) {
            try {
                sleep(lentezza);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name +" cavalca - passo: " + i);
        }
        if(Main.getPrimo().equals("")){
            Main.setPrimo(this.name);
        }
    }
    /**getter per il parametro di lentezza SUPERFLUI*/
    protected int getLentezza(){
        return lentezza;
    }
    /**setter per il parametro di lentezza */
    protected void setLentezza(int lentezza){
        this.lentezza=lentezza;
    }
}
