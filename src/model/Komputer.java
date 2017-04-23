package model;

import java.math.BigDecimal;

public class Komputer extends Produkt implements UrzadzeniaElektroniczne {
	
	private String cpu;
	private String ram;
	
	public Komputer(BigDecimal cena, String nazwa, String cpu, String ram) {
		super(cena, nazwa);
		this.cpu = cpu;
		this.ram = ram;
	}


	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Komputer [cpu=" + cpu + ", ram=" + ram + ", cena=" + cena + ", nazwa=" + nazwa + "]";
	}


	public void zaktualizuj(BigDecimal cena, String nazwa, String cpu, String ram) {
		this.setCena(cena);
		this.setCpu(cpu);
		this.setNazwa(nazwa);
		this.setRam(ram);
		
	}
	public String dajRabat(){
		return toString() + " Rabat - 10%.";
	}


	@Override
	public void wyswietlCertyfikatZgodnosci() {
		System.out.println(toString() + " - Certyfikat komputera.");
		
	}
}
