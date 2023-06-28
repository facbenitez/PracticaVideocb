package compraYalquilerTipoParcialTDD;

import java.util.ArrayList;
import java.util.List;

public class Videoclub {
	private String nombre;
	private List<Producto>listaDeProductos;

	public Videoclub(String nombre) {
		this.nombre = nombre;
		this.listaDeProductos=new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean agregarProducto(Producto nuevoProducto) {
		return this.listaDeProductos.add(nuevoProducto);
	}
	
	public Producto buscarProducto(Producto productoABuscar) {
		Producto buscado=null;
		for (Producto producto : listaDeProductos) {
			if(producto.equals(productoABuscar)) {
				buscado=producto;
				return buscado;
			}
		}
		return buscado;
	}

	public Boolean vender(Producto productoAVender, Cliente clienteElQueCompra) {
		Producto productoABuscar=buscarProducto(productoAVender);
		if(productoABuscar!=null && productoABuscar.getEstadoActual()==EstadoDelProducto.DISPONIBLE && productoABuscar instanceof Vendible) {
			productoABuscar.setEstadoActual(EstadoDelProducto.VENDIDO);
			productoABuscar.setQuienPoseeElProducto(clienteElQueCompra);
			return true;
		}
		return false;
	}

	public Boolean alquilar(Producto productoAAlquilar, Cliente clienteElQueAlquila) {
		Producto productoABuscar=buscarProducto(productoAAlquilar);
		if(productoABuscar!=null && productoABuscar.getEstadoActual()==EstadoDelProducto.DISPONIBLE && productoABuscar instanceof Alquilable) {
		  if(((Alquilable)productoAAlquilar).getEdadMinimaParaAlquilar() <= clienteElQueAlquila.getEdad()) {
			  productoABuscar.setEstadoActual(EstadoDelProducto.ALQUILADO);
			  productoABuscar.setQuienPoseeElProducto(clienteElQueAlquila);
			  return true;
		  }
	   }
		return false;
	}

	public Boolean devolver(Producto productoADevolver) {
		Producto productoABuscar=buscarProducto(productoADevolver);
		if(productoABuscar!=null && productoABuscar.getEstadoActual()==EstadoDelProducto.ALQUILADO && productoABuscar instanceof Alquilable) {
			  productoABuscar.setEstadoActual(EstadoDelProducto.DISPONIBLE);
			  productoABuscar.setQuienPoseeElProducto(null);
			  return true;
		  }  
		
		return false;
	}

	
	

}
