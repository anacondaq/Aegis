

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

	RegisterMemorialDungeon( [[�����}��]] );
	InsertMDMap( [[�����}��]], [[1@cash.gat]], 20 );
	InsertMDLiveTimeMinute( [[�����}��]], 60 );
	InsertMDEnterMap( [[�����}��]], [[1@cash.gat]], 199, 99 );

	return true, "good"
end

function memorial1()

	RegisterMemorialDungeon( [[���L�g�c]] );
	InsertMDMap( [[���L�g�c]], [[1@mist.gat]], 20 );
	InsertMDLiveTimeMinute( [[���L�g�c]], 120 );
	InsertMDEnterMap( [[���L�g�c]], [[1@mist.gat]], 89,29 );

	return true, "good"
end

function memorial2()

	RegisterMemorialDungeon( [[�a�U�Ƥ���]] );
	InsertMDMap( [[�a�U�Ƥ���]], [[1@pump.gat]], 20 );
	InsertMDMap( [[�a�U�Ƥ���]], [[2@pump.gat]], 20 );
	InsertMDLiveTimeMinute( [[�a�U�Ƥ���]], 60 );
	InsertMDEnterMap( [[�a�U�Ƥ���]], [[1@pump.gat]], 63,98 );

	return true, "good"
end

function memorial3()

	RegisterMemorialDungeon( [[�Où��Ҭ�s��]] );
	InsertMDMap( [[�Où��Ҭ�s��]], [[1@lhz.gat]], 20 );
	InsertMDLiveTimeMinute( [[�Où��Ҭ�s��]], 240 );
	InsertMDEnterMap( [[�Où��Ҭ�s��]], [[1@lhz.gat]], 45,148 );

	return true, "good"
end

function memorial4()

	RegisterMemorialDungeon( [[���ڦ���]] );
	InsertMDMap( [[���ڦ���]], [[1@ma_h.gat]], 20 );
	InsertMDLiveTimeMinute( [[���ڦ���]], 60 );
	InsertMDEnterMap( [[���ڦ���]], [[1@ma_h.gat]], 40,157 );

	return true, "good"
end

function memorial5()

	RegisterMemorialDungeon( [[�ڮw���s]] );
	InsertMDMap( [[�ڮw���s]], [[1@ma_b.gat]], 20 );
	InsertMDLiveTimeMinute( [[�ڮw���s]], 120 );
	InsertMDEnterMap( [[�ڮw���s]], [[1@ma_b.gat]], 64,51 );

	return true, "good"
end

function memorial6()

	RegisterMemorialDungeon( [[�_�c���s]] );
	InsertMDMap( [[�_�c���s]], [[1@ma_c.gat]], 20 );
	InsertMDLiveTimeMinute( [[�_�c���s]], 60 );
	InsertMDEnterMap( [[�_�c���s]], [[1@ma_c.gat]], 35,57 );

	return true, "good"
end
--// �޸𸮾� ���� : ��Ŭ���� ����
function memorial7()

	RegisterMemorialDungeon( [[�J�J�ԯ]����]] );
	InsertMDMap( [[�J�J�ԯ]����]], [[1@ecl.gat]], 20 );
	InsertMDLiveTimeMinute( [[�J�J�ԯ]����]], 20 );
	InsertMDEnterMap( [[�J�J�ԯ]����]], [[1@ecl.gat]], 60,50 );

	return true, "good"
end
function memorial8()

	RegisterMemorialDungeon( [[�§J�p���S�~�i�j��]] );
	InsertMDMap( [[�§J�p���S�~�i�j��]], [[1@gl_k.gat]], 20 );
	InsertMDMap( [[�§J�p���S�~�i�j��]], [[2@gl_k.gat]], 20 );
	InsertMDLiveTimeMinute( [[�§J�p���S�~�i�j��]], 60 );
	InsertMDEnterMap( [[�§J�p���S�~�i�j��]], [[1@gl_k.gat]], 150,20 );

	return true, "good"
end

function memorial10()

	RegisterMemorialDungeon( [[��Ԫ��O��]] )
	InsertMDMap( [[��Ԫ��O��]], [[1@sara.gat]], 20 )
	InsertMDLiveTimeMinute( [[��Ԫ��O��]], 60 )
	InsertMDEnterMap( [[��Ԫ��O��]], [[1@sara.gat]], 250,155 )

	return true, "good"
end



function memorial11()

	RegisterMemorialDungeon( [[���b���F�_��]] )
	InsertMDMap( [[���b���F�_��]], [[1@face.gat]], 20 )
	InsertMDLiveTimeMinute( [[���b���F�_��]], 60 )
	InsertMDEnterMap( [[���b���F�_��]], [[1@face.gat]], 112,370 )

	return true, "good"
end

function memorial13()

	RegisterMemorialDungeon( [[�N���]�k�j��]] )
	InsertMDMap( [[�N���]�k�j��]], [[1@ge_st.gat]], 20 )
	InsertMDMap( [[�N���]�k�j��]], [[1@gef_in.gat]], 20 )
	InsertMDMap( [[�N���]�k�j��]], [[1@gef.gat]], 20 )
	InsertMDLiveTimeMinute( [[�N���]�k�j��]], 120 )
	InsertMDEnterMap( [[�N���]�k�j��]], [[1@gef.gat]], 119,209 )

	return true, "good"
