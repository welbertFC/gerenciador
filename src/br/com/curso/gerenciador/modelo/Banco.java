package br.com.curso.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuario = new ArrayList<Usuario>();
	private static Integer chaveSequencial =1;
	
	static {
		
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Facebook");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Google");
		lista.addAll(Arrays.asList(empresa1, empresa2));
		
		Usuario user1 = new Usuario();
		user1.setLogin("joao");
		user1.setSenha("123");
		Usuario user2 = new Usuario();
		user2.setLogin("maria");
		user2.setSenha("1234");
		listaUsuario.add(user1);
		listaUsuario.add(user2);
		

		
		
		
		
	}

	public void adiciona(Empresa empresa) {
		
		lista.add(empresa);
		empresa.setId(chaveSequencial++);
		
	}
	
	public void remove(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while (it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
			
		}
		
	}
	
	
	
	public List<Empresa> getEmpresas(){
		
		return Banco.lista;
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		
		for (Empresa empresa : lista) {
			
			if(empresa.getId() == id) {
				return empresa;
			}
			
		}
		
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		
		for(Usuario u : listaUsuario) {
			
			if(u.ehIgual(login, senha)) {
				return u;
			}
			
		}
		return null;
	}

}
