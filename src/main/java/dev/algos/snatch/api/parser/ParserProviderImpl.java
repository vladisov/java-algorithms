package dev.algos.snatch.api.parser;

import org.apache.commons.lang3.ClassUtils;

import javax.inject.Singleton;

@Singleton
public class ParserProviderImpl implements ParserProvider {
    @Override
    public Parser provide(Class<?> parameter) {
        if (parameter.isArray()) {
            return provideArrayParser(parameter);
        }
        return new PrimitiveParser();
    }

    private Parser provideArrayParser(Class<?> parameter) {
        String typeName = parameter.getTypeName();
        try {
            var aClass = ClassUtils.getClass(typeName);
            int dims = aClass.getName().lastIndexOf("[") + 1;

            return new IntArrayParser(dims);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Incorrect type provided");
        }
    }
}
