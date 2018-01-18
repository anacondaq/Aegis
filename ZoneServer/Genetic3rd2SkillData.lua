
-- 이파일은 lua 문법에 따라 작성해야 합니다.
-- 이 파일은 믹스쿠킹 스킬 설정파일 입니다.
-- Select * from script_compare1.dbo.viewitemlist where id  in ( )

function MixCooking()
	
	-- 믹스쿠킹 레시피	
	RecipeTbl={
		{--Savage_BBQ(12429)
			Manual	 = {11022,"Mix_Cook_Book",1},
			Material = {{6248,"Melange_Pot",1},
			            {6249,"Savage_Meat",1},
			            {6250,"Cooking_Skewer",1},
			            {6251,"Black_Charcoal",1},},
			Product  = {12429,"Savage_BBQ",1},
			DifficultFactor = 15,
		},	
		
		{--Wug_Blood_Cocktail(12430)
			Manual	 = {11022,"Mix_Cook_Book",1},
			Material = {{6248,"Melange_Pot",1},
			            {6252,"Wolf_Blood",3},
			            {6253,"Cold_Ice",2},},
			Product  = {12430,"Wug_Blood_Cocktail",1},
			DifficultFactor = 15,
		},
		
		{--Minor_Brisket(12431)
			Manual	 = {11022,"Mix_Cook_Book",1},
			Material = {{6248,"Melange_Pot",1},
			            {6254,"Beef_Head_Meat",2},
			            {6255,"Large_Cookpot",1},},
			Product  = {12431,"Minor_Brisket",1},
			DifficultFactor = 15,
		},	
		
		{--Siroma_Icetea(12432)

			Manual	 = {11022,"Mix_Cook_Book",1},
			Material = {{6248,"Melange_Pot",1},
						{6256,"Ice_Fragment",3},
			            {6257,"Ice_Crystal",2},
			            {6258,"Comodo_Tropic_Fruit",1},},
			Product  = {12432,"Siroma_Icetea",1},
			DifficultFactor = 15,
		},
			
		{-- Drocera_Herb_Stew(12433)

			Manual	 = {11022,"Mix_Cook_Book",1},
			Material = {{6248,"Melange_Pot",1},
						{6259,"Drocera_Tentacle",3},
						{507,"Red_Herb",3},
						{510,"Blue_Herb",3},
						{509,"White_Herb",3},
						{6255,"Large_Cookpot",1},},
			Product  = {12433,"Drocera_Herb_Stew",1},
			DifficultFactor = 15,
		},		
		
		{-- Petti_Tail_Noodle(12434)
			Manual	 = {11022,"Mix_Cook_Book",1},
			Material = {{6248,"Melange_Pot",1},
						{6260,"Petti_Tail",2},
						{6261,"Fine_Noodle",1},
						{6262,"Cool_Gravy",1},},
			Product  = {12434,"Petti_Tail_Noodle",1},
			DifficultFactor = 15,
		},		
	};
	
	for k,v in pairs(RecipeTbl) do	
		result,message = InsertMixCookingRecipe(v.Manual,v.Material,v.Product,v.DifficultFactor);
		if(not result) then return false,message; end
	end
	
	-- 요리 제작 실패시 보상에 관한 메모
	-- {아이디,이름,갯수,확률(천분률)}	
	CompensationMemoTbl={	
		{13265,"Black_Lump",1,500},
		{13266,"Black_Hard_Lump",1,250},
		{13267,"Very_Hard_Lump",1,100},
		{12435,"Black_Thing",1,100},
		{13268,"Mysterious_Powder",1,50},
	};
	
	for k,v in pairs(CompensationMemoTbl) do	
		result,message = InsertMixCookingCompensationMemo(v[1],v[2],v[3],v[4]);
		if(not result) then return false,message; end
	end	
	
	return true,"Success";
end


