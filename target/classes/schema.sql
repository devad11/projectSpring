CREATE TABLE account (
accountId int(11) NOT NULL AUTO_INCREMENT,
balance int(15) NOT NULL,
PRIMARY KEY (accountId)
);

CREATE TABLE customer (
customerId int(11) NOT NULL AUTO_INCREMENT,
name VARCHAR(120) NOT NULL,
PRIMARY KEY (customerId)
);

CREATE TABLE account_owners(
accountId int(11) NOT NULL,
customerId int(11) NOT NULL,
PRIMARY KEY (accountId, customerId),
FOREIGN KEY (accountId) REFERENCES account(accountId),
FOREIGN KEY (customerId) REFERENCES customer(customerId)
);