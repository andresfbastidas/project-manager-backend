CREATE DATABASE projectmanagerdb2;
create sequence Activity_SEQ increment by 1 no minvalue no maxvalue start with 1;
create sequence Comment_SEQ increment by 1 no minvalue no maxvalue start with 1;
create sequence Project_SEQ increment by 1 no minvalue no maxvalue start with 1;
create sequence Profile_SEQ increment by 1 no minvalue no maxvalue start with 1;
create sequence Project_User_SEQ increment by 1 no minvalue no maxvalue start with 1;
create sequence Link_Attached_SEQ increment by 1 no minvalue no maxvalue start with 1;
create sequence ProjectDelivery_SEQ increment by 1 no minvalue no maxvalue start with 1;
create sequence ProjectRequestSEQ no minvalue no maxvalue;
create table Userapp (
  user_name      varchar(50) not null, 
  email          varchar(100), 
  first_name     varchar(50) not null, 
  second_name    varchar(50), 
  surname        varchar(50) not null, 
  second_surname varchar(50), 
  profile_id     int8 not null, 
  password       varchar(255) not null, 
  primary key (user_name));
create table Profile (
  profile_id   int8 not null, 
  profile_name varchar(100) not null, 
  primary key (profile_id));
create table Link_Attached (
  link_attached_id int8 not null, 
  link_attached    varchar(255) not null, 
  activity_id      int8 not null, 
  primary key (link_attached_id));
create table Comment (
  comment_id          int8 not null, 
  activity_id         int8 not null, 
  comment_description varchar(255) not null, 
  creation_date       date not null, 
  primary key (comment_id));
create table Project_User (
  project_user_id int8 not null, 
  project_id      int8 not null, 
  user_name      varchar(50) not null, 
  primary key (project_user_id));
create table Activity (
  activity_id       int8 not null, 
  activity_name     varchar(100) not null, 
  date_from         date not null, 
  date_until        date not null, 
  project_id        int8 not null, 
  state_activity_id int8 not null, 
  assigned_user     varchar(100) not null, 
  primary key (activity_id));
create table Project (
  project_id                   int8 not null, 
  date_from                    date not null, 
  date_until                   date not null, 
  project_title                varchar(255), 
  general_objetive             text, 
  project_summary              text, 
  project_methology            text, 
  research_problem          text,
  specific_objetive            text not null, 
  justification                text, 
  project_research_typology_id int8, 
  state_id                     int8 not null, 
  project_director              varchar(50),
  create_by                     varchar(50),
  constraint id_proyecto 
    primary key (project_id));
create table Delivery (
  delivery_id   bigserial not null, 
  delivery_name varchar(255) not null, 
  delivery_type varchar(10) not null, 
  primary key (delivery_id));
create table Project_Delivery (
  project_id          int8 not null, 
  delivery_id         int8 not null, 
  project_delivery_id int8 not null, 
  primary key (project_delivery_id));
create table Research_Typology (
  project_research_typology_id bigserial not null, 
  typology_description         varchar(50) not null, 
  primary key (project_research_typology_id));
create table State (
  state_id   bigserial not null, 
  state_name varchar(50) not null, 
  primary key (state_id));
create table State_Activity (
  state_activity_id   bigserial not null, 
  name_state_activity varchar(50) not null, 
  primary key (state_activity_id));
create table Project_Request (
  project_request_id        bigserial not null, 
  project_id               int8 not null, 
  user_name                varchar(50) not null, 
  details                   text,
  state_project_request_id int8 not null, 
  primary key (project_request_id));
create table State_Project_Request (
  state_project_request_id   bigserial not null, 
  state_name_project_request varchar(50) not null, 
  primary key (state_project_request_id));
