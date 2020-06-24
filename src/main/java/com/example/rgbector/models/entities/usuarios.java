package com.example.rgbector.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class usuarios implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_usuario")
	private Long idUsuario;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="nick")
	private String nick;
	
	@Column(name="clave")
	private String clave;
	
	@Column(name="estado")
	private Boolean estado;

	public usuarios() {
		super();
	}

	public usuarios(Long id) {
		super();
		this.idUsuario = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}	
	
	/* usuarios Uno a Varios con propuestas */
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<propuestas> propuestas;
	
	/* usuarios Uno a Varios con perfiles */
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<perfiles> perfiles;
	
	/* usuarios Uno a Varios con etiquetasTipoDisenio */
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<etiquetasTipoDisenio> etiquetasTipoDisenio;
	
	/* usuarios Uno a Varios con pedidos */
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<pedidos> pedidos;
	
	/* usuarios Varios a Uno con tipoUsuario */

	@JoinColumn(name="fk_tipo_usuario", referencedColumnName="pk_tipo_usuario")
	@ManyToOne
	private tipoUsuario tipoUsuario;

	public List<propuestas> getPropuestas() {
		return propuestas;
	}

	public void setPropuestas(List<propuestas> propuestas) {
		this.propuestas = propuestas;
	}

	public List<perfiles> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<perfiles> perfiles) {
		this.perfiles = perfiles;
	}

	public List<etiquetasTipoDisenio> getEtiquetasTipoDisenio() {
		return etiquetasTipoDisenio;
	}

	public void setEtiquetasTipoDisenio(List<etiquetasTipoDisenio> etiquetasTipoDisenio) {
		this.etiquetasTipoDisenio = etiquetasTipoDisenio;
	}

	public List<pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public tipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(tipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
}
