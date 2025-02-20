package com.fernandodev.sgi_backend.models;

import com.fernandodev.sgi_backend.enums.CategoriaProducto;
import com.fernandodev.sgi_backend.enums.SubCategoriaProducto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class    Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CategoriaProducto nombreCategoria;
    private SubCategoriaProducto nombreSubCategoria;
    @OneToMany(mappedBy="categoria")
    private List<Producto> productos;

    //CONSTRUCTORES
    public Categoria(CategoriaProducto categoryName, SubCategoriaProducto subCategoryName, List<Producto> productos ){
        this.nombreCategoria = categoryName;
        this.nombreSubCategoria = subCategoryName;
        this.productos = productos;
    }

    public Categoria(){}

    //GETTERS
    public Long getId() {
        return id;
    }
    public CategoriaProducto getNombreCategoria() {
        return nombreCategoria;
    }
    public SubCategoriaProducto getNombreSubCategoria() {
        return nombreSubCategoria;
    }
    public List<Producto> getProductos() {
        return productos;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombreCategoria(CategoriaProducto nombre) {
        this.nombreCategoria = nombre;
    }
    public void setNombreSubCategoria(SubCategoriaProducto nombreSubCategoria) {
        this.nombreSubCategoria = nombreSubCategoria;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
