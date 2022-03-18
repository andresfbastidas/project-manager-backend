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