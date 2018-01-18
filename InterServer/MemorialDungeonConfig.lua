

--///////////////////////////////////////////////////////////////////////
-- Title  : 
-- Desc   : 
-- Author : InGeon, Kim (Prgram/RO1/Gravity)
-- Date   : 2011/12/21
--///////////////////////////////////////////////////////////////////////


--/////////////////////////////////////////////////////////////////
--// 
--/////////////////////////////////////////////////////////////////

	MaximumZoneResourceMemory		= 1800;		--// 
	EnterLimitMinute				= 5;		--// 
	SubscriptionMinimumDelaySecond	= 60;		--// 
	DatabaseLogOutput				= 1;		--// 
	Open							= 1;		--// 



--/////////////////////////////////////////////////////////////////
--//
--/////////////////////////////////////////////////////////////////

function EndlessTower()

	RegisterMemorialDungeon( [[Endless Tower]] );
	InsertMDMap( [[Endless Tower]], [[1@tower.gat]], 20 );
	InsertMDMap( [[Endless Tower]], [[2@tower.gat]], 20 );
	InsertMDMap( [[Endless Tower]], [[3@tower.gat]], 20 );
	InsertMDMap( [[Endless Tower]], [[4@tower.gat]], 20 );
	InsertMDMap( [[Endless Tower]], [[5@tower.gat]], 20 );
	InsertMDMap( [[Endless Tower]], [[6@tower.gat]], 20 );
	InsertMDLiveTimeMinute( [[Endless Tower]], 240 );
	InsertMDEnterMap( [[Endless Tower]], [[1@tower.gat]], 50, 355 );

	return true, "good"

end

function Sealed_Catacom()

	RegisterMemorialDungeon( [[Sealed Catacom]] );
	InsertMDMap( [[Sealed Catacom]], [[1@cata.gat]], 21 );
	InsertMDMap( [[Sealed Catacom]], [[2@cata.gat]], 21 );
	InsertMDLiveTimeMinute( [[Sealed Catacom]], 120 );
	InsertMDEnterMap( [[Sealed Catacom]], [[1@cata.gat]], 100, 224 );

	return true, "good"

end

