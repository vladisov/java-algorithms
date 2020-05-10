package dev.algos.snatch.api.parser;

public class PrimitiveParser implements Parser {

    @Override
    public Object parse(Class<?> parameter, String arg) {
        String typeName = parameter.getTypeName();
        if (typeName.equals(String.class.getName())) {
            return arg;
        }
        if (typeName.equals(Integer.class.getName()) || typeName.equals("int")) {
            return Integer.parseInt(arg);
        }
        if (typeName.equals(Long.class.getName()) || typeName.equals("long")) {
            return Integer.parseInt(arg);
        }
        throw new UnsupportedOperationException("Unsupported type name " + typeName);
    }
}
