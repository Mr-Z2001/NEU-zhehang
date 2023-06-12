ping;
select 0
flushdb
HSET user:1 username admin
HSET user:1 password admin
HSET user:1 start_time '2023-06-01 00:00:00'
HSET user:1 stop_time '2023-12-01 00:00:00'
HSET user:1 status 1
HSET user:1 created_by admin
HSET user:1 creation_date '2023-06-01 00:00:00'
HSET user:1 last_updated_by admin
HSET user:1 last_update_date '2023-06-01 00:00:00'

SADD users user:1

-- you can use following commands to check if insertions were successful
-- HGETALL user:1
-- SMEMBERS users