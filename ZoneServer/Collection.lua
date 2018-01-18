-- ä������ ���� --

-- 1. ��� ���õ� PetTable.txt ������ �̿��Ͽ� ä������Ʈ�� �����Ͽ��µ� ä���κ��� �и��մϴ�.
-- 2. ä���� ���� ���� ������ ����������_1�� Ȯ���� ���մϴ�.
-- 3. ����
-- 3.1 [ [[ä�� �Ϸ��� ����]] ] - ��������Ʈ��
-- 3.2 ä���� �Ҹ� ������( ConsumeItem )
-- 3.3 ����������_1( CreateItem_1 )
-- 3.4 ����������_1�� Ȯ��( Random_1 )
-- 3.5 ����������_2( CreateItem_2 )
-- 3.6 ����������_2�� Ȯ��( Random_2 )
-- 3.7 ����������_3( CreateItem_3 )
-- 3.8 ����������_3�� Ȯ��( Random_3 )
-- 4. ��ũ��Ʈ��ɾ�( StartCollection )
--  4.1 ex) StartCollection ����Ĺ��


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