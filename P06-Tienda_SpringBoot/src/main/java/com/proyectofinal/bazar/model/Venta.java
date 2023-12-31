package com.proyectofinal.bazar.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    
    
    @JsonManagedReference
    @OneToMany(mappedBy="venta")
    private List<Producto> listaProductos;

    @OneToOne
    @JoinColumn (name="id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.cliente = cliente;
    }



    
    
    
    
    
}
