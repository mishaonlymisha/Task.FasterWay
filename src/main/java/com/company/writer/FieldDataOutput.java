package com.company.writer;

import com.company.reader.FieldDataInput;
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
    private FieldDataInput field;
    private int fasterWay;
}
