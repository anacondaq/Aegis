
// std_v2.sc와 중복되지 않도록 주의!

// 2007/01/19 - 어스퀘이크 수정 (연타데미지)

// TODO : TOGROUND 스킬 재정의 필요함

define PASSIVE			0
define TOCHARACTER 		1
define TOGROUND			2
define TOME			4
define TOALL			16

define SQUARE			1			// 반지름
define LINE			2			// 가로 반지름과 세로 높이

define SKFLAG_NODISPEL		1
define SKFLAG_QUESTSKILL 	2
define SKFLAG_NOREDUCT		4
define SKFLAG_APPLY_PLUSRNG 32
define SKFLAG_IGNORE_SAFETYWALL 64
define SKFLAG_PLUS_TRAP_RANGE_RA_RESEARCHTRAP 128 //트랩 연구(SKID_RA_RESEARCHTRAP)에 의해 사정거리가 증가하는 스킬인가?

define SKILLPATT_NONE				0	// 공격이 아닌 스킬타입
define SKILLPATT_DIRECTATTACK		1	// 직근접 물리 공격 스킬타입
define SKILLPATT_ATTACKSPELL		2	// 마법 공격 스킬타입

define ENUM			10000			// 스킬 함수는 10000 부터 사용

declare SetSkill 	n 	ENUM++			// [스킬]
declare OnUse: 		. 	ENUM++ blockcheck 	// 스킬을 사용했을때
declare OnSuccess:	.	ENUM++ blockcheck	// 스킬이 성공했을 경우
declare SkillType	n	ENUM++			// [타입] 타겟/셀프/지면
declare SkillMaxLv	n	ENUM++			// [레벨 1~10]
declare SkillPattern	n	ENUM++			// [패턴] 물리/마법/일반
declare SkillSplash	n?	ENUM++			// [범위형태(정사각형/직사각형)][레벨수만큼범위]
declare SkillHitPer	n?	ENUM++			// 명중률
declare SkillAtkPer	n?	ENUM++			// 공격력
declare SkillData1	n?	ENUM++			// 추가 데이타.. 확률..
declare SkillData2	n?	ENUM++			// 추가 데이타.. 시간..
declare SkillFlag	n?	ENUM++			// 
declare SkillRange	n?	ENUM++			// 공격거리
declare SkillProperty	n	ENUM++			// 스킬 속성
declare SkillHandicap	n?	ENUM++			// [상태이상][레벨수만큼 확률][레벨수만큼 시간(초)]
declare SkillKnockBack	n?	ENUM++			// [레벨수만큼밀리는거리] 넉백
declare SkillNoDamage	.	ENUM++			// 데미지 없음 : OnUse에서만 사용 가능
declare SkillSP		n?		ENUM++			// [레벨수만큼 SP 소모량]
declare SkillPreDelayTime n? ENUM++			// [레벨수만큼 캐스팅 시간]
declare SkillPostDelayTime n? ENUM++		// [레벨수만큼 시전후 딜레이]
declare SkillResetHandicap n? ENUM++		// [상태이상] 상태이상 풀기
declare SkillDrainHP n?	ENUM++				// [n%] 적에게 준 대미지에서 n% 만큼 HP를 흡수
declare SkillDrainSP n? ENUM++				// [n%] 적의 전체 SP에서 n% 만큼 SP를 제거 
declare SkillEvent	.	ENUM++				// 이벤트스킬, 스킬트리에 없지만, NPC에 의해 고정스킬로 등록가능한 스킬
declare SkillCastFixedDelay n? ENUM++		// [레벨수만큼 고정 캐스팅 시간]
declare SkillCastStatDelay n? ENUM++		// [레벨수만큼 스텟에 영향받는 캐스팅 시간]
declare SkillGlobalPostDelay n? ENUM++		// [레벨수만큼 전체 스킬을 사용 할 수 없는 후딜레이]
declare SkillSinglePostDelay n? ENUM++		// [레벨수만큼 해당 스킬을 사용 할 수 없는 후딜레이]
declare SkillData3	n?	ENUM++				// 추가 데이타.. 
declare SkillData4	n?	ENUM++				// 추가 데이타..
declare SkillData5	n?	ENUM++				// 추가 데이타..
declare SkillData6	n?	ENUM++				// 추가 데이타..
declare SkillDataString s? ENUM++			// [레벨수만큼 문자형 데이타]


SetSkill NPC_EARTHQUAKE 	// +서버, OnUse:고정데미지
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillPattern SKILLPATT_ATTACKSPELL
	SkillSplash SQUARE 5 7 9 11 13 5 7 9 11 13
	SkillHitPer 200 200 200 200 200 200 200 200 200 200
	SkillAtkPer 300 500 600 800 1000 1200 1300 1500 1600 1800
return

SetSkill NPC_FIREBREATH
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 10
	SkillRange 6 6 6 6 6 6 6 6 6 6 
	SkillProperty PROPERTY_Fire
	SkillFlag SKFLAG_IGNORE_SAFETYWALL
	SkillSplash LINE 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14
	SkillHitPer 200 200 200 200 200 200 200 200 200 200	
	SkillAtkPer 100 200 300 400 500 600 700 800 900 1000
return

SetSkill NPC_ICEBREATH
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 10
	SkillRange 6 6 6 6 6 6 6 6 6 6 
	SkillProperty PROPERTY_Water
	SkillFlag SKFLAG_IGNORE_SAFETYWALL
	SkillSplash LINE 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14
	SkillHitPer 200 200 200 200 200 200 200 200 200 200	 
	SkillAtkPer 100 200 300 400 500 600 700 800 900 1000
return
OnSuccess:
	SkillHandicap BODYFreezing 700 700 700 700 700 700 700 700 700 700 
return

SetSkill NPC_THUNDERBREATH
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 10
	SkillRange 6 6 6 6 6 6 6 6 6 6 
	SkillProperty PROPERTY_Wind
	SkillFlag SKFLAG_IGNORE_SAFETYWALL
	SkillSplash LINE 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14
	SkillHitPer 200 200 200 200 200 200 200 200 200 200
	SkillAtkPer 100 200 300 400 500 600 700 800 900 1000
return

SetSkill NPC_ACIDBREATH
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 10
	SkillRange 6 6 6 6 6 6 6 6 6 6 
	SkillProperty PROPERTY_Poison
	SkillFlag SKFLAG_IGNORE_SAFETYWALL
	SkillSplash LINE 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14
	SkillHitPer 200 200 200 200 200 200 200 200 200 200	 	
	SkillAtkPer 100 200 300 400 500 600 700 800 900 1000
return
OnSuccess:
	SkillHandicap HEALTHPoison 700 700 700 700 700 700 700 700 700 700 
return

SetSkill NPC_DARKNESSBREATH
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 10
	SkillRange 6 6 6 6 6 6 6 6 6 6 
	SkillProperty PROPERTY_Darkness
	SkillFlag SKFLAG_IGNORE_SAFETYWALL
	SkillSplash LINE 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14 3 14
	SkillHitPer 200 200 200 200 200 200 200 200 200 200
	SkillAtkPer 100 200 300 400 500 600 700 800 900 1000
return

SetSkill NPC_DRAGONFEAR		// +서버, OnUse:랜덤상태이상
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillRange 6 6 6 6 6
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSplash SQUARE 2 5 8 11 14  
return

SetSkill NPC_BLEEDING
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 5
	SkillRange 9 9 9 9 9
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillHitPer 120 120 120 120 120	
return
OnSuccess:
	SkillHandicap HEALTHBlooding 200 400 600 800 1000
return

SetSkill NPC_PULSESTRIKE
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 7 7 7 7 7
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillAtkPer 100 200 300 400 500
return
OnSuccess:
	SkillKnockBack 7 7 7 7 7
return

SetSkill NPC_HELLJUDGEMENT
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSplash SQUARE 14 14 14 14 14 14 14 14 14 14
	SkillAtkPer 100 200 300 400 500 600 700 800 900 1000
return
OnSuccess:
	SkillHandicap HEALTHCurse 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000
return

SetSkill NPC_WIDESILENCE
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 2 5 8 11 14 
return
OnUse:
	SkillHandicap HEALTHSilence 1000 1000 1000 1000 1000
	SkillNoDamage
return

SetSkill NPC_WIDEFREEZE
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillPattern SKILLPATT_ATTACKSPELL
	SkillSplash SQUARE 2 5 8 11 14 
return
OnUse:
	SkillHandicap BODYFreezing 1000 1000 1000 1000 1000
	SkillNoDamage
return

SetSkill NPC_WIDEBLEEDING
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 2 5 8 11 14 
return
OnUse:
	SkillHandicap HEALTHBlooding 1000 1000 1000 1000 1000
	SkillNoDamage
return

SetSkill NPC_WIDESTONE
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 2 5 8 11 14 
return
OnUse:
	SkillHandicap BODYStoneCurse 1000 1000 1000 1000 1000
	SkillNoDamage
return

SetSkill NPC_WIDECONFUSE
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 2 5 8 11 14 
return
OnUse:
	SkillHandicap HEALTHConfusion 1000 1000 1000 1000 1000
	SkillNoDamage
return

SetSkill NPC_WIDESLEEP
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 2 5 8 11 14 
return
OnUse:
	SkillHandicap BODYSleep 1000 1000 1000 1000 1000
	SkillNoDamage
return

SetSkill NPC_WIDESTUN
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 2 5 8 11 14 
return
OnUse:
	SkillHandicap BODYStun 1000 1000 1000 1000 1000
	SkillNoDamage
return

SetSkill NPC_WIDECURSE
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 2 5 8 11 14 
return
OnUse:
	SkillHandicap HEALTHCurse 1000 1000 1000 1000 1000
	SkillNoDamage
return


SetSkill NPC_WIDESIGHT						// +서버, OnUse:숨은적 찾기
OnInit:
	SkillType TOME
	SkillMaxLv 1
	SkillSplash SQUARE 14
return

SetSkill NPC_EXPULSION						// +서버, OnUse:텔레포트
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 1
	SkillRange 7
return

SetSkill NPC_SLOWCAST						// +서버, OnUse:버프
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 2 5 8 11 14
	SkillData1 20 40 60 80 100				// 캐스팅시간
	SkillData2 30 30 30 30 30 				// 지속시간(초)
return

SetSkill NPC_MAGICMIRROR					// +서버, OnUse:버프
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillData1 20 40 60 80 100 20 40 60 80 100		// 반사확률
	SkillData2 30 30 30 30 30 2 2 2 2 2 				// 지속시간(초)
return

SetSkill NPC_STONESKIN						// +서버, OnUse:버프
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillData1 20 40 60 80 100 20 40 60 80 100			// 물리데미지감소량, MDEF 감소
	SkillData2 300 300 300 300 300 2 2 2 2 2			// 지속시간(초)
return

SetSkill NPC_ANTIMAGIC						// +서버, OnUse:버프
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillData1 20 40 60 80 100 20 40 60 80 100			// 마법데미지 감소량, DEF 감소
	SkillData2 300 300 300 300 300 2 2 2 2 2			// 지속시간(초)
return

SetSkill NPC_CRITICALWOUND					// +서버, OnSuccess:버프
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 5
	SkillRange 7 7 7 7 7
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillData1 20 40 60 80 100 				// 힐 스킬 효과 감소
	SkillData2 30 30 30 30 30 				// 지속시간(초)
return

SetSkill NPC_EVILLAND						// +서버, OnUse:바닥스킬
OnInit:
	SkillMaxLv 10
	SkillType TOGROUND
	SkillRange 7 7 7 7 7 7 7 7 7 7
	SkillSplash SQUARE 1 1 1 1 1 1 1 1 1 1			// 서버에서 수정, 5 5 5 5 5 5 5 5 5 13
	SkillData2 4 7 10 13 16 19 22 25 28 31			// 바닥스킬 지속시간
	SkillAtkPer 100 200 300 400 500 600 666 666 666 666	// 데미지크기, 7레벨부터는 고정데미지
return
OnSuccess:
	SkillHandicap HEALTHBlind 50 100 150 200 250 300 350 400 450 500 // 암흑
return

SetSkill MER_CRASH
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillAtkPer 110 120 130 140 150
	SkillSP 10 10 10 10 10
	SkillPreDelayTime 1 1 1 1 1
	SkillPostDelayTime 2 2 2 2 2
	SkillRange 1 1 1 1 1
return
OnSuccess:
	SkillHandicap BODYStun 60 120 180 240 300
return

SetSkill MER_REGAIN
OnInit:
	SkillMaxLv 1
	SkillType TOALL
	SkillSP 10
	SkillRange 9
return
OnUse:
	SkillResetHandicap BODYStun BODYSleep
	SkillNoDamage
return

SetSkill MER_TENDER
OnInit:
	SkillMaxLv 1
	SkillType TOALL
	SkillSP 10
	SkillRange 9
return
OnUse:
	SkillResetHandicap BODYFreezing BODYStoneCurse
	SkillNoDamage
return

SetSkill MER_BENEDICTION
OnInit:
	SkillMaxLv 1
	SkillType TOALL
	SkillSP 10
	SkillRange 9
return
OnUse:
	SkillResetHandicap HEALTHCurse HEALTHBlind
	SkillNoDamage
return

SetSkill MER_RECUPERATE
OnInit:
	SkillMaxLv 1
	SkillType TOALL
	SkillSP 10
	SkillRange 9
return
OnUse:
	SkillResetHandicap HEALTHSilence HEALTHPoison HEALTHHeavyPoison
	SkillNoDamage
return

SetSkill MER_MENTALCURE
OnInit:
	SkillMaxLv 1
	SkillType TOALL
	SkillSP 10
	SkillRange 9
return
OnUse:
	SkillResetHandicap HEALTHConfusion		// 혼란은 환각까지 치료 가능
	SkillNoDamage
return

SetSkill MER_COMPRESS
OnInit:
	SkillMaxLv 1
	SkillType TOALL
	SkillSP 10
	SkillRange 9
return
OnUse:
	SkillResetHandicap HEALTHBlooding
	SkillNoDamage
return

SetSkill MER_SCAPEGOAT						// 나머지는 서버에서 처리
OnInit:
	SkillMaxLv 1
	SkillType TOME
	SkillSP 5
	SkillPreDelayTime 3
return

SetSkill NPC_VAMPIRE_GIFT
OnInit:
	SkillMaxLv 10
	SkillType TOME
	SkillSplash SQUARE 5 7 9 11 13 13 13 13 13 13 // 11*11	15*15	19*19	23*23	27*27	27*27	27*27	27*27	27*27	27*27
	SkillAtkPer 100 200 300 400 500 100 200 300 400 500
return
OnSuccess:
	SkillDrainHP 100 100 100 100 100 100 100 100 100 100
return

SetSkill NPC_WIDESOULDRAIN
OnInit:
	SkillMaxLv 10
	SkillType TOME
	SkillSplash SQUARE 5 7 9 11 13 13 13 13 13 13 // 11*11	15*15	19*19	23*23	27*27	27*27	27*27	27*27	27*27	27*27
return
OnUse:
	SkillDrainSP 20 40 60 80 100 20 40 60 80 100
	SkillNoDamage
return

SetSkill ALL_INCCARRY
OnInit:
	SkillMaxLv 10
	SkillType PASSIVE
	SkillEvent
	SkillData1	2000 4000 6000 8000 10000 12000 14000 16000 18000 20000
return


SetSkill ALL_ODINS_RECALL
OnInit:
	SkillMaxLv 1
	SkillType TOME
	SkillEvent	
	SkillFlag SKFLAG_NOREDUCT			// __THIRDJOB1 이전 버전에서만 적용됩니다.
	SkillCastFixedDelay 10000			// __THIRDJOB1 선언 후 적용됩니다.
return

SetSkill RETURN_TO_ELDICASTES
OnInit:
	SkillType TOME
	SkillMaxLv 1
	SkillSP 0
	SkillCastFixedDelay		2000
	SkillSinglePostDelay	300000			 // 스킬의 후딜레이는 서버에서 EFST로 저장함.
	SkillDataString			"dicastes01.gat" // 맵이름
	SkillData1				198 187			 // x, y
return


SetSkill ALL_GUARDIAN_RECALL
OnInit:
	SkillType TOME
	SkillMaxLv 1
	SkillSP 0
	SkillCastFixedDelay		3000
	SkillSinglePostDelay	300000			 // 스킬의 후딜레이는 서버에서 EFST로 저장함.
	SkillDataString			"mora.gat"		 // 맵이름
	SkillData1				44 151			 // x, y
return

SetSkill ALL_ODINS_POWER
OnInit:
	SkillType TOALL
	SkillMaxLv		2
	SkillRange		9		9
	SkillSP			70		100
	SkillData1		70		100				//ATK 증가량
	SkillData2		70		100				//MATK 증가량
	SkillData3		20		40				//DEF 감소량
	SkillData4		20		40				//MDEF 감소량
	SkillData5		60000	60000			//지속시간
return

//********************************************************************************************************** 

// __THIRDJOB1

// 룬나이트
SetSkill RK_ENCHANTBLADE //엔첸트 블레이드(SKID_RK_ENCHANTBLADE)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						40		45		50		55		60 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간		
	SkillData1				   120	   140     160     180     200 // MATK	
	SkillData2              300000  300000  300000  300000  300000 // 지속시간 300초
return

SetSkill RK_SONICWAVE // 소닉웨이브
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange 7 8 9 10 11
	SkillSP 30 35 40 45 50
	SkillAtkPer 600 700 800 900 1000
	SkillSinglePostDelay 2000 2000 2000 2000 2000 //2초
	SkillGlobalPostDelay 1000 1000 1000 1000 1000 //1초
return

SetSkill RK_DEATHBOUND // 데스 바운드
OnInit:
	SkillMaxLv 10
	SkillType TOME
	SkillSP 28 31 34 37 40 43 46 49 52 55
	SkillAtkPer 600 700 800 900 1000 1100 1200 1300 1400 1500 // 데미지 증폭량
	SkillGlobalPostDelay 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000
	SkillSinglePostDelay 3000 3000 3000 3000 3000 3000 3000 3000 3000 3000
return

SetSkill RK_HUNDREDSPEAR // 헌드레드 스피어
OnInit:
	SkillMaxLv 10
	SkillType TOCHARACTER
	SkillFlag SKFLAG_NODISPEL	// 캐스팅이 끊기지 않도록 수정
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange 5  5  5  5  5  5  5  5  5  5 
	SkillSP   60 60 60 60 60 60 60 60 60 60
	SkillAtkPer 640 680 720 760 800 840 880 920 960 1000
	SkillData1 13 16 19 22 25 28 31 34 37 40 // 스피어부메랑 발동 확률
	SkillCastStatDelay	1000	 900	 800	 700	 600	 500	 400	 300	 200	 100
	SkillSinglePostDelay    3000    3000    3000    3000    3000    3000    3000    3000    3000    3000
 	SkillGlobalPostDelay	 500	 500	 500	 500	 500	 500	 500	 500	 500	 500	 
return

SetSkill RK_WINDCUTTER //윈드 커터(SKID_RK_WINDCUTTER)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Wind
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						20		24		28		32		36 // SP소모량
	SkillAtkPer				   150	   200	   250	   300	   350 // 공격데미지증가율(%)
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay			 0	     0	     0	     0	     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay      2000	  2000	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay		 0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간		
return

SetSkill RK_IGNITIONBREAK //이그니션 브레이크(SKID_RK_IGNITIONBREAK)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillFlag		SKFLAG_NODISPEL								   // 캐스팅이 끊기지 않도록 수정
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						35		40		45		50		55 // SP소모량	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				   400	   600	   800	  1000	  1200 // 안쪽 범위 데미지
	SkillData2				   200     400	   600	   800    1000 // 중간 범위 데미지
	SkillData3				   200	   300	   400	   500	   600 // 바깥 범위 데미지
return

SetSkill RK_DRAGONTRAINING
OnInit:
	SkillMaxLv 5
	SkillType PASSIVE	
	SkillAtkPer 100 105 110 115 120 // 드래곤브레스 데미지 보정%
	SkillData1 80 85 90 95 100 // 공속회복
	SkillData2 700 900 1100 1300 1500 // 소지량증가

return

SetSkill RK_DRAGONBREATH
OnInit:
	SkillMaxLv 10
	SkillType TOGROUND
	SkillFlag SKFLAG_NODISPEL
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSP 30 35 40 45 50 55 60 65 70 75
	SkillProperty PROPERTY_Fire
	SkillRange 9 9 9 9 9 9 9 9 9 9
	SkillCastFixedDelay 500 500 500 500 500 500 500 500 500 500
	SkillCastStatDelay  0    0    0    1000 1000 1000 1500 1500 2000 2000
	SkillGlobalPostDelay 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000
	SkillData1 1 1 1 2 2 2 3 3 4 4 // 효과범위, 3*3, 3*3, 3*3, 5*5, 5*5, 5*5, 7*7, 7*7, 9*9, 9*9
return

SetSkill RK_DRAGONHOWLING
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSP 30 30 30 30 30	
	SkillData1 560 620 680 740 800 // 공포 확률, 천분률
	SkillData2 5000 5000 5000 5000 5000 // 효과 지속시간
	SkillSinglePostDelay 10000 10000 10000 10000 10000
return

SetSkill RK_RUNEMASTERY
OnInit:
	SkillMaxLv 10
	SkillType PASSIVE
return

SetSkill RK_MILLENNIUMSHIELD
OnInit:
	SkillMaxLv 1
	SkillType TOME
	SkillGlobalPostDelay 1000
return

SetSkill RK_CRUSHSTRIKE
OnInit:
	SkillMaxLv 1
	SkillType TOME
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillCastFixedDelay 1000
return

SetSkill RK_REFRESH
OnInit:
	SkillMaxLv 1
	SkillType TOME
	SkillCastFixedDelay 1000	
return

SetSkill RK_GIANTGROWTH
OnInit:
	SkillMaxLv 1
	SkillType TOME
	SkillCastFixedDelay 1000
	SkillData1 180000 // 지속시간	
return

SetSkill RK_STONEHARDSKIN
OnInit:
	SkillMaxLv 1
	SkillType TOME
	SkillCastFixedDelay 2000
	SkillData1 180000 // 지속시간
return

SetSkill RK_VITALITYACTIVATION
OnInit:
	SkillMaxLv 1
	SkillType TOME	
	SkillData1 180000 // 지속시간
return

SetSkill RK_STORMBLAST
OnInit:
	SkillMaxLv 1
	SkillType TOME	
	SkillFlag SKFLAG_NODISPEL
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillCastStatDelay 2000
	SkillGlobalPostDelay 1000
	SkillData1 7 // 넉백거리
return

SetSkill RK_FIGHTINGSPIRIT
OnInit:
	SkillMaxLv 1
	SkillType TOME	
	SkillData1 180000 // 지속시간
return

SetSkill RK_ABUNDANCE
OnInit:
	SkillMaxLv 1
	SkillType TOME	
	SkillData1 180000 // 지속시간
return

SetSkill RK_PHANTOMTHRUST
OnInit:
	SkillMaxLv 5
	SkillType TOALL
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSP 15 18 21 24 27
	SkillAtkPer 100 120 140 160 180
	SkillRange 5 6 7 8 9
return


//길로틴 크로스
SetSkill GC_VENOMIMPRESS //베놈 임프레스(SKID_GC_VENOMIMPRESS)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillRange                10	  10	  10	  10	  10 // 스킬사정거리
	SkillSP				      12	  16	  20	  24	  28 // SP소모량
	SkillGlobalPostDelay	3000	2500	2000	1500	1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  10	  20	  30	  40	  50 // 독속성 내성 감소%
	SkillData2			   10000   20000   30000   40000   50000 // 효과지속시간
return

SetSkill GC_CROSSIMPACT //크로스 임팩트(SKID_GC_CROSSIMPACT)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER	
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입
	SkillRange                 3	   3	   3	   3	   3 // 스킬사정거리
	SkillSP					  25	  25	  25	  25	  25 // SP소모량
	SkillGlobalPostDelay	2500	2000	1500	1000	 500 // 스킬사용후 전체스킬사용금지시간	
return

SetSkill GC_DARKILLUSION //다크 일루젼(SKID_GC_DARKILLUSION)
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange				   5	   6	   7	   8	   9 // 스킬사정거리
	SkillSP					  20	  25	  30	  35	  40 // SP소모량
	SkillGlobalPostDelay	1500	1500	1500	1500	1500 // 스킬사용후 전체스킬사용금지시간		
	SkillData1				   4	   8	  12	  16	  20 // 크로스임팩트 발동 확률
return


SetSkill GC_RESEARCHNEWPOISON //새로운 독 연구(SKID_GC_RESEARCHNEWPOISON)
OnInit:
	SkillMaxLv		10
	SkillType		PASSIVE	
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillProperty	PROPERTY_Nothing  // 속성없음
return

SetSkill GC_CREATENEWPOISON //새로운 독 제조(SKID_GC_CREATENEWPOISON)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP		10
	SkillGlobalPostDelay 500
return


SetSkill GC_ANTIDOTE //안티 도트(SKID_GC_ANTIDOTE)
OnInit:
	SkillMaxLv	1
	SkillType	TOALL
	SkillSP		10
	SkillRange  5 // 스킬사정거리
return

SetSkill GC_POISONINGWEAPON //포이즈닝 웨폰(SKID_GC_POISONINGWEAPON)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP					    20      24      28      32      36 // SP소모량
	SkillGlobalPostDelay	  1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     4	     6	     8	    10	    12 // 중독확률
	SkillData2				 60000	120000	180000	240000	300000 // 지속시간
return


SetSkill GC_WEAPONBLOCKING //웨폰 블로킹(SKID_GC_WEAPONBLOCKING)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						40	    36	    32	    28	    24 // SP소모량
	SkillGlobalPostDelay	  2000	  2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1					12      14      16      18      20 // 방어확률
	SkillData2				180000	180000	180000	180000	180000 // 지속시간
return

