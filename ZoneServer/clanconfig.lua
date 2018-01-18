tbl={
	[ [[SWORD CLAN]] ] =		--클랜명
	{
		CID = 1,		--클랜 ID  1번부터 시작합니다
		EMBLEM_NUM = 1,
		MASTER_NAME = [[㉬쇽 랍⒣ㆁ보]],	 -- npc 이름과 동일해야됩니다
		MANAGE_MAP  =[[prontera.gat]],
		MAX_USER = 500,			--클랜 최대 인원수
		ALLY_CLAN={3,},			--동맹클랜
		HOSTILE = {0,},			--적대클랜
		EFST_ID = { [[EFST_SWORDCLAN]],}, 		--효과를 적용할 EFST ID 리스트
	},
	[ [[ARCHWAND CLAN]] ]=
	{
		CID = 2,
		EMBLEM_NUM = 2,
		MASTER_NAME = [[펧팞 ╉보]],
		MANAGE_MAP  =[[geffen.gat]],
		MAX_USER = 500,
		ALLY_CLAN={3,},
		HOSTILE = {4,},
		EFST_ID ={ [[EFST_ARCWANDCLAN]], },
	},

	[ [[GOLDENMACE CLAN]] ]=
	{
		CID = 3,
		EMBLEM_NUM = 3,
		MASTER_NAME = [[�^벙 ╉보]],
		MANAGE_MAP  =[[prontera.gat]],
		MAX_USER = 500,
		ALLY_CLAN={1,2,4,},
		HOSTILE = {0},
		EFST_ID ={ [[EFST_GOLDENMACECLAN]], },
	},

	[ [[CROSSBOW CLAN]] ]=
	{
		CID = 4,
		EMBLEM_NUM = 4,
		MASTER_NAME = [[�|몰┢]],
		MANAGE_MAP  = [[payon.gat]],
		MAX_USER = 500,
		ALLY_CLAN={3,},
		HOSTILE   = {2,},
		EFST_ID   = { [[EFST_CROSSBOWCLAN]], },
	},	

};


function main()
	for clanname,  info in pairs(tbl) do
		result, msg = InsertClanInfo( clanname, info.CID, info.EMBLEM_NUM , info.MASTER_NAME,  info.MANAGE_MAP, info.MAX_USER,   info.ALLY_CLAN, info.HOSTILE, info.EFST_ID );
		if ( not result )then return false, msg; end
	end
	return true,"success"
end