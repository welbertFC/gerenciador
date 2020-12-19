package br.com.curso.gerenciador.acao;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idpar = request.getParameter("id");
		Integer id = Integer.valueOf(idpar);
		Banco banco = new Banco();
		banco.remove(id);
		
		
		return "redirect:entrada?acao=ListaEmpresa";
				
			
	}

}