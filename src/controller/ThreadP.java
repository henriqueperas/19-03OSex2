package controller;

import java.util.concurrent.Semaphore;

public class ThreadP extends Thread {
	
	private int idPrato;
	private static int posPreparo;
	private static int posEntrega;
	private Semaphore semaforo;
	
	public int resto;

	public ThreadP(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		pratoPreparando();
		try {
			semaforo.acquire();
			pratoEntregando();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			pratoFim();
		}
		
	}

	private void pratoFim() {
		posEntrega++;
		System.out.println("#" + idPrato + " foi o " + posEntrega + " a ser entregue ");
		
	}

	private void pratoEntregando() {
		
		System.out.println("#" + idPrato + " esta sendo entregue ");
		int tempo = 500;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void pratoPreparando() {
		int tempoPercorrido = 0;
		int tempoMs = 100;
		resto = idPrato % 2;
		if(resto == 1) {
			System.out.println("Preparando Sopa de Cebola # " + idPrato);
			int tempo = (int)((Math.random() * 301) + 500);
			while(tempoPercorrido < tempo) {
				tempoPercorrido += tempoMs;
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("#" + idPrato + " esta sendo preparado a " + tempoPercorrido + " ms");
			}
		}else if(resto == 0) {
			System.out.println("Preparando Lasanha a Bolonhesa # " + idPrato);
			int tempo1 = (int)((Math.random() * 601) + 600);
			while(tempoPercorrido < tempo1) {
				tempoPercorrido += tempoMs;
				try {
					sleep(tempo1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("#" + idPrato + " esta sendo preparado a " + tempoPercorrido + " ms");
			}
		}
		posPreparo++;
		System.out.println("#" + idPrato + " foi o " + posPreparo + " o. a terminar de preparar");
		
	}
	
}
