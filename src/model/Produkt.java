package model;

import java.math.BigDecimal;

public abstract class Produkt {

	protected BigDecimal cena; // wszedzie gdzie zalezy na precyzyjnych
								// obliczeniach to BigDecimal
	protected String nazwa;
	protected int id;
	private static int generator = 0;			// static oznacza, ze jest jedna kopia tej zmiennej dla wszystkich obiektow

	public Produkt(BigDecimal cena, String nazwa) {
		this.cena = cena;
		this.nazwa = nazwa;
		generator++;
		this.id = generator;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public abstract String dajRabat();
	
	public static void wyswietlIloscObiektow(){
		System.out.println(generator);
	}
}

