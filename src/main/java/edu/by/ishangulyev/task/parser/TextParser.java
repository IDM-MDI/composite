package edu.by.ishangulyev.task.parser;

import edu.by.ishangulyev.task.entity.TextComponent;
import edu.by.ishangulyev.task.exception.TextException;

public interface TextParser
{
    void parse(TextComponent component, String text) throws TextException;
}
