create table address
(
    id              uuid                  not null,
    add_info        character (255),
    subject         character (50) not null,
    city            character (50) not null,
    house_number    character (10) not null,
    street          character (50) not null,
    address_type    character (30) not null,
    organization_id uuid                  not null,
    primary key (id),
    foreign key (organization_id) references organization (id)
);

create table aggregator_specialist
(
    id            uuid not null,
    add_info      character (255),
    specialist_id uuid not null,
    primary key (id),
    foreign key (specialist_id) references person (id)
);

create table connection_request
(
    id              uuid                  not null,
    add_info        character (255),
    status          character (20) not null,
    date_end        date,
    date_begin      date                  not null,
    reg_number      character (20) not null,
    organization_id uuid,
    primary key (id),
    foreign key (organization_id) references organization (id)
);

create table connection_request_aggregator_specialists
(
    aggregator_specialists_id uuid not null,
    connection_request_id     uuid not null,
    primary key (aggregator_specialists_id, connection_request_id),
    foreign key (aggregator_specialists_id) references aggregator_specialist (id),
    foreign key (connection_request_id) references connection_request (id)
);

create table customer
(
    id          uuid not null,
    add_info    character (255),
    customer_id uuid not null,
    primary key (id),

    foreign key (customer_id) references person (id)
);

create table organization
(
    id                    uuid                   not null,
    add_info              character (255),
    ogrn                  character (13)  not null,
    kpp                   character (9)   not null,
    inn                   character (10)  not null,
    short_name            character (50)  not null,
    full_name             character (150) not null,
    is_connected          boolean                not null default false,
    responsible_person_id uuid                   not null,
    primary key (id),

    foreign key (responsible_person_id) references person (id)
);

create table person
(
    id           uuid                  not null,
    add_info     character (255),
    patronymic   character (50),
    email        character (50) not null,
    password     character      not null,
    name         character (50) not null,
    surname      character (50) not null,
    phone_number character (20) not null,
    primary key (id)

);

create table service
(
    id       uuid                  not null,
    add_info character (255),
    name     character (50) not null,
    code     character (3)  not null,
    primary key (id)
);

create table work
(
    id         uuid                  not null,
    add_info   character (255),
    duration   integer               not null,
    cost       numeric(19, 2)        not null,
    name       character (50) not null,
    code       character (3)  not null,
    service_id uuid                  not null,
    primary key (id),

    foreign key (service_id) references service (id)
);
