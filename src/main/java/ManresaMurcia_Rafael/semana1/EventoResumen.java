package ManresaMurcia_Rafael.semana1;


public class EventoResumen {
	
	private String titulo;
	private String identificador;
	private String url;
	private String inicio;
	private String descripcion;
	private String tipo; // TODO enumerado???¿¿¿
	
	
	public EventoResumen() {
		super();
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getInicio() {
		return inicio;
	}


	public void setInicio(String inicio) {
		this.inicio = inicio;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Evento [titulo=" + titulo + ", identificador=" + identificador + ", url=" + url + ", inicio=" + inicio
				+ ", descripcion=" + descripcion + ", tipo=" + tipo + "]";
	}
	
	
	
}
