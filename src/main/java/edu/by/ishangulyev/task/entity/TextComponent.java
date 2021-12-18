package edu.by.ishangulyev.task.entity;

import edu.by.ishangulyev.task.exception.TextException;

import java.util.List;

public interface TextComponent
{
    List<TextComponent> getChildNodes() throws TextException;
    List<TextComponent> getTextComponent() throws TextException;
    boolean add(TextComponent component) throws TextException;
    boolean remove(TextComponent component) throws TextException;
    TextType getType();
    String getValue();
    void setValue(String value);
}
