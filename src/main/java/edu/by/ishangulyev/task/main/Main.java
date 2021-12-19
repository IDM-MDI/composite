package edu.by.ishangulyev.task.main;

import edu.by.ishangulyev.task.entity.TextComponent;
import edu.by.ishangulyev.task.entity.TextComposite;
import edu.by.ishangulyev.task.entity.TextType;
import edu.by.ishangulyev.task.exception.TextException;
import edu.by.ishangulyev.task.parser.*;
import edu.by.ishangulyev.task.reader.ReaderBuilder;
import edu.by.ishangulyev.task.reader.impl.ReaderBuilderImpl;
import edu.by.ishangulyev.task.service.TextService;
import edu.by.ishangulyev.task.service.impl.TextServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static String path = "src/main/resources/files/text.txt";
    public static void main(String[] args) throws TextException
    {
        TextParser parser = new ParagraphParser();
        ReaderBuilder builder = new ReaderBuilderImpl();
        String text = builder.setPath(path).parse().getResult();
        TextComponent mainComponent = new TextComposite(TextType.TEXT);
        mainComponent.setValue(text);
        parser.parse(mainComponent, mainComponent.getValue());

        parser = new SentenceParser();
        List<TextComponent> paragr = mainComponent.getTextComponent();
        for (int i = 0; i < paragr.size(); i++)
        {
            parser.parse(paragr.get(i), paragr.get(i).getValue());
        }

        parser = new WordParser();
        for (int i = 0; i < mainComponent.getChildNodes().size(); i++)
        {
            for (int j = 0; j < mainComponent.getChildNodes().get(i).getChildNodes().size(); j++)
            {

                parser.parse(mainComponent.getChildNodes().get(i).getChildNodes().get(j),
                        mainComponent.getChildNodes().get(i).getChildNodes().get(j).getValue());
            }
        }

        parser = new SymbolParser();
        for (int i = 0; i < mainComponent.getChildNodes().size(); i++)
        {
            for (int j = 0; j < mainComponent.getChildNodes().get(i).getChildNodes().size(); j++)
            {
                for (int k = 0; k < mainComponent.getChildNodes().get(i).getChildNodes().get(j).getChildNodes().size(); k++)
                {
                    parser.parse(mainComponent.getChildNodes().get(i).getChildNodes().get(j).getChildNodes().get(k),
                            mainComponent.getChildNodes().get(i).getChildNodes().get(j).getChildNodes().get(k).getValue());

                }
            }
        }
        TextService service = new TextServiceImpl();
        service.sortBySentence(mainComponent);
    }
}
