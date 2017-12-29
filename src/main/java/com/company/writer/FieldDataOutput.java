package com.company.writer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Getter
public class FieldDataOutput {
    private List<String> field;
    private int fasterWay;
}
