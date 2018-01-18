

-- 한줄 주석은 -- 로 시작한다.
-- 블록주석은 --[[ 로 시작하여 ]] 으로 끝난다.

math.randomseed(os.time()) --랜덤을 초기화한다.

--[[스테이트 상수를 정의하자. 이 테이블에는 값을 추가 할수 없으며 수정할수도 없다. --]]
FSMSTATE =	{IDLE=0,RANDOM_MOVE=1,BERSERK=7, RUSH=4,DEAD=11,__newindex=function() error("unknown state"); end};
setmetatable(FSMSTATE,FSMSTATE); -- 자기자신을 메타테이블로 지정한다.

--[[케릭터 액션상수를 정의한다. --]]
ACTION_STATE ={MOVE=0,STAND=1,__newindex=function() error("unknown state"); end};
setmetatable(ACTION_STATE,ACTION_STATE); -- 자기자신을 메타테이블로 지정한다.

--[[메세지 상수를 정의 하자. 이테이블에는 값을 추가 할수 없으면 수정할수도 없다.--]]
MSG = {ATTACKED=1,DEAD=2,LOG=3,TELEPORT=4,__newindex=function() error("unknown state"); end};--메세지 정의값.
setmetatable(MSG,MSG); -- 자기자신을 메타테이블로 지정한다.

--[[async_wait함수의 목적을 상수로 정의하자 --]]
--ASYNC_WAIT_WHAT = {SKIP_PROCESS=0,SLEEP=1,__newindex=function() error("unknown state"); end}; --state를 저장하고 있는 테이블정의 
--setmetatable(ASYNC_WAIT_WHAT,ASYNC_WAIT_WHAT); -- 자기자신을 메타테이블로 지정한다.

--[[object type을 정의한다.--]]
OBJECT = { PLAYER=0,MONSTER=5,SKILL=3,ITEM=2,HOMUN = 8,MERSOL= 9,__newindex=function() error("unknown state"); end};
setmetatable(OBJECT,OBJECT); -- 자기자신을 메타테이블로 지정한다.

--[[GetV함수의 인자로 사용돼는 var값을 정의한다 --]]
VAR = {CURXPOS=61,CURYPOS=62,FSMSTATE=199,NAME=198,LEVEL=11,HP=5,MAXHP=6,SP=7,MAXSP=8,STR=13,AGI=14,VIT=15,INT=16,DEX=17,LUK=18,JOB=19,MONEY=20,SEX=21,__newindex=function() error("unknown state"); end};
setmetatable(VAR,VAR); -- 자기자신을 메타테이블로 지정한다.

--[[color값정의--]]
COLOR = {RED={R=255,G=0,B=0},WHITE={R=255,G=255,B=255},BLACK={R=0,G=0,B=0},__newindex=function() error("unknown state"); end};
setmetatable(COLOR,COLOR); -- 자기자신을 메타테이블로 지정한다.

--[[emotion값정의 --]]
EMOTION={
	SURPRISE=0,
	QUESTION=1,
	DELIGHT=2,
	THROB=3,
	SWEAT=4,
	AHA=5,
	FRET=6,
	ANGER=7,
	MONEY=8,
	THINK=9,
	SCISSOR=10,
	ROCK=11,
	WRAP=12,
	FLAG=13,
	BIGTHROB=14,
	THANKS=15,
	KEK=16,
	SORRY=17,
	SMILE=18,
	PROFUSELY_SWEAT=19,
	SCRATCH=20,
	BEST=21,
	STARE_ABOUT=22,
	HUK=23,
	O=24,
	X=25,
	HELP=26,
	GO=27,
	CRY=28,
	KIK=29,
	CHUP=30,
	CHUPCHUP=31,
	HNG=32,
	OK=33,
	CHAT_PROHIBIT=34,
	INDONESIA_FLAG=35,
	STARE=36,
	HUNGRY=37,
	COOL=38,
	MERONG=39, 
	SHY=40, 
	GOODBOY=41, 
	SPTIME=42, 
	SEXY=43, 
	COMEON=44,
	SLEEPY=45, 
	CONGRATULATION=46, 
	HPTIME=47, 
	PH_FLAG=48, 
	MY_FLAG =49, 
	SI_FLAG=50, 
	BR_FLAG=51,
	SPARK=52, 
	CONFUSE=53, 
	OHNO=54, 
	HUM=55, 
	BLABLA =56, 
	OTL=57, 
	DICE1=58, 
	DICE2=59, 
	DICE3=60, 
	DICE4=61, 
	DICE5 =62, 
	DICE6=63, 
	INDIA_FLAG=64, 
	LUV=65, 
	FLAG8=66, 
	FLAG9=67,
	MOBILE=68, 
	MAIL=69, 
	ANTENNA0=70, 
	ANTENNA1=71, 
	ANTENNA2=72, 
	ANTENNA3=73,
	HUM2=74,
	ABS=75,
	OOPS=76,
	SPIT=77,
	ENE=78,
	PANIC=79,
	WHISP=80,
	__newindex=function() error("unknown state"); end
};
setmetatable(EMOTION,EMOTION); -- 자기자신을 메타테이블로 지정한다.


--[[object attr 값정의--]]
OBJECT_ATTR={
	NONE		= 0x00000000,--디폴트상태
	HIDE		= 0x00000001,--하이딩상태
	SPECIALHIDE = 0x00000002,--운영자 하이딩상태
	DEAD	    = 0x00000004,--사망한 케릭터
	TRICKDEAD   = 0x00000008,--가짜로 사망한 케릭터		
	BURROW		= 0x00000010,--버로우 상태(TF_HIDING)
	CAMOUFLAGE  = 0x00000020,--EFST_CAMOUFLAGE(RA_CAMOUFLAGE)	
	__newindex=function() error("unknown state"); end};	
setmetatable(OBJECT_ATTR,OBJECT_ATTR); -- 자기자신을 메타테이블로 지정한다.

--[[object include 값정의--]]
OBJECT_INCLUDE={
	NONE		= 0x00000000,
	HIDE		= 0x00000001,--하이딩케릭터를 포함시켜라
	TRICKDEAD	= 0x00000002,--가짜로 사망한 케릭터를 포함시켜라
	BURROW		= 0x00000004,--버로우 상태(TF_HIDING)
	CAMOUFLAGE  = 0x00000008,--EFST_CAMOUFLAGE(RA_CAMOUFLAGE)
	__newindex=function() error("unknown state"); end};	
setmetatable(OBJECT_INCLUDE,OBJECT_INCLUDE); -- 자기자신을 메타테이블로 지정한다.


--[[맨처음 실행할 소스파일을 지정해준다 --]]
local startupFunc = assert(loadfile("scriptdata(lua)/startup.lua"))
startupFunc()