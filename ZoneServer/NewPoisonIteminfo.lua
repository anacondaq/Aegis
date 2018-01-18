
-- 새로운 독 연구, 제조확률
ResearchNewPoison_MakeSuccessPercent = {
		35, 40, 45, 50, 55, 60, 65, 70, 75, 80
	}

-- 새로운 독 연구, 최소수량
ResearchNewPoison_MakeMinCount = {
		2, 2, 3, 3, 4, 4, 5, 5, 6, 6
	}

-- 새로운 독 연구, 최대수량
ResearchNewPoison_MakeMaxCount = {
		4, 5, 5, 6, 6, 7, 7, 8, 8, 9
	}


-- 새로운 독 연구, 내성
-- ResearchNewPoison_Tolerance = {
--		5, 10, 15, 20, 25, 30, 35, 40, 45, 50
--	}

-- 새로운 독 연구, 제조가능한 독 레벨별
ResearchNewPoison_MakableItem = {
		"Poison_Paralysis",		-- 감각마비
		"Poison_Fever",			-- 열병독
		"Poison_Contamination",		-- 상처오염
		"Poison_Leech",		-- 거머리
		"Guillotine_Antidote",	-- 해독약
		"Poison_Fatigue",		-- 쇠약독
		"Poison_Laughing",		-- 웃음버섯
		"Poison_Numb",		-- 신경마비독
		"Poison_Oblivion"		-- 망각의재
	}


-- 독 생성시 필요한 아이템, 독약제조키트는 꼭 넣어주세요.

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


-- 포이즈닝웨폰에서 사용가능한 독과 버프 리스트
PoisoningWeaponList = {
		["Poison_Paralysis"]		= "EFST_PARALYSE",		-- 감각마비
		["Poison_Fever"]			= "EFST_PYREXIA",		-- 열병독
		["Poison_Contamination"]		= "EFST_DEATHHURT",		-- 상처오염
		["Poison_Leech"]		= "EFST_LEECHESEND",	-- 거머리		
		["Poison_Fatigue"]		= "EFST_VENOMBLEED",	-- 쇠약독
		["Poison_Laughing"]		= "EFST_MAGICMUSHROOM",	-- 웃음버섯
		["Poison_Numb"]		= "EFST_TOXIN",			-- 신경마비독
		["Poison_Oblivion"]		= "EFST_OBLIVIONCURSE"	-- 망각의재
	}



-- 길로틴크로스의 독 버프의 지속시간 
BuffDelayTimeList = {
		["EFST_PARALYSE"]		= 300000,	-- 감각마비
		["EFST_PYREXIA"]		= 300000,	-- 열병독
		["EFST_DEATHHURT"]		= 300000,	-- 상처오염
		["EFST_LEECHESEND"]		= 300000,	-- 거머리		
		["EFST_VENOMBLEED"]		= 300000,	-- 쇠약독
		["EFST_MAGICMUSHROOM"]	= 300000,	-- 웃음버섯
		["EFST_TOXIN"]			= 300000,	-- 신경마비독
		["EFST_OBLIVIONCURSE"]	= 300000,	-- 망각의재
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