package br.com.curso.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.curso.gerenciador.acao.Acao;



@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
//		boolean ehUmaAcaoPritegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		
//		if(ehUmaAcaoPritegida && usuarioNaoLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
		
		
		
		String nomeDaClase = "br.com.curso.gerenciador.acao." + paramAcao;
		
		String nome;
		
		
			try {
				Class classe = Class.forName(nomeDaClase);
				Object obj = classe.newInstance();
				Acao acao = (Acao) obj;
				nome = acao.executa(request,response);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
					| IOException e) {
				// TODO Auto-generated catch block
				throw new ServletException(e);
			}
		
		
		
		String[] tipoEndereco = nome.split(":");
		
		if(tipoEndereco[0].equals("forward")) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
		rd.forward(request, response);
		
		}else {
		
			response.sendRedirect(tipoEndereco[1]);

		}

	}

}
		
		
	/*
		String nome = null;
		if(paramAcao.equals("listaEmpresas")) {			
			ListaEmpresa acao = new ListaEmpresa();
			nome = acao.executa(request,response);
		
		}else if(paramAcao.equals("RemovaEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();	
			nome = acao.executa(request, response);		
			
			
	    }else if(paramAcao.equals("MostraEmpresa")) {
	    	MostraEmpresa acao = new MostraEmpresa();
	    	nome = acao.executa(request, response);
	    	
	    }else if(paramAcao.equals("EditaEmpresa")) {
	    	Editaempresa acao = new Editaempresa();
	    	nome = acao.executa(request, response);
		
	    }else if(paramAcao.equals("NovaEmpresa")) {
	    	NovaEmpresa acao = new NovaEmpresa();
	    	nome = acao.executa(request, response);

	    }else if(paramAcao.equals("NovaEmpresaForm")) {
	    	NovaEmpresaForm acao = new NovaEmpresaForm();
	    	nome = acao.executa(response, request);

	    }
	    
	    */
		
		

