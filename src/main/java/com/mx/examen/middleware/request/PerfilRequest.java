package com.mx.examen.middleware.request;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mx.examen.middleware.constantes.PatronesValidaciones;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "perfiles")
@Component
public class PerfilRequest {

	private String id;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(max = 15)
	@Pattern(regexp = PatronesValidaciones.PATTERN_NOMBRE , message="Solo se permite letras")
	private String nombre;

	@NotNull
	@NotEmpty
	@NotBlank
	@Size(max = 15)
	@Pattern(regexp = PatronesValidaciones.PATTERN_NOMBRE , message="Solo se permite letras")
	private String apellidoPaterno;

	@NotNull
	@NotEmpty
	@NotBlank
	@Size(max = 15)
	@Pattern(regexp = PatronesValidaciones.PATTERN_NOMBRE , message="Solo se permite letras")
	private String apellidoMaterno;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = PatronesValidaciones.TIME_ZONE)
	private Date fechaNacimiento;

	@Min(12)
	@Max(999)
	private int edad;

	private String foto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
