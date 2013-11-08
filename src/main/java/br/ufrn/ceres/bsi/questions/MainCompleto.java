package br.ufrn.ceres.bsi.questions;

import br.ufrn.ceres.bsi.questions.dao.UserService;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Endereco;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.model.Questao;
import br.ufrn.ceres.bsi.questions.model.Usuario;


public class MainCompleto {

    /**
     * Método main para testar os conceitos.
     * @param args
     */
    public static void main(String[] args) {
        //Criando questões
        Questao q1 = new Questao("q1");

        //Criando as alternativas
        Alternativa a1 = new Alternativa("a1");
        Alternativa a2 = new Alternativa("a2");
        Alternativa a3 = new Alternativa("a3");
        Alternativa a4 = new Alternativa("a4");
        Alternativa a5 = new Alternativa("a4");

        //Adicionando alternativas nas questões
        q1.addAlternativa(a1);
        q1.addAlternativa(a2);
        q1.addAlternativa(a3);
        q1.addAlternativa(a4);
        q1.addAlternativa(a5);
        q1.addAlternativaCorreta(a3);
        q1.addAlternativaCorreta(a5);

        Endereco endereco = new Endereco();
        endereco.setCity("Caic�");
        endereco.setCountry("Brasil");
        endereco.setStreet("Presidente Kennedy");
        endereco.setSuburb("Acampamento");

        Usuario user1 = new Usuario();
        user1.setUsername("tacianosilva");
        user1.setFirstname("Taciano");
        user1.setLastname("Silva");
        user1.setEmail("tacianosilva@gmail.com");
        user1.setPassword("12345");
        user1.setAddress(endereco);

        UserService service = new UserService(JPAUtil.EMF);
        service.create(user1);

    }
}