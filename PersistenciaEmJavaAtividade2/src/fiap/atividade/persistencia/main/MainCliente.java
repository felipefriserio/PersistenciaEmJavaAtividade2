package fiap.atividade.persistencia.main;

import java.util.List;

import fiap.atividade.persistencia.helper.ClienteDAO;
import fiap.atividade.persistencia.model.Cliente;

public class MainCliente {
	public static void main(String[] args) {
		Cliente c = new Cliente("Felipe", "felipefriserio@gmail.com");
		ClienteDAO cDao = new ClienteDAO();
		
		// testa insert
		System.out.println("********** Testa Insert **********");
		System.out.println(cDao.insert(c));
		
		// testa get
		System.out.println("********** Testa GET **********");
		Cliente c2 = cDao.get(1);
		System.out.println(c2.toString());
		
		// testa listar clientes
		System.out.println("********** Testa lista de clientes **********");
		List<Cliente> lista = cDao.lista();
		for (Cliente cliente : lista) {
			System.out.println(cliente.toString());
		}
	}
	
}