SetSkill GC_COUNTERSLASH //카운터 슬래쉬(SKID_GC_COUNTERSLASH)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입
	SkillSP					   5	   8	  11	  14	  17 // SP소모량
	SkillAtkPer				 400	 500	 600	 700	 800 // 공격데미지증가율(%)
	SkillGlobalPostDelay	2000	2000	2000	2000	2000 // 스킬사용후 전체스킬사용금지시간
return

SetSkill GC_WEAPONCRUSH //웨폰 크러쉬(SKID_GC_WEAPONCRUSH)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입
	SkillSP					  20	  20	  20	  20	  20 // SP소모량
	SkillGlobalPostDelay	1000	1000	1000	1000	1000 // 스킬사용후 전체스킬사용금지시간
return

SetSkill GC_VENOMPRESSURE //베놈 프렛셔(SKID_GC_VENOMPRESSURE)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					   30	   40      50	   60	   70 // SP소모량
	SkillAtkPer				  1000	  1000	  1000	  1000	 1000 // 공격데미지증가율(%)	
	SkillCastFixedDelay         0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		    0	    0	    0	    0	    0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0	    0	    0	    0	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				   75	   80	   85	   90	   95 // 중독확률	
	SkillData2				  114     118     122     126     130 // 명중률 보정 기본 100 + 레벨별 증가치
return

SetSkill GC_POISONSMOKE //포이즌 스모크(SKID_GC_POISONSMOKE)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange                  5	    5	    5	    5       5 // 스킬사정거리
	SkillSP			   40	   40	   40	   40	   40 // SP소모량
	SkillCastFixedDelay      2000	 2000	 2000	 2000	 2000 // 스킬 캐스팅 고정 delay값
	SkillGlobalPostDelay	 2000	 2000	 2000	 2000	 2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1		10000	12000	14000	16000	18000 // 지속시간
return

SetSkill GC_CLOAKINGEXCEED //클로킹 익시드(SKID_GC_CLOAKINGEXCEED)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP					  45	  45	  45	  45	  45 // SP소모량
	SkillGlobalPostDelay	2000	2000	2000	2000	2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				   9       8       7       6       5 // 초당 추가 소모 SP
	SkillData2				   1	   1	   2	   2	   3 // 방어 횟수
	SkillData3				   0	  10	  20	  30	  40 // 이동속도증가(%)
return

SetSkill GC_PHANTOMMENACE //팬텀 메나스(SKID_GC_PHANTOMMENACE)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillAtkPer			  300 // 공격데미지증가율(%)
	SkillSP				   30 // SP소모량
	SkillGlobalPostDelay 1000 // 스킬사용후 전체스킬사용금지시간
	
return

SetSkill GC_HALLUCINATIONWALK //할루시네이션 워크(SKID_GC_HALLUCINATIONWALK)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP					   100	   100	   100	   100	   100 // SP소모량
	SkillSinglePostDelay	300000	300000	300000	300000	300000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간	
	SkillData1					50	   100	   150	   200	   250 // 회피율 상승값 
	SkillData2					10		20		30		40		50 // 마법무시확률
	SkillData3				 30000	 35000	 40000	 45000	 50000 // 지속시간	
	SkillData4				    16	    14	    12		10	     8 // HP소모량(%)
return

SetSkill GC_ROLLINGCUTTER //롤링 커터(SKID_GC_ROLLINGCUTTER)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					  5		  5	      5	      5		  5 // SP소모량
	SkillAtkPer             120		140		160		180		200 // 공격데미지증가율(%)
	SkillGlobalPostDelay	200		200		200		200		200 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  1	      1	      1	      1	      2 // 데미지 적용반경
return

SetSkill GC_CROSSRIPPERSLASHER //크로스 리퍼 슬래셔(SKID_GC_CROSSRIPPERSLASHER)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					  20	  24	  28	  32	  36 // SP소모량
	SkillRange				   9	  10	  11	  12	  13 // 스킬사정거리
	SkillAtkPer				 200	 240	 280	 320	 360 // 공격데미지증가율(%)
	SkillGlobalPostDelay	1000	1000	1000	1000	1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				 100	 200	 300	 400	 500 // 회전카운트에 의한 추가공격력 2회/4회/6회/8회/10회일때
return


SetSkill AB_JUDEX //쥬덱스 - 아크비숍
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Saint //성속성을 부여한다.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange				  11	  11	  11	  11	  11 //사정거리
	SkillSP					  20	  23	  26	  29	  32 //SP소모량
	SkillAtkPer				 300	 320	 340	 360	 400
	SkillCastFixedDelay		 500	 500	 500	 500	 500 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay		2000	2000	2000	2000	2000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	   0	   0	   0	   0	   0 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	 500	 500	 500	 500	 500 //스킬사용후 전체스킬사용금지시간 
return


SetSkill AB_ANCILLA //안실라 - 아크비숍
OnInit:
	SkillMaxLv 1
	SkillProperty PROPERTY_Nothing //속성이 없다.
	SkillType TOME	
	SkillPattern SKILLPATT_NONE //공격스킬 아님
	SkillSP             30 // 이값이 클라이언트에서 %로 화면에 출력되게 된다.0이면 시전이 않된다. 주의하라.
	SkillCastFixedDelay 0 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay 1000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 0 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay 1000 //스킬사용후 전체스킬사용금지시간 
return


SetSkill AB_ADORAMUS //아도라무스 - 아크비숍
OnInit:
	SkillMaxLv		10
	SkillProperty	PROPERTY_Saint //성속성을 부여한다.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange              11	   11	   11	   11	    11	    11	    11	    11	    11	    11
	SkillSP                 20	   24	   28	   32	    36	    40	    44	    48	    52	    56
	SkillCastFixedDelay      0	    0	    0	    0	     0	     0	     0	     0	     0	     0 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  2000	 2000	 2000	 2000	  2000	  2000	  2000	  2000	  2000	  2000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay  2000	 2000	 2000	 2000	  2000	  2000	  2000	  2000	  2000	  2000 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay   500	  500	  500	  500	   500	   500	   500	   500	   500	   500 //스킬사용후 전체스킬사용금지시간 
	SkillData1			  6000	 7000	 8000	 9000	 10000	 11000	 12000	 13000	 14000	 15000 //암흑 지속시간
	SkillData2			 15000	20000	25000	30000	 35000   40000	 45000	 50000	 55000	 60000 //민첩성감소 지속시간
	SkillData3				 3      4       5       6        7	     8	     9	    10	    11	    12 //AGI감소량

return


SetSkill AB_CLEMENTIA //크레멘티아 - 아크비숍
OnInit:
	SkillMaxLv 3
	SkillProperty PROPERTY_Saint //성속성을 부여한다.
	SkillType TOME
	SkillPattern SKILLPATT_NONE //공격스킬 아님
	SkillSP					   280	   320	   360
	SkillAtkPer				   100	   100	   100
	SkillCastFixedDelay		  1000	  1000	  1000 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  3000	  3000	  3000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0       0       0 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay		 0	     0	     0 //스킬사용후 전체스킬사용금지시간 
	SkillData1					 3	     7		15 //효과범위(반경)
	SkillData2				120000	180000	240000 //지속시간
return


SetSkill AB_CANTO //칸토캔디두스 - 아크비숍
OnInit:
	SkillMaxLv 3
	SkillProperty PROPERTY_Saint //성속성을 부여한다.
	SkillType TOME 
	SkillPattern SKILLPATT_NONE //공격스킬아님
	SkillSP					   200	   220	   240
	SkillAtkPer				   100	   100	   100
	SkillCastFixedDelay		  1000	  1000	  1000 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  3000	  3000	  3000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0       0       0 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay		 0	     0	     0 //스킬사용후 전체스킬사용금지시간 
	SkillData1					 3	     7	    15 //효과범위(반경)
	SkillData2				120000	180000	240000 //지속시간
return


SetSkill AB_CHEAL //콜루세오힐-아크비숍
OnInit:
	SkillMaxLv 3
	SkillProperty PROPERTY_Saint //성속성을 부여한다.
	SkillType	 TOME
	SkillPattern SKILLPATT_NONE //공격스킬아님
	SkillSP               200	 220	 240
	SkillAtkPer           100	 100	 100
	SkillCastFixedDelay  1000	 500	   0 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay	 3000	3000	3000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 2000   2000    2000 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay    0	   0	   0 //스킬사용후 전체스킬사용금지시간 
	SkillData1			    3	   7	  15 //효과범위(반경)
return


SetSkill AB_EPICLESIS //에피클레시스-아크비숍
OnInit:
	SkillMaxLv 5
	SkillProperty PROPERTY_Saint //성속성을 부여한다.
	SkillType TOGROUND
	SkillPattern SKILLPATT_NONE //공격스킬아님
	SkillRange              11	   11	   11	   11	   11 
	SkillSP                300	  300	  300	  300	  300
	SkillAtkPer            100	  100	  100	  100	  100
	SkillCastFixedDelay   2000	 2000	 2000	 2000	 2000 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  2000	 2500	 3000	 3500	 4000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 60000	60000	60000	60000	60000 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay  2000	 2000	 2000	 2000	 2000 //스킬사용후 전체스킬사용금지시간 
	SkillData1			 18000  21000	24000	27000	30000 //생명주기
	SkillData2			     3      3	    4	    4       5 //3초당HP회복량(%)
	SkillData3				 2      2       3       3       4 //3초당SP회복량(%)
	SkillData4				 5     10      15      20      25 //MHP증가량(%)
return


SetSkill AB_PRAEFATIO //프라에파티오-아크비숍
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Saint //성속성을 부여한다.
	SkillType TOME //자기자신에게 사용한다.
	SkillPattern SKILLPATT_NONE //공격스킬아님
	SkillRange               11	    11	    11	    11	    11	    11	    11	    11	    11	    11
	SkillSP                  90	   100	   110	   120	   130	   140	   150	   160	   170	   180	
	SkillCastFixedDelay    1000	  1000	  1000    1000	  1000	  1000	  1000	  1000	  1000	  1000 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay	   2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay  13000	 16000	 19000	 22000	 25000	 28000	 31000	 34000	 37000	 40000 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      0	     0	     0	     0	     0	     0	     0	     0	     0	     0 //스킬사용후 전체스킬사용금지시간 
	SkillData1				  7	     8	     9	    10	    11	    12      13      14      15      16 //방어횟수
	SkillData2			     18	    20	    22      24      26      28      30      32      34      36 //MHP증가량(%)
	SkillData3			 120000	120000	120000	120000	120000	120000	120000	120000	120000	120000 //생명주기
return


SetSkill AB_ORATIO //오라티오--아크비숍
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Saint //성속성을 부여한다.
	SkillType TOME               //자신에게 사용
	SkillPattern SKILLPATT_NONE //공격스킬아님
	SkillRange               11	    11	    11	    11	    11	    11	    11	    11	    11	    11
	SkillSP                  35	    38	    41	    44	    47	    50	    53	    56	    59	    62	
	SkillCastFixedDelay    1000	  1000	  1000    1000	  1000	  1000	  1000	  1000	  1000	  1000 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay	   4000	  4000	  4000	  4000	  4000	  4000	  4000	  4000	  4000	  4000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay   2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      0	     0	     0	     0	     0	     0	     0	     0	     0	     0 //스킬사용후 전체스킬사용금지시간 
	SkillData1				 45	    50	    55	    60	    65	    70      75      80      85      90 //적용확률(%)
	SkillData2			      2	     4	     6       8      10      12      14      16      18      20 //내성감소량
	SkillData3			  30000	 30000	 30000	 30000	 30000	 30000	 30000	 30000	 30000	 30000 //생명주기
return

SetSkill AB_LAUDAAGNUS //라우다아그누스-아크비숍
OnInit:
	SkillMaxLv 4
	SkillProperty PROPERTY_Saint //성속성을 부여한다.
	SkillType TOME               //자신에게 사용
	SkillPattern SKILLPATT_NONE //공격스킬아님
	SkillRange               11	    11	    11		11
	SkillSP                  50	    60	    70	    80
	SkillCastFixedDelay       0	     0	     0       0 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay	   1000	  1000	  1000	  1000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay   3000	  3000	  3000	  3000 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      0	     0	     0	     0 //스킬사용후 전체스킬사용금지시간 
	SkillData1				 50	    60	    70	    80 //동빙,석화,암흑 해제 확률(%)
	SkillData2			      5	     6	     7       8 //VIT 보너스 
	SkillData3			  60000	 60000	 60000	 60000 //VIT 보너스 지속시간
return


SetSkill AB_LAUDARAMUS //라우다라무스-아크비숍
OnInit:
	SkillMaxLv 4
	SkillProperty PROPERTY_Saint //성속성을 부여한다.
	SkillType TOME               //자신에게 사용
	SkillPattern SKILLPATT_NONE //공격스킬아님
	SkillRange               11	    11	    11		11
	SkillSP                  50	    60	    70	    80
	SkillCastFixedDelay       0	     0	     0       0 //스킬 캐스팅 고정 delay값
	SkillCastStatDelay	   1000	  1000	  1000	  1000 //스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay   3000	  3000	  3000	  3000 //스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      0	     0	     0	     0 //스킬사용후 전체스킬사용금지시간 
	SkillData1				 50	    60	    70	    80 //침묵,수면,스턴 해제 확률(%)
	SkillData2			      5	     6	     7       8 //LUK 보너스 
	SkillData3			  60000	 60000	 60000	 60000 //LUK 보너스 지속시간
return

SetSkill AB_EUCHARISTICA //에우카리스티카-아크비숍
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Nothing  //속성없음
	SkillType PASSIVE               //패시브스킬
	SkillPattern SKILLPATT_NONE     //공격스킬아님	
	SkillData1				1,	2,	3,	4,	5,	6,	7,	8,	9,	10 //물리공격력 증가량(%)
	SkillData2				1,	2,	3,	4,	5,	6,	7,	8,	9,	10 //마법공격력 증가량(%)
	SkillData3				1,	2,	3,	4,	5,	6,	7,	8,	9,	10 //언데드,암 속성에대한 저항력 증가(%)
return


SetSkill AB_RENOVATIO //레노바티오-아크비숍
OnInit:
	SkillMaxLv 1
	SkillProperty PROPERTY_Saint  //성속성
	SkillType TOALL  //자신을 포함한 모든 케릭터적용 
	SkillPattern SKILLPATT_NONE   //공격스킬아님
	SkillRange               11
	SkillSP                  70
	SkillCastFixedDelay    2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	   3000	// 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay   1000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      0	// 스킬사용후 전체스킬사용금지시간		
	SkillData1				  3 // 5초당 HP 회복량(%)
	SkillData2			  90000	// 지속시간 
return


SetSkill AB_HIGHNESSHEAL //하이네스힐-아크비숍
OnInit:
	SkillMaxLv 5
	SkillProperty PROPERTY_Saint  //성속성
	SkillType TOALL        //자신을포함한 모든 케릭터적용 
	SkillPattern SKILLPATT_ATTACKSPELL //흐뉴마위의 타겟에게도 데미지를 주기 위해 마법공격으로 변경함.2009.12.10
	SkillRange                11	   11	   11	   11	   11
	SkillSP                   70	  100	  130	  160	  190 // SP소모량
	SkillCastFixedDelay        0        0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		1000	 1000	 1000	 1000	 1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay    3000	 3000	 3000	 3000	 3000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	1000	 1000	 1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간		
	SkillData1				 200	  230	  260	  290	  320 // 회복량 증가률(%)
return

SetSkill AB_CLEARANCE //클리어런스-아크비숍
OnInit:
	SkillMaxLv 5
	SkillProperty	PROPERTY_Nothing     // 속성없음
	SkillType		TOALL  //자신을 포함한 모든 케릭터적용 
	SkillPattern	SKILLPATT_ATTACKSPELL // 마법 공격 스킬타입
	SkillRange                11	   11	   11	   11	   11
	SkillSP                   54	   60	   66	   72	   78
	SkillCastFixedDelay        0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		4000	 4000	 4000	 4000	 4000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay   10000	10000	10000	10000	10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	   0		0	    0	    0	    0 // 스킬사용후 전체스킬사용금지시간		
	SkillData1				  68	   76	   84	   92	  100 // 적용확률
return


SetSkill AB_EXPIATIO //엑스피아티오-아크비숍
OnInit:
	SkillMaxLv 5
	SkillProperty PROPERTY_Nothing     // 속성없음
	SkillType		TOALL  //자신을 포함한 모든 케릭터적용 
	SkillPattern SKILLPATT_NONE		   // 공격스타일 아님
	SkillRange                11	   11	   11	   11	   11
	SkillSP                   35	   40	   45	   50	   55
	SkillCastFixedDelay     1000	 1000	 1000	 1000	 1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		1000	 1000	 1000	 1000	 1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay       0	    0	    0	    0	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	   0		0	    0	    0	    0 // 스킬사용후 전체스킬사용금지시간		
	SkillData1			  150000   180000  210000  240000  270000 // 지속시간
	SkillData2				   5       10      15      20      25 // 방어무시량(%)
return


SetSkill AB_DUPLELIGHT //듀플레라이트-아크비숍
OnInit:
	SkillMaxLv    10
	SkillProperty PROPERTY_Saint       // 성속성
	SkillType     TOME                 // 자신에게 사용
	SkillPattern  SKILLPATT_NONE       // 공격스타일 아님
	SkillRange                11	   11	   11	   11	   11      11	   11	   11	   11	   11
	SkillSP                   55	   60	   65	   70	   75      80      85      90      95     100
	SkillCastFixedDelay     2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay       0	    0	    0	    0	    0       0	    0	    0	    0	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간		
	SkillData1			   90000   120000  150000  180000  210000  240000  270000  300000  330000  360000 // 지속시간	
return

SetSkill AB_DUPLELIGHT_MELEE //듀플레라이트-근접물리공격-아크비숍
OnInit:
	SkillMaxLv		10
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK //물리공격
	SkillRange                11	 11	    11	   11	  11     11	    11	   11	  11	 11
	SkillSP                    0	  0		 0		0	   0	  0		 0		0	   0	  0
	SkillAtkPer				 110	120	   130	  140	 150	160    170	  180	 190    200
	SkillCastFixedDelay        0	  0		 0		0	   0      0      0      0      0      0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	       0	  0		 0	    0	   0	  0	     0	    0	   0	  0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay       0	  0	     0	    0	   0	  0	     0	    0	   0	  0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       0	  0		 0	    0	   0	  0	     0	    0	   0	  0 // 스킬사용후 전체스킬사용금지시간 
	SkillData1				 120	140	   160	  180    200    220	   240    260	 280	300 // 발동확률 1000분률(%)
return

SetSkill AB_DUPLELIGHT_MAGIC //듀플레라이트-마법공격-아크비숍
OnInit:
	SkillMaxLv		10
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                11	 11	    11	   11	  11     11	    11	   11	  11	 11
	SkillSP                    0	  0		 0		0	   0	  0		 0		0	   0	  0
	SkillAtkPer				 220	240	   260	  280	 300	320    340    360    380    400
	SkillCastFixedDelay        0	  0		 0		0	   0      0      0      0      0      0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	       0	  0		 0	    0	   0	  0	     0	    0	   0	  0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay       0	  0	     0	    0	   0	  0	     0	    0	   0	  0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       0	  0		 0	    0	   0	  0	     0	    0	   0	  0 // 스킬사용후 전체스킬사용금지시간 
	SkillData1				 120	140	   160	  180    200    220	   240    260	 280	300 // 발동확률 1000분률(%)
return

SetSkill AB_SILENTIUM //시렌치움-아크비숍
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Saint //성속성을 부여한다.
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                 4	    5	    6	    7       8 // 반경
	SkillSP                   64	   68	   72	   76	   80 // SP소모량
	SkillCastFixedDelay        0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	    4000	 4000	 4000	 4000	 4000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay   15000	15000	15000	15000	15000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       0	    0		0	    0	    0 // 스킬사용후 전체스킬사용금지시간 
	SkillData1			   20000	30000	40000	50000	60000 // 지속시간
return

SetSkill AB_SECRAMENT //세크라멘트
OnInit:
	SkillMaxLv 5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOALL  //자신을 포함한 모든 케릭터적용 
	SkillPattern	SKILLPATT_NONE   //공격스킬아님
	SkillRange                  11	    11	    11	    11	    11 // 스킬사정거리
	SkillSP                    100	   120	   140	   160	   180 // 소모 SP
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	      1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay         0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간		
	SkillData1				 60000	 90000	120000	150000	180000 // 효과지속시간
	SkillData2			        10	    20	    30	    40	    50 // 고정캐스팅시간 감소%
return

SetSkill WL_WHITEIMPRISON //화이트임프리즌-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOALL //자기자신포함
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                 11	   11	   11	   11	   11
	SkillSP                    50	   55	   60	   65	   70
	SkillCastFixedDelay         0	    0		0		0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0	    0	    0	    0	    0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 4000	 4000	 4000	 4000	 4000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0	    0		0	    0	    0 // 스킬사용후 전체스킬사용금지시간 
	SkillData2				10000	12000	14000	16000	18000 // 타겟이 player일경우 고정 지속시간
return

SetSkill WL_SOULEXPANSION //소울익스펜션-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Telekinesis //염속성
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                11	  11	  11	  11	  11 // 스킬사정거리
	SkillSP                   30	  35	  40      45      50
	SkillAtkPer				 500	 600	 700	 800	 900
	SkillCastFixedDelay        0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		2000	2000	2000	2000	2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay       0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     500	 500	 500	 500	 500 // 스킬사용후 전체스킬사용금지시간 
	SkillData1				   1	   1	   1       2       2 // 효과범위(지름)
return

SetSkill WL_FROSTMISTY //프로스트미스티-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Water //수속성
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                 11	   11	   11	   11	   11 // 스킬사정거리
	SkillSP                    40	   48	   56      64      72
	SkillAtkPer				  300	  400	  500	  600	  700
	SkillCastFixedDelay       500	  500	  500	  500	  500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		 2000	 2500	 3000	 3500	 4000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 8000	 8000	 8000	 8000	 8000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간 
	SkillData1				    9	    9	    9       9       9 // 효과범위(반경)
	SkillData3				    3	    4	    5       6       7 // 연타횟수
return


SetSkill WL_JACKFROST //잭프로스트-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Water //수속성
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                 11	   11	   11	   11	   11 // 스킬사정거리
	SkillSP                    50	   60	   70      80      90
	SkillAtkPer				 1300	 1600    1900	 2200    2500
	SkillCastFixedDelay      1000	 1000	 1000	 1000	 1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		 2000	 2500	 3000	 3500	 4000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0	    0	    0	    0	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간 
	SkillData1				    5	    6	    7       8       9 // 효과범위(반경)
	SkillData2				10000	15000	20000	25000	30000 // 동빙유지시간
return


SetSkill WL_MARSHOFABYSS //마쉬오브어비스-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_NONE   // 공격이 아닌 스킬타입
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                11	  11	  11	  11	  11 // 스킬사정거리
	SkillSP                   40	  42	  44      46      48
	SkillCastFixedDelay      500	 500	 500	 500	 500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay    2500	3000	3500	4000	4500 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay    1000	1000	1000	1000	1000 // 스킬사용후 전체스킬사용금지시간 
	SkillData1				  50	  60	  70      80      90 // 이동속도 감소(%)	
	SkillData2				   3	   6	   9	  12	  15 // 플레이어 Agi / Dex 감소 비율
	SkillData3				   6	  12	  18	  24	  30 // 몬스터 Agi / Dex 감소 비율
return

SetSkill WL_RECOGNIZEDSPELL //리코그나이즈드스펠-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE   // 공격이 아닌 스킬타입
	SkillRange                  11	    11	    11	    11	    11 // 스킬사정거리
	SkillSP                    100	   120	   140     160     180	
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 50000	 80000	110000	140000	170000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 60000	 90000	120000	150000	180000 // 지속시간
return



SetSkill WL_SIENNAEXECRATE //시에나엑서크레이트-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_NONE   // 공격이 아닌 스킬타입
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                 7	   7	   7	   7	   7 // 스킬사정거리
	SkillSP                   32	  34	  36      38      40
	SkillCastFixedDelay        0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		2000	2000	2000	2000	2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay       0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay    2000	2000	2000	2000	2000 // 스킬사용후 전체스킬사용금지시간 
	SkillData1				   1	   2	   2       3       3 // 효과범위
	SkillData3			   10000   12000   14000   16000   18000 // 석화지속시간
return

SetSkill WL_RADIUS //라디어스-워록
OnInit:
	SkillMaxLv 3
	SkillProperty PROPERTY_Nothing    // 속성없음
	SkillType PASSIVE                 // 패시브스킬
	SkillPattern SKILLPATT_NONE       // 공격스킬아님	
	SkillData1				1	2	3 // 스킬 사정거리 증가값
	SkillData2			   10  15  20 // 고정캐스팅속도 감소률(%)
return

SetSkill WL_STASIS //스테이시스-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE   // 공격이 아닌 스킬타입
	SkillRange                  11	    11	    11	    11	    11 // 스킬사정거리
	SkillSP                     50	    60	    70      80      90	
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  3000	  3000	  3000	  3000	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	180000	190000	200000	210000	220000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 10000   20000   30000   40000   50000 // 레벨별 추가지속시간 
	SkillData2				     9	    10	    11	    12	    13 // 효과반경
return

SetSkill WL_DRAINLIFE //드레인라이프-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillAtkPer				 600	 700	 800	 900	1000 // 공격데미지증가율(%)
	SkillRange                11	  11	  11	  11	  11 // 스킬사정거리
	SkillSP                   20	  24	  28      32      36
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		4000	4000	4000	4000	4000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay    2000	2000	2000	2000	2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       0	   0	   0	   0	   0 // 스킬사용후 전체스킬사용금지시간 
return

SetSkill WL_CRIMSONROCK //크림즌록-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Fire //화속성	
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입					
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillAtkPer				1600	1900	2200	2500	2800 // 공격데미지증가율(%)
	SkillRange                11	  11	  11	  11	  11 // 스킬사정거리
	SkillSP                   60	  70	  80      90     100
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		5000	5000	5000	5000	5000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay    5000    5000    5000    5000    5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay    2000	2000	2000	2000	2000 // 스킬사용후 전체스킬사용금지시간 	
return

