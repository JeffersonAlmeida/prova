package dao;

public class Pessoa {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	private Long id;
	private String nome;
	private int telefone;
	
	public Pessoa(){
		super();
	}
	
	public Pessoa(String nome){
		this.nome = nome;
		this.telefone = 0;
	}
	@Override
	public String toString() {
		return "Pessoa [nome= " + nome + "]";
	}
	
}
