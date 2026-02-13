-- PHARMACY
CREATE TABLE IF NOT EXISTS pharmacy (
                                        cnpj VARCHAR(14) PRIMARY KEY,
    accreditation_date DATE,
    address VARCHAR(255),
    city VARCHAR(255),
    name VARCHAR(255),
    neighborhood VARCHAR(255),
    state VARCHAR(255)
    );

-- INDICATION CATEGORY (id manual, sem serial)
CREATE TABLE IF NOT EXISTS indication_category (
                                                   id BIGINT PRIMARY KEY,
                                                   indication VARCHAR(150) UNIQUE
    );

-- MEDICATION REFERENCE
CREATE TABLE IF NOT EXISTS medication_name (
                                               medicine_code VARCHAR(255) PRIMARY KEY,
    medicine_name VARCHAR(255) NOT NULL UNIQUE,
    indication_category_id BIGINT NOT NULL REFERENCES indication_category(id)
    );

-- STOCK (estado atual)
CREATE TABLE IF NOT EXISTS pharmacy_medicine_stock (
                                                       id BIGSERIAL PRIMARY KEY,
                                                       quantity INT,
                                                       stock_status VARCHAR(255),
    updated_at TIMESTAMP,
    medicine_code VARCHAR(255) NOT NULL REFERENCES medication_name(medicine_code),
    pharmacy_id VARCHAR(14) NOT NULL REFERENCES pharmacy(cnpj),
    CONSTRAINT uq_pharmacy_medicine UNIQUE (pharmacy_id, medicine_code)
    );

-- FILE INGESTION CONTROL
CREATE TABLE IF NOT EXISTS file_ingestion_control (
                                                      id BIGSERIAL PRIMARY KEY,
                                                      blob_path TEXT NOT NULL,
                                                      etag VARCHAR(255) NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    reference_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    received_at TIMESTAMP NOT NULL DEFAULT NOW(),
    processed_at TIMESTAMP NULL,
    error_reason TEXT NULL,
    CONSTRAINT uq_blob_etag UNIQUE (blob_path, etag)
    );