alter table Project_User add constraint FKProject_Us617757 foreign key (project_id) references Project (project_id);
alter table Project_User add constraint FKProject_Us761835 foreign key (user_name) references UserApp (user_name);
alter table UserApp add constraint FKUserApp447612 foreign key (profile_id) references Profile (profile_id);
alter table Comment add constraint FKComment829094 foreign key (activity_id) references Activity (activity_id);
alter table Link_Attached add constraint FKLink_Attac718125 foreign key (activity_id) references Activity (activity_id);
alter table Activity add constraint FKActivity46817 foreign key (project_id) references Project (project_id);
alter table Project_Delivery add constraint FKProject_De969291 foreign key (project_id) references Project (project_id);
alter table Project_Delivery add constraint FKProject_De35226 foreign key (delivery_id) references Delivery (delivery_id);
alter table Project add constraint FKProject342473 foreign key ("project_research_typology_id") references Research_Typology (project_research_typology_id);
alter table Project add constraint FKProject25763 foreign key (state_id) references State (state_id);
alter table Activity add constraint FKActivity645069 foreign key (state_activity_id) references State_Activity (state_activity_id);
alter table Project_Request add constraint FKProject_Re48220 foreign key (project_id) references Project (project_id);
alter table Project_Request add constraint FKProject_Re904141 foreign key (user_name) references UserApp (user_name);
alter table Project_Request add constraint FKProject_Re638018 foreign key (state_project_request_id) references State_Project_Request (state_project_request_id);
alter table if exists Project_User drop constraint FKProject_Us617757;
alter table if exists Project_User drop constraint FKProject_Us761835;
alter table if exists UserApp drop constraint FKUserApp447612;
alter table if exists Comment drop constraint FKComment829094;
alter table if exists Link_Attached drop constraint FKLink_Attac718125;
alter table if exists Activity drop constraint FKActivity46817;
alter table if exists Project_Delivery drop constraint FKProject_De969291;
alter table if exists Project_Delivery drop constraint FKProject_De35226;
alter table if exists Project drop constraint FKProject342473;
alter table if exists Project drop constraint FKProject25763;
alter table if exists Activity drop constraint FKActivity645069;
alter table if exists Project_Request drop constraint FKProject_Re48220;
alter table if exists Project_Request drop constraint FKProject_Re904141;
alter table if exists Project_Request drop constraint FKProject_Re638018;

INSERT INTO public.research_typology(
	project_research_typology_id, typology_description)
	VALUES (nextval('research_typology_project_research_typology_id_seq'), 'EDUCACION');
	
	INSERT INTO public.research_typology(
	project_research_typology_id, typology_description)
	VALUES (nextval('research_typology_project_research_typology_id_seq'), 'IMPACTO SOCIAL');
	
		INSERT INTO public.research_typology(
	project_research_typology_id, typology_description)
	VALUES (nextval('research_typology_project_research_typology_id_seq'), 'INVESTIGACION Y DESARROLLO');
	
	INSERT INTO public.delivery(
	delivery_id, delivery_name, delivery_type)
	VALUES (nextval('delivery_delivery_id_seq'), 'TESIS DE DOCTORADO', 'TD');
	
	INSERT INTO public.delivery(
	delivery_id, delivery_name, delivery_type)
	VALUES (nextval('delivery_delivery_id_seq'), 'TESIS DE MAESTRIA', 'TM');
	
	INSERT INTO public.delivery(
	delivery_id, delivery_name, delivery_type)
	VALUES (nextval('delivery_delivery_id_seq'), 'TRABAJO DE GRADO', 'TG');

	INSERT INTO public.state(
	state_id, state_name)
	VALUES (1, 'SOLICITUD INICIAL');
	
	INSERT INTO public.state(
	state_id, state_name)
	VALUES (2, 'RECHAZADO');
	
	INSERT INTO public.state(
	state_id, state_name)
	VALUES (3, 'TERMINADO');
	
	INSERT INTO public.state(
	state_id, state_name)
	VALUES (4, 'EN PROGRESO');

	INSERT INTO public.state(
	state_id, state_name)
	VALUES (5, 'DISPONIBLE');

	INSERT INTO public.state_activity(
	state_activity_id, name_state_activity)
	VALUES (1, 'EN PROGRESO');
	
	INSERT INTO public.state_activity(
	state_activity_id, name_state_activity)
	VALUES (2, 'CREADA');
	
	INSERT INTO public.state_activity(
	state_activity_id, name_state_activity)
	VALUES (3, 'TERMINADA');

	INSERT INTO public.profile(
	profile_id, profile_name)
	VALUES (1, 'DIRECTOR');
	
	INSERT INTO public.profile(
	profile_id, profile_name)
	VALUES (2, 'ESTUDIANTE');
	
	INSERT INTO public.profile(
	profile_id, profile_name)
	VALUES (3, 'PROFESOR');

	INSERT INTO public.state_project_request(
	state_project_request_id, state_name_project_request)
	VALUES (1, 'PENDIENTE');
	
	INSERT INTO public.state_project_request(
	state_project_request_id, state_name_project_request)
	VALUES (2, 'APROBADO');
	
		INSERT INTO public.state_project_request(
	state_project_request_id, state_name_project_request)
	VALUES (3, 'RECHAZADO');