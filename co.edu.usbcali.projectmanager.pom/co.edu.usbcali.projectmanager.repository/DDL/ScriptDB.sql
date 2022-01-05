--<ScriptOptions statementTerminator=";"/>

ALTER TABLE ProjectDelivery DROP CONSTRAINT fkproject_de969291;

ALTER TABLE Comment DROP CONSTRAINT fkcomment829094;

ALTER TABLE UserApp DROP CONSTRAINT fkuser399673;

ALTER TABLE LinkAttached DROP CONSTRAINT fklinkattach227390;

ALTER TABLE Activity DROP CONSTRAINT fkactivity46817;

ALTER TABLE ProjectUser DROP CONSTRAINT fkprojectuse427809;

ALTER TABLE Project DROP CONSTRAINT fkproject25763;

ALTER TABLE ProjectDelivery DROP CONSTRAINT fkproject_de35226;

ALTER TABLE ProjectUser DROP CONSTRAINT fkprojectuse552417;

ALTER TABLE pg_publication DROP CONSTRAINT pg_publication_oid_index;

ALTER TABLE pg_init_privs DROP CONSTRAINT pg_init_privs_o_c_o_index;

ALTER TABLE pg_publication_rel DROP CONSTRAINT pg_publication_rel_oid_index;

ALTER TABLE pg_collation DROP CONSTRAINT pg_collation_oid_index;

ALTER TABLE pg_subscription_rel DROP CONSTRAINT pg_subscription_rel_srrelid_srsubid_index;

ALTER TABLE pg_constraint DROP CONSTRAINT pg_constraint_oid_index;

ALTER TABLE pg_ts_template DROP CONSTRAINT pg_ts_template_oid_index;

ALTER TABLE pg_language DROP CONSTRAINT pg_language_oid_index;

ALTER TABLE pg_event_trigger DROP CONSTRAINT pg_event_trigger_oid_index;

ALTER TABLE pg_range DROP CONSTRAINT pg_range_rngtypid_index;

ALTER TABLE Comment DROP CONSTRAINT comment_pkey;

ALTER TABLE pg_namespace DROP CONSTRAINT pg_namespace_oid_index;

ALTER TABLE pg_partitioned_table DROP CONSTRAINT pg_partitioned_table_partrelid_index;

ALTER TABLE pg_operator DROP CONSTRAINT pg_operator_oid_index;

ALTER TABLE pg_aggregate DROP CONSTRAINT pg_aggregate_fnoid_index;

ALTER TABLE pg_shdescription DROP CONSTRAINT pg_shdescription_o_c_index;

ALTER TABLE pg_policy DROP CONSTRAINT pg_policy_oid_index;

ALTER TABLE pg_description DROP CONSTRAINT pg_description_o_c_o_index;

ALTER TABLE pg_extension DROP CONSTRAINT pg_extension_oid_index;

ALTER TABLE pg_proc DROP CONSTRAINT pg_proc_oid_index;

ALTER TABLE ProjectDelivery DROP CONSTRAINT project_delivery_pkey;

ALTER TABLE pg_user_mapping DROP CONSTRAINT pg_user_mapping_oid_index;

ALTER TABLE pg_trigger DROP CONSTRAINT pg_trigger_oid_index;

ALTER TABLE pg_replication_origin DROP CONSTRAINT pg_replication_origin_roiident_index;

ALTER TABLE pg_opclass DROP CONSTRAINT pg_opclass_oid_index;

ALTER TABLE LinkAttached DROP CONSTRAINT linkattached_pkey;

ALTER TABLE pg_statistic_ext_data DROP CONSTRAINT pg_statistic_ext_data_stxoid_index;

ALTER TABLE pg_attribute DROP CONSTRAINT pg_attribute_relid_attnum_index;

ALTER TABLE pg_foreign_data_wrapper DROP CONSTRAINT pg_foreign_data_wrapper_oid_index;

ALTER TABLE pg_tablespace DROP CONSTRAINT pg_tablespace_oid_index;

ALTER TABLE pg_statistic_ext DROP CONSTRAINT pg_statistic_ext_oid_index;

ALTER TABLE pg_transform DROP CONSTRAINT pg_transform_oid_index;

ALTER TABLE pg_subscription DROP CONSTRAINT pg_subscription_oid_index;

ALTER TABLE pg_sequence DROP CONSTRAINT pg_sequence_seqrelid_index;

ALTER TABLE pg_default_acl DROP CONSTRAINT pg_default_acl_oid_index;

ALTER TABLE pg_conversion DROP CONSTRAINT pg_conversion_oid_index;

ALTER TABLE pg_auth_members DROP CONSTRAINT pg_auth_members_role_member_index;

ALTER TABLE Delivery DROP CONSTRAINT delivery_pkey;

ALTER TABLE pg_statistic DROP CONSTRAINT pg_statistic_relid_att_inh_index;

ALTER TABLE pg_enum DROP CONSTRAINT pg_enum_oid_index;

ALTER TABLE pg_shseclabel DROP CONSTRAINT pg_shseclabel_object_index;

ALTER TABLE pg_ts_dict DROP CONSTRAINT pg_ts_dict_oid_index;

ALTER TABLE pg_amproc DROP CONSTRAINT pg_amproc_oid_index;

ALTER TABLE pg_foreign_server DROP CONSTRAINT pg_foreign_server_oid_index;

ALTER TABLE pg_cast DROP CONSTRAINT pg_cast_oid_index;

ALTER TABLE pg_ts_config DROP CONSTRAINT pg_ts_config_oid_index;

ALTER TABLE pg_amop DROP CONSTRAINT pg_amop_oid_index;

ALTER TABLE pg_ts_parser DROP CONSTRAINT pg_ts_parser_oid_index;

ALTER TABLE ResearchTypology DROP CONSTRAINT researchtypology_pkey;

ALTER TABLE pg_database DROP CONSTRAINT pg_database_oid_index;

ALTER TABLE Profile DROP CONSTRAINT profile_pkey;

ALTER TABLE Activity DROP CONSTRAINT activity_pkey;

ALTER TABLE Project DROP CONSTRAINT id_proyecto;

ALTER TABLE pg_largeobject_metadata DROP CONSTRAINT pg_largeobject_metadata_oid_index;

ALTER TABLE pg_opfamily DROP CONSTRAINT pg_opfamily_oid_index;

ALTER TABLE pg_authid DROP CONSTRAINT pg_authid_oid_index;

ALTER TABLE pg_class DROP CONSTRAINT pg_class_oid_index;

ALTER TABLE UserApp DROP CONSTRAINT User_pkey;

ALTER TABLE pg_rewrite DROP CONSTRAINT pg_rewrite_oid_index;

ALTER TABLE pg_am DROP CONSTRAINT pg_am_oid_index;

ALTER TABLE State DROP CONSTRAINT state_pkey;

ALTER TABLE pg_seclabel DROP CONSTRAINT pg_seclabel_object_index;

ALTER TABLE ProjectUser DROP CONSTRAINT projectuser_pkey;

ALTER TABLE pg_type DROP CONSTRAINT pg_type_oid_index;

ALTER TABLE pg_ts_config_map DROP CONSTRAINT pg_ts_config_map_index;

ALTER TABLE pg_attrdef DROP CONSTRAINT pg_attrdef_oid_index;

ALTER TABLE pg_inherits DROP CONSTRAINT pg_inherits_relid_seqno_index;

ALTER TABLE pg_index DROP CONSTRAINT pg_index_indexrelid_index;

ALTER TABLE pg_foreign_table DROP CONSTRAINT pg_foreign_table_relid_index;

ALTER TABLE pg_db_role_setting DROP CONSTRAINT pg_db_role_setting_databaseid_rol_index;

ALTER TABLE pg_largeobject DROP CONSTRAINT pg_largeobject_loid_pn_index;

DROP INDEX pg_ts_dict_dictname_index;

DROP INDEX pg_operator_oprname_l_r_n_index;

DROP INDEX pg_sequence_seqrelid_index;

DROP INDEX pg_index_indexrelid_index;

DROP INDEX pg_publication_pubname_index;

DROP INDEX pg_authid_oid_index;

DROP INDEX pg_trigger_tgrelid_tgname_index;

DROP INDEX pg_constraint_conrelid_contypid_conname_index;

DROP INDEX pg_publication_rel_oid_index;

DROP INDEX pg_am_name_index;

DROP INDEX pg_opclass_am_name_nsp_index;

DROP INDEX pg_shdepend_depender_index;

DROP INDEX pg_user_mapping_oid_index;

DROP INDEX pg_attribute_relid_attnam_index;

DROP INDEX pg_inherits_parent_index;

DROP INDEX pg_amop_opr_fam_index;

DROP INDEX pg_statistic_ext_relid_index;

DROP INDEX pg_subscription_subname_index;

DROP INDEX pg_language_name_index;

DROP INDEX pg_partitioned_table_partrelid_index;

DROP INDEX pg_language_oid_index;

DROP INDEX pg_description_o_c_o_index;

