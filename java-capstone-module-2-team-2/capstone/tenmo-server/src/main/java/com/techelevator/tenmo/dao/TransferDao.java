package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;


import java.util.List;

//
// THINK OF this TransferDao as a dvd faceplate with buttons.
// Push each one of these methods to activate in the JDBCTransferDao
//

public interface TransferDao {

    void createTransfer(Transfer transfer);

    List<Transfer> getTransfer(int transferId);

    List<Transfer> getTransfersByUserId(int userId);

    Transfer getTransferByTransferId(int transferId);

    void updateTransfer(Transfer transfer);

}