package net.atos.projetFinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employe")
public class Employe {

	@Id
	@Column(name="idClient")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id ;
	
	@Column(name="username", length = 16)
	String nom ;
	
	@Column(length = 255)
	String email ;
	
	@Column(length = 32)
	String password ;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date createTime ;
	
	@OneToOne
	@JoinColumn(name="Role_idRole")
	Role role ;
}
