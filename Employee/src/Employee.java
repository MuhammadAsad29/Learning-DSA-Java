public class Employee {
    private String empId;
    public String getEmpId() {
        return empId;
    }
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public static void main(String[] args) {
        Employee obj = new Employee();
        obj.setEmpId("123123");
        String empId = obj.getEmpId();
        System.out.println("Empid: " + empId);
    }
}

// Empid: 123123