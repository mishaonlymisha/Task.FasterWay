package com.company.fieldClasses;

import com.company.strategy.Point;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterOfDataField {
    public Field convert(List<String> data) {
        List<List<String>> splitLines = splitTheLines(data);
        List<List<Cells>> field = createCellsField(splitLines).getKey();
        Point start = createCellsField(splitLines).getValue().getKey();
        Point finish = createCellsField(splitLines).getValue().getValue();
        return new Field(field, finish, start);
    }

    private Pair<List<List<Cells>>, Pair<Point, Point>> createCellsField(List<List<String>> splitLines) {
        List<List<Cells>> field = new ArrayList<>();
        Point finish = null;
        Point start = null;
        for (int i = 0; i < splitLines.size(); i++) {
            List<Cells> lineOfCells = new ArrayList<>();
            for (int j = 0; j < splitLines.get(i).size(); j++) {
                switch (splitLines.get(i).get(j)) {
                    case "*":
                        lineOfCells.add(new SimpleCell(new Point(j, i), null, true));
                        break;
                    case "s":
                        lineOfCells.add(new SimpleCell(new Point(j, i), null, true));
                        start = new Point(j, i);
                        break;
                    case "f":
                        lineOfCells.add(new SimpleCell(new Point(j, i), null, true));
                        finish = new Point(j, i);
                        break;
                    case "^":
                        lineOfCells.add(new SimpleCell(new Point(j, i), null, false));
                        break;
                    default:

                        List<String> hisPorts = splitPorts(splitLines.get(i).get(j)).getValue();
                        lineOfCells.add(new SimpleCell(new Point(j, i), findHisPorts(hisPorts, splitLines), true));

                }
            }
            field.add(lineOfCells);
        }
        return new Pair<>(field, new Pair<>(start, finish));
    }

    private List<List<String>> splitTheLines(List<String> stringsForSplit) {
        List<List<String>> splitTheLines = new ArrayList<>();
        for (int i = 0; i < stringsForSplit.size(); i++) {
            splitTheLines.add(new ArrayList<>(Arrays.asList(stringsForSplit.get(i).split(Pattern.quote("|")))));
        }
        return splitTheLines;
    }

    private boolean matcherMatches(String string) {
        Pattern pattern = Pattern.compile("(?<port>p\\d+)->(?<ports>(p\\d+,)*(p\\d+))");
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    private Point findPort(String port, List<List<String>> splitLines) {
        for (int i = 0; i < splitLines.size(); i++) {
            for (int j = 0; j < splitLines.get(i).size(); j++) {
                if (matcherMatches(splitLines.get(i).get(j))) {
                    if (port.equals(splitPorts(splitLines.get(i).get(j)).getKey())) {
                        return new Point(j, i);
                    }
                }
            }
        }
        return null;
    }

    private Pair<String, List<String>> splitPorts(String stringOfPorts) {
        Pattern pattern = Pattern.compile("(?<port>p\\d+)->(?<ports>(p\\d+,)*(p\\d+))");
        Matcher matcher = pattern.matcher(stringOfPorts);
        if (matcher.matches()) {
            String port = matcher.group("port");
            List<String> ports = Arrays.asList(matcher.group("ports").split(","));
            return new Pair<>(port, ports);
        } else {
            throw new RuntimeException();
        }
    }

    private List<Point> findHisPorts(List<String> hisPorts, List<List<String>> splitLines) {
        List<Point> resultList = new ArrayList<>();
        for (int i = 0; i < hisPorts.size(); i++) {
            resultList.add(findPort(hisPorts.get(i), splitLines));
        }
        return resultList;
    }
}
