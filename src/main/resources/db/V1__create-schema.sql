CREATE TABLE IF NOT EXISTS credit_register_event (
  credit_card_number VARCHAR2(13) NOT NULL,
  user_id VARCHAR2(8) NOT NULL,
  system_receipt_date_time DATE NOT NULL,
  CONSTRAINT pk_credit_register_event PRIMARY KEY(credit_card_number)
);

CREATE TABLE IF NOT EXISTS credit_valid_event (
  credit_valid_event_id VARCHAR2(13) auto_increment NOT NULL,
  credit_card_number VARCHAR2(13) NOT NULL,
  valid_credit_card_status VARCHAR2(4) NOT NULL,
  system_receipt_date_time DATE NOT NULL,
  CONSTRAINT pk_credit_valid_event PRIMARY KEY(credit_valid_event_id)
);

