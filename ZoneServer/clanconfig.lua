tbl={
	[ [[SWORD CLAN]] ] =		--Ŭ����
	{
		CID = 1,		--Ŭ�� ID  1������ �����մϴ�
		EMBLEM_NUM = 1,
		MASTER_NAME = [[���� ���Ԥ�]],	 -- npc �̸��� �����ؾߵ˴ϴ�
		MANAGE_MAP  =[[prontera.gat]],
		MAX_USER = 500,			--Ŭ�� �ִ� �ο���
		ALLY_CLAN={3,},			--����Ŭ��
		HOSTILE = {0,},			--����Ŭ��
		EFST_ID = { [[EFST_SWORDCLAN]],}, 		--ȿ���� ������ EFST ID ����Ʈ
	},
	[ [[ARCHWAND CLAN]] ]=
	{
		CID = 2,
		EMBLEM_NUM = 2,
		MASTER_NAME = [[�w�X �㺸]],
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
		MASTER_NAME = [[�^�� �㺸]],
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
		MASTER_NAME = [[�|����]],
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