CREATE TABLE Customer (
    customerId INT PRIMARY KEY,
    customerName CHAR(50) NOT NULL,
    customerMobile CHAR(20) NOT NULL,
    customerEmail CHAR(50) NOT NULL,
    address1 CHAR(100) NOT NULL,
    address2 CHAR(100)
);

CREATE TABLE Account (
    accountId INT PRIMARY KEY,
    accountType CHAR(50) NOT NULL,
    availableBalance DECIMAL(10, 2),
    accountNumber INT
);