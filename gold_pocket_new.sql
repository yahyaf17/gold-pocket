/*
 Navicat PostgreSQL Data Transfer

 Source Server         : mandiri-academy
 Source Server Type    : PostgreSQL
 Source Server Version : 130002
 Source Host           : localhost:5432
 Source Catalog        : gold_pocket_new
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130002
 File Encoding         : 65001

 Date: 27/04/2021 22:21:04
*/


-- ----------------------------
-- Sequence structure for customer_customer_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customer_customer_id_seq";
CREATE SEQUENCE "public"."customer_customer_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."customer_customer_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Sequence structure for product_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."product_id_seq";
CREATE SEQUENCE "public"."product_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;
ALTER SEQUENCE "public"."product_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Table structure for m_customers
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_customers";
CREATE TABLE "public"."m_customers" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "first_name" varchar(30) COLLATE "pg_catalog"."default",
  "last_name" varchar(30) COLLATE "pg_catalog"."default",
  "birth_date" date,
  "address" text COLLATE "pg_catalog"."default",
  "status" int4,
  "username" varchar(30) COLLATE "pg_catalog"."default",
  "password" varchar(100) COLLATE "pg_catalog"."default",
  "email" varchar(100) COLLATE "pg_catalog"."default",
  "created_at" date,
  "updated_at" date
)
;
ALTER TABLE "public"."m_customers" OWNER TO "postgres";

-- ----------------------------
-- Records of m_customers
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_customers" VALUES ('4028abad7912dc47017912dfa68e0001', 'Emir Ibrahim', 'Faisal', '2020-09-21', 'Jl. Sesama No. 11, Tangerang Selatan', 1, 'emir.ibrahim', 'password', 'emir@mail.com', '2021-04-27', '2021-04-27');
INSERT INTO "public"."m_customers" VALUES ('4028abad7912dc47017912e3377a0002', 'Bruno', 'Fernandes', '1988-09-21', 'Portugal Street No. 11, Manchester, UK', 1, 'fernandes.bruno', 'password', 'bruno@mail.com', '2021-04-27', '2021-04-27');
INSERT INTO "public"."m_customers" VALUES ('4028abad7912dc47017912dd17290000', 'Yahya Faikar', 'Hanif', '1998-01-17', 'Jl. Jalan No. 17, Papua Barat', 1, 'yahyaf17', 'password17', 'yahya@mail.com', '2021-04-27', '2021-04-27');
COMMIT;

-- ----------------------------
-- Table structure for m_history_prices
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_history_prices";
CREATE TABLE "public"."m_history_prices" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "history_date" timestamp(6),
  "price_buy" numeric(32,0),
  "price_sell" numeric(32,0),
  "product_id" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."m_history_prices" OWNER TO "postgres";

-- ----------------------------
-- Records of m_history_prices
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_history_prices" VALUES ('4028abad791316c3017913170eef0001', '2021-04-27 18:29:08.773', 860000, 880000, '4028abad791316c3017913170eb80000');
INSERT INTO "public"."m_history_prices" VALUES ('4028abad791316c30179131727740002', '2021-04-27 18:29:14.986', 850000, 870000, '4028abad791316c3017913170eb80000');
INSERT INTO "public"."m_history_prices" VALUES ('4028abad791316c30179131ca4bc0004', '2021-04-27 18:35:14.871', 880000, 902000, '4028abad791316c3017913170eb80000');
INSERT INTO "public"."m_history_prices" VALUES ('4028abad7913db0d017913e4b3df0019', '2021-04-27 22:13:45.943', 650000, 665000, '4028abad7913db0d017913e4b3da0018');
INSERT INTO "public"."m_history_prices" VALUES ('4028abad7913db0d017913e57e35001b', '2021-04-27 22:14:37.747', 1300000, 1410000, '4028abad7913db0d017913e57e34001a');
COMMIT;

-- ----------------------------
-- Table structure for m_pockets
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_pockets";
CREATE TABLE "public"."m_pockets" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "pocket_name" varchar(255) COLLATE "pg_catalog"."default",
  "pocket_qty" float4 NOT NULL DEFAULT 0.0,
  "customer_id" varchar(100) COLLATE "pg_catalog"."default",
  "product_id" varchar(100) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."m_pockets" OWNER TO "postgres";