DROP INDEX pg_inherits_relid_seqno_index;

DROP INDEX pg_publication_oid_index;

DROP INDEX pg_tablespace_spcname_index;

DROP INDEX pg_namespace_nspname_index;

DROP INDEX pg_shseclabel_object_index;

DROP INDEX pg_enum_typid_label_index;

DROP INDEX pg_tablespace_oid_index;

DROP INDEX linkattached_pkey;

DROP INDEX pg_collation_name_enc_nsp_index;

DROP INDEX pg_extension_name_index;

DROP INDEX pg_namespace_oid_index;

DROP INDEX pg_collation_oid_index;

DROP INDEX pg_type_typname_nsp_index;

DROP INDEX pg_class_tblspc_relfilenode_index;

DROP INDEX pg_foreign_data_wrapper_oid_index;

DROP INDEX pg_event_trigger_oid_index;

DROP INDEX pg_range_rngtypid_index;

DROP INDEX pg_index_indrelid_index;

DROP INDEX pg_am_oid_index;

DROP INDEX pg_foreign_data_wrapper_name_index;

DROP INDEX state_pkey;

DROP INDEX researchtypology_pkey;

DROP INDEX pg_ts_dict_oid_index;

DROP INDEX pg_constraint_conparentid_index;

DROP INDEX pg_statistic_ext_data_stxoid_index;

DROP INDEX pg_seclabel_object_index;

DROP INDEX pg_ts_template_tmplname_index;

DROP INDEX pg_trigger_tgconstraint_index;

DROP INDEX comment_pkey;

DROP INDEX pg_largeobject_loid_pn_index;

DROP INDEX pg_shdescription_o_c_index;

DROP INDEX pg_depend_reference_index;

DROP INDEX pg_aggregate_fnoid_index;

DROP INDEX User_pkey;

DROP INDEX pg_user_mapping_user_server_index;

DROP INDEX pg_constraint_conname_nsp_index;

DROP INDEX pg_subscription_rel_srrelid_srsubid_index;

DROP INDEX pg_depend_depender_index;

DROP INDEX pg_opclass_oid_index;

DROP INDEX pg_policy_polrelid_polname_index;

DROP INDEX pg_foreign_server_oid_index;

DROP INDEX pg_amop_fam_strat_index;

DROP INDEX pg_transform_type_lang_index;

DROP INDEX pg_cast_oid_index;

DROP INDEX pg_attrdef_oid_index;

DROP INDEX pg_cast_source_target_index;

DROP INDEX pg_statistic_ext_oid_index;

DROP INDEX pg_default_acl_oid_index;

DROP INDEX pg_constraint_contypid_index;

DROP INDEX pg_extension_oid_index;

DROP INDEX pg_foreign_table_relid_index;

DROP INDEX pg_opfamily_oid_index;

DROP INDEX id_proyecto;

DROP INDEX pg_proc_proname_args_nsp_index;

DROP INDEX delivery_pkey;

DROP INDEX pg_ts_parser_prsname_index;

DROP INDEX pg_init_privs_o_c_o_index;

DROP INDEX pg_rewrite_oid_index;

DROP INDEX pg_auth_members_role_member_index;

DROP INDEX pg_amproc_oid_index;

DROP INDEX pg_attribute_relid_attnum_index;

DROP INDEX pg_statistic_relid_att_inh_index;

DROP INDEX pg_event_trigger_evtname_index;

DROP INDEX pg_replication_origin_roiident_index;

DROP INDEX pg_class_relname_nsp_index;

DROP INDEX pg_db_role_setting_databaseid_rol_index;

DROP INDEX pg_type_oid_index;

DROP INDEX pg_largeobject_metadata_oid_index;

DROP INDEX pg_default_acl_role_nsp_obj_index;

DROP INDEX pg_conversion_default_index;

DROP INDEX pg_conversion_name_nsp_index;

DROP INDEX profile_pkey;

DROP INDEX pg_class_oid_index;

DROP INDEX pg_statistic_ext_name_index;

DROP INDEX pg_database_datname_index;

DROP INDEX pg_publication_rel_prrelid_prpubid_index;

DROP INDEX pg_enum_typid_sortorder_index;

DROP INDEX pg_opfamily_am_name_nsp_index;

DROP INDEX pg_auth_members_member_role_index;

DROP INDEX pg_ts_config_oid_index;

DROP INDEX pg_transform_oid_index;

DROP INDEX pg_ts_config_map_index;

DROP INDEX pg_range_rngmultitypid_index;

DROP INDEX pg_rewrite_rel_rulename_index;

DROP INDEX pg_replication_origin_roname_index;

DROP INDEX pg_policy_oid_index;

DROP INDEX pg_foreign_server_name_index;

DROP INDEX pg_operator_oid_index;

DROP INDEX project_delivery_pkey;

DROP INDEX pg_authid_rolname_index;

DROP INDEX pg_proc_oid_index;

DROP INDEX pg_trigger_oid_index;

DROP INDEX pg_ts_template_oid_index;

DROP INDEX pg_amop_oid_index;

DROP INDEX pg_subscription_oid_index;

DROP INDEX pg_conversion_oid_index;

DROP INDEX pg_shdepend_reference_index;

DROP INDEX projectuser_pkey;

DROP INDEX pg_ts_parser_oid_index;

DROP INDEX pg_attrdef_adrelid_adnum_index;

DROP INDEX pg_database_oid_index;

DROP INDEX activity_pkey;

DROP INDEX pg_amproc_fam_proc_index;

DROP INDEX pg_ts_config_cfgname_index;

DROP INDEX pg_constraint_oid_index;

DROP INDEX pg_enum_oid_index;

DROP TABLE pg_depend;

DROP TABLE pg_event_trigger;

DROP TABLE pg_am;

DROP TABLE sql_parts;

DROP TABLE LinkAttached;

DROP TABLE Activity;

DROP TABLE pg_seclabel;

DROP TABLE pg_ts_parser;

DROP TABLE pg_statistic;

DROP TABLE pg_amproc;

DROP TABLE pg_sequence;

DROP TABLE pg_ts_dict;

DROP TABLE pg_conversion;

DROP TABLE pg_publication;

DROP TABLE pg_constraint;

DROP TABLE pg_auth_members;

DROP TABLE pg_db_role_setting;

DROP TABLE ProjectDelivery;

DROP TABLE pg_foreign_table;

DROP TABLE pg_ts_config_map;

DROP TABLE pg_foreign_server;

DROP TABLE pg_database;

DROP TABLE pg_shdepend;

DROP TABLE pg_language;

DROP TABLE pg_transform;

DROP TABLE pg_cast;

DROP TABLE UserApp;

DROP TABLE pg_subscription;

DROP TABLE pg_proc;

DROP TABLE pg_largeobject;

DROP TABLE State;

DROP TABLE pg_shseclabel;

DROP TABLE pg_trigger;

DROP TABLE pg_collation;

DROP TABLE pg_replication_origin;

DROP TABLE pg_attrdef;

DROP TABLE pg_attribute;

DROP TABLE sql_features;

DROP TABLE Comment;

DROP TABLE pg_foreign_data_wrapper;

DROP TABLE pg_opfamily;

DROP TABLE pg_ts_template;

DROP TABLE pg_namespace;

DROP TABLE pg_largeobject_metadata;

DROP TABLE pg_shdescription;

DROP TABLE ProjectUser;

DROP TABLE Profile;

DROP TABLE pg_partitioned_table;

DROP TABLE pg_type;

DROP TABLE pg_authid;

DROP TABLE pg_statistic_ext;

DROP TABLE Delivery;

DROP TABLE pg_statistic_ext_data;

DROP TABLE pg_aggregate;

DROP TABLE Project;

DROP TABLE pg_index;

DROP TABLE ResearchTypology;

DROP TABLE pg_class;

DROP TABLE pg_range;

DROP TABLE pg_amop;

DROP TABLE pg_default_acl;

DROP TABLE pg_subscription_rel;

DROP TABLE pg_rewrite;

DROP TABLE pg_operator;

DROP TABLE pg_init_privs;

DROP TABLE pg_publication_rel;

DROP TABLE pg_description;

DROP TABLE pg_enum;

DROP TABLE pg_extension;

DROP TABLE pg_policy;

DROP TABLE pg_user_mapping;

DROP TABLE pg_tablespace;

DROP TABLE pg_inherits;

DROP TABLE pg_ts_config;

DROP TABLE pg_opclass;

DROP TABLE sql_sizing;

DROP TABLE sql_implementation_info;

CREATE TABLE pg_depend (
		classid OID NOT NULL,
		objid OID NOT NULL,
		objsubid INT4 NOT NULL,
		refclassid OID NOT NULL,
		refobjid OID NOT NULL,
		refobjsubid INT4 NOT NULL,
		deptype BPCHAR(1) NOT NULL
	);

