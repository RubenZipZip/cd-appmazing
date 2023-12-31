package com.campusdual.appmazing.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity //un modelo- indica que esta clase es una entidad persistible  y que es un elemento que se va a poder guardar en BBDD y recuperarlo
@Table(name = "PRODUCTS")// el modelo va a representar la tabla (Products)asociamos la tabla PRODUCTOS de dbeaver con el modelo producto, para que por cada elemento que tenga se genere un producto
public class Product {
    @Id //indica que esta es la clave primaria, el identificador
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como es un valor autogenerable lo generamos siguiendo la estrategia de GenerationType.IDENTITY
    private int id;
    @Column // las columnas de la bbdd
    private String name;
    @Column
    private int stock;
    @Column
    private BigDecimal price;
    @Column
    private boolean active;
    @Column
    private Date date_added;

    @ManyToOne //
    @JoinColumn(name = "category_id") //columna creada para enlazar
    private Categories categories;

    public Categories getCategories() {
        return this.categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
