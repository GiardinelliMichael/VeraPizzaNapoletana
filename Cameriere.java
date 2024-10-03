package pizza;

public class Cameriere extends Thread{
	
	 private Pizzeria pizzeria;

	    public Cameriere(Pizzeria pizzeria) {
	        this.pizzeria = pizzeria;
	    }

	    public void run() {
	        while (true) {
	            int persone = (int) (Math.random() * 4) + 1; // Persone da 1 a 4
	            int tavolo = (int) (Math.random() * 20); // Tavolo da 0 a 19
	            if (Math.random() < 0.5) {
	                // Prende l'ordine
	                pizzeria.prendiOrdine(tavolo, persone);
	            } else {
	                // Porta le pizze
	                pizzeria.portaPizze(tavolo, persone);
	            }

	            try {
	                Thread.sleep(1000); // Tempo per servire o prendere l'ordine
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	                break;
	            }
	        }
	    }
}
