SELECT *
FROM tenmo_user;


INSERT INTO tenmo_user(username, password_hash)
VALUES ('Colt Wilson', 'variable');

SELECT *
FROM account;

-- Use case 3: Current balance
SELECT user_id, balance
FROM account;

-- Usecase 4: Send TE Bucks
SELECT user_id, username, amount
FROM tenmo_user;
--JOIN to transfer table with account_to


--Use case 5: View Transfers
SELECT transfer_type_id, account_to, account_from, amount
FROM transfer;


