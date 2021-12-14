package edu.by.ishangulyev.task.parser;

import edu.by.ishangulyev.task.entity.TextComponent;
import edu.by.ishangulyev.task.entity.TextComposite;
import edu.by.ishangulyev.task.entity.TextType;
import edu.by.ishangulyev.task.entity.WordComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements TextParser
{
    private static final Logger logger = LogManager.getLogger();
    private static final String WORD_SPLIT_REGEX = "[ ,().!?”“=:]";
    @Override
    public void parse(TextComponent component, String text)
    {
        String[] words = text.split(WORD_SPLIT_REGEX);
        for (String i: words)
        {
            if(i.length() > 1)
            {
                component.add(new WordComposite(i.trim()));
            }
        }
        logger.log(Level.INFO,"Words are parsed");
    }
}