CREATE TABLE pg_event_trigger (
		oid OID NOT NULL,
		evtname CIDR(2147483647) NOT NULL,
		evtevent CIDR(2147483647) NOT NULL,
		evtowner OID NOT NULL,
		evtfoid OID NOT NULL,
		evtenabled BPCHAR(1) NOT NULL,
		evttags TEXT[ ](2147483647)
	);

CREATE TABLE pg_am (
		oid OID NOT NULL,
		amname CIDR(2147483647) NOT NULL,
		amhandler REGPROC NOT NULL,
		amtype BPCHAR(1) NOT NULL
	);

CREATE TABLE sql_parts (
		feature_id null,
		feature_name null,
		is_supported null,
		is_verified_by null,
		comments null
	);

CREATE TABLE LinkAttached (
		link_attached_id INT8 NOT NULL,
		link_attached VARCHAR(255) NOT NULL,
		activity_id INT8 NOT NULL
	);

CREATE TABLE Activity (
		activity_id INT8 NOT NULL,
		activity_name VARCHAR(100) NOT NULL,
		activity_state VARCHAR(30) NOT NULL,
		date_from TIMESTAMP NOT NULL,
		date_until TIMESTAMP NOT NULL,
		project_id INT8 NOT NULL
	);

CREATE TABLE pg_seclabel (
		objoid OID NOT NULL,
		classoid OID NOT NULL,
		objsubid INT4 NOT NULL,
		provider TEXT(2147483647) NOT NULL,
		label TEXT(2147483647) NOT NULL
	);

CREATE TABLE pg_ts_parser (
		oid OID NOT NULL,
		prsname CIDR(2147483647) NOT NULL,
		prsnamespace OID NOT NULL,
		prsstart REGPROC NOT NULL,
		prstoken REGPROC NOT NULL,
		prsend REGPROC NOT NULL,
		prsheadline REGPROC NOT NULL,
		prslextype REGPROC NOT NULL
	);

CREATE TABLE pg_statistic (
		starelid OID NOT NULL,
		staattnum INT2 NOT NULL,
		stainherit BOOL NOT NULL,
		stanullfrac FLOAT4 NOT NULL,
		stawidth INT4 NOT NULL,
		stadistinct FLOAT4 NOT NULL,
		stakind1 INT2 NOT NULL,
		stakind2 INT2 NOT NULL,
		stakind3 INT2 NOT NULL,
		stakind4 INT2 NOT NULL,
		stakind5 INT2 NOT NULL,
		staop1 OID NOT NULL,
		staop2 OID NOT NULL,
		staop3 OID NOT NULL,
		staop4 OID NOT NULL,
		staop5 OID NOT NULL,
		stacoll1 OID NOT NULL,
		stacoll2 OID NOT NULL,
		stacoll3 OID NOT NULL,
		stacoll4 OID NOT NULL,
		stacoll5 OID NOT NULL,
		stanumbers1 FLOAT4[ ],
		stanumbers2 FLOAT4[ ],
		stanumbers3 FLOAT4[ ],
		stanumbers4 FLOAT4[ ],
		stanumbers5 FLOAT4[ ],
		stavalues1 null,
		stavalues2 null,
		stavalues3 null,
		stavalues4 null,
		stavalues5 null
	);

CREATE TABLE pg_amproc (
		oid OID NOT NULL,
		amprocfamily OID NOT NULL,
		amproclefttype OID NOT NULL,
		amprocrighttype OID NOT NULL,
		amprocnum INT2 NOT NULL,
		amproc REGPROC NOT NULL
	);

CREATE TABLE pg_sequence (
		seqrelid OID NOT NULL,
		seqtypid OID NOT NULL,
		seqstart INT8 NOT NULL,
		seqincrement INT8 NOT NULL,
		seqmax INT8 NOT NULL,
		seqmin INT8 NOT NULL,
		seqcache INT8 NOT NULL,
		seqcycle BOOL NOT NULL
	);

CREATE TABLE pg_ts_dict (
		oid OID NOT NULL,
		dictname CIDR(2147483647) NOT NULL,
		dictnamespace OID NOT NULL,
		dictowner OID NOT NULL,
		dicttemplate OID NOT NULL,
		dictinitoption TEXT(2147483647)
	);

CREATE TABLE pg_conversion (
		oid OID NOT NULL,
		conname CIDR(2147483647) NOT NULL,
		connamespace OID NOT NULL,
		conowner OID NOT NULL,
		conforencoding INT4 NOT NULL,
		contoencoding INT4 NOT NULL,
		conproc REGPROC NOT NULL,
		condefault BOOL NOT NULL
	);

CREATE TABLE pg_publication (
		oid OID NOT NULL,
		pubname CIDR(2147483647) NOT NULL,
		pubowner OID NOT NULL,
		puballtables BOOL NOT NULL,
		pubinsert BOOL NOT NULL,
		pubupdate BOOL NOT NULL,
		pubdelete BOOL NOT NULL,
		pubtruncate BOOL NOT NULL,
		pubviaroot BOOL NOT NULL
	);

CREATE TABLE pg_constraint (
		oid OID NOT NULL,
		conname CIDR(2147483647) NOT NULL,
		connamespace OID NOT NULL,
		contype BPCHAR(1) NOT NULL,
		condeferrable BOOL NOT NULL,
		condeferred BOOL NOT NULL,
		convalidated BOOL NOT NULL,
		conrelid OID NOT NULL,
		contypid OID NOT NULL,
		conindid OID NOT NULL,
		conparentid OID NOT NULL,
		confrelid OID NOT NULL,
		confupdtype BPCHAR(1) NOT NULL,
		confdeltype BPCHAR(1) NOT NULL,
		confmatchtype BPCHAR(1) NOT NULL,
		conislocal BOOL NOT NULL,
		coninhcount INT4 NOT NULL,
		connoinherit BOOL NOT NULL,
		conkey INT2[ ],
		confkey INT2[ ],
		conpfeqop OID[ ],
		conppeqop OID[ ],
		conffeqop OID[ ],
		conexclop OID[ ],
		conbin null
	);

CREATE TABLE pg_auth_members (
		roleid OID NOT NULL,
		member OID NOT NULL,
		grantor OID NOT NULL,
		admin_option BOOL NOT NULL
	);

CREATE TABLE pg_db_role_setting (
		setdatabase OID NOT NULL,
		setrole OID NOT NULL,
		setconfig TEXT[ ](2147483647)
	);

CREATE TABLE ProjectDelivery (
		project_id INT8 NOT NULL,
		delivery_id INT8 NOT NULL,
		project_delivery_id INT8 NOT NULL
	);

CREATE TABLE pg_foreign_table (
		ftrelid OID NOT NULL,
		ftserver OID NOT NULL,
		ftoptions TEXT[ ](2147483647)
	);

CREATE TABLE pg_ts_config_map (
		mapcfg OID NOT NULL,
		maptokentype INT4 NOT NULL,
		mapseqno INT4 NOT NULL,
		mapdict OID NOT NULL
	);

CREATE TABLE pg_foreign_server (
		oid OID NOT NULL,
		srvname CIDR(2147483647) NOT NULL,
		srvowner OID NOT NULL,
		srvfdw OID NOT NULL,
		srvtype TEXT(2147483647),
		srvversion TEXT(2147483647),
		srvacl ACLITEM[ ],
		srvoptions TEXT[ ](2147483647)
	);

CREATE TABLE pg_database (
		oid OID NOT NULL,
		datname CIDR(2147483647) NOT NULL,
		datdba OID NOT NULL,
		encoding INT4 NOT NULL,
		datcollate CIDR(2147483647) NOT NULL,
		datctype CIDR(2147483647) NOT NULL,
		datistemplate BOOL NOT NULL,
		datallowconn BOOL NOT NULL,
		datconnlimit INT4 NOT NULL,
		datlastsysoid OID NOT NULL,
		datfrozenxid XID NOT NULL,
		datminmxid XID NOT NULL,
		dattablespace OID NOT NULL,
		datacl ACLITEM[ ]
	);

CREATE TABLE pg_shdepend (
		dbid OID NOT NULL,
		classid OID NOT NULL,
		objid OID NOT NULL,
		objsubid INT4 NOT NULL,
		refclassid OID NOT NULL,
		refobjid OID NOT NULL,
		deptype BPCHAR(1) NOT NULL
	);

CREATE TABLE pg_language (
		oid OID NOT NULL,
		lanname CIDR(2147483647) NOT NULL,
		lanowner OID NOT NULL,
		lanispl BOOL NOT NULL,
		lanpltrusted BOOL NOT NULL,
		lanplcallfoid OID NOT NULL,
		laninline OID NOT NULL,
		lanvalidator OID NOT NULL,
		lanacl ACLITEM[ ]
	);

CREATE TABLE pg_transform (
		oid OID NOT NULL,
		trftype OID NOT NULL,
		trflang OID NOT NULL,
		trffromsql REGPROC NOT NULL,
		trftosql REGPROC NOT NULL
	);

CREATE TABLE pg_cast (
		oid OID NOT NULL,
		castsource OID NOT NULL,
		casttarget OID NOT NULL,
		castfunc OID NOT NULL,
		castcontext BPCHAR(1) NOT NULL,
		castmethod BPCHAR(1) NOT NULL
	);