SetSkill WL_HELLINFERNO //헬인페르노-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Fire //화속성	
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입					
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                11	  11	  11	  11	  11 // 스킬사정거리
	SkillSP                   35	  40	  45      50      55
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		3000	3000	3000	3000	3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay       0       0       0       0       0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay    1000	1000	1000	1000	1000 // 스킬사용후 전체스킬사용금지시간 	
	SkillData1				 600	 650	 700     750     800 // 발화(BODY_BURNNING) 성공확률(천분률)
	SkillData2			   20000   30000   40000   50000   60000 // 발화(BODY_BURNNING) 지속시간
return

SetSkill WL_COMET //커미트-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                  11	    11	    11	    11	    11 // 스킬사정거리
	SkillSP                    480	   560	   640     720     800
	SkillAtkPer				  3000	  3500	  4000	  4500	  5000 // 범위1의 MATK 공격증가률
	SkillCastFixedDelay       1000	  1500	  2000	  2500	  3000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		 10000	 11000	 12000	 13000	 14000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 60000   60000   60000   60000   60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간 
	SkillData2				  2000    2400    2800    3200    3600 // 범위2의 MATK 공격증가률
	SkillData3				  1500    1800    2100    2400    2700 // 범위3의 MATK 공격증가률
	SkillData4				  1000    1200    1400    1600    1800 // 범위4의 MATK 공격증가률
return

SetSkill WL_CHAINLIGHTNING //체인라이트닝-워록(시전스킬,실제공격은 WL_CHAINLIGHTNING_ATK 로 한다.)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOCHARACTER
	SkillPattern    SKILLPATT_NONE //공격스킬 아님
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillAtkPer				   0	   0	   0	   0	   0 // 공격데미지증가율(%)
	SkillRange                11	  11	  11	  11	  11 // 스킬사정거리
	SkillSP                   80	  90	 100     110     120
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		3500	4000	4500	5000	5500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay       0       0       0       0       0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay    3000	3000	3000	3000	3000 // 스킬사용후 전체스킬사용금지시간 	
	SkillData1				   5	   6	   7       8       9 // 전이횟수(다른타겟으로)
return

SetSkill WL_CHAINLIGHTNING_ATK //체인라이트닝공격-워록(체인라이트닝스킬의 실제공격스킬이다.)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Wind //풍속성
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입
	SkillAtkPer				 500	 600	 700	 800	 900 // 공격데미지증가율(%)
	SkillRange                11	  11	  11	  11	  11 // 스킬사정거리
	SkillSP                    0	   0	   0       0       0
	SkillCastFixedDelay        0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay       0       0       0       0       0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       0	   0	   0	   0	   0 // 스킬사용후 전체스킬사용금지시간
return

SetSkill WL_EARTHSTRAIN //어스스트레인-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Ground //지속성공격
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                   6	     6	     6	     6	     6 // 스킬사정거리
	SkillSP                     70	    78      86      94     102
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  3000	  4000	  5000	  6000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     5	     6	     7	     8	     9 // 이동거리
	SkillData2				     6	    14	    24	    36	    50 // 타격시 효과(스트립웨폰/스트립헬름)적용확률(%)
	SkillData3				     6	     7	     8	     9	    10 // 연타횟수
return


SetSkill WL_TETRAVORTEX //테트라볼텍스-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                  11	    11	    11	    11	    11 // 스킬사정거리
	SkillSP                    120     150     180     210     240 // SP소모량
	SkillAtkPer				  1000	  1500	  2000	  2500	  3000 // 공격데미지증가율(%)
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  5000	  6000	  7000	  8000	  9000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 15000	 15000	 15000	 15000	 15000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
return

SetSkill WL_SUMMONFB //서몬파이어볼-워록
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE// 공격이 아닌 스킬타입
	SkillSP                     10	    12      14      16      18
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				     1       1       1       1       1 // 소환유지를 위한 매초당 소모 sp량 
	SkillData2				120000	160000  200000  240000  280000 // 소환물 지속시간
return


SetSkill WL_SUMMON_ATK_FIRE //서먼-화속성공격-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Fire //화속성
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입
return

SetSkill WL_SUMMONBL //서몬볼라이트닝-워록
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE// 공격이 아닌 스킬타입
	SkillSP                     10	    12      14      16      18
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				     1       1       1       1       1 // 소환유지를 위한 매초당 소모 sp량 
	SkillData2				120000	160000  200000  240000  280000 // 소환물 지속시간
return

SetSkill WL_SUMMON_ATK_WIND //서먼-풍속성공격-워록
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Wind //풍속성
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입
return

SetSkill WL_SUMMONWB //서몬워터볼-워록
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE// 공격이 아닌 스킬타입
	SkillSP                     10	    12      14      16      18
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				     1       1       1       1       1 // 소환유지를 위한 매초당 소모 sp량 
	SkillData2				120000	160000  200000  240000  280000 // 소환물 지속시간
return

SetSkill WL_SUMMON_ATK_WATER //서먼-수속성공격-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Water //수속성
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입
return


SetSkill WL_SUMMONSTONE //서몬스톤-워록
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE// 공격이 아닌 스킬타입
	SkillSP                     10	    12      14      16      18
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				     1       1       1       1       1 // 소환유지를 위한 매초당 소모 sp량 
	SkillData2				120000	160000  200000  240000  280000 // 소환물 지속시간
return

SetSkill WL_SUMMON_ATK_GROUND //서먼-지속성공격-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Ground //지속성공격
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입
return


SetSkill WL_RELEASE //릴리즈-워록
OnInit:
	SkillMaxLv		2
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //마법 공격 스킬타입
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillSP         3	20
	SkillRange     11   11 // 스킬사정거리
return

SetSkill WL_READING_SB //리딩 스펠북(SKID_WL_READING_SB)-워록
OnInit:
	SkillMaxLv		1
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillSP                    40 // SP소모량
	SkillCastFixedDelay      1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		 5000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      500 // 스킬사용후 전체스킬사용금지시간 	
return

SetSkill WL_FREEZE_SP //프리징 스펠(SKID_WL_FREEZE_SP)
OnInit:
	SkillMaxLv		5	
	SkillProperty	PROPERTY_Nothing    // 속성없음
	SkillType		PASSIVE                 // 패시브스킬
	SkillPattern	SKILLPATT_NONE       // 공격스킬아님	
	SkillData2				   20	   16	   12       8       4 // 10초당 각 저장마법당 소모SP
return

//레인져
SetSkill RA_ARROWSTORM //애로우스톰(SKID_RA_ARROWSTORM)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillFlag		SKFLAG_APPLY_PLUSRNG
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				   9	   9	   9	   9	   9	   9	   9	   9	   9	   9 // 궁수계열 기본 거리	
	SkillAtkPer				 250	 300	 350	 400	 450	 500	 550	 600	 650	 700 // 공격데미지증가율(%)
	SkillSP					  30	  32	  34	  36	  38	  40	  42	  44	  46	  48 // SP소모량		
	SkillCastStatDelay		2000	2200	2400	2800	3000	3200	3400	3600	3800	4000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	5000	4800	4600	4400	4200	4000	3800	3600	3400	3200 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간	
	SkillData1				   3       3       3       3       3       4       4       4       4       5// 효과범위//
return

SetSkill RA_FEARBREEZE //피어브리즈(SKID_RA_FEARBREEZE)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP				    55	    60	    65	    70	    75 // SP소모량
	SkillCastFixedDelay	  2000	  2000	  2000	  2000	  2000 // 스킬 캐스팅 고정 delay값	
	SkillData1			 60000	 90000	120000	150000	180000 //지속시간
	SkillData2				 2		 2	     3	     4	     5 // 최대연타수 (최소 = 2)
	SkillData3				 12		 12		 21		 27	    30 // 발동 총확률 
	SkillData4				 0		 12		 9		 6		 3 // 연타수별 발동 확률, 1연타 = 0%, 2연타 = 12%, 3연타 = 9%, 4연타 = 6%, 5연타 = 3%
return

SetSkill RA_RANGERMAIN
OnInit:
	SkillMaxLv 10
	SkillType PASSIVE
	SkillData1 5 10 15 20 25 30 35 40 45 50	// 동물형,식물형,어패형 내성
	SkillData2 5 10 15 20 25 30 35 40 45 50 // 동물형,식물형,어패형 공격력
return

SetSkill RA_AIMEDBOLT //에임드 볼트(SKID_RA_AIMEDBOLT)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillFlag		SKFLAG_APPLY_PLUSRNG
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				   9	   9	   9	   9	   9	   9	   9	   9	   9	   9 // 궁수계열 기본 거리	
	SkillSP					  30	  32	  34	  36	  38	  40	  42	  44	  46	  48 // SP소모량
	SkillAtkPer				 550	 600	 650	 700	 750	 800	 850	 900	 950	1000 // 공격데미지증가율(%)
	SkillCastFixedDelay		 	 500	 500	 500	 500	 500	 500	 500	 500	 500	 500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay			4000	4000	4000	4000	4000	4000	4000	4000	4000	4000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	   0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	1000	1000	1000	1000	1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				50		50		60		40		70	    30		// 소형일경우 2히트 50 3히트 50  중형일경우 3히트 60 4히트 40  대형일경우 4히트 70 5히트 30 	
return

SetSkill RA_DETONATOR
OnInit:
	SkillMaxLv 1
	SkillType TOGROUND
	SkillSP 15
	SkillRange 9
return

SetSkill RA_ELECTRICSHOCKER
OnInit:
	SkillMaxLv 5
	SkillType TOGROUND
	SkillRange 3 3 3 3 3
	SkillSP 35 35 35 35 35
	SkillData1 20000 22000 24000 26000 28000 // 지속시간
	SkillData2 5 10 15 20 25 // 초당 소모SP%
return

SetSkill RA_CLUSTERBOMB //클러스터 붐(SKID_RA_CLUSTERBOMB)
OnInit:
	SkillMaxLv	5
	SkillType	TOGROUND
	SkillFlag	SKFLAG_PLUS_TRAP_RANGE_RA_RESEARCHTRAP
	SkillRange		  3   3   3   3   3 // 스킬사정거리
	SkillSP			 20  20  20  20  20	// SP소모량
	SkillAtkPer		300	400	500	600	700 // 공격데미지증가율(%)
return

SetSkill RA_WUGMASTERY //워그 마스터리(SKID_RA_WUGMASTERY)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP					   5 // SP소모량
	SkillCastFixedDelay		   0 // 스킬 캐스팅 고정 delay값
	SkillGlobalPostDelay	1000 // 스킬사용후 전체스킬사용금지시간
return

SetSkill RA_WUGRIDER
OnInit:
	SkillMaxLv 3
	SkillType TOME
	SkillSP 2 2 2
	SkillGlobalPostDelay 500 500 500 500 500	
return

SetSkill RA_WUGDASH
OnInit:
	SkillMaxLv 1
	SkillType TOME
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSP 4	
	SkillAtkPer 300
return

SetSkill RA_WUGSTRIKE
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange 9 9 9 9 9
	SkillSP	  20 22 24 26 28
	SkillAtkPer 200 400 600 800 1000
return

SetSkill RA_WUGBITE
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange 9 9 9 9 9
	SkillFlag SKFLAG_APPLY_PLUSRNG	
	SkillSP 40 42 44 46 48
	SkillAtkPer 600 800 1000 1200 1500
	SkillGlobalPostDelay 2000 2000 2000 2000 2000
	SkillSinglePostDelay 4000 6000 8000 10000 12000
	SkillData1 10000 10000 10000 10000 10000	//지속시간
	SkillData2    60     70   80   90   100	//성공률
return

SetSkill RA_TOOTHOFWUG
OnInit:
	SkillMaxLv 10
	SkillType PASSIVE
	SkillData1 30 60 90 120 150 180 210 240 270 300 // 늑대의 공격스킬 데미지
return

SetSkill RA_SENSITIVEKEEN //예민한 후각(SKID_RA_SENSITIVEKEEN)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					  12	  12	  12	  12	  12 // SP소모
	SkillAtkPer				 150	 200	 250	 300	 350 // 공격데미지증가율(%)
	SkillGlobalPostDelay	3000	3000	3000	3000	3000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				   8	  16	  24	  32	  30 // 워그바이트 연계확률
	SkillData2				   3	   4	   5	   6	   7 // 디텍팅 범위(반경)
return

SetSkill RA_CAMOUFLAGE
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP			40	40	40	40	40
	SkillData1		 6   5   4   3   2 // 지속시간 초당 소모 sp
	SkillData2	   100 100  50  25   0 // 이동속도감소 %
return

SetSkill RA_RESEARCHTRAP //트랩 연구(SKID_RA_RESEARCHTRAP)
OnInit:
	SkillMaxLv	5
	SkillType	PASSIVE
	SkillData1		 40	 80	120	160	200 // 트랩의 추가 데미지
	SkillData2        1   2   3   4   5 // 추가INT
	SkillData3		220 240 260 280 300 // 추가MSP
return

SetSkill RA_MAGENTATRAP //마젠타트랩(SKID_RA_MAGENTATRAP)
OnInit:
	SkillMaxLv		1
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Fire
	SkillRange				   3 // 스킬사정거리
	SkillSP					  10 // SP소모량
	SkillGlobalPostDelay	2000 // 스킬사용후 전체스킬사용금지시간
return

SetSkill RA_COBALTTRAP //코발트트랩(SKID_RA_COBALTTRAP)
OnInit:
	SkillMaxLv		1
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Water
	SkillRange				   3 // 스킬사정거리
	SkillSP					  10 // SP소모량
	SkillGlobalPostDelay	2000 // 스킬사용후 전체스킬사용금지시간		
return

SetSkill RA_MAIZETRAP //메이즈트랩(SKID_RA_MAIZETRAP)
OnInit:
	SkillMaxLv		1
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Ground
	SkillRange					   3 // 스킬사정거리
	SkillSP						  10 // SP소모량
	SkillGlobalPostDelay		2000 // 스킬사용후 전체스킬사용금지시간
return

SetSkill RA_VERDURETRAP //버듀어트랩(SKID_RA_VERDURETRAP)
OnInit:
	SkillMaxLv		1
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Wind
	SkillRange					   3 // 스킬사정거리
	SkillSP						  10 // SP소모량
	SkillGlobalPostDelay		2000 // 스킬사용후 전체스킬사용금지시간	
return

SetSkill RA_FIRINGTRAP //파이어링트랩(SKID_RA_FIRINGTRAP)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND	
	SkillProperty   PROPERTY_Fire
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag		SKFLAG_PLUS_TRAP_RANGE_RA_RESEARCHTRAP
	SkillRange		  3		  3		  3		  3		  3 // 스킬사정거리
	SkillSP			 10		 10		 10		 10		 10 // SP소모량	
	SkillData1		 60		 70		 80		 90		100 // 발화 확률
return

SetSkill RA_ICEBOUNDTRAP //아이스바운드트랩(SKID_RA_ICEBOUNDTRAP)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND	
	SkillProperty   PROPERTY_Water
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag		SKFLAG_PLUS_TRAP_RANGE_RA_RESEARCHTRAP
	SkillRange		  3		  3		  3		  3		  3 // 스킬사정거리
	SkillSP			 10		 10		 10		 10		 10 // SP소모량	
	SkillData1		 60		 70		 80		 90		100 // 빙결 확률
return

//미케닉
SetSkill NC_MADOLICENCE //마도기어 라이센스(SKID_NC_MADOLICENCE)
OnInit:
	SkillMaxLv	5
	SkillType	PASSIVE
	SkillData1	15	30	45	60	75	// ATK 증가
	SkillData2	40	30	20	10	 0	// 이동속도 감소 %
return

SetSkill NC_BOOSTKNUCKLE //부스트 너클(SKID_NC_BOOSTKNUCKLE)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag		SKFLAG_NODISPEL
	SkillRange				   11      11      11      11      11 // 스킬사정거리	
	SkillSP					    3	    6	    9	   12	   15 // SP소모량
	SkillAtkPer				  200	  250	  300	  350	  400 // 공격데미지증가율(%)
	SkillCastFixedDelay         		    0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	     		  200	  400	  600	  800	 1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay			    0	    0	    0	    0       0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        		    0	    0	    0	    0	    0 // 스킬사용후 전체스킬사용금지시간
return

SetSkill NC_PILEBUNKER //파일 벙커(SKID_NC_PILEBUNKER)
OnInit:
	SkillMaxLv		3
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				    3	    3	    3// 스킬사정거리
	SkillSP					   50	   50	   50 // SP소모량
	SkillAtkPer				  200     250     300 // 공격데미지증가율(%)
	SkillCastFixedDelay         		   0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        	   0	    0	    0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 	5000	 5000	 5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     		2000	 2000	 2000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				  40	   55	   70 // 버프 해제 확률(%)
return


SetSkill NC_VULCANARM //발칸 암(SKID_NC_VULCANARM)
OnInit:
	SkillMaxLv		3
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				   13	   13	   13 // 스킬사정거리
	SkillSP						2       4       6 // SP소모량
	SkillAtkPer				  100	  125	  150 // 공격데미지증가율(%)
	SkillCastFixedDelay         0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0	    0	    0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0	    0	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      300	  200	  100 // 스킬사용후 전체스킬사용금지시간
return


SetSkill NC_FLAMELAUNCHER //플레어 런쳐(SKID_NC_FLAMELAUNCHER)
OnInit:
	SkillMaxLv		3
	SkillType		TOCHARACTER	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillProperty	PROPERTY_Fire
	SkillFlag		SKFLAG_NODISPEL
	SkillRange					  7	     7	     7 // 스킬사정거리
	SkillSP					  	 20     20      20 // SP소모량
	SkillAtkPer				  	100	   150	   200 // 공격데미지증가율(%)
	SkillCastFixedDelay       	500	   500	   500 // 스킬 캐스팅 고정 delay값	
	SkillCastStatDelay	  		500	  1000	  1500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	      0	     0       0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       1500	  1000	   500 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				   	 30	    40	    50 // 발화 발생 확률
	SkillData2			       7000  14000   21000 // 발화 지속 시간
	SkillData3			          2      3       4 // 효과범위
return

SetSkill NC_COLDSLOWER //콜드 슬로어(SKID_NC_COLDSLOWER)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillProperty	PROPERTY_Water
	SkillFlag		SKFLAG_NODISPEL
	SkillRange					7	   7	   7 // 스킬사정거리
	SkillAtkPer				  100	 150	 200 // 공격데미지증가율(%)
	SkillSP					   20     20	  20 // SP소모량
	SkillCastFixedDelay         0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	     1000	1000	1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0	   0       0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000	2000	3000 // 스킬사용후 전체스킬사용금지시간		
	SkillData1					2	   3	   4 // 효과범위(반경)
	SkillData2				   10	  20	  30 // 동빙 발생 확률
	SkillData3				   30	  40	  50 // 빙결 발생 확률
return

SetSkill NC_ARMSCANNON //암즈 캐논(SKID_NC_ARMSCANNON)
OnInit:
	SkillMaxLv		3
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK	
	SkillFlag		SKFLAG_NODISPEL
	SkillRange					9	  11	  13 // 스킬사정거리
	SkillSP					   40     45      50 // SP소모량
	SkillCastFixedDelay	      600	 400	 200 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	     1400	1600	1800 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    	0	   0       0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay          500	1000	2000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					3	   2	   1 // 스플래쉬 범위
	SkillData2			      800   1000    1200 // 소형에 대한 공격데미지증가율(%)
	SkillData3				  600    800    1000 // 중형에 대한 공격데미지증가율(%)
	SkillData4				  400	 500	 800 // 대형에 대한 공격데미지증가율(%)
return

SetSkill NC_ACCELERATION //액셀레이션(SKID_NC_ACCELERATION)
OnInit:
	SkillMaxLv	3
	SkillType	TOME
	SkillSP					   20     40	  60 // SP소모량
	SkillCastFixedDelay			0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0	   0       0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0	   0	   0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				60000  90000   120000 // 지속시간
return

SetSkill NC_HOVERING //호버링(SKID_NC_HOVERING)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP		   25 // SP소모량
	SkillData1	90000 // 지속시간
return

SetSkill NC_F_SIDESLIDE //프론트 사이드 슬라이드(SKID_NC_F_SIDESLIDE)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP				        5 // SP소모량
	SkillCastFixedDelay			0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      500 // 스킬사용후 전체스킬사용금지시간
return

SetSkill NC_B_SIDESLIDE //백 사이드 슬라이드(SKID_NC_B_SIDESLIDE)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP					    5 // SP소모량
	SkillCastFixedDelay			0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      500 // 스킬사용후 전체스킬사용금지시간	
return

SetSkill NC_MAINFRAME //메인프레임 개조(SKID_NC_MAINFRAME)
OnInit:
	SkillMaxLv	4
	SkillType	PASSIVE
	SkillData1		40	60 	80	100 // DEF
	SkillData2		10	20	30	40 // 연료소지량
	SkillData3		50	130	210	300 // 오버히트 리미트
return

SetSkill NC_SELFDESTRUCTION //셀프 디스트럭션(SKID_NC_SELFDESTRUCTION)
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag		SKFLAG_NODISPEL
	SkillSP					     1	    1	   1 // 실제 소모되는 SP는 서버에서 처리함.(주의 값 0으로 주면 안됨)
	SkillCastFixedDelay		   500	  500	 500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	      2000	 1500	1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	300000 300000 300000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay		 0	    0	   0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 2	    3	   4 // 데미지 적용반경
return

SetSkill NC_SHAPESHIFT //셰이프 쉬프트(SKID_NC_SHAPESHIFT)
OnInit:
	SkillMaxLv		4
	SkillType		TOME
	SkillSP					  100	   100	   100	   100 // SP소모량
	SkillCastFixedDelay		 2000	  2000	  2000	  2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0	     0	     0	     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	 2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				 6360	  6363	  6362	  6361 // 스칼렛포인트(6360), 라임그린포인트(6363), 옐로우위시포인트(6362), 인디고포인트(6361)
	SkillData2			   300000	300000	300000	300000 // 지속시간
	SkillData3				PROPERTY_Fire PROPERTY_Ground PROPERTY_Wind PROPERTY_Water // 레벨별 갑옷 속성
	
return

SetSkill NC_EMERGENCYCOOL //이머전시 쿨(SKID_NC_EMERGENCYCOOL)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP					   20 // SP소모량
	SkillCastFixedDelay			0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	  500 // 스킬사용후 전체스킬사용금지시간
return


SetSkill NC_INFRAREDSCAN //인프라레드 스캔(SKID_NC_INFRAREDSCAN)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillSP					   45 // SP소모량
	SkillCastFixedDelay		    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  3000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	  500 // 스킬사용후 전체스킬사용금지시간	
return

SetSkill NC_ANALYZE //애널라이즈(SKID_NC_ANALYZE)
OnInit:
	SkillMaxLv	3
	SkillType	TOCHARACTER
	SkillSP					   30	  30	  30 // SP소모량
	SkillRange					9	   9	   9 // 스킬사정거리
	SkillCastFixedDelay		 1000	1000	1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	 1000	1000	1000 // 스킬사용후 전체스킬사용금지시간		
	SkillData1				   42	  54	  66 // 성공율(%)
	SkillData2				   14	  28	  42 // 물리,마법 방어력 감소율(%)
	SkillData3              20000  20000   20000 // 지속시간
return

SetSkill NC_MAGNETICFIELD //마그네틱 필드(SKID_NC_MAGNETICFIELD)
OnInit:
	SkillMaxLv	3
	SkillType	TOME
	SkillSP						60	    70	    80 // SP소모량
	SkillCastFixedDelay			 0		 0		 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	         0	     0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 20000   15000   10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간
	SkillData1					 2		 2		 2 // 적용반경
	SkillData2				  4000	  6000	  8000 // 이동불가 기본 지속시간
	SkillData3					50		50		50 // 1초당 SP 감소량
return

SetSkill NC_NEUTRALBARRIER //뉴트럴 배리어(SKID_NC_NEUTRALBARRIER)
OnInit:
	SkillMaxLv	3
	SkillType	TOME
	SkillSP						80		90	   100 // SP소모량
	SkillCastFixedDelay			 0		 0		 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	         0	     0	     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 20000	 15000	 10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					15	    20      25 // 물리,마법 방어력 증가량
	SkillData2				 30000	 45000	 60000 // 지속시간
return

SetSkill NC_STEALTHFIELD //스텔스 필드(SKID_NC_STEALTHFIELD)
OnInit:
	SkillMaxLv	3
	SkillType	TOME
	SkillSP					   80	  100	  120 	// SP소모량	
	SkillCastFixedDelay		    0	    0		0 	// 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		    0	    0		0 	// 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	20000	15000	10000 	// 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay		0		0		0 	// 스킬사용후 전체스킬사용금지시간			
	SkillData1				15000   20000   25000 	// 지속시간
	SkillData2				 3000	 4000    5000 	// 몇초당 1% SP 소모시키는지
return

SetSkill NC_REPAIR //리페어(SKID_NC_REPAIR)
OnInit:
	SkillMaxLv	5
	SkillType	TOALL
	SkillSP					  25	  30	  35	  40	  45 // SP소모량	
	SkillRange				   5	   6	   7	   8	   9 // 스킬사정거리
	SkillCastFixedDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		 200	 300	 400	 500	 600 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	   0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	1000	1000	1000	1000	1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				   4	   7	  13	  17	  23 // 대상의 MHP % 회복량	
	SkillData2				12392	12392  12393   12393   12394 // 레베렬에 따른 필요아이템 리페어A ~ 리페어C
return

SetSkill NC_TRAININGAXE //도끼수련(SKID_NC_TRAININGAXE)
OnInit:
	SkillMaxLv	10
	SkillType	PASSIVE
	SkillData1		5	10	15	20	25	30	35	40	45	50 // 도끼, 양손도끼 장비시 공격력 증가
	SkillData2		3	 6	 9	12	15	18	21	24	27	30 // 도끼, 양손도끼 장비시 명중률 증가
	SkillData3		4	 8	12	16	20	24	28	32	36	40 // 둔기, 양손둔기 장비시 공격력 증가
	SkillData4		2	 4	 6	 8	10	12	14	16	18	20 // 둔기, 양손둔기 장비시 명중률 증가	
