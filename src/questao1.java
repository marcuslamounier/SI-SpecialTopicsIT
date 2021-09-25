
public class questao1 {

	public static void main(String[] args) {
		int x = 1;
		int total = 0;
		
		while (x <= 10) {
			int y = x * x;
			total += y;
			x++;
		}
		
		System.out.printf("Total is %d%n", total);
	}

}