end

function memorial14()

	RegisterMemorialDungeon( [[���F�Ӯc]] )
	InsertMDMap( [[���F�Ӯc]], [[1@spa.gat]], 20 )
	InsertMDLiveTimeMinute( [[���F�Ӯc]], 60 )
	InsertMDEnterMap( [[���F�Ӯc]], [[1@spa.gat]], 42,196 )

	return true, "good"
end

 function tower_of_morocc()

	RegisterMemorialDungeon( [[�]������]] )
	InsertMDMap( [[�]������]], [[1@tnm1.gat]], 20 )
	InsertMDMap( [[�]������]], [[1@tnm2.gat]], 20 )
	InsertMDMap( [[�]������]], [[1@tnm3.gat]], 20 )
	InsertMDLiveTimeMinute( [[�]������]], 60 )
	InsertMDEnterMap( [[�]������]], [[1@tnm1.gat]], 50, 104 )

	return true, "good"
end

function memorial15()

	RegisterMemorialDungeon( [[���ƪ���u�t]] )
	InsertMDMap( [[���ƪ���u�t]], [[1@xm_d.gat]], 20 )
	InsertMDLiveTimeMinute( [[���ƪ���u�t]], 60 )
	InsertMDEnterMap( [[���ƪ���u�t]], [[1@xm_d.gat]], 111,22 )

	return true, "good"
end

function memorial16()

	RegisterMemorialDungeon( [[���ڴ��q]] )
	InsertMDMap( [[���ڴ��q]], [[1@dth1.gat]], 20 )
	InsertMDMap( [[���ڴ��q]], [[1@dth2.gat]], 20 )
	InsertMDMap( [[���ڴ��q]], [[1@dth3.gat]], 20 )
	InsertMDLiveTimeMinute( [[���ڴ��q]], 60 )
	InsertMDEnterMap( [[���ڴ��q]], [[1@dth1.gat]], 17, 93 )

	return true, "good"
end

function memorial17()

	RegisterMemorialDungeon( [[�]����]] )
	InsertMDMap( [[�]����]], [[1@eom.gat]], 20 )
	InsertMDLiveTimeMinute( [[�]����]], 60 )
	InsertMDEnterMap( [[�]����]], [[1@eom.gat]], 101,16 )

	return true, "good"
end

function memorial18()

	RegisterMemorialDungeon( [[���ڦN�S��]] )
	InsertMDMap( [[���ڦN�S��]], [[1@jtb.gat]], 20 )
	InsertMDLiveTimeMinute( [[���ڦN�S��]], 60 )
	InsertMDEnterMap( [[���ڦN�S��]], [[1@jtb.gat]], 16,17 )

	return true, "good"
end

function memorial19()
	RegisterMemorialDungeon( [[�������}��]] )
	InsertMDMap( [[�������}��]], [[1@rev.gat]], 20 )
	InsertMDLiveTimeMinute( [[�������}��]], 60 )
	InsertMDEnterMap( [[�������}��]], [[1@rev.gat]], 26,181 )

	return true, "good"
end

function memorial20()
	RegisterMemorialDungeon( [[�M�����d�z���y]] )
	InsertMDMap( [[�M�����d�z���y]], [[1@mcd.gat]], 20 )
	InsertMDLiveTimeMinute( [[�M�����d�z���y]], 60 )
	InsertMDEnterMap( [[�M�����d�z���y]], [[1@mcd.gat]], 127, 282 )

	return true, "good"
end


function memorial21()
	RegisterMemorialDungeon( [[���������]] )
	InsertMDMap( [[���������]], [[1@lab.gat]], 20 )
	InsertMDLiveTimeMinute( [[���������]], 60 )
	InsertMDEnterMap( [[���������]], [[1@lab.gat]], 120,30 )

	return true, "good"
end

function memorial22()
	RegisterMemorialDungeon( [[�̫�ж�]] )
	InsertMDMap( [[�̫�ж�]], [[1@uns.gat]], 20 )
	InsertMDLiveTimeMinute( [[�̫�ж�]], 60 )
	InsertMDEnterMap( [[�̫�ж�]], [[1@uns.gat]], 145,35 )

	return true, "good"
end

function memorial23()
	RegisterMemorialDungeon( [[��Q���M���]] )
	InsertMDMap( [[��Q���M���]], [[1@glast.gat]], 20 )
	InsertMDLiveTimeMinute( [[��Q���M���]], 60 )
	InsertMDEnterMap( [[��Q���M���]], [[1@glast.gat]], 367,304 )

	return true, "good"
end


function memorial24()

	RegisterMemorialDungeon( [[���Ÿ�ŧ��]] )
	InsertMDMap( [[���Ÿ�ŧ��]], [[1@air1.gat]], 20 )
	InsertMDMap( [[���Ÿ�ŧ��]], [[1@air2.gat]], 20 )
	InsertMDLiveTimeMinute( [[���Ÿ�ŧ��]], 60 )
	InsertMDEnterMap( [[���Ÿ�ŧ��]], [[1@air1.gat]], 244,73 )

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
