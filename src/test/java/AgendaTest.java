import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class AgendaTest {
    @BeforeEach
    public void uwu(){

    try {
        Init.csvReadA();
        Init.csvReadE();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
@Test
    void test(){
    System.out.println(Agenda.compararEspecialista("Juan Carlos Bodoque"));
    }
    @Test
    void test2(){
            int counter=0;
        for (Especialista e:Especialista.especialistas
        ) {
            if(e.isFonasa()){
                ++counter;
                System.out.println();
                System.out.println("Indice: "+counter);
                e.show();
            }
        }
        System.out.println(Especialista.especialistas.get(3));
    }
}