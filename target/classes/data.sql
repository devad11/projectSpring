INSERT INTO account (balance, overdraft) VALUES
(1000, 100),
(3000, 1000),
(12345, 3000),
(22345, 3000);

INSERT INTO customer (name) VALUES
('Adam'),
('Ruth'),
('Graeme');

INSERT INTO account_owners (accountId, customerid) VALUES
(1,1),
(2,2),
(1,2),
(3,3);

