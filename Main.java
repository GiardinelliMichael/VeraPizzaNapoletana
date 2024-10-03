package pizza;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pizzeria pizzeria = new Pizzeria();

        // Avvio del forno
        Forno forno = new Forno(pizzeria);
        forno.start();

        // Avvio di 3 camerieri
        for (int i = 0; i < 3; i++) {
            Cameriere cameriere = new Cameriere(pizzeria);
            cameriere.start();
        }

        // Esegui per un tempo limitato
        try {
            Thread.sleep(30000); // Simula per 30 secondi
        } catch (InterruptedException e) {
        }

        // Termina il programma
        forno.interrupt(); // interrupt() è un metodo che uso per fermare il forno
    }
}

