// Abstract class Patient
abstract class Patient {
    protected int patientId;
    protected String name;
    protected int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private String medicalHistory;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        this.medicalHistory = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History: " + medicalHistory);
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String diagnosis;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        this.diagnosis = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("Diagnosis: " + diagnosis);
    }
}

// Main class to demonstrate polymorphism
public class HospitalManagement {
    public static void main(String[] args) {
        Patient inpatient = new InPatient(101, "John Doe", 45, 5, 2000);
        Patient outpatient = new OutPatient(102, "Jane Smith", 30, 500);

        inpatient.getPatientDetails();
        System.out.println("Bill: Rs." + inpatient.calculateBill());
        System.out.println();

        outpatient.getPatientDetails();
        System.out.println("Bill: Rs." + outpatient.calculateBill());
    }
}
