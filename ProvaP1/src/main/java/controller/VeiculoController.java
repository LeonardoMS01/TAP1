package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Veiculos;

@WebServlet(urlPatterns = "/p1")
public class VeiculoController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private List<Object> lista = new ArrayList<>();
	JsonHelper json = new JsonHelper();
	int id=1;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String placa = req.getParameter("placa");
		String nome = req.getParameter("nome");
		String marca = req.getParameter("marca");		
		double valor = Double.parseDouble(req.getParameter("valor"));
		
		Veiculos obj = new Veiculos(id, placa, nome, marca, valor);
		lista.add(obj);
		
		try {
			resp.getWriter().println(json.gerarJson(obj));
			
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		id++;
		

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idRemove = Integer.parseInt(req.getParameter("id"));
		
		for(int i=0; i<lista.size(); i++){
			Veiculos objId = (Veiculos) lista.get(i); 
			if(objId.getId() == idRemove){
				lista.remove(i);
			}
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opcao = req.getParameter("opcao");
		String json1;
		int qtd=0;
		if(opcao.equals("quantidade")){
			for(int i=0; i<lista.size(); i++){
				qtd++;
			}
			resp.getWriter().print("{qtd:"+qtd+"}");
			
		 
			
		} else if(opcao.equals("buscar placa")){
			
			String buscPlaca = req.getParameter("placa");
			
			for(int i=0; i<lista.size(); i++){
				Veiculos placaBusc = (Veiculos) lista.get(i);
				
				if(placaBusc.getPlaca().equals(buscPlaca)){
					
					try {
						resp.getWriter().println(json.gerarJson(placaBusc));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				}
			}
			
		} else if(opcao.equals("todos")){
		
		
			try {
				json1 = json.gerarJsonLista(lista);
				resp.getWriter().print(json1);
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} else if(opcao.equals("barato")) {
			Veiculos objMenor = (Veiculos) lista.get(0);
			double menor = objMenor.getValor();
			
			for(int i=1; i<lista.size(); i++){				
				objMenor = (Veiculos) lista.get(i);
				if(objMenor.getValor() < menor){
					menor = objMenor.getValor();
					
						
							
								try {
									resp.getWriter().println(json.gerarJson(objMenor));
								} catch (IllegalArgumentException | IllegalAccessException
										| InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
					
					
				}
			}
			
		} else {
			Veiculos objMaior = (Veiculos) lista.get(0);
			double maior = objMaior.getValor();
			
			for(int i=1; i<lista.size(); i++){
				objMaior = (Veiculos) lista.get(i);
				if(objMaior.getValor() > maior){
					maior = objMaior.getValor();
					
						
							
								try {
									resp.getWriter().println(json.gerarJson(objMaior));
								} catch (IllegalArgumentException | IllegalAccessException
										| InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						
							
				
				}
			}
		}
		
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idEdit = Integer.parseInt(req.getParameter("id"));
				
		for(int i=0;i<lista.size();i++){
			Veiculos objId = (Veiculos) lista.get(i);
			
			if(objId.getId() == idEdit){
				String placa = req.getParameter("placa");
				String nome = req.getParameter("nome");
				String marca = req.getParameter("marca");
				double valor = Double.parseDouble(req.getParameter("valor"));
						
				objId.setPlaca(placa);
				objId.setNome(nome);
				objId.setMarca(marca);
				objId.setValor(valor);
				break;
			}
		}
	}
	
}
