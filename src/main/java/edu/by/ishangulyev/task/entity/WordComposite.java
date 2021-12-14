package edu.by.ishangulyev.task.entity;

import edu.by.ishangulyev.task.exception.TextException;

import java.util.ArrayList;
import java.util.List;

public class WordComposite implements TextComponent
{
    private List<TextComponent> symbols;
    private TextType type = TextType.WORD;
    private String value;

    public WordComposite(String value)
    {
        symbols = new ArrayList<>();
        this.value = value;
    }

    @Override
    public List<TextComponent> getChildNodes() throws TextException
    {
        return symbols.subList(0,symbols.size());
    }

    @Override
    public List<TextComponent> getTextComponent()
    {
        return symbols;
    }

    @Override
    public boolean add(TextComponent component)
    {
        return symbols.add(component);
    }

    @Override
    public boolean remove(TextComponent component)
    {
        return symbols.remove(component);
    }

    @Override
    public TextType getType()
    {
        return type;
    }

    @Override
    public String getValue()
    {
        return value;
    }

    @Override
    public void setValue(String value)
    {
        this.value = value;
    }
}
