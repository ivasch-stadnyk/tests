CREATE TABLE CATEGORY (
    ID int(9) NOT NULL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL
);
CREATE TABLE PRODUCTSTATUS (
    ID int(9) NOT NULL PRIMARY KEY,
    DESCRIPTION VARCHAR(50) NOT NULL
);
CREATE TABLE PRODUCT (
    ID int(9) NOT NULL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    CATEGORY int(9) NOT NULL,
    FOREIGN KEY (CATEGORY) REFERENCES CATEGORY(ID),
    STATUS int(9) NOT NULL,
    FOREIGN KEY (STATUS) REFERENCES PRODUCTSTATUS(ID)
);
