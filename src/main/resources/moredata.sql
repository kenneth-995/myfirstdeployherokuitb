insert into Pathological_Family (id, name, local_Date_Time) values (1, 'A01-ESTOMALÒGICS', '2021-04-02 09:24:22.998597');
insert into Pathological_Family (id, name, local_Date_Time) values (2, 'A02A-ANTIÀCIDS', '2021-04-02 09:24:22.998597');
insert into Pathological_Family (id, name, local_Date_Time) values (3, 'A02BA-ANTIULCEROSOS', '2021-04-02 09:24:22.998597');
insert into Pathological_Family (id, name, local_Date_Time) values (4, 'A03A-ANTIESPASMÒDICS I ANTICOLINÈRGICS', '2021-04-02 09:24:22.998597');


insert into Pathological_Subfamily (id, name, id_pathology) values (1, 'A01AA-PREPARATS PER A LA PROFILÀXIS DE LA CÀRIES', 1);
insert into Pathological_Subfamily (id, name, id_pathology) values (2, 'A01AB-ANTIINFECCIOSOS I ANTISÈPTICS PER TRACTAMENT ORAL LOCAL', 1);
insert into Pathological_Subfamily (id, name, id_pathology) values (3, 'A01AC-CORTICOIDS PER TRACTAMENT ORAL LOCAL', 1);
insert into Pathological_Subfamily (id, name, id_pathology) values (4, 'A01AD-ALTRES FÀRMACS', 1);

insert into Pathological_Subfamily (id, name, id_pathology) values (5, 'A02AB Antiàcids derivats de l''alumini', 2);
insert into Pathological_Subfamily (id, name, id_pathology) values (6, 'A02AD Combinacions i complexes d''alumini, càlci i magnesi', 2);
insert into Pathological_Subfamily (id, name, id_pathology) values (7, 'A02AF Antiàcids amb antiflatulents', 2);
insert into Pathological_Subfamily (id, name, id_pathology) values (8, 'A02AH Antiàcids amb bicarbonat sòdic', 2);

insert into Pathological_Subfamily (id, name, id_pathology) values (9, 'ANTIHISTAMÍNICS H2";', 3);
insert into Pathological_Subfamily (id, name, id_pathology) values (10, 'INHIBIDORS DE LA BOMBA DE PROTONS', 3);
insert into Pathological_Subfamily (id, name, id_pathology) values (11, 'ALTRES FÀRMACS PER A L''ÚLCERA PÈPTICA I EL REFLUX', 3);
insert into Pathological_Subfamily (id, name, id_pathology) values (12, 'A02BA ANTIULCEROSOS', 3);

insert into Pathological_Subfamily (id, name, id_pathology) values (13, 'A03AA-ANTICOLINÈRGICS SINTÈTICS , DERIVATS AMB AMINA TERCIARIA', 4);
insert into Pathological_Subfamily (id, name, id_pathology) values (14, 'A03AB-ANTICOLINÈRGICS SINTÈTICS , DERIVATS DAMONI QUATERNARI', 4);
insert into Pathological_Subfamily (id, name, id_pathology) values (15, 'A03BA - ALCALOIDES DE LA BELLADONA, DERIVATS DAMINA TERCIARIA', 4);
insert into Pathological_Subfamily (id, name, id_pathology) values (16, 'A03CB - ASSOCIACIONS DE BELLADONA I DERIVATS AMB PSICOLÈPTICS', 4);
insert into Pathological_Subfamily (id, name, id_pathology) values (17, 'A03DB-Combinacions de belladona i derivats analgèsics', 4);
insert into Pathological_Subfamily (id, name, id_pathology) values (18, 'A03ED-Associacions d''antiespasmòdics amb altres fàrmacs', 4);
insert into Pathological_Subfamily (id, name, id_pathology) values (19, 'A03ED-Procinètics', 4);


insert into Drug (id, name, desc1, desc2, dose) values (1, 'Fluoruro sòdico','Fluor Kin 0,25 mg (ió Fluor) comp','desc2','Segons edat i contingut de Fluor en aigua de beguda');
insert into Drug (id, name, desc1, desc2, dose) values (2, 'Fluoruro sòdico','Fluor Lacer 1mg (ió Fluor) comp)','Segons edat i contingut de Fluor en aigua de beguda','dose');
insert into Drug (id, name, desc1, desc2, dose) values (3, 'Fluoruro sòdico','Fluor Lacer 0,05 mg (ió Fluor) / gota 30 ml','desc2','Segons edat i contingut de Fluor en aigua de beguda');
insert into Drug (id, name, desc1, desc2, dose) values (4, 'Fluoruro sòdico','Fluodontyl 1350 (ió Fluor 1350 mg %=13500 p.p.m) crema','desc2','1aplic /8h');

insert into Drug (id, name, desc1, desc2, dose) values (5, 'No fármaco','SUSPENDRE TRACTAMENT DURANT L''INGRÈS.','Es consideren sense utilitat terapèutica en pacients ingressats','dose');



insert into intercambio (id, currentdrug_id, alternativedrug_id, subfamily_id) values (1, 1, 5, 1);
insert into intercambio (id, currentdrug_id, alternativedrug_id, subfamily_id) values (2, 2, 5, 1);
insert into intercambio (id, currentdrug_id, alternativedrug_id, subfamily_id) values (3, 3, 5, 1);
insert into intercambio (id, currentdrug_id, alternativedrug_id, subfamily_id) values (4, 4, 5, 1);

insert into incluido_guia (id, drug_id, subfamily_id) values (1, 2, 5);
insert into incluido_guia (id, drug_id, subfamily_id) values (2, 3, 5);
insert into incluido_guia (id, drug_id, subfamily_id) values (3, 4, 5);

insert into incluido_guia (id, drug_id, subfamily_id) values (4, 2, 3);
insert into incluido_guia (id, drug_id, subfamily_id) values (5, 3, 4);
insert into incluido_guia (id, drug_id, subfamily_id) values (6, 4, 2);
