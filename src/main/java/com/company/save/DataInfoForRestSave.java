package com.company.save;

import com.company.strategy.Point;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class DataInfoForRestSave {
    @JsonProperty
    private List<String> field;
    private final List<Point> pathForSave;
    private final String movingStateForSave;
}