function Memories_of_Ork()

	RegisterMemorialDungeon( [[Orc's Memory]] );
	InsertMDMap( [[Orc's Memory]], [[1@orcs.gat]], 20 );
	InsertMDMap( [[Orc's Memory]], [[2@orcs.gat]], 20 );
	InsertMDLiveTimeMinute( [[Orc's Memory]], 120 );
	InsertMDEnterMap( [[Orc's Memory]], [[1@orcs.gat]], 179, 15 );

	return true, "good"

end

function Nest_of_Nyd()

	RegisterMemorialDungeon( [[Nydhorg's nest]] );
	InsertMDMap( [[Nydhorg's nest]], [[1@nyd.gat]], 20 );
	InsertMDMap( [[Nydhorg's nest]], [[2@nyd.gat]], 20 );
	InsertMDLiveTimeMinute( [[Nydhorg's nest]], 240 );
	InsertMDEnterMap( [[Nydhorg's nest]], [[1@nyd.gat]], 32, 36 );

	return true, "good"
end

function Octopus_Cave()

	RegisterMemorialDungeon( [[章魚洞穴]] );
	InsertMDMap( [[章魚洞穴]], [[1@cash.gat]], 20 );
	InsertMDLiveTimeMinute( [[章魚洞穴]], 60 );
	InsertMDEnterMap( [[章魚洞穴]], [[1@cash.gat]], 199, 99 );

	return true, "good"
end

function memorial1()

	RegisterMemorialDungeon( [[霧林迷宮]] );
	InsertMDMap( [[霧林迷宮]], [[1@mist.gat]], 20 );
	InsertMDLiveTimeMinute( [[霧林迷宮]], 120 );
	InsertMDEnterMap( [[霧林迷宮]], [[1@mist.gat]], 89,29 );

	return true, "good"
end

function memorial2()

	RegisterMemorialDungeon( [[地下排水溝]] );
	InsertMDMap( [[地下排水溝]], [[1@pump.gat]], 20 );
	InsertMDMap( [[地下排水溝]], [[2@pump.gat]], 20 );
	InsertMDLiveTimeMinute( [[地下排水溝]], 60 );
	InsertMDEnterMap( [[地下排水溝]], [[1@pump.gat]], 63,98 );

	return true, "good"
end

function memorial3()

	RegisterMemorialDungeon( [[保羅協夫研究室]] );
	InsertMDMap( [[保羅協夫研究室]], [[1@lhz.gat]], 20 );
	InsertMDLiveTimeMinute( [[保羅協夫研究室]], 240 );
	InsertMDEnterMap( [[保羅協夫研究室]], [[1@lhz.gat]], 45,148 );

	return true, "good"
end

function memorial4()

	RegisterMemorialDungeon( [[噩夢死神]] );
	InsertMDMap( [[噩夢死神]], [[1@ma_h.gat]], 20 );
	InsertMDLiveTimeMinute( [[噩夢死神]], 60 );
	InsertMDEnterMap( [[噩夢死神]], [[1@ma_h.gat]], 40,157 );

	return true, "good"
end

function memorial5()

	RegisterMemorialDungeon( [[巴庫暴龍]] );
	InsertMDMap( [[巴庫暴龍]], [[1@ma_b.gat]], 20 );
	InsertMDLiveTimeMinute( [[巴庫暴龍]], 120 );
	InsertMDEnterMap( [[巴庫暴龍]], [[1@ma_b.gat]], 64,51 );

	return true, "good"
end

function memorial6()

	RegisterMemorialDungeon( [[寶箱巨鱷]] );
	InsertMDMap( [[寶箱巨鱷]], [[1@ma_c.gat]], 20 );
	InsertMDLiveTimeMinute( [[寶箱巨鱷]], 60 );
	InsertMDEnterMap( [[寶箱巨鱷]], [[1@ma_c.gat]], 35,57 );

	return true, "good"
end
--// 詭賅葬橡 湍蟒 : 縑贗塭鍬 頂睡
function memorial7()

	RegisterMemorialDungeon( [[埃克拉珠內部]] );
	InsertMDMap( [[埃克拉珠內部]], [[1@ecl.gat]], 20 );
	InsertMDLiveTimeMinute( [[埃克拉珠內部]], 20 );
	InsertMDEnterMap( [[埃克拉珠內部]], [[1@ecl.gat]], 60,50 );

	return true, "good"
end
function memorial8()

	RegisterMemorialDungeon( [[舊克雷斯特漢姆古城]] );
	InsertMDMap( [[舊克雷斯特漢姆古城]], [[1@gl_k.gat]], 20 );
	InsertMDMap( [[舊克雷斯特漢姆古城]], [[2@gl_k.gat]], 20 );
	InsertMDLiveTimeMinute( [[舊克雷斯特漢姆古城]], 60 );
	InsertMDEnterMap( [[舊克雷斯特漢姆古城]], [[1@gl_k.gat]], 150,20 );

	return true, "good"
end

function memorial10()

	RegisterMemorialDungeon( [[莎拉的記憶]] )
	InsertMDMap( [[莎拉的記憶]], [[1@sara.gat]], 20 )
	InsertMDLiveTimeMinute( [[莎拉的記憶]], 60 )
	InsertMDEnterMap( [[莎拉的記憶]], [[1@sara.gat]], 250,155 )

	return true, "good"
end



function memorial11()

	RegisterMemorialDungeon( [[驚駭森靈巢穴]] )
	InsertMDMap( [[驚駭森靈巢穴]], [[1@face.gat]], 20 )
	InsertMDLiveTimeMinute( [[驚駭森靈巢穴]], 60 )
	InsertMDEnterMap( [[驚駭森靈巢穴]], [[1@face.gat]], 112,370 )

	return true, "good"
end

function memorial13()

	RegisterMemorialDungeon( [[吉芬魔法大賽]] )
	InsertMDMap( [[吉芬魔法大賽]], [[1@ge_st.gat]], 20 )
	InsertMDMap( [[吉芬魔法大賽]], [[1@gef_in.gat]], 20 )
	InsertMDMap( [[吉芬魔法大賽]], [[1@gef.gat]], 20 )
	InsertMDLiveTimeMinute( [[吉芬魔法大賽]], 120 )
	InsertMDEnterMap( [[吉芬魔法大賽]], [[1@gef.gat]], 119,209 )

	return true, "good"
end

function memorial14()

	RegisterMemorialDungeon( [[幽靈皇宮]] )
	InsertMDMap( [[幽靈皇宮]], [[1@spa.gat]], 20 )
	InsertMDLiveTimeMinute( [[幽靈皇宮]], 60 )
	InsertMDEnterMap( [[幽靈皇宮]], [[1@spa.gat]], 42,196 )

	return true, "good"
end

 function tower_of_morocc()

	RegisterMemorialDungeon( [[魔神之塔]] )
	InsertMDMap( [[魔神之塔]], [[1@tnm1.gat]], 20 )
	InsertMDMap( [[魔神之塔]], [[1@tnm2.gat]], 20 )
	InsertMDMap( [[魔神之塔]], [[1@tnm3.gat]], 20 )
	InsertMDLiveTimeMinute( [[魔神之塔]], 60 )
	InsertMDEnterMap( [[魔神之塔]], [[1@tnm1.gat]], 50, 104 )

	return true, "good"
end

function memorial15()

	RegisterMemorialDungeon( [[恐怖玩具工廠]] )
	InsertMDMap( [[恐怖玩具工廠]], [[1@xm_d.gat]], 20 )
	InsertMDLiveTimeMinute( [[恐怖玩具工廠]], 60 )
	InsertMDEnterMap( [[恐怖玩具工廠]], [[1@xm_d.gat]], 111,22 )

	return true, "good"
end

function memorial16()

	RegisterMemorialDungeon( [[拜歐斯島]] )
	InsertMDMap( [[拜歐斯島]], [[1@dth1.gat]], 20 )
	InsertMDMap( [[拜歐斯島]], [[1@dth2.gat]], 20 )
	InsertMDMap( [[拜歐斯島]], [[1@dth3.gat]], 20 )
	InsertMDLiveTimeMinute( [[拜歐斯島]], 60 )
	InsertMDEnterMap( [[拜歐斯島]], [[1@dth1.gat]], 17, 93 )

	return true, "good"
end

function memorial17()

	RegisterMemorialDungeon( [[魔神殿]] )
	InsertMDMap( [[魔神殿]], [[1@eom.gat]], 20 )
	InsertMDLiveTimeMinute( [[魔神殿]], 60 )
	InsertMDEnterMap( [[魔神殿]], [[1@eom.gat]], 101,16 )

	return true, "good"
end

function memorial18()

	RegisterMemorialDungeon( [[噩夢吉特巴]] )
	InsertMDMap( [[噩夢吉特巴]], [[1@jtb.gat]], 20 )
	InsertMDLiveTimeMinute( [[噩夢吉特巴]], 60 )
	InsertMDEnterMap( [[噩夢吉特巴]], [[1@jtb.gat]], 16,17 )

	return true, "good"
end

function memorial19()
	RegisterMemorialDungeon( [[摩洛斯洞穴]] )
	InsertMDMap( [[摩洛斯洞穴]], [[1@rev.gat]], 20 )
	InsertMDLiveTimeMinute( [[摩洛斯洞穴]], 60 )
	InsertMDEnterMap( [[摩洛斯洞穴]], [[1@rev.gat]], 26,181 )

	return true, "good"
end

function memorial20()
	RegisterMemorialDungeon( [[危機的查理斯頓]] )
	InsertMDMap( [[危機的查理斯頓]], [[1@mcd.gat]], 20 )
	InsertMDLiveTimeMinute( [[危機的查理斯頓]], 60 )
	InsertMDEnterMap( [[危機的查理斯頓]], [[1@mcd.gat]], 127, 282 )

	return true, "good"
end


function memorial21()
	RegisterMemorialDungeon( [[中央實驗室]] )
	InsertMDMap( [[中央實驗室]], [[1@lab.gat]], 20 )
	InsertMDLiveTimeMinute( [[中央實驗室]], 60 )
	InsertMDEnterMap( [[中央實驗室]], [[1@lab.gat]], 120,30 )

	return true, "good"
end

function memorial22()
	RegisterMemorialDungeon( [[最後房間]] )
	InsertMDMap( [[最後房間]], [[1@uns.gat]], 20 )
	InsertMDLiveTimeMinute( [[最後房間]], 60 )
	InsertMDEnterMap( [[最後房間]], [[1@uns.gat]], 145,35 )

	return true, "good"
end

function memorial23()
	RegisterMemorialDungeon( [[潘利爾和莎拉]] )
	InsertMDMap( [[潘利爾和莎拉]], [[1@glast.gat]], 20 )
	InsertMDLiveTimeMinute( [[潘利爾和莎拉]], 60 )
	InsertMDEnterMap( [[潘利爾和莎拉]], [[1@glast.gat]], 367,304 )

	return true, "good"
end


function memorial24()

	RegisterMemorialDungeon( [[飛空艇襲擊]] )
	InsertMDMap( [[飛空艇襲擊]], [[1@air1.gat]], 20 )
	InsertMDMap( [[飛空艇襲擊]], [[1@air2.gat]], 20 )
	InsertMDLiveTimeMinute( [[飛空艇襲擊]], 60 )
	InsertMDEnterMap( [[飛空艇襲擊]], [[1@air1.gat]], 244,73 )

	return true, "good"
end

--// 
function MemorialDungeon()

	EndlessTower();
	Sealed_Catacom();
	Memories_of_Ork();
	Nest_of_Nyd();
	Octopus_Cave();
	memorial1();
	memorial2();
	memorial3();
	memorial4();
	memorial5();
	memorial6();
	memorial7();
	memorial8();	
	memorial10();	
	memorial11();	
	memorial13();	
	memorial14();	
	memorial15();
	memorial16();
	memorial17();
	memorial18();
	memorial19();
	memorial20();
	memorial21();
	memorial22();
	memorial23();
	memorial24();
	tower_of_morocc();
	return true, "good"

end


--/////////////////////////////////////////////////////////////////
--// 
--/////////////////////////////////////////////////////////////////

function main()

	result, msg = SetBaseConfig( MaximumZoneResourceMemory,
								 EnterLimitMinute,
								 SubscriptionMinimumDelaySecond,
								 DatabaseLogOutput,
								 Open );
	if( not result ) then	return false, msg; end

	result, msg = MemorialDungeon();
	if( not result ) then	return false, msg; end

	return true, msg;

end