return


SetSkill NC_RESEARCHFE //불과 대지의 연구(SKID_NC_RESEARCHFE)
OnInit:
	SkillMaxLv  5
	SkillType	PASSIVE
	SkillData1	10	20	30	40	50 // 화,지속성 몬스터에 내성
	SkillData2	10	20	30	40	50 // 화,지속성 몬스터에 추가공격력
return


SetSkill NC_AXEBOOMERANG //액스 부메랑(SKID_NC_AXEBOOMERANG)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				   5	   6	   7	   8	   9 // 스킬사정거리
	SkillSP					  20      22      24      26      28 // SP소모량
	SkillAtkPer				 200	 240	 280	 320	 360 // 공격데미지증가율(%)
	SkillCastFixedDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	5000	4500	4000	3500	3000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillData1				   2	   3	   4	   5	   6 // 넉백거리
return

SetSkill NC_POWERSWING //파워 스윙(SKID_NC_POWERSWING)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP		   	  20	  22	  24	  26	  28 // SP소모량
	SkillAtkPer	    	 400	 500	 600	 700	 800 // 공격데미지증가율(%)
	SkillCastFixedDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	   0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	1000	1000	1000	1000	1000 // 스킬사용후 전체스킬사용금지시간	
return

SetSkill NC_AXETORNADO //액스 토네이도(SKID_NC_AXETORNADO)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					  18	  20	  22	  24	  26 // SP소모량
	SkillAtkPer			     250	 300	 350	 400	 450 // 공격데미지증가율(%)
	SkillCastFixedDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	4000	3500	3000	2500	2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	 500	 500	 500	 500	 500 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				  20	  40	  60	  80	 100 // HP 소모
	SkillData2				   2       2	   3	   3	   3 // 적용반경
return


SetSkill NC_SILVERSNIPER //실버 스나이퍼(SKID_NC_SILVERSNIPER)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillFlag		SKFLAG_NODISPEL	// 캐스팅이 끊기지 않도록 수정
	SkillRange				   2	   2	   2	   2	   2 // 스킬사정거리
	SkillSP					  25      30      35      40      45 // SP소모량
	SkillCastFixedDelay		1800	1600	1400	1200	1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	   0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	   0	   0	   0	   0	   0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				   0	 200	 400	 800	1000 // 추가공격력
	SkillData2	        20000   30000   40000   50000   60000 // 지속시간
return


SetSkill NC_MAGICDECOY //매직 디코이(SKID_NC_MAGICDECOY)-마법의 허수아비
OnInit:
	SkillMaxLv	5
	SkillType	TOGROUND	
	SkillFlag   SKFLAG_NODISPEL	// 캐스팅이 끊기지 않도록 수정
	SkillSP					  40	  45	  50	  65	  70 // SP소모량	
	SkillRange				   2	   2	   2	   2	   2 // 스킬사정거리
	SkillCastFixedDelay		1800	1600	1400	1200	1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		   0	   0	   0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	   0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	   0	   0	   0	   0	   0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1			   20000   30000   40000   50000   60000 // 지속시간
	SkillData2				 300	 350	 400	 450	 500 // 마법MATK 증가량 절대값으로 사용된다.	
return

SetSkill NC_DISJOINT //FAW해체(SKID_NC_DISJOINT)
OnInit:
	SkillMaxLv	1
	SkillType	TOCHARACTER
	SkillRange				   5 // 스킬사정거리
	SkillSP					  15 // SP소모량
	SkillCastFixedDelay		   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	   0 // 스킬사용후 전체스킬사용금지시간	
return



//1차직업때 찍은 Job Level을 RemainMS에 저장하고 있다.
SetSkill SYS_FIRSTJOBLV 
OnInit:
	SkillMaxLv 1
return

//2차직업때 찍은 Job Level을 RemainMS에 저장하고 있다.
SetSkill SYS_SECONDJOBLV 
OnInit:
	SkillMaxLv 1
return




//__THIRDJOB1
//********************************************************************************************************************/



//*** __THIRDJOB2 *************************************************************************** 

SetSkill SC_FATALMENACE //페이탈메나스-섀도우체이서
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입
	SkillRange                   1	     1	     1	     1	     1 // 스킬사정거리
	SkillSP                     20      25      30      35      40  
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0	     0	     0	     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500     500	   500	   500 // 스킬사용후 전체스킬사용금지시간
	SkillData1					30	    25      20      15      10 // 명중률 보정값 * (-1)
return

SetSkill SC_REPRODUCE //리프로듀스-섀도우체이서
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Nothing  //속성없음
	SkillType TOME					//자기자신에게사용
	SkillPattern SKILLPATT_NONE     //공격스킬아님
	SkillSP                   40	  45	  50	  55	  60	  65	  70	  75	  80	  85
	SkillCastFixedDelay        0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		   0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	   0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	1000	1000	1000	1000	1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				   8	   8	   7	   7	   6	   6	   5	   5	   4	   4 // 초당SP소모량	
return

SetSkill SC_AUTOSHADOWSPELL //오토섀도우스펠-섀도우체이서
OnInit:
	SkillMaxLv		10
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE //공격스킬 아님
	SkillSP                     40      45      50      55      60       65     70      75      80      85 // 이값이 클라이언트에서 %로 화면에 출력되게 된다.0이면 시전이 않된다. 주의하라.
	SkillCastFixedDelay		  2000    2000    2000    2000    2000     2000   2000    2000    2000    2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  4000	  3600    3200    2800    2400     2000   1600    1200     800     400 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0       0       0       0       0       0       0       0       0       0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	     0	     0	     0	     0	     0	     0	     0       0       0       0 // 스킬사용후 전체스킬사용금지시간 
	SkillData1				 60000	 80000	100000	120000	140000	160000	180000	200000	220000	300000 // 지속시간
	SkillData2				   280	   260     240     220     200     180     160     140     120     150 // 발동확률(milipercent)
	SkillData3				     1	     1       2       2       3       3       4       4       5       5 // 최대 발동레벨
return

SetSkill SC_SHADOWFORM //섀도우폼-섀도우체이서
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillRange                   5	    5	    5	    5	    5 // 스킬사정거리
	SkillSP                     40     50      60      70      80  
	SkillCastFixedDelay          0	    0	    0	    0       0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	    0	    0	    0	    0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	    0	    0	    0	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	 1000    1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				    10	    9	    8	    7       6 // 초당 sp 소모량
	SkillData2				     5      6       7       8       9 // 효과횟수
	SkillData3				 30000	40000	50000	60000	70000 // 지속시간
return


SetSkill SC_TRIANGLESHOT //트라이앵글샷-섀도우체이서
OnInit:
	SkillMaxLv		10
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입
	SkillRange                   7	     7	     7	     9	     9		 9		 9	    11	    11		11 // 스킬사정거리
	SkillSP                     22	    24	    26	    28	    30		32	    34	    36		38	    40
	SkillCastFixedDelay          0	     0	     0	     0	     0	     0	     0	     0       0       0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500	   500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간
	SkillData1					 2	     3		 4	     5	     6	     7       8       9      10      11 // 넉백발동확률(%)
	SkillData2					 3	     3		 3	     3	     3	     3       3       3       3       3 // 넉백거리
return


SetSkill SC_BODYPAINT //바디페인팅-섀도우체이서
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillRange                   1	    1	    1	    1	    1 // 스킬사정거리
	SkillSP                     10     15      20      25      30  
	SkillCastFixedDelay          0	    0	    0	    0       0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	    0	    0	    0	    0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	 2000	 2000	 2000	 2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	 1000    1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     2	    2	    2	    2       2 // 디텍트반경(5x5인경우 2)
	SkillData2				    55     57      59      61      63 // 암흑발동확률(%)
	SkillData3				    25     30      35      40      45 // 공속감소 발동확률(%)
	SkillData4				  5000   7000	 9000	11000	13000 // 공속감소 지속시간
return

SetSkill SC_INVISIBILITY //인비지빌리티-섀도우체이서
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillRange                   1	    1	    1	    1	    1 // 스킬사정거리
	SkillSP                    100	  100	  100	  100	  100
	SkillCastFixedDelay          0	    0	    0	    0       0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	 1000	 1000	 1000	 1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 20000   30000  40000   50000   60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	 1000    1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				    20	   40	   60	   80	  100 // 크리티컬 발생확률 증가(%)
	SkillData2				    40     30      20      10       0 // 공속감소률(%)
	SkillData3				    10      8       6       4       2 // 초당소모SP(MSP * 값/100)	
return

SetSkill SC_DEADLYINFECT //데들리인펙트-섀도우체이서
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillRange                   1	    1	    1	    1	    1 // 스킬사정거리
	SkillSP                     40	   44	   48	   52	   56
	SkillCastFixedDelay          0	    0	    0	    0       0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	    0	    0	    0	    0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	 2000	 2000	 2000	 2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	 1000    1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1		 10000  15000	20000	25000	30000 // 지속시간
	SkillData2		    40	   50	   60	   70	   80 // 성공확률
return


SetSkill SC_ENERVATION //마스커레이드:이너베이션-섀도우체이서
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입	
	SkillRange                   3	     3	     3 // 스킬사정거리
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 10000	 15000   20000 // 타겟의 공격력감소유지시간
	SkillData2				    30	    40	    50 // 타겟의 공격력감소량(%)
return


SetSkill SC_GROOMY //마스커레이드:그루미-섀도우체이서
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입	
	SkillRange                   3	     3	     3 // 스킬사정거리
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 10000	 15000   20000 // 타겟의 공속&명중률 감소유지시간
	SkillData2				    30	    40	    50 // 타겟의 공속감소%
	SkillData3				    20	    40	    60 // 타겟의 명중률감소%
return

SetSkill SC_IGNORANCE //마스커레이드:이그노어런스
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입	
	SkillRange                   3	     3	     3 // 스킬사정거리
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 10000	 15000   20000 // 무지효과 유지시간
	SkillData2				   100	   200     300 // 타겟의 sp감소량
	SkillData3				    50	   100     150 // 시전자의 sp증가량
return

SetSkill SC_LAZINESS //마스커레이드:레이지네스(SKID_SC_LAZINESS)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입	
	SkillRange                   3	     3	     3 // 스킬사정거리
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 10000	 15000   20000 // 게으름효과 유지시간
	SkillData2					20		30      40 // 캐스팅속도 증가량%
	SkillData3					10		20      30 // 회피율감소량(%)
	SkillData4					10		20      30 // 스킬사용시 sp감소 추가량(amount)
return


SetSkill SC_UNLUCKY // 마스커레이드:언럭키(SKID_SC_UNLUCKY)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입	
	SkillRange                   3	     3	     3 // 스킬사정거리
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 10000	 15000   20000 // 불운(不運) 효과 유지시간
	SkillData2				    10	    20	    30 // 크리티컬 감소%
	SkillData3				    10	    20	    30 // 완전회피률 감소%
	SkillData4				   250	   500	  1000 // 스킬사용시 소모돼는 제니
return

SetSkill SC_WEAKNESS //마스커레이드:위크니스(SKID_SC_WEAKNESS)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입	
	SkillRange                   3	     3	     3 // 스킬사정거리
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 10000	 15000   20000 // 불운(不運) 효과 유지시간
	SkillData2				    10	    20	    30 // MHP감소값(%)
return

SetSkill SC_STRIPACCESSARY //스트립액세서리(SKID_SC_STRIPACCESSARY)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입	
	SkillRange                   3	     3	     3	    3       3 // 스킬사정거리
	SkillSP                     15	    18	    21     24      27
	SkillCastFixedDelay          0	     0	     0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000   1000	 1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0	    0	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 60000	 70000	 80000	90000  100000 // 효과 유지시간
	SkillData2				    14		16		18	   20	   22 // 성공확률
return

SetSkill SC_MANHOLE //맨홀(SKID_SC_MANHOLE)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                   7	     7	     7 // 스킬사정거리
	SkillSP                     20	    25	    30 
	SkillCastFixedDelay			 0		 0		 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간 
	SkillData1				  5000	 10000	 15000 // 지속시간	
	SkillData2				  5000	 10000	 15000 // 효과 지속시간	
return

SetSkill SC_DIMENSIONDOOR //디멘션도어(SKID_SC_DIMENSIONDOOR)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                   7	     7	     7 // 스킬사정거리
	SkillSP                     30	    36	    42 
	SkillCastFixedDelay			 0		 0		 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  4000	  8000	 12000 // 지속시간
return

SetSkill SC_CHAOSPANIC //카오스패닉(SKID_SC_CHAOSPANIC)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                   7	     7	     7 // 스킬사정거리
	SkillSP                     30	    36	    42 
	SkillCastFixedDelay			 0		 0		 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  5000	 10000	 15000 // 지속시간
	SkillData2				    50      65      80 // 성공확률
return

SetSkill SC_MAELSTROM //마엘슈트롬(SKID_SC_MAELSTROM)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                   7	     7	     7 // 스킬사정거리
	SkillSP                     50	    55	    60 
	SkillCastFixedDelay			 0		 0		 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  7000	 14000	 21000 // 지속시간	
return


SetSkill SC_BLOODYLUST //블러디러스트(SKID_SC_BLOODYLUST)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                   7	     7	     7 // 스킬사정거리
	SkillSP                     60	    70	    80 
	SkillCastFixedDelay			 1000		 1000		 1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		180000		180000		 180000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 5000	 10000	 15000 // 지속시간
return


SetSkill SC_FEINTBOMB //페인트봄(SKID_SC_FEINTBOMB)
OnInit:
	SkillMaxLv		3
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillFlag		SKFLAG_NODISPEL //캐스팅 중 데미지를 입어도 끊기지 않는다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillRange                   1	    1	    1 // 스킬사정거리
	SkillSP                     24	   28	   32
	SkillCastFixedDelay          0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	 1000	 1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	 5000	 5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay		 0		0		0 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     2	    2       2 // 공격범위(반경)
return

// 원더러(Wanderer) & 민스트럴(Minstrel)
SetSkill WA_SWING_DANCE //스윙댄스(SKID_WA_SWING_DANCE)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                     96	   112	   128	   144     160 // SP소모량 
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	  2000	  2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 60000   60000   60000   60000   60000 // 효과지속시간
	SkillData2				     7 	     8       9      10      11 // 유효범위(반경)
//	SkillData3				     4	     8	    12	    16 	    20 // 공격속도 증가(%)
return

SetSkill WA_SYMPHONY_OF_LOVER //연인들을 위한 심포니(SKID_WA_SYMPHONY_OF_LOVER)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                     60	    69	    78	    87	    96 // SP소모량 
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	  2000	  2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 60000   60000   60000   60000   60000 // 효과지속시간
	SkillData2				     7       8       9      10      11 // 유효범위(반경)
return

SetSkill WM_LESSON //레슨(SKID_WM_LESSON)
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Nothing    // 속성없음
	SkillType PASSIVE                 // 패시브스킬
	SkillPattern SKILLPATT_NONE       // 공격스킬아님	
	SkillData1				 30		 60		 90		120		150		180		210		240		270		300 // MSP증가값(amount)
return

SetSkill WM_METALICSOUND //메탈릭사운드(SKID_WM_METALICSOUND)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL // 마법 공격 스킬타입
	SkillRange                   9	     9	     9	     9       9 // 스킬사정거리
	SkillSP                     64	    68	    72      76      80 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1500	  2000    2500    3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000    2500    3000    3500    4000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData3				     2	     2		 3		 3		 4 // 타격횟수
return

SetSkill WM_REVERBERATION //진동잔향(SKID_WM_REVERBERATION)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   9	     9	     9	     9	     9 // 스킬사정거리
	SkillSP                     28	    32	    38	    42	    48 // SP소모량 
	SkillCastFixedDelay			 0		 0		 0       0       0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1100	  1200	  1300	  1400	  1500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  9000	 10000	 11000	 12000	 13000 // 지속시간
	SkillData2				   400	   500	   600     700     800 // 물리공격데미지 percent
	SkillData3				   200	   300	   400     500     600 // 마법공격데미지 percent
return

SetSkill WM_REVERBERATION_MELEE //진동잔향-물리공격(SKID_WM_REVERBERATION_MELEE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing       //속성이 없다.
	SkillType		TOCHARACTER            //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK //직근접 물리 공격 스킬타입
return

SetSkill WM_REVERBERATION_MAGIC //진동잔향-마법공격(SKID_WM_REVERBERATION_MAGIC)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing       //속성이 없다.
	SkillType		TOCHARACTER            //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL // 마법 공격 스킬타입
return

SetSkill WM_DOMINION_IMPULSE //도미니온임펄스(SKID_WM_DOMINION_IMPULSE)
OnInit:
	SkillMaxLv		1
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                  11 // 스킬사정거리
	SkillSP                     10 // SP소모량 
	SkillCastFixedDelay			 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     5 // 효과범위(반경)
return


SetSkill WM_SEVERE_RAINSTORM //서비어레인스톰(SKID_WM_SEVERE_RAINSTORM)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입
	SkillAtkPer		   100	   150	   200	   250	   300 // 공격데미지증가율(%)	
	SkillRange                   9	     9	     9	     9	     9 // 스킬사정거리
	SkillSP                     80	    90	   100	   110	   120 // SP소모량 
	SkillCastFixedDelay	   500	   500     500     500     500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  1500	  2000	  2500	  3000	  3500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5500	  6000	  6500	  7000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1		    12	    12	    12	    12	    12 // 총타격횟수
return

SetSkill WM_SEVERE_RAINSTORM_MELEE // 서비어레인스톰-물리공격(SKID_WM_SEVERE_RAINSTORM_MELEE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing       //속성이 없다.
	SkillType		TOCHARACTER            //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK //직근접 물리 공격 스킬타입
	SkillRange                  11	   11	   11	   11      11 // 스킬사정거리
return


SetSkill WM_POEMOFNETHERWORLD //나락의노래(SKID_WM_POEMOFNETHERWORLD)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   9	     9	     9	     9	     9 // 스킬사정거리
	SkillSP                     12	    16	    20	    24	    28 // SP소모량 
	SkillCastFixedDelay			 0		 0		 0       0       0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  3000	  3000	  3000	  3000	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  9000	 11000	 13000	 15000	 17000 // 지속시간
	SkillData2				  8000   10000   12000   14000   16000 // 효과지속시간
return

SetSkill WM_VOICEOFSIREN //사이렌의 목소리(SKID_WM_VOICEOFSIREN)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                     48	    56	    64	    72	    80 // SP소모량 
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2200	  2400	  2600	  2800 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000    5000    5000    5000    5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	  1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData2				     2       3       4       5       6 // 효과적용범위(반경)
	SkillData3				 15000	 18000	 21000   24000   27000 // 효과유지시간
return

SetSkill WM_DEADHILLHERE //사망의골짜기에서(SKID_WM_DEADHILLHERE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                   7	     7	     7	     7       7 // 스킬사정거리
	SkillSP                     50	    53	    56      59      62 // SP소모량
	SkillCastFixedDelay       1000    1000	  1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  3000	  2500	  2000    1500    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  	 0		 0		 0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				    90		92		94	    96	    98 // 성공활률(%)
	SkillData2				    50      40      30      20      10 // 부활시 대상케릭의 SP 소모률(%)
return

SetSkill WM_LULLABY_DEEPSLEEP //안식의자장가(SKID_WM_LULLABY_DEEPSLEEP)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillSP                     80	    90	   100	   110	   120 // SP소모량 
	SkillCastFixedDelay		  1000    1000    1000    1000    1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 10000	 10000   10000   10000   10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     5       6       7       8       9 // 효과적용 반경
	SkillData3				 12000	 14000	 16000	 18000	 20000 // 효과지속시간
return

SetSkill WM_SIRCLEOFNATURE //순환하는자연의소리(SKID_WM_SIRCLEOFNATURE)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //속성이 없다.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                     42	    46	    50	    54	    58 // SP소모량 
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 15000	 15000	 15000	 15000	 15000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	  1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				 60000   60000   60000   60000   60000 // 효과유지시간
	SkillData2				     4       8      12      16      20 // 대상의 초당 sp 소모량
	SkillData3				    40      80     120     160     200 // 대상의 초당 hp 회복량
	SkillData4				     3       4       5       6       7 // 적용반경
return

SetSkill WM_RANDOMIZESPELL //불확정요소의언어(SKID_WM_RANDOMIZESPELL)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillRange                   9	     9	     9	     9       9 // 스킬사정거리
	SkillSP                     40	    45	    50      55      60 // SP소모량
	SkillCastFixedDelay          0       0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0	     0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  3000	  3000	  3000	  3000	  3000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     5		 6		 7	     8	     9 // 발동돼는 스킬의 레벨 
return

SetSkill WM_GLOOMYDAY // 수줍은 하루의 우울(SKID_WM_GLOOMYDAY)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing       // 속성이 없다.
	SkillType		TOALL //자기자신포함
	SkillPattern	SKILLPATT_NONE		   // 공격스킬아님	
	SkillRange                   9	     9	     9	     9       9 // 스킬사정거리
	SkillSP                     60	    75	    90     105     120 // SP소모량
	SkillCastFixedDelay        500     500	   500	   500	   500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 10000   10000   10000   10000   10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				    25		30		35	    40	    45 // 회피감소(amount)
	SkillData2				    20		25		30	    35	    40 // 공속감소(%)
	SkillData3				 30000	 45000	 60000	 75000	 90000 // 효과지속시간
return

SetSkill WM_GREAT_ECHO //그레이트 에코(SKID_WM_GREAT_ECHO)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   9	     9	     9	     9	     9 // 스킬사정거리
	SkillSP                     80	    90	   100	   110	   120 // SP소모량 
	SkillAtkPer				  1000	  1100	  1200	  1300	  1400 // 공격데미지증가율(%)	
	SkillCastFixedDelay		   500	   500	   500     500     500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	  2200	  2400	  2600	  2800 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     2       3       3       4       4 // 공격적용 반경	
return

SetSkill WM_SONG_OF_MANA //마나의 노래(SKID_WM_SONG_OF_MANA)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                    120	   140	   160     180     200 // SP소모량
	SkillCastFixedDelay        500     500	   500	   500	   500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 90000	 90000	 90000	 90000	 90000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 30000	 60000	 90000	120000	150000 // 효과지속시간
	SkillData2				     5       6       7       8       9 // 적용반경
return

SetSkill WM_DANCE_WITH_WUG //워그와 함께 춤을(SKID_WM_DANCE_WITH_WUG)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                    120	   140	   160     180     200 // SP소모량
	SkillCastFixedDelay        500     500	   500	   500	   500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1500	  2000	  2500    3000    3500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 90000	 90000	 90000	 90000	 90000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 30000	 60000	 90000	120000	150000 // 효과지속시간
	SkillData2				     5       6       7       8       9 // 적용반경
return

SetSkill MI_RUSH_WINDMILL //풍차를 향해 돌격(SKID_MI_RUSH_WINDMILL)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                     82	    88	    94     100     106 // SP소모량
	SkillCastFixedDelay          0       0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 60000   60000   60000   60000   60000 // 효과지속시간
	SkillData3				     7       8       9      10      11 // 효과적용반경
return

SetSkill MI_ECHOSONG //메아리의 노래(SKID_MI_ECHOSONG)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                     86	    92	    98     104     110 // SP소모량
	SkillCastFixedDelay          0       0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 60000   60000   60000   60000   60000 // 효과지속시간
	SkillData3				     7	     8       9      10      11 // 효과적용반경
return

SetSkill MI_HARMONIZE //하모나이즈(SKID_MI_HARMONIZE)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOALL //자기자신포함
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                  9	    9	    9	    9	    9 // 스킬사정거리
	SkillSP                    70	   75	   80	   85	   90 // SP소모량
	SkillCastFixedDelay         0	    0		0		0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	     1000	 1000	 1000	 1000	 1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 5000	 5000	 5000	 5000	 5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간 
	SkillData1			    60000   60000   60000   60000   60000 // 효과지속시간
	SkillData2				   10	   15	   20	   25	   30 // 모든스테이터스 가중치 감소값
return

SetSkill WA_MOONLIT_SERENADE // 달빛의 세레나데(SKID_WA_MOONLIT_SERENADE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                     84	    96	   108     120     134 // SP소모량
	SkillCastFixedDelay          0       0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 60000   60000   60000   60000   60000 // 효과지속시간
	SkillData2				    10	    20      30      40      50 // 추가 마법공격력증가(%)
	SkillData3				     7	     8       9      10      11 // 효과적용 반경
return

SetSkill WM_SOUND_OF_DESTRUCTION //사운드 오브 디스트럭션(SKID_WM_SOUND_OF_DESTRUCTION)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //아무런속성이 없다.
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillAtkPer				  500	  500	  500	  500	  500 // 공격데미지증가율(%)
	SkillRange                  9	    9	    9	    9	    9 // 스킬사정거리
	SkillSP                    50	   60	   70	   80	   90 // SP소모량
	SkillCastFixedDelay       500	  500	  500	  500	  500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	        0	  500	 1000	 1500	 2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 6000    7000    8000    9000   10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				    4	    4	    5	    6	    7 // 효과적용범위(반경)
return

SetSkill WM_SATURDAY_NIGHT_FEVER //새터데이 나이트 피버(SKID_WM_SATURDAY_NIGHT_FEVER)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                    150	   160	   170	   180	   190 // SP소모량
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  2000	  3000    4000    5000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	180000	180000	180000	180000	180000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1	 10000	 15000	 20000	 25000	 30000 // 광란효과지속시간	
	SkillData2				     3	     4	     5	     6	     7 // 적용반경
return

SetSkill WM_LERADS_DEW //레라드의 이슬(SKID_WM_LERADS_DEW)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                    120	   130	   140	   150	   160 // SP소모량
	SkillCastFixedDelay        500	   500	   500	   500	   500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	180000	180000	180000	180000	180000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 20000	 30000	 40000	 50000	 60000 // 효과지속시간	
	SkillData2				     5		 5	     6	     6	     7 // 효과적용반경	
	SkillData4				   200     400     600     800    1000 // MHP증가량
