/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/12/9 星期六 15:34:41                       */
/*==============================================================*/


drop table if exists absent_repuest;

drop table if exists dept;

drop table if exists leave_repuest;

drop table if exists notice;

drop table if exists request;

drop table if exists student;

drop table if exists student_look_notice;

drop table if exists teacher;

/*==============================================================*/
/* Table: absent_repuest                                        */
/*==============================================================*/
create table absent_repuest
(
   request_id           int not null,
   starttime            date,
   endtime              date,
   course_name          varchar(20),
   primary key (request_id)
);

alter table absent_repuest comment '请假请求';

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept
(
   dept_id              int AUTO_INCREMENT not null,
   dept_name            varchar(20),
   dept_instrutor       int,
   primary key (dept_id)
);

alter table dept comment '专业，学院';

/*==============================================================*/
/* Table: leave_repuest                                         */
/*==============================================================*/
create table leave_repuest
(
   request_id           int not null,
   leaveTime            date,
   returnTime           date,
   destination          varchar(50),
   primary key (request_id)
);

alter table leave_repuest comment '离校请求';

/*==============================================================*/
/* Table: notice                                                */
/*==============================================================*/
create table notice
(
   notice_id            int AUTO_INCREMENT not null,
   teacher_id           int,
   notice_content       varchar(1024),
   primary key (notice_id)
);

alter table notice comment '公告';

/*==============================================================*/
/* Table: request                                               */
/*==============================================================*/
create table request
(
   request_id           int AUTO_INCREMENT not null,
   teacher_id           int,
   student_id           int,
   information          varchar(1024),
   is_agree             bool,
   refuse_information   varchar(1024),
   type                 int,
   primary key (request_id)
);

alter table request comment '请假请求';

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   student_id           int AUTO_INCREMENT not null,
   dept_id              int,
   student_name         varchar(20),
   student_class        varchar(5),
   student_grade        varchar(4),
   primary key (student_id)
);

alter table student comment '学生类';

/*==============================================================*/
/* Table: student_look_notice                                   */
/*==============================================================*/
create table student_look_notice
(
   notice_id            int not null,
   student_id           int not null,
   is_read              bool,
   primary key (notice_id, student_id)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   teacher_id           int AUTO_INCREMENT not null,
   dept_id              int,
   teacher_name         varchar(20),
   primary key (teacher_id)
);

alter table teacher comment '教工类';

alter table absent_repuest add constraint FK_Inheritance_1 foreign key (request_id)
      references request (request_id) on delete restrict on update restrict;

alter table leave_repuest add constraint FK_Inheritance_2 foreign key (request_id)
      references request (request_id) on delete restrict on update restrict;

alter table notice add constraint FK_Relationship_3 foreign key (teacher_id)
      references teacher (teacher_id) on delete restrict on update restrict;

alter table request add constraint FK_Relationship_10 foreign key (teacher_id)
      references teacher (teacher_id) on delete restrict on update restrict;

alter table request add constraint FK_Relationship_11 foreign key (student_id)
      references student (student_id) on delete restrict on update restrict;

alter table student add constraint FK_Relationship_1 foreign key (dept_id)
      references dept (dept_id) on delete restrict on update restrict;

alter table student_look_notice add constraint FK_Relationship_5 foreign key (notice_id)
      references notice (notice_id) on delete restrict on update restrict;

alter table student_look_notice add constraint FK_Relationship_6 foreign key (student_id)
      references student (student_id) on delete restrict on update restrict;

alter table teacher add constraint FK_Relationship_2 foreign key (dept_id)
      references dept (dept_id) on delete restrict on update restrict;

