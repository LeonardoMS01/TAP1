package helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class JsonHelper {
	public String gerarJsonLista(List<Object> lista) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		StringBuffer json = new StringBuffer("[");

		for (int i = 0; i < lista.size(); i++) {

		//json.append(gerarJson(lista.get(i)));
			if (i < lista.size() - 1)
				json.append(",");
		}
		json.append("]");
		return json.toString();

	}

	
}
