
insert into Family (id, name, local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ESTOMALÒGICS', '2021-04-02 09:24:22.998597');
insert into Family (id, name, local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ANTIÀCIDS', '2021-04-02 09:24:22.998597');
insert into Family (id, name,  local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ANTIULCEROSOS', '2021-04-02 09:24:22.998597');
insert into Family (id, name,  local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ANTIESPASMÒDICS', '2021-04-02 09:24:22.998597');

insert into Subfamily (id, name, familyid) values (1, 'PREPARATS PER A LA PROFILÀXIS DE LA CÀRIES', 1);
insert into Subfamily (id, name, familyid) values (2, 'ANTIINFECCIOSOS I ANTISÈPTICS PER TRACTAMENT ORAL LOCAL', 1);
insert into Subfamily (id, name, familyid) values (3, 'CORTICOIDS PER TRACTAMENT ORAL LOCAL', 1);
insert into Subfamily (id, name, familyid) values (4, 'ALTRES FÀRMACS', 1);

insert into Drug (id, name, dose) values (1, 'Fluoruro sòdico Fluor Kin 0,25 mg (ió Fluor) comp','Segons edat i contingut de Fluor en aigua de beguda');
insert into Drug (id, name, dose) values (2, 'Fluoruro sòdico Fluor Lacer 1mg (ió Fluor) comp)','Segons edat i contingut de Fluor en aigua de beguda');
insert into Drug (id, name, dose) values (3, 'Fluoruro sòdico Fluor Lacer 0,05 mg (ió Fluor) / gota 30 ml','Segons edat i contingut de Fluor en aigua de beguda');
insert into Drug (id, name, dose) values (4, 'Fluoruro sòdico Fluodontyl 1350 (ió Fluor 1350 mg %=13500 p.p.m) crema','1aplic /8h');