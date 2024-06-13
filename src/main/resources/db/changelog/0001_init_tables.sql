create table if not exists users(
       id serial primary key,
       name varchar(255) not null,
       surname varchar(255) not null,
       identity_no varchar(11) not null unique,
       gender varchar(6) not null,
       urole varchar(16) not null
);

create table if not exists lectures(
    id serial primary key,
    name varchar(255) not null,
    teacher_id integer not null,
    CONSTRAINT fk_teacher_id
        FOREIGN KEY (teacher_id)
            REFERENCES users(id)
);

create table if not exists user_lectures (
    user_id serial primary key,
    lecture_id integer not null,
    CONSTRAINT fk_user_id
        FOREIGN KEY (user_id)
            REFERENCES users(id),
    CONSTRAINT fk_lecture_id
        FOREIGN KEY (lecture_id)
            REFERENCES lectures(id)
);