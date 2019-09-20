package net.atos.projetFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Gère un status
 * 
 * @author kamel
 *
 */
@Entity
@Table(name = "status")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatus", updatable = false, nullable = false)
	private Long id;

	@Column(length = 100)
	private String nomStatus;


}
