CREATE TABLE authors
(
    id          SERIAL PRIMARY KEY,
    author_name VARCHAR(50) NOT NULL,
    gender      VARCHAR(50) NOT NULL
);

CREATE TABLE books
(
    id             SERIAL PRIMARY KEY,
    title          VARCHAR(100) NOT NULL,
    published_date TIMESTAMP    NOT NULL,
    author_id      INT REFERENCES authors (id) ON DELETE CASCADE
);

CREATE TABLE categories
(
    id            SERIAL PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE book_category
(
    book_id     INT REFERENCES books (id) ON DELETE CASCADE ,
    category_id INT REFERENCES categories (id) ON  DELETE CASCADE ,
    PRIMARY KEY (book_id, category_id)
);

INSERT INTO authors (author_name, gender)
VALUES ('Gech Seang', 'female')
RETURNING *;

UPDATE authors
SET author_name = 'ChunYeang', gender = 'male'
WHERE id = 5;


