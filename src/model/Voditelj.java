package model;

import java.util.Objects;

public class Voditelj {

	private Integer id;
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String password;

	public Voditelj() {
		super();
	}

	public Voditelj(String ime, String prezime, String korisnickoIme, String password) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ime, korisnickoIme, password, prezime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voditelj other = (Voditelj) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(korisnickoIme, other.korisnickoIme)
				&& Objects.equals(password, other.password) && Objects.equals(prezime, other.prezime);
	}

	@Override
	public String toString() {
		return "Admin [ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", password="
				+ password;
	}
}
