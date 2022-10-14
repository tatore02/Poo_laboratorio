import org.junit.Assert;
import org.junit.Test;

public class InputCheckerTest {
    @Test
    public void rightTest(){
        InputChecker input = new InputChecker();
        Assert.assertEquals("OK",input.checkInput("SI"));
        Assert.assertEquals("OK",input.checkInput("OK"));
        Assert.assertEquals("OK",input.checkInput("S"));
        Assert.assertEquals("OK",input.checkInput("certo"));
        Assert.assertEquals("OK",input.checkInput("perchè no?"));
    }
    
   @Test
   public void falseTest(){
       InputChecker input = new InputChecker();
       Assert.assertEquals("Fine",input.checkInput("N"));
       Assert.assertEquals("Fine",input.checkInput("NO"));
   } 
   
   @Test
    public void elseTest(){
       InputChecker input = new InputChecker();
       Assert.assertEquals("Dato non corretto",input.checkInput("cetto la qualunque"));
   }
}