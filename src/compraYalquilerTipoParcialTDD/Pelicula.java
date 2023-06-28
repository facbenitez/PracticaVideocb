package compraYalquilerTipoParcialTDD;

import java.util.ArrayList;
import java.util.List;

public class Pelicula extends Producto implements Vendible, Alquilable{
	
	private GeneroDePelicula genero;
	private Integer anioDeEstreno;
	private String director;
	private List<String>actores;
	private Double precioVenta;
	private Double precioAlquiler;
	private Integer edadMinimaParaAlquilar;


	public Pelicula(Integer codigo, String descripcion,GeneroDePelicula genero,Integer anioDeEstreno,String director, EstadoDelProducto estadoActual) {
		super(codigo, descripcion, estadoActual);
		this.genero=genero;
		this.anioDeEstreno=anioDeEstreno;
		this.director=director;
		this.actores=new ArrayList<>();
		this.precioVenta=0.0;
		this.precioAlquiler=0.0;
		this.edadMinimaParaAlquilar=0;
	}

	public GeneroDePelicula getGenero() {
		return genero;
	}

	public void setGenero(GeneroDePelicula genero) {
		this.genero = genero;
	}

	public Integer getAnioDeEstreno() {
		return anioDeEstreno;
	}

	public void setAnioDeEstreno(Integer anioDeEstreno) {
		this.anioDeEstreno = anioDeEstreno;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getActores() {
		return actores;
	}

	public void setActores(List<String> actores) {
		this.actores = actores;
	}

	public void agregarActor(String nuevoActor) {
		this.actores.add(nuevoActor);
		
	}

	public boolean actua(String actorEsperado) {
		Boolean actua=false;
		for (String string : actores) {
			if(string.equals(actorEsperado)) {
				actua=true;
				//return actua; 
			}
		}
		return actua;
	}

	@Override
	public Double getPrecioVenta() {
		// TODO Auto-generated method stub
		return precioVenta;
	}

	@Override
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta=precioVenta;
		
	}

	@Override
	public void setPrecioAlquiler(Double precioAlquiler) {
		this.precioAlquiler=precioAlquiler;
		
	}

	@Override
	public Double getPrecioAlquiler() {	
		// TODO Auto-generated method stub
		return precioAlquiler;
	}

	@Override
	public Integer getEdadMinimaParaAlquilar() {
		// TODO Auto-generated method stub
		return edadMinimaParaAlquilar;
	}

	public void setEdadMinimaParaAlquilar(Integer edadMinimaParaAlquilar) {
		this.edadMinimaParaAlquilar=edadMinimaParaAlquilar;
	}


	
}
