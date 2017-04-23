package ui;

import java.math.BigDecimal;
import java.util.Scanner;

import model.Komputer;
import model.Produkt;
import model.Sklep;
import model.Szkolenie;

public class Menu {

	public void wyswietlMenu() {

		String nazwa, cpu, ram, technologia;
		BigDecimal cena;
		Scanner scan = new Scanner(System.in);
		Sklep sklep = new Sklep("www.jacek.pl");
		String menu = "0";
		do {
			System.out.println("\nCo chcesz zrobic? [Wybierz odpowiedni nr]:");
			System.out.println("1. Dodaj komputer.");
			System.out.println("2. Dodaj szkolenie.");
			System.out.println("3. Usun produkt.");
			System.out.println("4. Modyfikuj komputer.");
			System.out.println("5. Wyswietl produkty.");
			System.out.println("6. Wyswietl rabaty.");
			System.out.println("7. Wyswietl certyfikaty.");
			System.out.println("q - Wyjdz z programu.");
			menu = scan.next();
			System.out.println();
			switch (menu) {
			case "1": {
				System.out.print("Podaj nazwe komputera:");
				nazwa = scan.next();
				System.out.print("Podaj cene komputera:");
				cena = scan.nextBigDecimal();
				scan.nextLine();
				System.out.print("Podaj cpu komputera:");
				cpu = scan.next();
				System.out.print("Podaj ram komputera:");
				ram = scan.next();
				Komputer komp = new Komputer(cena, nazwa, cpu, ram);
				sklep.dodajProdukt(komp);
				break;
			}
			case "2": {
				System.out.print("Podaj nazwe szkolenia:");
				nazwa = scan.next();
				System.out.print("Podaj cene szkolenia:");
				cena = scan.nextBigDecimal();
				scan.nextLine();
				System.out.print("Podaj technologie szkolenia:");
				technologia = scan.next();
				Szkolenie szkolenie = new Szkolenie(nazwa, technologia, cena);
				sklep.dodajProdukt(szkolenie);
				break;

			}
			case "3" : {
				if (sklep.sprwadzCzyListaPusta()) {
					System.out.println("Brak produktow w bazie.");
				} else {
					sklep.wyswietlListe();
					System.out.print("Podaj index produktu, ktory chcesz usunac: ");
					int index = scan.nextInt();
					scan.nextLine();
					if (sklep.czyIstnieje(index)) {
						sklep.usunProdukt(index);
					} else {
						System.out.println("Produkt o indeksie '" + index + "' nie istnieje.");
					}
				}
				break;
			}
			case "4" : { // dopisany {blok} aby zmienne byly widoczne tylko tu, np.
						// index albo tak, albo deklaracja przed
						// switchem - jak nazwa, cpu itd
				if (sklep.sprwadzCzyListaPusta()) {
					System.out.println("Brak produktow w bazie.");
				} else {
					sklep.wyswietlListe();
					System.out.print("Podaj index komputera, ktory chcesz edytowac: ");
					int index = scan.nextInt();
					scan.nextLine();
					if (sklep.czyIstnieje(index)) {
						Produkt produkt = sklep.znajdzProdukt(index);
						if (produkt instanceof Komputer) {
							Komputer komputer = (Komputer) sklep.znajdzProdukt(index);
							System.out.print("Podaj nowa nazwe komputera (aktualna: " + komputer.getNazwa() + "): ");
							nazwa = scan.next();
							System.out.print("Podaj nowa cene komputera (aktualna: " + komputer.getCena() + "): ");
							cena = scan.nextBigDecimal();
							scan.nextLine();
							System.out.print("Podaj nowy cpu komputera (aktualna: " + komputer.getCpu() + "): ");
							cpu = scan.next();
							System.out.print(
									"Podaj nowa ilosc pamieci ram komputera(aktualna: " + komputer.getRam() + "): ");
							ram = scan.next();

							komputer.zaktualizuj(cena, nazwa, cpu, ram);

							sklep.zmodyfikujProdukt(index, komputer);
						} else {
							System.out.println("To nie jest komputer!!!");
						}
					} else {
						System.out.println("Produkt o indeksie '" + index + "' nie istnieje.");
					}
				}
				break;
			}
			case "5" :
				if (sklep.sprwadzCzyListaPusta()) {
					System.out.println("Brak produktow w bazie.");
				} else {
					sklep.wyswietlListe();
				}
				break;
			case "6" :{
				sklep.wyswietlRabaty();
				break;
			}
			case "7" :{
				sklep.wyswietlCertyfikaty();
				break;
			}
			case "q":
			case "Q":
				System.out.println("Do widzenia.");
				break;
			default:
				System.out.println("Wybrales zla cyfre. Sprobuj jeszcze raz.");
				break;
			}

		} while (!menu.equalsIgnoreCase("q"));

		scan.close();
	}
}
