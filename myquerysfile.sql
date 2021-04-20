SELECT `dayOff_userdayoff`.`id`, `dayOff_userdayoff`.`cal_id`, `dayOff_userdayoff`.`user_id`,
       `department_member`.`id`, `department_member`.`password`, `department_member`
FROM `dayOff_userdayoff` INNER JOIN `department_member` ON (`dayOff_userdayoff`.`user_id` = `department_member`.`id`)

WHERE (`dayOff_userdayoff`.`approved` AND `dayOff_userdayoff`.`date` >= 2019-01-01 AND `dayOff_userdayoff`.`date` <= 2021-01-31 AND `dayOff_userdayoff`.`dayoff_type_id` = 3 AND `dayOff_userdayoff`.`user_id` = 1)

ORDER BY `dayOff_userdayoff`.`date` ASC, `dayOff_userdayoff`.`user_id` ASC, `dayOff_userdayoff`.`dayoff_type_id` ASC



select s."name"
from subfamily s
         INNER JOIN family f ON f.id = s.familyid
WHERE s."name" LIKE '%Preparats per a %'
;

select * from subfamily;


select e.id, e.alternativedrugid, e.currentdrugid, e.subfamilyid , s.name
from exchange e
         INNER JOIN subfamily s ON e.subfamilyid = s.id
WHERE s."name" LIKE '%Preparats per a %'
ORDER BY s.name ASC;

/*spring boot*/
select e.id, e.alternativedrugid, e.currentdrugid, e.subfamilyid
from exchange e
         INNER JOIN subfamily s ON e.subfamilyid = s.id
WHERE s."name" LIKE '%Preparats per a %'
ORDER BY s.name ASC;
