package dev.algos.snatch.api.service;

import com.google.inject.ImplementedBy;

@ImplementedBy(FileRunnerImpl.class)
public interface FileRunner {

    String runFile(String path, String fileName, String[] args);

    String runFunction(String path, String fileName, String functionName, String[] args);
}
