package b;

public class Robot {

	public static final int SIZE = 10;
	public static int[][] map = new int[SIZE][SIZE];
	public int x, y;

	public Robot() {
		x = SIZE / 2;
		y = SIZE / 2;
		map[x][y] = 1;
	}

	public void Esquerra() {
		if (y > 0) {
			System.out.println("Esquerra");
			map[x][y] = 0;
			map[x][y - 1] = 1;
			y--;
		}
	}

	public void Dreta() {
		if (y < SIZE - 1) {
			System.out.println("Dreta");
			map[x][y] = 0;
			map[x][y + 1] = 1;
			y++;
		}
	}

	public void Amunt() {
		if (x > 0) {
			System.out.println("Amunt");
			map[x][y] = 0;
			map[x - 1][y] = 1;
			x--;
		}
	}

	public void Avall() {
		if (x < SIZE - 1) {
			System.out.println("Avall");
			map[x][y] = 0;
			map[x + 1][y] = 1;
			x++;
		}
	}

	public void Balla(Integer i) {
		System.out.println("El robot balla sensualment");
		System.out.println(i);
		map[x][y] = i;
	}
	
	
	

}
