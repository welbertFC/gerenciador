package br.com.curso.gerenciador.acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.modelo.Banco;
import br.com.curso.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("mostrando dados da empresa");
		
		String parid = request.getParameter("id");
		Integer id = Integer.valueOf(parid);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);

		
		return "forward:formAlteraEmpresa.jsp";
		
		
	}

}
