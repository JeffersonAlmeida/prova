package dao.testes;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import dao.Pessoa;
import dao.PessoaDaoImpl;
import static org.junit.Assert.*;

public class TestPessoaDaoImpl {
	
	private PessoaDaoImpl pessoaDaoImpl;
	public static final Long PessoaDeletadaID = (long) 24;
	public static final Long PessoaAlteradaID = (long) 15;
	
	@Before
	public void setUp(){
		pessoaDaoImpl = new PessoaDaoImpl();
	}
	@After
	public void tearDown(){
		pessoaDaoImpl = null;
	}
	
	@Test
	public void testGetAll() throws Exception{
		
		List<Pessoa> pessoas = pessoaDaoImpl.listAll();
		assertNotNull(pessoas);
		Pessoa  pessoa = pessoas.get(0);
		assertNotNull(pessoa);
		assertEquals("Jefferson",pessoa.getNome());		
		Pessoa  segundaPessoa = pessoas.get(1);
		assertNotNull(segundaPessoa);
		assertEquals("Jefferson",segundaPessoa.getNome());
	}
	@Test
	public void testCadastrar() throws Exception{
		Pessoa pessoa = new Pessoa("Jefferson");
		assertNotNull(pessoa);
		assertEquals("Jefferson",pessoa.getNome());		
		assertNotNull(pessoaDaoImpl);
		pessoaDaoImpl.cadastrar(pessoa);
		List<Pessoa> pessoas = pessoaDaoImpl.listAll();
		int size = pessoas.size();
		Pessoa  pessoaRecuperada = pessoas.get(size-1);
		assertEquals("Jefferson", pessoaRecuperada.getNome());
		
	}
	@Test
	public void testExcluir() throws Exception{		
		// só descomentar e setar o valor da pessoa a ser deletada do banco PessoaDeletadaID
		
		/*
		Pessoa pessoa = new Pessoa();
		pessoa.setId(PessoaDeletadaID);
		pessoaDaoImpl.excluir(pessoa);*/
		
	}
	@Test
	public void testAlterar() throws Exception{
		// só descomentar e setar o valor da pessoa a ser alterada do banco PessoaAlteradaID
		
		/*Pessoa pessoa = new Pessoa();
		pessoa.setId(PessoaAlteradaID);
		pessoa.setNome("ManoelJoaquimDaSilva");
		pessoaDaoImpl.alterar(pessoa);*/		
	}
	@Test
	public void testConsultar() throws Exception{
		List<Pessoa> pessoas = pessoaDaoImpl.consultar("Jefferson");
		assertNotNull(pessoas);
		
	}
}
