package corso.spring.intgr.channels.demo.model;

import java.util.Date;



public class TicketRDA implements java.io.Serializable{

	private Long Id;
	private String modello;
	private String descrizioneProblema;
	private String numeroMatricola;
	private String numeroDocumentoAcquisto;
	private Date dataAcquisto;

	public enum Priority {
		low (1),
		medium(2),
		high(3),
		emergency(4);
		
		private int numero;
		
		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		private Priority(int numero){
			this.numero=numero;
		}
	}
	
	private Priority priority;
	
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	@Override
	public String toString() {
		return "TicketRDA [Id=" + Id + ", dataAcquisto=" + dataAcquisto
				+ ", descrizioneProblema=" + descrizioneProblema + ", modello="
				+ modello + ", numeroDocumentoAcquisto="
				+ numeroDocumentoAcquisto + ", numeroMatricola="
				+ numeroMatricola + ", priority=" + priority + "]";
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getDescrizioneProblema() {
		return descrizioneProblema;
	}
	public void setDescrizioneProblema(String descrizioneProblema) {
		this.descrizioneProblema = descrizioneProblema;
	}
	public String getNumeroMatricola() {
		return numeroMatricola;
	}
	public void setNumeroMatricola(String numeroMatricola) {
		this.numeroMatricola = numeroMatricola;
	}
	public String getNumeroDocumentoAcquisto() {
		return numeroDocumentoAcquisto;
	}
	public void setNumeroDocumentoAcquisto(String numeroDocumentoAcquisto) {
		this.numeroDocumentoAcquisto = numeroDocumentoAcquisto;
	}
	public Date getDataAcquisto() {
		return dataAcquisto;
	}
	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	
	
}
