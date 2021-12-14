package edu.by.ishangulyev.task.parser;

import edu.by.ishangulyev.task.entity.TextComponent;
import edu.by.ishangulyev.task.entity.TextComposite;
import edu.by.ishangulyev.task.entity.TextType;
import edu.by.ishangulyev.task.entity.SymbolComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser implements TextParser
{
    private static final Logger logger = LogManager.getLogger();
    private static final String LETTER_SPLIT_REGEX = "";
    @Override
    public void parse(TextComponent component, String text)
    {
        String[] splitText = text.split(LETTER_SPLIT_REGEX);
        for (String i:splitText)
        {
            if(i.length() < 2)
            {
                if(i.matches("[a-zA-Z]"))
                {
                    component.add(new SymbolComposite(i.charAt(0),TextType.LETTER));
                }
            }
        }
        logger.log(Level.INFO,"Letter successful parsed");
    }
}
