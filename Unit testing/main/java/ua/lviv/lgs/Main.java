package ua.lviv.lgs;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws Exception {

		Time[] timeOfSeances = { new Time(14, 00), new Time(16, 00), new Time(18, 00) };

		Cinema c = new Cinema();

		c.addData();

		while (true) {
			Menu();
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();

			switch (number) {
			case 1: {
				c.printSchedule();
				break;
			}
			case 2: {
				c.addSeance();
				break;
			}
			case 3: {
				c.addMovie(timeOfSeances);
				break;
			}

			case 4: {
				c.removeSeance();
				break;

			}
			case 5: {
				c.removeMovie();
				break;
			}
			}

		}

	}

	static void Menu() {
		System.out.println("\n--------------------\n" + "\n1. Print scheule" + "\n2. Add seance" + "\n3. Add movie"
				+ "\n4. Remove seance" + "\n5. Remove movie" + "\n6. ---" + "\n7. ---"
				+ "\n8. ---" + "\n9. --- " + "\n--------------------\n");

	}
}
