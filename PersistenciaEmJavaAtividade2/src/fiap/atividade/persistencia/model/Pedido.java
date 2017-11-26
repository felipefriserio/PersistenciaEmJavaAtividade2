package fiap.atividade.persistencia.model;

import java.awt.FontFormatException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	public Pedido(){}
	public Pedido(int id, Cliente cliente, Calendar data, String descricao, double valor){
		this.id = id;
		this.cliente = cliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Pedido(Cliente cliente, Calendar data, String descricao, double valor){
		this.cliente = cliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	@Id
	@Column(name = "idPedido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	private Calendar data;
	private String descricao;
	private double valor;
	
	public int getId() {
		return id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getData() {
		return data;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String toString(){
		return "idPedido "+this.id+
				" idCliente: "+this.getCliente().getId()+
				" Cliente :"+this.cliente.getNome()+
				//" data: "+ new SimpleDateFormat("dd-MM-yyyy").format(this.getData())+
				" descricao: "+ this.descricao+
				" valor: "+this.valor;
	}
}
