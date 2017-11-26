package fiap.atividade.persistencia.helper;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import fiap.atividade.persistencia.HibernateUtil;
import fiap.atividade.persistencia.model.Cliente;

public class ClienteDAO {
	private Session session;
	
	private Session getCurrentSession(){
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public Cliente get(int id){
		this.session = getCurrentSession();
		session.beginTransaction();
		TypedQuery<Cliente> query = session.createQuery("SELECT c FROM Cliente c WHERE c.id = :id ", Cliente.class);
		Cliente cliente = query.setParameter("id", id).getSingleResult();
		session.getTransaction().commit();
		return cliente;
	}
	
	public List<Cliente> lista(){
		this.session = getCurrentSession();
		session.beginTransaction();
		TypedQuery<Cliente> query = session.createQuery("SELECT c FROM Cliente c", Cliente.class);
		List<Cliente> listaDeClientes = query.getResultList();
		session.getTransaction().commit();
		return listaDeClientes;
	}

	public String insert(Cliente cliente){
		this.session = getCurrentSession();
		session.beginTransaction();
		session.save(cliente);
		session.getTransaction().commit();;
		return "Cliente cadastrado.";
	}
	
	
	
}
