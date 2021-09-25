
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vetor = {500, 541, 25, 54,-60, 84165, 2564, 45, 66, 5};
		
		imprimir(vetor);
		
		MergesortMultithread m = new MergesortMultithread(vetor, 0, vetor.length-1);
		m.start();
		
		
		try {
			m.join();
		}
		catch (InterruptedException e){
			System.exit(-1);
		}
		
		imprimir(vetor);
		
	}
	
	private static void imprimir (int[] v) {
		for (int i=0; i<v.length; i++) {
			System.out.print(v[i] + " ");
		}
		System.out.println();
	}

}
