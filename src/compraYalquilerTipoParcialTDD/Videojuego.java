package compraYalquilerTipoParcialTDD;

public class Videojuego extends Producto implements Alquilable{

    private TipoDeConsola consola;
    private Double precioAlquiler;
    private Integer edadMinimaParaAlquilar;

	
	public Videojuego(Integer codigo, String descripcion, TipoDeConsola consola, EstadoDelProducto estadoActual) {
		super(codigo, descripcion, estadoActual);
		this.consola=consola;
		this.precioAlquiler=0.0;
		this.edadMinimaParaAlquilar=0;
	}

	public TipoDeConsola getConsola() {
		return consola;
	}

	public void setConsola(TipoDeConsola consola) {
		this.consola = consola;
	}

	@Override
	public void setPrecioAlquiler(Double precioAlquiler) {
		this.precioAlquiler=precioAlquiler;
		
	}

	@Override
	public Double getPrecioAlquiler() {
		return precioAlquiler;
	}

	@Override
	public Integer getEdadMinimaParaAlquilar() {	
		return edadMinimaParaAlquilar;
	}

	public void setEdadMinimaParaAlquilar(Integer edadMinimaParaAlquilar) {
		this.edadMinimaParaAlquilar=edadMinimaParaAlquilar;
	}
	
}
