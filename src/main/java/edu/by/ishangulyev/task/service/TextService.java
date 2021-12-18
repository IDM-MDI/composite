package edu.by.ishangulyev.task.service;

import edu.by.ishangulyev.task.entity.SentenceComposite;
import edu.by.ishangulyev.task.entity.TextComponent;
import edu.by.ishangulyev.task.entity.TextComposite;
import edu.by.ishangulyev.task.exception.TextException;

public interface TextService
{
    void sortBySentence(TextComponent component);
    TextComponent findLongWord(TextComponent component) throws TextException;
    void deleteLessThatNumber(TextComponent component,int number) throws TextException;
    String countSimilarWord(TextComponent component);
    int vowelCount(TextComponent composite);
    int consonantCount(TextComponent component);
}
