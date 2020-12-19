package br.com.curso.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.modelo.Banco;
import br.com.curso.gerenciador.modelo.Empresa;

public class EditaEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parId = request.getParameter("id");
		Integer id = Integer.valueOf(parId);
		
		String nomeEmpresa = request.getParameter("nome");
		String dataCriacao = request.getParameter("date");
		
		Date data = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(dataCriacao);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(data);
		
		
		return "redirect:entrada?acao=ListaEmpresa";
		
	}

}
