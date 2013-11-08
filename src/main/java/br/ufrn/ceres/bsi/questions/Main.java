package br.ufrn.ceres.bsi.questions;

import java.util.List;

import br.ufrn.ceres.bsi.questions.dao.UserService;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Endereco;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.model.Questao;
import br.ufrn.ceres.bsi.questions.model.Usuario;


public class Main {

    /**
     * Método main para testar os conceitos.
     * @param args
     */
    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        endereco.setCity("Caicó");
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

        Usuario user2 = new Usuario();
        user2.setUsername("xuxa");
        user2.setFirstname("Xuxa");
        user2.setLastname("????");
        user2.setEmail("xuxa@gmail.com");
        user2.setPassword("12345");
        user2.setAddress(endereco);

        UserService service = new UserService(JPAUtil.EMF);
        service.create(user1);
        service.create(user2);

        System.out.println(service.find(user1.getId()));
        System.out.println(service.find(user2.getId()));

        //service.delete(user1.getId());

        System.out.println(service.find(user1.getId()));
        System.out.println(service.find(user2.getId()));

        List<Usuario> lista = service.findByQuery("SELECT u FROM Usuario u");
        for (Usuario usuario : lista) {
            System.out.println(usuario);
        }

    }
}