CREATE TABLE UserApp (
		user_id INT8 NOT NULL,
		user_name VARCHAR(100) NOT NULL,
		user_state VARCHAR(100) NOT NULL,
		email VARCHAR(100),
		firts_name VARCHAR(50) NOT NULL,
		second_name VARCHAR(50),
		surname VARCHAR(50) NOT NULL,
		second_surname VARCHAR(50),
		profile_id INT8 NOT NULL,
		password VARCHAR(255) NOT NULL
	);

CREATE TABLE pg_subscription (
		oid OID NOT NULL,
		subdbid OID NOT NULL,
		subname CIDR(2147483647) NOT NULL,
		subowner OID NOT NULL,
		subenabled BOOL NOT NULL,
		subbinary BOOL NOT NULL,
		substream BOOL NOT NULL,
		subconninfo TEXT(2147483647) NOT NULL,
		subslotname CIDR(2147483647),
		subsynccommit TEXT(2147483647) NOT NULL,
		subpublications TEXT[ ](2147483647) NOT NULL
	);

CREATE TABLE pg_proc (
		oid OID NOT NULL,
		proname CIDR(2147483647) NOT NULL,
		pronamespace OID NOT NULL,
		proowner OID NOT NULL,
		prolang OID NOT NULL,
		procost FLOAT4 NOT NULL,
		prorows FLOAT4 NOT NULL,
		provariadic OID NOT NULL,
		prosupport REGPROC NOT NULL,
		prokind BPCHAR(1) NOT NULL,
		prosecdef BOOL NOT NULL,
		proleakproof BOOL NOT NULL,
		proisstrict BOOL NOT NULL,
		proretset BOOL NOT NULL,
		provolatile BPCHAR(1) NOT NULL,
		proparallel BPCHAR(1) NOT NULL,
		pronargs INT2 NOT NULL,
		pronargdefaults INT2 NOT NULL,
		prorettype OID NOT NULL,
		proargtypes null NOT NULL,
		proallargtypes OID[ ],
		proargmodes ABSTIME[ ],
		proargnames TEXT[ ](2147483647),
		proargdefaults null,
		protrftypes OID[ ],
		prosrc TEXT(2147483647) NOT NULL,
		probin TEXT(2147483647),
		prosqlbody null,
		proconfig TEXT[ ](2147483647),
		proacl ACLITEM[ ]
	);

CREATE TABLE pg_largeobject (
		loid OID NOT NULL,
		pageno INT4 NOT NULL,
		data BYTEA(2147483647) NOT NULL
	);

CREATE TABLE State (
		state_id BIGSERIAL DEFAULT nextval('state_state_id_seq'::regclass) NOT NULL,
		state_name VARCHAR(50) NOT NULL
	);

CREATE TABLE pg_shseclabel (
		objoid OID NOT NULL,
		classoid OID NOT NULL,
		provider TEXT(2147483647) NOT NULL,
		label TEXT(2147483647) NOT NULL
	);

CREATE TABLE pg_trigger (
		oid OID NOT NULL,
		tgrelid OID NOT NULL,
		tgparentid OID NOT NULL,
		tgname CIDR(2147483647) NOT NULL,
		tgfoid OID NOT NULL,
		tgtype INT2 NOT NULL,
		tgenabled BPCHAR(1) NOT NULL,
		tgisinternal BOOL NOT NULL,
		tgconstrrelid OID NOT NULL,
		tgconstrindid OID NOT NULL,
		tgconstraint OID NOT NULL,
		tgdeferrable BOOL NOT NULL,
		tginitdeferred BOOL NOT NULL,
		tgnargs INT2 NOT NULL,
		tgattr null NOT NULL,
		tgargs BYTEA(2147483647) NOT NULL,
		tgqual null,
		tgoldtable CIDR(2147483647),
		tgnewtable CIDR(2147483647)
	);

CREATE TABLE pg_collation (
		oid OID NOT NULL,
		collname CIDR(2147483647) NOT NULL,
		collnamespace OID NOT NULL,
		collowner OID NOT NULL,
		collprovider BPCHAR(1) NOT NULL,
		collisdeterministic BOOL NOT NULL,
		collencoding INT4 NOT NULL,
		collcollate CIDR(2147483647) NOT NULL,
		collctype CIDR(2147483647) NOT NULL,
		collversion TEXT(2147483647)
	);

CREATE TABLE pg_replication_origin (
		roident OID NOT NULL,
		roname TEXT(2147483647) NOT NULL
	);

CREATE TABLE pg_attrdef (
		oid OID NOT NULL,
		adrelid OID NOT NULL,
		adnum INT2 NOT NULL,
		adbin null NOT NULL
	);

CREATE TABLE pg_attribute (
		attrelid OID NOT NULL,
		attname CIDR(2147483647) NOT NULL,
		atttypid OID NOT NULL,
		attstattarget INT4 NOT NULL,
		attlen INT2 NOT NULL,
		attnum INT2 NOT NULL,
		attndims INT4 NOT NULL,
		attcacheoff INT4 NOT NULL,
		atttypmod INT4 NOT NULL,
		attbyval BOOL NOT NULL,
		attalign BPCHAR(1) NOT NULL,
		attstorage BPCHAR(1) NOT NULL,
		attcompression BPCHAR(1) NOT NULL,
		attnotnull BOOL NOT NULL,
		atthasdef BOOL NOT NULL,
		atthasmissing BOOL NOT NULL,
		attidentity BPCHAR(1) NOT NULL,
		attgenerated BPCHAR(1) NOT NULL,
		attisdropped BOOL NOT NULL,
		attislocal BOOL NOT NULL,
		attinhcount INT4 NOT NULL,
		attcollation OID NOT NULL,
		attacl ACLITEM[ ],
		attoptions TEXT[ ](2147483647),
		attfdwoptions TEXT[ ](2147483647),
		attmissingval null
	);

CREATE TABLE sql_features (
		feature_id null,
		feature_name null,
		sub_feature_id null,
		sub_feature_name null,
		is_supported null,
		is_verified_by null,
		comments null
	);

CREATE TABLE Comment (
		comment_id INT8 NOT NULL,
		activity_id INT8 NOT NULL
	);

CREATE TABLE pg_foreign_data_wrapper (
		oid OID NOT NULL,
		fdwname CIDR(2147483647) NOT NULL,
		fdwowner OID NOT NULL,
		fdwhandler OID NOT NULL,
		fdwvalidator OID NOT NULL,
		fdwacl ACLITEM[ ],
		fdwoptions TEXT[ ](2147483647)
	);

CREATE TABLE pg_opfamily (
		oid OID NOT NULL,
		opfmethod OID NOT NULL,
		opfname CIDR(2147483647) NOT NULL,
		opfnamespace OID NOT NULL,
		opfowner OID NOT NULL
	);

CREATE TABLE pg_ts_template (
		oid OID NOT NULL,
		tmplname CIDR(2147483647) NOT NULL,
		tmplnamespace OID NOT NULL,
		tmplinit REGPROC NOT NULL,
		tmpllexize REGPROC NOT NULL
	);

CREATE TABLE pg_namespace (
		oid OID NOT NULL,
		nspname CIDR(2147483647) NOT NULL,
		nspowner OID NOT NULL,
		nspacl ACLITEM[ ]
	);

CREATE TABLE pg_largeobject_metadata (
		oid OID NOT NULL,
		lomowner OID NOT NULL,
		lomacl ACLITEM[ ]
	);

CREATE TABLE pg_shdescription (
		objoid OID NOT NULL,
		classoid OID NOT NULL,
		description TEXT(2147483647) NOT NULL
	);

CREATE TABLE ProjectUser (
		project_user_id INT8 NOT NULL,
		project_id INT8 NOT NULL,
		user_id INT8 NOT NULL
	);

CREATE TABLE Profile (
		profile_id INT8 NOT NULL,
		profile_name VARCHAR(100) NOT NULL
	);

CREATE TABLE pg_partitioned_table (
		partrelid OID NOT NULL,
		partstrat BPCHAR(1) NOT NULL,
		partnatts INT2 NOT NULL,
		partdefid OID NOT NULL,
		partattrs null NOT NULL,
		partclass null NOT NULL,
		partcollation null NOT NULL,
		partexprs null
	);

