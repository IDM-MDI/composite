package edu.by.ishangulyev.task.entity;

import edu.by.ishangulyev.task.exception.TextException;

import java.util.ArrayList;
import java.util.List;

public class ParagraphComposite implements TextComponent
{
    private List<TextComponent> sentence;
    private TextType type = TextType.PARAGRAPH;
    private String value;

    public ParagraphComposite(String value)
    {
        sentence = new ArrayList<>();
        this.value = value;
    }

    @Override
    public List<TextComponent> getChildNodes() throws TextException
    {
        return sentence.subList(0,sentence.size());
    }

    @Override
    public List<TextComponent> getTextComponent()
    {
        return sentence;
    }

    @Override
    public boolean add(TextComponent component)
    {
        return sentence.add(component);
    }

    @Override
    public String toString()
    {

        return "ParagraphComposite{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean remove(TextComponent component)
    {
        return sentence.remove(component);
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
