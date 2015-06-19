package padrao;

import localhost.soap.provamovel.Provamovel;
import localhost.soap.provamovel.ProvamovelLocator;
import localhost.soap.provamovel.ProvamovelPortType;

public class ClienteTeste {
	
	public static void main(String[] args) {

		try {

			//String valorCPF = JOptionPane.showInputDialog("Digite um CPF");

			 Provamovel service = new ProvamovelLocator();
			 ProvamovelPortType teste1 = service.getprovamovelPort();

			System.out.println(teste1.cadastrar("exemplo@email.com", "123456", "54753440"));
			
			System.out.println(teste1.login("jpaulo_silva@yahoo.com.br", "12345"));

		} catch (Exception e) {

		}

	}

}
