public class Car {
    public String make;
    public String model;
    public int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void getBrand() {
        System.out.println("This is the car class. Make: " + make + ", Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        Car obj = new Car("Umair", "Hammad", 2004);
        obj.getBrand();
    }
}

// This is the car class. Make: Umair, Model: Hammad, Year: 2004