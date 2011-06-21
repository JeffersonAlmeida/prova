package iterator;

import dao.Pessoa;

public class AgendaIterator implements Iterator{

	private Agenda agenda;
	
	public AgendaIterator(Agenda agenda){
		this.agenda = agenda;
	}
	
	@Override
	public boolean hasNext() {
		if(agenda.getPos()!=(agenda.getTamanho())){
			return true;
		}
		agenda.setPos(0); // seta zero para comecar mostrar desde o inicio novamente
		return false;
	}

	@Override
	public Object next() {
		Pessoa p = agenda.getPessoas()[agenda.getPos()];
		agenda.setPos(agenda.getPos()+1);
		return p;
	}

	/**
	 * @param agenda the agenda to set
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	/**
	 * @return the agenda
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	@Override
	public void remove() {
		this.agenda.getPessoas()[agenda.getTamanho()-1] = null;
		this.agenda.setTamanho(agenda.getTamanho()-1);
		
	}

}
