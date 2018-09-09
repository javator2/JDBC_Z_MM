package pl.sdacademy.jdbc;

import pl.sdacademy.jdbc.model.Student;
import pl.sdacademy.jdbc.resolver.StudentResolver;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static void Menu() {
        System.out.println("Menu:\n" +
                "1. Pokaż rekordy \n" +
                "2. Dodaj rekordy \n" +
                "3. Usuń rekordy \n" +
                "4. Nadpisz rekord [id=]\n" +
                "5. Koniec");
    }

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Menu();
        int menuNumber = 0;
        while (menuNumber != 5) {
            menuNumber = scanner.nextInt();

            StudentResolver studentResolver = new StudentResolver();
            switch (menuNumber) {
                case 1:
                    List<Student> students = studentResolver.get();
                    for (Student s : students
                            ) {
                        System.out.println(s.getId() + " " + s.getFirstname() + " " + s.getLastname());
                    }
                    Menu();
                    break;
                case 2:
                    Map<String, String> params = new HashMap<>();
                    System.out.println("Podaj imię: ");
                    String firstname = scanner.next();
                    System.out.println("Podaj nazwisko: ");
                    String lastname = scanner.next();

                    params.put("firstname", firstname);
                    params.put("lastname", lastname);

                    studentResolver.insert(params);

                    Menu();
                    break;
                case 3:
                    System.out.println("Podaj Id użytkownika: ");
                    int delId = scanner.nextInt();

                    studentResolver.delete(delId);
                    Menu();
                    break;
                case 4:
                    System.out.println("Podaj id do nadpisania: ");
                    int upId = scanner.nextInt();
                    Map<String, String> updateParams = new HashMap<>();

                    System.out.println("Podaj nowe imię: ");
                    String newName = scanner.next();

                    System.out.println("Podaj nowe nazwisko: ");
                    String newLastname = scanner.next();

                    updateParams.put("name", newName);
                    updateParams.put("lastname", newLastname);

                    studentResolver.update(upId, updateParams);
                    Menu();
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("bad choice");
            }
        }

    }
}
