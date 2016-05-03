package fr.inria.autojmh.humanmade.arregulo.reflection;

import java.util.Date;

public class A {
    private int count;
    protected String caption;
    long something;
    private Date timestamp;

    public A(Date timestamp, String caption) {
        this.timestamp = timestamp;
        this.caption = caption;

    }
}
