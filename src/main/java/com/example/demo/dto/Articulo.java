package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="articulos")//en caso que la tabla sea diferente

public class Articulo {
	
	//Atributos de entidad cliente
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id;
		@Column(name = "nombre")//no hace falta si se llama igual
		private String nombre;
		@Column(name = "precio")//no hace falta si se llama igual
		private double precio;
		
		@ManyToOne
	    @JoinColumn(name="fabricante")
	    private Fabricante fabricante;

		//Constructores
		public Articulo() {
			
		}

		public Articulo(Long id, String nombre, double precio, Fabricante fabricante) {
			this.id = id;
			this.nombre = nombre;
			this.precio = precio;
			this.fabricante = fabricante;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public Fabricante getFabricante() {
			return fabricante;
		}

		public void setFabricante(Fabricante fabricante) {
			this.fabricante = fabricante;
		}

		@Override
		public String toString() {
			return "Articulo [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fabricante=" + fabricante
					+ "]";
		}

}