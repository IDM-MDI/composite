package edu.by.ishangulyev.task.reader.impl;

import edu.by.ishangulyev.task.exception.TextException;
import edu.by.ishangulyev.task.reader.ReaderBuilder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderBuilderImpl implements ReaderBuilder
{
    private static final Logger logger = LogManager.getLogger();
    private String path;
    private String result;
    @Override
    public ReaderBuilder setPath(String path)
    {
        this.path = path;
        return this;
    }

    @Override
    public ReaderBuilder parse() throws TextException
    {
        StringBuilder stringBuilder = new StringBuilder();
        result = "";
        try(Stream<String> streamlines = Files.lines(Paths.get(path)))
        {
            streamlines.forEach(stringBuilder::append);
        }
        catch (IOException e)
        {
            logger.log(Level.ERROR,"Error while parsing");
            throw new TextException("Error while parsing");
        }
        finally
        {
            result = stringBuilder.toString();
            logger.log(Level.INFO,"File successfully parsed");
        }
        return this;
    }

    @Override
    public String getResult()
    {
        return String.copyValueOf(result.toCharArray());
    }
}
