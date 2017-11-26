package fiap.atividade.persistencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;

	public Cliente(){}
	public Cliente(String nome, String email){
		this.nome = nome;
		this.email = email;
	}
	
	public Cliente(int id, String nome, String email){
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	@Id
	@Column(name = "idCliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	
	public String toString(){
		return "id: "	  + this.id +
				" nome: " + this.nome +
				" email: "+ this.email;
	}
}
