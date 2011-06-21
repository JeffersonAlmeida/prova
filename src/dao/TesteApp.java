package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

public class TesteApp {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		SessionFactory sessionFactory = HibernateFactorySingleton.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Pessoa pessoa = new Pessoa("Marcos");
		PessoaDaoImpl pessoaDaoImpl = new PessoaDaoImpl();
		pessoaDaoImpl.cadastrar(pessoa);
		transaction.commit();
		session.close();

	}

}
