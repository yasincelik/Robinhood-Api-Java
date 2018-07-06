package com.ampro.robinhood.net.pagination;

import java.lang.reflect.ParameterizedType;

public class GenericTest {

    static class A {
    }

    static class B<E extends C> extends A {
        B() {
        }
    }

    static class C {
    }

    static class D {
        D(B<C> thing) {

        }
    }

    public static void main(String[] args) {
        A b = new B<C>();
        System.out.println(b.getClass().getName());

    }

}
