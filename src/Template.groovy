class Template {
    String textWithExpressions

    private static final String  EXPRESSION_START = /\$\{/
    private static final String  EXPRESSION_END = /}/


    String evaluate(Map<String, String> parameters){
        //kopia tej zmiennej:
        String result = textWithExpressions
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
