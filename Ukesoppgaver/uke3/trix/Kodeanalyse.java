class Kodeanalyse{
    public static void main(String[] args){

        // X x1 = (X) new Y();
        // Y y1 = new Y();
        // //Y y2 = new X(); funker ikke
        // Y y3 = new Z();
        // Z z1 = new Z();
        // Z z2 = (Z) new X();

        S q = new G();
        Q b = new Q();
        B s = new Q();
        B g = new B();
        S p = new B();

        System.out.println(q instanceof B);
        System.out.println(q instanceof G);
        System.out.println(q instanceof S);
        System.out.println(b instanceof B);
        System.out.println(b instanceof S);
        System.out.println(s instanceof B);
        System.out.println(g instanceof Q);
        System.out.println(g instanceof S);
        System.out.println(p instanceof Q);
        System.out.println(p instanceof S);
        System.out.println(p instanceof G);

        Person pers, pers2;
        Student stud, stud2;
        BachelorStudent bachelor, bachelor2;

        pers = new Person();
        stud = new Student();
        bachelor = new BachelorStudent();

        pers2 = stud;                                 // (A)
        bachelor2 = (BachelorStudent) stud;           // (B)
        stud2 = (BachelorStudent) stud;               // (C)
        // stud2 = (Person) stud;                        // (D)
        // stud2 = (Student) bachelor; bachelor = stud2; // (E)
    }
}

class X {}
class Y extends X{}
class Z extends Y{}

class S {}
class G extends S {}
class Q extends B {}
class B extends S {}

class Person {   }
class Student extends Person {   }
class BachelorStudent extends Student {   }