-- 폭탄제조(SKID_GN_MAKEBOMB)
function Bomb()

	RecipeTbl={
		{--Apple_Bomb(13260)			
			Manual	 = {6279,"Apple_Bomb_CB",1},
			Material = {{512,"Apple",1},
						{911,"Scell",1},
						{6244,"Gun_Powder",1},
					    {1051,"Detonator",1},},
			Product  = {13260,"Apple_Bomb",1},
			DifficultFactor = 5,
		},
		
		{--Coconut_Bomb(13261)			
			Manual	 = {6281,"Coconut_Bomb_CB",1},
			Material = {{6263,"Coconut_Fruit",1},
						{6244,"Gun_Powder",2},
					    {1051,"Detonator",1},},
			Product  = {13261,"Coconut_Bomb",1},
			DifficultFactor = 10,
		},		
			
		{--Melon_Bomb(13262)			
			Manual	 = {6282,"Melon_Bomb_CB",1},
			Material = {{6264,"Melon",1},
						{938,"Sticky_Mucus",1},
						{6244,"Gun_Powder",2},
					    {1051,"Detonator",1},},
			Product  = {13262,"Melon_Bomb",1},
			DifficultFactor = 10,
		},
		
		{--Pineapple_Bomb(13263)			
			Manual	 = {6280,"Pinepple_Bomb_CB",1},
			Material = {{6265,"Pineapple",1},
						{952,"Cactus_Needle",1},
						{6244,"Gun_Powder",3},
					    {1051,"Detonator",1},},
			Product  = {13263,"Pineapple_Bomb",1},
			DifficultFactor = 15,
		},
			
		{--Banana_Bomb(13264)
			Manual	 = {6283,"Banana_Bomb_CB",1},
			Material = {{513,"Banana",1},
						{7001,"Mould_Powder",1},
						{6244,"Gun_Powder",4},
					    {1051,"Detonator",1},},
			Product  = {13264,"Banana_Bomb",1},
			DifficultFactor = 20,
		},		
		
	};
		
	for k,v in pairs(RecipeTbl) do	
		result,message = InsertBombRecipe(v.Manual,v.Material,v.Product,v.DifficultFactor);
		if(not result) then return false,message; end
	end
	
	return true,"Success";
end



