CREATE TABLE role (
                      id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      role VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE app_user (
                      id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      first_name VARCHAR(255),
                      last_name VARCHAR(255),
                      active BOOLEAN NOT NULL
);

CREATE TABLE user_roles (
                            user_id BIGINT NOT NULL,
                            roles_id BIGINT NOT NULL,
                            PRIMARY KEY (user_id, roles_id),
                            CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES app_user (id),
                            CONSTRAINT fk_role FOREIGN KEY (roles_id) REFERENCES role (id)
);

CREATE TABLE page (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255),
                      url VARCHAR(255) UNIQUE,
                      parent_page_id BIGINT,
                      FOREIGN KEY (parent_page_id) REFERENCES page(id)
);

CREATE TABLE page_text (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           content CLOB,
                           identity VARCHAR(255) UNIQUE,
                           page_id BIGINT,
                           type VARCHAR(255),
                           FOREIGN KEY (page_id) REFERENCES page(id)
);

CREATE TABLE page_image (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            file_name VARCHAR(255),
                            identity VARCHAR(255) UNIQUE,
                            path VARCHAR(255),
                            page_id BIGINT,
                            FOREIGN KEY (page_id) REFERENCES page(id)
);

CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         price DOUBLE NOT NULL,
                         title VARCHAR(255) NOT NULL
);

CREATE TABLE notification (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              message VARCHAR(255) NOT NULL,
                              status VARCHAR(255) NOT NULL
);