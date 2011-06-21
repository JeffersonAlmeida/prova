package iterator;

import dao.Pessoa;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Agenda agenda = new Agenda();
		System.out.println("\n\n** SEM Iterator**\n\n");
		agenda.show();		
		System.out.println("\n\n**Iterator**\n\n");
		Iterator iterator = agenda.agendaIterator();
		while(iterator.hasNext()){
			Pessoa pessoa = (Pessoa) iterator.next();
			System.out.println(pessoa);
		}
		
		iterator.remove();
		
		System.out.println("\n\n**Iterator**\n\n");
		
		while(iterator.hasNext()){
			Pessoa pessoa = (Pessoa) iterator.next();
			System.out.println(pessoa);
		}
		
		iterator.remove();
		iterator.remove();
		iterator.remove();
		iterator.remove();
		

		System.out.println("\n\n**Iterator**\n\n");
		
		while(iterator.hasNext()){
			Pessoa pessoa = (Pessoa) iterator.next();
			System.out.println(pessoa);
		}
		
	}

}