CREATE TABLE pg_type (
		oid OID NOT NULL,
		typname CIDR(2147483647) NOT NULL,
		typnamespace OID NOT NULL,
		typowner OID NOT NULL,
		typlen INT2 NOT NULL,
		typbyval BOOL NOT NULL,
		typtype BPCHAR(1) NOT NULL,
		typcategory BPCHAR(1) NOT NULL,
		typispreferred BOOL NOT NULL,
		typisdefined BOOL NOT NULL,
		typdelim BPCHAR(1) NOT NULL,
		typrelid OID NOT NULL,
		typsubscript REGPROC NOT NULL,
		typelem OID NOT NULL,
		typarray OID NOT NULL,
		typinput REGPROC NOT NULL,
		typoutput REGPROC NOT NULL,
		typreceive REGPROC NOT NULL,
		typsend REGPROC NOT NULL,
		typmodin REGPROC NOT NULL,
		typmodout REGPROC NOT NULL,
		typanalyze REGPROC NOT NULL,
		typalign BPCHAR(1) NOT NULL,
		typstorage BPCHAR(1) NOT NULL,
		typnotnull BOOL NOT NULL,
		typbasetype OID NOT NULL,
		typtypmod INT4 NOT NULL,
		typndims INT4 NOT NULL,
		typcollation OID NOT NULL,
		typdefaultbin null,
		typdefault TEXT(2147483647),
		typacl ACLITEM[ ]
	);

CREATE TABLE pg_authid (
		oid OID NOT NULL,
		rolname CIDR(2147483647) NOT NULL,
		rolsuper BOOL NOT NULL,
		rolinherit BOOL NOT NULL,
		rolcreaterole BOOL NOT NULL,
		rolcreatedb BOOL NOT NULL,
		rolcanlogin BOOL NOT NULL,
		rolreplication BOOL NOT NULL,
		rolbypassrls BOOL NOT NULL,
		rolconnlimit INT4 NOT NULL,
		rolpassword TEXT(2147483647),
		rolvaliduntil TIMESTAMPTZ
	);

CREATE TABLE pg_statistic_ext (
		oid OID NOT NULL,
		stxrelid OID NOT NULL,
		stxname CIDR(2147483647) NOT NULL,
		stxnamespace OID NOT NULL,
		stxowner OID NOT NULL,
		stxstattarget INT4 NOT NULL,
		stxkeys null NOT NULL,
		stxkind ABSTIME[ ] NOT NULL,
		stxexprs null
	);

CREATE TABLE Delivery (
		delivery_id BIGSERIAL DEFAULT nextval('delivery_delivery_id_seq'::regclass) NOT NULL,
		delivery_name INT8 NOT NULL
	);

CREATE TABLE pg_statistic_ext_data (
		stxoid OID NOT NULL,
		stxdndistinct null,
		stxddependencies null,
		stxdmcv null,
		stxdexpr ABSTIME[ ]
	);

CREATE TABLE pg_aggregate (
		aggfnoid REGPROC NOT NULL,
		aggkind BPCHAR(1) NOT NULL,
		aggnumdirectargs INT2 NOT NULL,
		aggtransfn REGPROC NOT NULL,
		aggfinalfn REGPROC NOT NULL,
		aggcombinefn REGPROC NOT NULL,
		aggserialfn REGPROC NOT NULL,
		aggdeserialfn REGPROC NOT NULL,
		aggmtransfn REGPROC NOT NULL,
		aggminvtransfn REGPROC NOT NULL,
		aggmfinalfn REGPROC NOT NULL,
		aggfinalextra BOOL NOT NULL,
		aggmfinalextra BOOL NOT NULL,
		aggfinalmodify BPCHAR(1) NOT NULL,
		aggmfinalmodify BPCHAR(1) NOT NULL,
		aggsortop OID NOT NULL,
		aggtranstype OID NOT NULL,
		aggtransspace INT4 NOT NULL,
		aggmtranstype OID NOT NULL,
		aggmtransspace INT4 NOT NULL,
		agginitval TEXT(2147483647),
		aggminitval TEXT(2147483647)
	);

CREATE TABLE Project (
		project_id INT8 NOT NULL,
		date_from TIMESTAMP NOT NULL,
		date_until TIMESTAMP NOT NULL,
		project_title VARCHAR(255),
		general_objetive VARCHAR(255),
		project_summay VARCHAR(255),
		project_methology VARCHAR(255),
		especific_objetive VARCHAR(255) NOT NULL,
		justification VARCHAR(255),
		project_research_typology_id INT8,
		state_id INT8 NOT NULL
	);

CREATE TABLE pg_index (
		indexrelid OID NOT NULL,
		indrelid OID NOT NULL,
		indnatts INT2 NOT NULL,
		indnkeyatts INT2 NOT NULL,
		indisunique BOOL NOT NULL,
		indisprimary BOOL NOT NULL,
		indisexclusion BOOL NOT NULL,
		indimmediate BOOL NOT NULL,
		indisclustered BOOL NOT NULL,
		indisvalid BOOL NOT NULL,
		indcheckxmin BOOL NOT NULL,
		indisready BOOL NOT NULL,
		indislive BOOL NOT NULL,
		indisreplident BOOL NOT NULL,
		indkey null NOT NULL,
		indcollation null NOT NULL,
		indclass null NOT NULL,
		indoption null NOT NULL,
		indexprs null,
		indpred null
	);

CREATE TABLE ResearchTypology (
		project_research_typology_id BIGSERIAL DEFAULT nextval('researchtypology_project_research_typology_id_seq'::regclass) NOT NULL,
		product_type VARCHAR(5) NOT NULL,
		typology_description VARCHAR(50) NOT NULL
	);

CREATE TABLE pg_class (
		oid OID NOT NULL,
		relname CIDR(2147483647) NOT NULL,
		relnamespace OID NOT NULL,
		reltype OID NOT NULL,
		reloftype OID NOT NULL,
		relowner OID NOT NULL,
		relam OID NOT NULL,
		relfilenode OID NOT NULL,
		reltablespace OID NOT NULL,
		relpages INT4 NOT NULL,
		reltuples FLOAT4 NOT NULL,
		relallvisible INT4 NOT NULL,
		reltoastrelid OID NOT NULL,
		relhasindex BOOL NOT NULL,
		relisshared BOOL NOT NULL,
		relpersistence BPCHAR(1) NOT NULL,
		relkind BPCHAR(1) NOT NULL,
		relnatts INT2 NOT NULL,
		relchecks INT2 NOT NULL,
		relhasrules BOOL NOT NULL,
		relhastriggers BOOL NOT NULL,
		relhassubclass BOOL NOT NULL,
		relrowsecurity BOOL NOT NULL,
		relforcerowsecurity BOOL NOT NULL,
		relispopulated BOOL NOT NULL,
		relreplident BPCHAR(1) NOT NULL,
		relispartition BOOL NOT NULL,
		relrewrite OID NOT NULL,
		relfrozenxid XID NOT NULL,
		relminmxid XID NOT NULL,
		relacl ACLITEM[ ],
		reloptions TEXT[ ](2147483647),
		relpartbound null
	);

CREATE TABLE pg_range (
		rngtypid OID NOT NULL,
		rngsubtype OID NOT NULL,
		rngmultitypid OID NOT NULL,
		rngcollation OID NOT NULL,
		rngsubopc OID NOT NULL,
		rngcanonical REGPROC NOT NULL,
		rngsubdiff REGPROC NOT NULL
	);

CREATE TABLE pg_amop (
		oid OID NOT NULL,
		amopfamily OID NOT NULL,
		amoplefttype OID NOT NULL,
		amoprighttype OID NOT NULL,
		amopstrategy INT2 NOT NULL,
		amoppurpose BPCHAR(1) NOT NULL,
		amopopr OID NOT NULL,
		amopmethod OID NOT NULL,
		amopsortfamily OID NOT NULL
	);

CREATE TABLE pg_default_acl (
		oid OID NOT NULL,
		defaclrole OID NOT NULL,
		defaclnamespace OID NOT NULL,
		defaclobjtype BPCHAR(1) NOT NULL,
		defaclacl ACLITEM[ ] NOT NULL
	);

CREATE TABLE pg_subscription_rel (
		srsubid OID NOT NULL,
		srrelid OID NOT NULL,
		srsubstate BPCHAR(1) NOT NULL,
		srsublsn null
	);

CREATE TABLE pg_rewrite (
		oid OID NOT NULL,
		rulename CIDR(2147483647) NOT NULL,
		ev_class OID NOT NULL,
		ev_type BPCHAR(1) NOT NULL,
		ev_enabled BPCHAR(1) NOT NULL,
		is_instead BOOL NOT NULL,
		ev_qual null NOT NULL,
		ev_action null NOT NULL
	);

CREATE TABLE pg_operator (
		oid OID NOT NULL,
		oprname CIDR(2147483647) NOT NULL,
		oprnamespace OID NOT NULL,
		oprowner OID NOT NULL,
		oprkind BPCHAR(1) NOT NULL,
		oprcanmerge BOOL NOT NULL,
		oprcanhash BOOL NOT NULL,
		oprleft OID NOT NULL,
		oprright OID NOT NULL,
		oprresult OID NOT NULL,
		oprcom OID NOT NULL,
		oprnegate OID NOT NULL,
		oprcode REGPROC NOT NULL,
		oprrest REGPROC NOT NULL,
		oprjoin REGPROC NOT NULL
	);

CREATE TABLE pg_init_privs (
		objoid OID NOT NULL,
		classoid OID NOT NULL,
		objsubid INT4 NOT NULL,
		privtype BPCHAR(1) NOT NULL,
		initprivs ACLITEM[ ] NOT NULL
	);

