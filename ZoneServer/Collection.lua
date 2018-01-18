-- 채집관련 파일 --

-- 1. 펫과 관련된 PetTable.txt 파일을 이용하여 채집퀘스트를 진행하였는데 채집부분을 분리합니다.
-- 2. 채집의 성공 실패 유무는 생성아이템_1의 확률로 정합니다.
-- 3. 구조
-- 3.1 [ [[채집 하려는 몬스터]] ] - 스프라이트명
-- 3.2 채집용 소모 아이템( ConsumeItem )
-- 3.3 생성아이템_1( CreateItem_1 )
-- 3.4 생성아이템_1의 확률( Random_1 )
-- 3.5 생성아이템_2( CreateItem_2 )
-- 3.6 생성아이템_2의 확률( Random_2 )
-- 3.7 생성아이템_3( CreateItem_3 )
-- 3.8 생성아이템_3의 확률( Random_3 )
-- 4. 스크립트명령어( StartCollection )
--  4.1 ex) StartCollection 리프캣볼


CollectionTBL = 
{
	[ [[E_CRAMP]] ] = { ConsumeItem = [[Leaf_Cat_Ball]], CreateItem_1 = [[Mystic_Leaf_Cat_Ball]], Random_1 = 100, CreateItem_2 = [[Green_Herb]], Random_2 = 5, CreateItem_3 = [[Jellopy]], Random_3 = 1 },
	[ [[E_SHINING_PLANT]] ] = { ConsumeItem = [[Empty_Potion_Bottle]], CreateItem_1 = [[Magic_Potion_Bottle]], Random_1 = 100, CreateItem_2 = [[Green_Herb]], Random_2 = 5, CreateItem_3 = [[White_Herb]], Random_3 = 1 },
	[ [[LOST_LAMB]] ] = { ConsumeItem = [[Binding_Rope]], CreateItem_1 = [[Captured_Sheep]], Random_1 = 100, CreateItem_2 = [[Jellopy]], Random_2 = 1, CreateItem_3 = [[Green_Herb]], Random_3 = 1  },
	[ [[SAVAGE]] ] = { ConsumeItem = [[Savage_Ora]], CreateItem_1 = [[Savage_Box]], Random_1 = 50, CreateItem_2 = [[Animal's_Skin]], Random_2 = 10, CreateItem_3 = [[Animal_Blood]], Random_3 = 1 },			
	[ [[GRAND_PECO]] ] = { ConsumeItem = [[Grand_Peco_Ora]], CreateItem_1 = [[Grand_Peco_Box]], Random_1 = 50, CreateItem_2 = [[Orange]], Random_2 = 7, CreateItem_3 = [[Peco_Wing_Feather]], Random_3 = 3 },			
	[ [[DESERT_WOLF]] ] = { ConsumeItem = [[Dest_Wolf_Ora]], CreateItem_1 = [[Desert_Wolf_Box]], Random_1 = 50, CreateItem_2 = [[Claw_Of_Desert_Wolf]], Random_2 = 7, CreateItem_3 = [[Wolf_Blood]], Random_3 = 3 },
	[ [[BOMBPORING]] ] = { ConsumeItem = [[Explosion_Proof_Equip]], CreateItem_1 = [[Ice_Bomb]], Random_1 = 100, CreateItem_2 = [[Jellopy]], Random_2 = 1, CreateItem_3 = [[Jellopy]], Random_3 = 1 },							
	[ [[MOON_RABBIT]] ] = { ConsumeItem = [[Capture_Rope]], CreateItem_1 = [[Captured_MRabbit]], Random_1 = 100, CreateItem_2 = [[MRabbit_Hair]], Random_2 = 50, CreateItem_3 = [[MRabbit_SHair]], Random_3 = 10},
};

function main()

	for key, value in pairs(CollectionTBL) do
		result, msg = InsertTBL(key, value.ConsumeItem, value.CreateItem_1, value.Random_1, value.CreateItem_2, value.Random_2, value.CreateItem_3, value.Random_3);

		if( not result ) then 
			return false, msg;
		end
	end

	return true, "success";
end