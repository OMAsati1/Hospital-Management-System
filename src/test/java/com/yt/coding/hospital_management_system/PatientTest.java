package com.yt.coding.hospital_management_system;

// import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;

// import com.yt.coding.hospital_management_system.dto.BloodGroupCountResponseEntity;
import com.yt.coding.hospital_management_system.entity.Patient;
// import com.yt.coding.hospital_management_system.entity.type.BloodGroupType;
import com.yt.coding.hospital_management_system.repository.PatientRepository;
import com.yt.coding.hospital_management_system.service.PatientService;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patients = patientRepository.findAllPatientWithAppoinments
        
        ();
        System.out.println(patients);
    }

    @Test
    public void testTransactionMethods() {
        // Patient patient = patientService.getPatientById(7L);
        // System.out.println(patient);

        // Patient patient = patientRepository.findByName("Diya Patel");
        // System.out.println(patient);

        /*
         * List<Patient> patientList =
         * patientRepository.findByBirthDateOrEmail(LocalDate.of(1988, 03, 15),
         * "aarav.sharma@example.com");
         * for (Patient patient : patientList) {
         * System.out.println(patient);
         * }
         */

        /*
         * List<Patient> patientList =
         * patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
         * for (Patient patient : patientList) {
         * System.out.println(patient);
         * }
         */

        /*
         * List<Patient> patientList =
         * patientRepository.findByBornAfterDate(LocalDate.of(1990, 01, 01));
         * for (Patient patient : patientList) {
         * System.out.println(patient);
         * }
         */

        /*
         * List<Object[]> results = patientRepository.countEachBloodGroupType();
         * for (Object[] result : results) {
         * BloodGroupType bloodGroup = (BloodGroupType) result[0];
         * Long count = (Long) result[1];
         * System.out.println("Blood Group: " + bloodGroup + ", Count: " + count);
         * }
         */

        Page<Patient> patients = patientRepository.findAllPatients(PageRequest.of(1 , 2));
        for (Patient patient : patients) {
            System.out.println(patient);
        }

           /*  int rowsUpdated = patientRepository.updateNameById("Arav Sharma", 1L);
            System.out.println("Number of rows updated: " + rowsUpdated); */

            /* List<BloodGroupCountResponseEntity> results = patientRepository.countEachBloodGroupType();
            for (BloodGroupCountResponseEntity result : results) {  
                System.out.println(result);
            } */
    }
        @Test
    public void testDeletePatientById() {

        // when
        patientService.removPatientById(3L);

        // then (basic verification)
        System.out.println("Patient with ID 3 deleted");
    }
}
