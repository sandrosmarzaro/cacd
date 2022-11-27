import br.edu.ifes.cacd.Digrafo;
import br.edu.ifes.cacd.In;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Digrafo Teste")
public class DigrafoTeste {

    private final Digrafo digrafo = new Digrafo(new In("src/main/resources/data/digrafo1.txt"));

    @Test
    @DisplayName("Teste de número de vértices")
    public void verificaNumeroVerticeTest() {
        assertEquals(14, digrafo.V());
    }

    @Test
    @DisplayName("Teste de número de arestas")
    public void verificaNumeroArestaTest() {
        assertEquals(16, digrafo.A());
    }

    @Test
    @DisplayName("Teste de autor de cada artigo")
    public void verificaArtigoAutor() {
        assertEquals(0, digrafo.vertices().get(0));
        assertEquals(1, digrafo.vertices().get(1));
        assertEquals(2, digrafo.vertices().get(2));
        assertEquals(1, digrafo.vertices().get(3));
        assertEquals(0, digrafo.vertices().get(4));
        assertEquals(2, digrafo.vertices().get(5));
        assertEquals(0, digrafo.vertices().get(6));
        assertEquals(0, digrafo.vertices().get(7));
        assertEquals(2, digrafo.vertices().get(8));
        assertEquals(1, digrafo.vertices().get(9));
        assertEquals(3, digrafo.vertices().get(10));
        assertEquals(2, digrafo.vertices().get(11));
        assertEquals(1, digrafo.vertices().get(12));
        assertEquals(3, digrafo.vertices().get(13));
    }
}
