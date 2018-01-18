--//////////////////////////////////////////////////////////////////////////////////////////////
-- Title	: �����Ŵ��� ����ġ ���� ���� ��ũ��Ʈ.
-- Date		: 2011/06/02
-- Author	: InGeon, Kim (Gravity/RO1/Program Unit)
--//////////////////////////////////////////////////////////////////////////////////////////////

dofile( "ServerExpInfo.lua" );

--///////////////////////////////////////////////
-- ����ġ ���� ���� ���� ����
--///////////////////////////////////////////////

IAuthenticate = 
{
	ID = [[ragtest]], 
	PW = [[1234]], 
}

--///////////////////////////////////////////////
-- ����ġ ���� ���� ����.
--///////////////////////////////////////////////

EXPInfoRestrict = 
{
	--// ����ġ �ִ�, �ּ� ����
	EXP = 
	{
		Min = 0, 
		Max = 1000, 
	};
	
	--// ��� �г�Ƽ �ִ�, �ּ� ����
	DEATH = 
	{
		Min = -100, 
		Max = 0, 
	};
	
	--// ����� �ִ�, �ּ� ����
	DROP = 
	{
		Min = 0, 
		Max = 1000, 
	};
}


--///////////////////////////////////////////////////////////
-- �ϴ��� ������ ���� �������� ������.
-- ���Ƿ� ������ ���� ���� ��ü�� ������ �߻��� �� �ֽ��ϴ�.
--///////////////////////////////////////////////////////////

function main()
	result, msg = SetExpIAuthenticate( IAuthenticate.ID, IAuthenticate.PW );
	if( not result ) then	return false, msg;	end
	
	-- �ִ� �ּҰ��� ���� �����ؾ� �Ѵ�.
	result, msg = SetRestrictEXPInfo( EXPInfoRestrict.EXP.Min, EXPInfoRestrict.EXP.Max, EXPInfoRestrict.DEATH.Min, EXPInfoRestrict.DEATH.Max, EXPInfoRestrict.DROP.Min, EXPInfoRestrict.DROP.Max );
	if( not result ) then	return false, msg;	end
	
	-- �ݵ�� �ִ��ּҰ� �������Ŀ� ȣ���Ͽ��� �մϴ�.
	result, msg = SetServerEXPInfo( SERVER_EXP_INFO.EXP, SERVER_EXP_INFO.DEATH, SERVER_EXP_INFO.DROP );
	if( not result ) then	return false, msg;	end
	
	
	
	return true, "good";
end