return

SetSkill WM_MELODYOFSINK //멜로디 오브 싱크(SKID_WM_MELODYOFSINK)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                    120	   130	   140	   150	   160 // SP소모량
	SkillCastFixedDelay        500	   500	   500	   500	   500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	180000	180000	180000	180000	180000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 20000	 30000	 40000	 50000	 60000 // 효과지속시간	
	SkillData2				     5		 5	     6	     6	     7 // 효과적용반경
	SkillData3				    20		25	    30	    35	    40 // 성공확률	
return


SetSkill WM_BEYOND_OF_WARCRY //비욘드 오브 워 크라이(SKID_WM_BEYOND_OF_WARCRY)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                    120	   130	   140	   150	   160 // SP소모량
	SkillCastFixedDelay        500	   500	   500	   500	   500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	180000	180000	180000	180000	180000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 20000	 30000	 40000	 50000	 60000 // 효과지속시간	
	SkillData2				     5		 5	     6	     6	     7 // 효과적용반경
	SkillData3				    20		25	    30	    35	    40 // 성공확률
return


SetSkill WM_UNLIMITED_HUMMING_VOICE //언리미티드 허밍 보이스(SKID_WM_UNLIMITED_HUMMING_VOICE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //속성이 없다.
	SkillType		TOME //자기자신
	SkillPattern	SKILLPATT_NONE  // 공격스킬아님	
	SkillRange                   1	     1	     1	     1       1 // 스킬사정거리
	SkillSP                    120	   130	   140	   150	   160 // SP소모량
	SkillCastFixedDelay        500	   500	   500	   500	   500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	110000	120000	130000	140000	150000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 60000	 90000	120000	150000	180000 // 효과지속시간	
	SkillData2				     5		 5	     6	     6	     7 // 효과적용반경
return

//소서러
SetSkill SO_FIREWALK //파이어 워크(SKID_SO_FIREWALK)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillProperty	PROPERTY_Fire
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP					    30	    34	    38	    42	    46 // SP소모량	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1               30000   30000   30000   30000   30000 // 셀을 생성할 수 있는 EFST_PROPERTYWALK 지속시간 
	SkillData2				     8	    10      12	    14	    16 // 셀 생성개수
	SkillData3				 12000	 12000	 12000	 12000	 12000 // 셀당 지속시간
	SkillData4					 1	     1		 1	      1		 1 // 셀 하나당 공격 횟수
return

SetSkill SO_ELECTRICWALK //일렉트릭 워크(SKID_SO_ELECTRICWALK)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillProperty	PROPERTY_Wind
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP						30	    34	    38	    42	    46 // SP소모량	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				 30000   30000   30000   30000   30000 // 셀을 생성할 수 있는 EFST_PROPERTYWALK 지속시간 
	SkillData2					 8	    10	    12	    14	    16 //셀 생성개수
	SkillData3				 12000	 12000	 12000	 12000	 12000 // 셀당 지속시간
	SkillData4					 1	     1	     1	     1	     1 // 셀 하나당 공격 횟수
return

SetSkill SO_SPELLFIST //스펠 피스트(SKID_SO_SPELLFIST)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillSP						40	    44	    48	    52	    56 // SP소모량
	SkillAtkPer				   50     100     150     200     250 // 추가 데미지 MATK %
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay			 0		 0		 0		 0		 0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				 20000   25000   30000   35000   40000 // 지속시간
	SkillData2				     2       3       4       5       6 // 타격횟수
return

SetSkill SO_PSYCHIC_WAVE //사이킥 웨이브(SKID_SO_PSYCHIC_WAVE)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9	     9	     9 // 스킬사정거리
	SkillSP						48	    56	    64	    70	    78 // SP소모량
	SkillAtkPer				   700	   700	   700	   700	   700 // 공격데미지증가율(%)
	SkillCastFixedDelay       1000	   900	   800	   700	   600 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  8000	  9000	 10000	 11000	 12000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 3		 4		 5		 6		 7 // 횟수
	SkillData2					 3		 3		 4		 4		 5 // 범위(반경) 7*7 7*7 9*9 9*9 11*11
return

SetSkill SO_CLOUD_KILL //클라우드 킬(SKID_SO_CLOUD_KILL)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillProperty	PROPERTY_Poison	
	SkillRange					 9		 9		 9		 9		 9 // 스킬사정거리
	SkillAtkPer				  1200	  1400	  1600	  1800	  2000 // 공격데미지증가율(%)
	SkillSP						48	    56	    64	    70	    78 // SP소모량	
	SkillCastFixedDelay       700	  500	  300	  100	  0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2300	  2500	  2700	  2900	  3100 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1					 3		 3		 3		 3		 3 // 범위 7*7
	SkillData2				  8000   10000   12000   14000   16000 // 독구름 지속시간
	SkillData3				 10000	 15000	 20000	 25000	 30000 // EFST_CLOUD_KILL (독속성으로 변함) 지속시간
return

SetSkill SO_POISON_BUSTER //포이즌 버스터(SKID_SO_POISON_BUSTER)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Poison
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP			70	90	   110	   130	   150 // SP소모량
	SkillRange		 	9	 9	 9	 9	 9 // 스킬사정거리
	SkillAtkPer		  1500    1800    2100    2400    2700 // 공격데미지증가율(%)
	SkillCastFixedDelay        800	   600	   400	   200	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  2200	  3400	  4600	  5800	  6000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1					 1		 1		 1		 1		 2 // 적용반경
return


SetSkill SO_STRIKING //스크라이킹(SKID_SO_STRIKING)
OnInit:
	SkillMaxLv		5
	SkillType		TOALL
	SkillSP					    50		55		60		65		70 // SP소모량
	SkillRange					 9		 9		 9		 9		 9 // 스킬사정거리
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				    35	    45	    55	    65	    75 // 무기공격력 증가
	SkillData2					10		20		30		40		50 // 크리티컬 증가%
	SkillData3					 2		 3		 4		 5		 6 // 제련성공율 증가%
	SkillData4               60000   60000   60000   60000   60000 // 지속시간
	SkillData5					 5		 4		 3		 2		 1 // 초당SP소모
return

SetSkill SO_EARTHGRAVE //어스 그레이브(SKID_SO_EARTHGRAVE)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Ground
	SkillPattern	SKILLPATT_ATTACKSPELL	
	SkillRange					 9		 9		 9		 9		 9 // 스킬사정거리
	SkillSP						62		70		78		86		94 // SP소모량	
	SkillCastFixedDelay       1800	  1600    1400	  1200	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  2200	  2400	  2600	  2800	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 3		 3		 3		 4		 4 // 효과범위(반경) - 범위 7*7 7*7 7*7 9*9 9*9
	SkillData2				     5		10		15		20		25 // 출혈 발생 확률(%)	
return

SetSkill SO_DIAMONDDUST //다이아몬드 더스트(SKID_SO_DIAMONDDUST)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Water
	SkillPattern	SKILLPATT_ATTACKSPELL	
	SkillRange					 9		 9		 9		 9		 9 // 스킬사정거리
	SkillSP						50		56		62		68		74 // SP소모량	
	SkillCastFixedDelay        800	   600	   400	   200	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  5000 	  5500	  6000	  6500	  7000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 3		 3		 3		 4		 4 // 효과범위(반경)
	SkillData2					10		15		20		25		30 // 냉동 발생 확률(%)	
return

SetSkill SO_WARMER //워머(SKID_SO_WARMER)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange					 9		 9		 9		 9		 9 // 스킬사정거리
	SkillSP						40		52		64		76		88 // SP소모량
	SkillCastFixedDelay       1800	  1600	  1400	  1200	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  2200	  2400	  2600	  2800	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 35000	 40000	 45000	 50000	 55000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1		     3	     3	     3	     3       3 // 효과범위(반경)
	SkillData2               40000   45000   50000   55000   60000 // 지속시간
return

SetSkill SO_VACUUM_EXTREME // 바큠 익스트림
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange					 9		 9		 9		 9		 9 // 스킬사정거리
	SkillSP						34		42		50		58		66 // SP소모량
	SkillCastStatDelay		  1000	  1500	  2000	  2500	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 1		 1		 2		 2		 3 // 효과범위(반경) 3*3 3*3 5*5 5*5 7*7
	SkillData2                4000    6000    8000   10000   12000 // 지속시간
return

SetSkill SO_VARETYR_SPEAR // 바레티르스피어
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Wind
	SkillPattern	SKILLPATT_ATTACKSPELL		
	SkillRange					 9		 9		 9		 9		 9 // 스킬사정거리
	SkillSP			    55	    62	    69	    76	    83 // SP소모량
	SkillCastFixedDelay       1800	  1600	  1400	  1200	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  2200	  2400	  2600	  2800	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  2000	  2000	  2000	  2000	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 1		 1		 2		 2		 3 // 대상의 주변 효과범위(반경) 3*3, 3*3, 5*5, 5*5, 7*7
	SkillData2                  10      15      20      25      30 // 스턴확률
return

SetSkill SO_ARRULLO // 아를로
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange		     7	     7	     7	     7	    9 // 스킬사정거리
	SkillSP			    30	    35	    40	    45	   50 // SP소모량
	SkillCastFixedDelay        800	   600	   400	   200	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  2200	  2400	  2600	  2800	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  6000	  7000	  8000	  9000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1		     1	     1	     2	     2	    3 // 대상의 주변 효과범위(반경) 3*3, 3*3, 5*5, 5*5, 7*7
	SkillData2                  20      25      30      35     40 // EFST_DEEP_SLEEP 성공확률
	SkillData3		  8000	 10000   12000   14000   16000 // EFST_DEEP_SLEEP 지속시간
return

SetSkill SO_SUMMON_AGNI // 불의 정령 소환
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Fire
	SkillSP					   100	   150	   200 // SP소모량
	SkillCastFixedDelay       2000	  2000	  2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay        1000	  2000	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 60000	 60000	 60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillData1			    600000  900000 1200000 // 지속시간
	SkillData2					 5		 8		11 // 10초당 소모 SP
	SkillData3				   990     990     994 // 촉매 아이템 - 레드블러드 레드블러드 프레임하트
	SkillData4					 3       6       1 // 촉매 아이템 갯수	
return

SetSkill SO_SUMMON_AQUA // 물의 정령 소환
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Water
	SkillSP					   100	   150	   200 // SP소모량
	SkillCastFixedDelay       2000	  2000	  2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay        1000	  2000	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 60000	 60000	 60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillData1			    600000  900000 1200000 // 지속시간
	SkillData2					 5		 8		11 // 10초당 소모 SP
	SkillData3				   991     991     995 // 촉매 아이템 - 크리스탈블루 크리스탈블루 미스틱프로즌
	SkillData4					 3       6       1 // 촉매 아이템 갯수
return

SetSkill SO_SUMMON_VENTUS // 바람의 정령 소환
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Wind
	SkillSP					   100	   150	   200 // SP소모량
	SkillCastFixedDelay       2000	  2000	  2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay        1000	  2000	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 60000	 60000	 60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillData1			    600000  900000 1200000 // 지속시간
	SkillData2					 5		 8		11 // 10초당 소모 SP
	SkillData3				   992     992     996 // 촉매 아이템 - 윈드오브버듀어 윈드오브버듀어 러프윈드 
	SkillData4					 3       6       1 // 촉매 아이템 갯수	
return


SetSkill SO_SUMMON_TERA // 땅의 정령 소환
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Ground
	SkillSP					   100	   150	   200 // SP소모량
	SkillCastFixedDelay       2000	  2000	  2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay        1000	  2000	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 60000	 60000	 60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillData1			    600000  900000 1200000 // 지속시간
	SkillData2					 5		 8		11 // 10초당 소모 SP
	SkillData3				   993     993     997 // 촉매 아이템 - 그린라이브 그린라이브 그레이트네이쳐 
	SkillData4					 3       6       1 // 촉매 아이템 갯수
return

SetSkill SO_EL_CONTROL // 정령제어
OnInit:
	SkillMaxLv		4
	SkillType		TOME
	SkillSP						10		10		10		10	
	SkillCastFixedDelay          0	     0	     0	     0 // 스킬 캐스팅 고정 delay값	
	SkillCastStatDelay		  2000	  2000	  2000	  2000
	SkillSinglePostDelay      5000	  5000	  5000	  5000
	SkillGlobalPostDelay		 0		 0		 0		 0	
return

SetSkill SO_EL_ACTION // 엘리멘탈 액션(SKID_SO_EL_ACTION)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER
	SkillRange      5  // 스킬사정거리	
	SkillSP						50 // 소모 SP
	SkillCastFixedDelay          0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0 // 스킬사용후 전체스킬사용금지시간	
return

SetSkill SO_EL_ANALYSIS //원소 분석(SKID_SO_EL_ANALYSIS)
OnInit:
	SkillMaxLv		2
	SkillType		TOME
	SkillSP						10	  20 // 소모 SP
	SkillCastFixedDelay       2000	2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0     0 // 스킬사용후 전체스킬사용금지시간	
return

SetSkill SO_EL_SYMPATHY //정령 교감(SKID_SO_EL_SYMPATHY)
OnInit:
	SkillMaxLv 5
	SkillProperty PROPERTY_Nothing    // 속성없음
	SkillType PASSIVE                 // 패시브스킬
	SkillPattern SKILLPATT_NONE       // 공격스킬아님	
	SkillData1		  5 	  10	  15	  20	  25 // 정령 MHP % 증가량
	SkillData2		  5  	  10	  15	  20	  25 // 정령 MSP % 증가량
	SkillData3		 25  	  50	  75	 100	 125 // 정령 ATK & MATK 증가량
	SkillData4		 10	      15	  20	  25	  30 // 정령소환 스킬사용시 시전자의 SP 감소률	
return

SetSkill SO_EL_CURE // 정령 치유(SKID_SO_EL_CURE)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillSP						10 // 예외처리부분입니다.(maxhp및 maxsp의 10%을 소모합니다.) 이값이 0이면 않되므로 이곳에서 지정하고 코드에서 예외처리합니다.
	SkillCastFixedDelay          0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000 // 스킬사용후 전체스킬사용금지시간	
return


SetSkill SO_FIRE_INSIGNIA // 파이어 인시그니아(SKID_SO_FIRE_INSIGNIA)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9 // 스킬사정거리
	SkillSP						22	    30	    38 // SP소모량
	SkillCastFixedDelay       1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 60000	 60000	 60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0 // 스킬사용후 전체스킬사용금지시간
return

SetSkill SO_WATER_INSIGNIA // 워터 인시그니아(SKID_SO_WATER_INSIGNIA)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9 // 스킬사정거리
	SkillSP						22	    30	    38 // SP소모량
	SkillCastFixedDelay       1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 60000	 60000	 60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0 // 스킬사용후 전체스킬사용금지시간
return


SetSkill SO_WIND_INSIGNIA // 윈드 인시그니아(SKID_SO_WIND_INSIGNIA)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9 // 스킬사정거리
	SkillSP						22	    30	    38 // SP소모량
	SkillCastFixedDelay       1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 60000	 60000	 60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0 // 스킬사용후 전체스킬사용금지시간
return

SetSkill SO_EARTH_INSIGNIA // 어스 인시그니아(SKID_SO_EARTH_INSIGNIA)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9 // 스킬사정거리
	SkillSP						22	    30	    38 // SP소모량
	SkillCastFixedDelay       1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 60000	 60000	 60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0 // 스킬사용후 전체스킬사용금지시간
return




// ------------------ 제네릭(Genetic) 스킬들 --------------------------------------------------
SetSkill GN_TRAINING_SWORD //검수련(SKID_GN_TRAINING_SWORD)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing    // 속성없음
	SkillType		PASSIVE             // 패시브스킬
	SkillPattern	SKILLPATT_NONE     // 공격스킬아님	
	SkillData1		10		20		30		40		50 // 공격력추가
	SkillData2		 3		 6		 9		12		15 // 명중보너스 수치	
return

SetSkill GN_REMODELING_CART //카트 개조(SKID_GN_REMODELING_CART)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing    // 속성없음
	SkillType		PASSIVE             // 패시브스킬
	SkillPattern	SKILLPATT_NONE     // 공격스킬아님	
	SkillData1		 4		 8		12		16		20 // 카트스킬(3개)에만 명중률보정
	SkillData2	  5000	 10000	 15000	 20000	 25000 // 카트의 최대무게 증가수치 클라에서는 1/10 로 표시된다.
return

SetSkill GN_CART_TORNADO //카트 토네이도 어택(SKID_GN_CART_TORNADO)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillPattern		SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입
	SkillSP						30	    30	    30	    30	    30 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay			 0		 0		 0		 0		 0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	   500	  1000	  1500	  2000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				     2       2       2       2       2 // 효과범위(반경)
	SkillData2				     2       2       2       2       2 // 넉백셀수
return

SetSkill GN_CARTCANNON //카트 캐논(SKID_GN_CARTCANNON)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // 속성없음
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입
	SkillSP						40		42		46		48		50 // SP소모량
	SkillRange					 7		 8		 9		10		11 // 스킬사정거리
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1500	  2000	  2500	  3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     1       1       2       2       3 // 효과범위(반경)
return

SetSkill GN_CARTBOOST //카트 부스트(SKID_GN_CARTBOOST)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillSP						20	    24	    28	    32	    36 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1500	  1500    1500    1500    1500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				    50      50      75      75     100 // 이동속도증가량(%)
	SkillData2				    10      20      30      40      50 // ATK증가값
	SkillData3				 90000	 90000   90000   90000   90000 // 유지시간
return

SetSkill GN_THORNS_TRAP //가시나무 덫(SKID_GN_THORNS_TRAP)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND	
	SkillRange					 9		 9		 9		 9		 9 // 스킬사정거리
	SkillSP						22	    26	    30	    34	    38 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1500	  1500	  1500	  1500	  1500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간		
	SkillData1               10000   12000   14000   16000   18000 // 지속시간
	SkillData2                 300	   500	   700	   900	  1100 // 초당 데미지
	SkillData3                   3	     3	     3	     3	     3 // 최대설치갯수
return

SetSkill GN_BLOOD_SUCKER //블러드 서커(SKID_GN_BLOOD_SUCKER)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // 속성없음
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP						30		35		40		45		50 // SP소모량
	SkillRange					11		11		11		11		11 // 스킬사정거리
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1500	  1500	  1500	  1500	  1500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 20000	 22000	 24000	 26000	 28000 // 지속시간
	SkillData2				   300	   400	   500	   600     700 // 초당 데미지량 + 시전자의 INT값
	SkillData3				    10      15      20      25      30 // HP흡수률(%) (데미지량에 대해서)	
return


SetSkill GN_SPORE_EXPLOSION //스포어 익스플로젼(SKID_GN_SPORE_EXPLOSION)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // 속성없음
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입
	SkillSP						55		60		65		70		75 // SP소모량
	SkillRange					11		11		11		11		11 // 스킬사정거리
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1500	  1500	  1500	  1500	  1500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  2000	  2000	  3000	  3000	  4000 // 폭발지연시간
	SkillData3				     1       2       3       4       5 // 데미지적용반경
return

SetSkill GN_WALLOFTHORN //가시나무의 벽(SKID_GN_WALLOFTHORN)
OnInit:
	SkillMaxLv		5
	SkillType		TOALL					// 자신을 포함한 모든 케릭터적용 
	SkillProperty	PROPERTY_Nothing		// 속성없음
	SkillPattern	SKILLPATT_DIRECTATTACK  // 직근접 물리 공격 스킬타입
	SkillSP						40		50		60		70		80 // SP소모량
	SkillRange					11		11		11		11		11 // 스킬사정거리
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1500	  1500	  1500	  1500	  1500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간
	SkillData1				 10000	 11000	 12000	 13000	 14000 // 지속시간
	SkillData2				  4000	  6000	  8000	 10000	 12000 // 내구력
return

SetSkill GN_CRAZYWEED //크레이지 위드(SKID_GN_CRAZYWEED)
OnInit:
	SkillMaxLv		10
	SkillType		TOGROUND
	SkillSP						24	  28	  32	  36	  40	  44	  48	  52	  56	  60 // SP소모량
	SkillRange					11	  11	  11	  11	  11	  11	  11	  11	  11	  11 // 스킬사정거리
	SkillCastFixedDelay          0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  3000	3500	4000	4500	5000	5500	6000	6500	7000	7500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	5000	5000	5000	5000	5000	5000	5000	5000	5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	 500     500	 500	 500	 500	 500	 500	 500	 500 // 스킬사용후 전체스킬사용금지시간	
	SkillData1                   4	   4	   4	   4	   4	   4	   4	   4	   4	   4 // 낙하반경
	SkillData2                   3	   4	   4	   5	   5	   6	   6	   7	   7	   8 // 낙하횟수	
return

SetSkill GN_CRAZYWEED_ATK //크레이지 위드 드롭공격(SKID_GN_CRAZYWEED_ATK)
OnInit:
	SkillMaxLv		10
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Ground //지속성공격
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillAtkPer                600	 700	 800	 900	1000	1100	1200	1300	1400	1500 // 공격데미지증가율(%)
return


SetSkill GN_DEMONIC_FIRE //데모닉 파이어(SKID_GN_DEMONIC_FIRE)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Fire
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP						24	  28	  32	  36	  40 // SP소모량
	SkillRange					 9	   9	   9	   9	   9 // 스킬사정거리
	SkillCastFixedDelay          0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  3000	3500	4000	4500	5000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	5000	5000	5000	5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	 500     500	 500	 500 // 스킬사용후 전체스킬사용금지시간	
	SkillData1               10000 12000   14000   16000   18000 // 지속시간
	SkillData2                 130	 150	 170	 190	 210 // 2초당 MATK 공격데미지 증가율(%)
	SkillData3                   8	  12	  16	  20	  24 // 발화적용확률(%)	
return

SetSkill GN_FIRE_EXPANSION //파이어 익스펜션(SKID_GN_FIRE_EXPANSION)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillSP						30	  35	  40	  45	  50 // SP소모량
	SkillRange					 9	   9	   9	   9	   9 // 스킬사정거리
	SkillCastFixedDelay          0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  2000	2000	2000	2000	2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	 500     500	 500	 500 // 스킬사용후 전체스킬사용금지시간		
return


SetSkill GN_FIRE_EXPANSION_ACID //파이어 익스펜션 염산(SKID_GN_FIRE_EXPANSION_ACID)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // 속성없음
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						 0		0	    0	    0	    0	    0	    0	    0	    0	    0 // SP소모량
	SkillRange					11	   11	   11	   11	   11	   11	   11	   11	   11	   11 // 스킬사정거리
	SkillCastFixedDelay          0		0		0		0		0		0		0		0		0		0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0		0		0		0		0		0		0		0		0		0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0		0		0		0		0		0		0		0		0		0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0		0		0		0		0		0		0		0		0		0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1                   1		2		3		4		5		6		7		8		9	   10 // 연타횟수
	SkillData2                   1		2		3		4		5		6		7		8		9	   10 // 무기와 갑옷 파괴확률(%)
return


SetSkill GN_HELLS_PLANT // 헬즈 플랜트(SKID_GN_HELLS_PLANT)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillSP						40	  45	  50	  55	  60 // SP소모량	
	SkillRange					 9	   9	   9	   9	   9 // 스킬사정거리
	SkillCastFixedDelay          0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  3000	3500	4000	4500	5000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	   0	   0	   0	   0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	 500     500	 500	 500 // 스킬사용후 전체스킬사용금지시간
	SkillData1                   2	   3	   4	   5	   6 // 설치 최대 갯수
	SkillData2                  10	  15	  20	  25	  30 // 출혈 확률(%)
	SkillData3                  30	  40	  50	  60	  70 // 스턴 확률(%)
return

SetSkill GN_HELLS_PLANT_ATK // 헬즈 플랜트(SKID_GN_HELLS_PLANT_ATK)
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
return

SetSkill GN_MANDRAGORA //하울링 오브 만드라고라(SKID_GN_MANDRAGORA)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillSP						40	    45		50	    55      60 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000    1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				    35      45      55      65      75 // 효과에 걸릴 확률(기본값)
	SkillData2				    30      35      40      45      50 // SP감소량(%)(한번만)
	SkillData3				     4	     8	    12	    16	    20 // INT감소값
	SkillData4				     5	     6	     6	     7       7 // 적용반경
return

SetSkill GN_CHANGEMATERIAL //체인지 매터리얼(SKID_GN_CHANGEMATERIAL)
OnInit:
	SkillMaxLv			1
	SkillType			TOME
	SkillSP						 5 // SP소모량
	SkillCastFixedDelay          0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0 // 스킬사용후 전체스킬사용금지시간
return


SetSkill GN_MIX_COOKING //믹스 쿠킹(SKID_GN_MIX_COOKING)
OnInit:
	SkillMaxLv			2
	SkillType			TOME
	SkillSP						 5		40 // SP소모량
	SkillCastFixedDelay          0		 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0		 0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0		 0 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     1      10 // 갯수 증폭값
return

SetSkill GN_MAKEBOMB //폭탄제조(SKID_GN_MAKEBOMB)
OnInit:
	SkillMaxLv			2
	SkillType			TOME
	SkillSP						 5		40 // SP소모량
	SkillCastFixedDelay          0		 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0		 0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0		 0 // 스킬사용후 전체스킬사용금지시간
	SkillData1				     1      10 // 갯수 증폭값
return

SetSkill GN_S_PHARMACY //스페셜 파머시(SKID_GN_S_PHARMACY)
OnInit:
	SkillMaxLv			10
	SkillType			TOME
	SkillSP						12	   12	   12	   12	   12	   12	   12	   12	   12	   12 // SP소모량
	SkillCastFixedDelay          0		0		0		0		0		0		0		0		0		0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0		0		0		0		0		0		0		0		0		0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0		0		0		0		0		0		0		0		0		0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0		0		0		0		0		0		0		0		0		0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					7	    8	    8	    9	   9	   10	   10	   11	   11	   12 // 제조갯수
	SkillData2					600	  580	  560	  540	  520	  500	  480	  460	  440	  420 // 제조 기준치
