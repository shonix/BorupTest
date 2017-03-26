package Domain;
/*
    Database-koden for varer-table
   	CREATE TABLE medlemmer(
	ID int NOT NULL AUTO_INCREMENT,
 	Fornavn varchar(255) NOT NULL,
	Efternavn varchar(255) NOT NULL,
  	Adresse varchar (255),
  	F�dselsdato int(6) NOT NULL,
	Telefon int (10),
	Email varchar (255),
	NavnP�D�r varchar (255),
	Billeder TINYINT (1),
	PRIMARY KEY (ID)
	)
*/

/**
 * Medlem objekt. Dette bruges til at holde information fra databasen,<br>
 * Getters og Setters er tilg�ngelige for hver v�rdi.
 * 
 * <p>Indeholder toString() override som lader Medlem objekter s�ttes nemt ind i en mySQL syntax
 * @author PeterRaasth�j
 *
 */
public class Medlem{
	private int id;
	private String fornavn;
	private String efternavn;
	private String adresse;
	private String f�dselsdato;
	private String telefon;
	private String email;
	private String navnP�D�r;
	private	int billeder;

	public Medlem(int id, String fornavn, String efternavn, String adresse, String f�dselsdato, String telefon, String email, String navnP�D�r, int billeder){
		this.id = id;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.adresse = adresse;
		this.f�dselsdato = f�dselsdato;
		this.telefon = telefon;
		this.email = email;
		this.navnP�D�r = navnP�D�r;
		this.billeder = billeder;
		
	}

	public String toString(){
		return (String) ("'"+this.id+"'" + ", " + "'"+this.fornavn+"'" + ", " + "'"+this.efternavn+"'" + ", " + "'"+this.adresse+"'" + ", "+"'" + this.f�dselsdato +"'"+ ", "+"'" + this.telefon +"'"+ ", " + "'"+this.email+"'" + ", " + "'"+this.navnP�D�r+"'" + ", " + "'"+this.billeder+"'");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEfternavn() {
		return efternavn;
	}

	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getF�dselsdato() {
		return f�dselsdato;
	}

	public void setF�dselsdato(String f�dselsdato) {
		this.f�dselsdato = f�dselsdato;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNavnP�D�r() {
		return navnP�D�r;
	}

	public void setNavnP�D�r(String navnP�D�r) {
		this.navnP�D�r = navnP�D�r;
	}

	public int getBilleder() {
		return billeder;
	}

	public void setBilleder(int billeder) {
		this.billeder = billeder;
	}
	
	
}

