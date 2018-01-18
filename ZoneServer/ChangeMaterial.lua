
-- 이파일은 lua 문법에 따라 작성해야 합니다.
-- 이 파일은 체인지 매터리얼 스킬 설정입니다.


function main()

	tbl={		
		{-- 1.신관의가면(1045)
			Material={{940,"Grasshopper's_Leg",45},{942,"Yoyo_Tail",35},},   
			Product={{1045,"Sacred_Masque",8,1000},},   
			RandomPermill = 800,--80%
		},
		
		{-- 2.긴머리카락(1020)
			Material={{738,"Pencil_Case",40},{1029,"Tiger's_Skin",5},},   
			Product={{1020,"Long_Hair",4,800},{1020,"Long_Hair",6,200},},   
			RandomPermill = 1000,
		},
		
		{-- 3.프라콘(1010)
			Material={{908,"Spawn",45},{746,"Glass_Bead",40},},   
			Product={{1010,"Phracon",8,1000},},   
			RandomPermill = 800,
		},
		
		{-- 4.랜턴(1041)
			Material={{943,"Solid_Shell",10},{1032,"Blossom_Of_Maneater",20},},   
			Product={{1041,"Lantern",3,1000},},   
			RandomPermill = 800,
		},
		
		{-- 5.도토리(1026)
			Material={{952,"Cactus_Needle",30},{946,"Snail's_Shell",10},},   
			Product={{1026,"Acorn",4,1000},},   
			RandomPermill = 800,
		},		 
		
		
		{-- 6.비정한마음(1008)
			Material={{754,"Raccoondog_Doll",25},{1057,"Moth_Dust",35},},   
			Product={{1008,"Frozen_Heart",6,1000},},   
			RandomPermill = 800,
		},
		
		{-- 7.망자의이빨(958)
			Material={{905,"Stem",45},{1036,"Dragon_Scale",45},},   
			Product={{958,"Horrendous_Mouth",9,1000},},   
			RandomPermill = 800,
		},
		
		{-- 8.디트리민(971)
			Material={{915,"Chrysalis",40},{966,"Flesh_Of_Clam",10},},   
			Product={{971,"Detrimindexta",5,1000},},   
			RandomPermill = 800,
		},
		
		{-- 9.뇌관(1051)
			Material={{941,"Nose_Ring",45},{916,"Feather_Of_Birds",25},},   
			Product={{1051,"Detonator",7,1000},},   
			RandomPermill = 800,
		},
		
		{-- 10.전갈의집게손(1046)
			Material={{955,"Worm_Peelings",40},{753,"Monkey_Doll",5},},   
			Product={{1046,"Tweezer",4,1000},},   
			RandomPermill = 800,
		},
		
		
		{-- 11.새끼악마의뿔(1038)
			Material={{953,"Stone_Heart",5},{907,"Resin",10},},   
			Product={{1038,"Petite_DiablOfs_Horn",1,800},{1038,"Petite_DiablOfs_Horn",1,200},},   
			RandomPermill = 1000,
		},
		
		{-- 12.식인수의뿌리(1033)
			Material={{917,"Talon",25},{1044,"Tooth_Of_",20},},   
			Product={{1033,"Root_Of_Maneater",4,800},{1033,"Root_Of_Maneater",6,200},},   
			RandomPermill = 1000,
		},
		
		{-- 13.소라(961)
			Material={{956,"Gill",5},{929,"Immortal_Heart",25},},   
			Product={{961,"Conch",3,1000},},   
			RandomPermill = 800,
		},
		
		{-- 14.썩은비늘(959)
			Material={{935,"Shell",20},{1015,"Thin_N'_Long_Tongue",50},},   
			Product={{959,"Rotten_Scale",7,1000},},   
			RandomPermill = 800,
		},
		
		{-- 15.늙은요정의수염(1040)
			Material={{939,"Bee_Sting",35},{1039,"Petite_DiablOfs_Wing",45},},   
			Product={{1040,"Elder_Pixie's_Beard",8,800},{1040,"Elder_Pixie's_Beard",12,200},},   
			RandomPermill = 1000,
		},
		
		{-- 16.도마뱀의목덜미(1012)
			Material={{926,"Scale_Of_Snakes",20},{972,"Karvodailnirol",15},},   
			Product={{1012,"Lizard_Scruff",3,1000},},   
			RandomPermill = 800,
		},
		
		{-- 17.엠베르타콘(1011)
			Material={{950,"Heart_Of_Mermaid",5},{752,"Grasshopper_Doll",40},},   
			Product={{1011,"Emveretarcon",4,1000},},   
			RandomPermill = 800,
		},
		
		{-- 18.먹물(1024)
			Material={{948,"Bear's_Foot",20},{737,"Black_Ladle",25},},   
			Product={{1024,"Chinese_Ink",4,1000},},   
			RandomPermill = 800,
		},
		
		{-- 19.거미줄(1025)
			Material={{951,"Fin",50},{1048,"Slender_Snake",35},},   
			Product={{1025,"Spiderweb",8,1000},},   
			RandomPermill = 800,
		},
		
		{-- 20.말고삐(1064)
			Material={{742,"Chonchon_Doll",30},{740,"Stuffed_Doll",50},},   
			Product={{1064,"Reins",8,1000},},   
			RandomPermill = 800,
		},
		
		{-- 21.나무조각(1019)
			Material={{930,"Rotten_Bandage",10},{1052,"Single_Cell",10},},   
			Product={{1019,"Wooden_Block",2,1000},},   
			RandomPermill = 800,
		},
		
		{-- 22.촉수(962)
			Material={{957,"Decayed_Nail",40},{1028,"Wild_Boar's_Mane",5},},   
			Product={{962,"Tentacle",4,800},{962,"Tentacle",6,200},},   
			RandomPermill = 1000,
		},
		
		{-- 23.혼합제(974)
			Material={{937,"Posionous_Canine",15},{924,"Powder_Of_Butterfly",30},},   
			Product={{974,"Mixture",4,800},{974,"Mixture",6,200},},   
			RandomPermill = 1000,
		},
		
		{-- 24.알록달록한껍질(1013)
			Material={{947,"Horn",50},{912,"Zargon",45},},   
			Product={{1013,"Colorful_Shell",9,800},{1013,"Colorful_Shell",13,200},},   
			RandomPermill = 1000,
		},
		
		{-- 25.나방의날개(1058)
			Material={{749,"Frozen_Rose",20},{903,"Reptile_Tongue",30},},   
			Product={{1058,"Wing_Of_Moth",5,1000},},   
			RandomPermill = 800,
		},
		
		
		{-- 26.집게발(960)
			Material={{938,"Sticky_Mucus",25},{1055,"Earthworm_Peeling",40},},   
			Product={{960,"Nipper",6,800},{960,"Nipper",9,200},},   
			RandomPermill = 1000,
		},
		
		{-- 27.거북이등껍질(967)
			Material={{914,"Fluff",5},{741,"Poring_Doll",40},},   
			Product={{967,"Turtle_Shell",4,1000},},   
			RandomPermill = 800,
		},
		
		{-- 28.오크의손톱(1043)
			Material={{945,"Raccoon_Leaf",50},{910,"Garlet",10},},   
			Product={{1043,"Nail_Of_Orc",6,1000},},   
			RandomPermill = 800,
		},
		
		{-- 29.드래곤의이빨(1035)
			Material={{751,"Osiris_Doll",50},{918,"Sticky_Webfoot",35},},   
			Product={{1035,"Dragon_Canine",8,800},{1035,"Dragon_Canine",12,200},},   
			RandomPermill = 1000,
		},
		
		{-- 30.처녀의옷자락(1049)
			Material={{936,"Scales_Shell",30},{1047,"Head_Of_Medusa",35},},   
			Product={{1049,"Skirt_Of_Virgin",6,1000},},   
			RandomPermill = 800,
		},
		
		{-- 31.드래곤의꼬리(1037)
			Material={{913,"Tooth_Of_Bat",25},{1063,"Sharpened_Cuspid",35},},   
			Product={{1037,"Dragon_Train",6,1000},},   
			RandomPermill = 800,
		},
		
		
		{-- 32.도깨비의뿔(1021)
			Material={{954,"Shining_Scales",15},{1054,"Lip_Of_Ancient_Fish",25},},   
			Product={{1021,"Dokkaebi_Horn",4,1000},},   
			RandomPermill = 800,
		},
		
		{-- 33.모래조각(1056)
			Material={{747,"Crystal_Mirror",35},{1031,"Limb_Of_Mantis",50},},   
			Product={{1056,"Grit",8,1000},},   
			RandomPermill = 800,
		},
		
		{-- 34.날카로운비늘(963)
			Material={{944,"Horseshoe",10},{965,"Clam_Shell",20},},   
			Product={{963,"Sharp_Scale",3,1000},},   
			RandomPermill = 800,
		},
		
		{-- 35.짧은다리(1042)
			Material={{920,"Claw_Of_Wolves",20},{911,"Scell",45},},   
			Product={{1042,"Short_Leg",6,1000},},   
			RandomPermill = 800,
		},
		
		{-- 36.마녀의별모래(1061)
			Material={{928,"Insect_Feeler",10},{735,"Blue_Porcelain",15},},   
			Product={{1061,"Starsand_Of_Witch",2,1000},},   
			RandomPermill = 800,
		},
		
		{-- 37.여우의꼬리(1022)
			Material={{919,"Animal's_Skin",10},{739,"Rouge",15},},   
			Product={{1022,"Fox_Tail",2,800},{1022,"Fox_Tail",3,200},},   
			RandomPermill = 1000,
		},
		
		{-- 38.코볼트의털(1034)
			Material={{909,"Jellopy",45},{745,"Wedding_Bouquet",20},},   
			Product={{1034,"Cobold_Hair",6,800},{1034,"Cobold_Hair",9,200},},   
			RandomPermill = 1000,
		},
		
		{-- 39.개미의턱뼈(1014)
			Material={{743,"Spore_Doll",20},{748,"Witherless_Rose",20},},   
			Product={{1014,"Jaws_Of_Ant",4,800},{1014,"Jaws_Of_Ant",6,200},},   
			RandomPermill = 1000,
		},
		
		{-- 40.오크용자의증표(968)
			Material={{902,"Tree_Root",5},{1018,"Nail_Of_Mole",45},},
			Product={{968,"Voucher_Of_Orcish_Hero",5,1000},},   
			RandomPermill = 800,
		},
		
		{-- 41.성흔(1009)
			Material={{904,"Scorpion's_Tail",10},{1062,"Pumpkin_Head",30},},
			Product={{1009,"Sacred_Marks",4,1000},},   
			RandomPermill = 800,
		},
		
		{-- 42.알코올(970)
			Material={{931,"Orcish_Voucher",50},{932,"Skel_Bone",40},},
			Product={{970,"Alchol",9,1000},},   
			RandomPermill = 800,
		},
		
		{-- 43.게등껍질(964)
			Material={{750,"Baphomet_Doll",50},{1023,"Fish_Tail",30},},
			Product={{964,"Crap_Shell",8,1000},},   
			RandomPermill = 800,
		},
		
		{-- 44.힘줄(1050)
			Material={{922,"Orcish_Cuspid",25},{949,"Feather",5},},
			Product={{1050,"Tendon",3,1000},},   
			RandomPermill = 800,
		},
		
		{-- 45.호랑이의발바닥(1030)
			Material={{906,"Pointed_Scale",5},{736,"White_Platter",20},},
			Product={{1030,"Tiger_Footskin",2,1000},},   
			RandomPermill = 800,
		},
		
		{-- 46.황금(969)
			Material={{744,"Bunch_Of_Flowers",45},{1017,"Moustache_Of_Mole",40},},
			Product={{703,"Hinalle",4,800},{703,"Hinalle",2,200},},   
			RandomPermill = 1000,
		},
		
		{-- 47.중화제(973)
			Material={{923,"Evil_Horn",15},{934,"Mementos",30},},
			Product={{973,"Counteragent",4,1000},},   
			RandomPermill = 800,
		},
		
		{-- 48.고대어의이빨(1053)
			Material={{925,"Bill_Of_Birds",35},{1059,"Transparent_Cloth",30},},
			Product={{1053,"Tooth_Of_Ancient_Fish",6,800},{1053,"Tooth_Of_Ancient_Fish",9,200},},   
			RandomPermill = 1000,
		},
		
		{-- 49.쥐의꼬리(1016)
			Material={{921,"Mushroom_Spore",35},{1060,"Golden_Hair",40},},
			Product={{1016,"Rat_Tail",7,800},{1016,"Rat_Tail",10,200},},   
			RandomPermill = 1000,
		},		 
		 
		{-- 50.석탄(1003)
			Material={{2101,"Guard",1},},
			Product={{1003,"Coal",1,1000},},   
			RandomPermill = 500,
		},
		
		{-- 51.강철(999)
			Material={{1119,"Tsurugi",1},},
			Product={{999,"Steel",10,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 52.담배(2267)
			Material={{1304,"Orcish_Axe",1},},
			Product={{2267,"Cigar",1,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 53.해골지팡이(1615)
			Material={{7752,"Clattering_Skull",100},{7753,"Broken_Farming_Utensil",100},},
			Product={{1615,"Bone_Wand",1,1000},},   
			RandomPermill = 200,
		},
		
		{-- 54.담배(2267)
			Material={{1304,"Orcish_Axe",1},{931,"Orcish_Voucher",100},},
			Product={{2267,"Cigar",1,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 55.마녀의별모래(1061)
			Material={{1057,"Moth_Dust",100},{911,"Scell",100},},
			Product={{1061,"Starsand_Of_Witch",1,1000},},   
			RandomPermill = 1000,
		},		
		
		{-- 56.부드러운깃털(7063)
			Material={{949,"Feather",30},{916,"Feather_Of_Birds",30},},
			Product={{7063,"Soft_Feather",1,200},{7063,"Soft_Feather",1,200},{7063,"Soft_Feather",1,100},},   
			RandomPermill = 1000,
		},
		
		{-- 57.윈드오브버듀어(992)
			Material={{7066,"Ice_Piece",100},},
			Product={{992,"Wind_Of_Verdure",1,500},{992,"Wind_Of_Verdure",1,500},},   
			RandomPermill = 1000,
		},
		
		{-- 58.크리스탈블루(991)
			Material={{920,"Claw_Of_Wolves",100},},
			Product={{991,"Crystal_Blue",1,500},{991,"Crystal_Blue",1,500},},   
			RandomPermill = 1000,
		},
		
		{-- 59.부드러운비단천(7166)
			Material={{1059,"Transparent_Cloth",10},},
			Product={{7166,"Soft_Silk_Cloth",2,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 60.투명한천조각(1059)
			Material={{7166,"Soft_Silk_Cloth",2},},
			Product={{1059,"Transparent_Cloth",5,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 61.Boost500_To_Throw(13269)
			Material={{1093,"Empty_Potion",10},{12417,"Boost500",10},{7200,"Flexible_String",10},},
			Product={{13269,"Boost500_To_Throw",5,500},{13269,"Boost500_To_Throw",2,250},{13269,"Boost500_To_Throw",1,100},},   
			RandomPermill = 1000,
		},
		
		{-- 62.Full_SwingK_To_Throw(13270)
			Material={{1093,"Empty_Potion",10},{12418,"Full_SwingK",10},{7200,"Flexible_String",10},},
			Product={{13270,"Full_SwingK_To_Throw",5,500},{13270,"Full_SwingK_To_Throw",2,250},{13270,"Full_SwingK_To_Throw",1,100},},   
			RandomPermill = 1000,
		},
		
		
		{-- 63.Mana_Plus_To_Throw(13271)
			Material={{1093,"Empty_Potion",10},{12419,"Mana_Plus",10},{7200,"Flexible_String",10},},
			Product={{13271,"Mana_Plus_To_Throw",5,500},{13271,"Mana_Plus_To_Throw",2,250},{13271,"Mana_Plus_To_Throw",1,100},},   
			RandomPermill = 1000,
		},
		
		{-- 64.Cure_Free_To_Throw(13272)
			Material={{1093,"Empty_Potion",10},{12475,"Cure_Free",10},{7200,"Flexible_String",10},},
			Product={{13272,"Cure_Free_To_Throw",5,500},{13272,"Cure_Free_To_Throw",2,250},{13272,"Cure_Free_To_Throw",1,100},},   
			RandomPermill = 1000,
		},
		
		{-- 65.Stamina_Up_M_To_Throw(13273)
			Material={{1093,"Empty_Potion",10},{12420,"Stamina_Up_M",10},{7200,"Flexible_String",10},},
			Product={{13273,"Stamina_Up_M_To_Throw",5,500},{13273,"Stamina_Up_M_To_Throw",2,250},{13273,"Stamina_Up_M_To_Throw",1,100},},   
			RandomPermill = 1000,
		},
		
		{-- 66.Digestive_F_To_Throw(13274)
			Material={{1093,"Empty_Potion",10},{12421,"Digestive_F",10},{7200,"Flexible_String",10},},
			Product={{13274,"Digestive_F_To_Throw",5,500},{13274,"Digestive_F_To_Throw",2,250},{13274,"Digestive_F_To_Throw",1,100},},   
			RandomPermill = 1000,
		},
		
		{-- 67.HP_Inc_PotS_To_Throw(13275)
			Material={{6297,"Bottle_To_Throw",10},{12422,"HP_Increase_PotionS",10},},
			Product={{13275,"HP_Inc_PotS_To_Throw",10,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 68.HP_Inc_PotM_To_Throw(13276)
			Material={{6297,"Bottle_To_Throw",10},{12423,"HP_Increase_PotionM",10},},
			Product={{13276,"HP_Inc_PotM_To_Throw",10,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 69.HP_Inc_PotL_To_Throw(13277)
			Material={{6297,"Bottle_To_Throw",10},{12424,"HP_Increase_PotionL",10},},
			Product={{13277,"HP_Inc_PotL_To_Throw",10,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 70.SP_Inc_PotS_To_Throw(13278)
			Material={{6297,"Bottle_To_Throw",10},{12425,"SP_Increase_PotionS",10},},
			Product={{13278,"SP_Inc_PotS_To_Throw",10,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 71.SP_Inc_PotM_To_Throw(13279)
			Material={{6297,"Bottle_To_Throw",10},{12426,"SP_Increase_PotionM",10},},
			Product={{13279,"SP_Inc_PotM_To_Throw",10,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 72.SP_Inc_PotL_To_Throw(13280)
			Material={{6297,"Bottle_To_Throw",10},{12427,"SP_Increase_PotionL",10},},
			Product={{13280,"SP_Inc_PotL_To_Throw",10,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 73.En_White_PotZ_To_Throw(13281)
			Material={{6297,"Bottle_To_Throw",10},{12428,"Enrich_White_PotionZ",10},},
			Product={{13281,"En_White_PotZ_To_Throw",10,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 74.Vitata500_To_Throw(13282)
			Material={{6297,"Bottle_To_Throw",10},{12436,"Vitata500",10},},
			Product={{13282,"Vitata500_To_Throw",10,1000},},   
			RandomPermill = 1000,
		},
		
		{-- 75.En_Cel_Juice_To_Throw(13283)
			Material={{6297,"Bottle_To_Throw",10},{12437,"Enrich_Celermine_Juice",10},},
			Product={{13283,"En_Cel_Juice_To_Throw",10,1000},},   
			RandomPermill = 1000,
		},	
		
	};		
	
	for k,v in pairs(tbl) do
		result,msg = InsertRecipe(v.Material,v.Product,v.RandomPermill);
		if( not result) then return false,msg; end		
	end	
	
	return true,"Success";
end

