package helloworld.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import helloworld.Model.Tarefa;
import helloworld.Util.JpaUtil;

public class TarefaDAO {

	private EntityManager em = JpaUtil.getEntityManager();

	public List<Tarefa> listar() {
		em.getTransaction().begin();
		String q = "SELECT t FROM tarefa t ORDER BY t.descricao ASC";
		List<Tarefa> tarefas = em.createQuery(q, Tarefa.class).getResultList();
		em.getTransaction().commit();
		return tarefas;
	}
	
	public Tarefa findById(int id) {
		em.getTransaction().begin();
		Tarefa tarefa = em.find(Tarefa.class, id);
		em.getTransaction().commit();
		return tarefa;
	}
	
	public List<Tarefa> findTarefas(int id, String descricao, String responsavel, String situacao) {
		em.getTransaction().begin();

		String d = "SELECT t FROM tarefas WHERE t.id IS NOT NULL";

		StringBuilder where = new StringBuilder();

		if (!isEmpty(id)) {
			where.append(" AND t.id LIKE '%" + id + "%' ");
		}
		if (!isEmpty(descricao)) {
			where.append(" AND t.descricao LIKE '%" + descricao + "%' ");
		}
		if (!isEmpty(responsavel)) {
			where.append("AND t.responsavel LIKE '%" + responsavel + "%' ");
		}
		if (!isEmpty(situacao)) {
			where.append("AND t.situacao LIKE '%" + situacao + "%' ");
		}

		d += where + "t.id ASC;";

		List<Tarefa> tarefas = em.createNativeQuery(d, Tarefa.class).getResultList();

		return tarefas;
	}
	
	public void cadastrar(Tarefa tarefa) {
		em.getTransaction().begin();
		em.persist(tarefa);
		em.getTransaction().commit();
	}
	
	public void deletar(int id) {
		Tarefa tarefa = findById(id);
		em.getTransaction().begin();
		em.remove(tarefa);
		em.getTransaction().commit();
	}
	
	public static final boolean isEmpty(Object o) {

		if (o == null)
			return true;

		if (o instanceof String)
			return isEmpty((String) o);

		if (o instanceof Number) {
			Number i = (Number) o;
			return (i.doubleValue() == 0.0);
		}

		if (o instanceof int[])
			return ((int[]) o).length == 0;

		return false;
	}
	
}
