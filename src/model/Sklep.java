package model;

import java.util.ArrayList;
import java.util.List;

public class Sklep {

	private String www;

	private List<Produkt> produkty;

	public Sklep(String www) {
		this.www = www;
		this.produkty = new ArrayList<>();

	}

	public void dodajProdukt(Produkt produkt) {
		produkty.add(produkt);
	}

	public void usunProdukt(int index) {
		if (index>produkty.size()){
			System.out.println("Nie ma produktu o indeksie: " + index);
		}else
		produkty.remove(index-1);
	}

	public void wyswietlListe() {
		System.out.println("Lista produktow:");
		for (int i = 0; i < produkty.size(); i++) {
			System.out.println(i + 1 + ". " + produkty.get(i).toString());
		}
	}
	
	public Produkt znajdzProdukt(int index){
		return produkty.get(index-1);	
	}

	public void zmodyfikujProdukt(int index, Produkt produkt) {
		produkty.set(index-1, produkt);
	}
	
	public boolean sprwadzCzyListaPusta(){
		return produkty.isEmpty();
	}
	
	public boolean czyIstnieje(int index){
		return (index-1 < produkty.size() && index-1 >= 0);
	}

	public void wyswietlRabaty() {
		for (Produkt produkt : produkty){
			System.out.println(produkt.dajRabat());
		}
		
	}

	public void wyswietlCertyfikaty() {
		for (Produkt produkt : produkty){
			if (produkt instanceof UrzadzeniaElektroniczne){
				UrzadzeniaElektroniczne ue = (UrzadzeniaElektroniczne) produkt;
				ue.wyswietlCertyfikatZgodnosci();
			}
		}
		
	}

}
