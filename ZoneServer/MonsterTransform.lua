-- 몬스터 변신 시스템--
-- 1. 기존 타입에 변신아이템을 중복되지 않게 추가하시면 됩니다.
-- 2. 새로운 몬스터 제한 타입(["MALE"]..)을 추가하시면 서버코드에도 추가해야되서 프로그램팀에 알려주세요.
--  2.1 "DEFAULT", "ARCHER", "MAGICIAN", "FEMALE", "MALE"
-- 3. 스크립트명령어 예시
--  ex) Montransfrom 포링 30(분) "EFST_MTF_ASPD"(버프스페셜)
-- 보여지는 스크롤 이름(영문표기) , DEFAULT, 몬스터 이름

TransformTbl = 
{
	[ [[Trans_Scroll_Poring]] ]		        	= {	[[DEFAULT]],	[[PORING]]},
	[ [[Trans_Scroll_Mavka]] ]			= {	[[DEFAULT]],	[[MAVKA]]},
	[ [[Trans_Scroll_Devi]] ]			= {	[[DEFAULT]],	[[DEVIRUCHI]]},
	[ [[Trans_Scroll_Marduk]] ]			= {	[[DEFAULT]],	[[MARDUK]]},
	[ [[Trans_Scroll_Ray_Arch]] ]			= {	[[DEFAULT]],	[[RAYDRIC_ARCHER]]},
	[ [[Trans_Scroll_Banshee]] ]			= {	[[DEFAULT]],	[[BANSHEE]]},
	[ [[Trans_Scroll_Golem]] ]			= {	[[DEFAULT]],	[[GOLEM]]},
};

function main()
	
	for key, value in pairs(TransformTbl) do
		result, msg = InsertTbl(key, value[1], value[2]);
		if ( not result ) then 
			return false, msg; 
		end
	end

	return true,"success"
end
