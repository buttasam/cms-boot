SET NAMES utf8;
SET foreign_key_checks = 0;

INSERT INTO `page` (`id`, `url`, `title`) VALUES
  (1, 'homepage', 'Domovská stránka'),
  (2, 'o-firme', 'O firmě'),
  (3, 'projekce', 'Projece'),
  (4, 'kontrola', 'Kontrola'),
  (5, 'normy', 'Normy'),
  (6, 'objednavky', 'Objednavky');


INSERT INTO `page_text` (`id`, `content`, `page_id`, `identity`, `type`) VALUES
  (1, 'Dobrý den šíáýžřčřžýáíáýžř', 1, 'test-content', 'TEXT_BOX'),
  (2, 'Editace textu', 1, 'popis-auta', 'CK_EDITOR'),
  (3, 'Pavel popis', 1, 'popis-pavel', 'CK_EDITOR'),
  (4, 'Dobrý den, vítejte!', 1, 'wellcome-text', 'TEXT_BOX'),
  (5, '<span style=\"color: red\">Samuel Butta</span>\r\n<br>\r\nPavel novotný', 3, 'author-name', 'TEXT_BOX');


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
  (1, 'ROLE_USER'),
  (2, 'ROLE_ADMIN'),
  (3, 'ROLE_DEVELOPER');

INSERT INTO `user` (`id`, `active`, `email`, `first_name`, `last_name`, `password`) VALUES
  (1, 1, 'developer@admin.cz', 'Joe', 'Doe', '$2a$10$cIZhwKsIsM9kv6guM.iQnOCNKIfIaGSEkrJ7OSU2.02hmtAHAbCou'),
  (2, 1, 'admin@admin.cz', 'Joe', 'Doe', '$2a$10$cIZhwKsIsM9kv6guM.iQnOCNKIfIaGSEkrJ7OSU2.02hmtAHAbCou');

INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 1),
  (2, 2);