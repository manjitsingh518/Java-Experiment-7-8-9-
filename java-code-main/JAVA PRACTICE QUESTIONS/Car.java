class Car {
    String make, model;

    Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry");
        System.out.println(car.make + " " + car.model);
    }
}
