DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS accounts;

CREATE TABLE IF NOT EXISTS accounts (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(500),
  address VARCHAR(500),
  inn VARCHAR(100),
  kpp VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS orders (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(500),
  account_id BIGINT REFERENCES accounts (id) ON DELETE CASCADE,
  order_date TIMESTAMP,
  amount INT
);

INSERT INTO accounts (name, address, inn, kpp) VALUES ('First', 'First Address', '11112222', '11112222');
INSERT INTO accounts (name, address, inn, kpp) VALUES ('Second', 'Second Address', '33344444', '77777777');
INSERT INTO accounts (name, address, inn, kpp) VALUES ('Third', 'Third Address', '33344444', '88888888');
INSERT INTO accounts (name, address, inn, kpp) VALUES ('Fourth', 'Fourth Address', '33344444', '77777777');
INSERT INTO accounts (name, address, inn, kpp) VALUES ('Fifth', 'Fifth Address', '77775555', '66666666');

INSERT INTO orders (name, account_id, order_date, amount) VALUES ('First Order', 1, NOW(), 415);
INSERT INTO orders (name, account_id, order_date, amount) VALUES ('Super First Order', 1, NOW(), 10);
INSERT INTO orders (name, account_id, order_date, amount) VALUES ('Second Order', 1, NOW(), 185);
INSERT INTO orders (name, account_id, order_date, amount) VALUES ('Third Order', 2, NOW(), 300);
INSERT INTO orders (name, account_id, order_date, amount) VALUES ('Fifth Order', 3, NOW(), 777);
INSERT INTO orders (name, account_id, order_date, amount) VALUES ('Fifth Order First', 3, NOW(), 1);
INSERT INTO orders (name, account_id, order_date, amount) VALUES ('Fifth Order Second', 3, NOW(), 2);

-- 1
SELECT a.* FROM accounts a INNER JOIN orders o ON a.id = o.account_id GROUP BY a.id ORDER BY COUNT(o.id) DESC LIMIT 1;

-- 2
SELECT a.* FROM accounts a INNER JOIN orders o ON a.id = o.account_id GROUP BY a.id ORDER BY SUM(o.amount) DESC LIMIT 1;

-- 3
-- SELECT SUM(o.amount) FROM orders o WHERE o.order_date > EXTRACT year

-- 4
SELECT a.* FROM accounts a INNER JOIN orders o ON a.id = o.account_id GROUP BY a.id HAVING COUNT(o.id) > 2;

-- 5
SELECT a1.* FROM accounts a1 INNER JOIN
  (SELECT a2.inn, a2.kpp FROM accounts a2 GROUP BY a2.inn, a2.kpp HAVING COUNT(a2.*) > 1) a2
    ON a1.inn = a2.inn AND a1.kpp = a2.kpp;

-- Айдар первое задание
SELECT *
FROM accounts
WHERE id = (SELECT account_id
            FROM orders GROUP BY account_id
            ORDER BY Count(id) DESC
            LIMIT 1)
