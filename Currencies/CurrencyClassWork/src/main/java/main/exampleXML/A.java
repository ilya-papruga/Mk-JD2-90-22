package main.exampleXML;

import main.exampleXML.api.IA;
import main.exampleXML.api.IB;
import main.exampleXML.api.IC;

public class A implements IA {

    private final IB b;
    private final IC c;

    public A(IB b, IC c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public void print() {
        System.out.println(b);
        System.out.println(c);
    }
}
