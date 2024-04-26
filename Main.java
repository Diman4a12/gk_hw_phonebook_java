import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) {
        String[] name = { "Иван Иванов", "Николай Сидоров", "Петр Петров", "Алексей Кузнецов", "Сергей Сергеев",
                "Анна Болотникова", "Татьяна Кретова", "Светлана Светикова", "Вероника Козлова" };

        Random phone = new Random();
        Random nameRnd = new Random();

        PhoneBook myPhoneBook = new PhoneBook();

        for (int i = 0; i < 20; i++) {
            myPhoneBook.add(name[nameRnd.nextInt(9)], phone.nextInt(999_999 - 100_000 + 1) + 100_000);
        } 
        
       
        Scanner sc = new Scanner(System.in, "Cp866");
        boolean flag = true;
        while(flag){
            System.out.println("Укажите что хотите сделать (Добавить, Удалить, Вывести, Найти, Выход)");
            String answer = sc.nextLine();            
            if (answer.equals("Добавить")){
                System.out.println("Введите имя:");
                String nameIn = sc.nextLine();
                System.out.println("Введите номер (6 цифр):");
                Integer phoneIn = sc.nextInt();
                myPhoneBook.add(nameIn, phoneIn);
                sc.nextLine();
            }else if(answer.equals("Удалить")){
                System.out.println("Введите имя:");
                String nameDel = sc.nextLine();                
                myPhoneBook.delName(nameDel);
            }else if(answer.equals("Вывести")){
                myPhoneBook.printPhone();        
            }else if(answer.equals("Найти")){
                System.out.println("Введите имя:");
                String nameFind = sc.nextLine();                
                myPhoneBook.find(nameFind);
            }else if(answer.equals("Выход")){
                flag = false;
                sc.close();
                } else {
                    System.out.println("Нет такой команды. Прогармма закрывается)");
                    System.exit(0);
                }

    }           
}

    public static class  PhoneBook {

        public  HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

        public void add(String name, Integer phoneNum) {

            if (!phoneBook.containsKey(name)) {
                phoneBook.put(name, new ArrayList<>(phoneNum));
            }
            phoneBook.get(name).add(phoneNum);

        }     

		public void find(String name) {

            if (!phoneBook.containsKey(name)) {
                System.out.println("Нет такой записи");
            } else {
                System.out.println(phoneBook.get(name)); 
            }

        }      

        public void delName(String name) {
            if (phoneBook.containsKey(name)){
                phoneBook.remove(name);
            }else {
                System.out.println("Нет такой записи");
            }
        }

       

        public  void printPhone (){
            ArrayList<String> phoneList = new ArrayList<>();
            for (Map.Entry<String, ArrayList<Integer>> entry: phoneBook.entrySet()){
                String key = entry.getKey();
                ArrayList <Integer> value = entry.getValue();
                phoneList.add(key + " = " + value);
                        }
            Comparator<String> stringLen = new StringLenSort(); 
            Collections.sort(phoneList, stringLen);
            for (String item: phoneList){
                System.out.println(item);
            }
            
            
        }
    }

    

}


