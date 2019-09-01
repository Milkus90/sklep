package model;
import java.math.BigDecimal;

public class Szkolenie extends Produkt {
	
	private String technologia;
	
	public Szkolenie (String nazwa, String technologia, BigDecimal cena){
		super(cena, nazwa);
		this.technologia = technologia;

	}

	public String getTechnologia() {
		return technologia;
	}

	public void setTechnologia(String technologia) {
		this.technologia = technologia;
	}

	
	@Override
	public String toString() {
		return "Szkolenie [nazwa: " + nazwa + ", technologia: " + technologia + ", cena: " + cena + "]";
	}

	public void zaktualizuj(String nazwa, String technologia, BigDecimal cena){
		super.cena = cena;
		super.nazwa = nazwa;
		this.technologia = technologia;
	}
	
	public String dajRabat(){
		return toString() + " Rabat - 15%.";
	}
	
	
}
