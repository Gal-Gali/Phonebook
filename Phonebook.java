import java.util.TreeMap;
// represents phonebook
public class Phonebook {
    private TreeMap<String,String> phonebook;

    public Phonebook()
    {
        phonebook = new TreeMap<String,String>();
    }
    // add contact to the phonebook
    public void add(String name, String phoneNumber)
    {
        phonebook.put(name,phoneNumber);
    }
    //remove the contact of the given name from the phonebook
    public void remove(String name)
    {
        phonebook.remove(name);
    }
    //return the contact of the given name
    public TreeMap<String,String> search(String name)
    {
        TreeMap<String,String> temp = new TreeMap<String,String>();
        if (phonebook.containsKey(name))
        {
            temp.put(name,phonebook.get(name));
        }
        return temp;
    }
    // return the phonebook
    public TreeMap<String, String> getPhonebook() {
        return phonebook;
    }
}
