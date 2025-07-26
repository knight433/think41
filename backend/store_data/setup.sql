CREATE SCHEMA dev;

-- 1. distribution_centers
CREATE TABLE dev.distribution_centers (
  id                        INTEGER PRIMARY KEY,
  name                      TEXT NOT NULL,
  latitude                  DOUBLE PRECISION,
  longitude                 DOUBLE PRECISION
);

-- 2. inventory_items
CREATE TABLE dev.inventory_items (
  id                              INTEGER PRIMARY KEY,
  product_id                      INTEGER NOT NULL,
  created_at                      TIMESTAMP NOT NULL,
  sold_at                         TIMESTAMP,
  cost                            NUMERIC(10,2),
  product_category                TEXT,
  product_name                    TEXT,
  product_brand                   TEXT,
  product_retail_price            NUMERIC(10,2),
  product_department              TEXT,
  product_sku                     TEXT,
  product_distribution_center_id  INTEGER,
  FOREIGN KEY (product_distribution_center_id)
    REFERENCES dev.distribution_centers (id)
);

-- 3. order_items
CREATE TABLE dev.order_items (
  id                INTEGER PRIMARY KEY,
  order_id          INTEGER NOT NULL,
  user_id           INTEGER NOT NULL,
  product_id        INTEGER NOT NULL,
  inventory_item_id INTEGER NOT NULL,
  status            TEXT,
  created_at        TIMESTAMP NOT NULL,
  shipped_at        TIMESTAMP,
  delivered_at      TIMESTAMP,
  returned_at       TIMESTAMP
);

-- 4. orders
CREATE TABLE dev.orders (
  order_id     INTEGER PRIMARY KEY,
  user_id      INTEGER NOT NULL,
  status       TEXT,
  gender       TEXT,
  created_at   TIMESTAMP NOT NULL,
  returned_at  TIMESTAMP,
  shipped_at   TIMESTAMP,
  delivered_at TIMESTAMP,
  num_of_item  INTEGER
);

-- 5. products
CREATE TABLE dev.products (
  id                     INTEGER PRIMARY KEY,
  cost                   NUMERIC(10,2),
  category               TEXT,
  name                   TEXT,
  brand                  TEXT,
  retail_price           NUMERIC(10,2),
  department             TEXT,
  sku                    TEXT,
  distribution_center_id INTEGER,
  FOREIGN KEY (distribution_center_id)
    REFERENCES dev.distribution_centers (id)
);

-- 6. users
CREATE TABLE dev.users (
  id             INTEGER PRIMARY KEY,
  first_name     TEXT,
  last_name      TEXT,
  email          TEXT UNIQUE,
  age            INTEGER,
  gender         TEXT,
  state          TEXT,
  street_address TEXT,
  postal_code    TEXT,
  city           TEXT,
  country        TEXT,
  latitude       DOUBLE PRECISION,
  longitude      DOUBLE PRECISION,
  traffic_source TEXT,
  created_at     TIMESTAMP NOT NULL
);
