create table admins
(
    a_id       int          not null
        primary key,
    a_name     varchar(255) not null,
    a_password varchar(255) not null
);

create table album_categories
(
    category_id           int          not null
        primary key,
    category_path         varchar(255) not null,
    category_name         varchar(255) not null,
    category_created_date date         not null
);

create table users
(
    user_id       int auto_increment
        primary key,
    user_name     varchar(255)         not null,
    user_password varchar(255)         not null,
    register_date date                 not null,
    admin_id      int        default 1 not null,
    disabled      tinyint(1) default 0 not null,
    constraint users_ibfk_1
        foreign key (admin_id) references admins (a_id)
);

create table albums
(
    album_id          int          not null
        primary key,
    user_id           int          not null,
    admin_id          int          not null,
    category_id       int          not null,
    album_name        varchar(255) not null,
    album_description text         null,
    cover_id          int          null,
    constraint albums_ibfk_1
        foreign key (user_id) references users (user_id),
    constraint albums_ibfk_2
        foreign key (admin_id) references admins (a_id),
    constraint albums_ibfk_3
        foreign key (category_id) references album_categories (category_id)
);

create index admin_id
    on albums (admin_id);

create index category_id
    on albums (category_id);

create table photos
(
    photo_id          int auto_increment
        primary key,
    album_id          int                  not null,
    photo_name        varchar(255)         not null,
    photo_description text                 null,
    photo_url         varchar(255)         not null,
    is_cover          tinyint(1) default 0 not null,
    user_id           int                  not null,
    admin_id          int                  not null,
    constraint photos_ibfk_1
        foreign key (album_id) references albums (album_id),
    constraint photos_ibfk_2
        foreign key (user_id) references users (user_id),
    constraint photos_ibfk_3
        foreign key (admin_id) references admins (a_id)
);

alter table albums
    add constraint albums_ibfk_4
        foreign key (cover_id) references photos (photo_id);

create table comments
(
    comment_id int  not null
        primary key,
    content    text null,
    photo_id   int  null,
    constraint comments_ibfk_1
        foreign key (photo_id) references photos (photo_id)
);

create index photo_id
    on comments (photo_id);

create index admin_id
    on photos (admin_id);

create index album_id
    on photos (album_id);

create index admin_id
    on users (admin_id);


