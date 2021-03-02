package ManresaMurcia_Rafael.semana2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Semana2 {
	
	public final static String TITULO= "title";
	public final static String RESUMEN= "summary";
	public final static String URL= "wikipediaUrl";
	
	public static void main(String[] args) throws Exception{


		// 1. Obtener una factoría
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		
		// 2. Pedir a la factoría la construcción del analizador
		DocumentBuilder analizador = factoria.newDocumentBuilder();
		
		// 3. Analizar el documento
		Document documento = analizador.parse("xml/findNearbyWikipedia.xml"); // TODO cambiar
		
		
		//busco elementos 'entry'
		NodeList entradas = documento.getElementsByTagName("entry");
		
		//iteracion de todos elementos 'entry'
		for (int i = 0; i < entradas.getLength() ; i++) {
			//recorrido elemento 'calificacion'
			Element entrada = (Element) entradas.item(i);
			
			NodeList titulos = entrada.getElementsByTagName(TITULO);
			Element titulo = (Element) titulos.item(0);			
			
			NodeList resumenes = entrada.getElementsByTagName(RESUMEN);
			Element resumen = (Element) resumenes.item(0);			
			
			NodeList urls = entrada.getElementsByTagName(URL);
			Element url = (Element) urls.item(0);
				

			System.out.println(titulo.getTextContent());
			System.out.println(resumen.getTextContent());
			System.out.println(url.getTextContent());
			System.out.println("-----");

		}	// fin for
		
		System.out.println("fin");
		

	}

}
