package Domain;
/*
 * CREATE TABLE barbog 
	(ID int primary key AUTO_INCREMENT,
    vigtignote varchar (255),
    saldo int (10));
 * @author dolph
 *
 */

/**
 * Barbog objekt. Dette bruges til at holde information fra databasen,<br>
 * Getters og Setters er tilg�ngelige for hver v�rdi.
 * 
 * <p>Indeholder toString() override som lader Barbog objekter s�ttes nemt ind i en mySQL syntax
 * @author PeterRaasth�j DanRydeng
 *
 */
public class Barbog {
	int id;
	String vigtigNote;
	int saldo;
	String navn;
	
	public Barbog(int id, String navn, String vigtigNote, int saldo) {
		super();
		this.navn = navn;
		this.id = id;
		this.vigtigNote = vigtigNote;
		this.saldo = saldo;
	}
	public String toString(){
		return (String) ("'"+this.id+"'" + ", " + "'"+this.vigtigNote+"'" + ", " + "'"+this.saldo+"'");
	}

	public String getNavn(){
		return navn;
	}
	
	public void setNavn(String navn){
		this.navn = navn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getVigtigNote() {
		return vigtigNote;
	}
	public void setVigtigNote(String vigtigNote) {
		this.vigtigNote = vigtigNote;
	}

	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	//unsure if proper style
	public void changeSaldo(int saldo) {
		this.saldo = this.saldo + saldo;
	}
	public String getVigtig() {
		return vigtigNote;
	}
}
