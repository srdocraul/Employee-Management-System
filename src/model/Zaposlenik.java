package model;

import java.util.Date;
import java.util.Objects;

public class Zaposlenik {

	private Integer id;
	private String ime;
	private String prezime;
	private Date datumRodenja;
	private RadnoMjesto radnoMjesto;
	private Integer brojZaposlenika;

	public Zaposlenik() {
		super();
	}

	public Zaposlenik(String ime, String prezime, Date datumRodenja) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodenja = datumRodenja;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatumRodenja() {
		return datumRodenja;
	}

	public void setDatumRodenja(Date datumRodenja) {
		this.datumRodenja = datumRodenja;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public RadnoMjesto getRadnoMjesto() {
		return radnoMjesto;
	}

	public void setRadnoMjesto(RadnoMjesto radnoMjesto) {
		this.radnoMjesto = radnoMjesto;
	}

	public Integer getBrojZaposlenika() {
		return brojZaposlenika;
	}

	public void setBrojZaposlenika(Integer brojZaposlenika) {
		this.brojZaposlenika = brojZaposlenika;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brojZaposlenika, datumRodenja, ime, prezime, radnoMjesto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zaposlenik other = (Zaposlenik) obj;
		return Objects.equals(brojZaposlenika, other.brojZaposlenika)
				&& Objects.equals(datumRodenja, other.datumRodenja) && Objects.equals(ime, other.ime)
				&& Objects.equals(prezime, other.prezime) && Objects.equals(radnoMjesto, other.radnoMjesto);
	}

	@Override
	public String toString() {
		return "Zaposlenik [ime=" + ime + ", prezime=" + prezime + ", datumRodenja=" + datumRodenja + ", radnoMjesto="
				+ radnoMjesto + ", brojZaposlenika=" + brojZaposlenika + "]";
	}
}
