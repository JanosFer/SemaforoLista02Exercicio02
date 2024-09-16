package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorredores;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for(int i = 0; i < 4; i++) {
			ThreadCorredores t = new ThreadCorredores(semaforo);
			t.start();
		}
	}

}
