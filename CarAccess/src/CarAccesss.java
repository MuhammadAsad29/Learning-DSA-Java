class CarAccess {
    public  String make;
    private String model;
    protected int year;
    CarAccess(String make,String model,int year){
        this.make="Toyota";
        this.model="corrola";
        this.year=2012;
    }
    public String getModel() {
        return model;
    }
    private void displayYear() {
        System.out.println(year);
    }
    void display() {
        System.out.println("make "+ make);
        System.out.println("model "+ model);
        System.out.println("year "+ year);
    }
    public static void main (String[]args) {
        CarAccess obj = new CarAccess("Honda","CIVIC",2015);
        obj.display();
    }
}

// make Toyota
// model corrola
// year 2012