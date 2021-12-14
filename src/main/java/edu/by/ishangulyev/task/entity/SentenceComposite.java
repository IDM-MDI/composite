package edu.by.ishangulyev.task.entity;

import edu.by.ishangulyev.task.exception.TextException;

import java.util.ArrayList;
import java.util.List;

public class SentenceComposite implements TextComponent
{
    private List<TextComponent> words;
    private TextType type = TextType.SENTENCE;
    private String value;

    public SentenceComposite(String value)
    {
        words = new ArrayList<>();
        this.value = value;
    }

    @Override
    public List<TextComponent> getChildNodes() throws TextException
    {
        return words.subList(0,words.size());
    }

    @Override
    public List<TextComponent> getTextComponent()
    {
        return words;
    }

    @Override
    public boolean add(TextComponent component)
    {
        return words.add(component);
    }

    @Override
    public boolean remove(TextComponent component)
    {
        return words.remove(component);
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
    public String toString()
    {
        return "SentenceComposite{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public void setValue(String value)
    {
        this.value = value;
    }
}
