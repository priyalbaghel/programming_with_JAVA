class Mobile {
    String brand;
    String model;
    double price;

    // Default Constructor
    Mobile() {
        brand = "Samsung";
        model = "A15";
        price = 18000;
    }

    // Parameterized Constructor
    Mobile(String b, String m, double p) {
        brand = b;
        model = m;
        price = p;
    }

    // Copy Constructor
    Mobile(Mobile obj) {
        brand = obj.brand;
        model = obj.model;
        price = obj.price;
    }

    void display() {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : ₹" + price);
    }

    public static void main(String[] args) {

        // Default constructor
        Mobile m1 = new Mobile();

        // Parameterized constructor
        Mobile m2 = new Mobile("Apple", "iPhone 15", 79999);

        // Copy constructor (duplicate object)
        Mobile m3 = new Mobile(m2);

        System.out.println("Mobile 1:");
        m1.display();

        System.out.println("\nMobile 2:");
        m2.display();

        System.out.println("\nDuplicate Mobile Record:");
        m3.display();
    }
}
