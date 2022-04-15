package com.techelevator.tenmo;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.UserCredentials;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }

    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

//    private void viewCurrentBalance() {
//        // TODO Auto-generated method stub
//        private void viewCurrentBalance () {
//            BigDecimal balance = tenmoService.getBalance();
//            System.out.println("Your current account balance is: $" + balance);
//        }
//
//    }
//
//    private void viewTransferHistory() {
//        // TODO add ability to get info about a specific transaction from the list of transactions
//
//         Transaction[] transfers = tenmoService.listTransactions();
//         List<Integer> transferIDs = new ArrayList<>();
//            if(transfers.length == 0){
//                System.out.println("*********You have no transfers in your history********");
//            }
//            else{
//                User user = currentUser.getUser();
//                System.out.println("--------------------------------------------");
//                System.out.println("ID------FROM/TO---------------------AMOUNT");
//                for(int i = 0; i < transfers.length; i++){
//                    //add the transfer ID to a list of transfer IDS
//                    transferIDs.add(transfers[i].getTransferID());
//                    //if user was sender, show as TO
//
//                }
//
//
//        private void viewPendingRequests () {
//            // TODO Auto-generated method stub
//                    Transaction[] transfers = tenmoService.listPendingTransactions();
//                    List<Integer> transferIDs = new ArrayList<>();
//                    if(transfers.length == 0){
//                        System.out.println("*********You have no transfers in your history********");
//                    }
//                    else{
//                        User user = currentUser.getUser();
//                        System.out.println("--------------------------------------------");
//                        System.out.println("ID------FROM/TO---------------------AMOUNT");
//                        for(int i = 0; i < transfers.length; i++){
//                            //add the transfer ID to a list of transfer IDS
//                            transferIDs.add(transfers[i].getTransferID());
//                            //if user was sender, show as TO
//                            if(user.getUsername().equals(transfers[i].getSenderName())){
//                                System.out.println(transfers[i].getTransferID()+"-----TO:" +
//                                        transfers[i].getDestinationName() + "-------------------$" + transfers[i].getAmount());
//                            }
//
//                        }
//
//
//            private void sendBucks () {

    // Sending TE bucks to other users BUT not yourself here ///////////////////////////////////////////////////////
                // TODO Auto-generated method stub
//                            User[] allUsers = tenmoService.getAllUsers();
//                            int currentUserIndex = -1;
//                            for(int i = 0; i < allUsers.length; i++){
//                                if (allUsers[i].getUsername().equals(currentUser.getUser().getUsername())){
//                                    currentUserIndex = i;
//                                } else {
//                                    System.out.println((i+1) + ") " +  allUsers[i].getId() + "----" + allUsers[i].getUsername());
//                                }
//                            }
//                            int userSelection = consoleService.promptForMenuSelection("Please choose a user to send TE bucks to (0 to exit): ")-1;
//                            while ((userSelection < -1) || (userSelection >= allUsers.length ) ||(userSelection == currentUserIndex)){
//                                System.out.println("Hit the road Jack!");
//                                userSelection = consoleService.promptForMenuSelection("Please choose a user to send TE bucks to (0 to exit): ")-1;
//                            }
//                            if(userSelection != -1) {
//                                Transaction transaction = new Transaction();
//
//                            }
//
//
//                private void requestBucks () {
//                    // TODO Auto-generated method stub
//                    User[] allUsers = tenmoService.getAllUsers();
//                    int currentUserIndex = -1;
//                    for (int i = 0; i < allUsers.length; i++) {
//                        if (allUsers[i].getUsername().equals(currentUser.getUser().getUsername())) {
//                            currentUserIndex = i;
//                        } else {
//                            System.out.println((i + 1) + ") " + allUsers[i].getId() + "----" + allUsers[i].getUsername());
//                        }
//                    }
//                    int userSelection = consoleService.promptForMenuSelection("Please choose a user to request TE bucks from (0 to exit): ") - 1;
//                    while ((userSelection < -1) || (userSelection >= allUsers.length) || (userSelection == currentUserIndex)) {
//                        System.out.println("Hit the road Jack!");
//                        userSelection = consoleService.promptForMenuSelection("Please choose a user to request TE bucks from (0 to exit): ") - 1;
//                    }
//                    if (userSelection != -1) {
//                        Transaction transaction = new Transaction();
//                        BigDecimal amount = console
//
//                    }
//
//
//                }
                }
            }
        }
    }
}