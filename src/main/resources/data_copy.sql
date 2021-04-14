insert into Usuario(username, password, role) values ('kenneth', '$2a$10$0aBG0gwHAgt7I3fNqLchG.fVgM.pM05aXV9tDIPX7knfof.nffy4e', 'ADMIN');
insert into Usuario(username, password, role) values ('user', '$2a$10$DcPTP/W9MyV3u113VChZYuDAy6gYaeTji04BMA19642GGfzlRXxUm', 'USER');

insert into Family (id, name, local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'Estomatològics', '2021-04-02 09:24:22.998597');
insert into Family (id, name, local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'Antiàcids', '2021-04-02 09:24:22.998597');
insert into Family (id, name,  local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'Antiulcerosos', '2021-04-02 09:24:22.998597');
insert into Family (id, name,  local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'Antiespasmòdics', '2021-04-02 09:24:22.998597');

insert into Subfamily (id, name, familyid) values (NEXTVAL('hibernate_sequence'), 'Preparats per a la profilàxis de la càries', 1);
insert into Subfamily (id, name, familyid) values (NEXTVAL('hibernate_sequence'), 'Antiinfecciosos i antisèptics per tractament oral', 1);
insert into Subfamily (id, name, familyid) values (NEXTVAL('hibernate_sequence'), 'Corticoids per tractament oral local', 1);
insert into Subfamily (id, name, familyid) values (NEXTVAL('hibernate_sequence'), 'Altres fàrmacs', 1);

insert into Drug (id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Fluoruro sòdico Fluor Kin 0,25 mg (ió Fluor) comp','Segons edat i contingut de Fluor en aigua de beguda');
insert into Drug (id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Fluoruro sòdico Fluor Lacer 1mg (ió Fluor) comp)','Segons edat i contingut de Fluor en aigua de beguda');
insert into Drug (id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Fluoruro sòdico Fluor Lacer 0,05 mg (ió Fluor) / gota 30 ml','Segons edat i contingut de Fluor en aigua de beguda');
insert into Drug (id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Fluoruro sòdico Fluodontyl 1350 (ió Fluor 1350 mg %=13500 p.p.m) crema','1aplic /8h');

insert into Drug (id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Sin fármaco','No precisa tratamiento');


insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 9, 13, 5);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 10, 13, 5);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 11, 12, 5);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 12, 13, 6);

insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 12, 13, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 12, 13, 6);