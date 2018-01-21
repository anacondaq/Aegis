

-- 이파일은 lua 문법에 따라 작성해야 합니다.
-- 이 파일은 몬스터드랍 아이템중 특정한아이템을 획들했을시 브로드캐스팅메세지를 날려준다.
-- 주석은 -- 표시입니다.
-- 드롭하는 몬스터와 별개로 아이템 획득시에 방송이 나오며, 포링이 바포메트 카드를 먹은후 드롭하게 되더라도
-- '예시 : 포링을 사냥하여 바포메트 카드를 획득하였습니다.' 라는 형태로 방송이 나오게 됩니다.
-- 획득 캐릭터 명은 디폴트로 캐릭터 명의 뒤쪽 문자 2개가 **로 표시가되며, Ro.inf를 수정하여 이름이 모두 표시되도록
-- 변경 가능합니다.
-- 사용 방법에 있어서
--	tbl={	
--		{ID,"DB NAME"},
--		{738,"연필꽃이"},
--	};
-- 상기 구문안의 ID와 DB Name을 제외한 항목은 수정하면 안됩니다.

--function main()
--
--	tbl={	
--		{ID,"DB NAME"},
--		{738,"연필꽃이"},
--	};
--	
--	for k,v in pairs(tbl) do
--		result,msg = InsertItem(v);
--		if( not result) then return false,msg; end		
--	end	
--	
--	return true,"성공";
--end



function main()

	tbl={	
		{7782,"Gold_Key77"},
		{7783,"Silver_Key77"},
	};
	
	for k,v in pairs(tbl) do
		result,msg = InsertItem(v);
		if( not result) then return false,msg; end		
	end	
	
	return true,"Success";
end

