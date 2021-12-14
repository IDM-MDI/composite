package edu.by.ishangulyev.task.reader;

import edu.by.ishangulyev.task.exception.TextException;

public interface ReaderBuilder
{
    ReaderBuilder setPath(String path);
    ReaderBuilder parse() throws TextException;
    String getResult();
}
