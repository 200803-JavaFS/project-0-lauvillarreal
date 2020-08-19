DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS account CASCADE;

CREATE TABLE account (
	users_username VARCHAR(100) PRIMARY KEY,
	users_name VARCHAR(100),
	checkings_bal NUMERIC(10,2),
	savings_bal NUMERIC(10,2),
	status VARCHAR(100)
);

CREATE TABLE Users (
	users_id SERIAL PRIMARY KEY,
	users_password VARCHAR(100),
	isloggedin BOOLEAN,
	users_type VARCHAR(100),
	users_username_fk VARCHAR(100) REFERENCES account(users_username)

);

CREATE OR REPLACE FUNCTION get_current_time() RETURNS TIME WITH TIME ZONE
AS $$
-- curent_time is a built value that is just the current time.  
SELECT current_time;
$$ LANGUAGE SQL; 

SELECT get_current_time(); 

ALTER TABLE public.account ADD CONSTRAINT account_check CHECK (checkings_bal >=0);
ALTER TABLE public.account ADD CONSTRAINT account_check_savings CHECK (savings_bal >=0);
ALTER TABLE users ADD COLUMN users_name VARCHAR(100);


INSERT INTO Users (users_password, isloggedin, users_type, users_username_fk, users_name)
VALUES ('mo124', false, 'customer', 'michelle123', 'Michelle');
					
INSERT INTO account (users_username, users_name, checkings_bal, savings_bal, status)
VALUES ('michelle123', 'Michelle', 10000, 0, 'approved');

UPDATE account SET users_name = 'Barbara Bernadino' WHERE users_username = 'barbermtz';
UPDATE account SET users_name = 'Michelle O' WHERE users_username = 'michelle123';

DELETE FROM account WHERE users_username = 'willa';
DELETE FROM users WHERE  users_username_fk = 'willa';

UPDATE users SET isloggedin = false WHERE isloggedin = true;

