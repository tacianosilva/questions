package br.ufrn.ceres.bsi.questions.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
public class Usuario extends BaseEntity implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5370901970072298180L;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @Column(length = 50)
    private String email;

    @Column(length = 64)
    private String password;

    @OneToOne(cascade = {CascadeType.ALL})
    private Endereco endereco;

    public Usuario() {
        endereco = new Endereco();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Endereco getAddress() {
        return this.endereco;
    }

    public void setAddress(Endereco endereco) {
        this.endereco = endereco;
    }
}