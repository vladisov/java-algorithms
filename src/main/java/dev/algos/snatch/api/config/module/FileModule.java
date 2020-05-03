package dev.algos.snatch.api.config.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import dev.algos.snatch.api.config.Routing;
import dev.algos.snatch.api.config.route.FileRouting;
import dev.algos.snatch.api.controller.FileController;
import dev.algos.snatch.api.service.FileStorage;
import dev.algos.snatch.api.service.FileStorageImpl;

public class FileModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FileController.class);
        bind(FileStorage.class).to(FileStorageImpl.class);
        Multibinder.newSetBinder(binder(), Routing.class).addBinding().to(FileRouting.class);
    }
}
