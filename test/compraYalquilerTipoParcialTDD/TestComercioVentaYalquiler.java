package compraYalquilerTipoParcialTDD;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestComercioVentaYalquiler {

	@Test
	public void queSePuedaCrearUnaPelicula() {
		
		final Integer CODIGO_PELICULA = 1;
		final String DESCRIPCION = "Exterminators II";
		final GeneroDePelicula GENERO = GeneroDePelicula.ACCION;
		final Integer ANIO_DE_ESTRENO = 1993;
		final String DIRECTOR = "Carlos Galettini";
		final String ACTOR_1= "Guillermo Francella";
		final String ACTOR_2 = "Emilio Disi";
		final EstadoDelProducto ESTADO_PRODUCTO=EstadoDelProducto.DISPONIBLE;
		
		Pelicula pelicula = new Pelicula(CODIGO_PELICULA, DESCRIPCION, GENERO, ANIO_DE_ESTRENO, DIRECTOR,ESTADO_PRODUCTO);
		pelicula.agregarActor(ACTOR_1);
		pelicula.agregarActor(ACTOR_2);
		
		assertEquals(CODIGO_PELICULA, pelicula.getCodigo());
		assertEquals(DESCRIPCION, pelicula.getDescripcion());
		assertEquals(GENERO, pelicula.getGenero());
		assertEquals(ANIO_DE_ESTRENO, pelicula.getAnioDeEstreno());
		assertEquals(DIRECTOR, pelicula.getDirector());
		assertTrue(pelicula.actua(ACTOR_1));
		
	}
	
	@Test
	public void queSePuedaCrearUnVideojuego() {
		
		final Integer CODIGO_VIDEOJUEGO = 1;
		final String DESCRIPCION = "Fornite";
		final TipoDeConsola CONSOLA = TipoDeConsola.PLAY_STATION;
		final EstadoDelProducto ESTADO_PRODUCTO=EstadoDelProducto.DISPONIBLE;
		
		Videojuego juego = new Videojuego(CODIGO_VIDEOJUEGO, DESCRIPCION, CONSOLA,ESTADO_PRODUCTO);
		
		assertEquals(CODIGO_VIDEOJUEGO, juego.getCodigo());
		assertEquals(DESCRIPCION, juego.getDescripcion());
		assertEquals(CONSOLA, juego.getConsola());
		
	}
	
	@Test
	public void queSePuedaCrearUnLibro() {
	
		final Integer CODIGO_LIBRO = 1;
		final String DESCRIPCION = "Fifty Shades of Grey";
		final String AUTOR= "E. L. James";
		final String EDITORIAL = "Vintage Books";
		final EstadoDelProducto ESTADO_PRODUCTO=EstadoDelProducto.DISPONIBLE;
		
		Libro libro = new Libro(CODIGO_LIBRO, DESCRIPCION, AUTOR, EDITORIAL,ESTADO_PRODUCTO);
		
		assertEquals(CODIGO_LIBRO, libro.getCodigo());
		assertEquals(DESCRIPCION, libro.getDescripcion());
		assertEquals(AUTOR, libro.getAutor());
		assertEquals(EDITORIAL, libro.getEditorial());
		
	}
	
	
	@Test
	public void queUnaPeliculaSeaVendible() {
		
		final Integer CODIGO_PELICULA = 1;
		final String DESCRIPCION = "Exterminators II";
		final GeneroDePelicula GENERO = GeneroDePelicula.ACCION;
		final Integer ANIO_DE_ESTRENO = 1993;
		final String DIRECTOR = "Carlos Galettini";
		final Double PRECIO_VENTA = 5000.0;
		final EstadoDelProducto ESTADO_PRODUCTO=EstadoDelProducto.VENDIDO;
	
		Vendible pelicula = new Pelicula(CODIGO_PELICULA, DESCRIPCION, GENERO, ANIO_DE_ESTRENO, DIRECTOR,ESTADO_PRODUCTO);
		pelicula.setPrecioVenta(PRECIO_VENTA);
		
		assertEquals(PRECIO_VENTA, pelicula.getPrecioVenta());		
	}

	@Test
	public void queUnJuegoSeaAlquilable() {
		
		final Integer CODIGO_VIDEOJUEGO = 1;
		final String DESCRIPCION = "Fornite";
		final TipoDeConsola CONSOLA = TipoDeConsola.PLAY_STATION;
		final Double PRECIO_ALQUILER = 500.0;
		final EstadoDelProducto ESTADO_PRODUCTO=EstadoDelProducto.ALQUILADO;
		
		Alquilable juego = new Videojuego(CODIGO_VIDEOJUEGO, DESCRIPCION, CONSOLA,ESTADO_PRODUCTO);
		juego.setPrecioAlquiler(PRECIO_ALQUILER);
		
		assertEquals(PRECIO_ALQUILER, juego.getPrecioAlquiler());
		
	}

	@Test
	public void queSePuedaCrearUnCliente() {

		final Integer CODIGO_CLIENTE = 1;
		final String NOMBRE = "Camila";
		final String APELLIDO = "Oculto";
		final Integer EDAD = 23;
		
		Cliente nuevoCliente = new Cliente(CODIGO_CLIENTE, APELLIDO, NOMBRE, EDAD);
		
		assertEquals(CODIGO_CLIENTE, nuevoCliente.getCodigo());
		assertEquals(NOMBRE, nuevoCliente.getNombre());
		assertEquals(APELLIDO, nuevoCliente.getApellido());
		assertEquals(EDAD, nuevoCliente.getEdad());
		
	}

	@Test
	public void queSePuedaVenderUnLibro() {
		
		final Integer CODIGO_LIBRO = 1;
		final String DESCRIPCION = "Fifty Shades of Grey";
		final String AUTOR = "E. L. James";
		final String EDITORIAL = "Vintage Books";
		final String NOMBRE_VIDEOCLUB = "Blockbuster";
		final Integer CODIGO_CLIENTE = 1;
		final String NOMBRE = "Camila";
		final String APELLIDO = "Privado";
		final Integer EDAD = 23;
		final EstadoDelProducto ESTADO_INICIAL_PRODUCTO = EstadoDelProducto.DISPONIBLE;
		final EstadoDelProducto ESTADO_FINAL_PRODUCTO = EstadoDelProducto.VENDIDO;
		
		
		Videoclub video = new Videoclub(NOMBRE_VIDEOCLUB);
		Producto nuevoProducto = new Libro(CODIGO_LIBRO, DESCRIPCION, AUTOR, EDITORIAL,ESTADO_INICIAL_PRODUCTO);
		Cliente nuevoCliente = new Cliente(CODIGO_CLIENTE, APELLIDO, NOMBRE, EDAD);
		
		video.agregarProducto(nuevoProducto);
		
		
		assertEquals(ESTADO_INICIAL_PRODUCTO,nuevoProducto.getEstadoActual());
		assertTrue(video.vender(nuevoProducto, nuevoCliente));
		assertEquals(NOMBRE, video.buscarProducto(nuevoProducto).getQuienPoseeElProducto().getNombre());
		assertEquals(ESTADO_FINAL_PRODUCTO, video.buscarProducto(nuevoProducto).getEstadoActual());
	}
	
	@Test
	public void queSePuedaAlquilarUnaPelicula() {
		
		final Integer CODIGO_PELICULA = 1;
		final String DESCRIPCION = "El Cisne Negro";
		final GeneroDePelicula GENERO = GeneroDePelicula.SUSPENSO;
		final Integer ANIO_DE_ESTRENO = 2010;
		final String DIRECTOR = "Darren Aronofsky";
		final String NOMBRE_VIDEOCLUB = "Blockbuster";
		final Integer CODIGO_CLIENTE = 1;
		final String NOMBRE = "Camila";
		final String APELLIDO = "Privado";
		final Integer EDAD = 23;
		final EstadoDelProducto ESTADO_INICIAL_PRODUCTO = EstadoDelProducto.DISPONIBLE;
		final EstadoDelProducto ESTADO_FINAL_PRODUCTO = EstadoDelProducto.ALQUILADO;
		

		Videoclub video = new Videoclub(NOMBRE_VIDEOCLUB);
		Producto nuevoProducto = new Pelicula(CODIGO_PELICULA, DESCRIPCION, GENERO, ANIO_DE_ESTRENO, DIRECTOR,ESTADO_INICIAL_PRODUCTO);
		Cliente nuevoCliente = new Cliente(CODIGO_CLIENTE, APELLIDO, NOMBRE, EDAD);		
		
		video.agregarProducto(nuevoProducto);
			
		assertEquals(ESTADO_INICIAL_PRODUCTO, video.buscarProducto(nuevoProducto).getEstadoActual());
		assertTrue(video.alquilar(nuevoProducto, nuevoCliente));
		assertEquals(NOMBRE, video.buscarProducto(nuevoProducto).getQuienPoseeElProducto().getNombre());
		assertEquals(ESTADO_FINAL_PRODUCTO, video.buscarProducto(nuevoProducto).getEstadoActual());
	}
	
	@Test
	public void queSeNoSePuedaVenderUnProductoVendido() {
		
		final Integer CODIGO_LIBRO = 1;
		final String DESCRIPCION = "Fifty Shades of Grey";
		final String AUTOR = "E. L. James";
		final String EDITORIAL= "Vintage Books";
		final String NOMBRE_VIDEOCLUB = "Blockbuster";
		final Integer CODIGO_CLIENTE = 1;
		final String NOMBRE = "Camila";
		final String APELLIDO = "Privado";
		final Integer EDAD= 23;
		final EstadoDelProducto ESTADO_FINAL_PRODUCTO = EstadoDelProducto.VENDIDO;
		
		Videoclub video = new Videoclub(NOMBRE_VIDEOCLUB);
		Producto producto = new Libro(CODIGO_LIBRO, DESCRIPCION, AUTOR, EDITORIAL,ESTADO_FINAL_PRODUCTO);
		Cliente cliente1 = new Cliente(CODIGO_CLIENTE, APELLIDO, NOMBRE, EDAD);		
		Cliente cliente2 = new Cliente(2, "Gomez", "Laura", 30);		

		video.agregarProducto(producto);

		assertTrue((video.vender(producto, cliente1)));
		
		assertFalse((video.vender(producto, cliente2)));
				
	}
	
	@Test
	public void queSeNoSePuedaAlquilarUnJuegoAlquilado() {
		
		final Integer CODIGO_VIDEOJUEGO = 1;
		final String DESCRIPCION = "Fornite";
		final TipoDeConsola CONSOLA = TipoDeConsola.PLAY_STATION;
		final Double PRECIO_ALQUILER = 500.0;
		final String NOMBRE_VIDEOCLUB = "Blockbuster";
		final Integer CODIGO_CLIENTE = 1;
		final String NOMBRE = "Camila";
		final String APELLIDO = "Privado";
		final Integer EDAD = 23;
		final EstadoDelProducto ESTADO_FINAL_PRODUCTO = EstadoDelProducto.ALQUILADO;
		
		Producto juego = new Videojuego(CODIGO_VIDEOJUEGO, DESCRIPCION, CONSOLA,ESTADO_FINAL_PRODUCTO);
		((Videojuego)juego).setPrecioAlquiler(PRECIO_ALQUILER);
		
		Videoclub video = new Videoclub(NOMBRE_VIDEOCLUB);

		Cliente cliente1 = new Cliente(CODIGO_CLIENTE, APELLIDO, NOMBRE, EDAD);		
		Cliente cliente2 = new Cliente(2, "Gomez", "Laura", 30);		

		video.agregarProducto(juego);
		assertTrue(video.alquilar(juego, cliente1));
		
		assertFalse(video.alquilar(juego, cliente2));
	}
	
	@Test
	public void queLuegoDeDevueltaUnaPeliculaSePuedaAlquilar() {
	
		final Integer CODIGO_PELICULA = 1;
		final String DESCRIPCION = "El Cisne Negro";
		final GeneroDePelicula GENERO = GeneroDePelicula.SUSPENSO;
		final Integer ANIO_DE_ESTRENO= 2010;
		final String DIRECTOR = "Darren Aronofsky";
		final String NOMBRE_VIDEOCLUB = "Blockbuster";
		final Integer CODIGO_CLIENTE = 1;
		final String NOMBRE = "Camila";
		final String APELLIDO = "Privado";
		final Integer EDAD= 23;
		final EstadoDelProducto ESTADO_FINAL_PRODUCTO = EstadoDelProducto.ALQUILADO;
		
		Videoclub video = new Videoclub(NOMBRE_VIDEOCLUB);
		Producto nuevoProducto = new Pelicula(CODIGO_PELICULA, DESCRIPCION, GENERO, ANIO_DE_ESTRENO, DIRECTOR,ESTADO_FINAL_PRODUCTO);
		Cliente nuevoCliente = new Cliente(CODIGO_CLIENTE, APELLIDO, NOMBRE, EDAD);		
		Cliente cliente2 = new Cliente(2, "Gomez", "Laura", 30);	
		
		video.agregarProducto(nuevoProducto);
		assertTrue(video.alquilar(nuevoProducto, nuevoCliente));
		assertFalse(video.alquilar(nuevoProducto, cliente2));
		video.devolver(nuevoProducto);
		assertTrue(video.alquilar(nuevoProducto, cliente2));

	}
	
	@Test
	public void queSeNoSePuedaAlquilarUnPeliculaAUnMenor() {
		
		final Integer CODIGO_PELICULA = 1;
		final String DESCRIPCION = "El Cisne Negro";
		final GeneroDePelicula GENERO= GeneroDePelicula.SUSPENSO;
		final Integer ANIO_DE_ESTRENO = 2010;
		final String DIRECTOR= "Darren Aronofsky";
		final String NOMBRE_VIDEOCLUB = "Blockbuster";
		final Integer CODIGO_CLIENTE= 1;
		final String NOMBRE = "Camila";
		final String APELLIDO = "Privado";
		final Integer EDAD = 15;
		final EstadoDelProducto ESTADO_INICIAL_PRODUCTO = EstadoDelProducto.DISPONIBLE;
		
		
		Videoclub video = new Videoclub(NOMBRE_VIDEOCLUB);
		Producto nuevoProducto = new Pelicula(CODIGO_PELICULA, DESCRIPCION, GENERO, ANIO_DE_ESTRENO, DIRECTOR,ESTADO_INICIAL_PRODUCTO);
		((Pelicula)nuevoProducto).setEdadMinimaParaAlquilar(18);
		Cliente nuevoCliente = new Cliente(CODIGO_CLIENTE, APELLIDO, NOMBRE, EDAD);		
		
		video.agregarProducto(nuevoProducto);
		
		assertFalse(video.alquilar(nuevoProducto, nuevoCliente));
	}

}
