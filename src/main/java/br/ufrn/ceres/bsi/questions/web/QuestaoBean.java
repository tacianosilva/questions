package br.ufrn.ceres.bsi.questions.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ufrn.ceres.bsi.questions.Questions;
import br.ufrn.ceres.bsi.questions.bo.NegocioException;
import br.ufrn.ceres.bsi.questions.model.Questao;

@ManagedBean(name = "questionsBean")
@SessionScoped
public class QuestaoBean extends AbstractBean implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private Questions questions = Questions.getInstance();

    private String descricao = null;

    private Questao questao = null;

    private List<Questao> questoes = null;

    public String manter() {
        return "/questao/manter";
    }

    private Questao getQuestao() {
        questao = new Questao();
        questao.setDescricao(getDescricao());
        return questao;
    }

    public String incluir() {
        FacesContext context = FacesContext.getCurrentInstance();
        setContext(context);

        // ResourceBundle bundle =
        // FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(),
        // "msg");
        // String messageSucesso =
        // bundle.getString("info.cursobean.incluir.sucesso");

        try {
            // O método retirna o curso com o código
            questions.inserirQuestao(getQuestao());
            context.addMessage("questaoBean.incluir", new FacesMessage(
                    msg("info.questaobean.incluir.sucesso")));
        } catch (NegocioException ex) {
            questoes = new ArrayList<Questao>();
            Logger.getLogger(QuestaoBean.class.getName()).log(Level.SEVERE,
                    ex.getMessage(), ex);
            context.addMessage("questaoBean.listar", new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Erro ao carregar a lista de questoes", ex.getMessage()));
        }
        return "/questao/manter";
    }

    public String listar() {
        try {
            questoes = questions.listarQuestoes();
        } catch (NegocioException ex) {
            questoes = new ArrayList<Questao>();
            Logger.getLogger(QuestaoBean.class.getName()).log(Level.SEVERE,
                    ex.getMessage(), ex);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("questaoBean.listar", new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Erro ao carregar a lista de questões", ex.getMessage()));
        }
        return "index";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Questao> getQuestoes() {
        listar();
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
}