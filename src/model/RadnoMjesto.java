package model;

import java.util.Objects;

public class RadnoMjesto {

	private Integer id;
	private String radnoMjesto;

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

	@Override
	public int hashCode() {
		return Objects.hash(radnoMjesto);
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
		return Objects.equals(radnoMjesto, other.radnoMjesto);
	}

	@Override
	public String toString() {
		return "RadnoMjesto [radnoMjesto=" + radnoMjesto + ", zaposlenik=" + "]";
	}
}
