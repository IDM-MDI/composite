package edu.by.ishangulyev.task.service.impl;

import edu.by.ishangulyev.task.entity.TextComponent;
import edu.by.ishangulyev.task.entity.TextType;
import edu.by.ishangulyev.task.exception.TextException;
import edu.by.ishangulyev.task.service.TextService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

    public class TextServiceImpl implements TextService
{
    private int longWord = 0;
    private TextComponent word;
    private final String VOWEL_REGEX = "[EeOoIiAaUu]";
    private final String CONSONANT_REGEX = "[QqWwRrTtYyPpSsDdFfGgHhJjKkLlZzXxCcVvBbNnMm]";
    private static final String WORD_SPLIT_REGEX = "[ ,().!?”“=:]";
    private List<String> words;

    @Override
    public void sortBySentence(TextComponent component) throws TextException
    {
        int paragraph = 0;
        int size = 0;
        for (int i = 0; i < component.getChildNodes().size(); i++)
        {
            if(size == 0)
            {
                size = component.getChildNodes().get(i).getChildNodes().size();
                paragraph = i;
                continue;
            }
            if(component.getChildNodes().get(i).getChildNodes().size() > size)
            {
                Collections.swap(component.getChildNodes(),i,paragraph);
                paragraph = i;
                size = component.getChildNodes().get(i).getChildNodes().size();
            }
        }
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

    private void findAllWords(TextComponent component) throws TextException
    {
        String[] splitResult = component.getValue().split(WORD_SPLIT_REGEX);
        words.addAll(Arrays.asList(splitResult));
        words.removeIf(String::isEmpty);
        words = words.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    @Override
    public String countSimilarWord(TextComponent component) throws TextException
    {
        words = new ArrayList<>();
        findAllWords(component);
        Collections.sort(words);
        int count = 0;

        StringBuilder result = new StringBuilder("Similar word: ");

        for (int i = 0; i < words.size(); i++)
        {
            if(i == 0)
            {
                count++;
                continue;
            }
            if(words.get(i).equals(words.get(i-1)))
            {
                count++;
            }
            else
            {
                if(count == 0) count++;
                result.append(words.get(i - 1)).append(" - count: ").append(count).append("\n");
                count = 0;
            }
        }
        return result.toString();
    }

    @Override
    public int vowelCount(TextComponent composite)
    {
        int count = 0;
        for (String i:composite.getValue().trim().split(""))
        {
            if(i.matches(VOWEL_REGEX)) count++;
        }
        return count;
    }

    @Override
    public int consonantCount(TextComponent component)
    {
        int count = 0;
        for (String i:component.getValue().trim().split(""))
        {
            if(i.matches(CONSONANT_REGEX)) count++;
        }
        return count;
    }

    private boolean isWordInArray(String word)
    {
        return words.stream().anyMatch(word::equals);
    }
}
