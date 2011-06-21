package dao;

import java.util.List;

public interface PessoaDao {
	
	void cadastrar(Pessoa p) throws Exception ;
	void excluir(Pessoa p) throws Exception ;
	void alterar(Pessoa p) throws Exception ;
	List<Pessoa> consultar(String nome) throws Exception ;
	List<Pessoa> listAll() throws Exception ;
		
	
}
