--//////////////////////////////////////////////////////////////////////////////////////////////
-- Title	: 서버매니저 경험치 관리 정보 스크립트.
-- Date		: 2011/06/02
-- Author	: InGeon, Kim (Gravity/RO1/Program Unit)
--//////////////////////////////////////////////////////////////////////////////////////////////

dofile( "ServerExpInfo.lua" );

--///////////////////////////////////////////////
-- 경험치 수정 권한 인증 정보
--///////////////////////////////////////////////

IAuthenticate = 
{
	ID = [[ragtest]], 
	PW = [[1234]], 
}

--///////////////////////////////////////////////
-- 경험치 수정 제한 설정.
--///////////////////////////////////////////////

EXPInfoRestrict = 
{
	--// 경험치 최대, 최소 제한
	EXP = 
	{
		Min = 0, 
		Max = 1000, 
	};
	
	--// 사망 패널티 최대, 최소 제한
	DEATH = 
	{
		Min = -100, 
		Max = 0, 
	};
	
	--// 드랍율 최대, 최소 제한
	DROP = 
	{
		Min = 0, 
		Max = 1000, 
	};
}


--///////////////////////////////////////////////////////////
-- 하단의 내용은 절대 수정하지 마세요.
-- 임의로 수정시 인터 서버 자체에 문제가 발생할 수 있습니다.
--///////////////////////////////////////////////////////////

function main()
	result, msg = SetExpIAuthenticate( IAuthenticate.ID, IAuthenticate.PW );
	if( not result ) then	return false, msg;	end
	
	-- 최대 최소값을 먼저 설정해야 한다.
	result, msg = SetRestrictEXPInfo( EXPInfoRestrict.EXP.Min, EXPInfoRestrict.EXP.Max, EXPInfoRestrict.DEATH.Min, EXPInfoRestrict.DEATH.Max, EXPInfoRestrict.DROP.Min, EXPInfoRestrict.DROP.Max );
	if( not result ) then	return false, msg;	end
	
	-- 반드시 최대최소값 설정이후에 호출하여야 합니다.
	result, msg = SetServerEXPInfo( SERVER_EXP_INFO.EXP, SERVER_EXP_INFO.DEATH, SERVER_EXP_INFO.DROP );
	if( not result ) then	return false, msg;	end
	
	
	
	return true, "good";
end