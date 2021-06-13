package posjavamavenhibernate;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.TelefoneUser;
import model.UsuarioPessoa;

public class testehibernate {
	
	@Test
	public void testeHibernateUtil(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setLogin("teste");
		pessoa.setNome("Paulo");
		pessoa.setSenha("123");
		pessoa.setSobrenome("Egidio");
		pessoa.setIdade(20);
		pessoa.setEmail("camila3467@outlook.com");
		
		daoGeneric.salvar(pessoa);
		
	}
	
	@Test
	public void testeBuscar(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeBuscar2(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L , UsuarioPessoa.class);
		
		System.out.println(pessoa);
		
	}
	
	
	
	@Test
	public void testeUpdate(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(34L , UsuarioPessoa.class);
		
		pessoa.setNome("Nome atualizado Hibernate");
		pessoa.setSenha("sd4s5d4s4d");
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	
	@Test
	public void testeDelete(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(23L,UsuarioPessoa.class);
		
		daoGeneric.deletarPoId(pessoa);
		
		
	}
	
	
	@Test
	public void testeConsultar(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("--------------------------------------------------");
		}
	}
	@Test
	public void testeQueryList() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
List<UsuarioPessoa>list=daoGeneric.getEntityManager().createQuery("from UsuarioPessoa order by id").
setMaxResults(1).getResultList();
for (UsuarioPessoa usuarioPessoa : list) {
	System.out.println(usuarioPessoa);
}
	}
	//estabelece parametros
	@Test
	public void testeQueryListParameter() {
DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
List<UsuarioPessoa>list=daoGeneric.getEntityManager().
createQuery("from UsuarioPessoa where nome= :nome").
setParameter("nome", "Paulo").getResultList();
for(UsuarioPessoa usuarioPessoa:list) {
		System.out.println(usuarioPessoa);
	}

	
	}
	@Test
	public void  testeQuerysomaIdade () {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
Long  somaIdade=(Long) daoGeneric.getEntityManager().createQuery("select sum(u.idade) from UsuarioPessoa u").getSingleResult();
		System.out.println("soma das idades é:"+somaIdade);
	}
	@Test
	public void testeNameQuery()
{
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	List<UsuarioPessoa>list=daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.todos").getResultList();
	for(UsuarioPessoa usuarioPessoa:list) {
		System.out.println(usuarioPessoa);
	}
}
	@Test
	public void testeGravarTelefone() {
		
		 DaoGeneric daoGeneric = new DaoGeneric();
		 UsuarioPessoa pessoa=(UsuarioPessoa) daoGeneric.pesquisar(35L, UsuarioPessoa.class);
	TelefoneUser telefoneUser= new TelefoneUser();
	telefoneUser.setTipo("celular");
	telefoneUser.setNumero("986448761");
	telefoneUser.setUsuarioPessoa(pessoa);
	daoGeneric.salvar(telefoneUser);
	}
}




