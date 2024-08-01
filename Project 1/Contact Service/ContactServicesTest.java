package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ContactService.ContactService;

class ContactServiceTest {
    private ContactService newContactService;

    @BeforeEach
    void setUp() {
        newContactService = new ContactService();
    }

    @Test
    void testAddContact() {
        newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
        assertTrue(newContactService.contactList.stream()
                .anyMatch(contact -> contact.getContactID().equals("123456789") &&
                        contact.getContactFirstName().equals("TestFirst") &&
                        contact.getContactLastName().equals("TestLast") &&
                        contact.getContactPhoneNum().equals("5201234567") &&
                        contact.getContactAddress().equals("Test the Address, Tucson")));
    }

    @Test
    void testAddDuplicateContactIdThrowsException() {
        newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            newContactService.addContact("123456789", "DupFirst", "DupLast", "5201111111", "Duplicate, Tucson");
        });
    }

    @Test
    void testTwoContacts() {
        newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
        newContactService.addContact("987654321", "2ndFirst", "2ndLast", "5200000007", "Testing in Tucson");

        assertTrue(newContactService.contactList.stream()
                .anyMatch(contact -> contact.getContactID().equals("123456789") &&
                        contact.getContactFirstName().equals("TestFirst") &&
                        contact.getContactLastName().equals("TestLast") &&
                        contact.getContactPhoneNum().equals("5201234567") &&
                        contact.getContactAddress().equals("Test the Address, Tucson")));

        assertTrue(newContactService.contactList.stream()
                .anyMatch(contact -> contact.getContactID().equals("987654321") &&
                        contact.getContactFirstName().equals("2ndFirst") &&
                        contact.getContactLastName().equals("2ndLast") &&
                        contact.getContactPhoneNum().equals("5200000007") &&
                        contact.getContactAddress().equals("Testing in Tucson")));
    }

    @Test
    void testDeleteContact() {
        newContactService.addContact("987654321", "TestFirst", "TestLast", "5200000007", "Testing in Tucson");
        newContactService.deleteContact("987654321");
        assertFalse(newContactService.contactList.stream()
                .anyMatch(contact -> contact.getContactID().equals("987654321")));
    }

    @Test
    void testDeleteNonExistentContact() {
        newContactService.addContact("987654321", "TestFirst", "TestLast", "5200000007", "Testing in Tucson");
        try {
            newContactService.deleteContact("987654321");
        } catch (Exception e) {
            fail("Threw exception with delete command");
        }
        assertFalse(newContactService.contactList.stream()
                .anyMatch(contact -> contact.getContactID().equals("987654321")));
    }

    @Test
    void testUpdateContactFirstName() {
        newContactService.addContact("123456789", "TestFirst", "TestLast", "5200000007", "Testing in Tucson");
        newContactService.updateContactFirstName("123456789", "newFirst");
        assertEquals("newFirst", newContactService.contactList.stream()
                .filter(contact -> contact.getContactID().equals("123456789"))
                .findFirst()
                .orElseThrow()
                .getContactFirstName());
    }

    @Test
    void testUpdateContactLastName() {
        newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
        newContactService.updateContactLastName("123456789", "newLast");
        assertEquals("newLast", newContactService.contactList.stream()
                .filter(contact -> contact.getContactID().equals("123456789"))
                .findFirst()
                .orElseThrow()
                .getContactLastName());
    }

    @Test
    void testUpdateContactPhoneNum() {
        newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
        newContactService.updateContactPhoneNum("123456789", "0000000000");
        assertEquals("0000000000", newContactService.contactList.stream()
                .filter(contact -> contact.getContactID().equals("123456789"))
                .findFirst()
                .orElseThrow()
                .getContactPhoneNum());
    }

    @Test
    void testUpdateContactAddress() {
        newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
        newContactService.updateContactAddress("123456789", "65432 Greener Pastures");
        assertEquals("65432 Greener Pastures", newContactService.contactList.stream()
                .filter(contact -> contact.getContactID().equals("123456789"))
                .findFirst()
                .orElseThrow()
                .getContactAddress());
    }
}
