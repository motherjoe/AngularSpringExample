-- Create User table
CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_active` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
);

-- Create Book table
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `star_rating` int(11) DEFAULT NULL,
  `description` text,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_book_fk` (`user_id`),
  CONSTRAINT `user_book_fk` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
);



