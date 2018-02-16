package com.company.save;

import com.company.strategy.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@ToString
@Getter
public class ArmyLocation {
    private final List<Point> pathForSave;
    private final String movingStateForSave;


}