CREATE TABLE pg_publication_rel (
		oid OID NOT NULL,
		prpubid OID NOT NULL,
		prrelid OID NOT NULL
	);

CREATE TABLE pg_description (
		objoid OID NOT NULL,
		classoid OID NOT NULL,
		objsubid INT4 NOT NULL,
		description TEXT(2147483647) NOT NULL
	);

CREATE TABLE pg_enum (
		oid OID NOT NULL,
		enumtypid OID NOT NULL,
		enumsortorder FLOAT4 NOT NULL,
		enumlabel CIDR(2147483647) NOT NULL
	);

CREATE TABLE pg_extension (
		oid OID NOT NULL,
		extname CIDR(2147483647) NOT NULL,
		extowner OID NOT NULL,
		extnamespace OID NOT NULL,
		extrelocatable BOOL NOT NULL,
		extversion TEXT(2147483647) NOT NULL,
		extconfig OID[ ],
		extcondition TEXT[ ](2147483647)
	);

CREATE TABLE pg_policy (
		oid OID NOT NULL,
		polname CIDR(2147483647) NOT NULL,
		polrelid OID NOT NULL,
		polcmd BPCHAR(1) NOT NULL,
		polpermissive BOOL NOT NULL,
		polroles OID[ ] NOT NULL,
		polqual null,
		polwithcheck null
	);

CREATE TABLE pg_user_mapping (
		oid OID NOT NULL,
		umuser OID NOT NULL,
		umserver OID NOT NULL,
		umoptions TEXT[ ](2147483647)
	);

CREATE TABLE pg_tablespace (
		oid OID NOT NULL,
		spcname CIDR(2147483647) NOT NULL,
		spcowner OID NOT NULL,
		spcacl ACLITEM[ ],
		spcoptions TEXT[ ](2147483647)
	);

CREATE TABLE pg_inherits (
		inhrelid OID NOT NULL,
		inhparent OID NOT NULL,
		inhseqno INT4 NOT NULL,
		inhdetachpending BOOL NOT NULL
	);

CREATE TABLE pg_ts_config (
		oid OID NOT NULL,
		cfgname CIDR(2147483647) NOT NULL,
		cfgnamespace OID NOT NULL,
		cfgowner OID NOT NULL,
		cfgparser OID NOT NULL
	);

CREATE TABLE pg_opclass (
		oid OID NOT NULL,
		opcmethod OID NOT NULL,
		opcname CIDR(2147483647) NOT NULL,
		opcnamespace OID NOT NULL,
		opcowner OID NOT NULL,
		opcfamily OID NOT NULL,
		opcintype OID NOT NULL,
		opcdefault BOOL NOT NULL,
		opckeytype OID NOT NULL
	);

CREATE TABLE sql_sizing (
		sizing_id null,
		sizing_name null,
		supported_value null,
		comments null
	);

CREATE TABLE sql_implementation_info (
		implementation_info_id null,
		implementation_info_name null,
		integer_value null,
		character_value null,
		comments null
	);

CREATE UNIQUE INDEX pg_ts_dict_dictname_index ON pg_ts_dict (dictname ASC, dictnamespace ASC);

CREATE UNIQUE INDEX pg_operator_oprname_l_r_n_index ON pg_operator (oprname ASC, oprleft ASC, oprright ASC, oprnamespace ASC);

CREATE UNIQUE INDEX pg_sequence_seqrelid_index ON pg_sequence (seqrelid ASC);

CREATE UNIQUE INDEX pg_index_indexrelid_index ON pg_index (indexrelid ASC);

CREATE UNIQUE INDEX pg_publication_pubname_index ON pg_publication (pubname ASC);

CREATE UNIQUE INDEX pg_authid_oid_index ON pg_authid (oid ASC);

CREATE UNIQUE INDEX pg_trigger_tgrelid_tgname_index ON pg_trigger (tgrelid ASC, tgname ASC);

CREATE UNIQUE INDEX pg_constraint_conrelid_contypid_conname_index ON pg_constraint (conrelid ASC, contypid ASC, conname ASC);

CREATE UNIQUE INDEX pg_publication_rel_oid_index ON pg_publication_rel (oid ASC);

CREATE UNIQUE INDEX pg_am_name_index ON pg_am (amname ASC);

CREATE UNIQUE INDEX pg_opclass_am_name_nsp_index ON pg_opclass (opcmethod ASC, opcname ASC, opcnamespace ASC);

CREATE INDEX pg_shdepend_depender_index ON pg_shdepend (dbid ASC, classid ASC, objid ASC, objsubid ASC);

CREATE UNIQUE INDEX pg_user_mapping_oid_index ON pg_user_mapping (oid ASC);

CREATE UNIQUE INDEX pg_attribute_relid_attnam_index ON pg_attribute (attrelid ASC, attname ASC);

CREATE INDEX pg_inherits_parent_index ON pg_inherits (inhparent ASC);

CREATE UNIQUE INDEX pg_amop_opr_fam_index ON pg_amop (amopopr ASC, amoppurpose ASC, amopfamily ASC);

CREATE INDEX pg_statistic_ext_relid_index ON pg_statistic_ext (stxrelid ASC);

CREATE UNIQUE INDEX pg_subscription_subname_index ON pg_subscription (subdbid ASC, subname ASC);

CREATE UNIQUE INDEX pg_language_name_index ON pg_language (lanname ASC);

CREATE UNIQUE INDEX pg_partitioned_table_partrelid_index ON pg_partitioned_table (partrelid ASC);

CREATE UNIQUE INDEX pg_language_oid_index ON pg_language (oid ASC);

CREATE UNIQUE INDEX pg_description_o_c_o_index ON pg_description (objoid ASC, classoid ASC, objsubid ASC);

CREATE UNIQUE INDEX pg_inherits_relid_seqno_index ON pg_inherits (inhrelid ASC, inhseqno ASC);

CREATE UNIQUE INDEX pg_publication_oid_index ON pg_publication (oid ASC);

CREATE UNIQUE INDEX pg_tablespace_spcname_index ON pg_tablespace (spcname ASC);

CREATE UNIQUE INDEX pg_namespace_nspname_index ON pg_namespace (nspname ASC);

CREATE UNIQUE INDEX pg_shseclabel_object_index ON pg_shseclabel (objoid ASC, classoid ASC, provider ASC);

CREATE UNIQUE INDEX pg_enum_typid_label_index ON pg_enum (enumtypid ASC, enumlabel ASC);

CREATE UNIQUE INDEX pg_tablespace_oid_index ON pg_tablespace (oid ASC);

CREATE UNIQUE INDEX linkattached_pkey ON LinkAttached (link_attached_id ASC);

CREATE UNIQUE INDEX pg_collation_name_enc_nsp_index ON pg_collation (collname ASC, collencoding ASC, collnamespace ASC);

CREATE UNIQUE INDEX pg_extension_name_index ON pg_extension (extname ASC);

CREATE UNIQUE INDEX pg_namespace_oid_index ON pg_namespace (oid ASC);

CREATE UNIQUE INDEX pg_collation_oid_index ON pg_collation (oid ASC);

CREATE UNIQUE INDEX pg_type_typname_nsp_index ON pg_type (typname ASC, typnamespace ASC);

CREATE INDEX pg_class_tblspc_relfilenode_index ON pg_class (reltablespace ASC, relfilenode ASC);

CREATE UNIQUE INDEX pg_foreign_data_wrapper_oid_index ON pg_foreign_data_wrapper (oid ASC);

CREATE UNIQUE INDEX pg_event_trigger_oid_index ON pg_event_trigger (oid ASC);

CREATE UNIQUE INDEX pg_range_rngtypid_index ON pg_range (rngtypid ASC);

CREATE INDEX pg_index_indrelid_index ON pg_index (indrelid ASC);

CREATE UNIQUE INDEX pg_am_oid_index ON pg_am (oid ASC);

CREATE UNIQUE INDEX pg_foreign_data_wrapper_name_index ON pg_foreign_data_wrapper (fdwname ASC);

CREATE UNIQUE INDEX state_pkey ON State (state_id ASC);

CREATE UNIQUE INDEX researchtypology_pkey ON ResearchTypology (project_research_typology_id ASC);

CREATE UNIQUE INDEX pg_ts_dict_oid_index ON pg_ts_dict (oid ASC);

CREATE INDEX pg_constraint_conparentid_index ON pg_constraint (conparentid ASC);

CREATE UNIQUE INDEX pg_statistic_ext_data_stxoid_index ON pg_statistic_ext_data (stxoid ASC);

CREATE UNIQUE INDEX pg_seclabel_object_index ON pg_seclabel (objoid ASC, classoid ASC, objsubid ASC, provider ASC);

CREATE UNIQUE INDEX pg_ts_template_tmplname_index ON pg_ts_template (tmplname ASC, tmplnamespace ASC);

CREATE INDEX pg_trigger_tgconstraint_index ON pg_trigger (tgconstraint ASC);

