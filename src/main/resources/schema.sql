CREATE TABLE EVENT_STORE
(
  id             UUID PRIMARY KEY,
  aggregate_id   UUID  not null,
  aggregate_type varchar(255) not null,
  created_at     datetime not null,
  employee_id    varchar(255) null,
  status         varchar(255)  not null,
  event_type     varchar(255) not null,
  pay_load       longtext     null,
  version        int          not null
);

CREATE TABLE PRODUCT_CONTAINER
(
  id UUID PRIMARY KEY,
  CUSTOMER_ID int null,
  pay_load longtext null,
);



