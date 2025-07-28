# JavaFX Phonebook Application

## Overview
This is a simple phonebook application built using JavaFX. It allows users to add, update, delete, and search for contacts by name. The contact list is displayed in a table format using JavaFX UI components, and the data is managed using a `TreeMap`.

## How to Run

1. Make sure you have **Java 8** or later installed with JavaFX support.  
2. Compile all `.java` files:  
   ```bash
   javac Main.java Phonebook.java PhonebookController.java

## Usage

- **Add/Update Contact**:  
  Enter a name and phone number, then click "Add / Update". If the name exists, the number will be updated.

- **Delete Contact**:  
  Enter the name and click "Delete" to remove the contact from the phonebook.

- **Search Contact**:  
  Type a name in the search bar and click "Search" to view only matching contacts. Clear the search field to show all contacts.

- **Phone Number Validation**:  
  Only digits and hyphens (`-`) are allowed in the phone number input field.
