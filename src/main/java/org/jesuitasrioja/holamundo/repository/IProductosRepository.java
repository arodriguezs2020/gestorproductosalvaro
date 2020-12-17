package org.jesuitasrioja.holamundo.repository;

import java.util.List;

import org.jesuitasrioja.holamundo.modelo.Producto;

public interface IProductosRepository {

	Producto getById(String id);

	List<Producto> getAll();

	boolean aniadirProducto(Producto producto);

	boolean eliminarProducto(String id);

}