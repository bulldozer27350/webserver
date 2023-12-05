DROP USER IF EXISTS sa;
CREATE USER sa;

DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS category;

CREATE TABLE article (
  id SERIAL PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  stock_quantity INTEGER NOT NULL,
  short_description VARCHAR(250) NOT NULL,
  long_description VARCHAR(250) NOT NULL,
  category_id VARCHAR(250) NOT NULL
);

CREATE TABLE category (
  id SERIAL  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

GRANT USAGE ON SCHEMA public TO sa;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO sa;
GRANT ALL PRIVILEGES ON category_id_seq, article_id_seq TO sa;