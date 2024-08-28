package tn.essat.nlpchatbot.entity.Enum;

public enum TypeBeta {
    PERSON("Person"),
    ORGANIZATION("Organization"),
    LOCATION("Location"),
    DATE("Date"),
    TIME("Time"),
    EMAIL("Email"),
    MONEY("Money"),
    MEDICAL_CONDITION("Medical_Condition"),
    TREATMENT("Treatment"),
    MEDICATION("Medication"),
    INSURANCE_POLICY("Insurance_Policy"),
    COMPLAINT_TYPE("Complaint_Type"),
    APPOINTMENT("Appointment"),
    MEDICAL_PROCEDURE("Medical_Procedure"),
    DIAGNOSIS("Diagnosis"),
    SYMPTOMS("Symptoms"),
    INSURANCE_CLAIM("Insurance_Claim"),
    CONTACT_INFO("Contact_Info"),
    ADDRESS("Address"),
    EMERGENCY("Emergency"),
    PATIENT_ID("Patient_ID"),
    CITY("City"),
    STATE_OR_PROVINCE("State_Or_Province"),
    COUNTRY("Country");

    private final String type;

    TypeBeta(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return type;
    }
}