-- FEEDBACK TABLE
CREATE TABLE feedback (
                          id varchar(255) PRIMARY KEY,
                          consultation TEXT,
                          is_evaluated BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('17304162000116', '2013-12-30 00:00:00.000', 'SIQUEIRA BUENO', 'SAO PAULO', 'DROGA DARCIGOTO LTDA - EPP', 'BELENZINHO', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('61412110011270', '2006-07-13 00:00:00.000', 'JULIO DE CASTILHO', 'SAO PAULO', 'DROGARIA SAO PAULO S.A.', 'BELENZINHO', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('61585865104445', '2014-02-20 00:00:00.000', 'RUA JULIO DE CASTILHO, Nº 936, 950', 'SAO PAULO', 'RAIA DROGASIL S/A', 'BELENZINHO', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('2980800000222', '2013-04-04 00:00:00.000', 'AVENIDA CELSO GARCIA 406', 'SAO PAULO', 'DROGA DARCIE LTDA. - EPP', 'BRAS', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('15210034000188', '2014-04-11 00:00:00.000', 'AV. CELSO GARCIA, Nº 1907 - LOJA 08', 'SAO PAULO', 'DROGARIA FARMA LUISA LTDA - ME', 'BRAS', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('61412110041773', '2013-06-24 00:00:00.000', 'AVENIDA RANGEL PESTANA, 2078', 'SAO PAULO', 'DROGARIA SAO PAULO S.A.', 'BRAS', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('5404331000291', '2014-08-15 00:00:00.000', 'RUA BRESSER', 'SAO PAULO', 'FARMACIA DE MANIPULACAO SINETE LTDA', 'BRAS', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('7685223000936', '2011-02-28 00:00:00.000', 'RUA DO CONTORNO, 900 - LOJA 1', 'SAO PAULO', 'CARAMANTI & CARAMANTI LTDA.', 'ITAQUERA', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('71813612000141', '2015-05-21 00:00:00.000', 'RUA BARTOLOMEU FERRARI 452', 'SAO PAULO', 'DROGA LESTE LTDA - ME', 'ITAQUERA', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('60562188000193', '2010-10-07 00:00:00.000', 'RUA PE VIEGAS DE MENEZES, 508', 'SAO PAULO', 'DROGARIA NIPO BRASIL DE ITAQUERA LTDA', 'ITAQUERA', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('61412110024097', '2009-09-16 00:00:00.000', 'MARIA LUIZA AMERICANO', 'SAO PAULO', 'DROGARIA SAO PAULO S.A.', 'ITAQUERA', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('61412110007915', '2006-07-13 00:00:00.000', 'RUA GREGÓRIO RAMALHO Nº 279', 'SAO PAULO', 'DROGARIA SAO PAULO S.A.', 'ITAQUERA', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('64659782000158', '2013-01-25 00:00:00.000', 'RUA SABBADO D''ANGELO 1119', 'SAO PAULO', 'DROGARIA YARALINE LTDA - EPP', 'ITAQUERA', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('6626253041850', '2013-03-28 00:00:00.000', 'RUA GREGORIO RAMALHO, Nº 114', 'SAO PAULO', 'EMPREENDIMENTOS PAGUE MENOS S/A', 'ITAQUERA', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('61585865114327', '2015-07-23 00:00:00.000', 'RUA AMERICO SALVADOR NOVELLI, 466', 'SAO PAULO', 'RAIA DROGASIL S/A', 'ITAQUERA', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('5404334000144', '2006-03-03 00:00:00.000', 'RUA BRESSER Nº 1448', 'SAO PAULO', 'DROGARIA E PERFUMARIA BRESSER LTDA', 'BRAS', 'SP');
INSERT INTO pharmacy (cnpj, accreditation_date, address, city, "name", neighborhood, state) VALUES('61585865004220', '2006-08-21 00:00:00.000', 'AV. RANGEL PESTANA Nº 1996', 'SAO PAULO', 'DROGASIL S.A.', 'BRAS', 'SP');

INSERT INTO indication_category (id, indication) VALUES(1, 'ASMA');
INSERT INTO indication_category (id, indication) VALUES(2, 'DIABETES');
INSERT INTO indication_category (id, indication) VALUES(3, 'HIPERTENSÃO');
INSERT INTO indication_category (id, indication) VALUES(4, 'ANTICONCEPÇÃO');
INSERT INTO indication_category (id, indication) VALUES(5, 'OSTEOPOROSE');
INSERT INTO indication_category (id, indication) VALUES(6, 'DISLIPIDEMIA');
INSERT INTO indication_category (id, indication) VALUES(7, 'DOENCA DE PARKINSON');
INSERT INTO indication_category (id, indication) VALUES(8, 'GLAUCOMA');
INSERT INTO indication_category (id, indication) VALUES(9, 'RINITE');
INSERT INTO indication_category (id, indication) VALUES(10, 'DIABETES MELLITUS + DOENÇA CARDIOVASCULAR');
INSERT INTO indication_category (id, indication) VALUES(11, 'DIGNIDADE MENSTRUAL');
INSERT INTO indication_category (id, indication) VALUES(12, 'INCONTINÊNCIA URINÁRIA');

INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED001','brometo de ipratrópio 0,02mg',1);
INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED002','brometo de ipratrópio 0,25mg',1);
INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED003','dipropionato de beclometasona 200mcg',1);
INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED004','dipropionato de beclometasona 250mcg',1);
INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED005','dipropionato de beclometasona 50mcg',1);
INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED006','sulfato de salbutamol 100mcg',1);
INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED007','sulfato de salbutamol 5mg',1);
INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED008','cloridrato de metformina 500mg',2);
INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED009','cloridrato de metformina 500mg - ação prolongada',2);
INSERT INTO medication_name (medicine_code,medicine_name,indication_category_id) VALUES('MED010','cloridrato de metformina 850mg',2);

INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED001', 15, 'NORMAL', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED002', 40, 'HIGH', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED003', 8, 'CRITICAL', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED004', 20, 'NORMAL', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED005', 12, 'NORMAL', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED006', 50, 'HIGH', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED007', 6, 'CRITICAL', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED008', 18, 'NORMAL', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED009', 35, 'HIGH', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED010',  22, 'NORMAL', '2026-02-10 11:42:50.612', '17304162000116');
INSERT INTO pharmacy_medicine_stock (medicine_code, quantity, stock_status, updated_at, pharmacy_id) VALUES('MED001', 6, 'CRITICAL', '2026-02-11 19:39:21.546', '2980800000222');