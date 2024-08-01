package ContactService;

public class Contact {

    private final String contactID;
    private String contactFirstName;
    private String contactLastName;
    private String contactPhoneNum;
    private String contactAddress;
    
    // Variables for parameter checks
    private static final int MAX_LENGTH_CONTACT_ID = 10;
    private static final int MAX_LENGTH_FIRST_NAME = 10;
    private static final int MAX_LENGTH_LAST_NAME = 10;
    private static final int LENGTH_PHONE_NUM = 10;
    private static final int MAX_LENGTH_ADDRESS = 30;
    
    // Function for parameter checks
    private boolean isValidParameter(String value, int maxLength) {
        return value != null && value.length() <= maxLength;
    }

    private boolean isValidPhoneNumber(String phoneNum) {
        if (phoneNum == null || phoneNum.length() != LENGTH_PHONE_NUM) {
            return false;
        }
        for (char c : phoneNum.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    // Create new contact
    public Contact(String contactID, String contactFirstName, String contactLastName, String contactPhoneNum, String contactAddress) {
        if (!isValidParameter(contactID, MAX_LENGTH_CONTACT_ID)) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (!isValidParameter(contactFirstName, MAX_LENGTH_FIRST_NAME)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (!isValidParameter(contactLastName, MAX_LENGTH_LAST_NAME)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (!isValidPhoneNumber(contactPhoneNum)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (!isValidParameter(contactAddress, MAX_LENGTH_ADDRESS)) {
            throw new IllegalArgumentException("Invalid address");
        }
        
        this.contactID = contactID;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactPhoneNum = contactPhoneNum;
        this.contactAddress = contactAddress;
    }
    
    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactPhoneNum() {
        return contactPhoneNum;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    // Setters with checks included
    public void setContactFirstName(String newFirstName) {
        if (!isValidParameter(newFirstName, MAX_LENGTH_FIRST_NAME)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        contactFirstName = newFirstName;
    }

    public void setContactLastName(String newLastName) {
        if (!isValidParameter(newLastName, MAX_LENGTH_LAST_NAME)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        contactLastName = newLastName;
    }

    public void setContactPhoneNum(String newPhoneNum) {
        if (!isValidPhoneNumber(newPhoneNum)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        contactPhoneNum = newPhoneNum;
    }

    public void setContactAddress(String newAddress) {
        if (!isValidParameter(newAddress, MAX_LENGTH_ADDRESS)) {
            throw new IllegalArgumentException("Invalid address");
        }
        contactAddress = newAddress;
    }
}
