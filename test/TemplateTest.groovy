import org.junit.Test
import org.testng.Assert

/**
 * Najpier tworzymy test, później dodajemy do niego klasę Template (/scr)
 * W której dodajemy dopiero odpowiednio wyjaśnienie wymienionej w teście metody evaluate
 */
class TemplateTest{

    @Test
    void shouldEvaluateWithExpression(){

        Template template = new Template(textWithExpressions: 'My name is ${firstName} ${lastName}')
        //assert "My name is Jan Kowalski" == template.evaluate([firstName: 'Jan', lastName: 'Kowalski'])
        //równoważna forma:
        Assert.assertEquals("My name is Jan Kowalski",template.evaluate([firstName: 'Jan', lastName: 'Kowalski']))
    }
}