package org.jesuitasrioja.holamundo.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.jesuitasrioja.holamundo.modelo.Producto;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ProductosRepositoryMongoDB implements IProductosRepository {

	private MongoCollection<Document> collection;

	public ProductosRepositoryMongoDB() {
		MongoClient mongo  = new MongoClient("localhost",27017);
		MongoDatabase database = mongo.getDatabase("productosDB");
		collection = database.getCollection("productos");
	}

	/**
	 *
	 *@return El producto con id pasado por parametro o null en caso de no existir.
	 *
	 */
	@Override
	public Producto getById(String id) {
		
		Producto producto = null;
		
		Document productoDocument = collection.find(Filters.eq("id",id)).first();
		
		if(productoDocument != null) {
			System.out.println("entre:"+productoDocument);
			
			producto = document2Producto(productoDocument);	
		}
		
		return producto;
	}

	@Override
	public List<Producto> getAll() {
		
		List<Producto> listaProductos = new ArrayList<Producto>();
		
		FindIterable<Document> listaDocumentos = collection.find();
    	
    	for (Document document : listaDocumentos) {
    		
    		Producto producto = document2Producto(document);	
    		listaProductos.add(producto);
		}
		return listaProductos;
	}

	@Override
	public boolean aniadirProducto(Producto producto) {
		return false;
	}

	@Override
	public boolean eliminarProducto(String id) {
		return false;
	}

	private Producto document2Producto(Document productoDocument) {
		Producto producto;
		Gson gson = new Gson();
		
		String productoJSON = productoDocument.toJson();
		
		producto = gson.fromJson(productoJSON, Producto.class);
		return producto;
	}
}
