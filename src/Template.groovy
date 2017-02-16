class Template {
    String textWithExpressions

    String evaluate(Map<String, String> parameters){
        //kopia tej zmiennej:
        String result = textWithExpressions
        //iterujemy po wszystkich elementach:
        parameters.each { name, value ->
            result = result.replaceAll(/\$\{/ + name+ /}/, value)
        }
        return result
    }
}
