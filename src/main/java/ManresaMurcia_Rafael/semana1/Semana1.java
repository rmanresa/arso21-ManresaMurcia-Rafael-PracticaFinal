package ManresaMurcia_Rafael.semana1;

import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;


public class Semana1 {
	
	public static void main(String[] args) throws Exception{

		// Establecer el nombre del fichero

		final String documento = "xml/madrid.xml";

		Manejador manejador = new Manejador();

		// 1. Obtener una factoría

		SAXParserFactory factoria = SAXParserFactory.newInstance();
		
		// 2. Pedir a la factoría la construcción del analizador

		// Dejamos escapar las excepciones de construcción (throws en el main)

		SAXParser analizador = factoria.newSAXParser();

		// 3. Analizar el documento

		try {
			analizador.parse(documento, manejador);

			for (EventoResumen evento: manejador.getListaEventos().getEventos()) {
				System.out.println(evento.toString());
			}


		} catch (SAXException e) {

			System.out.println("El procesamiento se ha detenido por errores sintácticos");

		} catch (IOException e) {

			System.out.println("No se ha podido abrir el documento: " + documento);
		}

		System.out.println("Fin.");
		
		
		/*

		// 1. Obtener una factoría
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		
		// 2. Pedir a la factoría la construcción del analizador
		DocumentBuilder analizador = factoria.newDocumentBuilder();
		
		// 3. Analizar el documento
		Document documento = analizador.parse("xml/madrid.xml"); // TODO cambiar
		
		ListadoEventos eventos = new ListadoEventos();
		
		//busco elementos 'contenido'
		NodeList contenidos = documento.getElementsByTagName("contenido");
		
		//iteracion de todos elementos 'contenido'
		for (int i = 0; i < contenidos.getLength() ; i++) {
			
			Evento evento = new Evento();
			
			//recorrido elemento 'contenido'
			Element contenido = (Element) contenidos.item(i);
			
			//busco atributos de cada contenido
			NodeList atributos = contenido.getElementsByTagName("atributos");
			Element atributoPrimero = (Element) atributos.item(0);
			
			NodeList atributo = atributoPrimero.getElementsByTagName("atributo");
			for (int j = 0; j < atributo.getLength() ; j++) {
				Element subatributo = (Element) atributo.item(j);
				String nombreAtributo = subatributo.getAttribute("nombre"); 
				String getContext = subatributo.getTextContent();
				
				switch (nombreAtributo) {
				case "ID-EVENTO":
					evento.setIdentificador(getContext);
					evento.setUrl("https://datos.madrid.es/egob/catalogo/tipo/evento/" + getContext + ".json"); // TODO json? xml??
					break;
				case "TITULO":
					evento.setTitulo(getContext);
					break;
				case "FECHA-EVENTO":
					evento.setInicio(getContext);
					break;
				case "DESCRIPCION":
					evento.setDescripcion(getContext);
					break;
				case "TIPO":
					evento.setTipo(getContext);
					break;

				default:
					break;
				}
				
				
			}
			
			eventos.addEvento(evento);
			
			System.out.println(evento.toString());
				
				
				
				
				
				
			
			



		}	// fin for
		
		System.out.println("fin");
		


*/
	}

}