-- ----------------------------
-- Records of m_pockets
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_pockets" VALUES ('4028abad7913bb2d017913bb54260000', 'Dana Sekolah Anak', 26, '4028abad7912dc47017912dd17290000', '4028abad791316c3017913170eb80000');
INSERT INTO "public"."m_pockets" VALUES ('4028abad79134686017913469e260000', 'Dana Pensiunku', 18, '4028abad7912dc47017912dd17290000', '4028abad791316c3017913170eb80000');
COMMIT;

-- ----------------------------
-- Table structure for m_products
-- ----------------------------
DROP TABLE IF EXISTS "public"."m_products";
CREATE TABLE "public"."m_products" (
  "id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "product_name" varchar(100) COLLATE "pg_catalog"."default",
  "product_price_buy" numeric,
  "product_price_sell" numeric,
  "product_image" varchar(100) COLLATE "pg_catalog"."default",
  "product_status" int4,
  "created_at" date,
  "updated_at" date
)
;
ALTER TABLE "public"."m_products" OWNER TO "postgres";

-- ----------------------------
-- Records of m_products
-- ----------------------------
BEGIN;
INSERT INTO "public"."m_products" VALUES ('4028abad791316c3017913170eb80000', 'Gold', 880000, 902000, 'gold.png', 1, '2021-04-27', '2021-04-27');
INSERT INTO "public"."m_products" VALUES ('4028abad7913db0d017913e4b3da0018', 'Silver', 650000, 665000, 'silver.png', 1, '2021-04-27', '2021-04-27');
INSERT INTO "public"."m_products" VALUES ('4028abad7913db0d017913e57e34001a', 'Platinum', 1300000, 1410000, 'platinum.png', 1, '2021-04-27', '2021-04-27');
COMMIT;

