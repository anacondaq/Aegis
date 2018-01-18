
-- 이파일은 lua 문법에 따라 작성되어야 합니다.
-- 이파일은 고립맵탈출시스템에서 사용되는 탈출결로 리스트입니다.


function main()

	-- 존서버이상으로 케릭터가 고립되어 있는경우 
	-- 아래 테이블에 존재하는 맵으로 이동이 가능합니다.
	escapetbl ={ 
		{[[prontera.gat]],116,73},
		{[[payon.gat]],162,58},
		{[[geffen.gat]],121,37},
		{[[aldebaran.gat]],167,112},
		{[[morocc.gat]],157,45},
		{[[comodo.gat]],179,152},
		{[[veins.gat]],204,103},
		{[[ayothaya.gat]],218,187},
		{[[lighthalzen.gat]],159,95},
	    {[[mora.gat]],57,143},		
	};

	-- 감옥맵에 존재하는 케릭은 탈출대상에서 제외 됩니다.
	jailtbl = {
		[[sec_pri.gat]],
	};


	-- 탈출맵들을 등록한다.
	for k,v in pairs(escapetbl) do
		result,msg = InsertEscape(v[1],v[2],v[3]);
		if( not result) then return false,msg; end		
	end	

	-- 감옥을 등록한다.
	for k,v in pairs(jailtbl) do
		result,msg = InsertJail(v);
		if( not result) then return false,msg; end		
	end	
	
	return true,"good";
end

	