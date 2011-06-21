package dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;


public class PessoaDaoImpl implements PessoaDao {

	@Override
	public void cadastrar(Pessoa p) throws Exception{
		
		Session session = HibernateFactorySingleton.getInstance().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(p);
			transaction.commit();
		}catch(Exception exception){
			if(transaction!=null){
				transaction.rollback();
			}
			throw exception; 
		}finally{
			session.close();
		}		
	}

	@Override
	public void excluir(Pessoa pessoa) throws Exception{
		Session session = HibernateFactorySingleton.getInstance().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();		
			session.delete(pessoa);
			transaction.commit();
		}catch(Exception exception){
			throw exception; 
		}finally{
			session.close();
		}			
	}

	@Override
	public void alterar(Pessoa p) throws Exception {		
		Session session = HibernateFactorySingleton.getInstance().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Pessoa pessoa = (Pessoa) session.load(Pessoa.class, new Long(p.getId()));
			pessoa.setNome(p.getNome());
			pessoa.setTelefone(p.getTelefone());		
			transaction.commit();
		}catch(Exception exception){
			if(transaction==null){
				transaction.rollback();
			}
			throw exception;
		}finally{
			session.close();
		}	
		
	}

	@Override
	public List<Pessoa> consultar(String nome) throws Exception{
		Session session = HibernateFactorySingleton.getInstance().openSession();
		Transaction transaction = null;
		List <Pessoa> pessoas = null;
		try{
			 transaction = session.beginTransaction();	
			 String query = "from Pessoa p where p.nome like '"+ nome +"'";
			 pessoas = session.createQuery(query).list();
			 System.out.println(pessoas.get(0).getNome());
			 transaction.commit();
		}catch(Exception exception){
			if(transaction==null){
				transaction.rollback();
			}
			throw exception;
		}finally{
			session.close();			
			return pessoas;
		}		
	}

	@Override
	public List<Pessoa> listAll() throws Exception{
		Session session = HibernateFactorySingleton.getInstance().openSession();
		Transaction transaction = null;
		List<Pessoa> pessoas = null;
		try{
			transaction = session.beginTransaction();
			pessoas = session.createQuery("from Pessoa").list();
			transaction.commit();
		}catch(Exception exception){
			if(transaction!=null){
				transaction.rollback();
			}
		}finally{
			session.close();
			return pessoas;
		}	
		
	}

}