return

SetSkill GN_SLINGITEM //슬링 아이템(SKID_GN_SLINGITEM)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // 속성없음
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						 4 // SP소모량
	SkillRange					11 // 스킬사정거리
	SkillCastFixedDelay          0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  1000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0 // 스킬사용후 전체스킬사용금지시간
return

SetSkill GN_SLINGITEM_RANGEMELEEATK //슬링 아이템 원거리물리공격(SKID_GN_SLINGITEM_RANGEMELEEATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // 속성없음	
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입		
	SkillSP						 0 // SP소모량
	SkillRange					11 // 스킬사정거리
	SkillCastFixedDelay          0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0 // 스킬사용후 전체스킬사용금지시간
return





//수라
SetSkill SR_DRAGONCOMBO //쌍룡각(SKID_SR_DRAGONCOMBO)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						 3		4		5		6		7		8		9	   10	   11	   12 // SP소모량
	SkillCastFixedDelay          0		0		0		0		0		0		0		0		0		0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0		0		0		0		0		0		0		0		0		0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0		0		0		0		0		0		0		0		0		0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0		0		0		0		0		0		0		0		0		0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 20	    30		40		50		60		70		80		90	   100	   110 // 스턴확률(%)
return

SetSkill SR_SKYNETBLOW //천라지망(SKID_SR_SKYNETBLOW)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						 8		 9		10		11		12
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 2		 2		 2		 2		 2 // 범위 5*5
	SkillData2					 5		 5		 5		 5		 5 // 타격횟수
return

SetSkill SR_EARTHSHAKER //지뢰진(SKID_SR_EARTHSHAKER)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						36		40		44		48		52 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  3000	  3000	  3000	  3000	  3000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 1		 2		 3		 4		 5 // 범위 11*11	
	SkillData2				  1000    2000    2000    3000    3000 // 공격성공시 타겟 스턴 걸리는 시간
	SkillData3				   300     350     400     450     500 // 공격성공시 타겟 스턴 확률(천분률)
return

SetSkill SR_RAMPAGEBLASTER //폭기산탄(SKID_SR_RAMPAGEBLASTER)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					   150	   150	   150	   150	   150 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 3		 3		 3		 3		 3 // 범위 7*7
return

SetSkill SR_KNUCKLEARROW //수라신탄(SKID_SR_KNUCKLEARROW)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK	
	SkillSP					    10		15		20		25		30 // SP소모량
	SkillRange					 7		 8		 9		10		11 // 스킬사정거리
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1					 2		 3		 4		 5		 6 // 넉백 거리
return

SetSkill SR_FALLENEMPIRE // 대전붕추(SKID_SR_FALLENEMPIRE)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						20		30		40		50		60 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간
	SkillData1				   500	  1000	  1500    2000	  2500 // 경직시간
return

SetSkill SR_TIGERCANNON //호포(SKID_SR_TIGERCANNON)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK	
	SkillSP						 1		1		1		1		1		1		1	    1	    1	    1 // SP소모량(0일때 시전못하도록 임의설정)
	SkillRange					 1		1		1		1		1		1		1		1		1		1 // 스킬 사정거리
	SkillCastFixedDelay          0		0		0		0		0		0		0		0		0		0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1100	 1200	 1300	 1400	 1500	 1600	 1700	 1800	 1900	 2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					12     14	   16	   18	   20	   22	   24	   26	   28	   30 // 스킬 사용시 소모되는 HP %
	SkillData2					 6		7		8		9	   10	   11	   12	   13	   14	   15 // 스킬 사용시 소모되는 SP %
	SkillData3					 1		1		1		1		1		2		2		2		2		2 // 범위 7*7
return

SetSkill SR_GATEOFHELL //나찰파황격(SKID_SR_GATEOFHELL)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillFlag		SKFLAG_NODISPEL
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange					 1		2		3		3		4		4		5		5		6		7 // 스킬 사정거리
	SkillSP						11	   12	   13	   14	   15	   16	   17	   18	   19	   20 // SP소모량(0일때 사용하지 못하도록 임의설정)
	SkillCastFixedDelay          0	    0	    0	    0	    0	    0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	 1200	 1400	 1600	 1800	 2000	 2200	 2400	 2600	 2800 // 스킬 캐스팅 스텟에 영향받는 delay값
//	SkillSinglePostDelay	  5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       100	  200	  300	  400	  500	  600	  700	  800	  900	 1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					12	   14	   16	   18	   20	   22	   24	   26      28	   30 // 데미지증폭 FACTOR 		
return

SetSkill SR_CRESCENTELBOW //파쇄주(SKID_SR_CRESCENTELBOW)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						80		80		80		80		80 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  3000    4000    5000    6000    7000 // 지속시간	
	SkillData2				    55      60      65      70      75 // 발동확률
return

SetSkill SR_CRESCENTELBOW_AUTOSPELL //파쇄주-오트스펠(SKID_SR_CRESCENTELBOW_AUTOSPELL)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK	
	SkillData1				   200     400     600     800    1000 // 넉백시 추가 데미지(%)
return

SetSkill SR_WINDMILL //선풍퇴(SKID_SR_WINDMILL)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						45
	SkillCastFixedDelay          0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000  // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  3000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay       500 // 스킬사용후 전체스킬사용금지시간
	SkillData1					 2 // 범위 5*5
return


SetSkill SR_CURSEDCIRCLE //주박진(SKID_SR_CURSEDCIRCLE)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						40		60		80	   100	   120 // SP소모량	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 1		 2		 3		 4		 5 // HP소모(%)
	SkillData2					 1		 1		 2		 2		 3 // 범위 5*5 
	SkillData3				  3000	  4000	  5000	  6000	  7000 // 지속시간
return

SetSkill SR_LIGHTNINGWALK //섬전보(SKID_SR_LIGHTNINGWALK)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						80		70		60		50		40 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay	  1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간		
	SkillData1					45		50		55		60		65 // 발동확률(%)
	SkillData2				  5000	  6000	  7000	  8000	  9000 // 효과 지속 시간

return

SetSkill SR_RAISINGDRAGON // 잠룡승천(SKID_SR_RAISINGDRAGON)
OnInit:
	SkillMaxLv		10
	SkillType		TOME
	SkillSP					   120	  120	  120	  120	  120	  120	  120	  120	  120	  120 // SP소모량
	SkillCastFixedDelay          0	    0		0		0		0		0		0		0		0		0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0		0		0		0		0		0		0		0		0		0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 30000	30000	30000	30000	30000	30000	30000	30000	30000	30000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				 30000	45000	60000	75000	90000  105000  120000  135000  150000  165000 // 지속시간
	SkillData2					 1		2		3	    4	    5	    6	    7	    8	   9	   10 // 추가돼는 최대기구체숫자(기존의 축기에 의한값에 추가돼는값)
	SkillData3					 3		4		5		6		7		8		9	   10	   11	   12 // HP / SP 증가(%)	
return

SetSkill SR_GENTLETOUCH_QUIET //점혈-묵(SKID_SR_GENTLETOUCH_QUIET)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange					 2		 2		 2		 2		 2 // 사정거리
	SkillSP						20		25		30		35		40 // SP소모량
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  1000	  1500	  2000	  2500	  3000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0		 0		 0		 0		 0 // 스킬사용후 전체스킬사용금지시간
	SkillData1				  5000    7000    9000   11000   13000 // 침묵 지속시간
return


SetSkill SR_GENTLETOUCH_CURE //점혈-쾌(SKID_SR_GENTLETOUCH_CURE)
OnInit:
	SkillMaxLv		5
	SkillType		TOALL				// 자신을 포함한 모든 케릭터적용 
	SkillRange					 2		 2		 2		 2		 2 // 사정거리
	SkillSP						40		50		60		70		80 // SP소모량	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		     0	     0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  1000	  1500	  2000    2500    3000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간	
return

SetSkill SR_GENTLETOUCH_ENERGYGAIN //점혈-구(SKID_SR_GENTLETOUCH_ENERGYGAIN)
OnInit:
	SkillMaxLv		5
	SkillType		TOME	
	SkillSP						40		50		60		70		80 // SP소모량
	SkillCastFixedDelay       1000	  1500	  2000	  2500	  3000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1					 1		 2		 3		 4	     5 // HP소모량(%)
	SkillData2					15		20		25		30		35 // 기구체를 얻을확률	
	SkillData3			    240000  240000  240000  240000  240000 // 지속시간
return

SetSkill SR_GENTLETOUCH_CHANGE //점혈-반(SKID_SR_GENTLETOUCH_CHANGE)
OnInit:
	SkillMaxLv 5
	SkillType TOALL
	SkillRange		     2       2       2       2	     2 // 사정거리
	SkillSP			    40      50      60      70      80 // SP소모량
	SkillCastFixedDelay       1000	  1000	  1000	  1000    1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	200000  180000  160000	140000  120000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1		     1       2      3        4       5 // HP소모량(%)
	SkillData2	        240000  240000  240000  240000  240000 // 지속시간
return

SetSkill SR_GENTLETOUCH_REVITALIZE //점혈-활(SKID_SR_GENTLETOUCH_REVITALIZE)
OnInit:
	SkillMaxLv		5
	SkillType		TOALL
	SkillRange		     2	     2       2       2       2 // 스킬사정거리
	SkillSP			    40	    50	    60	    70	    80 // SP소모량
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	200000  180000  160000	140000 	120000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1	        240000  240000  240000  240000  240000 // 지속시간
return

SetSkill SR_ASSIMILATEPOWER //흡기공(SKID_SR_ASSIMILATEPOWER)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillSP						10
	SkillCastFixedDelay			 0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay			 0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  5000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay      1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1					 1 // 기구체 하나당 SP 회복량: MSP에대한 비율
	SkillData2					 2 // 반경(5x5)
return

SetSkill SR_POWERVELOCITY //전기주입(SKID_SR_POWERVELOCITY)
OnInit:
	SkillMaxLv	1
	SkillType	TOALL
	SkillRange					 3 // 스킬사정거리
	SkillSP						50 // SP소모량
	SkillCastFixedDelay        500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1500 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay		 0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0 // 스킬사용후 전체스킬사용금지시간
return

SetSkill SR_HOWLINGOFLION //사자후(SKID_SR_HOWLINGOFLION)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillPattern		SKILLPATT_DIRECTATTACK
	SkillFlag			SKFLAG_NODISPEL //캐스팅 중 데미지를 입어도 끊기지 않는다.
	SkillSP						80		90	   100     110     120 // SP소모량
	SkillCastFixedDelay        500	   500	   500	   500	   500 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // 스킬사용후 전체스킬사용금지시간
	SkillData1					 3		 4		5		 6		 7 // 데미지적용반경 
	SkillData2					10		15		20		25		30 // 상태이상[공포] 적용확률(%) 
return

SetSkill SR_RIDEINLIGHTNING //뇌광탄(SKID_SR_RIDEINLIGHTNING)
OnInit:
	SkillMaxLv			5
	SkillType			TOGROUND
	SkillPattern		SKILLPATT_DIRECTATTACK
	SkillSP			    22	  24	  26	  28	  30 // SP소모량
	SkillRange		    11	  11	  11	  11	  11 // 스킬사정거리
	SkillCastFixedDelay          0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	  1000	2000	3000	4000	5000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	  1000	1000	1000	1000	1000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay         0     0       0       0       0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1		     1	   1	   2	   2	   3 // 데미지적용반경 
	SkillData2                   1	   2       3	   4	   5 // 소모하는 기구체의 갯수
	SkillData3                  50	 100	 150	 200	 250 // 풍속성무기 착용시 추가 증폭공격력(%) 
return

//로열가드
SetSkill LG_CANNONSPEAR
OnInit:
	SkillMaxLv 5
	SkillType  TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange			      11      11      11      11      11
	SkillSinglePostDelay	2000	2000	2000	2000	2000
	SkillSP					  12      16      20      24      28	
return

SetSkill LG_BANISHINGPOINT
OnInit:
	SkillMaxLv 10
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSP      20    20    20    20    20    25    25    25    25    25
	SkillRange    7     7     7     7     7     7     7     7     7     7	
	SkillHitPer 103   106   109   112   115   118   121   124   127   130
return

SetSkill LG_TRAMPLE
OnInit:
	SkillMaxLv 3
	SkillType TOME
	SkillSP					  30      45      60
	SkillGlobalPostDelay	1000	1000	1000
	SkillData1				  50      75     100 // 성공확률	
return

SetSkill LG_SHIELDPRESS
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSP					  10	  12      14      16      18
	SkillData1				 700     750     800     850     900 // 스턴확률(천분율)
	SkillSinglePostDelay	2000	2000	2000	2000	2000
return

SetSkill LG_REFLECTDAMAGE
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillSP				        60		80     100     120     140
	SkillData1			    300000  300000  300000  300000  300000 // 지속시간
	SkillData2					20		25		30		35 		40 // 반사데미지 %
	SkillData3					30		40		50		60      70 // 10초당 소모 SP
	SkillData4					40		50		60		70		80 // 반사확률
	SkillData5					30		35		40		45		50 // 일정 횟수의 데미지 입으면 효과 해제
return

SetSkill LG_PINPOINTATTACK
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange				 5		 5		 5		 5		 5
	SkillSP					50		50		50		50		50
	SkillGlobalPostDelay  1000	  1000	  1000	  1000	  1000	
	SkillSinglePostDelay  5000	  5000	  5000	  5000	  5000
return

SetSkill LG_FORCEOFVANGUARD
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillSP					30		30		30		30		30
	SkillCastFixedDelay   1000	  1000	  1000	  1000	  1000
	SkillGlobalPostDelay  1000	  1000	  1000	  1000	  1000
	SkillData1			     7	     9	    11	    13	    15 // 기구체 최대 숫자	
	SkillData2			    20      16      12       8       4 // 10초당 소모 SP
	SkillData3			    20      32      44      56      68 // 기구체 획득 조건, 데미지를 입을때 몇% 확률로 얻는가
	
return

SetSkill LG_RAGEBURST
OnInit:
	SkillMaxLv 1
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillGlobalPostDelay 3000
	SkillSP 150
return

SetSkill LG_SHIELDSPELL
OnInit:
	SkillMaxLv 3
	SkillType TOME
	SkillCastStatDelay	 1000	 1000	 1000
	SkillSinglePostDelay 2000	 2000	 2000
	SkillGlobalPostDelay 1000	 1000	 1000
	SkillSP				   50	   50	   50
return

SetSkill LG_EXEEDBREAK
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSP				   20	   32	   44	   56	   68
	SkillCastStatDelay   5000    5500    6000    6500	 7000
	SkillGlobalPostDelay 1000	 1000	 1000	 1000	 1000
	SkillData1		   300000  300000  300000  300000  300000 // 효과지속시간
	SkillData2			   50	   40	   30	   20	   10 // 캐스팅중 이동속도감소
return

SetSkill LG_OVERBRAND
OnInit:
	SkillMaxLv 5
	SkillType TOGROUND
	SkillPattern SKILLPATT_DIRECTATTACK	
	SkillSP				   20	   30	   40	   50	   60
	SkillCastStatDelay    500     500     500     500     500
	SkillGlobalPostDelay 2000    2000    2000    2000    2000
	SkillData1			    3       4       5       6       7 // 넉백
return

SetSkill LG_OVERBRAND_BRANDISH
OnInit:
	SkillMaxLv 5
	SkillType TOGROUND
	SkillPattern SKILLPATT_DIRECTATTACK	
	SkillData1			    3       4       5       6       7 // 넉백
return

SetSkill LG_OVERBRAND_PLUSATK
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK	
	SkillData1			    3       4       5       6       7 // 넉백
return

SetSkill LG_PRESTIGE
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillCastFixedDelay	 2000	 2000	 2000	 2000    2000
	SkillCastStatDelay   1000    1000    1000    1000    1000
	SkillSinglePostDelay 60000  60000   60000   60000   60000
	SkillSP                75      80      85      90      95
	SkillData1          30000   45000   60000   75000   90000 // 지속시간
return

SetSkill LG_BANDING
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillSP				   30	   36	   42	   48	   54
	SkillData1			    6	    5	    4	    3	    2 // 5초당 SP 소모
	SkillData2	           20	   30	   40	   50	   60 // 인원당 공격력 증가
	SkillData3	            6	    7       8       9      10 // 인원당 방어력 증가
return

SetSkill LG_MOONSLASHER
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillCastStatDelay	 1000	 1000	 1000	 1000	 1000
	SkillSinglePostDelay 6000	 5000	 4000	 3000	 2000
	SkillGlobalPostDelay 1000	 1000	 1000	 1000	 1000
	SkillSP				   20	   24	   28	   32	   36
	SkillData1				3		3		3		3		3 // 7*7
	SkillData2			   40	   48	   56	   64	   72 // 성공률
return

SetSkill LG_RAYOFGENESIS
OnInit:
	SkillMaxLv 5
	SkillType TOGROUND
	SkillProperty PROPERTY_Saint	
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillCastFixedDelay	  500	  500	  500	  500	  500
	SkillCastStatDelay	 2000	 2500	 3000	 3500	 4000
	SkillSinglePostDelay 5000	 5000	 5000	 5000	 5000
	SkillGlobalPostDelay 2000	 2000	 2000	 2000	 2000
	SkillSP				   60	   65	   70	   75	   80
	SkillData1			    3	    6	    9	   12	   15 //MHP 소모%
	SkillData2			    5		5		5		5		5 //11*11	
return

SetSkill LG_PIETY
OnInit:
	SkillMaxLv 5
	SkillType TOALL
	SkillSP				   40	   45	   50	   55	   60
	SkillCastStatDelay   3000	 2500	 2000	 1500	 1000
	SkillData1		    60000   80000  100000  120000  140000 // 효과 지속시간
return

SetSkill LG_EARTHDRIVE
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillProperty PROPERTY_Ground
	SkillCastStatDelay	 1000	 1000	 1000	 1000	 1000
	SkillSinglePostDelay 7000	 6000	 5000	 4000	 3000
	SkillGlobalPostDelay 1000	 1000	 1000	 1000	 1000
	SkillSP				   52	   60	   68	   76	   84
	SkillData1				1		1		2		2		3 // 3*3 3*3 5*5 5*5 7*7
	SkillData2				5		5		5		5		5 // 연타횟수
	SkillData3			   25	   25	   25	   25	   25 // 물리방어력, 공속 하락 Percent
	SkillData4			 3000	 6000	 9000	12000	15000 // 물리방어력, 공속 하락 지속시간
return

SetSkill LG_HESPERUSLIT
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK	
	SkillCastStatDelay   1000	 1000	 1000	 1000	 1000
	SkillSinglePostDelay 20000	20000	20000	20000	20000
	SkillGlobalPostDelay 3000	 3000	 3000	 3000	 3000
	SkillSP				   80	   90	  100	  110	  120
	SkillRange			    3		3		3		3		3	
return

SetSkill LG_INSPIRATION
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillCastFixedDelay	 1000	 1000	 1000	 1000	 1000
	SkillCastStatDelay	 2000	 2000	 2000	 2000	 2000
	SkillSinglePostDelay 540000 480000  420000  360000  300000
	SkillGlobalPostDelay 2000	 2000	 2000	 2000	 2000
	SkillSP				   80	   90	  100	  110	  120
	SkillData1			   30	   25	   20	   15	   10 //5초당 HP 소모 천분률
	SkillData2			   40	   35	   30	   25	   20 //5초당 SP 소모 천분률
	SkillData3			30000   45000	60000	75000	90000 // 지속시간
return

//__THIRDJOB2 ********************************************************************************* */















// 정령(elemental)의 스킬
SetSkill EL_CIRCLE_OF_FIRE //서클 오브 파이어(EL_CIRCLE_OF_FIRE)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillProperty	PROPERTY_Fire
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillAtkPer		300
	SkillSP         40    // SP소모량
	SkillData1		60000 // 효과지속시간	
	SkillData2		5	  // 초당 소모되는 SP 량	
return

SetSkill EL_FIRE_CLOAK // 파이어 클록(SKID_EL_FIRE_CLOAK)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE
	SkillSP         60   // SP소모량
	SkillData1		60000 // 효과지속시간	
	SkillData2		5	  // 초당 소모되는 SP 량	
return

SetSkill EL_FIRE_MANTLE //파이어 맨틀(SKID_EL_FIRE_MANTLE)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Fire         //화속성
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillSP         80   // SP소모량
	SkillAtkPer		1000
return


SetSkill EL_WATER_SCREEN //워터 스크린(SKID_EL_WATER_SCREEN)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         40   // SP소모량
	SkillData1		60000 // 효과지속시간	
	SkillData2		5	  // 초당 소모되는 SP 량	
return


SetSkill EL_WATER_DROP //워터 드롭(SKID_EL_WATER_DROP)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         60   // SP소모량
	SkillData1		60000 // 효과지속시간	
	SkillData2		5	  // 초당 소모되는 SP 량	
return


SetSkill EL_WATER_BARRIER //워터 베리어(SKID_EL_WATER_BARRIER)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         80				  // SP소모량
	SkillData1		15000			  // 효과지속시간	
return


SetSkill EL_WIND_STEP //윈드 스텝(SKID_EL_WIND_STEP)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         40   // SP소모량
	SkillData1		60000 // 효과지속시간	
	SkillData2		5	  // 초당 소모되는 SP 량	
return


SetSkill EL_WIND_CURTAIN //윈드 커튼(SKID_EL_WIND_CURTAIN)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         60   // SP소모량
	SkillData1		60000 // 효과지속시간	
	SkillData2		5	  // 초당 소모되는 SP 량	
return



SetSkill EL_ZEPHYR //제피르(SKID_EL_ZEPHYR)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         80   // SP소모량
	SkillData1		15000			  // 효과지속시간	
return

SetSkill EL_SOLID_SKIN //솔리드 스킨(SKID_EL_SOLID_SKIN)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         40				  // SP소모량
	SkillData1		60000			  // 효과지속시간	
	SkillData2		5	  // 초당 소모되는 SP 량	
return


SetSkill EL_STONE_SHIELD //스톤 쉴드(SKID_EL_STONE_SHIELD)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         60				  // SP소모량
	SkillData1		60000			  // 효과지속시간	
	SkillData2		5				  // 초당 소모되는 SP 량	
return


SetSkill EL_POWER_OF_GAIA //파워 오브 가이아(SKID_EL_POWER_OF_GAIA)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         80				  // SP소모량
	SkillData1		15000			  // 효과지속시간	
return

SetSkill EL_PYROTECHNIC // 파이로테크닉(SKID_EL_PYROTECHNIC)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		10				  // 10초당 소모되는 SP 량	
return

SetSkill EL_HEATER // 히터(SKID_EL_HEATER)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		20				  // 10초당 소모되는 SP 량	
return

SetSkill EL_TROPIC // 트로픽(SKID_EL_TROPIC)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		30				  // 10초당 소모되는 SP 량	
return

SetSkill EL_AQUAPLAY //아쿠아플레이(SKID_EL_AQUAPLAY)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		10				  // 10초당 소모되는 SP 량	
return

SetSkill EL_COOLER //쿨러(SKID_EL_COOLER)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		20				  // 10초당 소모되는 SP 량	
return

SetSkill EL_CHILLY_AIR //칠리 에어(SKID_EL_CHILLY_AIR)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		30				  // 10초당 소모되는 SP 량	
return

SetSkill EL_GUST //거스트(SKID_EL_GUST)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		10				  // 10초당 소모되는 SP 량	
return

SetSkill EL_BLAST //블래스트(SKID_EL_BLAST)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		20				  // 10초당 소모되는 SP 량	
return

SetSkill EL_WILD_STORM //와일드 스톰(SKID_EL_WILD_STORM)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		30				  // 10초당 소모되는 SP 량	
return

SetSkill EL_PETROLOGY //페트롤로지(SKID_EL_PETROLOGY)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		10				  // 10초당 소모되는 SP 량	
return

SetSkill EL_CURSED_SOIL //커즈드 소일(SKID_EL_CURSED_SOIL)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		20				  // 10초당 소모되는 SP 량	
return

SetSkill EL_UPHEAVAL //업히벌(SKID_EL_UPHEAVAL)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillPattern	SKILLPATT_NONE    // 공격스킬아님	
	SkillSP         0				  // SP소모량
	SkillData1		300000			  // 효과지속시간	
	SkillData2		30				  // 10초당 소모되는 SP 량	
return

SetSkill EL_FIRE_ARROW //파이어 애로우(SKID_EL_FIRE_ARROW)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격	
	SkillProperty	PROPERTY_Fire  // 화속성	
	SkillSP         40	// SP소모량
	SkillAtkPer		300 // 공격데미지증가율(%)
	SkillRange      6   // 스킬사정거리	
return

SetSkill EL_FIRE_BOMB // 파이어 봄(SKID_EL_FIRE_BOMB)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격	
	SkillProperty	PROPERTY_Fire  // 화속성	
	SkillSP         60	// SP소모량
	SkillAtkPer		500 // 공격데미지증가율(%)
	SkillRange      6   // 스킬사정거리	
return

SetSkill EL_FIRE_BOMB_ATK // 파이어 봄(SKID_EL_FIRE_BOMB_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입	
	SkillProperty	PROPERTY_Fire  // 화속성
	SkillAtkPer		300 // 공격데미지증가율(%)
	SkillRange      6   // 스킬사정거리	
return

SetSkill EL_FIRE_WAVE // 파이어 웨이브(SKID_EL_FIRE_WAVE)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격	
	SkillProperty	PROPERTY_Fire  // 화속성	
	SkillSP         80	// SP소모량
	SkillAtkPer		1200 // 공격데미지증가율(%)
	SkillRange      6   // 스킬사정거리	
return

SetSkill EL_FIRE_WAVE_ATK // 파이어 웨이브(SKID_EL_FIRE_WAVE_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입	
	SkillProperty	PROPERTY_Fire  // 화속성
	SkillAtkPer		600 // 공격데미지증가율(%)
	SkillRange      6   // 스킬사정거리	
return

