/*
-- ※※※※※ 消さないでください ※※※※※※
-- テーブルの作成と、インデックスの作成を行います。
-- ここには、CREATE TABLE文を記述してください。
-- 通常、BOのORACLEで行っているTABLESPACEの指定に関しては、別ディレクトリで
-- ALTER文で記述してください。
-- 理由は、TABLESPACEの指定は、H2には無いためです。ローカルPCの環境でもBOの環境でも
-- 同一のCREATE文を実行したいがために分割しています。

-- なお、テストメソッド実行後にDROP TABLEを行っています。DROP TABLEは、このファイルの
-- ファイル名のテーブルに対して行います。例えば、SAMPLE_USER.sqlだとSAMPLE_USERテーブルがTRUNCATEされます。
-- ファイル名を間違えないようにお気をつけ下さい。

-- ※※※※※ 注意まとめ！！！！ ※※※※※※
-- ・ファイル名のテーブルに対してDROP TABLEが行われます
-- ・Oracle向けのTABLESPACEの指定は、別ディレクトリでALTER文を作成してください。
*/

CREATE TABLE sample_user
(
    sample_user_id NUMBER(10) ,
    sample_user_name VARCHAR2(255) NOT NULL,
    sample_gender VARCHAR2(28) NOT NULL,
    CONSTRAINT pk_sample_user PRIMARY KEY( sample_user_id )
)