package br.ufrn.ceres.bsi.questions;

import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.model.Questao;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

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

    }

}
