CREATE TABLE users (
    id TEXT PRIMARY KEY NOT NULL,
    email TEXT  NOT NUll UNIQUE,
    password TEXT NOT NULL
);