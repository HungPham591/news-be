CREATE TABLE `admin`
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at timestamp    DEFAULT NOW() NULL,
    created_by VARCHAR(255) DEFAULT 'System' NULL,
    updated_at timestamp    DEFAULT NOW() NULL,
    updated_by VARCHAR(255) DEFAULT 'System' NULL,
    deleted_at datetime NULL,
    user_name  VARCHAR(255) NULL,
    password   VARCHAR(255) NULL,
    CONSTRAINT pk_admin PRIMARY KEY (id)
);

CREATE TABLE author
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at timestamp    DEFAULT NOW() NULL,
    created_by VARCHAR(255) DEFAULT 'System' NULL,
    updated_at timestamp    DEFAULT NOW() NULL,
    updated_by VARCHAR(255) DEFAULT 'System' NULL,
    deleted_at datetime NULL,
    email      VARCHAR(255) NULL,
    phone      VARCHAR(255) NULL,
    name       VARCHAR(255) NULL,
    image      VARCHAR(255) NULL,
    status     VARCHAR(255) NULL,
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE category
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    timestamp    DEFAULT NOW() NULL,
    created_by    VARCHAR(255) DEFAULT 'System' NULL,
    updated_at    timestamp    DEFAULT NOW() NULL,
    updated_by    VARCHAR(255) DEFAULT 'System' NULL,
    deleted_at    datetime NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE comment
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at timestamp    DEFAULT NOW() NULL,
    created_by VARCHAR(255) DEFAULT 'System' NULL,
    updated_at timestamp    DEFAULT NOW() NULL,
    updated_by VARCHAR(255) DEFAULT 'System' NULL,
    deleted_at datetime NULL,
    content    VARCHAR(255) NULL,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);

CREATE TABLE config_app
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at timestamp    DEFAULT NOW() NULL,
    created_by VARCHAR(255) DEFAULT 'System' NULL,
    updated_at timestamp    DEFAULT NOW() NULL,
    updated_by VARCHAR(255) DEFAULT 'System' NULL,
    deleted_at datetime NULL,
    email      VARCHAR(255) NULL,
    CONSTRAINT pk_config_app PRIMARY KEY (id)
);

CREATE TABLE file
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at timestamp    DEFAULT NOW() NULL,
    created_by VARCHAR(255) DEFAULT 'System' NULL,
    updated_at timestamp    DEFAULT NOW() NULL,
    updated_by VARCHAR(255) DEFAULT 'System' NULL,
    deleted_at datetime NULL,
    name       VARCHAR(255) NULL,
    url        VARCHAR(255) NULL,
    CONSTRAINT pk_file PRIMARY KEY (id)
);

CREATE TABLE news
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at timestamp    DEFAULT NOW() NULL,
    created_by VARCHAR(255) DEFAULT 'System' NULL,
    updated_at timestamp    DEFAULT NOW() NULL,
    updated_by VARCHAR(255) DEFAULT 'System' NULL,
    deleted_at datetime NULL,
    title      VARCHAR(255) NULL,
    content    VARCHAR(255) NULL,
    CONSTRAINT pk_news PRIMARY KEY (id)
);

CREATE TABLE profile
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at timestamp    DEFAULT NOW() NULL,
    created_by VARCHAR(255) DEFAULT 'System' NULL,
    updated_at timestamp    DEFAULT NOW() NULL,
    updated_by VARCHAR(255) DEFAULT 'System' NULL,
    deleted_at datetime NULL,
    email      VARCHAR(255) NULL,
    phone      VARCHAR(255) NULL,
    name       VARCHAR(255) NULL,
    image      VARCHAR(255) NULL,
    birthdate  datetime NULL,
    gender     SMALLINT NULL,
    CONSTRAINT pk_profile PRIMARY KEY (id)
);