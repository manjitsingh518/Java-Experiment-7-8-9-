class Parent {
    String name;

    Parent(String name) {
        this.name = name;
    }
}

class Child extends Parent {
    Child(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Child child = new Child("John");
        System.out.println(child.name);
    }
}