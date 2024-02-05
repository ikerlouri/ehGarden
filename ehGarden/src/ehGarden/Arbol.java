package ehGarden;

import java.sql.Date;

public class Arbol {

	
	private int id;
	private String nombreComun;
	private String nombreCientifico;
	private Habitat habitat;
	private int altura;
	private Date fecha_encontrada;
	private boolean singular;
	
	public int getId() {
		return id;
	}
	public String getNombreComun() {
		return nombreComun;
	}
	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}
	public String getNombreCientifico() {
		return nombreCientifico;
	}
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public Habitat getHabitat() {
		return habitat;
	}
	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}
	public Date getFecha_encontrada() {
		return fecha_encontrada;
	}
	public void setFecha_encontrada(Date fecha_encontrada) {
		this.fecha_encontrada = fecha_encontrada;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public boolean isSingular() {
		return singular;
	}
	public void setSingular(boolean singular) {
		this.singular = singular;
	}
	
	
	
	public Arbol(int id, String nombreComun, String nombreCientifico, Habitat habitat, int altura, Date fecha_encontrada) {
		super();
		this.id = id;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.habitat = habitat;
		this.altura = altura;
		this.fecha_encontrada = fecha_encontrada;
	}
	
	
	public Arbol() {
		super();
	}
	


	
	
}
