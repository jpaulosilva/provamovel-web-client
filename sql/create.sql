-- Create Table: tb_test
--------------------------------------------------------------------------------
CREATE TABLE tb_test
(
	`id` INT NOT NULL 
	,PRIMARY KEY (id)
	,`title` VARCHAR(250) NOT NULL 
	,`authorEmail` VARCHAR(250) NOT NULL 
)
ENGINE=INNODB



-- Create Table: tb_question
--------------------------------------------------------------------------------
CREATE TABLE tb_question
(
	`id` INT NOT NULL 
	,PRIMARY KEY (id)
	,`test` INT NOT NULL 
	,`title` VARCHAR(250) NOT NULL 
	,`type` INT NOT NULL 
)
ENGINE=INNODB



-- Create Table: tb_question_option
--------------------------------------------------------------------------------
CREATE TABLE tb_question_option
(
	`id` INT NOT NULL 
	,PRIMARY KEY (id)
	,`title` VARCHAR(250) NOT NULL 
	,`question` INT NOT NULL 
)
ENGINE=INNODB



-- Create Table: tb_user
--------------------------------------------------------------------------------
CREATE TABLE tb_user
(
	`email` VARCHAR(250) NOT NULL 
	,PRIMARY KEY (email)
	,`password` VARCHAR(250) NOT NULL 
	,`hash` VARCHAR(250)  NULL 
)
ENGINE=INNODB



-- Create Table: tb_user_test_answer
--------------------------------------------------------------------------------
CREATE TABLE tb_user_test_answer
(
	`id` INT NOT NULL 
	,PRIMARY KEY (id)
	,`userEmail` VARCHAR(250) NOT NULL 
	,`test` INT NOT NULL 
)
ENGINE=INNODB



-- Create Table: tb_user_answer_item
--------------------------------------------------------------------------------
CREATE TABLE tb_user_answer_item
(
	`id` INT NOT NULL 
	,PRIMARY KEY (id)
	,`answer` TEXT NOT NULL 
)
ENGINE=INNODB



-- Create Foreign Key: tb_question.test -> tb_test.id
ALTER TABLE tb_question ADD FOREIGN KEY (test) REFERENCES tb_test(id);


-- Create Foreign Key: tb_question_option.question -> tb_question.id
ALTER TABLE tb_question_option ADD FOREIGN KEY (question) REFERENCES tb_question(id);


-- Create Foreign Key: tb_user_test_answer.userEmail -> tb_user.email
ALTER TABLE tb_user_test_answer ADD FOREIGN KEY (userEmail) REFERENCES tb_user(email);


-- Create Foreign Key: tb_user_test_answer.test -> tb_test.id
ALTER TABLE tb_user_test_answer ADD FOREIGN KEY (test) REFERENCES tb_test(id);


-- Create Foreign Key: tb_user_answer_item.id -> tb_user_test_answer.id
ALTER TABLE tb_user_answer_item ADD FOREIGN KEY (id) REFERENCES tb_user_test_answer(id);


-- Create Foreign Key: tb_test.authorEmail -> tb_user.email
ALTER TABLE tb_test ADD FOREIGN KEY (authorEmail) REFERENCES tb_user(email);