SetSkill EL_ICE_NEEDLE // 아이스 니들(SKID_EL_ICE_NEEDLE)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격	
	SkillProperty	PROPERTY_Water //수속성
	SkillSP         40	// SP소모량
	SkillAtkPer		500 // 공격데미지증가율(%)
	SkillRange      9   // 스킬사정거리	
return

SetSkill EL_WATER_SCREW // 워터 스크류(SKID_EL_WATER_SCREW)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격	
	SkillProperty	PROPERTY_Water //수속성
	SkillSP         60	// SP소모량
	SkillAtkPer		1000 // 공격데미지증가율(%)
	SkillRange      9   // 스킬사정거리	
return

SetSkill EL_WATER_SCREW_ATK // 워터 스크류(SKID_EL_WATER_SCREW_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillProperty	PROPERTY_Water //수속성
	SkillAtkPer		1000 // 공격데미지증가율(%)
	SkillRange      9   // 스킬사정거리	
return

SetSkill EL_TIDAL_WEAPON // 타이달 웨폰(SKID_EL_TIDAL_WEAPON)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입	
	SkillProperty	PROPERTY_Water //수속성
	SkillSP         80	// SP소모량
	SkillAtkPer		1500 // 공격데미지증가율(%)
	SkillRange      9   // 스킬사정거리	
return

SetSkill EL_WIND_SLASH // 윈드 슬래쉬(SKID_EL_WIND_SLASH)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입	
	SkillProperty   PROPERTY_Wind //풍속성
	SkillSP         40	// SP소모량
	SkillAtkPer		200 // 공격데미지증가율(%)
	SkillRange      11  // 스킬사정거리	
return

SetSkill EL_HURRICANE // 허리케인 레이지(SKID_EL_HURRICANE)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입	
	SkillProperty   PROPERTY_Wind //풍속성
	SkillSP         60	// SP소모량
	SkillAtkPer		700 // 공격데미지증가율(%)
	SkillRange      11  // 스킬사정거리	
return

SetSkill EL_HURRICANE_ATK // 허리케인 레이지(SKID_EL_HURRICANE_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillProperty   PROPERTY_Wind //풍속성
	SkillAtkPer		500 // 공격데미지증가율(%)
	SkillRange      7  // 스킬사정거리
return

SetSkill EL_TYPOON_MIS // 타이푼 미사일(SKID_EL_TYPOON_MIS)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입	
	SkillProperty   PROPERTY_Wind //풍속성
	SkillSP         80	// SP소모량
	SkillAtkPer		1000 // 공격데미지증가율(%)
	SkillRange      11  // 스킬사정거리	
return

SetSkill EL_TYPOON_MIS_ATK // 타이푼 미사일(SKID_EL_TYPOON_MIS_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillProperty   PROPERTY_Wind //풍속성
	SkillAtkPer		1200 // 공격데미지증가율(%)
	SkillRange      11  // 스킬사정거리	
return

SetSkill EL_STONE_HAMMER // 스톤 해머(SKID_EL_STONE_HAMMER)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입	
	SkillProperty	PROPERTY_Ground //지속성
	SkillSP         40	// SP소모량
	SkillAtkPer		500 // 공격데미지증가율(%)
	SkillRange      5  // 스킬사정거리	
return

SetSkill EL_ROCK_CRUSHER // 록 크러셔(SKID_EL_ROCK_CRUSHER)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입	
	SkillProperty	PROPERTY_Ground //지속성
	SkillSP         60	// SP소모량
	SkillAtkPer		800 // 공격데미지증가율(%)
	SkillRange      3  // 스킬사정거리	
return

SetSkill EL_ROCK_CRUSHER_ATK // 록 크러셔(SKID_EL_ROCK_CRUSHER_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillProperty	PROPERTY_Ground //지속성
	SkillAtkPer		300 // 공격데미지증가율(%)
	SkillRange      5  // 스킬사정거리	
return

SetSkill EL_STONE_RAIN //스톤 레인(SKID_EL_STONE_RAIN)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //플레이어&몬스터
	SkillPattern	SKILLPATT_DIRECTATTACK // 직근접 물리 공격 스킬타입	
	SkillProperty	PROPERTY_Ground //지속성
	SkillSP         80	// SP소모량
	SkillAtkPer		300 // 공격데미지증가율(%)
	SkillRange      9  // 스킬사정거리	
return


//*---------------------------호문변이---------------------------------------

SetSkill MUTATION_BASEJOB
OnInit:
	SkillType	PASSIVE
return

SetSkill MH_SUMMON_LEGION
OnInit:
	SkillMaxLv				5
	SkillType				TOCHARACTER		
	SkillRange				9		9		9		9		9
	SkillSP					60		80		100		120		140
	SkillCastFixedDelay		400		600		800		1000	1200
	SkillCastStatDelay		1600	1400	1200	1000	800
	SkillData1				2158	2159	2159	2160	2160	//소환몬스터 호넷 자이언트_호넷 루시올라_베스파
	SkillData2				3		3		4		4		5		//소환마리수
	SkillData3				20000	30000	40000	50000	60000	//지속시간
return

SetSkill MH_NEEDLE_OF_PARALYZE
OnInit:
	SkillMaxLv				5
	SkillType				TOCHARACTER	
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillProperty			PROPERTY_Poison
	SkillRange				5		5		5		5		5
	SkillSP					48		60		72		84		96
	SkillCastFixedDelay		500		400		300		200		100
	SkillCastStatDelay		1000	1100	1200	1300	1400
	SkillGlobalPostDelay	2000	2000	2000	2000	2000 
	SkillAtkPer				800		900		1000	1100	1200
	SkillData1				45		50		55		60		65
return

SetSkill MH_POISON_MIST
OnInit:
	SkillMaxLv				5
	SkillType				TOGROUND
	SkillPattern			SKILLPATT_ATTACKSPELL
	SkillProperty			PROPERTY_Poison
	SkillRange				5		5		5		5		5
	SkillSP					65		75		85		95		105
	SkillCastFixedDelay		500		500		500		500		500
	SkillCastStatDelay		500		700		900		1100	1300
	SkillData1				3		3		3		3		3		//7*7, 7*7, 7*7, 7*7, 7*7
	SkillData2				2300	2100	1900	1700	1500	//데미지 ?초당 1회
	SkillData3				12000	14000	16000	18000	20000	//미스트 지속시간
	SkillData4				4000	6000	8000	10000	12000	//암흑지속시간
	SkillData5				200		300		400		500		600		//암흑확률(천분률)
return

SetSkill MH_PAIN_KILLER
OnInit:
	SkillMaxLv				5
	SkillType				TOALL	
	SkillRange				1		1		1		1		1
	SkillSP					48		52		56		60		64
	SkillCastFixedDelay		1000	800		600		400		200
	SkillCastStatDelay		1000	1200	1400	1600	1800
	SkillData1				20000	30000	40000	50000	60000	
return

SetSkill MH_LIGHT_OF_REGENE
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					40		50		60		70		80
	SkillCastFixedDelay		1600	1400	1200	1000	800
	SkillData1				360000	420000	480000	540000	600000	//지속시간	
return

SetSkill MH_OVERED_BOOST
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					70		90		110		130		150
	SkillCastFixedDelay		200		300		400		500		600
	SkillCastStatDelay		800		700		600		500		400
	SkillData1				340		380		420		460		500		//FLEE
	SkillData2				181		183		185		187		189		//ASPD
	SkillData3				30000	45000	60000	75000	90000	//지속시간	
return

SetSkill MH_ERASER_CUTTER
OnInit:
	SkillMaxLv				5
	SkillType				TOCHARACTER
	SkillPattern			SKILLPATT_ATTACKSPELL
	SkillSP					25		30		35		40		45
	SkillCastStatDelay		1000	1500	2000	2500	3000
	SkillGlobalPostDelay	2000	2000	2000	2000	2000
	SkillRange				7		7		7		7		7
	SkillAtkPer				600		1000	800		1200	1000
	SkillData1				PROPERTY_Wind	PROPERTY_Nothing	PROPERTY_Wind	PROPERTY_Nothing	PROPERTY_Wind	
return

SetSkill MH_XENO_SLASHER
OnInit:
	SkillMaxLv				5
	SkillType				TOGROUND
	SkillPattern			SKILLPATT_ATTACKSPELL
	SkillSP					90		100		110		120		130
	SkillCastFixedDelay		500		500		500		500		500
	SkillCastStatDelay		1500	2500	3500	4500	5500
	SkillGlobalPostDelay	5000	5000	5000	5000	5000
	SkillRange				7		7		7		7		7
	SkillAtkPer				500		700		600		900		700
	SkillData1				2		2		3		3		4		//5*5 5*5 7*7 7*7 9*9
	SkillData2				PROPERTY_Wind	PROPERTY_Nothing	PROPERTY_Wind	PROPERTY_Nothing	PROPERTY_Wind	
return

SetSkill MH_SILENT_BREEZE
OnInit:
	SkillMaxLv				5
	SkillType				TOCHARACTER
	SkillSP					45		54		63		72		81
	SkillCastFixedDelay		1000	800		600		400		200
	SkillCastStatDelay		1000	1200	1400	1600	1800
	SkillRange				5		5		7		7		9
	SkillData1				9000	12000	15000	18000	21000		//지속시간

return

SetSkill MH_STYLE_CHANGE
OnInit:
	SkillMaxLv				1
	SkillType				TOME
	SkillSP					35
	SkillCastFixedDelay		500
	SkillGlobalPostDelay	1000
return

SetSkill MH_SONIC_CLAW
OnInit:
	SkillMaxLv				5
	SkillType				TOCHARACTER
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillSP					20		25		30		35		40
	SkillGlobalPostDelay	1000	1000	1000	1000	1000
	SkillRange				1		1		1		1		1	
return

SetSkill MH_SILVERVEIN_RUSH
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillSP					10		15		20		25		30
	SkillSinglePostDelay	2000	2000	2000	2000	2000
	SkillRange				1		1		1		1		1
	SkillData1				25		30		35		40		45		//스턴확률	
return

SetSkill MH_MIDNIGHT_FRENZY
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillSP					8		16		24		32		40
	SkillSinglePostDelay	2000	2000	2000	2000	2000
	SkillRange				1		1		1		1		1
	SkillData1				12		14		16		18		20		//공포확률	
return


SetSkill MH_STAHL_HORN
OnInit:
	SkillMaxLv				5
	SkillType				TOCHARACTER
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillSP					40		45		50		55		60
	SkillCastFixedDelay		200		400		600		800		1000
	SkillCastStatDelay		800		600		400		200		0
	SkillGlobalPostDelay	3000	3000	3000	3000	3000
	SkillRange				5		6		7		8		9
	SkillData1				3		3		3		3		3		//넉백거리
	SkillData2				20		24		28		32		36		//스턴확률
return

SetSkill MH_GOLDENE_FERSE
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					60		65		70		75		80
	SkillCastStatDelay		1000	1200	1400	1600	1800
	SkillData1				20		30		40		50		60		//회피율상승
	SkillData2				10		14		18		22		26		//공속상승
	SkillData3				4		6		8		10		12		//성속성 발동 확률
	SkillData4				30000	45000	60000	75000	90000	//지속시간		
return

SetSkill MH_STEINWAND
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					80		90		100		110		120
	SkillCastStatDelay		1000	1000	1000	1000	1000
	SkillData1				5		6		7		8		9		//회피횟수
	SkillData2				30000	45000	60000	75000	90000	//지속시간		
return

SetSkill MH_HEILIGE_STANGE
OnInit:
	SkillMaxLv				5
	SkillType				TOCHARACTER	
	SkillPattern			SKILLPATT_ATTACKSPELL
	SkillProperty			PROPERTY_Saint
	SkillSP					60		68		76		84		100
	SkillCastFixedDelay		1800	1600	1400	1200	1000
	SkillCastStatDelay		200		400		600		800		1000
	SkillGlobalPostDelay	5000	5000	5000	5000	5000
	SkillRange				9		9		9		9		9
	SkillData1				1		1		1		1		2		//효과범위 3*3 ....	5*5
return

SetSkill MH_ANGRIFFS_MODUS
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					60		65		70		75		80
	SkillCastStatDelay		200		400		600		800		1000
	SkillData1				70		90		110		130		150		//ATK 상승
	SkillData2				50		70		90		110		130		//DEF 하락
	SkillData3				60		80		100		120		140		//FLEE 하락
	SkillData4				30000	45000	60000	75000	90000	//지속시간
return

SetSkill MH_TINDER_BREAKER
OnInit:
	SkillMaxLv				5
	SkillType				TOCHARACTER
	SkillSP					20		25		30		35		40
	SkillCastStatDelay		1000	1000	1000	1000	1000
	SkillRange				3		4		5		6		7	
return

SetSkill MH_CBC
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					10		20		30		40		50
	SkillGlobalPostDelay	0	     0	     0	     0	     0
return

SetSkill MH_EQC
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					24		28		32		36		40
	SkillGlobalPostDelay	1000	1000	1000	1000	1000
return


SetSkill MH_MAGMA_FLOW
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillProperty			PROPERTY_Fire	
	SkillSP					34		38		42		46		50
	SkillCastFixedDelay		2000	1500	1000	500		0
	SkillCastStatDelay		2000	2500	3000	3500	4000
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	
	SkillData1				30000	45000	60000	75000	90000	//지속시간
	SkillData2				3		6		9		12		15		//발동확률
	SkillData3				1		1		1		2		2		//효과범위 3*3, 5*5
return

SetSkill MH_GRANITIC_ARMOR
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					54		58		62		66		70
	SkillCastFixedDelay		1000	1000	1000	1000	1000
	SkillCastStatDelay		5000	4500	4000	3500	3000
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	
	SkillData1				60000	60000	60000	60000	60000	//지속시간
return

SetSkill MH_LAVA_SLIDE
OnInit:
	SkillMaxLv				5
	SkillType				TOGROUND
	SkillProperty			PROPERTY_Fire
	SkillRange				7		7		7		7		7
	SkillSP					30		35		40		45		50
	SkillCastFixedDelay		1000	1000	1000	1000	1000
	SkillCastStatDelay		5000	4500	4000	3500	3000
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	
	SkillData1				12000	14000	16000	18000	20000	//지속시간
	SkillData2				1		1		2		2		3		//효과범위 3*3 5*5 7*7	
return

SetSkill MH_PYROCLASTIC
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					20		28		36		44		52
	SkillCastFixedDelay		200		200		200		200		200
	SkillCastStatDelay		1000	1500	2000	2500	3000
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	
	SkillData1				60000	90000	120000	150000	180000 //지속시간	
return

SetSkill MH_VOLCANIC_ASH
OnInit:
	SkillMaxLv				5
	SkillType				TOGROUND
	SkillRange				7		7		7		7		7 
	SkillSP					60		65		70		75		80
	SkillCastFixedDelay		1000	1000	1000	1000	1000
	SkillCastStatDelay		4000	3500	3000	2500	2000
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	
	SkillData1				1		1		1		1		1	//3*3
	SkillData2				12000	14000	16000	18000	20000
return

//---------------------------호문변이---------------------------------------*/


SetSkill NPC_ASSASSINCROSS //npc용 석양의 어세신 크로스
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillData1	25	30	35	40 	45	50	55	60	65	70 //공격속도증가
	
return

SetSkill NPC_DISSONANCE //npc용 불협화음
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillData1	40	50	60	70 	80 //기본데미지
	
return

SetSkill NPC_UGLYDANCE //npc용 막춤
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillData1	10	15	20	25 	30 //기본데미지
	
return

SetSkill MC_CARTDECORATE // 카트꾸미기(SKID_MC_CARTDECORATE)
OnInit:
	SkillMaxLv			1
	SkillType			TOME
	SkillEvent
	SkillPattern		SKILLPATT_NONE // 공격이 아닌 스킬타입
	SkillSP				40 // SP소모량
	SkillData1			658188 // 카트의종류(바이트) 코드의 IsAbleChangeCart()함수에 예약한후 이곳에 추가 하여야 한다.
return

/////////////////////닌자 확장 스킬/////////////////////////
SetSkill KO_YAMIKUMO	//암운 (闇雲)
OnInit:
	SkillType 	TOME
	SkillMaxLv 	1
	SkillSP		10
return 

SetSkill KO_RIGHT	//오른손 수련 (패시브) [KO_RIGHT] 
OnInit:
	SkillType 	PASSIVE			
	SkillMaxLv 	5
return 

SetSkill KO_LEFT
OnInit:
	SkillType 	PASSIVE			
	SkillMaxLv 	5
return 

SetSkill KO_JYUMONJIKIRI //십자 베기 (十門字斬)
OnInit:
	SkillType	TOCHARACTER
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillMaxLv 	5
	SkillRange			3	4	5	6	7 
	SkillSP				10	12	14	16	18
	SkillCastFixedDelay		0	0	0	0	0		//스킬 캐스팅
	SkillCastStatDelay		0	0	0	0	0		//스탯 캐스팅
	SkillSinglePostDelay		5000	4500	4000	3500	3000		//스킬 쿨타임
	SkillGlobalPostDelay		500	500	500	500	500		//글로벌 쿨타임
return 

SetSkill KO_SETSUDAN	//영혼 절단 (?魂絶斷)
OnInit:
	SkillType	TOCHARACTER
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillMaxLv 	5
	SkillRange			2	2	2	2	2 
	SkillSP				12	16	20	24	28
	SkillCastFixedDelay		0	0	0	0	0		//스킬 캐스팅
	SkillCastStatDelay		0	0	0	0	0		//스탯 캐스팅
	SkillSinglePostDelay		3000	3000	3000	3000	3000		//스킬 쿨타임
	SkillGlobalPostDelay		0	0	0	0	0		//글로벌 쿨타임
return 

SetSkill KO_BAKURETSU	//폭발 쿠나이 (爆?苦無) 
OnInit:
	SkillType	TOGROUND
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillMaxLv 	5
	SkillRange			7	8	9	10	11
	SkillSP				5	6	7	8	9
	SkillCastFixedDelay		0	0	0	0	0		//스킬 캐스팅
	SkillCastStatDelay	     1000    1400    1800    2200    2600		//스탯 캐스팅
	SkillSinglePostDelay	     3000    3000    3000    3000    3000		//스킬 쿨타임
	SkillGlobalPostDelay 	     1000    1000    1000    1000    1000		//글로벌 쿨타임
	SkillData1			1	1	1	1 	1 		//효과범위
	
return 

SetSkill KO_HAPPOKUNAI	//팔방 쿠나이 (八方苦無)
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillRange			0	0	0	0	0
	SkillSP				12	14	16	18	20
	SkillCastFixedDelay		0	0	0	0	0		//스킬 캐스팅
	SkillCastStatDelay		0	0	0	0	0		//스탯 캐스팅
	SkillSinglePostDelay		0	0	0	0	0		//스킬 쿨타임
	SkillGlobalPostDelay		500	500	500	500	500		//글로벌 쿨타임
	SkillData1			4	4	4	4 	5 		//효과범위
return 

SetSkill	KO_MUCHANAGE	//마구 던지기 (無茶投げ)
OnInit:
	SkillType	TOGROUND
	SkillMaxLv 	10
	SkillRange			11	11	11	11	11	11	11	11	11	11
	SkillSP				50	50	50	50	50	50	50	50	50	50
	SkillCastStatDelay		1000	1000	1000	1000	1000	1000	1000	1000	1000	1000	//스탯 캐스팅
	SkillSinglePostDelay		10000	10000	10000	10000	10000	10000	10000	10000	10000	10000	//스킬 쿨타임
	SkillData1			10000	20000	30000	40000 	50000	60000	70000	80000	90000	100000 	//제니소모
	SkillData2			1	1	1	1	1	1	1	1	1	2	//효과범위

return 

SetSkill KO_HUUMARANKA	//풍마수리검 난화
OnInit:
	SkillType	TOGROUND
	SkillMaxLv 	5
	SkillRange		    9	   10      11      12      13 // 사정거리
	SkillSP			   24	   28      32      36      40 // 소모SP
	SkillCastFixedDelay         0 	    0	    0	    0 	    0  // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	 1000 	 1200	 1400	 1600 	 1800 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	 3000	 3000	 3000	 3000	 3000  // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000  // 스킬사용후 전체스킬사용금지시간
return 

SetSkill KO_MAKIBISHI	//마키비시
OnInit:
	SkillType				TOME
	SkillMaxLv 				5	
	SkillProperty			PROPERTY_Nothing  // 속성없음
	SkillSP					    9	   12      15      18      21 // 소모SP
	SkillCastFixedDelay         0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		    0	    0	    0	    0	    0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0	    0	    0	    0	    0 // 스킬사용후 전체스킬사용금지시간
	SkillData1				    3       4       5       6       7 // 뿌릴 마키비시갯수
	SkillData2				12000   14000   16000   18000   20000 // 지속시간
	SkillData3				    3       4       5       6       7 // 마키비시
return 

SetSkill KO_MEIKYOUSISUI	//명경지수
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillSP					  100	  100     100     100     100 // 소모SP
	SkillCastFixedDelay         0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		 3000	 3000	 3000	 3000	 3000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0	    0	    0	    0	    0 // 스킬사용후 전체스킬사용금지시간
	SkillData1				10000   10000   10000   10000   10000 // 지속시간
return 

SetSkill KO_ZANZOU	// 환술-잔영
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillSP					   40      44      48      52	   56 // 소모SP
	SkillCastFixedDelay         0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		    0	    0	    0	    0	    0 // 스킬 캐스팅 스텟에 영향받는 delay값	
	SkillSinglePostDelay	30000	27000	24000	21000	18000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				27000   24000   21000   18000   15000 // 도플갱어의 지속시간
return 


SetSkill KO_KAHU_ENTEN	////화부 : 염천
OnInit:
	SkillType	TOME
	SkillMaxLv 	1
	SkillSP			   20 // 소모SP
	SkillCastFixedDelay         0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	 2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0 // 스킬사용후 전체스킬사용금지시간
return 

SetSkill KO_HYOUHU_HUBUKI ////빙부 : 취설
OnInit:
	SkillType	TOME
	SkillMaxLv 	1
	SkillSP			   20 // 소모SP
	SkillCastFixedDelay         0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	 2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0 // 스킬사용후 전체스킬사용금지시간
return 

SetSkill KO_KAZEHU_SEIRAN ////풍부 : 청람
OnInit:
	SkillType	TOME
	SkillMaxLv 	1
	SkillSP			   20 // 소모SP
	SkillCastFixedDelay         0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	 2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0 // 스킬사용후 전체스킬사용금지시간
return 

SetSkill KO_DOHU_KOUKAI ////토부 : 강괴
OnInit:
	SkillType	TOME
	SkillMaxLv 	1
	SkillSP			   20 // 소모SP
	SkillCastFixedDelay         0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	 2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay	    0 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0 // 스킬사용후 전체스킬사용금지시간
return 

SetSkill KO_KAIHOU ////술식해방
OnInit:
	SkillType	TOCHARACTER
	SkillPattern 	SKILLPATT_ATTACKSPELL
	SkillMaxLv 	1
	SkillRange		   11 // 사정거리
	SkillSP			   10 // 소모SP
return

SetSkill KO_ZENKAI	//술식전개
OnInit:
	SkillType		TOGROUND
	SkillMaxLv 		       1
	SkillGlobalPostDelay        1000 // 스킬사용후 전체스킬사용금지시간
	SkillRange		   7 // 사정거리
	SkillSP			      30 // 소모SP	
return


SetSkill KO_KYOUGAKU	// 환술-경악
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP					   40      44      48      52	   56 // 소모SP
	SkillRange				    5		5       5       5       5 // 사정거리
	SkillCastFixedDelay         0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		 3000    2500    2000    1500    1000 // 스킬 캐스팅 스텟에 영향받는 delay값	
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				12000   14000   16000   18000   20000 // 효과지속시간
	SkillData2				   50      55      60      65      70 // 적용확률
return 

SetSkill KO_JYUSATSU	// 환술-주살
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP					   40      44      48      52	   56 // 소모SP
	SkillRange		    5	    5       5       5       5 // 사정거리
	SkillCastFixedDelay         0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	 3000    2500    2000    1500    1000 // 스킬 캐스팅 스텟에 영향받는 delay값	
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1		 8000   10000	12000	14000	16000 // 적용시간
	SkillData2		   50      55	   60	   65	   70 // 적용확률

return 


SetSkill KO_GENWAKU	// 환술-환혹
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP					   40      44      48      52	   56 // 소모SP
	SkillRange				    5		6       7       8       9 // 사정거리
	SkillCastFixedDelay         0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		 3000    2500    2000    1500    1000 // 스킬 캐스팅 스텟에 영향받는 delay값	
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				   50      55      60      65      70 // 적용확률
return 

SetSkill KO_IZAYOI // 열 여섯번째의 밤
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillSP					   70      75      80      85	   90 // 소모SP
	SkillCastFixedDelay         0	    0	    0	    0	    0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		    0       0       0       0       0 // 스킬 캐스팅 스텟에 영향받는 delay값	
	SkillSinglePostDelay	60000   60000   60000   60000   60000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay        0       0       0       0       0 // 스킬사용후 전체스킬사용금지시간	
	SkillData1				30000   45000   60000   75000   90000 // 지속시간
return 

SetSkill KG_KAGEHUMI // 그림자 밟기
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillSP			25      30      35      40	45 // 소모SP
	SkillData1		2        3       4       5      6 // 효과범위
	SkillData2		5000  6000    7000    8000   9000 // 지속시간

return 

SetSkill KG_KYOMU // 허무의그림자
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP			50      50      50      50	50 // 소모SP
	SkillSinglePostDelay	20000   20000   20000   20000   20000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1		10000  15000    20000   25000  30000 // 지속시간

return 


SetSkill KG_KAGEMUSYA // 그림자무사
OnInit:
	SkillType	TOALL
	SkillMaxLv 	5
	SkillSP			60      65      70      75	80 // 소모SP
	SkillSinglePostDelay	20000   20000   20000   20000   20000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1		60000   90000  120000  150000  180000 // 지속시간

return 

