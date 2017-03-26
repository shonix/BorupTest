package Domain;

/*
 *  Database-koden for varer-table
CREATE TABLE varer(
ID int PRIMARY KEY AUTO_INCREMENT,
pris int (255) NOT NULL,
navn varchar (255) NOT NULL,
tilg�ngelig int (1),
antal int (6) NOT NULL);
 */

/**
 * Varer objekt. Dette bruges til at holde information fra databasen,<br>
 * Getters og Setters er tilg�ngelige for hver v�rdi.
 * 
 * <p>Indeholder toString() override som lader Varer objekter s�ttes nemt ind i en mySQL syntax
 * @author PeterRaasth�j DanRydeng 
 *
 */
public class Varer {
	int id;
	int pris;
	String navn;
	int tilg�ngelig;
	int antal;
	
	
	public Varer(int id, int pris, String navn, int tilg�ngelig, int antal){
		this.id = id;
		this.pris =pris;
		this.navn = navn;
		this.tilg�ngelig = tilg�ngelig;
		this.antal = antal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getTilg�ngelig() {
		return tilg�ngelig;
	}

	public void setTilg�ngelig(int tilg�ngelig) {
		this.tilg�ngelig = tilg�ngelig;
	}

	public int getAntal() {
		return antal;
	}

	public void setAntal(int antal) {
		this.antal = antal;
	}
	
}