CREATE UNIQUE INDEX comment_pkey ON Comment (comment_id ASC);

CREATE UNIQUE INDEX pg_largeobject_loid_pn_index ON pg_largeobject (loid ASC, pageno ASC);

CREATE UNIQUE INDEX pg_shdescription_o_c_index ON pg_shdescription (objoid ASC, classoid ASC);

CREATE INDEX pg_depend_reference_index ON pg_depend (refclassid ASC, refobjid ASC, refobjsubid ASC);

CREATE UNIQUE INDEX pg_aggregate_fnoid_index ON pg_aggregate (aggfnoid ASC);

CREATE UNIQUE INDEX User_pkey ON UserApp (user_id ASC);

CREATE UNIQUE INDEX pg_user_mapping_user_server_index ON pg_user_mapping (umuser ASC, umserver ASC);

CREATE INDEX pg_constraint_conname_nsp_index ON pg_constraint (conname ASC, connamespace ASC);

CREATE UNIQUE INDEX pg_subscription_rel_srrelid_srsubid_index ON pg_subscription_rel (srrelid ASC, srsubid ASC);

CREATE INDEX pg_depend_depender_index ON pg_depend (classid ASC, objid ASC, objsubid ASC);

CREATE UNIQUE INDEX pg_opclass_oid_index ON pg_opclass (oid ASC);

CREATE UNIQUE INDEX pg_policy_polrelid_polname_index ON pg_policy (polrelid ASC, polname ASC);

CREATE UNIQUE INDEX pg_foreign_server_oid_index ON pg_foreign_server (oid ASC);

CREATE UNIQUE INDEX pg_amop_fam_strat_index ON pg_amop (amopfamily ASC, amoplefttype ASC, amoprighttype ASC, amopstrategy ASC);

CREATE UNIQUE INDEX pg_transform_type_lang_index ON pg_transform (trftype ASC, trflang ASC);

CREATE UNIQUE INDEX pg_cast_oid_index ON pg_cast (oid ASC);

CREATE UNIQUE INDEX pg_attrdef_oid_index ON pg_attrdef (oid ASC);

CREATE UNIQUE INDEX pg_cast_source_target_index ON pg_cast (castsource ASC, casttarget ASC);

CREATE UNIQUE INDEX pg_statistic_ext_oid_index ON pg_statistic_ext (oid ASC);

CREATE UNIQUE INDEX pg_default_acl_oid_index ON pg_default_acl (oid ASC);

CREATE INDEX pg_constraint_contypid_index ON pg_constraint (contypid ASC);

CREATE UNIQUE INDEX pg_extension_oid_index ON pg_extension (oid ASC);

CREATE UNIQUE INDEX pg_foreign_table_relid_index ON pg_foreign_table (ftrelid ASC);

CREATE UNIQUE INDEX pg_opfamily_oid_index ON pg_opfamily (oid ASC);

CREATE UNIQUE INDEX id_proyecto ON Project (project_id ASC);

CREATE UNIQUE INDEX pg_proc_proname_args_nsp_index ON pg_proc (proname ASC, proargtypes ASC, pronamespace ASC);

CREATE UNIQUE INDEX delivery_pkey ON Delivery (delivery_id ASC);

CREATE UNIQUE INDEX pg_ts_parser_prsname_index ON pg_ts_parser (prsname ASC, prsnamespace ASC);

CREATE UNIQUE INDEX pg_init_privs_o_c_o_index ON pg_init_privs (objoid ASC, classoid ASC, objsubid ASC);

CREATE UNIQUE INDEX pg_rewrite_oid_index ON pg_rewrite (oid ASC);

CREATE UNIQUE INDEX pg_auth_members_role_member_index ON pg_auth_members (roleid ASC, member ASC);

CREATE UNIQUE INDEX pg_amproc_oid_index ON pg_amproc (oid ASC);

CREATE UNIQUE INDEX pg_attribute_relid_attnum_index ON pg_attribute (attrelid ASC, attnum ASC);

CREATE UNIQUE INDEX pg_statistic_relid_att_inh_index ON pg_statistic (starelid ASC, staattnum ASC, stainherit ASC);

CREATE UNIQUE INDEX pg_event_trigger_evtname_index ON pg_event_trigger (evtname ASC);

CREATE UNIQUE INDEX pg_replication_origin_roiident_index ON pg_replication_origin (roident ASC);

CREATE UNIQUE INDEX pg_class_relname_nsp_index ON pg_class (relname ASC, relnamespace ASC);

CREATE UNIQUE INDEX pg_db_role_setting_databaseid_rol_index ON pg_db_role_setting (setdatabase ASC, setrole ASC);

CREATE UNIQUE INDEX pg_type_oid_index ON pg_type (oid ASC);

CREATE UNIQUE INDEX pg_largeobject_metadata_oid_index ON pg_largeobject_metadata (oid ASC);

CREATE UNIQUE INDEX pg_default_acl_role_nsp_obj_index ON pg_default_acl (defaclrole ASC, defaclnamespace ASC, defaclobjtype ASC);

CREATE UNIQUE INDEX pg_conversion_default_index ON pg_conversion (connamespace ASC, conforencoding ASC, contoencoding ASC, oid ASC);

CREATE UNIQUE INDEX pg_conversion_name_nsp_index ON pg_conversion (conname ASC, connamespace ASC);

CREATE UNIQUE INDEX profile_pkey ON Profile (profile_id ASC);

CREATE UNIQUE INDEX pg_class_oid_index ON pg_class (oid ASC);

CREATE UNIQUE INDEX pg_statistic_ext_name_index ON pg_statistic_ext (stxname ASC, stxnamespace ASC);

CREATE UNIQUE INDEX pg_database_datname_index ON pg_database (datname ASC);

CREATE UNIQUE INDEX pg_publication_rel_prrelid_prpubid_index ON pg_publication_rel (prrelid ASC, prpubid ASC);

CREATE UNIQUE INDEX pg_enum_typid_sortorder_index ON pg_enum (enumtypid ASC, enumsortorder ASC);

CREATE UNIQUE INDEX pg_opfamily_am_name_nsp_index ON pg_opfamily (opfmethod ASC, opfname ASC, opfnamespace ASC);

CREATE UNIQUE INDEX pg_auth_members_member_role_index ON pg_auth_members (member ASC, roleid ASC);

CREATE UNIQUE INDEX pg_ts_config_oid_index ON pg_ts_config (oid ASC);

CREATE UNIQUE INDEX pg_transform_oid_index ON pg_transform (oid ASC);

CREATE UNIQUE INDEX pg_ts_config_map_index ON pg_ts_config_map (mapcfg ASC, maptokentype ASC, mapseqno ASC);

CREATE UNIQUE INDEX pg_range_rngmultitypid_index ON pg_range (rngmultitypid ASC);

CREATE UNIQUE INDEX pg_rewrite_rel_rulename_index ON pg_rewrite (ev_class ASC, rulename ASC);

CREATE UNIQUE INDEX pg_replication_origin_roname_index ON pg_replication_origin (roname ASC);

CREATE UNIQUE INDEX pg_policy_oid_index ON pg_policy (oid ASC);

CREATE UNIQUE INDEX pg_foreign_server_name_index ON pg_foreign_server (srvname ASC);

CREATE UNIQUE INDEX pg_operator_oid_index ON pg_operator (oid ASC);

CREATE UNIQUE INDEX project_delivery_pkey ON ProjectDelivery (project_delivery_id ASC);

CREATE UNIQUE INDEX pg_authid_rolname_index ON pg_authid (rolname ASC);

CREATE UNIQUE INDEX pg_proc_oid_index ON pg_proc (oid ASC);

CREATE UNIQUE INDEX pg_trigger_oid_index ON pg_trigger (oid ASC);

CREATE UNIQUE INDEX pg_ts_template_oid_index ON pg_ts_template (oid ASC);

CREATE UNIQUE INDEX pg_amop_oid_index ON pg_amop (oid ASC);

CREATE UNIQUE INDEX pg_subscription_oid_index ON pg_subscription (oid ASC);

CREATE UNIQUE INDEX pg_conversion_oid_index ON pg_conversion (oid ASC);

CREATE INDEX pg_shdepend_reference_index ON pg_shdepend (refclassid ASC, refobjid ASC);

CREATE UNIQUE INDEX projectuser_pkey ON ProjectUser (project_user_id ASC);

CREATE UNIQUE INDEX pg_ts_parser_oid_index ON pg_ts_parser (oid ASC);

CREATE UNIQUE INDEX pg_attrdef_adrelid_adnum_index ON pg_attrdef (adrelid ASC, adnum ASC);

CREATE UNIQUE INDEX pg_database_oid_index ON pg_database (oid ASC);

CREATE UNIQUE INDEX activity_pkey ON Activity (activity_id ASC);

CREATE UNIQUE INDEX pg_amproc_fam_proc_index ON pg_amproc (amprocfamily ASC, amproclefttype ASC, amprocrighttype ASC, amprocnum ASC);

