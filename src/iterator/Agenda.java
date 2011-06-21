package iterator;

import dao.Pessoa;

public class Agenda {
	
	private Pessoa pessoas[];
	private String nomes[] = {"A","B","C","D","E","F","G","H","I","J"};
	public static final int quantPessoas = 10;
	private int pos = 0;
	private int tamanho = 10;
	
	public Agenda(){
		pessoas = new Pessoa[10];		
		for(int i =0; i< quantPessoas; i++){
			pessoas[i] = new Pessoa(nomes[i]);
			pos++;
		}
	}

	/**
	 * @param pessoas the pessoas to set
	 */
	public void setPessoas(Pessoa pessoas[]) {
		this.pessoas = pessoas;
	}

	/**
	 * @return the pessoas
	 */
	public Pessoa[] getPessoas() {
		return pessoas;
	}
	
	public Iterator agendaIterator(){
		this.pos = 0;
		return new AgendaIterator(this);
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}

	/**
	 * @return the pos
	 */
	public int getPos() {
		return pos;
	}
	
	public void show(){
		for(int i= 0; i< quantPessoas; i++){
			System.out.println(this.getPessoas()[i]);
		}
	}

	/**
	 * @param tamanho the tamanho to set
	 */
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	/**
	 * @return the tamanho
	 */
	public int getTamanho() {
		return tamanho;
	}
}
