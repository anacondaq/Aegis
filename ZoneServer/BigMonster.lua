-- 대형 몬스터 반경 설정

BigMonsterTable =
{
--	[ [[분노한_탈락자_퓨리엘]] ] = 1,
--	[ [[여전사_로라]] ] = 1,
--	[ [[지오이아]] ] = 1,
--	[ [[엘비아]] ] = 2,
--	[ [[장군_대현]] ] = 1,
--	[ [[호위_무사_소현]] ] =1,
--	[ [[망자의_수호자_카데스]] ] = 1,
	[ [[바돈X]] ] = 2,
	[ [[MG_AMDARAIS]] ] = 1,
	[ [[MG_CORRUPTION_ROOT]] ] = 1,
	[ [[MYSTCASE_GIANT]] ] = 2,
};

function main()

	for key, value in pairs(BigMonsterTable) do
		result, msg = InsertTable(key, value);
		if ( not result ) then
			return false, msg;
		end
	end

	return true,"success"
end
