import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[] name = { "Иван Иванов", "Николай Сидоров", "Петр Петров", "Алексей Кузнецов", "Сергей Сергеев",
                "Анна Болотникова", "Татьяна Кретова", "Светлана Светикова", "Вероника Козлова" }; // 9

        Random phone = new Random();
        Random nameRnd = new Random();

        PhoneBook myPhoneBook = new PhoneBook();

        for (int i = 0; i < 20; i++) {
            myPhoneBook.add(name[nameRnd.nextInt(9)], phone.nextInt(999_999 - 100_000 + 1) + 100_000);
        }

        System.out.println(myPhoneBook.find("Иван Иванов"));
        System.out.println(PhoneBook.getPhoneBook());

    }

    public static class PhoneBook {

        static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

        public void add(String name, Integer phoneNum) {

            if (!phoneBook.containsKey(name)) {
                phoneBook.put(name, new ArrayList<>(phoneNum));
            }
            phoneBook.get(name).add(phoneNum);

        }

        public ArrayList<Integer> find(String name) {

            if (!phoneBook.containsKey(name)) {
                return new ArrayList<>();
            } else {
                return phoneBook.get(name);
            }

        }

        public static HashMap<String, ArrayList<Integer>> getPhoneBook() {

            return phoneBook;
        }
    }

}