SetSkill OB_ZANGETSU // 일그러진 초승달
OnInit:
	SkillType	TOALL
	SkillMaxLv 	5
	SkillSP			60      70      80      90	100 // 소모SP
	SkillRange		   7	7       7       7       7 // 사정거리
	SkillCastFixedDelay     2000	 2000	 2000	 2000	2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	1000    1500    2000    2500    3000 // 스킬 캐스팅 스텟에 영향받는 delay값	
	SkillSinglePostDelay	30000   30000   30000   30000   30000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1		60000   75000   90000  105000  120000 // 지속시간

return 


SetSkill OB_OBOROGENSOU	//흐린달빛의 환상
OnInit:
	SkillType	TOALL
	SkillMaxLv 	5
	SkillSP					55		60		65     70		75 // 소모SP
	SkillRange			 	 7		 7       7      7       7 // 사정거리	
	SkillCastStatDelay	   1000    1000    1000    1000    1000 // 스킬 캐스팅 스텟에 영향받는 delay값	
	SkillSinglePostDelay      15000   15000   15000   15000   15000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay   1000    1000    1000    1000    1000 // 스킬사용후 전체스킬사용금지시간	
	SkillData1			  10000   15000   20000   25000   30000 // 지속시간
	SkillData2			  30   35   40   45   50 // 기본성공수치

return 

SetSkill OB_AKAITSUKI // 불길한 붉은 달빛(SKID_OB_AKAITSUKI)
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP					   20      30      40      50	   60 // 소모SP
	SkillRange				    7		7       7       7       7 // 사정거리
	SkillCastFixedDelay      2000	 2000	 2000	 2000	 2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		 1000    1500    2000    2500    3000 // 스킬 캐스팅 스텟에 영향받는 delay값	
	SkillSinglePostDelay	30000	30000	30000	30000	30000 // 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // 스킬사용후 전체스킬사용금지시간
	SkillData1				10000   15000   20000   25000   30000 // 지속시간
return
/////////////////////닌자 확장 스킬  끝/////////////////////////
SetSkill	ALL_FULL_THROTTLE // 풀 스로틀 (공통 3차스킬)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSinglePostDelay 	3000000 3000000	3000000	3000000	3000000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	6	4	3	2	1 	// 1초당 MSP의 퍼센트 비율로 소모한다
	SkillData2	 	10000	15000	20000	25000	30000 	// 유지시간
return

SetSkill RK_DRAGONBREATH_WATER
OnInit:
	SkillMaxLv 	10
	SkillType 		TOGROUND
	SkillFlag 		SKFLAG_NODISPEL
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillProperty 	PROPERTY_Water
	SkillSP 		30 35 40 45 50 55 60 65 70 75
	SkillRange 	9 9 9 9 9 9 9 9 9 9
	SkillCastFixedDelay 500 500 500 500 500 500 500 500 500 500
	SkillCastStatDelay  0    0    0    1000 1000 1000 1500 1500 2000 2000
	SkillGlobalPostDelay 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000
	SkillData1 	1 1 1 2 2 2 3 3 4 4 // 효과범위, 3*3, 3*3, 3*3, 5*5, 5*5, 5*5, 7*7, 7*7, 9*9, 9*9
return

SetSkill RK_LUXANIMA	// 룬스킬 : 럭스아니마 (SKID_RK_LUXANIMA)
	SkillMaxLv		1
	SkillType TOME
	SkillGlobalPostDelay 1000
return

SetSkill	LG_KINGS_GRACE // 왕의 가호(로얄가드스킬)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			200	180	160	140	120
	SkillSinglePostDelay 	100000 	90000	80000	70000	60000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	4	5	6	7	8 	//초당 HP 회복 퍼센트
return

SetSkill	WL_TELEKINESIS_INTENSE	//텔레키네틱 인텐스
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			100	150	200	250	300	
	SkillSinglePostDelay 	300000  	300000	300000	300000	300000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	60000	60000	60000	60000	60000 	// 지속시간
	SkillData2	 	140	180	220	260	300 	// 염속성 마법 마법공격력증가
	SkillData3	 	10	20	30	40	50 	// 변동캐스팅 감소
	SkillData4	 	10	20	30	40	50 	// 염속성마법 소모sp감소
return

SetSkill	SO_ELEMENTAL_SHIELD
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME			
	SkillSP 		120	120	120	120	120	
	SkillSinglePostDelay 0	0	0	0	0
	SkillGlobalPostDelay 0 	0	0 	0	0
	SkillData1	  7	8	9	10	11 	// 방어횟수
	SkillData2	  30000	35000	40000	45000	50000 	// 지속시간
	SkillData3	 1800	2100	2400	2700	3000 	// 기본 내구도
return

SetSkill	AB_OFFERTORIUM	//오페르토리움
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			30	60	90	120	150	
	SkillCastStatDelay  	5000	4000	3000	2000	1000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	130	160	190	220	250 	// 힐 회복량(100분율)
	SkillData2	 	220	240	260	280	300 	// 모든 스킬 사용시 sp 소모량(100분률)
	SkillData3		90000	90000	90000	90000	90000	// 버프 지속시간	
return

SetSkill	SR_FLASHCOMBO	//섬광연격
OnInit:
	SkillMaxLv 	5
	SkillType 		TOCHARACTER
	SkillSP 		65	65	65	65	65	
	SkillSinglePostDelay 12000  	10000	8000	6000	4000
	SkillGlobalPostDelay 1000 	1000	1000 	1000	1000
	SkillData1	  4000	4000	4000	4000	4000 	// 지속시간
	SkillData2	  5	5	4	4	3 	// 소모 기구체 수
	SkillData3	 40	60	80	100	120 	// atk증가
return

SetSkill	RA_UNLIMIT // 언리밋(레인저스킬)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			100	120	140	160	180
	SkillCastFixedDelay		1000	1000	1000	1000	1000
	SkillSinglePostDelay 	300000 	300000	300000	300000	300000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	150	200	250	300	350 	// 공격력상승(100분율)

return

SetSkill WM_FRIGG_SONG
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME			
	SkillSP 		200	230	260	290	320
	SkillCastStatDelay  1000	1000	1000	1000	1000
	SkillGlobalPostDelay 2000 	2000	2000 	2000	2000
	SkillData1	  3	4	5	6	7 	// 효과범위, 11*11, 13*13, 15*15, 17*17,19*19
	SkillData2	  5	10	15	20	25 	// 10초당 MHP %회복
	SkillData3	 100	120	140	160	180 	//  10초당 HP회복 절대값
return

SetSkill	GC_DARKCROW // 검은 손톱(길로틴크로스스킬) (SKID_GC_DARKCROW)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOCHARACTER
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillAtkPer 		100 	200 	300 	400 	500
	SkillSP 			22	34	46	58	70
	SkillSinglePostDelay 	60000 	60000	60000	60000	60000
	SkillData1	  	130	160	190	220	250 	// 근거리 물리데미지 증폭량

return

SetSkill	SC_ESCAPE	//긴급 탈출(SKID_SC_ESCAPE )
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			30	26	22	18	14	
	SkillSinglePostDelay 	10000  	8000	6000	4000	2000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	5	6	7	8	9 	// 반대방향셀이동
return

SetSkill NC_MAGMA_ERUPTION
OnInit:
	SkillMaxLv 	5
	SkillType 		TOGROUND
	SkillFlag 		SKFLAG_NODISPEL
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillProperty 	PROPERTY_Nothing  // 속성없음
	SkillSP 		60	70	80	90	100
	SkillRange 	1	1	1	1	1
	SkillCastFixedDelay 0	0	0	0	0
	SkillCastStatDelay  1000	1000	1000	1000	1000
	SkillGlobalPostDelay 500 	500	500 	500	500
	SkillSinglePostDelay 10000	9000	8000	7000	6000
	SkillData1	  500	550	600	650	700 // 스킬시전시 ATK
	SkillData2	  1000	1200	1400	1600	1800 // 용암대지의 고정데미지
	SkillData3	  100	200	300	400	500 // 발화확률(1000분률)
return

SetSkill	GN_ILLUSIONDOPING // 환각도핑 (제네릭스킬)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOCHARACTER
	SkillSP 			60	70	80	90	100	
	SkillCastFixedDelay		1000	1000	1000	1000	0
	SkillSinglePostDelay 	5000 	4000	3000	2000	1000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	4	5	6	7	18 	// 적용셀
	SkillData2	 	900	800	700	650	500 	// 환각 퍼센트
return
SetSkill ECLAGE_RECALL								
OnInit:								
	SkillMaxLv 1							
	SkillSP 0							
	SkillType TOME							
	SkillCastFixedDelay  3000			// 고정캐스팅				
	SkillSinglePostDelay 300000			//스킬딜레이				
	SkillDataString			"ecl_in01.gat"		 // 맵이름		
	SkillData1			47 31			 // x, y	
return

SetSkill ALL_RAY_OF_PROTECTION  //수호의 빛
OnInit:
	SkillMaxLv 1
	SkillType  TOME
return
SetSkill NPC_COMET //커미트-워록
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillFlag		SKFLAG_APPLY_PLUSRNG //스킬사정거리증가옵션
	SkillRange                  11	    11	    11	    11	    11 // 스킬사정거리	
	SkillData1	  3000	  3500	  4000	  4500	  5000 // 범위1의 MATK 공격증가률
	SkillData2	  2500    3000    3500    4000    4500 // 범위2의 MATK 공격증가률
	SkillData3	  2000    2500    3000    3500    4000 // 범위3의 MATK 공격증가률
	SkillData4	  1500    2000    2500    3000    3500 // 범위4의 MATK 공격증가률
return



SetSkill NPC_FLAMECROSS //플레임크로스
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillData1	  20	    40	  60	  80	  100 // 데미지 * atk
	SkillData2	  3000   3000    3000    3000    3000    // 지속 시간 1/1000 단위
return


SetSkill NPC_ICEMINE //얼음 지뢰
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing  // 속성없음
	SkillSplash SQUARE 3 3 3 3 3	//스킬 효과 범위
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillData1	  20	    40	  60	  80	  100 // 데미지 * atk
	SkillData2	  10000   10000    10000    10000    10000    // 지속 시간 1/1000 단위
return

SetSkill NPC_PULSESTRIKE2
OnInit:
	SkillMaxLv		1
	SkillProperty	PROPERTY_Darkness  // 속성없음
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //마법공격
	SkillAtkPer	200
	SkillData1	1000	//공격시간 텀(초), 1/1000 단위
	SkillData2	3	//공격 횟수 
	
return


SetSkill NPC_DANCINGBLADE // 춤추는 칼날(시전스킬, 실제공격은 NPC_DANCINGBLADE_ATK 로 한다)
OnInit:
	SkillMaxLv				1						// 최대 레벨
	SkillProperty			PROPERTY_Nothing		// 무속성
	SkillType				TOCHARACTER				// 적 1체
	SkillPattern    		SKILLPATT_NONE			// 공격스킬 아님
	SkillRange				10						// 스킬사정거리
	SkillCastFixedDelay     1000					// 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		3500					// 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay    0						// 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay    3000					// 스킬사용후 전체스킬사용금지시간 	
	SkillData1				4						// 전이횟수(다른타겟으로)
return

SetSkill NPC_DANCINGBLADE_ATK // 춤추는 칼날(실제공격스킬)
OnInit:
	SkillMaxLv				1						// 최대 레벨
	SkillProperty			PROPERTY_Nothing		// 무속성
	SkillType				TOCHARACTER				// 적 1체
	SkillPattern			SKILLPATT_DIRECTATTACK	// 물리 공격 스킬타입
	SkillAtkPer				100						// 공격데미지증가율(%)
	SkillRange              10						// 스킬사정거리
	SkillCastFixedDelay     0						// 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		0						// 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay    0 						// 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay    0						// 스킬사용후 전체스킬사용금지시간
return


SetSkill NPC_DARKPIERCING // 다크피어스
OnInit:
	SkillMaxLv				1						// 최대 레벨
	SkillProperty			PROPERTY_Nothing		// 무속성
	SkillType				TOCHARACTER				// 적 1체
	SkillPattern    		SKILLPATT_DIRECTATTACK	// 물리 공격 스킬타입
	SkillAtkPer				100						// 공격데미지증가율(%)
	SkillRange				3						// 스킬사정거리
	SkillCastFixedDelay     0						// 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		0						// 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay    2000					// 스킬사용후 해당스킬을 재사용하는데 필요한 시간
	SkillGlobalPostDelay    0						// 스킬사용후 전체스킬사용금지시간
return

SetSkill NPC_VENOMFOG						// +서버, OnUse:바닥스킬
OnInit:
	SkillProperty	PROPERTY_Poison  // 독속성
	SkillMaxLv 10
	SkillType TOME
	SkillSplash SQUARE 2 2 2 2 2 2 2 2 2 5			// 
	SkillData1              3000 3000 3000 3000 3000 3000 3000 3000 3000 3000			// 바닥스킬 지속시간
	SkillData2             50 100 150 200 250 300 350 400 450 500 				// 독효과(HEALTHHeavyPoison)
return
SetSkill NPC_JACKFROST // 몬스터스킬(잭프로스트)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Water // 수속성
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL // 마법공격
	SkillRange                 11	   11	   11	   11	   11 // 스킬사정거리
	SkillAtkPer	 1300	 1600    1900	 2200    2500
	SkillData1	    5	    6	    7       8       9 // 효과범위(반경)
	SkillData2	10000	15000	20000	25000	30000 // 동빙유지시간
return

SetSkill NPC_LEX_AETERNA	// 범위 렉스 에테르나 (NPC_LEX_AETERNA)
OnInit:
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillData1		2	5	8	11	14	// 시전 반경(5*5, 11*11, 17*17, 23*23, 29*29)
return

SetSkill NPC_REVERBERATION //진동 잔향 (SKID_NPC_REVERBERATION)
OnInit:
	SkillPattern		SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOME
	SkillAtkPer		600	800	1000	1200	1400
return

SetSkill NPC_WIDEWEB	//광역 웹(NPC_WIDEWEB)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillData1		7		// 시전 반경이 7셀(15 x 15)
return

SetSkill NPC_FIRESTORM	// 화염 폭풍 (NPC_FIRESTORM)
OnInit:
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Fire
	SkillAtkPer		300		300		300
	SkillData1		3		3		3	// 시전 반경이 3셀 (7 x 7)
	SkillData2		1		3		5	// 히트 수
	SkillData3		2000	2000	2000	// 화상효과 Tick 데미지
return


SetSkill NPC_WIDESUCK //광역 흡혈
OnInit:
	SkillMaxLv	1
	SkillType 		TOGROUND
	SkillData1	13	//적용범위
	SkillData2	15	//MHP 흡수비율
	SkillData3	3	//몇번 흡수 할것인가 (1초당 흡수함)
return

SetSkill NPC_HELLBURNING
OnInit:
	SkillMaxLv	1
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL 	//마법공격
	SkillProperty	PROPERTY_Fire		//불속성
	SkillAtkPer	1000			// 공격데미지증가율(%)
	SkillData1	3000			//지속시간
return



SetSkill NPC_MAXPAIN	//맥스페인
OnInit:
	SkillMaxLv	10
	SkillType		TOME
	SkillData1	10	20	30 	40 	50	60 	70	80	90	100	// 유저에게 반사되는 데미지  비율 (백분율)	
return

SetSkill ALL_NIFLHEIM_RECALL
OnInit:
	SkillMaxLv 1
	SkillSP 10
	SkillType TOME	
	SkillCastFixedDelay  1000			// 고정캐스팅
	SkillSinglePostDelay 300000			//스킬딜레이
	SkillDataString			"niflheim.gat"		 // 맵이름
	SkillData1			193 186			 // x, y
return
//건슬링거 확장 상위 직업군 리벨리온
SetSkill RL_RICHS_COIN	//리치스 코인 : (부유한 자의 재물)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillSP					10
	SkillSinglePostDelay 	3000
	SkillGlobalPostDelay 	1000
	SkillData1		100	// 제니소모량
	SkillData2		10	// 코인생성개수
return

SetSkill RL_MASS_SPIRAL  //매스 스파이럴
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOCHARACTER	
	SkillRange				15		15		15		15		15
	SkillSP					80		84		88		92		96
	SkillCastFixedDelay     2000	2000	2000	2000	2000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		1000	1000	1000	1000	1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	10000 	10000	10000	10000	10000
	SkillGlobalPostDelay 	1000 	1000	1000 	1000	1000
	SkillData1		1	1	1	1	1	// 소모코인수	
	SkillData2		400	500	600	700	800	// 출혈확률(천분율)
return


SetSkill RL_BANISHING_BUSTER  //배니싱 버스터 
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOCHARACTER	
	SkillRange				9		9		9		9		9
	SkillSP					55		60		65		70		75
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	    3000	2500	2000	1500	1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	6000 	7000	8000	9000	10000
	SkillGlobalPostDelay 	2000 	2000	2000 	2000	2000
	SkillData1		1	1	1	1	1	// 소모코인수
	SkillData2		2	2	2	2	2	// 데미지 효과 범위
	SkillData3		1	2	3	4	5	// 삭제 되는 버프수
return


SetSkill RL_B_TRAP  //바인드 트랩 
OnInit:	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOME		
	SkillSP					30		32		34		36		38	
	SkillCastFixedDelay     0		0		0		0		0	// 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		2000	1600	1200	800		400	// 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	0 		0		0		0		0
	SkillGlobalPostDelay 	2500 	2000	1500 	1000	500
	SkillData1		1		1		1		1		1		// 소모코인수
	SkillData2		10000	11000	12000	13000	14000	// 이동속도감소 시간
	SkillData3		1		2		2		3		3		// 효과범위
return



SetSkill RL_FLICKER  //플리거
OnInit:		
	SkillMaxLv		1
	SkillType		TOME		
	SkillSP					2
	SkillCastFixedDelay     0
	SkillCastStatDelay		0
	SkillSinglePostDelay 	10000
	SkillGlobalPostDelay 	0
	SkillData1				15	//효과범위
return

SetSkill RL_S_STORM  //섀터 스톰
OnInit:	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOCHARACTER		
	SkillRange				9		9		9		9		9
	SkillSP					50		55		60		65		70	
	SkillCastFixedDelay     1000	1000	1000	1000	1000	// 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		3000	2500	2000	1500	1000	// 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	6000    7000	8000	9000	10000
	SkillGlobalPostDelay 	2000 	2000	2000 	2000	2000
	SkillData1		3		3		3		3		3		// 소모코인수
	SkillData2		2		2		2		2		2		// 효과범위
	SkillData3		1		1		1		1		1		// 파괴되는 장비수	
return

SetSkill RL_E_CHAIN  //이터널체인( 무한연쇄)
OnInit:	
	SkillMaxLv		10
	SkillType		TOME
	SkillSP			            45     45	    45	    45	    45	    45	    45	    45	    45	    45
	SkillCastFixedDelay          0      0        0       0       0       0       0       0       0       0
	SkillCastStatDelay		  1000	 1000     1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000
	SkillSinglePostDelay 	     0      0        0       0       0       0       0       0       0       0  
	SkillGlobalPostDelay 	  1000	 1000     1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000
	SkillData1				 45000   60000   75000   90000  105000  120000  135000  150000  165000  180000	//지속시간	
return

SetSkill RL_QD_SHOT  //퀵드로우샷
OnInit:	
	SkillMaxLv		1
	SkillType		TOME
	SkillSP					5
	SkillCastFixedDelay     0
	SkillCastStatDelay		0
	SkillSinglePostDelay 	0
	SkillGlobalPostDelay 	0
	SkillData1		10		//21*21 적용범위	
return


SetSkill RL_C_MARKER  //크림즌마커(피의낙인)
OnInit:	
	SkillMaxLv		1
	SkillType		TOCHARACTER
	SkillRange				11
	SkillSP					10
	SkillCastFixedDelay     0
	SkillCastStatDelay		0
	SkillSinglePostDelay 	1000
	SkillGlobalPostDelay 	0
	SkillData1				1		//코인소비
	SkillData2				30000	//지속시간
	SkillData3				10		//Flee 감소수치
return

SetSkill RL_FIREDANCE //파이어댄스(살육의 춤)
OnInit:
	SkillMaxLv				5
	SkillType				TOME	
	SkillSP					10	10	10	10	10
	SkillGlobalPostDelay 	500	500	500	500	500
	SkillData1				3	3	3	3	3		//범위 	
	SkillData2				5	5	5	5	5		//총알수
	SkillData3				1	1	1	1	1		//코인소모수
return

SetSkill RL_H_MINE // 하울링 마인(파괴의 절규)
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOCHARACTER	
	SkillRange		7	8	9	10	11
	SkillSP			45	50	55	60	65
	SkillCastFixedDelay        0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	    1000	1000	1000	1000	1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	5000 	4500	4000	3500	3000
	SkillGlobalPostDelay 	1000 	1000	1000 	1000	1000
	SkillData1		           2	   2	   2	   2	   2 // 효과범위
	SkillData2		           1	   1	   1	   1	   1 // 코인소모갯수
return

SetSkill RL_P_ALTER	// 플래티넘 알터
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP			20	24	28	32	36
	SkillCastFixedDelay     0	0	0	0	0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	2000	2000	2000	2000	2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	0 	0	0	0	0
	SkillGlobalPostDelay 	0 	0	0 	0	0
	SkillData1				30000	45000	60000	75000	90000		// 버프 지속시간
return

SetSkill RL_FALLEN_ANGEL // 펄른엔젤(타천사)
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag SKFLAG_NODISPEL	// 캐스팅이 끊기지 않도록 수정
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange		            9	   9	   9	   9	   9
	SkillSP			           10	  10	  10	  10	  10
	SkillCastFixedDelay       500	 500	 500	 500	 500 
	SkillSinglePostDelay 	10000	8000	6000	4000	2000
	SkillGlobalPostDelay 	 3000	2500	2000	1500	1000
	SkillData1				    1      1       1       1       1 // 코인소모갯수
return

SetSkill RL_R_TRIP // 라운드 트립
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOME	
	SkillSP			20	25	30	35	40
	SkillCastFixedDelay     0	0	0	0	0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	0	0	0	0	0 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	3000 	2500	2000	1500	1000
	SkillGlobalPostDelay 	1000 	1000	1000 	1000	1000
	SkillData1		3	3	4	5	6	// 효과범위
	SkillData2		3	3	3	3	3	// 넉백거리
return

SetSkill RL_R_TRIP_PLUSATK
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK	
return

SetSkill RL_D_TAIL // 드래곤 테일(마수의 꼬리)
OnInit:
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillMaxLv				5
	SkillType				TOME	
	SkillSP					60	70	80	90	100	
	SkillCastStatDelay		1200	1400	1600	1800	2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	5000	5000	5000	5000	5000
	SkillGlobalPostDelay 	2000	2000	2000	2000	2000
	SkillData1		15		15		15		15		15	// 적용범위

return

SetSkill RL_FIRE_RAIN	// 파이어 레인
OnInit:
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillMaxLv				5
	SkillType				TOGROUND
	SkillSP					70	70	70	70	70
	SkillCastFixedDelay        0	   0	   0	   0	   0 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		1800	1600	1400	1200	1000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	5000    5000    5000    5000    5000
	SkillGlobalPostDelay 	1000	1000	1000	1000	1000
	SkillRange		           3	   3	   3	   3	   3
	SkillData1		           1	   1	   1       1       1 // 코인소모갯수
return

SetSkill RL_HEAT_BARREL // 히트배럴(착열총탄)
OnInit:	
	SkillMaxLv			5
	SkillType			TOME	
	SkillSP				30	30	30	30	30
	SkillCastStatDelay		2000	2000	2000	2000	2000
	SkillSinglePostDelay 		100000	95000	90000	85000	80000
	SkillGlobalPostDelay 		1000	1000	1000	1000	1000
	SkillData1			70	65	60	55	50	// Flee - 패널트값
	SkillData2			8	10	12	14	16	// ATK+ ( 소모한코인개수 * SkillData2값 )
	SkillData3			60000	60000	60000	60000	60000	// 지속시간
return

SetSkill RL_AM_BLAST	//안티매터리얼 블래스트
OnInit:	
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern            SKILLPATT_DIRECTATTACK
	SkillRange		15	15	15	15	15
	SkillSP			80	84	88	92	96			
	SkillCastFixedDelay      1000	1000   1000	  1000	 1000 // 스킬 캐스팅 고정 delay값
	SkillCastStatDelay	     2000	2000   2000	  2000	 2000 // 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	 5000  5000  5000	 5000  5000
	SkillGlobalPostDelay 	 1000	1000   1000	  1000	 1000
	SkillData1		            1	   1	  1	     1	    1 // 코인소모
	SkillData2				 6000   7000   8000   9000  10000 // 지속시간
	SkillData3		           10	  20	 30	    40	   50 // 플레이어형 내성효과감소
return

SetSkill RL_SLUGSHOT	//슬러그샷
OnInit:	
	SkillMaxLv				5
	SkillType				TOCHARACTER
	SkillRange				9		9		9		9		9
	SkillSP					80		84		88		92		96			
	SkillCastFixedDelay     1000	1000	1000	1000	1000	// 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		5000	6000	7000	8000	9000	// 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	5000	5000	5000	5000	5000
	SkillGlobalPostDelay 	1000	1000	1000	1000	1000
	SkillData1				1		1		1		1		1		// 코인소모
	SkillData2				10		9		8		7		6		// 1셀당 명중률 하락 수치
return

SetSkill RL_HAMMER_OF_GOD	//해머오브갓(신의분노)
OnInit:	
	SkillMaxLv				5
	SkillType				TOCHARACTER
	SkillRange				7		8		9		10		11
	SkillSP					35		40		45		50		55			
	SkillCastFixedDelay     5000	5000	5000	5000	5000	// 스킬 캐스팅 고정 delay값
	SkillCastStatDelay		2000	4000	6000	8000	10000	// 스킬 캐스팅 스텟에 영향받는 delay값
	SkillSinglePostDelay 	30000	30000	30000	30000	30000
	SkillGlobalPostDelay 	2000	2000	2000	2000	2000
	SkillData2				2		2		2		2		2		// 적용범위
	SkillData3				3000	3000	4000	4000	5000	// 마비지속시간 1/1000초
return
//리벨리온 끝