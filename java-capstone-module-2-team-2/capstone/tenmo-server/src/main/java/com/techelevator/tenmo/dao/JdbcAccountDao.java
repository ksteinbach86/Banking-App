package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/*

THE JDBC_name_Dao makes it possible to do these things within an application:
establish a connection with a data source,
send queries and update statements, as well as processing results.

 */

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public Account getAccountByUserId(int userId) {
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        Account account = null;
        if(result.next()) {
            account = mapResultsToAccount(result);
        }
        return account;
    }

    @Override
    public Account getAccountByAccountId(int accountId) {
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE account_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, accountId);
        Account account = null;
        if(result.next()) {
            account = mapResultsToAccount(result);
        }
        return account;
    }


    private Account mapResultsToAccount(SqlRowSet result) {
        int accountId = result.getInt("account_id");
        int userAccountId = result.getInt("user_id");

        Account account = new Account();
        String accountName = result.getString("name");
        account.setAccountId(new int(accountId));

        return new Account(new accountId, userAccountId);
    }
}