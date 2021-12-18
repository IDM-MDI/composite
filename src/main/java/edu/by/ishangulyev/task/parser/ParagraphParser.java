package edu.by.ishangulyev.task.parser;

import edu.by.ishangulyev.task.entity.ParagraphComposite;
import edu.by.ishangulyev.task.entity.TextComponent;
import edu.by.ishangulyev.task.entity.TextComposite;
import edu.by.ishangulyev.task.entity.TextType;
import edu.by.ishangulyev.task.exception.TextException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser implements TextParser
{
    private static final Logger logger = LogManager.getLogger();
    private static final String PARAGRAPH_REGEX = "   ";
    @Override
    public void parse(TextComponent component, String text) throws TextException
    {
        String[] splitText = text.split(PARAGRAPH_REGEX);
        for (String i: splitText)
        {
            if(i.length() > 1)
            {
                component.add(new ParagraphComposite(i.trim()));
            }
        }
        logger.log(Level.INFO,"Paragraph successful parsed");
    }
}

