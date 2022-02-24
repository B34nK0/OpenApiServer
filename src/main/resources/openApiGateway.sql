-- 访问控制
create table if not exists access_controller_list
(
    id              integer primary key autoincrement, -- 主键
    resource_id     bigint  not null default 0,
    subject_id      bigint  not null default 0,
    subject_type    integer not null default 0
);


-- 资源
create table if not exists resource
(
    id              integer primary key autoincrement, -- 主键
    name            text    not null default '',
    url             text    not null default '',
    http_method     text    not null default '',
    remark          text    not null default ''
);


create table if not exists app
(
    id                  integer primary key autoincrement, -- 主键
    name                text    not null default '',
    service_private_key text    not null default '',
    service_public_key  text    not null default '',
    public_key          text    not null default '',
    remark              text    not null default ''
);
--
-- create table if not exists group
-- (
--     id              integer primary key autoincrement, -- 主键
--     name            text    not null default '',
--     remark          text    not null default ''
-- );
--
-- create table if not exists app_group
-- (
--     id              integer primary key autoincrement, -- 主键
--     app_id          bigint  not null default 0,
--     group_id        bigint  not null default 0
-- );