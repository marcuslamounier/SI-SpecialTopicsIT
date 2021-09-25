
public class MergesortMultithread extends Thread {

	private int[] vetor;
	private int direito;
	private int esquerdo;
	
	public MergesortMultithread (int[] vetor, int esquerdo, int direito) {
		this.vetor = vetor;
		this.direito = direito;
		this.esquerdo = esquerdo;
	}
	
	
	@Override
	public void run() {
		if (esquerdo < direito) {
			int meio = (esquerdo + direito)/2;
			MergesortMultithread m1 = new MergesortMultithread(vetor, esquerdo, meio);
			MergesortMultithread m2 = new MergesortMultithread(vetor, meio+1, direito);
			
			m1.start();
			m2.start();
			
			try {
				m1.join();
				m2.join();
			}
			catch (InterruptedException e) {
				System.exit(-1);
			}
			
			intercala(esquerdo, meio, direito);
			
		}
	}
	
	private void intercala (int esquerdo, int meio, int direito) {
		int[] aux = new int[vetor.length];
		
		int i = esquerdo;
		int j = meio+1;
		int k = 0;
		
		while(i <= meio && j <= direito) {
			if (vetor[i] <= vetor[j]) {
				aux[k++] = vetor[i++];
			}
			else {
				aux[k++] = vetor[j++];
			}
		}
		
		while (i <= meio) {
			aux[k++] = vetor[i++];
		}
		
		while (j <= direito) {
			aux[k++] = vetor[j++];
		}
		
		for (i = esquerdo; i <= direito; i++) {
			vetor [i] = aux[i-esquerdo];
		}
	}

	
	
}
