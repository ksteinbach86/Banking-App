package com.techelevator.tenmo.controller;

import javax.validation.Valid;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;


@RestController
public class tenmoController {

    @ResponseStatus
    @RequestMapping(path = "/send", method = RequestMethod.POST)
    public void sendTransfer(@RequestParam double Amount, @RequestParam int destination_id, Principal principal) {

    }

    @RequestMapping(path = "/balance", method = RequestMethod.GET)
    public Account getBalance(Principal principal) {
        System.out.println(principal.getName());
        return Account.class(principal.getName());
    }

    @RequestMapping(path="/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return accoutDao.findAll();
    }
                                                        // TODO add throws exception to
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/transfers/{id}", method = RequestMethod.POST)
    public void addTransfer(@RequestBody Transfer transfer, @PathVariable int id) throws  {

        BigDecimal transferAmount = transfer.getAmount();
        Account accountFrom = getAccountByAccountID(transfer.getAccountFrom());
        Account accountTo = accountDAO.getAccountByAccountID(transfer.getAccountTo());

        //TODO probably need to create sendMoney and receiveMoney
//        accountFrom.getBalance().sendMoney(transferAmount)
//        accountTo.getBalance().receiveMoney(transferAmount);


    }

    @RequestMapping(path="/account/user/{id}", method = RequestMethod.GET)
    public Account getAccountByUserId(@PathVariable int id) {
        return accountDAO.getAccountByUserID(id);
    }

    @RequestMapping(path="/account/{id}", method = RequestMethod.GET)
    public Account getAccountFromAccountId(@PathVariable int id) {
        return account.getAccountByAccountID(id);
    }

    @RequestMapping(path="/transfers/user/{userId}", method = RequestMethod.GET)
    public List<Transfer> getTransfersByUserId(@PathVariable int userId) {
        return transferDAO.getTransfersByUserId(userId);
    }

    @RequestMapping(path="/transfers/{id}", method = RequestMethod.GET)
    public Transfer getTransferById(@PathVariable int id) {
        return transferDAO.getTransferByTransferId(id);
    }

    @RequestMapping(path="/users/{id}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable int id) {
        return userDao.getUserByUserId(id);
    }

    @RequestMapping(path="/transfers", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers() {
        return transferDAO.getAllTransfers();
    }






}


























