-- 스페셜파머시(SKID_GN_S_PHARMACY)
function Pharmacy()

	RecipeTbl={	
		-- Plant_Genetic_Grow(6284)
			{-- Seed_Of_Horny_Plant(6210)
				Manual	 = {6284,"Plant_Genetic_Grow",1},
				Material = {{576,"Prickly_Fruit",10},},
				Product  = {6210,"Seed_Of_Horny_Plant",1},
				DifficultFactor = 30,
			},	
			
			{-- Bloodsuck_Plant_Seed(6211)
				Manual	 = {6284,"Plant_Genetic_Grow",1},			 
				Material = {{1033,"Root_Of_Maneater",10},},
				Product  = {6211,"Bloodsuck_Plant_Seed",1},
				DifficultFactor = 30,
			},	
			
			{-- Bomb_Mushroom_Spore(6212)
				Manual	 = {6284,"Plant_Genetic_Grow",1},			
				Material = {{921,"Mushroom_Spore",10},
							{7033,"Poison_Spore",5},
							{6244,"Gun_Powder",2},},
				Product  = {6212,"Bomb_Mushroom_Spore",1},
				DifficultFactor = 15,
			},	
		
		
		-- Increase_Stamina_Study(11023)	
			{-- HP_Increase_PotionS(12422)
				Manual	 = {11023,"Increase_Stamina_Study",1},
				Material = {{713,"Empty_Bottle",10},
							{528,"Monster's_Feed",5},
							{509,"White_Herb",10},
							{7455,"Hot_Sauce",1},},
				Product  = {12422,"HP_Increase_PotionS",1},
				DifficultFactor = 10,
			},	
			
			{-- HP_Increase_PotionM(12423)
				Manual	 = {11023,"Increase_Stamina_Study",1},
				Material = {{713,"Empty_Bottle",10},
							{508,"Yellow_Herb",10},
							{509,"White_Herb",10},
							{7455,"Hot_Sauce",1},},
				Product  = {12423,"HP_Increase_PotionM",1},
				DifficultFactor = 20,
			},	
			
			{-- HP_Increase_PotionL(12424)
				Manual	 = {11023,"Increase_Stamina_Study",1},				
				Material = {{713,"Empty_Bottle",10},
							{509,"White_Herb",15},
							{522,"Fruit_Of_Mastela",3},
							{523,"Holy_Water",1},
							{7455,"Hot_Sauce",1},},
				Product  = {12424,"HP_Increase_PotionL",1},
				DifficultFactor = 40,
			},
			
			
		-- Vital_Drink_CB(11024)
			{-- SP_Increase_PotionS(12425)
				Manual	 = {11024,"Vital_Drink_CB",1},
				Material = {{713,"Empty_Bottle",10},
							{568,"Lemon",10},
							{514,"Grape",10},
							{7453,"Sweet_Sauce",1},},
				Product  = {12425,"SP_Increase_PotionS",1},
				DifficultFactor = 10,
			},
			{-- SP_Increase_PotionM(12426)
				Manual	 = {11024,"Vital_Drink_CB",1},
				Material = {{713,"Empty_Bottle",10},
							{518,"Honey",10},
							{510,"Blue_Herb",10},
							{7453,"Sweet_Sauce",1},},
				Product  = {12426,"SP_Increase_PotionM",1},
				DifficultFactor = 15,
			},
			{-- SP_Increase_PotionL(12427)
				Manual	 = {11024,"Vital_Drink_CB",1},
				Material = {{713,"Empty_Bottle",10},
							{526,"Royal_Jelly",10},
							{510,"Blue_Herb",15},
							{7453,"Sweet_Sauce",1},},
				Product  = {12427,"SP_Increase_PotionL",1},
				DifficultFactor = 20,
			},
			
		-- Quality_Potion_Book(6285)
			{-- Enrich_White_PotionZ(12428)
				Manual	 = {6285,"Quality_Potion_Book",1},
				Material = {{1092,"Empty_Cylinder",10},
							{504,"White_Potion",20},
							{509,"White_Herb",10},
							{970,"Alchol",1},},
				Product  = {12428,"Enrich_White_PotionZ",1},
				DifficultFactor = 10,
			},
			
			{-- Vitata500(12436)
				Manual	 = {6285,"Quality_Potion_Book",1},
				Material = {{1092,"Empty_Cylinder",10},
							{514,"Grape",10},
							{518,"Honey",10},
							{510,"Blue_Herb",10},},
				Product  = {12436,"Vitata500",1},
				DifficultFactor = 20,
			},
			
			{-- Enrich_Celermine_Juice(12437)
				Manual	 = {6285,"Quality_Potion_Book",1},
				Material = {{1092,"Empty_Cylinder",10},
							{656,"Awakening_Potion",5},
							{645,"Center_Potion",5},
							{7455,"Hot_Sauce",5},},
				Product  = {12437,"Enrich_Celermine_Juice",1},
				DifficultFactor = 30,
			},
			
			{-- 큐어프리(12475)
				Manual	 = {6285,"Quality_Potion_Book",1},
				Material = {{1092,"Empty_Cylinder",10},
							{525,"Panacea",5},
							{511,"Green_Herb",20},
							{522,"Fruit_Of_Mastela",1},
							{610,"Leaf_Of_Yggdrasil",1},},
				Product  = {12475,"Cure_Free",1},
				DifficultFactor = 40,
			},
			
			
	};
		
	for k,v in pairs(RecipeTbl) do	
		result,message = InsertPharmacyRecipe(v.Manual,v.Material,v.Product,v.DifficultFactor);
		if(not result) then return false,message; end
	end
	
	return true,"Success";
end





function main()	
	
	-- 믹스쿠킹(SKID_GN_MIX_COOKING)관련 설정
	result,msg = MixCooking();
	if not result then return result,msg; end
	
	-- 폭탄제조(SKID_GN_MAKEBOMB)관련 설정
	result,msg = Bomb();
	if not result then return result,msg; end
	
	-- 스페셜 파머시(SKID_GN_S_PHARMACY)
	result,msg = Pharmacy();
	if not result then return result,msg; end
	
	return true,"Success";
end




--빨간포션 501
--산호초 7013
--새싹 711
--상한Apple쥬스 7708
--빨간허브 507
--강철 999
--젤로피 909
--스틸레토 1216
--버클러 2103
--에르늄 985
--플레이트 2316