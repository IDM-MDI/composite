package edu.by.ishangulyev.task.entity;

import edu.by.ishangulyev.task.exception.TextException;

import java.util.List;

public class SymbolComposite implements TextComponent
{
    private TextType type = TextType.LETTER;
    private Character value;

    public SymbolComposite()
    {

    }

    public SymbolComposite(Character value)
    {
        this.value = value;
    }

    public SymbolComposite(Character value, TextType type)
    {
        this.value = value;
        this.type = type;
    }

    @Override
    public void setValue(String value)
    {
        this.value = value.charAt(0);
    }
    @Override
    public String getValue()
    {
        return value.toString();
    }

    public void setValue(Character value)
    {
        this.value = value;
    }

    @Override
    public List<TextComponent> getChildNodes() throws TextException
    {
        return null;
    }

    @Override
    public List<TextComponent> getTextComponent()
    {
        return null;
    }

    @Override
    public boolean add(TextComponent component)
    {
        return false;
    }

    @Override
    public boolean remove(TextComponent component)
    {
        return false;
    }

    @Override
    public TextType getType()
    {
        return null;
    }
}
