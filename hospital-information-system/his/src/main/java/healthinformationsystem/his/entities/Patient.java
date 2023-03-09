package healthinformationsystem.his.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private int weightInKg;
    private double heightInMetres;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate firstAdmissionDate;
//    @OneToMany
//    private Set<Illness> illnesses;
//    private Set<String> allergies;
//    private Set<MedicalExamination> medicalExaminations;
//    @ManyToOne
//    @JoinColumn(name = "ward_id")
//    private Ward ward;

    @Transient
    private long age;

//    public Ward getWard() {
//        return ward;
//    }
//
//    public void setWard(Ward ward) {
//        this.ward = ward;
//    }

    @PostLoad
    private void calculateAge(){
        this.age = ChronoUnit.YEARS.between(super.getBirthDate(), LocalDate.now());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(int weightInKg) {
        this.weightInKg = weightInKg;
    }

    public double getHeightInMetres() {
        return heightInMetres;
    }

    public void setHeightInMetres(double heightInMetres) {
        this.heightInMetres = heightInMetres;
    }

    public LocalDate getFirstAdmissionDate() {
        return firstAdmissionDate;
    }

    public void setFirstAdmissionDate(LocalDate firstAdmissionDate) {
        this.firstAdmissionDate = firstAdmissionDate;
    }

//    public Set<Illness> getIllnesses() {
//        return illnesses;
//    }
//
//    public void setIllnesses(Set<Illness> illnesses) {
//        this.illnesses = illnesses;
//    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

//    public Set<String> getAllergies() {
//        return allergies;
//    }
//
//    public void setAllergies(Set<String> allergies) {
//        this.allergies = allergies;
//    }
//
//    public Set<MedicalExamination> getMedicalExaminations() {
//        return medicalExaminations;
//    }
//
//    public void setMedicalExaminations(Set<MedicalExamination> medicalExaminations) {
//        this.medicalExaminations = medicalExaminations;
//    }
//


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", weightInKg=" + weightInKg +
                ", heightInMetres=" + heightInMetres +
                ", firstAdmissionDate=" + firstAdmissionDate +
//                ", illnesses=" + illnesses +
//                ", ward=" + ward +
                ", age=" + age +
                "} " + super.toString();
    }
}
