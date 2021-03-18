package view;

import java.util.concurrent.Semaphore;

import controller.ThreadP;

public class Principal {

	public static void main(String[] args) {

		int permissoes = 5;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idPrato = 0; idPrato < 5; idPrato++) {
			Thread tPrato = new ThreadP(idPrato, semaforo);
			tPrato.start();
		}
		
	}

}
