package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "cafer"),
        @JsonSubTypes.Type(value = Motorbike.class, name = "motorbike"),
        @JsonSubTypes.Type(value = RaceBike.class, name = "race-bike")
})
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property="className")


public abstract class Auto {
    protected String name;
    protected String owner;
    protected int age;
}