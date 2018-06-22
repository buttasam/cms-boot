SET NAMES utf8;
SET foreign_key_checks = 0;

INSERT INTO `page` (`id`, `url`, `title`) VALUES
  (1, 'homepage', 'Homepage'),
  (2, 'about', 'About'),
  (3, 'contacts', 'Contacts');


INSERT INTO `page_text` (`id`, `content`, `page_id`, `identity`, `type`) VALUES
  (1, 'Wellcome text', 1, 'wellcome-text', 'TEXT_BOX'),
  (2, 'Homepage text', 1, 'homepage-text', 'CK_EDITOR'),
  (3, 'About text', 1, 'about-text', 'CK_EDITOR'),
  (4, 'Contact text', 2, 'contact-text', 'CK_EDITOR');


INSERT INTO `role` (`id`, `role`) VALUES
  (1, 'ROLE_USER'),
  (2, 'ROLE_ADMIN'),
  (3, 'ROLE_DEVELOPER');

INSERT INTO `user` (`id`, `active`, `email`, `first_name`, `last_name`, `password`) VALUES
  (1, 1, 'developer@admin.cz', 'Joe', 'Doe', '$2a$10$cIZhwKsIsM9kv6guM.iQnOCNKIfIaGSEkrJ7OSU2.02hmtAHAbCou'),
  (2, 1, 'admin@admin.cz', 'Joe', 'Doe', '$2a$10$Jg/n0bwaYZxJBhTPVhWuDO989e3xmLbUPnB/IXNde/LfbCHjPPt8.');

INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 1),
  (2, 2);