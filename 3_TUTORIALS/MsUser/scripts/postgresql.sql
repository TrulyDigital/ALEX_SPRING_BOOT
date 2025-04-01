-- table users
CREATE TABLE users(
  id UUID PRIMARY KEY,          -- binary
  name VARCHAR(255) NOT NULL,   --
  age INTEGER NOT NULL          --
);

-- table users - index
CREATE INDEX idx_users_id ON users(id);

-- select
SELECT * FROM users;
SELECT id, name, age FROM users;