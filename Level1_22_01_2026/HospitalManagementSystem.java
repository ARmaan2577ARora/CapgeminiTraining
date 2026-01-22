package Level1_22_01_2026;
import java.util.ArrayList;
import java.util.List;

class Patient {
    String name;
    int id;
    List<Doctor> doctors;

    public Patient(String name, int id) {
        this.name = name;
        this.id = id;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}

class Doctor {
    String name;
    String specialty;
    List<Patient> patients;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void consult(Patient patient) {
        System.out.println("Doctor " + name + " (" + specialty + ") is consulting patient " + patient.name + ".");
        this.addPatient(patient);
        patient.addDoctor(this);
    }

    @Override
    public String toString() {
        return "Dr. " + name + " [" + specialty + "]";
    }
}

class Hospital {
    String hospitalName;
    List<Doctor> doctors;
    List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showStats() {
        System.out.println("--- " + hospitalName + " Statistics ---");
        System.out.println("Doctors: " + doctors.size());
        System.out.println("Patients: " + patients.size());
        for (Doctor d : doctors) {
            System.out.println(d + " has " + d.patients.size() + " patients.");
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital cityHospital = new Hospital("City Central Hospital");

        Doctor drSmith = new Doctor("Smith", "Cardiologist");
        Doctor drAdams = new Doctor("Adams", "Neurologist");

        Patient p1 = new Patient("John Doe", 101);
        Patient p2 = new Patient("Jane Doe", 102);

        cityHospital.addDoctor(drSmith);
        cityHospital.addDoctor(drAdams);
        cityHospital.addPatient(p1);
        cityHospital.addPatient(p2);

        // Consultations show communication and create associations
        drSmith.consult(p1);
        drSmith.consult(p2);
        drAdams.consult(p1);

        System.out.println();
        cityHospital.showStats();
    }
}
