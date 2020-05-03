package dev.algos.snatch.api.config;

import com.google.inject.Inject;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Singleton
public class Startup {
    @Inject(optional = true)
    private Map<EntrypointType, AppEntrypoint> entryPoints = Collections.emptyMap();

    public void boot(EntrypointType entrypointType, String[] args) {
        var entryPoint = Optional.ofNullable(entryPoints.get(entrypointType));
        entryPoint.orElseThrow(() -> new RuntimeException("Entrypoint not defined")).boot(args);
    }
}
