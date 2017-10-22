SET NAMES utf8;
SET foreign_key_checks = 0;

INSERT INTO `page` (`id`, `url`, `title`) VALUES
  (1, 'o-firme', 'O firmě'),
  (2, 'projekce', 'Projece'),
  (3, 'kontrola', 'Kontrola'),
  (4, 'normy', 'Normy'),
  (5, 'objednavky', 'Objednavky');


INSERT INTO `page_text` (`id`, `content`, `page_id`, `identity`) VALUES
  (1, 'Dobrý den šíáýžřčřžýáíáýžř', 1, 'test-content'),
  (2, 'Editace textu', 1, 'popis-auta'),
  (3, 'Pavel popis', 1, 'popis-pavel'),
  (4, 'Dobrý den, vítejte!', 3, 'wellcome-text'),
  (5, '<span style=\"color: red\">Samuel Butta</span>\r\n<br>\r\nPavel novotný', 3, 'author-name');


INSERT INTO `product_category` (`id`, `name`, `parent_category_id`) VALUES
  (5, 'parent', NULL),
  (6, 'kategorie 1', 5),
  (7, 'parent', NULL),
  (8, 'kategorie 1', 7),
  (9, 'parent', NULL),
  (10, 'kategorie 1', 9),
  (11, 'parent', NULL),
  (12, 'kategorie 1', 11);

INSERT INTO `role` (`id`, `role`) VALUES
  (1, 'USER'),
  (2, 'ADMIN'),
  (3, 'DEVELOPER');

INSERT INTO `user` (`id`, `active`, `email`, `first_name`, `last_name`, `password`) VALUES
  (1, 1, 'developer@admin.cz', 'Joe', 'Doe', '$2a$10$cIZhwKsIsM9kv6guM.iQnOCNKIfIaGSEkrJ7OSU2.02hmtAHAbCou'),
  (2, 1, 'admin@admin.cz', 'Joe', 'Doe', '$2a$10$cIZhwKsIsM9kv6guM.iQnOCNKIfIaGSEkrJ7OSU2.02hmtAHAbCou');

INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 1),
  (2, 2);