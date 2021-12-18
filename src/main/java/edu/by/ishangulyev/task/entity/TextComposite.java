package edu.by.ishangulyev.task.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent
{
    private List<TextComponent> paragraphs;
    private TextType type = TextType.TEXT;
    private String value;


    public TextComposite(TextType type)
    {
        this.type = type;
        paragraphs = new ArrayList<>();
    }
    public TextComposite(String value,TextType type)
    {
        this.type = type;
        paragraphs = new ArrayList<>();
    }

    @Override
    public List<TextComponent> getChildNodes()
    {
        return paragraphs.subList(0,paragraphs.size());
    }

    @Override
    public List<TextComponent> getTextComponent()
    {
        return paragraphs;
    }

    public List<TextComponent> getParagraphs()
    {
        return List.copyOf(paragraphs);
    }

    @Override
    public boolean add(TextComponent component)
    {
        return paragraphs.add(component);
    }

    @Override
    public boolean remove(TextComponent component)
    {
        return paragraphs.remove(component);
    }

    @Override
    public TextType getType()
    {
        return this.type;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        return sb.append("Text{ ")
                .append("value = ")
                .append(value)
                .append(" }")
                .toString();
    }
}
