package helloworld.Bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import helloworld.DAO.TarefaDAO;
import helloworld.Model.Tarefa;

@ManagedBean(name="tarefa")
@ViewScoped
public class TarefaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Tarefa tarefa = new Tarefa();
	private TarefaDAO tarefaDao = new TarefaDAO();
	private List<Tarefa> listaTarefas = tarefaDao.listar();
	private String descricaoBusca = "";

	/*
	 * Determinam os dados a serem filtrados para buscar uma tarefa.
	 */
	public boolean checkId;
	private boolean checkDescricao;
	private boolean checkResponsavel;
	private boolean checkSituacao;

	/*
	 * Usados para setar os dados para a busca da tarefa.
	 */
	public Tarefa filtroId;
	public Tarefa filtroDescricao;
	public Tarefa filtroResponsavel;
	public Tarefa filtroSituacao;
	public Tarefa filtroPrioridade;

	/*
	 * Usados para determinar qual a prioridade da tarefa.
	 */
	private boolean isPrioridadeAlta;
	private boolean isPrioridadeMedia;
	private boolean isPrioridadeBaixa;

	/*
	 * Usados para determinar a situação de uma tarefa.
	 */
	private boolean isTarefaEmAndamento;
	private boolean isTarefaConcluída;

	/*
	 * Método que seta a prioridade de uma tarefa no cadastro.
	 */
	public void definePrioridade() {
		if (isPrioridadeAlta) {
			tarefa.setPrioridade("ALTA");
		} else if (isPrioridadeMedia) {
			tarefa.setPrioridade("MEDIA");
		} else if (isPrioridadeBaixa) {
			tarefa.setPrioridade("BAIXA");
		}
	}

	/*
	 * Método usado para setar a situação de uma tarefa na busca.
	 */
	public void defineSituacao() {
		if (isTarefaConcluída) {
			tarefa.setSituacao("CONCLUÍDA");
		} else if (isTarefaEmAndamento) {
			tarefa.setSituacao("EM ANDAMENTO");
		}
	}

	public void listar() {
		listaTarefas = tarefaDao.listar();
		descricaoBusca = "";
	}

	public String buscarPorId(int id) {
		tarefa = tarefaDao.findById(id);
		System.out.println("buscou");
		return "";
	}

	public void verificaLista() {
		if (descricaoBusca == "") {
			listar();
		}
	}

	public String cadastrar() {
		tarefaDao.cadastrar(tarefa);
		verificaLista();
		tarefa = new Tarefa();
		return "";
	}

	public String deletar(int id) {
		tarefaDao.deletar(id);
		verificaLista();
		return "";
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public TarefaDAO getTarefaDao() {
		return tarefaDao;
	}

	public void setTarefaDao(TarefaDAO tarefaDao) {
		this.tarefaDao = tarefaDao;
	}

	public List<Tarefa> getListaTarefas() {
		return listaTarefas;
	}

	public void setListaTarefas(List<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}

	public String getNomeBusca() {
		return descricaoBusca;
	}

	public void setNomeBusca(String descricaoBusca) {
		this.descricaoBusca = descricaoBusca;
	}

	public String getDescricaoBusca() {
		return descricaoBusca;
	}

	public void setDescricaoBusca(String descricaoBusca) {
		this.descricaoBusca = descricaoBusca;
	}

	public boolean isCheckId() {
		return checkId;
	}

	public void setCheckId(boolean checkId) {
		this.checkId = checkId;
	}

	public boolean isCheckDescricao() {
		return checkDescricao;
	}

	public void setCheckDescricao(boolean checkDescricao) {
		this.checkDescricao = checkDescricao;
	}

	public boolean isCheckResponsavel() {
		return checkResponsavel;
	}

	public void setCheckResponsavel(boolean checkResponsavel) {
		this.checkResponsavel = checkResponsavel;
	}

	public boolean isCheckSituacao() {
		return checkSituacao;
	}

	public void setCheckSituacao(boolean checkSituacao) {
		this.checkSituacao = checkSituacao;
	}

	public Tarefa getFiltroId() {
		return filtroId;
	}

	public void setFiltroId(Tarefa filtroId) {
		this.filtroId = filtroId;
	}

	public Tarefa getFiltroDescricao() {
		return filtroDescricao;
	}

	public void setFiltroDescricao(Tarefa filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}

	public Tarefa getFiltroResponsavel() {
		return filtroResponsavel;
	}

	public void setFiltroResponsavel(Tarefa filtroResponsavel) {
		this.filtroResponsavel = filtroResponsavel;
	}

	public Tarefa getFiltroSituacao() {
		return filtroSituacao;
	}

	public void setFiltroSituacao(Tarefa filtroSituacao) {
		this.filtroSituacao = filtroSituacao;
	}

	public Tarefa getFiltroPrioridade() {
		return filtroPrioridade;
	}

	public void setFiltroPrioridade(Tarefa filtroPrioridade) {
		this.filtroPrioridade = filtroPrioridade;
	}

	public boolean isPrioridadeAlta() {
		return isPrioridadeAlta;
	}

	public void setPrioridadeAlta(boolean isPrioridadeAlta) {
		this.isPrioridadeAlta = isPrioridadeAlta;
	}

	public boolean isPrioridadeMedia() {
		return isPrioridadeMedia;
	}

	public void setPrioridadeMedia(boolean isPrioridadeMedia) {
		this.isPrioridadeMedia = isPrioridadeMedia;
	}

	public boolean isPrioridadeBaixa() {
		return isPrioridadeBaixa;
	}

	public void setPrioridadeBaixa(boolean isPrioridadeBaixa) {
		this.isPrioridadeBaixa = isPrioridadeBaixa;
	}

	public boolean isTarefaEmAndamento() {
		return isTarefaEmAndamento;
	}

	public void setTarefaEmAndamento(boolean isTarefaEmAndamento) {
		this.isTarefaEmAndamento = isTarefaEmAndamento;
	}

	public boolean isTarefaConcluída() {
		return isTarefaConcluída;
	}

	public void setTarefaConcluída(boolean isTarefaConcluída) {
		this.isTarefaConcluída = isTarefaConcluída;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
