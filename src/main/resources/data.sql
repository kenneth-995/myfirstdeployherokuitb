
insert into Family (id, name, local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ESTOMALÒGICS', '2021-04-02 09:24:22.998597');
insert into Family (id, name, local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ANTIÀCIDS', '2021-04-02 09:24:22.998597');
insert into Family (id, name,  local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ANTIULCEROSOS', '2021-04-02 09:24:22.998597');
insert into Family (id, name,  local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ANTIESPASMÒDICS', '2021-04-02 09:24:22.998597');

insert into Subfamily (id, name, familyid) values (NEXTVAL('hibernate_sequence'), 'PREPARATS PER A LA PROFILÀXIS DE LA CÀRIES', 1);
insert into Subfamily (id, name, familyid) values (NEXTVAL('hibernate_sequence'), 'ANTIINFECCIOSOS I ANTISÈPTICS PER TRACTAMENT ORAL LOCAL', 1);
insert into Subfamily (id, name, familyid) values (NEXTVAL('hibernate_sequence'), 'CORTICOIDS PER TRACTAMENT ORAL LOCAL', 1);
insert into Subfamily (id, name, familyid) values (NEXTVAL('hibernate_sequence'), 'ALTRES FÀRMACS', 1);

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