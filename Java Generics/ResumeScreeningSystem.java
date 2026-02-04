import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract void screen();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void screen() {
        System.out.println("Screening Resume for Software Engineer: Checking Java, Spring, and System Design skills.");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void screen() {
        System.out.println("Screening Resume for Data Scientist: Checking Python, ML, and Statistics background.");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void screen() {
        System.out.println("Screening Resume for Product Manager: Checking Roadmap planning and UX experience.");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getRole() {
        return role;
    }
}

public class ResumeScreeningSystem {

    public static void processResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("AI Resume Screening Pipeline Started...\n");
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("Candidate: " + resume.getCandidateName());
            resume.getRole().screen();
        }
    }

    public static void main(String[] args) {
        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();

        resumeList.add(new Resume<>("Simran", new SoftwareEngineer()));
        resumeList.add(new Resume<>("Preeti", new DataScientist()));
        resumeList.add(new Resume<>("Kavya", new ProductManager()));
        resumeList.add(new Resume<>("Anjali", new SoftwareEngineer()));

        processResumes(resumeList);
    }
}
