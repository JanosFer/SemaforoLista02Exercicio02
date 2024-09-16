package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredores extends Thread{
	private final int TID = (int) getId();
	private Semaphore semaforo;
	
	public ThreadCorredores(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	public void run() {
		corredor();
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
	}
	
	private void corredor() {
		int corredor = 200;
		int caminhou = 0;
		
		while(caminhou < corredor) {
			int velocidade = (int) (Math.random() * 5) + 2;
			caminhou += velocidade;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	private void porta() {
		int porta = (int) (Math.random() * 2) + 1;
		
		try {
			Thread.sleep(porta);
			System.out.println(TID + "# Pessoa chegou ao final do corredor e passou pela porta.");
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}
