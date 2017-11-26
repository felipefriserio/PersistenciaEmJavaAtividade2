package fiap.atividade.persistencia.main;

import java.util.Calendar;
import java.util.List;

import fiap.atividade.persistencia.helper.ClienteDAO;
import fiap.atividade.persistencia.helper.PedidoDAO;
import fiap.atividade.persistencia.model.Cliente;
import fiap.atividade.persistencia.model.Pedido;

public class MainPedido {
	public static void main(String[] args) {
		Cliente cliente = new ClienteDAO().get(2);
		Pedido pedido = new Pedido(cliente, 
								   Calendar.getInstance(),
								   "descricao", 
								   10d);
		
		// testa insert
		PedidoDAO pedidoDAO = new PedidoDAO();
		System.out.println("********** Testa Insert **********");
		System.out.println(pedidoDAO.insert(pedido));
		
		// testa get
		System.out.println("********** Testa GET **********");
		Pedido pedido2 = pedidoDAO.get(2);
		System.out.println(pedido2.toString());
		
		// testa lista pedidos
		System.out.println("********** Testa lista Pedidos do cliente **********");
		List<Pedido> listaDePedidosDoCliente = new PedidoDAO().listaPedidosDoCliente(2);
			for (Pedido pedidoDoCliente : listaDePedidosDoCliente) {
				System.out.println(pedidoDoCliente.toString());
			}
		
		// testa lista pedidos do cliente 
		System.out.println("********** Testa lista Pedidos **********");
		List<Pedido> listaDePedidos = new PedidoDAO().lista();
		for (Pedido pedidoDaLista : listaDePedidos) {
			System.out.println(pedidoDaLista.toString());
		}
	}

}
