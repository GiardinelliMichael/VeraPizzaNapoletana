package pizza;

public class Tavolo {
	
	private int numeroPersone;

    public Tavolo() {
        this.numeroPersone = 0; // Inizialmente il tavolo è vuoto
    }

    public synchronized void occupaTavolo(int persone) {
        this.numeroPersone += persone;
        System.out.println("Tavolo occupato da " + persone + " persone. Totale persone: " + numeroPersone);
    }

    public synchronized void liberaTavolo(int persone) {
        this.numeroPersone -= persone;
        System.out.println("Tavolo liberato da " + persone + " persone. Totale persone: " + numeroPersone);
    }

    public synchronized int getNumeroPersone() {
        return numeroPersone;
    }
}
