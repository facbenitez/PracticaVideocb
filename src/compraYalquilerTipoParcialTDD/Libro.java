package compraYalquilerTipoParcialTDD;

public class Libro extends Producto implements Vendible{

	private String autor;
	private String editorial;
	private Double precioVenta;

	public Libro(Integer codigo, String descripcion,String autor,String editorial, EstadoDelProducto estadoActual) {
		super(codigo, descripcion, estadoActual);
		this.autor=autor;
		this.editorial=editorial;
		this.precioVenta=0.0;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public Double getPrecioVenta() {
		// TODO Auto-generated method stub
		return precioVenta;
	}

	@Override
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta=precioVenta;;
		
	}

	
}
