-- 会員
CREATE TABLE IF NOT EXISTS member_sign_up_event (
  user_id VARCHAR2(8) NOT NULL,
  sign_up_date DATE NOT NULL,
  system_receipt_date_time TIMESTAMP NOT NULL,
  CONSTRAINT pk_member_sign_up_event PRIMARY KEY(user_id)
);

CREATE TABLE IF NOT EXISTS member_withdraw_event (
  user_id VARCHAR2(8) NOT NULL,
  withdrawal_date DATE NOT NULL,
  system_receipt_date_time TIMESTAMP NOT NULL,
  CONSTRAINT pk_member_withdraw_event PRIMARY KEY(user_id)
);

-- 会員プロフィール
CREATE TABLE IF NOT EXISTS member_profile_register_event (
  profile_register_event_id VARCHAR2(13) auto_increment NOT NULL,
  user_id VARCHAR2(8) NOT NULL,
  name VARCHAR2(128) NOT NULL,
  name_kana VARCHAR2(128) NOT NULL,
  gender VARCHAR2(4) NOT NULL,
  birthday DATE NOT NULL,
  zip_code VARCHAR2(8)  NOT NULL,
  address VARCHAR2(128)  NOT NULL,
  system_receipt_date_time TIMESTAMP NOT NULL,
  CONSTRAINT pk_member_profile_register_event PRIMARY KEY(profile_register_event_id)
);

CREATE TABLE IF NOT EXISTS member_mail_address_register_event (
  mail_address_register_event_id VARCHAR2(13) auto_increment NOT NULL,
  user_id VARCHAR2(8) NOT NULL,
  mail_address VARCHAR2(128) NOT NULL,
  system_receipt_date_time TIMESTAMP NOT NULL,
  CONSTRAINT pk_member_mail_address_register_event PRIMARY KEY(mail_address_register_event_id)
);


-- 認証

CREATE TABLE IF NOT EXISTS auth_event (
  auth_event_id VARCHAR2(13) auto_increment NOT NULL,
  user_id VARCHAR2(8) NOT NULL,
  user_password VARCHAR2(128) NOT NULL,
  system_receipt_date_time TIMESTAMP NOT NULL,
  CONSTRAINT pk_auth_event PRIMARY KEY(auth_event_id)
);


-- コース

CREATE TABLE IF NOT EXISTS course_receipt_event (
  course_receipt_event_id VARCHAR2(13) auto_increment NOT NULL,
  user_id VARCHAR2(8) NOT NULL,
  course VARCHAR2(50) NOT NULL,
  switching_date DATE NOT NULL,
  system_receipt_date_time TIMESTAMP NOT NULL,
  CONSTRAINT pk_course_receipt_event PRIMARY KEY(course_receipt_event_id)
);


-- クレジットカード

CREATE TABLE IF NOT EXISTS credit_register_event (
  credit_card_number VARCHAR2(13) NOT NULL,
  user_id VARCHAR2(8) NOT NULL,
  system_receipt_date_time TIMESTAMP NOT NULL,
  CONSTRAINT pk_credit_register_event PRIMARY KEY(credit_card_number)
);

CREATE TABLE IF NOT EXISTS credit_valid_event (
  credit_valid_event_id VARCHAR2(13) auto_increment NOT NULL,
  credit_card_number VARCHAR2(13) NOT NULL,
  valid_credit_card_status VARCHAR2(4) NOT NULL,
  system_receipt_date_time TIMESTAMP NOT NULL,
  CONSTRAINT pk_credit_valid_event PRIMARY KEY(credit_valid_event_id)
);


