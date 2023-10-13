--
 INSERT INTO products
	(product_id,description,created_at,updated_at,price,brand)
VALUES
  ('0000','product_all',NOW(),NOW(),0.0,''),
  ('33a480ab-7ec4-4ff0-8b83-4347423425f4','product 1',NOW(),NOW(),2.34,'brand 1'),
  ('33a480ab-7ec4-4ff0-8b83-4347423425f1','product 2',NOW(),NOW(),1.34,'brand 1'),
  ('32a480ab-7ec4-4ff0-8b83-4347423425f1','product 3',NOW(),NOW(),0.34,'brand 1');

  INSERT INTO roles (role_id, role) VALUES
    ('0','root'),
    ('1','admin'),
    ('2','user'),
    ('3','no_user');


   insert into users
   	(user_id,name,last_name,second_last_name,is_verified,password,email,role_id)
   values
   	('ANONYMOUS','ANONYMOUS','ANONYMOUS','ANONYMOUS',true,'xxx','xxxx','3'),
   	('33a480ab-7ec4-4ff0-8b83-434742qas21d','root','root','root',true,'root','root@root.com','0'),
   	('33a480ab-7ec4-4ff0-8b83-434742342512','test','test','test',true,'pass','test@test.com','1'),
   	('32a348ab-7ec4-4ff0-8b83-434742342512','test1','test1','test1',true,'pass','test1@test.com','2');