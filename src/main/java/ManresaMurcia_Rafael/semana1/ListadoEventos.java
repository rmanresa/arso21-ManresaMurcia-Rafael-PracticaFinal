package ManresaMurcia_Rafael.semana1;

import java.util.LinkedList;
import java.util.List;

public class ListadoEventos {

	private List<EventoResumen> eventos;

	
	public ListadoEventos() {
		eventos = new LinkedList<EventoResumen>();
	}

	public List<EventoResumen> getEventos() {
		return new LinkedList<EventoResumen>(eventos);
	}

	public void setEventos(List<EventoResumen> eventos) {
		this.eventos = eventos;
	}

	public void addEvento(EventoResumen evento) {
		eventos.add(evento);
	}
	
	
}
