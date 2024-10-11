package com.ism.view;

import java.util.List;
import java.util.Scanner;

import com.ism.entities.Client;
import com.ism.entities.User;
import com.ism.enums.Role;
import com.ism.repository.database.ClientRepositoryBD;
import com.ism.repository.database.UserRepositoryBD;
import com.ism.services.impl.ClientServiceImpl;
import com.ism.services.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        int choix;
        Scanner scanner = new Scanner(System.in);
        ClientRepositoryBD clientRepository = new ClientRepositoryBD();
        ClientServiceImpl clientServiceImpl = new ClientServiceImpl(clientRepository);
        UserRepositoryBD userRepository = new UserRepositoryBD();
        UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);

        do {
            System.out.println("Choisissez une option:");
            System.out.println("1-Creer Client");
            System.out.println("2-Lister client");
            System.out.println("3-Rechercher client Par Telephone");
            System.out.println("4-Creer Utilisateur");
            System.out.println("5-Lister Utilisateurs");
            System.out.println("6-Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    Client client = new Client();
                    System.out.println("Entrer le surnom");
                    client.setSurname(scanner.nextLine());
                    System.out.println("Entrer le Telephone");
                    client.setTelephone(scanner.nextLine());
                    System.out.println("Entrer l'email");
                    clientServiceImpl.create(client);
                    break;
                case 2:
                    List<Client> clients = clientServiceImpl.show();
                    clients.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Entrez le numéro de téléphone à rechercher:");
                    String tel = scanner.nextLine();
                    client = clientServiceImpl.searchClient(tel);
                    if (client != null) {
                        System.out.println(client);
                    } else {
                        System.out.println("Client non trouvé.");
                    }
                    break;
                case 4:
                    User user = new User();
                    System.out.println("Entrer le login: ");
                    user.setLogin(scanner.nextLine());
                    System.out.println("Entrer le password: ");
                    user.setPassword(scanner.nextLine());
                    user.setRole(saisieRole(scanner));
                    break;
                case 5:
                    List<User> users = userServiceImpl.show();
                    users.forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }

        } while (choix != 6);

        scanner.close();
    }

    public static Role saisieRole(Scanner scanner) {
        int role;
        do {
            System.out.println("Choisir un role: ");
            System.out.println("1-Boutiquier ");
            System.out.println("2-Admin ");
            role = scanner.nextInt();
        } while (role < 1 || role > 2);
        return Role.values()[role - 1];
    }
}
