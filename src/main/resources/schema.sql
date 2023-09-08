DROP TABLE IF EXISTS bounty_url_table;
CREATE TABLE bounty_url_table(id BigInt NOT NULL,
                  original_Url VarChar(255) NOT NULL,
                  short_Url VarChar(255) NOT NULL,
                  created_Date TimeStamp NOT NULL);