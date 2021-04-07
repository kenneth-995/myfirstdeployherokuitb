
insert into Family (id, name, local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ESTOMALÒGICS', '2021-04-02 09:24:22.998597');
insert into Family (id, name, local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ANTIÀCIDS', '2021-04-02 09:24:22.998597');
insert into Family (id, name,  local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ANTIULCEROSOS', '2021-04-02 09:24:22.998597');
insert into Family (id, name,  local_Date_Time) values (NEXTVAL('hibernate_sequence'), 'ANTIESPASMÒDICS', '2021-04-02 09:24:22.998597');

insert into Subfamily (id, name, familyid) values (1, 'PREPARATS PER A LA PROFILÀXIS DE LA CÀRIES', 1);
insert into Subfamily (id, name, familyid) values (2, 'ANTIINFECCIOSOS I ANTISÈPTICS PER TRACTAMENT ORAL LOCAL', 1);
insert into Subfamily (id, name, familyid) values (3, 'CORTICOIDS PER TRACTAMENT ORAL LOCAL', 1);
insert into Subfamily (id, name, familyid) values (4, 'ALTRES FÀRMACS', 1);