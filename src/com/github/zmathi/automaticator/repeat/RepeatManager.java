package com.github.zmathi.automaticator.repeat;

import com.google.common.collect.Lists;

import java.util.List;

public class RepeatManager {

    private List<Repeat> repeats;

    public RepeatManager() {
        repeats = Lists.newArrayList();
    }

    public List<Repeat> getRepeats() {
        return repeats;
    }
}
