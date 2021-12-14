package edu.by.ishangulyev.task.entity;

import edu.by.ishangulyev.task.exception.TextException;

import java.util.List;

public interface TextComponent
{
    List<TextComponent> getChildNodes() throws TextException;
    List<TextComponent> getTextComponent();
    boolean add(TextComponent component);
    boolean remove(TextComponent component);
    TextType getType();
    String getValue();
    void setValue(String value);
}
