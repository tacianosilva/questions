package br.ufrn.ceres.bsi.questions.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.model.Questao;

public class QuestaoServiceTest {

    QuestaoService service = new QuestaoService(JPAUtil.EMF);
    Questao questao1;
    Questao questao2;
    Alternativa alt1;
    Alternativa alt2;
    Alternativa alt3;
    Alternativa alt4;
    Alternativa alt5;
    Alternativa alt6;

    @Before
    public void setUp() throws Exception {

        alt1 = new Alternativa("Sim");
        alt2 = new Alternativa("Não");

        questao1 = new Questao("Você gosta de Caicó?");
        questao1.addAlternativa(alt1);
        questao1.addAlternativa(alt2);

        alt3 = new Alternativa("Ótimo");
        alt4 = new Alternativa("Bom");
        alt5 = new Alternativa("Regular");
        alt6 = new Alternativa("Ruim");

        questao2 = new Questao("Qual seu nível de programador?");
        questao2.addAlternativa(alt3);
        questao2.addAlternativa(alt4);
        questao2.addAlternativa(alt5);
        questao2.addAlternativa(alt6);
    }

    @After
    public void tearDown() {
        try {
            if (service != null && questao1.getId() != null && questao2.getId() != null) {
                service.delete(questao1.getId());
                service.delete(questao2.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        questao1 = null;
        questao2 = null;
    }

    @Test
    public void testInserir() {
        Questao questao;
        try {
            assertEquals("1", null, questao1.getId());
            questao = service.create(questao1);
            assertNotNull("2", questao);
            assertNotNull("3", questao.getId());
            assertEquals("4", "Você gosta de Caicó?", questao.getDescricao());
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }
    /*
     * @Test public void testInserirDuplicata() { try { curso =
     * bo.inserir(curso); curso2 = bo.inserir(curso); } catch (NegocioException
     * e) { assertEquals("1",
     * "erro.curso.bo.inserir.PreexistingEntityException", e.getMessage());
     * e.printStackTrace(); } }
     *
     * @Test public void testBuscar() { try { curso = bo.inserir(curso);
     * assertNotNull("1", curso); assertNotNull("2", curso.getCodigo());
     * assertEquals("3", "Curso Teste", curso.getNome()); Curso buscado =
     * bo.buscarCurso(curso.getCodigo()); assertEquals("4", buscado.getCodigo(),
     * curso.getCodigo()); } catch (NegocioException e) { fail();
     * e.printStackTrace(); } }
     *
     *
     * @Test public void testExcluir() { try { curso = bo.inserir(curso2);
     * assertNotNull("1", curso2); assertNotNull("2", curso2.getCodigo());
     * assertEquals("3", "Curso Teste Excluir", curso.getNome()); Curso buscado
     * = bo.buscarCurso(curso2.getCodigo()); assertEquals("4",
     * buscado.getCodigo(), curso2.getCodigo()); bo.excluir(curso2.getCodigo());
     * buscado = bo.buscarCurso(curso2.getCodigo()); assertEquals("5", buscado,
     * null); } catch (NegocioException e) { fail(); e.printStackTrace(); } }
     *
     * //@Test public void testListar() { fail("Not yet implemented"); }
     */
}
