package com.company.reader;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class FieldDataInput {
    @JsonProperty
    private List<String> field;
}


