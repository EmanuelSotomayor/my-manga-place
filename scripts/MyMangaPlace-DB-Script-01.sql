CREATE DATABASE IF NOT EXISTS my_manga_place;

USE my_manga_place;

CREATE TABLE IF NOT EXISTS users(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` TEXT NOT NULL,
  `created_at` DATE,
  `deleted` BIT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS roles(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_rol(
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `user_id` BIGINT,
    `rol_id` BIGINT,
    CONSTRAINT FK_user_rol_user_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT FK_user_rol_rol_id FOREIGN KEY (rol_id) REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS likes(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `counter` BIGINT
);

CREATE TABLE IF NOT EXISTS dislikes(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `counter` BIGINT
);

CREATE TABLE IF NOT EXISTS comments(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `text` LONGTEXT NOT NULL,
  `likes_id` BIGINT,
  `dislikes_id` BIGINT,
  `deleted` BIT DEFAULT 0,
  CONSTRAINT `FK_comments_likes_id` FOREIGN KEY (likes_id) REFERENCES likes(id),
  CONSTRAINT `FK_comments_dislikes_id` FOREIGN KEY (dislikes_id) REFERENCES dislikes(id)
);

CREATE TABLE IF NOT EXISTS categories(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS genres(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(100),
  `description` VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS categories_genres(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `categories_id` BIGINT,
  `genres_id` BIGINT,
  CONSTRAINT `FK_categories_genres_categories_id` FOREIGN KEY (categories_id) REFERENCES categories(id),
  CONSTRAINT `FK_categories_genres_genres_id` FOREIGN KEY (genres_id) REFERENCES genres(id)
);

CREATE TABLE IF NOT EXISTS images(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `title` VARCHAR(255),
  `size` BIGINT,
  `hash` LONGBLOB
);

CREATE TABLE IF NOT EXISTS animes(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(255),
  `description` TEXT,
  `release_date` DATE,
  `images_id` BIGINT,
  `likes_id` BIGINT,
  `dislikes_id` BIGINT,
  CONSTRAINT `FK_animes_images_id` FOREIGN KEY (images_id) REFERENCES images(id),
  CONSTRAINT `FK_animes_likes_id` FOREIGN KEY (likes_id) REFERENCES likes(id),
  CONSTRAINT `FK_animes_dislikes_id` FOREIGN KEY (dislikes_id) REFERENCES dislikes(id)
);

CREATE TABLE IF NOT EXISTS mangas(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(255),
  `description` TEXT,
  `release_date` DATE,
  `images_id` BIGINT,
  `likes_id` BIGINT,
  `dislikes_id` BIGINT,
   CONSTRAINT `FK_mangas_images_id` FOREIGN KEY (images_id) REFERENCES images(id),
   CONSTRAINT `FK_mangas_likes_id` FOREIGN KEY (likes_id) REFERENCES likes(id),
   CONSTRAINT `FK_mangas_dislikes_id` FOREIGN KEY (dislikes_id) REFERENCES dislikes(id)
);

CREATE TABLE IF NOT EXISTS authors(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(100),
  `surname` VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS animes_authors(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `animes_id` BIGINT,
  `authors_id` BIGINT,
  CONSTRAINT `FK_animes_authors_animes_id` FOREIGN KEY (animes_id) REFERENCES animes(id),
  CONSTRAINT `FK_animes_authors_authors_id` FOREIGN KEY (authors_id) REFERENCES authors(id)
);

CREATE TABLE IF NOT EXISTS mangas_authors(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `mangas_id` BIGINT,
  `authors_id` BIGINT,
  CONSTRAINT `FK_mangas_authors_mangas_id` FOREIGN KEY (mangas_id) REFERENCES mangas(id),
  CONSTRAINT `FK_mangas_authors_authors_id` FOREIGN KEY (authors_id) REFERENCES authors(id)
);

CREATE TABLE IF NOT EXISTS user_rol_mangas_comments(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `user_rol_id` BIGINT,
  `mangas_id` BIGINT,
  `comments_id` BIGINT,
  CONSTRAINT `FK_user_rol_mangas_comments_users_rol_id` FOREIGN KEY (user_rol_id) REFERENCES user_rol(id),
  CONSTRAINT `FK_user_rol_mangas_comments_mangas_id` FOREIGN KEY (mangas_id) REFERENCES mangas(id),
  CONSTRAINT `FK_user_rol_mangas_comments_comments_id` FOREIGN KEY (comments_id) REFERENCES comments(id)
);

CREATE TABLE IF NOT EXISTS user_rol_animes_comments(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `user_rol_id` BIGINT,
  `animes_id` BIGINT,
  `comments_id` BIGINT,
  CONSTRAINT `FK_user_rol_animes_comments_users_rol_id` FOREIGN KEY (user_rol_id) REFERENCES user_rol(id),
  CONSTRAINT `FK_user_rol_animes_comments_animes_id` FOREIGN KEY (animes_id) REFERENCES animes(id),
  CONSTRAINT `FK_user_rol_animes_comments_comments_id` FOREIGN KEY (comments_id) REFERENCES comments(id)
);

CREATE TABLE IF NOT EXISTS user_rol_animes_authors_categories_genres(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `user_rol_id` BIGINT,
  `animes_authors_id` BIGINT,
  `categories_genres_id` BIGINT,
  CONSTRAINT `FK_usraa_user_rol_id` FOREIGN KEY (user_rol_id) REFERENCES user_rol(id),
  CONSTRAINT `FK_usraa_authros_id`
  FOREIGN KEY (animes_authors_id) REFERENCES animes_authors(id),
  CONSTRAINT `FK_usraa_categories_id`
  FOREIGN KEY (categories_genres_id) REFERENCES categories_genres(id)
);

CREATE TABLE IF NOT EXISTS user_rol_mangas_authors_categories_genres(
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `user_rol_id` BIGINT,
  `mangas_authors_id` BIGINT,
  `categories_genres_id` BIGINT,
  CONSTRAINT `FK_usrma_user_rol_id` FOREIGN KEY (user_rol_id) REFERENCES user_rol(id),
  CONSTRAINT `FK_usrma_authors_id`
  FOREIGN KEY (mangas_authors_id) REFERENCES mangas_authors(id),
  CONSTRAINT `FK_usrma_categories_id`
  FOREIGN KEY (categories_genres_id) REFERENCES categories_genres(id)
);