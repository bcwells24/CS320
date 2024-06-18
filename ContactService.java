package ContactService;

import java.util.ArrayList;

public class ContactService {

	public ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	//add contact
	public void addContact (String contactID, String contactFirstName, String contactLastName, String contactPhoneNum, String contactAddress) {
		Contact contactToAdd = new Contact(contactID, contactFirstName, contactLastName, contactPhoneNum, contactAddress);
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getContactID() == contactID){
				throw new IllegalArgumentException("Contact ID already exists!");
			}
		}
		contactList.add(contactToAdd);
	}

	
	//delete contact
	public void deleteContact (String contactIdToDelete) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getContactID() == contactIdToDelete){
				contactList.remove(i);
			}
		}
	}
	
	//update contact functions
	public void updateContactFirstName (String contactIdToUpdate, String updatedContactName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getContactID() == contactIdToUpdate){
				contactList.get(i).setContactFirstName(updatedContactName);
			}
		}
	}
	public void updateContactLastName (String contactIdToUpdate, String updatedContactName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getContactID() == contactIdToUpdate){
				contactList.get(i).setContactLastName(updatedContactName);
			}
		}
	}
	public void updateContactPhoneNum (String contactIdToUpdate, String updatedPhoneNum) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getContactID() == contactIdToUpdate){
				contactList.get(i).setContactPhoneNum(updatedPhoneNum);
			}
		}
	}
	public void updateContactAddress (String contactIdToUpdate, String updatedAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getContactID() == contactIdToUpdate){
				contactList.get(i).setContactAddress(updatedAddress);
			}
		}
	}
}