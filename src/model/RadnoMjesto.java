package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RadnoMjesto {
	
	private Integer id;
	private String radnoMjesto;
	private List<Zaposlenik> zaposlenik = new ArrayList<Zaposlenik>();
	
	public RadnoMjesto() {
		super();
	}
	public RadnoMjesto(String radnoMjesto) {
		super();
		this.radnoMjesto = radnoMjesto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRadnoMjesto() {
		return radnoMjesto;
	}
	public void setRadnoMjesto(String radnoMjesto) {
		this.radnoMjesto = radnoMjesto;
	}
	
	public List<Zaposlenik> getZaposlenik() {
		return zaposlenik;
	}
	public void setZaposlenik(List<Zaposlenik> zaposlenik) {
		this.zaposlenik = zaposlenik;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(radnoMjesto, zaposlenik);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadnoMjesto other = (RadnoMjesto) obj;
		return Objects.equals(radnoMjesto, other.radnoMjesto) && Objects.equals(zaposlenik, other.zaposlenik);
	}
	@Override
	public String toString() {
		return "RadnoMjesto [radnoMjesto=" + radnoMjesto + ", zaposlenik=" + zaposlenik + "]";
	}
	
}
