package Chapter8.Examples;

//: polymorphism/RTTI.java
// Нисходящее преобразование и динамическое определение типов (RTTI).
// {ThrowsException}

class Useful {
    public void f() {}
    public void g() {}
}

class MoreUseful extends Useful {
    public void f() {}
    public void g() {}
    public void u() {}
    public void v() {}
    public void w() {}
}

public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {new Useful(), new MoreUseful()};
        x[0].f();
        x[1].g();
        // Стадия компиляции: метод не найден в классе Useful:
        //! x[1].u;
        ((MoreUseful)x[1]).u(); // Нисходящее преобразование / RTTI
        ((MoreUseful)x[0]).u(); // Происходит исключение
    }
} ///:~