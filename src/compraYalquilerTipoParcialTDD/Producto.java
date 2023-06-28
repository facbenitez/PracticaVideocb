package compraYalquilerTipoParcialTDD;

public abstract class Producto {
		
	private Integer codigo;
	private String descripcion;
	private EstadoDelProducto estadoActual;
	private Cliente quienPoseeElProducto;
		
	public Producto(Integer codigo, String descripcion,EstadoDelProducto estadoActual) {
			
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estadoActual=EstadoDelProducto.DISPONIBLE;

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 
		
	public EstadoDelProducto getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(EstadoDelProducto estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Cliente getQuienPoseeElProducto() {
		
		return quienPoseeElProducto;
	}
		
	public void setQuienPoseeElProducto(Cliente quienPoseeElProducto) {
		this.quienPoseeElProducto = quienPoseeElProducto;
	}
		

}


