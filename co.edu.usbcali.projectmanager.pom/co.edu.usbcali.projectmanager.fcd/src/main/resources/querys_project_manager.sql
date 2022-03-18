select pj.project_id, pj.date_from, pj.date_until, pj.project_title,
			pj.general_objetive, pj.project_summary, pj.project_methology, pj.specific_objetive, 
			pj.justification, pj.project_research_typology_id, pj.state_id, pj.project_director, DIRECTOR.first_name ||' '|| DIRECTOR.surname as DirectorName 
			from project_user pu, userapp up, project pj,(select user_name, first_name, surname from userapp where profile_id = 1) DIRECTOR 
			where pu.user_id = up.user_id and pj.project_id = pu.project_id and up.user_name = 'alexandra.bastidas'
			and pj.project_director = DIRECTOR.user_name
			
			
			select p.project_user_id, p.project_id, p.user_id, u.user_name, u.profile_id from public.project_user p inner join userapp u ON p.user_id = u.user_id
			inner join project pr ON p.project_id = pr.project_id
			and u.profile_id = 1 and pr.project_id=1;

			SELECT us.user_id, user_name, first_name, second_name, surname, second_surname, profile_id,
    us.first_name ||' '|| us.surname as FullName
	FROM public.userapp us inner join project_user pj on pj.user_id = us.user_id
	inner join project pr on pr.project_id = pj.project_id and pr.project_id=39;

	SELECT pju.project_id,
array_to_string(array_agg(usr.first_name ||' '|| usr.surname),',') AS USERS
FROM project_user pju, userapp usr, project pj WHERE pju.project_id=pj.project_id and
usr.user_id= pju.user_id and pj.project_id=39
GROUP BY pju.project_id;

select pj.project_id, pj.date_from, pj.date_until, pj.project_title,
			pj.general_objetive, pj.project_summary, pj.project_methology, pj.specific_objetive,
			pj.justification, pj.project_research_typology_id, pj.state_id, pj.project_director, DIRECTOR.first_name ||' '|| DIRECTOR.surname as DirectorName,
			pj.create_by,USERS, CREATE_BY.first_name ||' '|| CREATE_BY.surname AS CREATE_BY_NAMES
			from project_user pu, userapp up, project pj,(select user_name, first_name, surname from userapp where profile_id = 1) DIRECTOR,
			(SELECT pju.project_id,
			array_to_string(array_agg(usr.first_name ||' '|| usr.surname),',') AS USERS
			FROM project_user pju, userapp usr, project pj WHERE pju.project_id=pj.project_id and
			usr.user_name= pju.user_name
			GROUP BY pju.project_id) USERS,
			(select usw.user_name,usw.first_name, usw.surname from userapp usw where usw.user_name='andres.lopez') CREATE_BY
			where pu.user_name = up.user_name and pj.project_id = pu.project_id and up.user_name = CREATE_BY.user_name
			and pj.project_director = DIRECTOR.user_name and USERS.project_id=pj.project_id

			@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE APPLICATION ap SET ap.CREDIT_LIMIT = ?1, ap.CREATE_DATE = ?2, ap.IS_PREAPPROVAL_APPLICATION = ?3 where ap.id_application = (select a.id_application from application a  INNER JOIN customer c"
			+ "        ON c.id_customer = a.card_owner  and c.document_number = ?4 and c.document_type_code= ?5)", nativeQuery = true)
	public void updateApplication(BigDecimal creditLimit, Date createDate,String isPreapproval, String documentNumber, String documentType)
			throws ControlApplicationException;

SELECT pd.project_id,array_to_string(array_agg(d.delivery_name),',') AS DELIVERYS
FROM project_delivery pd, delivery d, project pj WHERE pd.project_id=pj.project_id and
d.delivery_id= pd.delivery_id and pj.project_id=6 GROUP BY pd.project_id



select pr.project_request_id,pj.project_id,pj.date_from,pj.date_until, 
pj.project_title,pj.general_objetive, pj.project_summary, pj.project_methology, 
pj.specific_objetive, pj.justification, rt.typology_description,
DELIVERYS, pj.create_by from project_request pr, project pj, 
state_project_request sr,research_typology rt,
(SELECT pd.project_id,array_to_string(array_agg(d.delivery_name),',') AS DELIVERYS
FROM project_delivery pd, delivery d, project pj WHERE pd.project_id=pj.project_id 
 and d.delivery_id= pd.delivery_id GROUP BY pd.project_id) DELIVERYS
where pr.project_id=pj.project_id and  DELIVERYS.project_id=pr.project_id 
and pj.project_research_typology_id = rt.project_research_typology_id and
sr.state_project_request_id= pr.state_project_request_id and pr.project_request_id=2;


select distinct pr.project_request_id,pj.project_id,sr.state_project_request_id, 
pr.user_name, pr.details,sr.state_name_project_request,pj.project_director
from project_request pr, project pj, state_project_request sr
where (pr.state_project_request_id =1 OR pr.state_project_request_id=2 OR
pr.state_project_request_id =3) and 
pr.project_id=pj.project_id and pj.project_director='andres.bastidas' and 
sr.state_project_request_id= pr.state_project_request_id;

select distinct pr.project_request_id,pj.project_id,sr.state_project_request_id, 
pr.user_name, pr.details,sr.state_name_project_request, pj.project_director
from project_request pr, project pj, state_project_request sr
where (pr.state_project_request_id =1 OR pr.state_project_request_id=2 OR
pr.state_project_request_id =3) and 
pr.project_id=pj.project_id and pr.user_name='alexandra.bastidas' and 
sr.state_project_request_id= pr.state_project_request_id;

select distinct pj.project_id,pj.date_from,pj.date_until, 
pj.project_title,pj.general_objetive, pj.project_summary, pj.project_methology, 
pj.specific_objetive, pj.justification, rt.typology_description, pj.project_director,
pj.investigation_problem, pj.create_by, s.state_name, DELIVERYS from project pj,research_typology rt, state s,
(SELECT pd.project_id,array_to_string(array_agg(d.delivery_name),',') AS DELIVERYS
FROM project_delivery pd, delivery d, project pj WHERE pd.project_id=pj.project_id 
 and d.delivery_id= pd.delivery_id GROUP BY pd.project_id) DELIVERYS
where DELIVERYS.project_id=pj.project_id 
and pj.project_research_typology_id = rt.project_research_typology_id and
pj.state_id=s.state_id and pj.state_id=5;


SELECT c.activity_id,c.comment_description,c.comment_id,c.creation_date, act.activity_name
	FROM public.comment c, public.activity act 
	where c.activity_id=1 and act.activity_id=c.activity_id;






