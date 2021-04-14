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
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Miconazol ( Daktarin oral 250 mg comp)', '1/2 comp/6h');/*farmacos de la subfamilia  con id 6*/
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Clorat potàssic ( Clorato potàssico Brum 200 mg comp; Clorato potàssico Orrovan comp)', '1c/2-3h adults 1/2 c/ 2-3 h nens');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Sulfacetamida + Tirotricina ( Denticelso Sol.)', 'Directament o 10-15 gotes dilluït per glopejos / 3-4 h');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Hipecacuana+Salicilato de metil+Sulfanilamida+Tintura de mirra+Mentol+ clorur de zinc(Buco Regis Sol.)', '5-10 gotes directament o diluit per glopejos');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Clorhexidina+Clorobutanol (Eludril Sol.)', '2-3 glopejos / 24h');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Ac. Ascòrbic+Perborat sòdic ( Lema Ern C pols)', 'Diluït 3 glopejos/24h');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Hexetidina + Bencidamina Clh ( Mentamida Sol.)', '3- 4 aplic/24h');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Resorcinol + Tetraborat sòdic+ Mel ( Milrosina Sol.)', '3- 4 aplic/24h');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Clorur de Benzalconi +Clorur de Zinc ( Odamida Sol.)', 'Màx. 4 aplic/ 24h');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Formaldehid 35% 44 mg (Frasco A)+Tirotricina 20 mg (Frasco B)', '3-4 aplic./24h');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Benzocaïna+ Tetracaïna Clh + Mentol (Dentikrisos Sol.)', 'Tocs');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Ac. Ascòrbic+Neomicina+Cortisona Acet.+Rutòsid ( Gingilone pasta )', '3-4 aplic / 24h');
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Miconazol ( Fungisdin oral 2% gel, Daktarin oral 2% gel )', '100mg / 6h Adults (50 mg nens i 25 mg lactants)'); /*#alternativo*/
insert into Drug(id, name, dose) values (NEXTVAL('hibernate_sequence'), 'Clorhexidina 2% Colutori Bucal', '12 ml / 8h'); /*#alternativo*/

insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 9, 13, 5);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 10, 13, 5);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 11, 13, 5);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 12, 13, 5);
/*#nuevos intercambios*/
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 14, 26, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 15, 13, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 16, 27, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 17, 27, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 18, 27, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 19, 27, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 20, 27, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 21, 27, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 22, 27, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 23, 27, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 24, 13, 6);
insert into exchange (id, currentdrugid, alternativedrugid, subfamilyid) values (NEXTVAL('hibernate_sequence'), 25, 13, 6);



insert into Usuario(username, password, role) values ('kenneth', '$2a$10$0aBG0gwHAgt7I3fNqLchG.fVgM.pM05aXV9tDIPX7knfof.nffy4e', 'ADMIN');
insert into Usuario(username, password, role) values ('user', '$2a$10$DcPTP/W9MyV3u113VChZYuDAy6gYaeTji04BMA19642GGfzlRXxUm', 'USER');