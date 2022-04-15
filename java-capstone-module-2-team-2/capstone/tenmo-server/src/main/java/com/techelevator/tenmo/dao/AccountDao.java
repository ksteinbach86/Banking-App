package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.apache.catalina.User;



//
// THINK OF this TransferDao as a dvd faceplate with buttons.
// Push each one of these methods to activate in the JDBCTransferDao
//

public interface AccountDao {

    Account getAccountByUserId(int userId);

    Account getAccountByAccountId(int accountId);

}
