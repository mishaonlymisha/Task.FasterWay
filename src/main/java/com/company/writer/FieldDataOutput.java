package com.company.writer;

import com.company.reader.FieldDataInput;
import com.company.strategy.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.util.List;

@AllArgsConstructor
@ToString
@Getter
public class FieldDataOutput {
    @JsonUnwrapped
    private List<String> field;
    private List<Point> path;
    private String movingState;
}
