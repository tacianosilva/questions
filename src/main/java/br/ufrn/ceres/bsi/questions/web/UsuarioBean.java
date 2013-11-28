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

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.ufrn.ceres.bsi.questions.Questions;
import br.ufrn.ceres.bsi.questions.bo.NegocioException;
import br.ufrn.ceres.bsi.questions.model.Usuario;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean extends AbstractBean implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private Questions questions = Questions.getInstance();

    private String nome = null;

    private String sobrenome = null;

    private String email = null;

    private String username = null;

    private Usuario usuario = null;

    private List<Usuario> usuarios = null;

    public UsuarioBean() {
        usuario = new Usuario();
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication){
                usuario.setUsername(((User)authentication.getPrincipal()).getUsername());
            }
        }
    }

    public String manter() {
        return "/usuario/manter";
    }

    private Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setFirstname(getNome());
        return usuario;
    }

    public String incluir() {
        FacesContext context = FacesContext.getCurrentInstance();
        setContext(context);

        try {
            // O método retorna o usuário com o código
            questions.inserirUsuario(getUsuario());
            context.addMessage("usuarioBean.incluir", new FacesMessage(
                    msg("info.usuariobean.incluir.sucesso")));
        } catch (NegocioException ex) {
            usuarios = new ArrayList<Usuario>();
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE,
                    ex.getMessage(), ex);
            context.addMessage("usuarioBean.listar", new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Erro ao carregar a lista de usuários", ex.getMessage()));
        }
        return "/usuario/manter";
    }

    public String listar() {
        try {
            usuarios = questions.listarUsuarios();
        } catch (NegocioException ex) {
            usuarios = new ArrayList<Usuario>();
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE,
                    ex.getMessage(), ex);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("usuarioBean.listar", new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Erro ao carregar a lista de usuarios", ex.getMessage()));
        }
        return "index";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Usuario> getUsuarios() {
        listar();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}