/**
 * @author Jose Prince
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestRadio {
    
    IRadio miRadio = new Radio();

    
    /** 
     * @throws Exception
     */
    @Test
    public void setFrequenceAMTest() throws Exception{
        miRadio.setFrequence("AM");
        String frecuencia = miRadio.getFrequence();
        assertEquals("AM", frecuencia);

    }

    
    /** 
     * @throws Exception
     */
    @Test
    public void setFrequenceFMTest() throws Exception{
        miRadio.setFrequence("FM");
        String frecuencia = miRadio.getFrequence();
        assertEquals("FM", frecuencia);

    }

    
    /** 
     * @throws Exception
     */
    @Test
    public void ForwardTest() throws Exception{
        miRadio.setFrequence("FM");
        miRadio.Forward();
        double estacion = miRadio.getFMActualStation();
        assertEquals(88.1, estacion, 88.1);
    }

    
    /** 
     * @throws Exception
     */
    @Test
    public void BackwardTest() throws Exception{
        miRadio.setFrequence("AM");
        miRadio.Forward();
        double estacion = miRadio.getAMActualStation();
        assertEquals(1610, estacion, 1610);
    }
}
