package pizza;

public class Pizzeria extends Thread{
	
	 private Tavolo[] tavoli;
	    private int pizzeDisponibili = 0;

	    public Pizzeria() {
	        this.tavoli = new Tavolo[20];
	        for (int i = 0; i < 20; i++) {
	            tavoli[i] = new Tavolo();
	        }
	    }

	    public synchronized void produciPizze(int pizze) {
	        pizzeDisponibili += pizze;
	        System.out.println("Forno ha prodotto " + pizze + " pizze. Pizze disponibili: " + pizzeDisponibili);
	        notifyAll();
	    }

	    public synchronized void prendiOrdine(int tavolo, int persone) {
	        if (tavoli[tavolo].getNumeroPersone() + persone <= 5) { // Supponiamo che ogni tavolo possa avere al massimo 5 persone
	            tavoli[tavolo].occupaTavolo(persone);
	            System.out.println("Cameriere ha preso ordine per " + persone + " persone al tavolo " + tavolo);
	        } else {
	            System.out.println("Tavolo " + tavolo + " pieno, non possono entrare " + persone + " persone.");
	        }
	    }

	    public synchronized void portaPizze(int tavolo, int persone) {
	        if (pizzeDisponibili > 0) {
	            tavoli[tavolo].liberaTavolo(persone);
	            pizzeDisponibili--;
	            System.out.println("Cameriere ha servito pizze al tavolo " + tavolo + " per " + persone + " persone. Pizze rimanenti: " + pizzeDisponibili);
	            notifyAll();
	        } else {
	            System.out.println("Nessuna pizza disponibile per il tavolo " + tavolo);
	        }
	    }
}
