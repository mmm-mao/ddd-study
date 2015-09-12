CREATE TABLE IF NOT EXISTS credit_register_event (
  credit_card_number VARCHAR2(13) NOT NULL,
  user_id VARCHAR2(25) NOT NULL,
  valid_credit_card_status VARCHAR2(25) NOT NULL,
  system_receipt_date_time DATE NOT NULL,
  CONSTRAINT pk_docomo_change_order_ok PRIMARY KEY(credit_card_number)
)