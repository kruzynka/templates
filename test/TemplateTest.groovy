import org.junit.Before
import org.junit.Test
import org.testng.Assert

import static org.testng.Assert.*

/**
 * Najpierw tworzymy test, później dodajemy do niego klasę Template (pod /scr)
 * w której dopiero dodajemy odpowiedni kod programu, który jest testowany w TemplateTest
 */
class TemplateTest {

    private static final EXPECTED_RESULT = "My name is Jan Kowalski"
    private Template template = new Template(textWithExpressions: 'My name is ${firstName} ${lastName}')
    private parameters = [firstName: 'Jan', lastName: 'Kowalski']

    //tylko na dowód tego, że przeodzę przez kolejne testy
    @Before
    void init() {
        println 'itit'
    }

    @Test
    void shouldEvaluateWithExpression() {

        //równoważna forma: assert EXPECTED_RESULT == template.evaluate(parameters)
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