package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Parametro;



	@WebServlet(urlPatterns = "/ex")
	public class Servlet extends HttpServlet{
		
		private static final long serialVersionUID = 1L;
		private List<Object> lista = new ArrayList<>();
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			int n1 = Integer.parseInt(req.getParameter("n1"));
			int n2 = Integer.parseInt(req.getParameter("n2"));
			String operacao = req.getParameter("operacao");
			int resultado;
			
			Parametro calculo = new Parametro(n1, n2, operacao);
			
			resultado = calculo.Calcular(n1, n2, operacao);
			
			lista.add(resultado);
			//resp.getWriter().println("{Resultado:"+ resultado +"}");
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			StringBuffer json = new StringBuffer("[");
			for(int i = 0; i<lista.size(); i++){
				
					json.append("{resultado: "+lista.get(i)+"}");
					if (i < lista.size() - 1)
						json.append(",");
				}
				json.append("]");
			
				resp.getWriter().print(json.toString());
		}
			
		
	
}
