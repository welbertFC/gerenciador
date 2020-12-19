package br.com.curso.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.modelo.Banco;
import br.com.curso.gerenciador.modelo.Empresa;

//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastro nova empresa");
		
		String nome = request.getParameter("nome");
		String dataEmpresa = request.getParameter("date");
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		response.sendRedirect("listaEmpresasServlet");
		
		
		//Chamar o JSP
		//RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresasServlet");
		//request.setAttribute("empresa", empresa.getNome());
		//request.setAttribute("dataempresa", empresa.getDataAbertura());
		//rd.forward(request, response);
		
		
		
		
		
		List<Empresa> lista = banco.getEmpresas();
		Empresa ultimaInsercao =  lista.get(lista.size() - 1);
		System.out.println(ultimaInsercao.getNome());
		
		
		
	}

}
