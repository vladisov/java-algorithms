package dev.algos.snatch.api.parser;

import com.google.inject.ImplementedBy;

@ImplementedBy(ParserProviderImpl.class)
public interface ParserProvider {

    Parser provide(Class<?> parameter);
}
