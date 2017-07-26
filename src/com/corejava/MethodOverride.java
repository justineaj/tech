package com.corejava;

class Bar{
    public void test() {
        testPrivate();
        testPublic();
    }

    public void testPublic() {
        System.out.println( "Bar::testPublic");
    }

    private void testPrivate() {
        System.out.println( "Bar::testPrivate");
    }
}

class Foo extends Bar
{
    public void testPublic() {
        System.out.println( "Foo::testPublic");
    }

    private void testPrivate() {
        System.out.println( "Foo::testPrivate");
    }
}

class MethodOverride{
    public static void main(String args[]){
        Foo foo = new Foo();
        foo.test();
    }
}

