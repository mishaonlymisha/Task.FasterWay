package com.company.state;

import com.company.save.ArmyLocation;

public interface State {
    State moveToTheNextState();
    boolean isFinal();
    ArmyLocation savedData();
}
