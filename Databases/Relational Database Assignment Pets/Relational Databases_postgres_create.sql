--
-- DROP FOREIGN KEYS
--
ALTER TABLE IF EXISTS "vets" DROP CONSTRAINT IF EXISTS "vets_fk0";
ALTER TABLE IF EXISTS "caretakers" DROP CONSTRAINT IF EXISTS "caretakers_fk0";
ALTER TABLE IF EXISTS "pets" DROP CONSTRAINT IF EXISTS "pets_fk0";
ALTER TABLE IF EXISTS "caretaker_pets" DROP CONSTRAINT IF EXISTS "caretaker_pets_fk0";
ALTER TABLE IF EXISTS "caretaker_pets" DROP CONSTRAINT IF EXISTS "caretaker_pets_fk1";
--
-- DROP TABLES
--
DROP TABLE IF EXISTS "vets";
DROP TABLE IF EXISTS "cities";
DROP TABLE IF EXISTS "caretakers";
DROP TABLE IF EXISTS "pets";
DROP TABLE IF EXISTS "caretaker_pets";

--
-- CREATE TABLES
--
CREATE TABLE "vets" (
	"cvr" char(8) NOT NULL,
	"name" varchar(50) NOT NULL,
	"phone" varchar(12) NOT NULL,
	"street" varchar(50) NOT NULL,
	"fk_zip_code" char(4) NOT NULL,
	CONSTRAINT "vets_pk" PRIMARY KEY ("cvr")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "cities" (
	"zip_code" char(4) NOT NULL UNIQUE,
	"city_name" varchar(50) NOT NULL,
	CONSTRAINT "cities_pk" PRIMARY KEY ("zip_code")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "caretakers" (
	"id" serial NOT NULL,
	"name" varchar(50) NOT NULL,
	"phone" varchar(12) NOT NULL,
	"street" varchar(50) NOT NULL,
	"fk_zip_code" char(4) NOT NULL,
	CONSTRAINT "caretakers_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "pets" (
	"id" serial NOT NULL,
	"d_type" varchar(20) NOT NULL,
	"name" varchar(50) NOT NULL,
	"age" int NOT NULL,
	"live_count" int DEFAULT '9',
	"bark_pitch" char(2),
	"fk_vet_cvr" char(8),
	CONSTRAINT "pets_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "caretaker_pets" (
	"caretaker_id" int NOT NULL,
	"pet_id" int NOT NULL
) WITH (
  OIDS=FALSE
);

--
-- CREATE FOREIGN KEYS (CONSTRAINTS)
--
ALTER TABLE "vets" ADD CONSTRAINT "vets_fk0" FOREIGN KEY ("fk_zip_code") REFERENCES "cities"("zip_code");
ALTER TABLE "caretakers" ADD CONSTRAINT "caretakers_fk0" FOREIGN KEY ("fk_zip_code") REFERENCES "cities"("zip_code");
ALTER TABLE "pets" ADD CONSTRAINT "pets_fk0" FOREIGN KEY ("fk_vet_cvr") REFERENCES "vets"("cvr");
ALTER TABLE "caretaker_pets" ADD CONSTRAINT "caretaker_pets_fk0" FOREIGN KEY ("caretaker_id") REFERENCES "caretakers"("id");
ALTER TABLE "caretaker_pets" ADD CONSTRAINT "caretaker_pets_fk1" FOREIGN KEY ("pet_id") REFERENCES "pets"("id");

