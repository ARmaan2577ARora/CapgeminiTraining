interface MedicalRecord {
    void addRecord(String record);

    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String[] records;
    private int recordCount;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.records = new String[10]; 
        this.recordCount = 0;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    protected void internalAddRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount++] = record;
        } else {
            System.out.println("Medical record limit reached for patient " + name);
        }
    }

    protected String[] internalGetRecords() {
        return records;
    }

    protected int getRecordCount() {
        return recordCount;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }
}

class InPatient extends Patient implements MedicalRecord {
    private double perDayCharge;
    private int daysStayed;

    public InPatient(String patientId, String name, int age, double perDayCharge, int daysStayed) {
        super(patientId, name, age);
        this.perDayCharge = perDayCharge;
        this.daysStayed = daysStayed;
    }

    @Override
    public double calculateBill() {
        return perDayCharge * daysStayed;
    }

    @Override
    public void addRecord(String record) {
        internalAddRecord("In-Patient Record: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        String[] recs = internalGetRecords();
        for (int i = 0; i < getRecordCount(); i++) {
            System.out.println("- " + recs[i]);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        internalAddRecord("Out-Patient Consultation: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        String[] recs = internalGetRecords();
        for (int i = 0; i < getRecordCount(); i++) {
            System.out.println("- " + recs[i]);
        }
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient[] patients = new Patient[2];

        InPatient p1 = new InPatient("P101", "John Smith", 45, 2000, 5);
        p1.addRecord("Diagnosed with Fever");
        p1.addRecord("Administered Paracetamol");
        patients[0] = p1;

        OutPatient p2 = new OutPatient("P201", "Jane Doe", 30, 500);
        p2.addRecord("Routine Checkup");
        patients[1] = p2;

        System.out.println("--- Hospital Patient Management ---");
        for (Patient p : patients) {
            if (p != null) {
                p.getPatientDetails();
                System.out.println("Total Bill: " + p.calculateBill());
                if (p instanceof MedicalRecord) {
                    ((MedicalRecord) p).viewRecords();
                }
            }
        }
    }
}
