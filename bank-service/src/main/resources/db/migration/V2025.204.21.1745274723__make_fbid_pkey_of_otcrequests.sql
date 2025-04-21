-- Make OtcRequests PKEY a ForeignBankId
alter table otc_requests drop constraint otc_requests_pkey;
alter table otc_requests rename column id_user_id to id_id;
alter table otc_requests
            add column id_routing_number bigint not null default (444);
alter table otc_requests add primary key (id_id, id_routing_number);
