
-- ���ο� �� ����, ����Ȯ��
ResearchNewPoison_MakeSuccessPercent = {
		35, 40, 45, 50, 55, 60, 65, 70, 75, 80
	}

-- ���ο� �� ����, �ּҼ���
ResearchNewPoison_MakeMinCount = {
		2, 2, 3, 3, 4, 4, 5, 5, 6, 6
	}

-- ���ο� �� ����, �ִ����
ResearchNewPoison_MakeMaxCount = {
		4, 5, 5, 6, 6, 7, 7, 8, 8, 9
	}


-- ���ο� �� ����, ����
-- ResearchNewPoison_Tolerance = {
--		5, 10, 15, 20, 25, 30, 35, 40, 45, 50
--	}

-- ���ο� �� ����, ���������� �� ������
ResearchNewPoison_MakableItem = {
		"Poison_Paralysis",		-- ��������
		"Poison_Fever",			-- ������
		"Poison_Contamination",		-- ��ó����
		"Poison_Leech",		-- �ŸӸ�
		"Guillotine_Antidote",	-- �ص���
		"Poison_Fatigue",		-- ��൶
		"Poison_Laughing",		-- ��������
		"Poison_Numb",		-- �Ű渶��
		"Poison_Oblivion"		-- ��������
	}


-- �� ������ �ʿ��� ������, ��������ŰƮ�� �� �־��ּ���.

NewPoison_12717 = {					-- Poison_Paralysis
		["Poison_Kit"]		= 1,
		["Medicine_Bowl"]			= 1,
		["Poison_Toad's_Skin"]	= 20,		
		["Poison_Herb_Amoena"]	= 1,
	}

NewPoison_12722 = {					-- Poison_Fever
		["Poison_Kit"]		= 1,
		["Medicine_Bowl"]			= 1,		
		["Anolian_Skin"]	= 20,		
		["Poison_Herb_Rantana"]		= 1,		
	}

NewPoison_12720 = {					-- Poison_Contamination
		["Poison_Kit"]		= 1,
		["Medicine_Bowl"]			= 1,		
		["Decayed_Nail"]		= 25,		
		["Poison_Herb_Seratum"]		= 1,	
	}

NewPoison_12718 = {					-- Poison_Leech
		["Poison_Kit"]		= 1,		
		["Medicine_Bowl"]			= 1,
		["Poison_Herb_Scopolia"]	= 1,		
		["Poison_Herb_Nerium"]		= 1,	
	}

NewPoison_6128 = {					-- Guillotine_Antidote
		["Green_Herb"]		= 2,				
		["White_Herb"]		= 1,				
		["Blue_Herb"]		= 1,				
	}

NewPoison_12724 = {					-- Poison_Fatigue
		["Poison_Kit"]		= 1,
		["Medicine_Bowl"]			= 1,		
		["Sticky_Poison"]	= 10,		
		["Izidor"]		= 1,
	}

NewPoison_12723 = {					-- Poison_Laughing
		["Poison_Kit"]		= 1,
		["Medicine_Bowl"]			= 1,		
		["Poison_Spore"]		= 10,		
		["Poison_Herb_Makulata"]	= 1,	
	}

NewPoison_12721 = {					-- Poison_Numb
		["Poison_Kit"]		= 1,
		["Medicine_Bowl"]			= 1,		
		["Sticky_Poison"]	= 10,		
		["Poison_Herb_Nerium"]		= 1,	
	}

NewPoison_12719 = {					-- Poison_Oblivion
		["Poison_Kit"]		= 1,
		["Medicine_Bowl"]			= 1,		
		["Heart_Of_Mermaid"]		= 10,		
		["Izidor"]		= 1,
	}


-- ������׿������� ��밡���� ���� ���� ����Ʈ
PoisoningWeaponList = {
		["Poison_Paralysis"]		= "EFST_PARALYSE",		-- ��������
		["Poison_Fever"]			= "EFST_PYREXIA",		-- ������
		["Poison_Contamination"]		= "EFST_DEATHHURT",		-- ��ó����
		["Poison_Leech"]		= "EFST_LEECHESEND",	-- �ŸӸ�		
		["Poison_Fatigue"]		= "EFST_VENOMBLEED",	-- ��൶
		["Poison_Laughing"]		= "EFST_MAGICMUSHROOM",	-- ��������
		["Poison_Numb"]		= "EFST_TOXIN",			-- �Ű渶��
		["Poison_Oblivion"]		= "EFST_OBLIVIONCURSE"	-- ��������
	}



-- ���ƾũ�ν��� �� ������ ���ӽð� 
BuffDelayTimeList = {
		["EFST_PARALYSE"]		= 300000,	-- ��������
		["EFST_PYREXIA"]		= 300000,	-- ������
		["EFST_DEATHHURT"]		= 300000,	-- ��ó����
		["EFST_LEECHESEND"]		= 300000,	-- �ŸӸ�		
		["EFST_VENOMBLEED"]		= 300000,	-- ��൶
		["EFST_MAGICMUSHROOM"]	= 300000,	-- ��������
		["EFST_TOXIN"]			= 300000,	-- �Ű渶��
		["EFST_OBLIVIONCURSE"]	= 300000,	-- ��������
	}


MagicMushroomRandomSkillList = {
		"KN_AUTOCOUNTER",
		"MG_SIGHT",
		"MG_ENERGYCOAT",
		"AC_CONCENTRATION",
		"AL_ANGELUS",
		"AL_CRUCIS",
		"AL_RUWACH",
		"SM_MAGNUM",
		"SM_ENDURE",
		"PR_MAGNIFICAT",
		"BS_HAMMERFALL",
		"BS_MAXIMIZE",
		"NV_FIRSTAID",
		"TF_BACKSLIDING",
		"TF_PICKSTONE",
		"CR_AUTOGUARD",
		"CR_PROVIDENCE",
		"MO_CALLSPIRITS",
		"MO_EXPLOSIONSPIRITS",
		"DC_SCREAM",
		"NJ_TATAMIGAESHI",
		"NJ_UTSUSEMI",
		"GS_GLITTERING",
	}