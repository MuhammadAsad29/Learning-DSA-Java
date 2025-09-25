class Animal {
    public String type;
    private String name;

    Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    Dog(String type, String name) {
        super(type, name);
    }

    void run() {
        System.out.println(getName() + " is running");
    }

    public static void main(String[] args) {
        Dog obj = new Dog("Mammal", "Tiger");
        obj.eat();
        obj.run();
    }
}

// Tiger is eating
// Tiger is running