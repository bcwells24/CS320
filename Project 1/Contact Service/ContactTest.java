package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ContactService.Contact;

class ContactTest {

    private Contact newContact;

    @BeforeEach
    void setUp() {
        newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
    }

    @Test
    void testContactClass() {
        assertEquals("123456789", newContact.getContactID());
        assertEquals("TestFirst", newContact.getContactFirstName());
        assertEquals("TestLast", newContact.getContactLastName());
        assertEquals("5201234567", newContact.getContactPhoneNum());
        assertEquals("Test the Address, Tucson", newContact.getContactAddress());
    }

    @Test
    void testGetContactID() {
        assertEquals("123456789", newContact.getContactID());
    }

    @Test
    void testGetContactFirstName() {
        assertEquals("TestFirst", newContact.getContactFirstName());
    }

    @Test
    void testGetContactLastName() {
        assertEquals("TestLast", newContact.getContactLastName());
    }

    @Test
    void testGetContactPhoneNum() {
        assertEquals("5201234567", newContact.getContactPhoneNum());
    }

    @Test
    void testGetContactAddress() {
        assertEquals("Test the Address, Tucson", newContact.getContactAddress());
    }

    @Test
    void testSetContactFirstName() {
        newContact.setContactFirstName("NewFirst"); // Must be 10 characters or less
        assertEquals("NewFirst", newContact.getContactFirstName());
    }

    @Test
    void testSetContactLastName() {
        newContact.setContactLastName("NewLast"); // Must be 10 characters or less
        assertEquals("NewLast", newContact.getContactLastName());
    }

    @Test
    void testSetContactPhoneNum() {
        newContact.setContactPhoneNum("1234567520");
        assertEquals("1234567520", newContact.getContactPhoneNum());
    }

    @Test
    void testSetContactAddress() {
        newContact.setContactAddress("123 New Address, Texas");
        assertEquals("123 New Address, Texas", newContact.getContactAddress());
    }

    @Test
    void testContactIdTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789123", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
        });
    }

    @Test
    void testContactIdNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
        });
    }

    @Test
    void testFirstNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", "TestFirstNameThatIsTooLong", "TestLast", "5201234567", "Test the Address, Tucson");
    });
}

    @Test
    void testFirstNameNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", null, "TestLast", "5201234567", "Test the Address, Tucson");
    });
}

    @Test
    void testLastNameTooLong() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", "TestFirst", "TestLastNameThatIsTooLong", "5201234567", "Test the Address, Tucson");
    });
}

    @Test
    void testLastNameNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", "TestFirst", null, "5201234567", "Test the Address, Tucson");
    });
}

    @Test
    void testPhoneNumTooLong() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", "TestFirst", "TestLast", "520123456712345", "Test the Address, Tucson");
    });
}

    @Test
    void testPhoneNumNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", "TestFirst", "TestLast", null, "Test the Address, Tucson");
    });
}

    @Test
    void testPhoneNumTooShort() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", "TestFirst", "TestLast", "5201234", "Test the Address, Tucson");
    });
}

    @Test
    void testPhoneHasNonDigit() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", "TestFirst", "TestLast", "52012a4567", "Test the Address, Tucson");
    });
}

    @Test
    void testAddressTooLong() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address that is super long and exceeds the limit, Tucson");
    });
}

    @Test
    void testAddressNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789", "TestFirst", "TestLast", "5201234567", null);
    });
}

    @Test
    void testSetFirstNameTooLong() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactFirstName("FirstNameThatIsWayTooLong");
    });
}

    @Test
    void testSetFirstNameNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactFirstName(null);
    });
}

    @Test
    void testSetLastNameTooLong() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactLastName("LastNameThatIsWayTooLong");
    });
}

    @Test
    void testSetLastNameNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactLastName(null);
    });
}

    @Test
    void testSetPhoneNumTooLong() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactPhoneNum("520123456789012");
    });
}

    @Test
    void testSetPhoneNumTooShort() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactPhoneNum("52012345");
    });
}

    @Test
    void testSetPhoneNumNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactPhoneNum(null);
    });
}

    @Test
    void testSetPhoneNumWithNonDigit() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactPhoneNum("520123f567");
    });
}

    @Test
    void testSetAddressTooLong() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactAddress("An address that is way too long and exceeds the allowable limit");
    });
}

    @Test
    void testSetAddressNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
        newContact.setContactAddress(null);
    });
}
    @Test
    void testSetContactFirstNameBoundary() {
        newContact.setContactFirstName("NewFirst1");
        assertEquals("NewFirst1", newContact.getContactFirstName());
    }

    @Test
    void testSetContactLastNameBoundary() {
        newContact.setContactLastName("NewLast1");
        assertEquals("NewLast1", newContact.getContactLastName());
    }

    @Test
    void testSetContactPhoneNumBoundary() {
        newContact.setContactPhoneNum("1234567890");
        assertEquals("1234567890", newContact.getContactPhoneNum());
    }

    @Test
    void testSetContactAddressBoundary() {
        String address = "12345 Test Address, Tucson, AZ";
        newContact.setContactAddress(address);
        assertEquals(address, newContact.getContactAddress());
    }

    @Test
    void testSetContactFirstNameEmpty() {
        newContact.setContactFirstName("");  // Set an empty string as the first name
        assertEquals("", newContact.getContactFirstName());  // Check if the first name is empty
    }

    @Test
    void testSetContactLastNameEmpty() {
        newContact.setContactLastName("");  // Set an empty string as the last name
        assertEquals("", newContact.getContactLastName());  // Check if the last name is empty
    }

    @Test
    void testSetContactPhoneNumEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            newContact.setContactPhoneNum("");
        });
    }

    @Test
    void testSetContactAddressEmpty() {
        newContact.setContactAddress("");  // Set an empty string as the address
        assertEquals("", newContact.getContactAddress());  // Check if the address is empty
    }
    
}
