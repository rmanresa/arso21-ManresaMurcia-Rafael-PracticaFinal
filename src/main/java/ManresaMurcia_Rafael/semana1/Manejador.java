package ManresaMurcia_Rafael.semana1;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class Manejador extends DefaultHandler {
	
	//Constantes
	private final static String URL_NUEVA = "https://datos.madrid.es/egob/catalogo/tipo/evento/";

	//Evento en construccion
	private EventoResumen evento;
	
	//Lista de Enventos
	private ListadoEventos listaEventos;
	
	//Flag que indica si estamos dentro de <atributos>
	private boolean describiendoEvento;
	
	//Flag que indica si estamos dentro de <atributo>
	private boolean dentroEvento;
	
	//Valor atributo 'nombre' analizado dentro de <atributo>
	private String tipoAnalizado;
	


	@Override
	public void startDocument() throws SAXException {
		//Inicializacion de lista eventos
		listaEventos = new ListadoEventos();
		evento = null;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		//Si estamos en <atributos>, empezamos a analizar, y creamos evento vacío
		if (qName.equals("atributos")) {
			describiendoEvento = true;	
			evento = new EventoResumen();
		}
		//Si estamos dentro de <atributo>, empezamos a analizar
		else if (qName.equals("atributo") && describiendoEvento) {
			dentroEvento = true;
			
			//obtenemos el valor del atributo 'nombre'contenido en <atributo>
			tipoAnalizado = attributes.getValue("nombre");		
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		//Si volvemos a <atributos>, estamos al final del análisis
		//añadiendo el evento a la lista
		if (qName.equals("atributos")) {
			describiendoEvento = false;		
			listaEventos.addEvento(evento);
			evento = null;
		}
		else if (qName.equals("atributo") && describiendoEvento) {
			dentroEvento = false;
		}	
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
		//Si estamos dentro de <atributo>, modificamos el evento en curso con cada atributo
		if (dentroEvento) {
			
			String getContext = new String(ch, start, length);
									
			switch (tipoAnalizado) {
				case "ID-EVENTO":
					evento.setIdentificador(getContext);
					evento.setUrl(URL_NUEVA + getContext + ".json"); // TODO json? xml??
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
					;

			}

		
		}
	}
	
	
	public ListadoEventos getListaEventos() {
		return listaEventos; // TODO aliasing???
	}

	public void setListaEventos(ListadoEventos listaEventos) {
		this.listaEventos = listaEventos;
	}
	
}