-- 이파일은 lua 문법에 따라 작성해야 합니다.
-- 이 파일은 존서버별 개별설정항목들을 지정합니다.

function main()
           -- 값을 -1 로 설정할경우 데이타베이스에 동일한 IP당 존서버 한개씩만 설정해야만합니다.
           result, msg = SetZsvrID( 101 ); -- 존서버의 ZSID 를 설정한다.
           if( not result ) then return false, msg; end

           result, msg = SetCharacterCount(100); -- 최대 접속 허용 인원수
           if( not result ) then return false, msg; end
            
           return true, "good";
end