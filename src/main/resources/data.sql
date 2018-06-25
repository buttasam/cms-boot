SET NAMES utf8;
SET foreign_key_checks = 0;

INSERT INTO `page` (`id`, `url`, `title`) VALUES
  (1, 'homepage', 'Homepage'),
  (2, 'about', 'About'),
  (3, 'contacts', 'Contacts');


INSERT INTO `page_text` (`id`, `content`, `page_id`, `identity`, `type`) VALUES
  (1, 'Wellcome text', 1, 'wellcome-text', 'TEXT_BOX'),
  (2, 'Homepage text', 1, 'homepage-text', 'CK_EDITOR'),
  (3, 'About text', 2, 'about-text', 'CK_EDITOR'),
  (4, 'Contacts text', 3, 'contacts-text', 'CK_EDITOR');

INSERT INTO `page_image` (`id`, `file_name`, `identity`, `path`, `page_id`) VALUES
(1,	'dummy1.png',	'about-image',	NULL,	2);


INSERT INTO `product` (`id`, `price`, `title`) VALUES
(1,	129,	'Product1'),
(2,	299,	'Product2');


INSERT INTO `role` (`id`, `role`) VALUES
  (1, 'ROLE_USER'),
  (2, 'ROLE_ADMIN'),
  (3, 'ROLE_DEVELOPER');

INSERT INTO `user` (`id`, `active`, `email`, `first_name`, `last_name`, `password`) VALUES
  (1, 1, 'developer@admin.com', 'Joe', 'Doe', '$2a$10$Jg/n0bwaYZxJBhTPVhWuDO989e3xmLbUPnB/IXNde/LfbCHjPPt8.'),
  (2, 1, 'admin@admin.com', 'Joe', 'Doe', '$2a$10$Jg/n0bwaYZxJBhTPVhWuDO989e3xmLbUPnB/IXNde/LfbCHjPPt8.');

INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 1),
  (2, 2);