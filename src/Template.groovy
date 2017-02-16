/**
 * Dopisujemy kod do testów, mamy pewność 100% pokrycia kodu przez testy
 * Gdyby klasa zaczęła dziedziczyć inne, musielibyśmy użyć mocków, aby skupić się na fragmencie kodu
 */
class Template {

    private static final String  EXPRESSION_START = /\$\{/
    private static final String  EXPRESSION_END = /}/
    // . dowlony znak, * dowolna ich ilość, $ dosłownie, { dosłownie, ^ zaprzeczenie dotyczące [], + przynajmniej raz :
    private static final String EXPRESSION = /.*\$\{[^}]+\}.*/

    String textWithExpressions

    String evaluate(Map<String, String> parameters){
        String result = substitute(parameters)
        if (result =~ EXPRESSION){
            throw new IllegalArgumentException()
        }
        return result
    }

    private String substitute(Map<String,String> parameters){

        String result = textWithExpressions //kopia tej zmiennej
        //iterujemy po wszystkich elementach:
        parameters.each { name, value ->
            result = result.replaceAll(createExpression(name), value)
        }
        return result
    }

    private String createExpression(String name){
        EXPRESSION_START + name+ EXPRESSION_END
    }

}