-- ----------------------------
-- Table structure for t_purchase_details
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_purchase_details";
CREATE TABLE "public"."t_purchase_details" (
  "purchase_detail_id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "price" numeric,
  "quantity_in_gram" float4,
  "product_id" varchar(100) COLLATE "pg_catalog"."default",
  "purchase_id" varchar(100) COLLATE "pg_catalog"."default",
  "pocket_id" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."t_purchase_details" OWNER TO "postgres";

-- ----------------------------
-- Records of t_purchase_details
-- ----------------------------
BEGIN;
INSERT INTO "public"."t_purchase_details" VALUES ('4028abad7913db0d017913df1a21000d', 902000, 10, '4028abad791316c3017913170eb80000', '4028abad7913db0d017913df1a21000c', '4028abad79134686017913469e260000');
INSERT INTO "public"."t_purchase_details" VALUES ('4028abad7913db0d017913df1a22000e', 902000, 15, '4028abad791316c3017913170eb80000', '4028abad7913db0d017913df1a21000c', '4028abad7913bb2d017913bb54260000');
INSERT INTO "public"."t_purchase_details" VALUES ('4028abad7913db0d017913df46ad0010', 902000, 15, '4028abad791316c3017913170eb80000', '4028abad7913db0d017913df46ad000f', '4028abad7913bb2d017913bb54260000');
INSERT INTO "public"."t_purchase_details" VALUES ('4028abad7913db0d017913df46ad0011', 902000, 10, '4028abad791316c3017913170eb80000', '4028abad7913db0d017913df46ad000f', '4028abad79134686017913469e260000');
INSERT INTO "public"."t_purchase_details" VALUES ('4028abad7913db0d017913df5e130013', 902000, 15, '4028abad791316c3017913170eb80000', '4028abad7913db0d017913df5e130012', '4028abad7913bb2d017913bb54260000');
INSERT INTO "public"."t_purchase_details" VALUES ('4028abad7913db0d017913df5e130014', 902000, 10, '4028abad791316c3017913170eb80000', '4028abad7913db0d017913df5e130012', '4028abad79134686017913469e260000');
INSERT INTO "public"."t_purchase_details" VALUES ('4028abad7913db0d017913e3644e0016', 880000, 19, '4028abad791316c3017913170eb80000', '4028abad7913db0d017913e3644d0015', '4028abad7913bb2d017913bb54260000');
INSERT INTO "public"."t_purchase_details" VALUES ('4028abad7913db0d017913e3644e0017', 880000, 12, '4028abad791316c3017913170eb80000', '4028abad7913db0d017913e3644d0015', '4028abad79134686017913469e260000');
COMMIT;

-- ----------------------------
-- Table structure for t_purchases
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_purchases";
CREATE TABLE "public"."t_purchases" (
  "purchase_id" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "purchase_date" date,
  "customer_id" varchar(100) COLLATE "pg_catalog"."default",
  "purchase_type" int4
)
;
ALTER TABLE "public"."t_purchases" OWNER TO "postgres";

-- ----------------------------
-- Records of t_purchases
-- ----------------------------
BEGIN;
INSERT INTO "public"."t_purchases" VALUES ('4028abad7913db0d017913df1a21000c', '2021-04-27', '4028abad7912dc47017912dd17290000', 0);
INSERT INTO "public"."t_purchases" VALUES ('4028abad7913db0d017913df46ad000f', '2021-04-27', '4028abad7912dc47017912dd17290000', 0);
INSERT INTO "public"."t_purchases" VALUES ('4028abad7913db0d017913df5e130012', '2021-04-27', '4028abad7912dc47017912dd17290000', 0);
INSERT INTO "public"."t_purchases" VALUES ('4028abad7913db0d017913e3644d0015', '2021-04-27', '4028abad7912dc47017912dd17290000', 1);
COMMIT;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."customer_customer_id_seq"
OWNED BY "public"."m_customers"."id";
SELECT setval('"public"."customer_customer_id_seq"', 8, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."product_id_seq"
OWNED BY "public"."m_products"."id";
SELECT setval('"public"."product_id_seq"', 6, true);

-- ----------------------------
-- Primary Key structure for table m_customers
-- ----------------------------
ALTER TABLE "public"."m_customers" ADD CONSTRAINT "m_customer_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_history_prices
-- ----------------------------
ALTER TABLE "public"."m_history_prices" ADD CONSTRAINT "history_price_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_pockets
-- ----------------------------
ALTER TABLE "public"."m_pockets" ADD CONSTRAINT "m_pocket_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table m_products
-- ----------------------------
ALTER TABLE "public"."m_products" ADD CONSTRAINT "product_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_purchase_details
-- ----------------------------
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "purchase_detail_pkey" PRIMARY KEY ("purchase_detail_id");

-- ----------------------------
-- Primary Key structure for table t_purchases
-- ----------------------------
ALTER TABLE "public"."t_purchases" ADD CONSTRAINT "purchase_pkey" PRIMARY KEY ("purchase_id");

-- ----------------------------
-- Foreign Keys structure for table m_history_prices
-- ----------------------------
ALTER TABLE "public"."m_history_prices" ADD CONSTRAINT "fk_product_history" FOREIGN KEY ("product_id") REFERENCES "public"."m_products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table m_pockets
-- ----------------------------
ALTER TABLE "public"."m_pockets" ADD CONSTRAINT "fk_pocket_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."m_customers" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."m_pockets" ADD CONSTRAINT "fk_pocket_product" FOREIGN KEY ("product_id") REFERENCES "public"."m_products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table t_purchase_details
-- ----------------------------
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "fk_purchase_detail_product" FOREIGN KEY ("product_id") REFERENCES "public"."m_products" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "fk_purchase_detail_purchase" FOREIGN KEY ("purchase_id") REFERENCES "public"."t_purchases" ("purchase_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."t_purchase_details" ADD CONSTRAINT "fkebmr362n2hfocm5jwceup3qbr" FOREIGN KEY ("pocket_id") REFERENCES "public"."m_pockets" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table t_purchases
-- ----------------------------
ALTER TABLE "public"."t_purchases" ADD CONSTRAINT "fk_purchase_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."m_customers" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
