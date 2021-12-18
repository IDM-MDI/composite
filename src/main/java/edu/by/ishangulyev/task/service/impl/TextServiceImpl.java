package edu.by.ishangulyev.task.service.impl;

import edu.by.ishangulyev.task.entity.SentenceComposite;
import edu.by.ishangulyev.task.entity.TextComponent;
import edu.by.ishangulyev.task.entity.TextType;
import edu.by.ishangulyev.task.exception.TextException;
import edu.by.ishangulyev.task.service.TextService;

public class TextServiceImpl implements TextService
{
    private int longWord = 0;
    private TextComponent word;

    @Override
    public void sortBySentence(TextComponent component)
    {

    }

    @Override
    public TextComponent findLongWord(TextComponent component) throws TextException
    {
        for (int i = 0; i < component.getChildNodes().size(); i++)
        {
            if(component.getType().equals(TextType.WORD))
            {
                if(longWord < component.getValue().length())
                {
                    longWord = component.getValue().length();
                    word = component;
                }
            }
            else
            {
                findLongWord(component.getChildNodes().get(i));
            }
        }
        return word;
    }

    public void clearData()
    {
        longWord = 0;
        word = null;
    }

    @Override
    public void deleteLessThatNumber(TextComponent component, int number) throws TextException
    {
        for (int i = 0; i < component.getChildNodes().size(); i++)
        {
            if(component.getType().equals(TextType.SENTENCE))
            {
                if(component.getChildNodes().size() < number)
                {
                    for (int j = 0; j < component.getChildNodes().size(); j++)
                    {
                        component.remove(component.getChildNodes().get(j));
                    }
                }
                else
                {
                    return;
                }
            }
            else
            {
                deleteLessThatNumber(component.getChildNodes().get(i), number);
            }
        }
    }

    @Override
    public String countSimilarWord(TextComponent component)
    {
        return null;
    }

    @Override
    public int vowelCount(TextComponent composite)
    {
        return 0;
    }

    @Override
    public int consonantCount(TextComponent component)
    {
        return 0;
    }
}
