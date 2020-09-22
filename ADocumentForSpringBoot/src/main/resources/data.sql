INSERT INTO USER(id, fullname, username, password, birthday)
VALUES 
	(11, 'bao kha', 'kha.tran', '123456', '2000-09-15'),
	(12, 'minh chau', 'chau.truong', '123456789', '2000-03-31'),
	(13, 'hao le', 'hao.le', '123456', '2000-01-16'),
	(14, 'gia bao', 'bao.trinh', 'giabao', '2000-01-01'),
	(15, 'tran kha', 'kha.tran1509', '12345644', '1999-09-15'),
	(16, 'tran tien', 'tien.tran', 'trantien', '1998-08-12');

INSERT INTO post(id, content, postday, user_id)
VALUES 
	(11, 'This is my first post','2000-09-15', 11),
	(13, 'bat man','2000-01-16', 12),
    (14, 'spring boot is awesom', '2000-01-01', 12),
	(15, 'lodaaaaa', '1999-09-15', 12),
	(16, 'tran tien', '1998-08-12' , 13),
	(17, 'This is my first post','2000-09-15', 13),
	(18, 'minh chau', '2000-03-31', 14),
	(19, 'bat man','2000-01-16', 15),
	(20, 'spring boot is awesome', '2000-01-01', 16),
	(21, 'lodaaaaa', '1999-09-15', 15),
	(22, 'tran tien', '1998-08-12' , 14);
	
INSERT INTO authority
VALUES 
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');

INSERT INTO user_authority(user_id, authority_id)
VALUES 
	(11, 1),
	(11, 2),
	(12,2),
	(13,2),
	(14,2),
	(15,2),
	(16,2);