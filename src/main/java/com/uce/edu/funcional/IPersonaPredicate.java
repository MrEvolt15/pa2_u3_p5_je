package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaPredicate <T> {
    public boolean evaluate(T arg);
}
