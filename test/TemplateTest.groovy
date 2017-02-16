import org.junit.Before
import org.junit.Test
import org.testng.Assert

import static org.testng.Assert.*

/**
 * Najpier tworzymy test, później dodajemy do niego klasę Template (/scr)
 * W której dodajemy dopiero odpowiednio wyjaśnienie wymienionej w teście metody evaluate
 */
class TemplateTest {

    private static final EXPECTED_RESULT = "My name is Jan Kowalski"
    private Template template = new Template(textWithExpressions: 'My name is ${firstName} ${lastName}')
    private parameters = [firstName: 'Jan', lastName: 'Kowalski']

    @Before
    void init() {
        println 'itit'
    }

    @Test
    void shouldEvaluateWithExpression() {

        Template template = new Template(textWithExpressions: 'My name is ${firstName} ${lastName}')
        //assert "My name is Jan Kowalski" == template.evaluate([firstName: 'Jan', lastName: 'Kowalski'])
        //równoważna forma:
        assertEvaluate()
    }

    /**
     * możemy na poziomie testu sprawdzić czy wyjątek wystąpi,
     * ale należy pamiętać, że jeżeli nie wystąpi to test polegnie
     */
    @Test(expected = IllegalArgumentException.class)
    void shouldThrowExceptionParameterIsMissing() {
        template.evaluate([:])
    }

    @Test
    void shouldIgnoreExtraParameters(){
        parameters.put('extraKey','extraValue')
        assertEvaluate()
    }

    private void assertEvaluate(){
        assertEquals(EXPECTED_RESULT, template.evaluate(parameters))

    }
}