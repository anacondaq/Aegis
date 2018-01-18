-- 랭크의 종류
RankType = {	
		 S = 0, 
	     A = 1,
  	     B = 2,
	     C = 3 
	}


-- 아이템별 랭크
RuneRankList = {
		["Runstone_Verkana"]		= RankType.S ,		-- 베르카나		
		["Runstone_Rhydo"]		= RankType.C ,		-- 라이도	
		["Runstone_Nosiege"]		= RankType.A ,		-- 노씨즈		
		["Runstone_Turisus"]		= RankType.C ,		-- 튜리서스
		["Runstone_Hagalas"]		= RankType.C ,		-- 하갈라즈		
		["Runstone_Isia"]		= RankType.B ,		-- 아이샤	
		["Runstone_Pertz"]		= RankType.B ,		-- 페르쓰
		["Runstone_Asir"]		= RankType.C ,		-- 에이시르		
		["Runstone_Urj"]		= RankType.A ,		-- 우르즈		
		["Runstone_Lux"]		= RankType.S 		--  아니마
	}

-- 랭크별 성공 확률 보정값
RankSuccessPercent = {
		S = -20,
		A = -15,
		B = -10,
		C = -5
	}

-- 원석 성공 확률 보정
RawRuneSuccessPercent = {
		["Runstone_Ordinary"]		= 2,		-- 일반룬,	
		["Runstone_Quality"]		= 5,		-- 고급룬,	
		["Runstone_Rare"]		= 8,		-- 희귀룬,	
		["Runstone_Ancient"]		= 11,		-- 고대룬,	
		["Runstone_Mystic"]		= 14		-- 신비한룬,
	}


-- 룬마스터리 스킬 레벨별 제작성공율
RuneMastery_MakeSuccessPercent = {
		53, 55, 57, 59, 61, 63, 65, 67, 69, 71
	}

-- 룬마스터리, 스킬 레벨별 제작 최소수량
RuneMastery_MakeMinCount = {
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1
	}

-- 룬마스터리, 스킬 레벨별 제작 최대수량
RuneMastery_MakeMaxCount = {
		1, 1, 1, 1, 2, 2, 2, 2, 2, 3
	}

-- 룬마스터리 스킬 레벨별 사용성공율
RuneMastery_UseSuccessPercent = {
		56, 57, 58, 59, 60, 61, 62, 63, 64, 65
	}

	
-- 룬 아이템 최대 소지 갯수
RuneItem_MaxCount = {
		["Runstone_Turisus"]		= 20,		-- 튜리서스
		["Runstone_Isia"]		= 20,		-- 아이샤
		["Runstone_Pertz"]		= 20,		-- 페르쓰
		["Runstone_Hagalas"]		= 20,		-- 하갈라즈
		["Runstone_Asir"]		= 20,		-- 에이시르
		["Runstone_Urj"]		= 20,		-- 우르즈
		["Runstone_Rhydo"]		= 20,		-- 라이도
		["Runstone_Nosiege"]		= 20,		-- 노씨즈
		["Runstone_Verkana"]		= 20,		-- 베르카나
		["Runstone_Lux"]		= 20		-- 아니마
	}


-- 룬마스터리 스킬 레벨에 따라서 제작 가능한 룬
RuneMasteryLevel_MakableItem = {
		"Runstone_Turisus",		-- 튜리서드
		"Runstone_Isia",		-- 아이샤
		"Runstone_Pertz",		-- 페르쓰
		"Runstone_Hagalas",		-- 하갈라즈
		"Runstone_Asir",		-- 에이시르
		"Runstone_Urj",			-- 우르즈
		"Runstone_Rhydo",		-- 라이도
		"Runstone_Nosiege",		-- 노씨즈
		"Runstone_Verkana",		-- 베르카나
		"Runstone_Lux"			-- 아니마
	}


-- 룬제작에 필요한 아이템, 테이블 이름에 한글명을 사용할 수 없어서... itemID로 넣음! 주의!

Rune_12731 = {		-- 튜리서스
		["Elder_Branch"]		= 1,		
		["Cobold_Hair"]		= 1,		
		["Claw_Of_Desert_Wolf"]		= 1,		
	}

Rune_12728 = {		-- 아이샤 
		["Elder_Branch"]		= 1,		
		["Burning_Heart"]		= 1,		
	}

Rune_12732 = {		-- 페르쓰 
		["Elder_Branch"]		= 1,		
		["Light_Granule"]	= 1,		
		["Tangled_Chain"]		= 1,		
		["Dragon_Canine"]		= 1,		
	}

Rune_12733 = {		-- 하갈라즈 
		["Elder_Branch"]		= 1,		
		["Round_Shell"]	= 1,		
		["Dragon's_Skin"]		= 1,		
	}

Rune_12729 = {		-- 에이시르 
		["Elder_Branch"]		= 1,		
		["Light_Granule"]	= 1,		
		["Ogre_Tooth"]		= 1,		
	}

Rune_12730 = {			-- 우르즈 
		["Elder_Branch"]		= 1,		
		["Slender_Snake"]	= 1,		
		["Honey"]		= 1,		
	}

Rune_12726 = {	-- 라이도 
		["Elder_Branch"]		= 1,		
		["Light_Granule"]	= 1,		
		["Red_Gemstone"]		= 1,		
	}

Rune_12725 = {		-- 노씨즈 
		["Elder_Branch"]		= 1,		
		["Light_Granule"]	= 1,		
		["Broken_Armor_Piece"]		= 1,		
		["Old_Magic_Circle"]		= 1,		
	}

Rune_12727 = {		-- 베르카나 
		["Elder_Branch"]		= 1,		
		["Dullahan_Armor"]	= 1,		
	}
Rune_22540 = {		-- 럭스아니마 
		["Elder_Branch"]		= 1,		
		["Gold"]	= 3,		
		["Light_Granule"]	= 3,		
	}