CREATE UNIQUE INDEX pg_ts_config_cfgname_index ON pg_ts_config (cfgname ASC, cfgnamespace ASC);

CREATE UNIQUE INDEX pg_constraint_oid_index ON pg_constraint (oid ASC);

CREATE UNIQUE INDEX pg_enum_oid_index ON pg_enum (oid ASC);

ALTER TABLE pg_publication ADD CONSTRAINT pg_publication_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_init_privs ADD CONSTRAINT pg_init_privs_o_c_o_index PRIMARY KEY (objoid, classoid, objsubid);

ALTER TABLE pg_publication_rel ADD CONSTRAINT pg_publication_rel_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_collation ADD CONSTRAINT pg_collation_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_subscription_rel ADD CONSTRAINT pg_subscription_rel_srrelid_srsubid_index PRIMARY KEY (srrelid, srsubid);

ALTER TABLE pg_constraint ADD CONSTRAINT pg_constraint_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_ts_template ADD CONSTRAINT pg_ts_template_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_language ADD CONSTRAINT pg_language_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_event_trigger ADD CONSTRAINT pg_event_trigger_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_range ADD CONSTRAINT pg_range_rngtypid_index PRIMARY KEY (rngtypid);

ALTER TABLE Comment ADD CONSTRAINT comment_pkey PRIMARY KEY (comment_id);

ALTER TABLE pg_namespace ADD CONSTRAINT pg_namespace_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_partitioned_table ADD CONSTRAINT pg_partitioned_table_partrelid_index PRIMARY KEY (partrelid);

ALTER TABLE pg_operator ADD CONSTRAINT pg_operator_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_aggregate ADD CONSTRAINT pg_aggregate_fnoid_index PRIMARY KEY (aggfnoid);

ALTER TABLE pg_shdescription ADD CONSTRAINT pg_shdescription_o_c_index PRIMARY KEY (objoid, classoid);

ALTER TABLE pg_policy ADD CONSTRAINT pg_policy_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_description ADD CONSTRAINT pg_description_o_c_o_index PRIMARY KEY (objoid, classoid, objsubid);

ALTER TABLE pg_extension ADD CONSTRAINT pg_extension_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_proc ADD CONSTRAINT pg_proc_oid_index PRIMARY KEY (oid);

ALTER TABLE ProjectDelivery ADD CONSTRAINT project_delivery_pkey PRIMARY KEY (project_delivery_id);

ALTER TABLE pg_user_mapping ADD CONSTRAINT pg_user_mapping_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_trigger ADD CONSTRAINT pg_trigger_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_replication_origin ADD CONSTRAINT pg_replication_origin_roiident_index PRIMARY KEY (roident);

ALTER TABLE pg_opclass ADD CONSTRAINT pg_opclass_oid_index PRIMARY KEY (oid);

ALTER TABLE LinkAttached ADD CONSTRAINT linkattached_pkey PRIMARY KEY (link_attached_id);

ALTER TABLE pg_statistic_ext_data ADD CONSTRAINT pg_statistic_ext_data_stxoid_index PRIMARY KEY (stxoid);

ALTER TABLE pg_attribute ADD CONSTRAINT pg_attribute_relid_attnum_index PRIMARY KEY (attrelid, attnum);

ALTER TABLE pg_foreign_data_wrapper ADD CONSTRAINT pg_foreign_data_wrapper_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_tablespace ADD CONSTRAINT pg_tablespace_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_statistic_ext ADD CONSTRAINT pg_statistic_ext_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_transform ADD CONSTRAINT pg_transform_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_subscription ADD CONSTRAINT pg_subscription_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_sequence ADD CONSTRAINT pg_sequence_seqrelid_index PRIMARY KEY (seqrelid);

ALTER TABLE pg_default_acl ADD CONSTRAINT pg_default_acl_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_conversion ADD CONSTRAINT pg_conversion_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_auth_members ADD CONSTRAINT pg_auth_members_role_member_index PRIMARY KEY (roleid, member);

ALTER TABLE Delivery ADD CONSTRAINT delivery_pkey PRIMARY KEY (delivery_id);

ALTER TABLE pg_statistic ADD CONSTRAINT pg_statistic_relid_att_inh_index PRIMARY KEY (starelid, staattnum, stainherit);

ALTER TABLE pg_enum ADD CONSTRAINT pg_enum_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_shseclabel ADD CONSTRAINT pg_shseclabel_object_index PRIMARY KEY (objoid, classoid, provider);

ALTER TABLE pg_ts_dict ADD CONSTRAINT pg_ts_dict_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_amproc ADD CONSTRAINT pg_amproc_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_foreign_server ADD CONSTRAINT pg_foreign_server_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_cast ADD CONSTRAINT pg_cast_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_ts_config ADD CONSTRAINT pg_ts_config_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_amop ADD CONSTRAINT pg_amop_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_ts_parser ADD CONSTRAINT pg_ts_parser_oid_index PRIMARY KEY (oid);

ALTER TABLE ResearchTypology ADD CONSTRAINT researchtypology_pkey PRIMARY KEY (project_research_typology_id);

ALTER TABLE pg_database ADD CONSTRAINT pg_database_oid_index PRIMARY KEY (oid);

ALTER TABLE Profile ADD CONSTRAINT profile_pkey PRIMARY KEY (profile_id);

ALTER TABLE Activity ADD CONSTRAINT activity_pkey PRIMARY KEY (activity_id);

ALTER TABLE Project ADD CONSTRAINT id_proyecto PRIMARY KEY (project_id);

ALTER TABLE pg_largeobject_metadata ADD CONSTRAINT pg_largeobject_metadata_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_opfamily ADD CONSTRAINT pg_opfamily_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_authid ADD CONSTRAINT pg_authid_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_class ADD CONSTRAINT pg_class_oid_index PRIMARY KEY (oid);

ALTER TABLE UserApp ADD CONSTRAINT User_pkey PRIMARY KEY (user_id);

ALTER TABLE pg_rewrite ADD CONSTRAINT pg_rewrite_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_am ADD CONSTRAINT pg_am_oid_index PRIMARY KEY (oid);

ALTER TABLE State ADD CONSTRAINT state_pkey PRIMARY KEY (state_id);

ALTER TABLE pg_seclabel ADD CONSTRAINT pg_seclabel_object_index PRIMARY KEY (objoid, classoid, objsubid, provider);

ALTER TABLE ProjectUser ADD CONSTRAINT projectuser_pkey PRIMARY KEY (project_user_id);

ALTER TABLE pg_type ADD CONSTRAINT pg_type_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_ts_config_map ADD CONSTRAINT pg_ts_config_map_index PRIMARY KEY (mapcfg, maptokentype, mapseqno);

ALTER TABLE pg_attrdef ADD CONSTRAINT pg_attrdef_oid_index PRIMARY KEY (oid);

ALTER TABLE pg_inherits ADD CONSTRAINT pg_inherits_relid_seqno_index PRIMARY KEY (inhrelid, inhseqno);

ALTER TABLE pg_index ADD CONSTRAINT pg_index_indexrelid_index PRIMARY KEY (indexrelid);

ALTER TABLE pg_foreign_table ADD CONSTRAINT pg_foreign_table_relid_index PRIMARY KEY (ftrelid);

ALTER TABLE pg_db_role_setting ADD CONSTRAINT pg_db_role_setting_databaseid_rol_index PRIMARY KEY (setdatabase, setrole);

ALTER TABLE pg_largeobject ADD CONSTRAINT pg_largeobject_loid_pn_index PRIMARY KEY (loid, pageno);

ALTER TABLE ProjectDelivery ADD CONSTRAINT fkproject_de969291 FOREIGN KEY (project_id)
	REFERENCES Project (project_id);

ALTER TABLE Comment ADD CONSTRAINT fkcomment829094 FOREIGN KEY (activity_id)
	REFERENCES Activity (activity_id);

ALTER TABLE UserApp ADD CONSTRAINT fkuser399673 FOREIGN KEY (profile_id)
	REFERENCES Profile (profile_id);

ALTER TABLE LinkAttached ADD CONSTRAINT fklinkattach227390 FOREIGN KEY (activity_id)
	REFERENCES Activity (activity_id);

ALTER TABLE Activity ADD CONSTRAINT fkactivity46817 FOREIGN KEY (project_id)
	REFERENCES Project (project_id);

ALTER TABLE ProjectUser ADD CONSTRAINT fkprojectuse427809 FOREIGN KEY (user_id)
	REFERENCES UserApp (user_id);

ALTER TABLE Project ADD CONSTRAINT fkproject25763 FOREIGN KEY (state_id)
	REFERENCES State (state_id);

ALTER TABLE ProjectDelivery ADD CONSTRAINT fkproject_de35226 FOREIGN KEY (delivery_id)
	REFERENCES Delivery (delivery_id);

ALTER TABLE ProjectUser ADD CONSTRAINT fkprojectuse552417 FOREIGN KEY (project_id)
	REFERENCES Project (project_id);

