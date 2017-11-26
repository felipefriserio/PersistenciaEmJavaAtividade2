package fiap.atividade.persistencia.helper;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import fiap.atividade.persistencia.HibernateUtil;
import fiap.atividade.persistencia.model.Pedido;

public class PedidoDAO {
	private Session session;
	
	private Session getCurrentSession(){
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
public Pedido get(int id){
		this.session = getCurrentSession();
		session.beginTransaction();
		TypedQuery<Pedido> query = session.createQuery("FROM Pedido p WHERE p.id = :id ", Pedido.class);
		Pedido pedido = query.setParameter("id", id).getSingleResult();
		session.getTransaction().commit();
		return pedido;
	}
	
	public List<Pedido> lista(){
		this.session = getCurrentSession();
		session.beginTransaction();
		TypedQuery<Pedido> query = session.createQuery("FROM Pedido p", Pedido.class);
		List<Pedido> listaDePedidos = query.getResultList();
		session.getTransaction().commit();
		return listaDePedidos;
	}
	
	public List<Pedido> listaPedidosDoCliente(int idCliente){
		this.session = getCurrentSession();
		session.beginTransaction();
		TypedQuery<Pedido> query = session.createQuery("FROM Pedido p WHERE p.cliente.id = :idCliente", Pedido.class);
		List<Pedido> listaDePedidos = query.setParameter("idCliente", idCliente).getResultList();
		session.getTransaction().commit();
		return listaDePedidos;
	}

	public String insert(Pedido p){
		this.session = getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();;
		return "pedido inserido";
	}
}
