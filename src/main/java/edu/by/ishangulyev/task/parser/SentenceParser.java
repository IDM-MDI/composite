package edu.by.ishangulyev.task.parser;

import edu.by.ishangulyev.task.entity.SentenceComposite;
import edu.by.ishangulyev.task.entity.TextComponent;
import edu.by.ishangulyev.task.entity.TextComposite;
import edu.by.ishangulyev.task.entity.TextType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements TextParser
{
    private static final Logger logger = LogManager.getLogger();
    private static final String SENTENCE_REGEX = "[.?!]";
    @Override
    public void parse(TextComponent component, String text)
    {
        String[] splitText = text.split(SENTENCE_REGEX);
        for (String i: splitText)
        {
            component.add(new SentenceComposite(i.trim()));
        }
        logger.log(Level.INFO,"Sentence successful parsed");
    }
}
