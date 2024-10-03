package pizza;

import java.util.Random;

public class Forno extends Thread{
	
	private Pizzeria pizzeria;
    private Random random = new Random();

    public Forno(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    public void run() {
        while (true) {
            int pizze = random.nextInt(8) + 1; // Produce da 1 a 8 pizze
            pizzeria.produciPizze(pizze);

            try {
                Thread.sleep(random.nextInt(2000) + 1000); // Tempo di produzione casuale tra 1 e 3 secondi
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
