
// std_v2.sc�� �ߺ����� �ʵ��� ����!

// 2007/01/19 - �����ũ ���� (��Ÿ������)

// TODO : TOGROUND ��ų ������ �ʿ���

define PASSIVE			0
define TOCHARACTER 		1
define TOGROUND			2
define TOME			4
define TOALL			16

define SQUARE			1			// ������
define LINE			2			// ���� �������� ���� ����

define SKFLAG_NODISPEL		1
define SKFLAG_QUESTSKILL 	2
define SKFLAG_NOREDUCT		4
define SKFLAG_APPLY_PLUSRNG 32
define SKFLAG_IGNORE_SAFETYWALL 64
define SKFLAG_PLUS_TRAP_RANGE_RA_RESEARCHTRAP 128 //Ʈ�� ����(SKID_RA_RESEARCHTRAP)�� ���� �����Ÿ��� �����ϴ� ��ų�ΰ�?

define SKILLPATT_NONE				0	// ������ �ƴ� ��ųŸ��
define SKILLPATT_DIRECTATTACK		1	// ������ ���� ���� ��ųŸ��
define SKILLPATT_ATTACKSPELL		2	// ���� ���� ��ųŸ��

define ENUM			10000			// ��ų �Լ��� 10000 ���� ���

declare SetSkill 	n 	ENUM++			// [��ų]
declare OnUse: 		. 	ENUM++ blockcheck 	// ��ų�� ���������
declare OnSuccess:	.	ENUM++ blockcheck	// ��ų�� �������� ���
declare SkillType	n	ENUM++			// [Ÿ��] Ÿ��/����/����
declare SkillMaxLv	n	ENUM++			// [���� 1~10]
declare SkillPattern	n	ENUM++			// [����] ����/����/�Ϲ�
declare SkillSplash	n?	ENUM++			// [��������(���簢��/���簢��)][��������ŭ����]
declare SkillHitPer	n?	ENUM++			// ���߷�
declare SkillAtkPer	n?	ENUM++			// ���ݷ�
declare SkillData1	n?	ENUM++			// �߰� ����Ÿ.. Ȯ��..
declare SkillData2	n?	ENUM++			// �߰� ����Ÿ.. �ð�..
declare SkillFlag	n?	ENUM++			// 
declare SkillRange	n?	ENUM++			// ���ݰŸ�
declare SkillProperty	n	ENUM++			// ��ų �Ӽ�
declare SkillHandicap	n?	ENUM++			// [�����̻�][��������ŭ Ȯ��][��������ŭ �ð�(��)]
declare SkillKnockBack	n?	ENUM++			// [��������ŭ�и��°Ÿ�] �˹�
declare SkillNoDamage	.	ENUM++			// ������ ���� : OnUse������ ��� ����
declare SkillSP		n?		ENUM++			// [��������ŭ SP �Ҹ�]
declare SkillPreDelayTime n? ENUM++			// [��������ŭ ĳ���� �ð�]
declare SkillPostDelayTime n? ENUM++		// [��������ŭ ������ ������]
declare SkillResetHandicap n? ENUM++		// [�����̻�] �����̻� Ǯ��
declare SkillDrainHP n?	ENUM++				// [n%] ������ �� ��������� n% ��ŭ HP�� ���
declare SkillDrainSP n? ENUM++				// [n%] ���� ��ü SP���� n% ��ŭ SP�� ���� 
declare SkillEvent	.	ENUM++				// �̺�Ʈ��ų, ��ųƮ���� ������, NPC�� ���� ������ų�� ��ϰ����� ��ų
declare SkillCastFixedDelay n? ENUM++		// [��������ŭ ���� ĳ���� �ð�]
declare SkillCastStatDelay n? ENUM++		// [��������ŭ ���ݿ� ����޴� ĳ���� �ð�]
declare SkillGlobalPostDelay n? ENUM++		// [��������ŭ ��ü ��ų�� ��� �� �� ���� �ĵ�����]
declare SkillSinglePostDelay n? ENUM++		// [��������ŭ �ش� ��ų�� ��� �� �� ���� �ĵ�����]
declare SkillData3	n?	ENUM++				// �߰� ����Ÿ.. 
declare SkillData4	n?	ENUM++				// �߰� ����Ÿ..
declare SkillData5	n?	ENUM++				// �߰� ����Ÿ..
declare SkillData6	n?	ENUM++				// �߰� ����Ÿ..
declare SkillDataString s? ENUM++			// [��������ŭ ������ ����Ÿ]


SetSkill NPC_EARTHQUAKE 	// +����, OnUse:����������
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

SetSkill NPC_DRAGONFEAR		// +����, OnUse:���������̻�
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


SetSkill NPC_WIDESIGHT						// +����, OnUse:������ ã��
OnInit:
	SkillType TOME
	SkillMaxLv 1
	SkillSplash SQUARE 14
return

SetSkill NPC_EXPULSION						// +����, OnUse:�ڷ���Ʈ
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 1
	SkillRange 7
return

SetSkill NPC_SLOWCAST						// +����, OnUse:����
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillSplash SQUARE 2 5 8 11 14
	SkillData1 20 40 60 80 100				// ĳ���ýð�
	SkillData2 30 30 30 30 30 				// ���ӽð�(��)
return

SetSkill NPC_MAGICMIRROR					// +����, OnUse:����
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillData1 20 40 60 80 100 20 40 60 80 100		// �ݻ�Ȯ��
	SkillData2 30 30 30 30 30 2 2 2 2 2 				// ���ӽð�(��)
return

SetSkill NPC_STONESKIN						// +����, OnUse:����
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillData1 20 40 60 80 100 20 40 60 80 100			// �������������ҷ�, MDEF ����
	SkillData2 300 300 300 300 300 2 2 2 2 2			// ���ӽð�(��)
return

SetSkill NPC_ANTIMAGIC						// +����, OnUse:����
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillData1 20 40 60 80 100 20 40 60 80 100			// ���������� ���ҷ�, DEF ����
	SkillData2 300 300 300 300 300 2 2 2 2 2			// ���ӽð�(��)
return

SetSkill NPC_CRITICALWOUND					// +����, OnSuccess:����
OnInit:
	SkillType TOCHARACTER
	SkillMaxLv 5
	SkillRange 7 7 7 7 7
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillData1 20 40 60 80 100 				// �� ��ų ȿ�� ����
	SkillData2 30 30 30 30 30 				// ���ӽð�(��)
return

SetSkill NPC_EVILLAND						// +����, OnUse:�ٴڽ�ų
OnInit:
	SkillMaxLv 10
	SkillType TOGROUND
	SkillRange 7 7 7 7 7 7 7 7 7 7
	SkillSplash SQUARE 1 1 1 1 1 1 1 1 1 1			// �������� ����, 5 5 5 5 5 5 5 5 5 13
	SkillData2 4 7 10 13 16 19 22 25 28 31			// �ٴڽ�ų ���ӽð�
	SkillAtkPer 100 200 300 400 500 600 666 666 666 666	// ������ũ��, 7�������ʹ� ����������
return
OnSuccess:
	SkillHandicap HEALTHBlind 50 100 150 200 250 300 350 400 450 500 // ����
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
	SkillResetHandicap HEALTHConfusion		// ȥ���� ȯ������ ġ�� ����
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

SetSkill MER_SCAPEGOAT						// �������� �������� ó��
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
	SkillFlag SKFLAG_NOREDUCT			// __THIRDJOB1 ���� ���������� ����˴ϴ�.
	SkillCastFixedDelay 10000			// __THIRDJOB1 ���� �� ����˴ϴ�.
return

SetSkill RETURN_TO_ELDICASTES
OnInit:
	SkillType TOME
	SkillMaxLv 1
	SkillSP 0
	SkillCastFixedDelay		2000
	SkillSinglePostDelay	300000			 // ��ų�� �ĵ����̴� �������� EFST�� ������.
	SkillDataString			"dicastes01.gat" // ���̸�
	SkillData1				198 187			 // x, y
return


SetSkill ALL_GUARDIAN_RECALL
OnInit:
	SkillType TOME
	SkillMaxLv 1
	SkillSP 0
	SkillCastFixedDelay		3000
	SkillSinglePostDelay	300000			 // ��ų�� �ĵ����̴� �������� EFST�� ������.
	SkillDataString			"mora.gat"		 // ���̸�
	SkillData1				44 151			 // x, y
return

SetSkill ALL_ODINS_POWER
OnInit:
	SkillType TOALL
	SkillMaxLv		2
	SkillRange		9		9
	SkillSP			70		100
	SkillData1		70		100				//ATK ������
	SkillData2		70		100				//MATK ������
	SkillData3		20		40				//DEF ���ҷ�
	SkillData4		20		40				//MDEF ���ҷ�
	SkillData5		60000	60000			//���ӽð�
return

//********************************************************************************************************** 

// __THIRDJOB1

// �鳪��Ʈ
SetSkill RK_ENCHANTBLADE //��þƮ ���̵�(SKID_RK_ENCHANTBLADE)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						40		45		50		55		60 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�		
	SkillData1				   120	   140     160     180     200 // MATK	
	SkillData2              300000  300000  300000  300000  300000 // ���ӽð� 300��
return

SetSkill RK_SONICWAVE // �Ҵп��̺�
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange 7 8 9 10 11
	SkillSP 30 35 40 45 50
	SkillAtkPer 600 700 800 900 1000
	SkillSinglePostDelay 2000 2000 2000 2000 2000 //2��
	SkillGlobalPostDelay 1000 1000 1000 1000 1000 //1��
return

SetSkill RK_DEATHBOUND // ���� �ٿ��
OnInit:
	SkillMaxLv 10
	SkillType TOME
	SkillSP 28 31 34 37 40 43 46 49 52 55
	SkillAtkPer 600 700 800 900 1000 1100 1200 1300 1400 1500 // ������ ������
	SkillGlobalPostDelay 2000 2000 2000 2000 2000 2000 2000 2000 2000 2000
	SkillSinglePostDelay 3000 3000 3000 3000 3000 3000 3000 3000 3000 3000
return

SetSkill RK_HUNDREDSPEAR // ��巹�� ���Ǿ�
OnInit:
	SkillMaxLv 10
	SkillType TOCHARACTER
	SkillFlag SKFLAG_NODISPEL	// ĳ������ ������ �ʵ��� ����
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange 5  5  5  5  5  5  5  5  5  5 
	SkillSP   60 60 60 60 60 60 60 60 60 60
	SkillAtkPer 640 680 720 760 800 840 880 920 960 1000
	SkillData1 13 16 19 22 25 28 31 34 37 40 // ���Ǿ�θ޶� �ߵ� Ȯ��
	SkillCastStatDelay	1000	 900	 800	 700	 600	 500	 400	 300	 200	 100
	SkillSinglePostDelay    3000    3000    3000    3000    3000    3000    3000    3000    3000    3000
 	SkillGlobalPostDelay	 500	 500	 500	 500	 500	 500	 500	 500	 500	 500	 
return

SetSkill RK_WINDCUTTER //���� Ŀ��(SKID_RK_WINDCUTTER)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Wind
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						20		24		28		32		36 // SP�Ҹ�
	SkillAtkPer				   150	   200	   250	   300	   350 // ���ݵ�����������(%)
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay			 0	     0	     0	     0	     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay      2000	  2000	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay		 0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�		
return

SetSkill RK_IGNITIONBREAK //�̱״ϼ� �극��ũ(SKID_RK_IGNITIONBREAK)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillFlag		SKFLAG_NODISPEL								   // ĳ������ ������ �ʵ��� ����
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						35		40		45		50		55 // SP�Ҹ�	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�	
	SkillData1				   400	   600	   800	  1000	  1200 // ���� ���� ������
	SkillData2				   200     400	   600	   800    1000 // �߰� ���� ������
	SkillData3				   200	   300	   400	   500	   600 // �ٱ� ���� ������
return

SetSkill RK_DRAGONTRAINING
OnInit:
	SkillMaxLv 5
	SkillType PASSIVE	
	SkillAtkPer 100 105 110 115 120 // �巡��극�� ������ ����%
	SkillData1 80 85 90 95 100 // ����ȸ��
	SkillData2 700 900 1100 1300 1500 // ����������

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
	SkillData1 1 1 1 2 2 2 3 3 4 4 // ȿ������, 3*3, 3*3, 3*3, 5*5, 5*5, 5*5, 7*7, 7*7, 9*9, 9*9
return

SetSkill RK_DRAGONHOWLING
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSP 30 30 30 30 30	
	SkillData1 560 620 680 740 800 // ���� Ȯ��, õ�з�
	SkillData2 5000 5000 5000 5000 5000 // ȿ�� ���ӽð�
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
	SkillData1 180000 // ���ӽð�	
return

SetSkill RK_STONEHARDSKIN
OnInit:
	SkillMaxLv 1
	SkillType TOME
	SkillCastFixedDelay 2000
	SkillData1 180000 // ���ӽð�
return

SetSkill RK_VITALITYACTIVATION
OnInit:
	SkillMaxLv 1
	SkillType TOME	
	SkillData1 180000 // ���ӽð�
return

SetSkill RK_STORMBLAST
OnInit:
	SkillMaxLv 1
	SkillType TOME	
	SkillFlag SKFLAG_NODISPEL
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillCastStatDelay 2000
	SkillGlobalPostDelay 1000
	SkillData1 7 // �˹�Ÿ�
return

SetSkill RK_FIGHTINGSPIRIT
OnInit:
	SkillMaxLv 1
	SkillType TOME	
	SkillData1 180000 // ���ӽð�
return

SetSkill RK_ABUNDANCE
OnInit:
	SkillMaxLv 1
	SkillType TOME	
	SkillData1 180000 // ���ӽð�
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


//���ƾ ũ�ν�
SetSkill GC_VENOMIMPRESS //���� ��������(SKID_GC_VENOMIMPRESS)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillRange                10	  10	  10	  10	  10 // ��ų�����Ÿ�
	SkillSP				      12	  16	  20	  24	  28 // SP�Ҹ�
	SkillGlobalPostDelay	3000	2500	2000	1500	1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				  10	  20	  30	  40	  50 // ���Ӽ� ���� ����%
	SkillData2			   10000   20000   30000   40000   50000 // ȿ�����ӽð�
return

SetSkill GC_CROSSIMPACT //ũ�ν� ����Ʈ(SKID_GC_CROSSIMPACT)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER	
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��
	SkillRange                 3	   3	   3	   3	   3 // ��ų�����Ÿ�
	SkillSP					  25	  25	  25	  25	  25 // SP�Ҹ�
	SkillGlobalPostDelay	2500	2000	1500	1000	 500 // ��ų����� ��ü��ų�������ð�	
return

SetSkill GC_DARKILLUSION //��ũ �Ϸ���(SKID_GC_DARKILLUSION)
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillRange				   5	   6	   7	   8	   9 // ��ų�����Ÿ�
	SkillSP					  20	  25	  30	  35	  40 // SP�Ҹ�
	SkillGlobalPostDelay	1500	1500	1500	1500	1500 // ��ų����� ��ü��ų�������ð�		
	SkillData1				   4	   8	  12	  16	  20 // ũ�ν�����Ʈ �ߵ� Ȯ��
return


SetSkill GC_RESEARCHNEWPOISON //���ο� �� ����(SKID_GC_RESEARCHNEWPOISON)
OnInit:
	SkillMaxLv		10
	SkillType		PASSIVE	
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
return

SetSkill GC_CREATENEWPOISON //���ο� �� ����(SKID_GC_CREATENEWPOISON)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP		10
	SkillGlobalPostDelay 500
return


SetSkill GC_ANTIDOTE //��Ƽ ��Ʈ(SKID_GC_ANTIDOTE)
OnInit:
	SkillMaxLv	1
	SkillType	TOALL
	SkillSP		10
	SkillRange  5 // ��ų�����Ÿ�
return

SetSkill GC_POISONINGWEAPON //������� ����(SKID_GC_POISONINGWEAPON)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP					    20      24      28      32      36 // SP�Ҹ�
	SkillGlobalPostDelay	  1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				     4	     6	     8	    10	    12 // �ߵ�Ȯ��
	SkillData2				 60000	120000	180000	240000	300000 // ���ӽð�
return


SetSkill GC_WEAPONBLOCKING //���� ���ŷ(SKID_GC_WEAPONBLOCKING)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						40	    36	    32	    28	    24 // SP�Ҹ�
	SkillGlobalPostDelay	  2000	  2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1					12      14      16      18      20 // ���Ȯ��
	SkillData2				180000	180000	180000	180000	180000 // ���ӽð�
return

SetSkill GC_COUNTERSLASH //ī���� ������(SKID_GC_COUNTERSLASH)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��
	SkillSP					   5	   8	  11	  14	  17 // SP�Ҹ�
	SkillAtkPer				 400	 500	 600	 700	 800 // ���ݵ�����������(%)
	SkillGlobalPostDelay	2000	2000	2000	2000	2000 // ��ų����� ��ü��ų�������ð�
return

SetSkill GC_WEAPONCRUSH //���� ũ����(SKID_GC_WEAPONCRUSH)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��
	SkillSP					  20	  20	  20	  20	  20 // SP�Ҹ�
	SkillGlobalPostDelay	1000	1000	1000	1000	1000 // ��ų����� ��ü��ų�������ð�
return

SetSkill GC_VENOMPRESSURE //���� ������(SKID_GC_VENOMPRESSURE)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					   30	   40      50	   60	   70 // SP�Ҹ�
	SkillAtkPer				  1000	  1000	  1000	  1000	 1000 // ���ݵ�����������(%)	
	SkillCastFixedDelay         0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		    0	    0	    0	    0	    0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0	    0	    0	    0	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				   75	   80	   85	   90	   95 // �ߵ�Ȯ��	
	SkillData2				  114     118     122     126     130 // ���߷� ���� �⺻ 100 + ������ ����ġ
return

SetSkill GC_POISONSMOKE //������ ����ũ(SKID_GC_POISONSMOKE)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange                  5	    5	    5	    5       5 // ��ų�����Ÿ�
	SkillSP			   40	   40	   40	   40	   40 // SP�Ҹ�
	SkillCastFixedDelay      2000	 2000	 2000	 2000	 2000 // ��ų ĳ���� ���� delay��
	SkillGlobalPostDelay	 2000	 2000	 2000	 2000	 2000 // ��ų����� ��ü��ų�������ð�
	SkillData1		10000	12000	14000	16000	18000 // ���ӽð�
return

SetSkill GC_CLOAKINGEXCEED //Ŭ��ŷ �ͽõ�(SKID_GC_CLOAKINGEXCEED)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP					  45	  45	  45	  45	  45 // SP�Ҹ�
	SkillGlobalPostDelay	2000	2000	2000	2000	2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				   9       8       7       6       5 // �ʴ� �߰� �Ҹ� SP
	SkillData2				   1	   1	   2	   2	   3 // ��� Ƚ��
	SkillData3				   0	  10	  20	  30	  40 // �̵��ӵ�����(%)
return

SetSkill GC_PHANTOMMENACE //���� �޳���(SKID_GC_PHANTOMMENACE)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillAtkPer			  300 // ���ݵ�����������(%)
	SkillSP				   30 // SP�Ҹ�
	SkillGlobalPostDelay 1000 // ��ų����� ��ü��ų�������ð�
	
return

SetSkill GC_HALLUCINATIONWALK //�ҷ�ó��̼� ��ũ(SKID_GC_HALLUCINATIONWALK)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP					   100	   100	   100	   100	   100 // SP�Ҹ�
	SkillSinglePostDelay	300000	300000	300000	300000	300000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�	
	SkillData1					50	   100	   150	   200	   250 // ȸ���� ��°� 
	SkillData2					10		20		30		40		50 // ��������Ȯ��
	SkillData3				 30000	 35000	 40000	 45000	 50000 // ���ӽð�	
	SkillData4				    16	    14	    12		10	     8 // HP�Ҹ�(%)
return

SetSkill GC_ROLLINGCUTTER //�Ѹ� Ŀ��(SKID_GC_ROLLINGCUTTER)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					  5		  5	      5	      5		  5 // SP�Ҹ�
	SkillAtkPer             120		140		160		180		200 // ���ݵ�����������(%)
	SkillGlobalPostDelay	200		200		200		200		200 // ��ų����� ��ü��ų�������ð�
	SkillData1				  1	      1	      1	      1	      2 // ������ ����ݰ�
return

SetSkill GC_CROSSRIPPERSLASHER //ũ�ν� ���� ������(SKID_GC_CROSSRIPPERSLASHER)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					  20	  24	  28	  32	  36 // SP�Ҹ�
	SkillRange				   9	  10	  11	  12	  13 // ��ų�����Ÿ�
	SkillAtkPer				 200	 240	 280	 320	 360 // ���ݵ�����������(%)
	SkillGlobalPostDelay	1000	1000	1000	1000	1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				 100	 200	 300	 400	 500 // ȸ��ī��Ʈ�� ���� �߰����ݷ� 2ȸ/4ȸ/6ȸ/8ȸ/10ȸ�϶�
return


SetSkill AB_JUDEX //�굦�� - ��ũ���
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange				  11	  11	  11	  11	  11 //�����Ÿ�
	SkillSP					  20	  23	  26	  29	  32 //SP�Ҹ�
	SkillAtkPer				 300	 320	 340	 360	 400
	SkillCastFixedDelay		 500	 500	 500	 500	 500 //��ų ĳ���� ���� delay��
	SkillCastStatDelay		2000	2000	2000	2000	2000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	   0	   0	   0	   0	   0 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	 500	 500	 500	 500	 500 //��ų����� ��ü��ų�������ð� 
return


SetSkill AB_ANCILLA //�ȽǶ� - ��ũ���
OnInit:
	SkillMaxLv 1
	SkillProperty PROPERTY_Nothing //�Ӽ��� ����.
	SkillType TOME	
	SkillPattern SKILLPATT_NONE //���ݽ�ų �ƴ�
	SkillSP             30 // �̰��� Ŭ���̾�Ʈ���� %�� ȭ�鿡 ��µǰ� �ȴ�.0�̸� ������ �ʵȴ�. �����϶�.
	SkillCastFixedDelay 0 //��ų ĳ���� ���� delay��
	SkillCastStatDelay 1000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 0 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay 1000 //��ų����� ��ü��ų�������ð� 
return


SetSkill AB_ADORAMUS //�Ƶ��󹫽� - ��ũ���
OnInit:
	SkillMaxLv		10
	SkillProperty	PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange              11	   11	   11	   11	    11	    11	    11	    11	    11	    11
	SkillSP                 20	   24	   28	   32	    36	    40	    44	    48	    52	    56
	SkillCastFixedDelay      0	    0	    0	    0	     0	     0	     0	     0	     0	     0 //��ų ĳ���� ���� delay��
	SkillCastStatDelay	  2000	 2000	 2000	 2000	  2000	  2000	  2000	  2000	  2000	  2000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay  2000	 2000	 2000	 2000	  2000	  2000	  2000	  2000	  2000	  2000 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay   500	  500	  500	  500	   500	   500	   500	   500	   500	   500 //��ų����� ��ü��ų�������ð� 
	SkillData1			  6000	 7000	 8000	 9000	 10000	 11000	 12000	 13000	 14000	 15000 //���� ���ӽð�
	SkillData2			 15000	20000	25000	30000	 35000   40000	 45000	 50000	 55000	 60000 //��ø������ ���ӽð�
	SkillData3				 3      4       5       6        7	     8	     9	    10	    11	    12 //AGI���ҷ�

return


SetSkill AB_CLEMENTIA //ũ����Ƽ�� - ��ũ���
OnInit:
	SkillMaxLv 3
	SkillProperty PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType TOME
	SkillPattern SKILLPATT_NONE //���ݽ�ų �ƴ�
	SkillSP					   280	   320	   360
	SkillAtkPer				   100	   100	   100
	SkillCastFixedDelay		  1000	  1000	  1000 //��ų ĳ���� ���� delay��
	SkillCastStatDelay		  3000	  3000	  3000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0       0       0 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay		 0	     0	     0 //��ų����� ��ü��ų�������ð� 
	SkillData1					 3	     7		15 //ȿ������(�ݰ�)
	SkillData2				120000	180000	240000 //���ӽð�
return


SetSkill AB_CANTO //ĭ��ĵ��ν� - ��ũ���
OnInit:
	SkillMaxLv 3
	SkillProperty PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType TOME 
	SkillPattern SKILLPATT_NONE //���ݽ�ų�ƴ�
	SkillSP					   200	   220	   240
	SkillAtkPer				   100	   100	   100
	SkillCastFixedDelay		  1000	  1000	  1000 //��ų ĳ���� ���� delay��
	SkillCastStatDelay		  3000	  3000	  3000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0       0       0 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay		 0	     0	     0 //��ų����� ��ü��ų�������ð� 
	SkillData1					 3	     7	    15 //ȿ������(�ݰ�)
	SkillData2				120000	180000	240000 //���ӽð�
return


SetSkill AB_CHEAL //�ݷ缼����-��ũ���
OnInit:
	SkillMaxLv 3
	SkillProperty PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType	 TOME
	SkillPattern SKILLPATT_NONE //���ݽ�ų�ƴ�
	SkillSP               200	 220	 240
	SkillAtkPer           100	 100	 100
	SkillCastFixedDelay  1000	 500	   0 //��ų ĳ���� ���� delay��
	SkillCastStatDelay	 3000	3000	3000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 2000   2000    2000 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay    0	   0	   0 //��ų����� ��ü��ų�������ð� 
	SkillData1			    3	   7	  15 //ȿ������(�ݰ�)
return


SetSkill AB_EPICLESIS //����Ŭ���ý�-��ũ���
OnInit:
	SkillMaxLv 5
	SkillProperty PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType TOGROUND
	SkillPattern SKILLPATT_NONE //���ݽ�ų�ƴ�
	SkillRange              11	   11	   11	   11	   11 
	SkillSP                300	  300	  300	  300	  300
	SkillAtkPer            100	  100	  100	  100	  100
	SkillCastFixedDelay   2000	 2000	 2000	 2000	 2000 //��ų ĳ���� ���� delay��
	SkillCastStatDelay	  2000	 2500	 3000	 3500	 4000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 60000	60000	60000	60000	60000 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay  2000	 2000	 2000	 2000	 2000 //��ų����� ��ü��ų�������ð� 
	SkillData1			 18000  21000	24000	27000	30000 //�����ֱ�
	SkillData2			     3      3	    4	    4       5 //3�ʴ�HPȸ����(%)
	SkillData3				 2      2       3       3       4 //3�ʴ�SPȸ����(%)
	SkillData4				 5     10      15      20      25 //MHP������(%)
return


SetSkill AB_PRAEFATIO //������Ƽ��-��ũ���
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType TOME //�ڱ��ڽſ��� ����Ѵ�.
	SkillPattern SKILLPATT_NONE //���ݽ�ų�ƴ�
	SkillRange               11	    11	    11	    11	    11	    11	    11	    11	    11	    11
	SkillSP                  90	   100	   110	   120	   130	   140	   150	   160	   170	   180	
	SkillCastFixedDelay    1000	  1000	  1000    1000	  1000	  1000	  1000	  1000	  1000	  1000 //��ų ĳ���� ���� delay��
	SkillCastStatDelay	   2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay  13000	 16000	 19000	 22000	 25000	 28000	 31000	 34000	 37000	 40000 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      0	     0	     0	     0	     0	     0	     0	     0	     0	     0 //��ų����� ��ü��ų�������ð� 
	SkillData1				  7	     8	     9	    10	    11	    12      13      14      15      16 //���Ƚ��
	SkillData2			     18	    20	    22      24      26      28      30      32      34      36 //MHP������(%)
	SkillData3			 120000	120000	120000	120000	120000	120000	120000	120000	120000	120000 //�����ֱ�
return


SetSkill AB_ORATIO //����Ƽ��--��ũ���
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType TOME               //�ڽſ��� ���
	SkillPattern SKILLPATT_NONE //���ݽ�ų�ƴ�
	SkillRange               11	    11	    11	    11	    11	    11	    11	    11	    11	    11
	SkillSP                  35	    38	    41	    44	    47	    50	    53	    56	    59	    62	
	SkillCastFixedDelay    1000	  1000	  1000    1000	  1000	  1000	  1000	  1000	  1000	  1000 //��ų ĳ���� ���� delay��
	SkillCastStatDelay	   4000	  4000	  4000	  4000	  4000	  4000	  4000	  4000	  4000	  4000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay   2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000	  2000 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      0	     0	     0	     0	     0	     0	     0	     0	     0	     0 //��ų����� ��ü��ų�������ð� 
	SkillData1				 45	    50	    55	    60	    65	    70      75      80      85      90 //����Ȯ��(%)
	SkillData2			      2	     4	     6       8      10      12      14      16      18      20 //�������ҷ�
	SkillData3			  30000	 30000	 30000	 30000	 30000	 30000	 30000	 30000	 30000	 30000 //�����ֱ�
return

SetSkill AB_LAUDAAGNUS //���پƱ״���-��ũ���
OnInit:
	SkillMaxLv 4
	SkillProperty PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType TOME               //�ڽſ��� ���
	SkillPattern SKILLPATT_NONE //���ݽ�ų�ƴ�
	SkillRange               11	    11	    11		11
	SkillSP                  50	    60	    70	    80
	SkillCastFixedDelay       0	     0	     0       0 //��ų ĳ���� ���� delay��
	SkillCastStatDelay	   1000	  1000	  1000	  1000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay   3000	  3000	  3000	  3000 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      0	     0	     0	     0 //��ų����� ��ü��ų�������ð� 
	SkillData1				 50	    60	    70	    80 //����,��ȭ,���� ���� Ȯ��(%)
	SkillData2			      5	     6	     7       8 //VIT ���ʽ� 
	SkillData3			  60000	 60000	 60000	 60000 //VIT ���ʽ� ���ӽð�
return


SetSkill AB_LAUDARAMUS //���ٶ󹫽�-��ũ���
OnInit:
	SkillMaxLv 4
	SkillProperty PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType TOME               //�ڽſ��� ���
	SkillPattern SKILLPATT_NONE //���ݽ�ų�ƴ�
	SkillRange               11	    11	    11		11
	SkillSP                  50	    60	    70	    80
	SkillCastFixedDelay       0	     0	     0       0 //��ų ĳ���� ���� delay��
	SkillCastStatDelay	   1000	  1000	  1000	  1000 //��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay   3000	  3000	  3000	  3000 //��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      0	     0	     0	     0 //��ų����� ��ü��ų�������ð� 
	SkillData1				 50	    60	    70	    80 //ħ��,����,���� ���� Ȯ��(%)
	SkillData2			      5	     6	     7       8 //LUK ���ʽ� 
	SkillData3			  60000	 60000	 60000	 60000 //LUK ���ʽ� ���ӽð�
return

SetSkill AB_EUCHARISTICA //����ī����Ƽī-��ũ���
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Nothing  //�Ӽ�����
	SkillType PASSIVE               //�нú꽺ų
	SkillPattern SKILLPATT_NONE     //���ݽ�ų�ƴ�	
	SkillData1				1,	2,	3,	4,	5,	6,	7,	8,	9,	10 //�������ݷ� ������(%)
	SkillData2				1,	2,	3,	4,	5,	6,	7,	8,	9,	10 //�������ݷ� ������(%)
	SkillData3				1,	2,	3,	4,	5,	6,	7,	8,	9,	10 //�𵥵�,�� �Ӽ������� ���׷� ����(%)
return


SetSkill AB_RENOVATIO //�����Ƽ��-��ũ���
OnInit:
	SkillMaxLv 1
	SkillProperty PROPERTY_Saint  //���Ӽ�
	SkillType TOALL  //�ڽ��� ������ ��� �ɸ������� 
	SkillPattern SKILLPATT_NONE   //���ݽ�ų�ƴ�
	SkillRange               11
	SkillSP                  70
	SkillCastFixedDelay    2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	   3000	// ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay   1000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      0	// ��ų����� ��ü��ų�������ð�		
	SkillData1				  3 // 5�ʴ� HP ȸ����(%)
	SkillData2			  90000	// ���ӽð� 
return


SetSkill AB_HIGHNESSHEAL //���̳׽���-��ũ���
OnInit:
	SkillMaxLv 5
	SkillProperty PROPERTY_Saint  //���Ӽ�
	SkillType TOALL        //�ڽ��������� ��� �ɸ������� 
	SkillPattern SKILLPATT_ATTACKSPELL //�崺������ Ÿ�ٿ��Ե� �������� �ֱ� ���� ������������ ������.2009.12.10
	SkillRange                11	   11	   11	   11	   11
	SkillSP                   70	  100	  130	  160	  190 // SP�Ҹ�
	SkillCastFixedDelay        0        0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		1000	 1000	 1000	 1000	 1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay    3000	 3000	 3000	 3000	 3000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	1000	 1000	 1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�		
	SkillData1				 200	  230	  260	  290	  320 // ȸ���� ������(%)
return

SetSkill AB_CLEARANCE //Ŭ�����-��ũ���
OnInit:
	SkillMaxLv 5
	SkillProperty	PROPERTY_Nothing     // �Ӽ�����
	SkillType		TOALL  //�ڽ��� ������ ��� �ɸ������� 
	SkillPattern	SKILLPATT_ATTACKSPELL // ���� ���� ��ųŸ��
	SkillRange                11	   11	   11	   11	   11
	SkillSP                   54	   60	   66	   72	   78
	SkillCastFixedDelay        0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		4000	 4000	 4000	 4000	 4000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay   10000	10000	10000	10000	10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	   0		0	    0	    0	    0 // ��ų����� ��ü��ų�������ð�		
	SkillData1				  68	   76	   84	   92	  100 // ����Ȯ��
return


SetSkill AB_EXPIATIO //�����Ǿ�Ƽ��-��ũ���
OnInit:
	SkillMaxLv 5
	SkillProperty PROPERTY_Nothing     // �Ӽ�����
	SkillType		TOALL  //�ڽ��� ������ ��� �ɸ������� 
	SkillPattern SKILLPATT_NONE		   // ���ݽ�Ÿ�� �ƴ�
	SkillRange                11	   11	   11	   11	   11
	SkillSP                   35	   40	   45	   50	   55
	SkillCastFixedDelay     1000	 1000	 1000	 1000	 1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		1000	 1000	 1000	 1000	 1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay       0	    0	    0	    0	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	   0		0	    0	    0	    0 // ��ų����� ��ü��ų�������ð�		
	SkillData1			  150000   180000  210000  240000  270000 // ���ӽð�
	SkillData2				   5       10      15      20      25 // ���÷�(%)
return


SetSkill AB_DUPLELIGHT //���÷�����Ʈ-��ũ���
OnInit:
	SkillMaxLv    10
	SkillProperty PROPERTY_Saint       // ���Ӽ�
	SkillType     TOME                 // �ڽſ��� ���
	SkillPattern  SKILLPATT_NONE       // ���ݽ�Ÿ�� �ƴ�
	SkillRange                11	   11	   11	   11	   11      11	   11	   11	   11	   11
	SkillSP                   55	   60	   65	   70	   75      80      85      90      95     100
	SkillCastFixedDelay     2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000	 2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay       0	    0	    0	    0	    0       0	    0	    0	    0	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�		
	SkillData1			   90000   120000  150000  180000  210000  240000  270000  300000  330000  360000 // ���ӽð�	
return

SetSkill AB_DUPLELIGHT_MELEE //���÷�����Ʈ-������������-��ũ���
OnInit:
	SkillMaxLv		10
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK //��������
	SkillRange                11	 11	    11	   11	  11     11	    11	   11	  11	 11
	SkillSP                    0	  0		 0		0	   0	  0		 0		0	   0	  0
	SkillAtkPer				 110	120	   130	  140	 150	160    170	  180	 190    200
	SkillCastFixedDelay        0	  0		 0		0	   0      0      0      0      0      0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	       0	  0		 0	    0	   0	  0	     0	    0	   0	  0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay       0	  0	     0	    0	   0	  0	     0	    0	   0	  0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       0	  0		 0	    0	   0	  0	     0	    0	   0	  0 // ��ų����� ��ü��ų�������ð� 
	SkillData1				 120	140	   160	  180    200    220	   240    260	 280	300 // �ߵ�Ȯ�� 1000�з�(%)
return

SetSkill AB_DUPLELIGHT_MAGIC //���÷�����Ʈ-��������-��ũ���
OnInit:
	SkillMaxLv		10
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                11	 11	    11	   11	  11     11	    11	   11	  11	 11
	SkillSP                    0	  0		 0		0	   0	  0		 0		0	   0	  0
	SkillAtkPer				 220	240	   260	  280	 300	320    340    360    380    400
	SkillCastFixedDelay        0	  0		 0		0	   0      0      0      0      0      0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	       0	  0		 0	    0	   0	  0	     0	    0	   0	  0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay       0	  0	     0	    0	   0	  0	     0	    0	   0	  0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       0	  0		 0	    0	   0	  0	     0	    0	   0	  0 // ��ų����� ��ü��ų�������ð� 
	SkillData1				 120	140	   160	  180    200    220	   240    260	 280	300 // �ߵ�Ȯ�� 1000�з�(%)
return

SetSkill AB_SILENTIUM //�÷�ġ��-��ũ���
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Saint //���Ӽ��� �ο��Ѵ�.
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                 4	    5	    6	    7       8 // �ݰ�
	SkillSP                   64	   68	   72	   76	   80 // SP�Ҹ�
	SkillCastFixedDelay        0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	    4000	 4000	 4000	 4000	 4000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay   15000	15000	15000	15000	15000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       0	    0		0	    0	    0 // ��ų����� ��ü��ų�������ð� 
	SkillData1			   20000	30000	40000	50000	60000 // ���ӽð�
return

SetSkill AB_SECRAMENT //��ũ���Ʈ
OnInit:
	SkillMaxLv 5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOALL  //�ڽ��� ������ ��� �ɸ������� 
	SkillPattern	SKILLPATT_NONE   //���ݽ�ų�ƴ�
	SkillRange                  11	    11	    11	    11	    11 // ��ų�����Ÿ�
	SkillSP                    100	   120	   140	   160	   180 // �Ҹ� SP
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	      1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay         0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�		
	SkillData1				 60000	 90000	120000	150000	180000 // ȿ�����ӽð�
	SkillData2			        10	    20	    30	    40	    50 // ����ĳ���ýð� ����%
return

SetSkill WL_WHITEIMPRISON //ȭ��Ʈ��������-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOALL //�ڱ��ڽ�����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                 11	   11	   11	   11	   11
	SkillSP                    50	   55	   60	   65	   70
	SkillCastFixedDelay         0	    0		0		0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0	    0	    0	    0	    0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 4000	 4000	 4000	 4000	 4000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0	    0		0	    0	    0 // ��ų����� ��ü��ų�������ð� 
	SkillData2				10000	12000	14000	16000	18000 // Ÿ���� player�ϰ�� ���� ���ӽð�
return

SetSkill WL_SOULEXPANSION //�ҿ��ͽ����-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Telekinesis //���Ӽ�
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                11	  11	  11	  11	  11 // ��ų�����Ÿ�
	SkillSP                   30	  35	  40      45      50
	SkillAtkPer				 500	 600	 700	 800	 900
	SkillCastFixedDelay        0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		2000	2000	2000	2000	2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay       0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     500	 500	 500	 500	 500 // ��ų����� ��ü��ų�������ð� 
	SkillData1				   1	   1	   1       2       2 // ȿ������(����)
return

SetSkill WL_FROSTMISTY //���ν�Ʈ�̽�Ƽ-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Water //���Ӽ�
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                 11	   11	   11	   11	   11 // ��ų�����Ÿ�
	SkillSP                    40	   48	   56      64      72
	SkillAtkPer				  300	  400	  500	  600	  700
	SkillCastFixedDelay       500	  500	  500	  500	  500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		 2000	 2500	 3000	 3500	 4000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 8000	 8000	 8000	 8000	 8000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // ��ų����� ��ü��ų�������ð� 
	SkillData1				    9	    9	    9       9       9 // ȿ������(�ݰ�)
	SkillData3				    3	    4	    5       6       7 // ��ŸȽ��
return


SetSkill WL_JACKFROST //�����ν�Ʈ-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Water //���Ӽ�
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                 11	   11	   11	   11	   11 // ��ų�����Ÿ�
	SkillSP                    50	   60	   70      80      90
	SkillAtkPer				 1300	 1600    1900	 2200    2500
	SkillCastFixedDelay      1000	 1000	 1000	 1000	 1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		 2000	 2500	 3000	 3500	 4000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0	    0	    0	    0	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // ��ų����� ��ü��ų�������ð� 
	SkillData1				    5	    6	    7       8       9 // ȿ������(�ݰ�)
	SkillData2				10000	15000	20000	25000	30000 // ���������ð�
return


SetSkill WL_MARSHOFABYSS //����������-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_NONE   // ������ �ƴ� ��ųŸ��
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                11	  11	  11	  11	  11 // ��ų�����Ÿ�
	SkillSP                   40	  42	  44      46      48
	SkillCastFixedDelay      500	 500	 500	 500	 500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay    2500	3000	3500	4000	4500 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay    1000	1000	1000	1000	1000 // ��ų����� ��ü��ų�������ð� 
	SkillData1				  50	  60	  70      80      90 // �̵��ӵ� ����(%)	
	SkillData2				   3	   6	   9	  12	  15 // �÷��̾� Agi / Dex ���� ����
	SkillData3				   6	  12	  18	  24	  30 // ���� Agi / Dex ���� ����
return

SetSkill WL_RECOGNIZEDSPELL //���ڱ׳�����彺��-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE   // ������ �ƴ� ��ųŸ��
	SkillRange                  11	    11	    11	    11	    11 // ��ų�����Ÿ�
	SkillSP                    100	   120	   140     160     180	
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 50000	 80000	110000	140000	170000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 60000	 90000	120000	150000	180000 // ���ӽð�
return



SetSkill WL_SIENNAEXECRATE //�ÿ�������ũ����Ʈ-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_NONE   // ������ �ƴ� ��ųŸ��
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                 7	   7	   7	   7	   7 // ��ų�����Ÿ�
	SkillSP                   32	  34	  36      38      40
	SkillCastFixedDelay        0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		2000	2000	2000	2000	2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay       0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay    2000	2000	2000	2000	2000 // ��ų����� ��ü��ų�������ð� 
	SkillData1				   1	   2	   2       3       3 // ȿ������
	SkillData3			   10000   12000   14000   16000   18000 // ��ȭ���ӽð�
return

SetSkill WL_RADIUS //���-����
OnInit:
	SkillMaxLv 3
	SkillProperty PROPERTY_Nothing    // �Ӽ�����
	SkillType PASSIVE                 // �нú꽺ų
	SkillPattern SKILLPATT_NONE       // ���ݽ�ų�ƴ�	
	SkillData1				1	2	3 // ��ų �����Ÿ� ������
	SkillData2			   10  15  20 // ����ĳ���üӵ� ���ҷ�(%)
return

SetSkill WL_STASIS //�����̽ý�-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE   // ������ �ƴ� ��ųŸ��
	SkillRange                  11	    11	    11	    11	    11 // ��ų�����Ÿ�
	SkillSP                     50	    60	    70      80      90	
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  3000	  3000	  3000	  3000	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	180000	190000	200000	210000	220000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 10000   20000   30000   40000   50000 // ������ �߰����ӽð� 
	SkillData2				     9	    10	    11	    12	    13 // ȿ���ݰ�
return

SetSkill WL_DRAINLIFE //�巹�ζ�����-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillAtkPer				 600	 700	 800	 900	1000 // ���ݵ�����������(%)
	SkillRange                11	  11	  11	  11	  11 // ��ų�����Ÿ�
	SkillSP                   20	  24	  28      32      36
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		4000	4000	4000	4000	4000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay    2000	2000	2000	2000	2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       0	   0	   0	   0	   0 // ��ų����� ��ü��ų�������ð� 
return

SetSkill WL_CRIMSONROCK //ũ�����-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Fire //ȭ�Ӽ�	
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��					
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillAtkPer				1600	1900	2200	2500	2800 // ���ݵ�����������(%)
	SkillRange                11	  11	  11	  11	  11 // ��ų�����Ÿ�
	SkillSP                   60	  70	  80      90     100
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		5000	5000	5000	5000	5000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay    5000    5000    5000    5000    5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay    2000	2000	2000	2000	2000 // ��ų����� ��ü��ų�������ð� 	
return

SetSkill WL_HELLINFERNO //�����丣��-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Fire //ȭ�Ӽ�	
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��					
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                11	  11	  11	  11	  11 // ��ų�����Ÿ�
	SkillSP                   35	  40	  45      50      55
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		3000	3000	3000	3000	3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay       0       0       0       0       0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay    1000	1000	1000	1000	1000 // ��ų����� ��ü��ų�������ð� 	
	SkillData1				 600	 650	 700     750     800 // ��ȭ(BODY_BURNNING) ����Ȯ��(õ�з�)
	SkillData2			   20000   30000   40000   50000   60000 // ��ȭ(BODY_BURNNING) ���ӽð�
return

SetSkill WL_COMET //Ŀ��Ʈ-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                  11	    11	    11	    11	    11 // ��ų�����Ÿ�
	SkillSP                    480	   560	   640     720     800
	SkillAtkPer				  3000	  3500	  4000	  4500	  5000 // ����1�� MATK ����������
	SkillCastFixedDelay       1000	  1500	  2000	  2500	  3000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		 10000	 11000	 12000	 13000	 14000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 60000   60000   60000   60000   60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð� 
	SkillData2				  2000    2400    2800    3200    3600 // ����2�� MATK ����������
	SkillData3				  1500    1800    2100    2400    2700 // ����3�� MATK ����������
	SkillData4				  1000    1200    1400    1600    1800 // ����4�� MATK ����������
return

SetSkill WL_CHAINLIGHTNING //ü�ζ���Ʈ��-����(������ų,���������� WL_CHAINLIGHTNING_ATK �� �Ѵ�.)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOCHARACTER
	SkillPattern    SKILLPATT_NONE //���ݽ�ų �ƴ�
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillAtkPer				   0	   0	   0	   0	   0 // ���ݵ�����������(%)
	SkillRange                11	  11	  11	  11	  11 // ��ų�����Ÿ�
	SkillSP                   80	  90	 100     110     120
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		3500	4000	4500	5000	5500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay       0       0       0       0       0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay    3000	3000	3000	3000	3000 // ��ų����� ��ü��ų�������ð� 	
	SkillData1				   5	   6	   7       8       9 // ����Ƚ��(�ٸ�Ÿ������)
return

SetSkill WL_CHAINLIGHTNING_ATK //ü�ζ���Ʈ�װ���-����(ü�ζ���Ʈ�׽�ų�� �������ݽ�ų�̴�.)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Wind //ǳ�Ӽ�
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��
	SkillAtkPer				 500	 600	 700	 800	 900 // ���ݵ�����������(%)
	SkillRange                11	  11	  11	  11	  11 // ��ų�����Ÿ�
	SkillSP                    0	   0	   0       0       0
	SkillCastFixedDelay        0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay       0       0       0       0       0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       0	   0	   0	   0	   0 // ��ų����� ��ü��ų�������ð�
return

SetSkill WL_EARTHSTRAIN //���Ʈ����-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Ground //���Ӽ�����
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                   6	     6	     6	     6	     6 // ��ų�����Ÿ�
	SkillSP                     70	    78      86      94     102
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  3000	  4000	  5000	  6000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				     5	     6	     7	     8	     9 // �̵��Ÿ�
	SkillData2				     6	    14	    24	    36	    50 // Ÿ�ݽ� ȿ��(��Ʈ������/��Ʈ���︧)����Ȯ��(%)
	SkillData3				     6	     7	     8	     9	    10 // ��ŸȽ��
return


SetSkill WL_TETRAVORTEX //��Ʈ���ؽ�-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                  11	    11	    11	    11	    11 // ��ų�����Ÿ�
	SkillSP                    120     150     180     210     240 // SP�Ҹ�
	SkillAtkPer				  1000	  1500	  2000	  2500	  3000 // ���ݵ�����������(%)
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  5000	  6000	  7000	  8000	  9000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 15000	 15000	 15000	 15000	 15000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
return

SetSkill WL_SUMMONFB //�������̾-����
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE// ������ �ƴ� ��ųŸ��
	SkillSP                     10	    12      14      16      18
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�	
	SkillData1				     1       1       1       1       1 // ��ȯ������ ���� ���ʴ� �Ҹ� sp�� 
	SkillData2				120000	160000  200000  240000  280000 // ��ȯ�� ���ӽð�
return


SetSkill WL_SUMMON_ATK_FIRE //����-ȭ�Ӽ�����-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Fire //ȭ�Ӽ�
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��
return

SetSkill WL_SUMMONBL //���󺼶���Ʈ��-����
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE// ������ �ƴ� ��ųŸ��
	SkillSP                     10	    12      14      16      18
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�	
	SkillData1				     1       1       1       1       1 // ��ȯ������ ���� ���ʴ� �Ҹ� sp�� 
	SkillData2				120000	160000  200000  240000  280000 // ��ȯ�� ���ӽð�
return

SetSkill WL_SUMMON_ATK_WIND //����-ǳ�Ӽ�����-����
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Wind //ǳ�Ӽ�
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��
return

SetSkill WL_SUMMONWB //������ͺ�-����
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE// ������ �ƴ� ��ųŸ��
	SkillSP                     10	    12      14      16      18
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�	
	SkillData1				     1       1       1       1       1 // ��ȯ������ ���� ���ʴ� �Ҹ� sp�� 
	SkillData2				120000	160000  200000  240000  280000 // ��ȯ�� ���ӽð�
return

SetSkill WL_SUMMON_ATK_WATER //����-���Ӽ�����-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Water //���Ӽ�
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��
return


SetSkill WL_SUMMONSTONE //������-����
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME
	SkillPattern	SKILLPATT_NONE// ������ �ƴ� ��ųŸ��
	SkillSP                     10	    12      14      16      18
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�	
	SkillData1				     1       1       1       1       1 // ��ȯ������ ���� ���ʴ� �Ҹ� sp�� 
	SkillData2				120000	160000  200000  240000  280000 // ��ȯ�� ���ӽð�
return

SetSkill WL_SUMMON_ATK_GROUND //����-���Ӽ�����-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Ground //���Ӽ�����
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��
return


SetSkill WL_RELEASE //������-����
OnInit:
	SkillMaxLv		2
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_ATTACKSPELL //���� ���� ��ųŸ��
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillSP         3	20
	SkillRange     11   11 // ��ų�����Ÿ�
return

SetSkill WL_READING_SB //���� �����(SKID_WL_READING_SB)-����
OnInit:
	SkillMaxLv		1
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillSP                    40 // SP�Ҹ�
	SkillCastFixedDelay      1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		 5000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      500 // ��ų����� ��ü��ų�������ð� 	
return

SetSkill WL_FREEZE_SP //����¡ ����(SKID_WL_FREEZE_SP)
OnInit:
	SkillMaxLv		5	
	SkillProperty	PROPERTY_Nothing    // �Ӽ�����
	SkillType		PASSIVE                 // �нú꽺ų
	SkillPattern	SKILLPATT_NONE       // ���ݽ�ų�ƴ�	
	SkillData2				   20	   16	   12       8       4 // 10�ʴ� �� ���帶���� �Ҹ�SP
return

//������
SetSkill RA_ARROWSTORM //�ַο콺��(SKID_RA_ARROWSTORM)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillFlag		SKFLAG_APPLY_PLUSRNG
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				   9	   9	   9	   9	   9	   9	   9	   9	   9	   9 // �ü��迭 �⺻ �Ÿ�	
	SkillAtkPer				 250	 300	 350	 400	 450	 500	 550	 600	 650	 700 // ���ݵ�����������(%)
	SkillSP					  30	  32	  34	  36	  38	  40	  42	  44	  46	  48 // SP�Ҹ�		
	SkillCastStatDelay		2000	2200	2400	2800	3000	3200	3400	3600	3800	4000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	5000	4800	4600	4400	4200	4000	3800	3600	3400	3200 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�	
	SkillData1				   3       3       3       3       3       4       4       4       4       5// ȿ������//
return

SetSkill RA_FEARBREEZE //�Ǿ�긮��(SKID_RA_FEARBREEZE)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP				    55	    60	    65	    70	    75 // SP�Ҹ�
	SkillCastFixedDelay	  2000	  2000	  2000	  2000	  2000 // ��ų ĳ���� ���� delay��	
	SkillData1			 60000	 90000	120000	150000	180000 //���ӽð�
	SkillData2				 2		 2	     3	     4	     5 // �ִ뿬Ÿ�� (�ּ� = 2)
	SkillData3				 12		 12		 21		 27	    30 // �ߵ� ��Ȯ�� 
	SkillData4				 0		 12		 9		 6		 3 // ��Ÿ���� �ߵ� Ȯ��, 1��Ÿ = 0%, 2��Ÿ = 12%, 3��Ÿ = 9%, 4��Ÿ = 6%, 5��Ÿ = 3%
return

SetSkill RA_RANGERMAIN
OnInit:
	SkillMaxLv 10
	SkillType PASSIVE
	SkillData1 5 10 15 20 25 30 35 40 45 50	// ������,�Ĺ���,������ ����
	SkillData2 5 10 15 20 25 30 35 40 45 50 // ������,�Ĺ���,������ ���ݷ�
return

SetSkill RA_AIMEDBOLT //���ӵ� ��Ʈ(SKID_RA_AIMEDBOLT)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillFlag		SKFLAG_APPLY_PLUSRNG
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				   9	   9	   9	   9	   9	   9	   9	   9	   9	   9 // �ü��迭 �⺻ �Ÿ�	
	SkillSP					  30	  32	  34	  36	  38	  40	  42	  44	  46	  48 // SP�Ҹ�
	SkillAtkPer				 550	 600	 650	 700	 750	 800	 850	 900	 950	1000 // ���ݵ�����������(%)
	SkillCastFixedDelay		 	 500	 500	 500	 500	 500	 500	 500	 500	 500	 500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay			4000	4000	4000	4000	4000	4000	4000	4000	4000	4000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	   0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	1000	1000	1000	1000	1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				50		50		60		40		70	    30		// �����ϰ�� 2��Ʈ 50 3��Ʈ 50  �����ϰ�� 3��Ʈ 60 4��Ʈ 40  �����ϰ�� 4��Ʈ 70 5��Ʈ 30 	
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
	SkillData1 20000 22000 24000 26000 28000 // ���ӽð�
	SkillData2 5 10 15 20 25 // �ʴ� �Ҹ�SP%
return

SetSkill RA_CLUSTERBOMB //Ŭ������ ��(SKID_RA_CLUSTERBOMB)
OnInit:
	SkillMaxLv	5
	SkillType	TOGROUND
	SkillFlag	SKFLAG_PLUS_TRAP_RANGE_RA_RESEARCHTRAP
	SkillRange		  3   3   3   3   3 // ��ų�����Ÿ�
	SkillSP			 20  20  20  20  20	// SP�Ҹ�
	SkillAtkPer		300	400	500	600	700 // ���ݵ�����������(%)
return

SetSkill RA_WUGMASTERY //���� �����͸�(SKID_RA_WUGMASTERY)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP					   5 // SP�Ҹ�
	SkillCastFixedDelay		   0 // ��ų ĳ���� ���� delay��
	SkillGlobalPostDelay	1000 // ��ų����� ��ü��ų�������ð�
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
	SkillData1 10000 10000 10000 10000 10000	//���ӽð�
	SkillData2    60     70   80   90   100	//������
return

SetSkill RA_TOOTHOFWUG
OnInit:
	SkillMaxLv 10
	SkillType PASSIVE
	SkillData1 30 60 90 120 150 180 210 240 270 300 // ������ ���ݽ�ų ������
return

SetSkill RA_SENSITIVEKEEN //������ �İ�(SKID_RA_SENSITIVEKEEN)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					  12	  12	  12	  12	  12 // SP�Ҹ�
	SkillAtkPer				 150	 200	 250	 300	 350 // ���ݵ�����������(%)
	SkillGlobalPostDelay	3000	3000	3000	3000	3000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				   8	  16	  24	  32	  30 // ���׹���Ʈ ����Ȯ��
	SkillData2				   3	   4	   5	   6	   7 // ������ ����(�ݰ�)
return

SetSkill RA_CAMOUFLAGE
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP			40	40	40	40	40
	SkillData1		 6   5   4   3   2 // ���ӽð� �ʴ� �Ҹ� sp
	SkillData2	   100 100  50  25   0 // �̵��ӵ����� %
return

SetSkill RA_RESEARCHTRAP //Ʈ�� ����(SKID_RA_RESEARCHTRAP)
OnInit:
	SkillMaxLv	5
	SkillType	PASSIVE
	SkillData1		 40	 80	120	160	200 // Ʈ���� �߰� ������
	SkillData2        1   2   3   4   5 // �߰�INT
	SkillData3		220 240 260 280 300 // �߰�MSP
return

SetSkill RA_MAGENTATRAP //����ŸƮ��(SKID_RA_MAGENTATRAP)
OnInit:
	SkillMaxLv		1
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Fire
	SkillRange				   3 // ��ų�����Ÿ�
	SkillSP					  10 // SP�Ҹ�
	SkillGlobalPostDelay	2000 // ��ų����� ��ü��ų�������ð�
return

SetSkill RA_COBALTTRAP //�ڹ�ƮƮ��(SKID_RA_COBALTTRAP)
OnInit:
	SkillMaxLv		1
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Water
	SkillRange				   3 // ��ų�����Ÿ�
	SkillSP					  10 // SP�Ҹ�
	SkillGlobalPostDelay	2000 // ��ų����� ��ü��ų�������ð�		
return

SetSkill RA_MAIZETRAP //������Ʈ��(SKID_RA_MAIZETRAP)
OnInit:
	SkillMaxLv		1
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Ground
	SkillRange					   3 // ��ų�����Ÿ�
	SkillSP						  10 // SP�Ҹ�
	SkillGlobalPostDelay		2000 // ��ų����� ��ü��ų�������ð�
return

SetSkill RA_VERDURETRAP //�����Ʈ��(SKID_RA_VERDURETRAP)
OnInit:
	SkillMaxLv		1
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Wind
	SkillRange					   3 // ��ų�����Ÿ�
	SkillSP						  10 // SP�Ҹ�
	SkillGlobalPostDelay		2000 // ��ų����� ��ü��ų�������ð�	
return

SetSkill RA_FIRINGTRAP //���̾Ʈ��(SKID_RA_FIRINGTRAP)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND	
	SkillProperty   PROPERTY_Fire
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag		SKFLAG_PLUS_TRAP_RANGE_RA_RESEARCHTRAP
	SkillRange		  3		  3		  3		  3		  3 // ��ų�����Ÿ�
	SkillSP			 10		 10		 10		 10		 10 // SP�Ҹ�	
	SkillData1		 60		 70		 80		 90		100 // ��ȭ Ȯ��
return

SetSkill RA_ICEBOUNDTRAP //���̽��ٿ��Ʈ��(SKID_RA_ICEBOUNDTRAP)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND	
	SkillProperty   PROPERTY_Water
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag		SKFLAG_PLUS_TRAP_RANGE_RA_RESEARCHTRAP
	SkillRange		  3		  3		  3		  3		  3 // ��ų�����Ÿ�
	SkillSP			 10		 10		 10		 10		 10 // SP�Ҹ�	
	SkillData1		 60		 70		 80		 90		100 // ���� Ȯ��
return

//���ɴ�
SetSkill NC_MADOLICENCE //������� ���̼���(SKID_NC_MADOLICENCE)
OnInit:
	SkillMaxLv	5
	SkillType	PASSIVE
	SkillData1	15	30	45	60	75	// ATK ����
	SkillData2	40	30	20	10	 0	// �̵��ӵ� ���� %
return

SetSkill NC_BOOSTKNUCKLE //�ν�Ʈ ��Ŭ(SKID_NC_BOOSTKNUCKLE)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag		SKFLAG_NODISPEL
	SkillRange				   11      11      11      11      11 // ��ų�����Ÿ�	
	SkillSP					    3	    6	    9	   12	   15 // SP�Ҹ�
	SkillAtkPer				  200	  250	  300	  350	  400 // ���ݵ�����������(%)
	SkillCastFixedDelay         		    0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	     		  200	  400	  600	  800	 1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay			    0	    0	    0	    0       0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        		    0	    0	    0	    0	    0 // ��ų����� ��ü��ų�������ð�
return

SetSkill NC_PILEBUNKER //���� ��Ŀ(SKID_NC_PILEBUNKER)
OnInit:
	SkillMaxLv		3
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				    3	    3	    3// ��ų�����Ÿ�
	SkillSP					   50	   50	   50 // SP�Ҹ�
	SkillAtkPer				  200     250     300 // ���ݵ�����������(%)
	SkillCastFixedDelay         		   0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        	   0	    0	    0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 	5000	 5000	 5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     		2000	 2000	 2000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				  40	   55	   70 // ���� ���� Ȯ��(%)
return


SetSkill NC_VULCANARM //��ĭ ��(SKID_NC_VULCANARM)
OnInit:
	SkillMaxLv		3
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				   13	   13	   13 // ��ų�����Ÿ�
	SkillSP						2       4       6 // SP�Ҹ�
	SkillAtkPer				  100	  125	  150 // ���ݵ�����������(%)
	SkillCastFixedDelay         0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0	    0	    0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0	    0	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      300	  200	  100 // ��ų����� ��ü��ų�������ð�
return


SetSkill NC_FLAMELAUNCHER //�÷��� ����(SKID_NC_FLAMELAUNCHER)
OnInit:
	SkillMaxLv		3
	SkillType		TOCHARACTER	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillProperty	PROPERTY_Fire
	SkillFlag		SKFLAG_NODISPEL
	SkillRange					  7	     7	     7 // ��ų�����Ÿ�
	SkillSP					  	 20     20      20 // SP�Ҹ�
	SkillAtkPer				  	100	   150	   200 // ���ݵ�����������(%)
	SkillCastFixedDelay       	500	   500	   500 // ��ų ĳ���� ���� delay��	
	SkillCastStatDelay	  		500	  1000	  1500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	      0	     0       0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       1500	  1000	   500 // ��ų����� ��ü��ų�������ð�	
	SkillData1				   	 30	    40	    50 // ��ȭ �߻� Ȯ��
	SkillData2			       7000  14000   21000 // ��ȭ ���� �ð�
	SkillData3			          2      3       4 // ȿ������
return

SetSkill NC_COLDSLOWER //�ݵ� ���ξ�(SKID_NC_COLDSLOWER)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillProperty	PROPERTY_Water
	SkillFlag		SKFLAG_NODISPEL
	SkillRange					7	   7	   7 // ��ų�����Ÿ�
	SkillAtkPer				  100	 150	 200 // ���ݵ�����������(%)
	SkillSP					   20     20	  20 // SP�Ҹ�
	SkillCastFixedDelay         0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	     1000	1000	1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0	   0       0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000	2000	3000 // ��ų����� ��ü��ų�������ð�		
	SkillData1					2	   3	   4 // ȿ������(�ݰ�)
	SkillData2				   10	  20	  30 // ���� �߻� Ȯ��
	SkillData3				   30	  40	  50 // ���� �߻� Ȯ��
return

SetSkill NC_ARMSCANNON //���� ĳ��(SKID_NC_ARMSCANNON)
OnInit:
	SkillMaxLv		3
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK	
	SkillFlag		SKFLAG_NODISPEL
	SkillRange					9	  11	  13 // ��ų�����Ÿ�
	SkillSP					   40     45      50 // SP�Ҹ�
	SkillCastFixedDelay	      600	 400	 200 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	     1400	1600	1800 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    	0	   0       0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay          500	1000	2000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					3	   2	   1 // ���÷��� ����
	SkillData2			      800   1000    1200 // ������ ���� ���ݵ�����������(%)
	SkillData3				  600    800    1000 // ������ ���� ���ݵ�����������(%)
	SkillData4				  400	 500	 800 // ������ ���� ���ݵ�����������(%)
return

SetSkill NC_ACCELERATION //�׼����̼�(SKID_NC_ACCELERATION)
OnInit:
	SkillMaxLv	3
	SkillType	TOME
	SkillSP					   20     40	  60 // SP�Ҹ�
	SkillCastFixedDelay			0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0	   0       0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0	   0	   0 // ��ų����� ��ü��ų�������ð�	
	SkillData1				60000  90000   120000 // ���ӽð�
return

SetSkill NC_HOVERING //ȣ����(SKID_NC_HOVERING)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP		   25 // SP�Ҹ�
	SkillData1	90000 // ���ӽð�
return

SetSkill NC_F_SIDESLIDE //����Ʈ ���̵� �����̵�(SKID_NC_F_SIDESLIDE)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP				        5 // SP�Ҹ�
	SkillCastFixedDelay			0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      500 // ��ų����� ��ü��ų�������ð�
return

SetSkill NC_B_SIDESLIDE //�� ���̵� �����̵�(SKID_NC_B_SIDESLIDE)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP					    5 // SP�Ҹ�
	SkillCastFixedDelay			0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      500 // ��ų����� ��ü��ų�������ð�	
return

SetSkill NC_MAINFRAME //���������� ����(SKID_NC_MAINFRAME)
OnInit:
	SkillMaxLv	4
	SkillType	PASSIVE
	SkillData1		40	60 	80	100 // DEF
	SkillData2		10	20	30	40 // ���������
	SkillData3		50	130	210	300 // ������Ʈ ����Ʈ
return

SetSkill NC_SELFDESTRUCTION //���� ��Ʈ����(SKID_NC_SELFDESTRUCTION)
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag		SKFLAG_NODISPEL
	SkillSP					     1	    1	   1 // ���� �Ҹ�Ǵ� SP�� �������� ó����.(���� �� 0���� �ָ� �ȵ�)
	SkillCastFixedDelay		   500	  500	 500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	      2000	 1500	1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	300000 300000 300000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay		 0	    0	   0 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 2	    3	   4 // ������ ����ݰ�
return

SetSkill NC_SHAPESHIFT //������ ����Ʈ(SKID_NC_SHAPESHIFT)
OnInit:
	SkillMaxLv		4
	SkillType		TOME
	SkillSP					  100	   100	   100	   100 // SP�Ҹ�
	SkillCastFixedDelay		 2000	  2000	  2000	  2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0	     0	     0	     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	 2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				 6360	  6363	  6362	  6361 // ��Į������Ʈ(6360), ���ӱ׸�����Ʈ(6363), ���ο���������Ʈ(6362), �ε������Ʈ(6361)
	SkillData2			   300000	300000	300000	300000 // ���ӽð�
	SkillData3				PROPERTY_Fire PROPERTY_Ground PROPERTY_Wind PROPERTY_Water // ������ ���� �Ӽ�
	
return

SetSkill NC_EMERGENCYCOOL //�̸����� ��(SKID_NC_EMERGENCYCOOL)
OnInit:
	SkillMaxLv	1
	SkillType	TOME
	SkillSP					   20 // SP�Ҹ�
	SkillCastFixedDelay			0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	  500 // ��ų����� ��ü��ų�������ð�
return


SetSkill NC_INFRAREDSCAN //�����󷹵� ��ĵ(SKID_NC_INFRAREDSCAN)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillSP					   45 // SP�Ҹ�
	SkillCastFixedDelay		    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  3000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	  500 // ��ų����� ��ü��ų�������ð�	
return

SetSkill NC_ANALYZE //�ֳζ�����(SKID_NC_ANALYZE)
OnInit:
	SkillMaxLv	3
	SkillType	TOCHARACTER
	SkillSP					   30	  30	  30 // SP�Ҹ�
	SkillRange					9	   9	   9 // ��ų�����Ÿ�
	SkillCastFixedDelay		 1000	1000	1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	 1000	1000	1000 // ��ų����� ��ü��ų�������ð�		
	SkillData1				   42	  54	  66 // ������(%)
	SkillData2				   14	  28	  42 // ����,���� ���� ������(%)
	SkillData3              20000  20000   20000 // ���ӽð�
return

SetSkill NC_MAGNETICFIELD //���׳�ƽ �ʵ�(SKID_NC_MAGNETICFIELD)
OnInit:
	SkillMaxLv	3
	SkillType	TOME
	SkillSP						60	    70	    80 // SP�Ҹ�
	SkillCastFixedDelay			 0		 0		 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	         0	     0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 20000   15000   10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	     0	     0	     0 // ��ų����� ��ü��ų�������ð�
	SkillData1					 2		 2		 2 // ����ݰ�
	SkillData2				  4000	  6000	  8000 // �̵��Ұ� �⺻ ���ӽð�
	SkillData3					50		50		50 // 1�ʴ� SP ���ҷ�
return

SetSkill NC_NEUTRALBARRIER //��Ʈ�� �踮��(SKID_NC_NEUTRALBARRIER)
OnInit:
	SkillMaxLv	3
	SkillType	TOME
	SkillSP						80		90	   100 // SP�Ҹ�
	SkillCastFixedDelay			 0		 0		 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	         0	     0	     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 20000	 15000	 10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	     0	     0	     0 // ��ų����� ��ü��ų�������ð�	
	SkillData1					15	    20      25 // ����,���� ���� ������
	SkillData2				 30000	 45000	 60000 // ���ӽð�
return

SetSkill NC_STEALTHFIELD //���ڽ� �ʵ�(SKID_NC_STEALTHFIELD)
OnInit:
	SkillMaxLv	3
	SkillType	TOME
	SkillSP					   80	  100	  120 	// SP�Ҹ�	
	SkillCastFixedDelay		    0	    0		0 	// ��ų ĳ���� ���� delay��
	SkillCastStatDelay		    0	    0		0 	// ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	20000	15000	10000 	// ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay		0		0		0 	// ��ų����� ��ü��ų�������ð�			
	SkillData1				15000   20000   25000 	// ���ӽð�
	SkillData2				 3000	 4000    5000 	// ���ʴ� 1% SP �Ҹ��Ű����
return

SetSkill NC_REPAIR //�����(SKID_NC_REPAIR)
OnInit:
	SkillMaxLv	5
	SkillType	TOALL
	SkillSP					  25	  30	  35	  40	  45 // SP�Ҹ�	
	SkillRange				   5	   6	   7	   8	   9 // ��ų�����Ÿ�
	SkillCastFixedDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		 200	 300	 400	 500	 600 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	   0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	1000	1000	1000	1000	1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				   4	   7	  13	  17	  23 // ����� MHP % ȸ����	
	SkillData2				12392	12392  12393   12393   12394 // �����Ŀ� ���� �ʿ������ �����A ~ �����C
return

SetSkill NC_TRAININGAXE //��������(SKID_NC_TRAININGAXE)
OnInit:
	SkillMaxLv	10
	SkillType	PASSIVE
	SkillData1		5	10	15	20	25	30	35	40	45	50 // ����, ��յ��� ���� ���ݷ� ����
	SkillData2		3	 6	 9	12	15	18	21	24	27	30 // ����, ��յ��� ���� ���߷� ����
	SkillData3		4	 8	12	16	20	24	28	32	36	40 // �б�, ��յб� ���� ���ݷ� ����
	SkillData4		2	 4	 6	 8	10	12	14	16	18	20 // �б�, ��յб� ���� ���߷� ����	
return


SetSkill NC_RESEARCHFE //�Ұ� ������ ����(SKID_NC_RESEARCHFE)
OnInit:
	SkillMaxLv  5
	SkillType	PASSIVE
	SkillData1	10	20	30	40	50 // ȭ,���Ӽ� ���Ϳ� ����
	SkillData2	10	20	30	40	50 // ȭ,���Ӽ� ���Ϳ� �߰����ݷ�
return


SetSkill NC_AXEBOOMERANG //�׽� �θ޶�(SKID_NC_AXEBOOMERANG)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange				   5	   6	   7	   8	   9 // ��ų�����Ÿ�
	SkillSP					  20      22      24      26      28 // SP�Ҹ�
	SkillAtkPer				 200	 240	 280	 320	 360 // ���ݵ�����������(%)
	SkillCastFixedDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	5000	4500	4000	3500	3000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillData1				   2	   3	   4	   5	   6 // �˹�Ÿ�
return

SetSkill NC_POWERSWING //�Ŀ� ����(SKID_NC_POWERSWING)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP		   	  20	  22	  24	  26	  28 // SP�Ҹ�
	SkillAtkPer	    	 400	 500	 600	 700	 800 // ���ݵ�����������(%)
	SkillCastFixedDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	   0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	1000	1000	1000	1000	1000 // ��ų����� ��ü��ų�������ð�	
return

SetSkill NC_AXETORNADO //�׽� ����̵�(SKID_NC_AXETORNADO)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					  18	  20	  22	  24	  26 // SP�Ҹ�
	SkillAtkPer			     250	 300	 350	 400	 450 // ���ݵ�����������(%)
	SkillCastFixedDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	4000	3500	3000	2500	2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	 500	 500	 500	 500	 500 // ��ų����� ��ü��ų�������ð�	
	SkillData1				  20	  40	  60	  80	 100 // HP �Ҹ�
	SkillData2				   2       2	   3	   3	   3 // ����ݰ�
return


SetSkill NC_SILVERSNIPER //�ǹ� ��������(SKID_NC_SILVERSNIPER)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillFlag		SKFLAG_NODISPEL	// ĳ������ ������ �ʵ��� ����
	SkillRange				   2	   2	   2	   2	   2 // ��ų�����Ÿ�
	SkillSP					  25      30      35      40      45 // SP�Ҹ�
	SkillCastFixedDelay		1800	1600	1400	1200	1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	   0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	   0	   0	   0	   0	   0 // ��ų����� ��ü��ų�������ð�	
	SkillData1				   0	 200	 400	 800	1000 // �߰����ݷ�
	SkillData2	        20000   30000   40000   50000   60000 // ���ӽð�
return


SetSkill NC_MAGICDECOY //���� ������(SKID_NC_MAGICDECOY)-������ ����ƺ�
OnInit:
	SkillMaxLv	5
	SkillType	TOGROUND	
	SkillFlag   SKFLAG_NODISPEL	// ĳ������ ������ �ʵ��� ����
	SkillSP					  40	  45	  50	  65	  70 // SP�Ҹ�	
	SkillRange				   2	   2	   2	   2	   2 // ��ų�����Ÿ�
	SkillCastFixedDelay		1800	1600	1400	1200	1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		   0	   0	   0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	   0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	   0	   0	   0	   0	   0 // ��ų����� ��ü��ų�������ð�	
	SkillData1			   20000   30000   40000   50000   60000 // ���ӽð�
	SkillData2				 300	 350	 400	 450	 500 // ����MATK ������ ���밪���� ���ȴ�.	
return

SetSkill NC_DISJOINT //FAW��ü(SKID_NC_DISJOINT)
OnInit:
	SkillMaxLv	1
	SkillType	TOCHARACTER
	SkillRange				   5 // ��ų�����Ÿ�
	SkillSP					  15 // SP�Ҹ�
	SkillCastFixedDelay		   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	   0 // ��ų����� ��ü��ų�������ð�	
return



//1�������� ���� Job Level�� RemainMS�� �����ϰ� �ִ�.
SetSkill SYS_FIRSTJOBLV 
OnInit:
	SkillMaxLv 1
return

//2�������� ���� Job Level�� RemainMS�� �����ϰ� �ִ�.
SetSkill SYS_SECONDJOBLV 
OnInit:
	SkillMaxLv 1
return




//__THIRDJOB1
//********************************************************************************************************************/



//*** __THIRDJOB2 *************************************************************************** 

SetSkill SC_FATALMENACE //����Ż�޳���-������ü�̼�
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��
	SkillRange                   1	     1	     1	     1	     1 // ��ų�����Ÿ�
	SkillSP                     20      25      30      35      40  
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0	     0	     0	     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500     500	   500	   500 // ��ų����� ��ü��ų�������ð�
	SkillData1					30	    25      20      15      10 // ���߷� ������ * (-1)
return

SetSkill SC_REPRODUCE //�����εེ-������ü�̼�
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Nothing  //�Ӽ�����
	SkillType TOME					//�ڱ��ڽſ��Ի��
	SkillPattern SKILLPATT_NONE     //���ݽ�ų�ƴ�
	SkillSP                   40	  45	  50	  55	  60	  65	  70	  75	  80	  85
	SkillCastFixedDelay        0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		   0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	   0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	1000	1000	1000	1000	1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				   8	   8	   7	   7	   6	   6	   5	   5	   4	   4 // �ʴ�SP�Ҹ�	
return

SetSkill SC_AUTOSHADOWSPELL //���伨���콺��-������ü�̼�
OnInit:
	SkillMaxLv		10
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE //���ݽ�ų �ƴ�
	SkillSP                     40      45      50      55      60       65     70      75      80      85 // �̰��� Ŭ���̾�Ʈ���� %�� ȭ�鿡 ��µǰ� �ȴ�.0�̸� ������ �ʵȴ�. �����϶�.
	SkillCastFixedDelay		  2000    2000    2000    2000    2000     2000   2000    2000    2000    2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  4000	  3600    3200    2800    2400     2000   1600    1200     800     400 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0       0       0       0       0       0       0       0       0       0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	     0	     0	     0	     0	     0	     0	     0       0       0       0 // ��ų����� ��ü��ų�������ð� 
	SkillData1				 60000	 80000	100000	120000	140000	160000	180000	200000	220000	300000 // ���ӽð�
	SkillData2				   280	   260     240     220     200     180     160     140     120     150 // �ߵ�Ȯ��(milipercent)
	SkillData3				     1	     1       2       2       3       3       4       4       5       5 // �ִ� �ߵ�����
return

SetSkill SC_SHADOWFORM //��������-������ü�̼�
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillRange                   5	    5	    5	    5	    5 // ��ų�����Ÿ�
	SkillSP                     40     50      60      70      80  
	SkillCastFixedDelay          0	    0	    0	    0       0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	    0	    0	    0	    0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	    0	    0	    0	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	 1000    1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				    10	    9	    8	    7       6 // �ʴ� sp �Ҹ�
	SkillData2				     5      6       7       8       9 // ȿ��Ƚ��
	SkillData3				 30000	40000	50000	60000	70000 // ���ӽð�
return


SetSkill SC_TRIANGLESHOT //Ʈ���̾ޱۼ�-������ü�̼�
OnInit:
	SkillMaxLv		10
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��
	SkillRange                   7	     7	     7	     9	     9		 9		 9	    11	    11		11 // ��ų�����Ÿ�
	SkillSP                     22	    24	    26	    28	    30		32	    34	    36		38	    40
	SkillCastFixedDelay          0	     0	     0	     0	     0	     0	     0	     0       0       0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500	   500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�
	SkillData1					 2	     3		 4	     5	     6	     7       8       9      10      11 // �˹�ߵ�Ȯ��(%)
	SkillData2					 3	     3		 3	     3	     3	     3       3       3       3       3 // �˹�Ÿ�
return


SetSkill SC_BODYPAINT //�ٵ�������-������ü�̼�
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillRange                   1	    1	    1	    1	    1 // ��ų�����Ÿ�
	SkillSP                     10     15      20      25      30  
	SkillCastFixedDelay          0	    0	    0	    0       0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	    0	    0	    0	    0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	 2000	 2000	 2000	 2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	 1000    1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				     2	    2	    2	    2       2 // ����Ʈ�ݰ�(5x5�ΰ�� 2)
	SkillData2				    55     57      59      61      63 // ����ߵ�Ȯ��(%)
	SkillData3				    25     30      35      40      45 // ���Ӱ��� �ߵ�Ȯ��(%)
	SkillData4				  5000   7000	 9000	11000	13000 // ���Ӱ��� ���ӽð�
return

SetSkill SC_INVISIBILITY //�κ�������Ƽ-������ü�̼�
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillRange                   1	    1	    1	    1	    1 // ��ų�����Ÿ�
	SkillSP                    100	  100	  100	  100	  100
	SkillCastFixedDelay          0	    0	    0	    0       0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	 1000	 1000	 1000	 1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 20000   30000  40000   50000   60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	 1000    1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				    20	   40	   60	   80	  100 // ũ��Ƽ�� �߻�Ȯ�� ����(%)
	SkillData2				    40     30      20      10       0 // ���Ӱ��ҷ�(%)
	SkillData3				    10      8       6       4       2 // �ʴ�Ҹ�SP(MSP * ��/100)	
return

SetSkill SC_DEADLYINFECT //���鸮����Ʈ-������ü�̼�
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillRange                   1	    1	    1	    1	    1 // ��ų�����Ÿ�
	SkillSP                     40	   44	   48	   52	   56
	SkillCastFixedDelay          0	    0	    0	    0       0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	    0	    0	    0	    0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	 2000	 2000	 2000	 2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	 1000    1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�
	SkillData1		 10000  15000	20000	25000	30000 // ���ӽð�
	SkillData2		    40	   50	   60	   70	   80 // ����Ȯ��
return


SetSkill SC_ENERVATION //����Ŀ���̵�:�̳ʺ��̼�-������ü�̼�
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��	
	SkillRange                   3	     3	     3 // ��ų�����Ÿ�
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 10000	 15000   20000 // Ÿ���� ���ݷ°��������ð�
	SkillData2				    30	    40	    50 // Ÿ���� ���ݷ°��ҷ�(%)
return


SetSkill SC_GROOMY //����Ŀ���̵�:�׷��-������ü�̼�
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��	
	SkillRange                   3	     3	     3 // ��ų�����Ÿ�
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 10000	 15000   20000 // Ÿ���� ����&���߷� ���������ð�
	SkillData2				    30	    40	    50 // Ÿ���� ���Ӱ���%
	SkillData3				    20	    40	    60 // Ÿ���� ���߷�����%
return

SetSkill SC_IGNORANCE //����Ŀ���̵�:�̱׳���
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��	
	SkillRange                   3	     3	     3 // ��ų�����Ÿ�
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 10000	 15000   20000 // ����ȿ�� �����ð�
	SkillData2				   100	   200     300 // Ÿ���� sp���ҷ�
	SkillData3				    50	   100     150 // �������� sp������
return

SetSkill SC_LAZINESS //����Ŀ���̵�:�������׽�(SKID_SC_LAZINESS)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��	
	SkillRange                   3	     3	     3 // ��ų�����Ÿ�
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 10000	 15000   20000 // ������ȿ�� �����ð�
	SkillData2					20		30      40 // ĳ���üӵ� ������%
	SkillData3					10		20      30 // ȸ�������ҷ�(%)
	SkillData4					10		20      30 // ��ų���� sp���� �߰���(amount)
return


SetSkill SC_UNLUCKY // ����Ŀ���̵�:��Ű(SKID_SC_UNLUCKY)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��	
	SkillRange                   3	     3	     3 // ��ų�����Ÿ�
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 10000	 15000   20000 // �ҿ�(���) ȿ�� �����ð�
	SkillData2				    10	    20	    30 // ũ��Ƽ�� ����%
	SkillData3				    10	    20	    30 // ����ȸ�Ƿ� ����%
	SkillData4				   250	   500	  1000 // ��ų���� �Ҹ�Ŵ� ����
return

SetSkill SC_WEAKNESS //����Ŀ���̵�:��ũ�Ͻ�(SKID_SC_WEAKNESS)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��	
	SkillRange                   3	     3	     3 // ��ų�����Ÿ�
	SkillSP                     30	    40	    50 
	SkillCastFixedDelay          0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 10000	 15000   20000 // �ҿ�(���) ȿ�� �����ð�
	SkillData2				    10	    20	    30 // MHP���Ұ�(%)
return

SetSkill SC_STRIPACCESSARY //��Ʈ���׼�����(SKID_SC_STRIPACCESSARY)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��	
	SkillRange                   3	     3	     3	    3       3 // ��ų�����Ÿ�
	SkillSP                     15	    18	    21     24      27
	SkillCastFixedDelay          0	     0	     0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000   1000	 1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0	    0	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 60000	 70000	 80000	90000  100000 // ȿ�� �����ð�
	SkillData2				    14		16		18	   20	   22 // ����Ȯ��
return

SetSkill SC_MANHOLE //��Ȧ(SKID_SC_MANHOLE)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                   7	     7	     7 // ��ų�����Ÿ�
	SkillSP                     20	    25	    30 
	SkillCastFixedDelay			 0		 0		 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000 // ��ų����� ��ü��ų�������ð� 
	SkillData1				  5000	 10000	 15000 // ���ӽð�	
	SkillData2				  5000	 10000	 15000 // ȿ�� ���ӽð�	
return

SetSkill SC_DIMENSIONDOOR //���ǵ���(SKID_SC_DIMENSIONDOOR)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                   7	     7	     7 // ��ų�����Ÿ�
	SkillSP                     30	    36	    42 
	SkillCastFixedDelay			 0		 0		 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				  4000	  8000	 12000 // ���ӽð�
return

SetSkill SC_CHAOSPANIC //ī�����д�(SKID_SC_CHAOSPANIC)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                   7	     7	     7 // ��ų�����Ÿ�
	SkillSP                     30	    36	    42 
	SkillCastFixedDelay			 0		 0		 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				  5000	 10000	 15000 // ���ӽð�
	SkillData2				    50      65      80 // ����Ȯ��
return

SetSkill SC_MAELSTROM //������Ʈ��(SKID_SC_MAELSTROM)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                   7	     7	     7 // ��ų�����Ÿ�
	SkillSP                     50	    55	    60 
	SkillCastFixedDelay			 0		 0		 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				  7000	 14000	 21000 // ���ӽð�	
return


SetSkill SC_BLOODYLUST //���𷯽�Ʈ(SKID_SC_BLOODYLUST)
OnInit:
	SkillMaxLv		3
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                   7	     7	     7 // ��ų�����Ÿ�
	SkillSP                     60	    70	    80 
	SkillCastFixedDelay			 1000		 1000		 1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		180000		180000		 180000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 5000	 10000	 15000 // ���ӽð�
return


SetSkill SC_FEINTBOMB //����Ʈ��(SKID_SC_FEINTBOMB)
OnInit:
	SkillMaxLv		3
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillFlag		SKFLAG_NODISPEL //ĳ���� �� �������� �Ծ ������ �ʴ´�.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillRange                   1	    1	    1 // ��ų�����Ÿ�
	SkillSP                     24	   28	   32
	SkillCastFixedDelay          0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	 1000	 1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	 5000	 5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay		 0		0		0 // ��ų����� ��ü��ų�������ð�
	SkillData1				     2	    2       2 // ���ݹ���(�ݰ�)
return

// ������(Wanderer) & �ν�Ʈ��(Minstrel)
SetSkill WA_SWING_DANCE //������(SKID_WA_SWING_DANCE)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                     96	   112	   128	   144     160 // SP�Ҹ� 
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	  2000	  2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 60000   60000   60000   60000   60000 // ȿ�����ӽð�
	SkillData2				     7 	     8       9      10      11 // ��ȿ����(�ݰ�)
//	SkillData3				     4	     8	    12	    16 	    20 // ���ݼӵ� ����(%)
return

SetSkill WA_SYMPHONY_OF_LOVER //���ε��� ���� ������(SKID_WA_SYMPHONY_OF_LOVER)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                     60	    69	    78	    87	    96 // SP�Ҹ� 
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	  2000	  2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 60000   60000   60000   60000   60000 // ȿ�����ӽð�
	SkillData2				     7       8       9      10      11 // ��ȿ����(�ݰ�)
return

SetSkill WM_LESSON //����(SKID_WM_LESSON)
OnInit:
	SkillMaxLv 10
	SkillProperty PROPERTY_Nothing    // �Ӽ�����
	SkillType PASSIVE                 // �нú꽺ų
	SkillPattern SKILLPATT_NONE       // ���ݽ�ų�ƴ�	
	SkillData1				 30		 60		 90		120		150		180		210		240		270		300 // MSP������(amount)
return

SetSkill WM_METALICSOUND //��Ż������(SKID_WM_METALICSOUND)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL // ���� ���� ��ųŸ��
	SkillRange                   9	     9	     9	     9       9 // ��ų�����Ÿ�
	SkillSP                     64	    68	    72      76      80 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1500	  2000    2500    3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000    2500    3000    3500    4000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData3				     2	     2		 3		 3		 4 // Ÿ��Ƚ��
return

SetSkill WM_REVERBERATION //��������(SKID_WM_REVERBERATION)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   9	     9	     9	     9	     9 // ��ų�����Ÿ�
	SkillSP                     28	    32	    38	    42	    48 // SP�Ҹ� 
	SkillCastFixedDelay			 0		 0		 0       0       0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1100	  1200	  1300	  1400	  1500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				  9000	 10000	 11000	 12000	 13000 // ���ӽð�
	SkillData2				   400	   500	   600     700     800 // �������ݵ����� percent
	SkillData3				   200	   300	   400     500     600 // �������ݵ����� percent
return

SetSkill WM_REVERBERATION_MELEE //��������-��������(SKID_WM_REVERBERATION_MELEE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing       //�Ӽ��� ����.
	SkillType		TOCHARACTER            //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK //������ ���� ���� ��ųŸ��
return

SetSkill WM_REVERBERATION_MAGIC //��������-��������(SKID_WM_REVERBERATION_MAGIC)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing       //�Ӽ��� ����.
	SkillType		TOCHARACTER            //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL // ���� ���� ��ųŸ��
return

SetSkill WM_DOMINION_IMPULSE //���̴Ͽ����޽�(SKID_WM_DOMINION_IMPULSE)
OnInit:
	SkillMaxLv		1
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                  11 // ��ų�����Ÿ�
	SkillSP                     10 // SP�Ҹ� 
	SkillCastFixedDelay			 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				     5 // ȿ������(�ݰ�)
return


SetSkill WM_SEVERE_RAINSTORM //�����ν���(SKID_WM_SEVERE_RAINSTORM)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��
	SkillAtkPer		   100	   150	   200	   250	   300 // ���ݵ�����������(%)	
	SkillRange                   9	     9	     9	     9	     9 // ��ų�����Ÿ�
	SkillSP                     80	    90	   100	   110	   120 // SP�Ҹ� 
	SkillCastFixedDelay	   500	   500     500     500     500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  1500	  2000	  2500	  3000	  3500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5500	  6000	  6500	  7000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1		    12	    12	    12	    12	    12 // ��Ÿ��Ƚ��
return

SetSkill WM_SEVERE_RAINSTORM_MELEE // �����ν���-��������(SKID_WM_SEVERE_RAINSTORM_MELEE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing       //�Ӽ��� ����.
	SkillType		TOCHARACTER            //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK //������ ���� ���� ��ųŸ��
	SkillRange                  11	   11	   11	   11      11 // ��ų�����Ÿ�
return


SetSkill WM_POEMOFNETHERWORLD //�����ǳ뷡(SKID_WM_POEMOFNETHERWORLD)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   9	     9	     9	     9	     9 // ��ų�����Ÿ�
	SkillSP                     12	    16	    20	    24	    28 // SP�Ҹ� 
	SkillCastFixedDelay			 0		 0		 0       0       0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  3000	  3000	  3000	  3000	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�
	SkillData1				  9000	 11000	 13000	 15000	 17000 // ���ӽð�
	SkillData2				  8000   10000   12000   14000   16000 // ȿ�����ӽð�
return

SetSkill WM_VOICEOFSIREN //���̷��� ��Ҹ�(SKID_WM_VOICEOFSIREN)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                     48	    56	    64	    72	    80 // SP�Ҹ� 
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2200	  2400	  2600	  2800 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000    5000    5000    5000    5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	  1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData2				     2       3       4       5       6 // ȿ���������(�ݰ�)
	SkillData3				 15000	 18000	 21000   24000   27000 // ȿ�������ð�
return

SetSkill WM_DEADHILLHERE //����ǰ�¥�⿡��(SKID_WM_DEADHILLHERE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                   7	     7	     7	     7       7 // ��ų�����Ÿ�
	SkillSP                     50	    53	    56      59      62 // SP�Ҹ�
	SkillCastFixedDelay       1000    1000	  1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  3000	  2500	  2000    1500    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  	 0		 0		 0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				    90		92		94	    96	    98 // ����Ȱ��(%)
	SkillData2				    50      40      30      20      10 // ��Ȱ�� ����ɸ��� SP �Ҹ��(%)
return

SetSkill WM_LULLABY_DEEPSLEEP //�Ƚ������尡(SKID_WM_LULLABY_DEEPSLEEP)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillSP                     80	    90	   100	   110	   120 // SP�Ҹ� 
	SkillCastFixedDelay		  1000    1000    1000    1000    1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 10000	 10000   10000   10000   10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				     5       6       7       8       9 // ȿ������ �ݰ�
	SkillData3				 12000	 14000	 16000	 18000	 20000 // ȿ�����ӽð�
return

SetSkill WM_SIRCLEOFNATURE //��ȯ�ϴ��ڿ��ǼҸ�(SKID_WM_SIRCLEOFNATURE)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME	
	SkillPattern	SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                     42	    46	    50	    54	    58 // SP�Ҹ� 
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2000	  2000	  2000	  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 15000	 15000	 15000	 15000	 15000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	  1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				 60000   60000   60000   60000   60000 // ȿ�������ð�
	SkillData2				     4       8      12      16      20 // ����� �ʴ� sp �Ҹ�
	SkillData3				    40      80     120     160     200 // ����� �ʴ� hp ȸ����
	SkillData4				     3       4       5       6       7 // ����ݰ�
return

SetSkill WM_RANDOMIZESPELL //��Ȯ������Ǿ��(SKID_WM_RANDOMIZESPELL)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillRange                   9	     9	     9	     9       9 // ��ų�����Ÿ�
	SkillSP                     40	    45	    50      55      60 // SP�Ҹ�
	SkillCastFixedDelay          0       0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0	     0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  3000	  3000	  3000	  3000	  3000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				     5		 6		 7	     8	     9 // �ߵ��Ŵ� ��ų�� ���� 
return

SetSkill WM_GLOOMYDAY // ������ �Ϸ��� ���(SKID_WM_GLOOMYDAY)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing       // �Ӽ��� ����.
	SkillType		TOALL //�ڱ��ڽ�����
	SkillPattern	SKILLPATT_NONE		   // ���ݽ�ų�ƴ�	
	SkillRange                   9	     9	     9	     9       9 // ��ų�����Ÿ�
	SkillSP                     60	    75	    90     105     120 // SP�Ҹ�
	SkillCastFixedDelay        500     500	   500	   500	   500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 10000   10000   10000   10000   10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				    25		30		35	    40	    45 // ȸ�ǰ���(amount)
	SkillData2				    20		25		30	    35	    40 // ���Ӱ���(%)
	SkillData3				 30000	 45000	 60000	 75000	 90000 // ȿ�����ӽð�
return

SetSkill WM_GREAT_ECHO //�׷���Ʈ ����(SKID_WM_GREAT_ECHO)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOGROUND	
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   9	     9	     9	     9	     9 // ��ų�����Ÿ�
	SkillSP                     80	    90	   100	   110	   120 // SP�Ҹ� 
	SkillAtkPer				  1000	  1100	  1200	  1300	  1400 // ���ݵ�����������(%)	
	SkillCastFixedDelay		   500	   500	   500     500     500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	  2200	  2400	  2600	  2800 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				     2       3       3       4       4 // �������� �ݰ�	
return

SetSkill WM_SONG_OF_MANA //������ �뷡(SKID_WM_SONG_OF_MANA)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                    120	   140	   160     180     200 // SP�Ҹ�
	SkillCastFixedDelay        500     500	   500	   500	   500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 90000	 90000	 90000	 90000	 90000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 30000	 60000	 90000	120000	150000 // ȿ�����ӽð�
	SkillData2				     5       6       7       8       9 // ����ݰ�
return

SetSkill WM_DANCE_WITH_WUG //���׿� �Բ� ����(SKID_WM_DANCE_WITH_WUG)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                    120	   140	   160     180     200 // SP�Ҹ�
	SkillCastFixedDelay        500     500	   500	   500	   500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1500	  2000	  2500    3000    3500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 90000	 90000	 90000	 90000	 90000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 30000	 60000	 90000	120000	150000 // ȿ�����ӽð�
	SkillData2				     5       6       7       8       9 // ����ݰ�
return

SetSkill MI_RUSH_WINDMILL //ǳ���� ���� ����(SKID_MI_RUSH_WINDMILL)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                     82	    88	    94     100     106 // SP�Ҹ�
	SkillCastFixedDelay          0       0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 60000   60000   60000   60000   60000 // ȿ�����ӽð�
	SkillData3				     7       8       9      10      11 // ȿ������ݰ�
return

SetSkill MI_ECHOSONG //�޾Ƹ��� �뷡(SKID_MI_ECHOSONG)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                     86	    92	    98     104     110 // SP�Ҹ�
	SkillCastFixedDelay          0       0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 60000   60000   60000   60000   60000 // ȿ�����ӽð�
	SkillData3				     7	     8       9      10      11 // ȿ������ݰ�
return

SetSkill MI_HARMONIZE //�ϸ�����(SKID_MI_HARMONIZE)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOALL //�ڱ��ڽ�����
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                  9	    9	    9	    9	    9 // ��ų�����Ÿ�
	SkillSP                    70	   75	   80	   85	   90 // SP�Ҹ�
	SkillCastFixedDelay         0	    0		0		0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	     1000	 1000	 1000	 1000	 1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 5000	 5000	 5000	 5000	 5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // ��ų����� ��ü��ų�������ð� 
	SkillData1			    60000   60000   60000   60000   60000 // ȿ�����ӽð�
	SkillData2				   10	   15	   20	   25	   30 // ��罺�����ͽ� ����ġ ���Ұ�
return

SetSkill WA_MOONLIT_SERENADE // �޺��� ��������(SKID_WA_MOONLIT_SERENADE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                     84	    96	   108     120     134 // SP�Ҹ�
	SkillCastFixedDelay          0       0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      2000	  2000	  2000	  2000	  2000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 60000   60000   60000   60000   60000 // ȿ�����ӽð�
	SkillData2				    10	    20      30      40      50 // �߰� �������ݷ�����(%)
	SkillData3				     7	     8       9      10      11 // ȿ������ �ݰ�
return

SetSkill WM_SOUND_OF_DESTRUCTION //���� ���� ��Ʈ����(SKID_WM_SOUND_OF_DESTRUCTION)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing //�ƹ����Ӽ��� ����.
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillAtkPer				  500	  500	  500	  500	  500 // ���ݵ�����������(%)
	SkillRange                  9	    9	    9	    9	    9 // ��ų�����Ÿ�
	SkillSP                    50	   60	   70	   80	   90 // SP�Ҹ�
	SkillCastFixedDelay       500	  500	  500	  500	  500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	        0	  500	 1000	 1500	 2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 6000    7000    8000    9000   10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				    4	    4	    5	    6	    7 // ȿ���������(�ݰ�)
return

SetSkill WM_SATURDAY_NIGHT_FEVER //���͵��� ����Ʈ �ǹ�(SKID_WM_SATURDAY_NIGHT_FEVER)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                    150	   160	   170	   180	   190 // SP�Ҹ�
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  2000	  3000    4000    5000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	180000	180000	180000	180000	180000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1	 10000	 15000	 20000	 25000	 30000 // ����ȿ�����ӽð�	
	SkillData2				     3	     4	     5	     6	     7 // ����ݰ�
return

SetSkill WM_LERADS_DEW //������� �̽�(SKID_WM_LERADS_DEW)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                    120	   130	   140	   150	   160 // SP�Ҹ�
	SkillCastFixedDelay        500	   500	   500	   500	   500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	180000	180000	180000	180000	180000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 20000	 30000	 40000	 50000	 60000 // ȿ�����ӽð�	
	SkillData2				     5		 5	     6	     6	     7 // ȿ������ݰ�	
	SkillData4				   200     400     600     800    1000 // MHP������
return

SetSkill WM_MELODYOFSINK //��ε� ���� ��ũ(SKID_WM_MELODYOFSINK)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                    120	   130	   140	   150	   160 // SP�Ҹ�
	SkillCastFixedDelay        500	   500	   500	   500	   500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	180000	180000	180000	180000	180000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 20000	 30000	 40000	 50000	 60000 // ȿ�����ӽð�	
	SkillData2				     5		 5	     6	     6	     7 // ȿ������ݰ�
	SkillData3				    20		25	    30	    35	    40 // ����Ȯ��	
return


SetSkill WM_BEYOND_OF_WARCRY //���� ���� �� ũ����(SKID_WM_BEYOND_OF_WARCRY)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                    120	   130	   140	   150	   160 // SP�Ҹ�
	SkillCastFixedDelay        500	   500	   500	   500	   500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	180000	180000	180000	180000	180000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 20000	 30000	 40000	 50000	 60000 // ȿ�����ӽð�	
	SkillData2				     5		 5	     6	     6	     7 // ȿ������ݰ�
	SkillData3				    20		25	    30	    35	    40 // ����Ȯ��
return


SetSkill WM_UNLIMITED_HUMMING_VOICE //�𸮹�Ƽ�� ��� ���̽�(SKID_WM_UNLIMITED_HUMMING_VOICE)
OnInit:
	SkillMaxLv		5
	SkillProperty   PROPERTY_Nothing //�Ӽ��� ����.
	SkillType		TOME //�ڱ��ڽ�
	SkillPattern	SKILLPATT_NONE  // ���ݽ�ų�ƴ�	
	SkillRange                   1	     1	     1	     1       1 // ��ų�����Ÿ�
	SkillSP                    120	   130	   140	   150	   160 // SP�Ҹ�
	SkillCastFixedDelay        500	   500	   500	   500	   500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	110000	120000	130000	140000	150000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				 60000	 90000	120000	150000	180000 // ȿ�����ӽð�	
	SkillData2				     5		 5	     6	     6	     7 // ȿ������ݰ�
return

//�Ҽ���
SetSkill SO_FIREWALK //���̾� ��ũ(SKID_SO_FIREWALK)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillProperty	PROPERTY_Fire
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP					    30	    34	    38	    42	    46 // SP�Ҹ�	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1               30000   30000   30000   30000   30000 // ���� ������ �� �ִ� EFST_PROPERTYWALK ���ӽð� 
	SkillData2				     8	    10      12	    14	    16 // �� ��������
	SkillData3				 12000	 12000	 12000	 12000	 12000 // ���� ���ӽð�
	SkillData4					 1	     1		 1	      1		 1 // �� �ϳ��� ���� Ƚ��
return

SetSkill SO_ELECTRICWALK //�Ϸ�Ʈ�� ��ũ(SKID_SO_ELECTRICWALK)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillProperty	PROPERTY_Wind
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP						30	    34	    38	    42	    46 // SP�Ҹ�	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				 30000   30000   30000   30000   30000 // ���� ������ �� �ִ� EFST_PROPERTYWALK ���ӽð� 
	SkillData2					 8	    10	    12	    14	    16 //�� ��������
	SkillData3				 12000	 12000	 12000	 12000	 12000 // ���� ���ӽð�
	SkillData4					 1	     1	     1	     1	     1 // �� �ϳ��� ���� Ƚ��
return

SetSkill SO_SPELLFIST //���� �ǽ�Ʈ(SKID_SO_SPELLFIST)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillSP						40	    44	    48	    52	    56 // SP�Ҹ�
	SkillAtkPer				   50     100     150     200     250 // �߰� ������ MATK %
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay			 0		 0		 0		 0		 0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				 20000   25000   30000   35000   40000 // ���ӽð�
	SkillData2				     2       3       4       5       6 // Ÿ��Ƚ��
return

SetSkill SO_PSYCHIC_WAVE //����ű ���̺�(SKID_SO_PSYCHIC_WAVE)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9	     9	     9 // ��ų�����Ÿ�
	SkillSP						48	    56	    64	    70	    78 // SP�Ҹ�
	SkillAtkPer				   700	   700	   700	   700	   700 // ���ݵ�����������(%)
	SkillCastFixedDelay       1000	   900	   800	   700	   600 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  8000	  9000	 10000	 11000	 12000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 3		 4		 5		 6		 7 // Ƚ��
	SkillData2					 3		 3		 4		 4		 5 // ����(�ݰ�) 7*7 7*7 9*9 9*9 11*11
return

SetSkill SO_CLOUD_KILL //Ŭ���� ų(SKID_SO_CLOUD_KILL)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillProperty	PROPERTY_Poison	
	SkillRange					 9		 9		 9		 9		 9 // ��ų�����Ÿ�
	SkillAtkPer				  1200	  1400	  1600	  1800	  2000 // ���ݵ�����������(%)
	SkillSP						48	    56	    64	    70	    78 // SP�Ҹ�	
	SkillCastFixedDelay       700	  500	  300	  100	  0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2300	  2500	  2700	  2900	  3100 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1					 3		 3		 3		 3		 3 // ���� 7*7
	SkillData2				  8000   10000   12000   14000   16000 // ������ ���ӽð�
	SkillData3				 10000	 15000	 20000	 25000	 30000 // EFST_CLOUD_KILL (���Ӽ����� ����) ���ӽð�
return

SetSkill SO_POISON_BUSTER //������ ������(SKID_SO_POISON_BUSTER)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Poison
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP			70	90	   110	   130	   150 // SP�Ҹ�
	SkillRange		 	9	 9	 9	 9	 9 // ��ų�����Ÿ�
	SkillAtkPer		  1500    1800    2100    2400    2700 // ���ݵ�����������(%)
	SkillCastFixedDelay        800	   600	   400	   200	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  2200	  3400	  4600	  5800	  6000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1					 1		 1		 1		 1		 2 // ����ݰ�
return


SetSkill SO_STRIKING //��ũ����ŷ(SKID_SO_STRIKING)
OnInit:
	SkillMaxLv		5
	SkillType		TOALL
	SkillSP					    50		55		60		65		70 // SP�Ҹ�
	SkillRange					 9		 9		 9		 9		 9 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				    35	    45	    55	    65	    75 // ������ݷ� ����
	SkillData2					10		20		30		40		50 // ũ��Ƽ�� ����%
	SkillData3					 2		 3		 4		 5		 6 // ���ü����� ����%
	SkillData4               60000   60000   60000   60000   60000 // ���ӽð�
	SkillData5					 5		 4		 3		 2		 1 // �ʴ�SP�Ҹ�
return

SetSkill SO_EARTHGRAVE //� �׷��̺�(SKID_SO_EARTHGRAVE)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Ground
	SkillPattern	SKILLPATT_ATTACKSPELL	
	SkillRange					 9		 9		 9		 9		 9 // ��ų�����Ÿ�
	SkillSP						62		70		78		86		94 // SP�Ҹ�	
	SkillCastFixedDelay       1800	  1600    1400	  1200	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  2200	  2400	  2600	  2800	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 3		 3		 3		 4		 4 // ȿ������(�ݰ�) - ���� 7*7 7*7 7*7 9*9 9*9
	SkillData2				     5		10		15		20		25 // ���� �߻� Ȯ��(%)	
return

SetSkill SO_DIAMONDDUST //���̾Ƹ�� ����Ʈ(SKID_SO_DIAMONDDUST)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Water
	SkillPattern	SKILLPATT_ATTACKSPELL	
	SkillRange					 9		 9		 9		 9		 9 // ��ų�����Ÿ�
	SkillSP						50		56		62		68		74 // SP�Ҹ�	
	SkillCastFixedDelay        800	   600	   400	   200	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  5000 	  5500	  6000	  6500	  7000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 3		 3		 3		 4		 4 // ȿ������(�ݰ�)
	SkillData2					10		15		20		25		30 // �õ� �߻� Ȯ��(%)	
return

SetSkill SO_WARMER //����(SKID_SO_WARMER)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange					 9		 9		 9		 9		 9 // ��ų�����Ÿ�
	SkillSP						40		52		64		76		88 // SP�Ҹ�
	SkillCastFixedDelay       1800	  1600	  1400	  1200	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  2200	  2400	  2600	  2800	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 35000	 40000	 45000	 50000	 55000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1		     3	     3	     3	     3       3 // ȿ������(�ݰ�)
	SkillData2               40000   45000   50000   55000   60000 // ���ӽð�
return

SetSkill SO_VACUUM_EXTREME // ��Ũ �ͽ�Ʈ��
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange					 9		 9		 9		 9		 9 // ��ų�����Ÿ�
	SkillSP						34		42		50		58		66 // SP�Ҹ�
	SkillCastStatDelay		  1000	  1500	  2000	  2500	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 1		 1		 2		 2		 3 // ȿ������(�ݰ�) 3*3 3*3 5*5 5*5 7*7
	SkillData2                4000    6000    8000   10000   12000 // ���ӽð�
return

SetSkill SO_VARETYR_SPEAR // �ٷ�Ƽ�����Ǿ�
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Wind
	SkillPattern	SKILLPATT_ATTACKSPELL		
	SkillRange					 9		 9		 9		 9		 9 // ��ų�����Ÿ�
	SkillSP			    55	    62	    69	    76	    83 // SP�Ҹ�
	SkillCastFixedDelay       1800	  1600	  1400	  1200	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  2200	  2400	  2600	  2800	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  2000	  2000	  2000	  2000	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 1		 1		 2		 2		 3 // ����� �ֺ� ȿ������(�ݰ�) 3*3, 3*3, 5*5, 5*5, 7*7
	SkillData2                  10      15      20      25      30 // ����Ȯ��
return

SetSkill SO_ARRULLO // �Ƹ���
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange		     7	     7	     7	     7	    9 // ��ų�����Ÿ�
	SkillSP			    30	    35	    40	    45	   50 // SP�Ҹ�
	SkillCastFixedDelay        800	   600	   400	   200	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  2200	  2400	  2600	  2800	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  6000	  7000	  8000	  9000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1		     1	     1	     2	     2	    3 // ����� �ֺ� ȿ������(�ݰ�) 3*3, 3*3, 5*5, 5*5, 7*7
	SkillData2                  20      25      30      35     40 // EFST_DEEP_SLEEP ����Ȯ��
	SkillData3		  8000	 10000   12000   14000   16000 // EFST_DEEP_SLEEP ���ӽð�
return

SetSkill SO_SUMMON_AGNI // ���� ���� ��ȯ
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Fire
	SkillSP					   100	   150	   200 // SP�Ҹ�
	SkillCastFixedDelay       2000	  2000	  2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay        1000	  2000	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 60000	 60000	 60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillData1			    600000  900000 1200000 // ���ӽð�
	SkillData2					 5		 8		11 // 10�ʴ� �Ҹ� SP
	SkillData3				   990     990     994 // �˸� ������ - ������� ������� ��������Ʈ
	SkillData4					 3       6       1 // �˸� ������ ����	
return

SetSkill SO_SUMMON_AQUA // ���� ���� ��ȯ
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Water
	SkillSP					   100	   150	   200 // SP�Ҹ�
	SkillCastFixedDelay       2000	  2000	  2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay        1000	  2000	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 60000	 60000	 60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillData1			    600000  900000 1200000 // ���ӽð�
	SkillData2					 5		 8		11 // 10�ʴ� �Ҹ� SP
	SkillData3				   991     991     995 // �˸� ������ - ũ����Ż��� ũ����Ż��� �̽�ƽ������
	SkillData4					 3       6       1 // �˸� ������ ����
return

SetSkill SO_SUMMON_VENTUS // �ٶ��� ���� ��ȯ
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Wind
	SkillSP					   100	   150	   200 // SP�Ҹ�
	SkillCastFixedDelay       2000	  2000	  2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay        1000	  2000	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 60000	 60000	 60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillData1			    600000  900000 1200000 // ���ӽð�
	SkillData2					 5		 8		11 // 10�ʴ� �Ҹ� SP
	SkillData3				   992     992     996 // �˸� ������ - ����������� ����������� �������� 
	SkillData4					 3       6       1 // �˸� ������ ����	
return


SetSkill SO_SUMMON_TERA // ���� ���� ��ȯ
OnInit:
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Ground
	SkillSP					   100	   150	   200 // SP�Ҹ�
	SkillCastFixedDelay       2000	  2000	  2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay        1000	  2000	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 60000	 60000	 60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillData1			    600000  900000 1200000 // ���ӽð�
	SkillData2					 5		 8		11 // 10�ʴ� �Ҹ� SP
	SkillData3				   993     993     997 // �˸� ������ - �׸����̺� �׸����̺� �׷���Ʈ������ 
	SkillData4					 3       6       1 // �˸� ������ ����
return

SetSkill SO_EL_CONTROL // ��������
OnInit:
	SkillMaxLv		4
	SkillType		TOME
	SkillSP						10		10		10		10	
	SkillCastFixedDelay          0	     0	     0	     0 // ��ų ĳ���� ���� delay��	
	SkillCastStatDelay		  2000	  2000	  2000	  2000
	SkillSinglePostDelay      5000	  5000	  5000	  5000
	SkillGlobalPostDelay		 0		 0		 0		 0	
return

SetSkill SO_EL_ACTION // ������Ż �׼�(SKID_SO_EL_ACTION)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER
	SkillRange      5  // ��ų�����Ÿ�	
	SkillSP						50 // �Ҹ� SP
	SkillCastFixedDelay          0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0 // ��ų����� ��ü��ų�������ð�	
return

SetSkill SO_EL_ANALYSIS //���� �м�(SKID_SO_EL_ANALYSIS)
OnInit:
	SkillMaxLv		2
	SkillType		TOME
	SkillSP						10	  20 // �Ҹ� SP
	SkillCastFixedDelay       2000	2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0     0 // ��ų����� ��ü��ų�������ð�	
return

SetSkill SO_EL_SYMPATHY //���� ����(SKID_SO_EL_SYMPATHY)
OnInit:
	SkillMaxLv 5
	SkillProperty PROPERTY_Nothing    // �Ӽ�����
	SkillType PASSIVE                 // �нú꽺ų
	SkillPattern SKILLPATT_NONE       // ���ݽ�ų�ƴ�	
	SkillData1		  5 	  10	  15	  20	  25 // ���� MHP % ������
	SkillData2		  5  	  10	  15	  20	  25 // ���� MSP % ������
	SkillData3		 25  	  50	  75	 100	 125 // ���� ATK & MATK ������
	SkillData4		 10	      15	  20	  25	  30 // ���ɼ�ȯ ��ų���� �������� SP ���ҷ�	
return

SetSkill SO_EL_CURE // ���� ġ��(SKID_SO_EL_CURE)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillSP						10 // ����ó���κ��Դϴ�.(maxhp�� maxsp�� 10%�� �Ҹ��մϴ�.) �̰��� 0�̸� �ʵǹǷ� �̰����� �����ϰ� �ڵ忡�� ����ó���մϴ�.
	SkillCastFixedDelay          0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000 // ��ų����� ��ü��ų�������ð�	
return


SetSkill SO_FIRE_INSIGNIA // ���̾� �νñ״Ͼ�(SKID_SO_FIRE_INSIGNIA)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9 // ��ų�����Ÿ�
	SkillSP						22	    30	    38 // SP�Ҹ�
	SkillCastFixedDelay       1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 60000	 60000	 60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0 // ��ų����� ��ü��ų�������ð�
return

SetSkill SO_WATER_INSIGNIA // ���� �νñ״Ͼ�(SKID_SO_WATER_INSIGNIA)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9 // ��ų�����Ÿ�
	SkillSP						22	    30	    38 // SP�Ҹ�
	SkillCastFixedDelay       1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 60000	 60000	 60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0 // ��ų����� ��ü��ų�������ð�
return


SetSkill SO_WIND_INSIGNIA // ���� �νñ״Ͼ�(SKID_SO_WIND_INSIGNIA)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9 // ��ų�����Ÿ�
	SkillSP						22	    30	    38 // SP�Ҹ�
	SkillCastFixedDelay       1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 60000	 60000	 60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0 // ��ų����� ��ü��ų�������ð�
return

SetSkill SO_EARTH_INSIGNIA // � �νñ״Ͼ�(SKID_SO_EARTH_INSIGNIA)
OnInit:
	SkillMaxLv		3
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillRange					 9		 9	     9 // ��ų�����Ÿ�
	SkillSP						22	    30	    38 // SP�Ҹ�
	SkillCastFixedDelay       1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 60000	 60000	 60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0 // ��ų����� ��ü��ų�������ð�
return




// ------------------ ���׸�(Genetic) ��ų�� --------------------------------------------------
SetSkill GN_TRAINING_SWORD //�˼���(SKID_GN_TRAINING_SWORD)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing    // �Ӽ�����
	SkillType		PASSIVE             // �нú꽺ų
	SkillPattern	SKILLPATT_NONE     // ���ݽ�ų�ƴ�	
	SkillData1		10		20		30		40		50 // ���ݷ��߰�
	SkillData2		 3		 6		 9		12		15 // ���ߺ��ʽ� ��ġ	
return

SetSkill GN_REMODELING_CART //īƮ ����(SKID_GN_REMODELING_CART)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing    // �Ӽ�����
	SkillType		PASSIVE             // �нú꽺ų
	SkillPattern	SKILLPATT_NONE     // ���ݽ�ų�ƴ�	
	SkillData1		 4		 8		12		16		20 // īƮ��ų(3��)���� ���߷�����
	SkillData2	  5000	 10000	 15000	 20000	 25000 // īƮ�� �ִ빫�� ������ġ Ŭ�󿡼��� 1/10 �� ǥ�õȴ�.
return

SetSkill GN_CART_TORNADO //īƮ ����̵� ����(SKID_GN_CART_TORNADO)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillPattern		SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��
	SkillSP						30	    30	    30	    30	    30 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay			 0		 0		 0		 0		 0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	   500	  1000	  1500	  2000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�	
	SkillData1				     2       2       2       2       2 // ȿ������(�ݰ�)
	SkillData2				     2       2       2       2       2 // �˹鼿��
return

SetSkill GN_CARTCANNON //īƮ ĳ��(SKID_GN_CARTCANNON)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // �Ӽ�����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��
	SkillSP						40		42		46		48		50 // SP�Ҹ�
	SkillRange					 7		 8		 9		10		11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1500	  2000	  2500	  3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�
	SkillData1				     1       1       2       2       3 // ȿ������(�ݰ�)
return

SetSkill GN_CARTBOOST //īƮ �ν�Ʈ(SKID_GN_CARTBOOST)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillSP						20	    24	    28	    32	    36 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1500	  1500    1500    1500    1500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�	
	SkillData1				    50      50      75      75     100 // �̵��ӵ�������(%)
	SkillData2				    10      20      30      40      50 // ATK������
	SkillData3				 90000	 90000   90000   90000   90000 // �����ð�
return

SetSkill GN_THORNS_TRAP //���ó��� ��(SKID_GN_THORNS_TRAP)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND	
	SkillRange					 9		 9		 9		 9		 9 // ��ų�����Ÿ�
	SkillSP						22	    26	    30	    34	    38 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1500	  1500	  1500	  1500	  1500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�		
	SkillData1               10000   12000   14000   16000   18000 // ���ӽð�
	SkillData2                 300	   500	   700	   900	  1100 // �ʴ� ������
	SkillData3                   3	     3	     3	     3	     3 // �ִ뼳ġ����
return

SetSkill GN_BLOOD_SUCKER //���� ��Ŀ(SKID_GN_BLOOD_SUCKER)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // �Ӽ�����
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP						30		35		40		45		50 // SP�Ҹ�
	SkillRange					11		11		11		11		11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1500	  1500	  1500	  1500	  1500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�
	SkillData1				 20000	 22000	 24000	 26000	 28000 // ���ӽð�
	SkillData2				   300	   400	   500	   600     700 // �ʴ� �������� + �������� INT��
	SkillData3				    10      15      20      25      30 // HP�����(%) (���������� ���ؼ�)	
return


SetSkill GN_SPORE_EXPLOSION //������ �ͽ��÷���(SKID_GN_SPORE_EXPLOSION)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // �Ӽ�����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��
	SkillSP						55		60		65		70		75 // SP�Ҹ�
	SkillRange					11		11		11		11		11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1500	  1500	  1500	  1500	  1500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�
	SkillData1				  2000	  2000	  3000	  3000	  4000 // ���������ð�
	SkillData3				     1       2       3       4       5 // ����������ݰ�
return

SetSkill GN_WALLOFTHORN //���ó����� ��(SKID_GN_WALLOFTHORN)
OnInit:
	SkillMaxLv		5
	SkillType		TOALL					// �ڽ��� ������ ��� �ɸ������� 
	SkillProperty	PROPERTY_Nothing		// �Ӽ�����
	SkillPattern	SKILLPATT_DIRECTATTACK  // ������ ���� ���� ��ųŸ��
	SkillSP						40		50		60		70		80 // SP�Ҹ�
	SkillRange					11		11		11		11		11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1500	  1500	  1500	  1500	  1500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�
	SkillData1				 10000	 11000	 12000	 13000	 14000 // ���ӽð�
	SkillData2				  4000	  6000	  8000	 10000	 12000 // ������
return

SetSkill GN_CRAZYWEED //ũ������ ����(SKID_GN_CRAZYWEED)
OnInit:
	SkillMaxLv		10
	SkillType		TOGROUND
	SkillSP						24	  28	  32	  36	  40	  44	  48	  52	  56	  60 // SP�Ҹ�
	SkillRange					11	  11	  11	  11	  11	  11	  11	  11	  11	  11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	   0	   0	   0	   0	   0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  3000	3500	4000	4500	5000	5500	6000	6500	7000	7500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	5000	5000	5000	5000	5000	5000	5000	5000	5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	 500     500	 500	 500	 500	 500	 500	 500	 500 // ��ų����� ��ü��ų�������ð�	
	SkillData1                   4	   4	   4	   4	   4	   4	   4	   4	   4	   4 // ���Ϲݰ�
	SkillData2                   3	   4	   4	   5	   5	   6	   6	   7	   7	   8 // ����Ƚ��	
return

SetSkill GN_CRAZYWEED_ATK //ũ������ ���� ��Ӱ���(SKID_GN_CRAZYWEED_ATK)
OnInit:
	SkillMaxLv		10
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Ground //���Ӽ�����
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillAtkPer                600	 700	 800	 900	1000	1100	1200	1300	1400	1500 // ���ݵ�����������(%)
return


SetSkill GN_DEMONIC_FIRE //����� ���̾�(SKID_GN_DEMONIC_FIRE)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillProperty	PROPERTY_Fire
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillSP						24	  28	  32	  36	  40 // SP�Ҹ�
	SkillRange					 9	   9	   9	   9	   9 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  3000	3500	4000	4500	5000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	5000	5000	5000	5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	 500     500	 500	 500 // ��ų����� ��ü��ų�������ð�	
	SkillData1               10000 12000   14000   16000   18000 // ���ӽð�
	SkillData2                 130	 150	 170	 190	 210 // 2�ʴ� MATK ���ݵ����� ������(%)
	SkillData3                   8	  12	  16	  20	  24 // ��ȭ����Ȯ��(%)	
return

SetSkill GN_FIRE_EXPANSION //���̾� �ͽ����(SKID_GN_FIRE_EXPANSION)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillSP						30	  35	  40	  45	  50 // SP�Ҹ�
	SkillRange					 9	   9	   9	   9	   9 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  2000	2000	2000	2000	2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	 500     500	 500	 500 // ��ų����� ��ü��ų�������ð�		
return


SetSkill GN_FIRE_EXPANSION_ACID //���̾� �ͽ���� ����(SKID_GN_FIRE_EXPANSION_ACID)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // �Ӽ�����
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						 0		0	    0	    0	    0	    0	    0	    0	    0	    0 // SP�Ҹ�
	SkillRange					11	   11	   11	   11	   11	   11	   11	   11	   11	   11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0		0		0		0		0		0		0		0		0		0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0		0		0		0		0		0		0		0		0		0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0		0		0		0		0		0		0		0		0		0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0		0		0		0		0		0		0		0		0		0 // ��ų����� ��ü��ų�������ð�	
	SkillData1                   1		2		3		4		5		6		7		8		9	   10 // ��ŸȽ��
	SkillData2                   1		2		3		4		5		6		7		8		9	   10 // ����� ���� �ı�Ȯ��(%)
return


SetSkill GN_HELLS_PLANT // ���� �÷�Ʈ(SKID_GN_HELLS_PLANT)
OnInit:
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillSP						40	  45	  50	  55	  60 // SP�Ҹ�	
	SkillRange					 9	   9	   9	   9	   9 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  3000	3500	4000	4500	5000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	   0	   0	   0	   0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	 500     500	 500	 500 // ��ų����� ��ü��ų�������ð�
	SkillData1                   2	   3	   4	   5	   6 // ��ġ �ִ� ����
	SkillData2                  10	  15	  20	  25	  30 // ���� Ȯ��(%)
	SkillData3                  30	  40	  50	  60	  70 // ���� Ȯ��(%)
return

SetSkill GN_HELLS_PLANT_ATK // ���� �÷�Ʈ(SKID_GN_HELLS_PLANT_ATK)
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL
return

SetSkill GN_MANDRAGORA //�Ͽ︵ ���� �������(SKID_GN_MANDRAGORA)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillSP						40	    45		50	    55      60 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000    1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�	
	SkillData1				    35      45      55      65      75 // ȿ���� �ɸ� Ȯ��(�⺻��)
	SkillData2				    30      35      40      45      50 // SP���ҷ�(%)(�ѹ���)
	SkillData3				     4	     8	    12	    16	    20 // INT���Ұ�
	SkillData4				     5	     6	     6	     7       7 // ����ݰ�
return

SetSkill GN_CHANGEMATERIAL //ü���� ���͸���(SKID_GN_CHANGEMATERIAL)
OnInit:
	SkillMaxLv			1
	SkillType			TOME
	SkillSP						 5 // SP�Ҹ�
	SkillCastFixedDelay          0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0 // ��ų����� ��ü��ų�������ð�
return


SetSkill GN_MIX_COOKING //�ͽ� ��ŷ(SKID_GN_MIX_COOKING)
OnInit:
	SkillMaxLv			2
	SkillType			TOME
	SkillSP						 5		40 // SP�Ҹ�
	SkillCastFixedDelay          0		 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0		 0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0		 0 // ��ų����� ��ü��ų�������ð�
	SkillData1				     1      10 // ���� ������
return

SetSkill GN_MAKEBOMB //��ź����(SKID_GN_MAKEBOMB)
OnInit:
	SkillMaxLv			2
	SkillType			TOME
	SkillSP						 5		40 // SP�Ҹ�
	SkillCastFixedDelay          0		 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0		 0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0		 0 // ��ų����� ��ü��ų�������ð�
	SkillData1				     1      10 // ���� ������
return

SetSkill GN_S_PHARMACY //����� �ĸӽ�(SKID_GN_S_PHARMACY)
OnInit:
	SkillMaxLv			10
	SkillType			TOME
	SkillSP						12	   12	   12	   12	   12	   12	   12	   12	   12	   12 // SP�Ҹ�
	SkillCastFixedDelay          0		0		0		0		0		0		0		0		0		0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0		0		0		0		0		0		0		0		0		0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0		0		0		0		0		0		0		0		0		0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0		0		0		0		0		0		0		0		0		0 // ��ų����� ��ü��ų�������ð�	
	SkillData1					7	    8	    8	    9	   9	   10	   10	   11	   11	   12 // ��������
	SkillData2					600	  580	  560	  540	  520	  500	  480	  460	  440	  420 // ���� ����ġ
return

SetSkill GN_SLINGITEM //���� ������(SKID_GN_SLINGITEM)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // �Ӽ�����
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						 4 // SP�Ҹ�
	SkillRange					11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  1000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0 // ��ų����� ��ü��ų�������ð�
return

SetSkill GN_SLINGITEM_RANGEMELEEATK //���� ������ ���Ÿ���������(SKID_GN_SLINGITEM_RANGEMELEEATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER
	SkillProperty	PROPERTY_Nothing    // �Ӽ�����	
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��		
	SkillSP						 0 // SP�Ҹ�
	SkillRange					11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0 // ��ų����� ��ü��ų�������ð�
return





//����
SetSkill SR_DRAGONCOMBO //�ַ氢(SKID_SR_DRAGONCOMBO)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						 3		4		5		6		7		8		9	   10	   11	   12 // SP�Ҹ�
	SkillCastFixedDelay          0		0		0		0		0		0		0		0		0		0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0		0		0		0		0		0		0		0		0		0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0		0		0		0		0		0		0		0		0		0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0		0		0		0		0		0		0		0		0		0 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 20	    30		40		50		60		70		80		90	   100	   110 // ����Ȯ��(%)
return

SetSkill SR_SKYNETBLOW //õ������(SKID_SR_SKYNETBLOW)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						 8		 9		10		11		12
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500	   500	   500	   500	   500 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 2		 2		 2		 2		 2 // ���� 5*5
	SkillData2					 5		 5		 5		 5		 5 // Ÿ��Ƚ��
return

SetSkill SR_EARTHSHAKER //������(SKID_SR_EARTHSHAKER)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						36		40		44		48		52 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  3000	  3000	  3000	  3000	  3000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 1		 2		 3		 4		 5 // ���� 11*11	
	SkillData2				  1000    2000    2000    3000    3000 // ���ݼ����� Ÿ�� ���� �ɸ��� �ð�
	SkillData3				   300     350     400     450     500 // ���ݼ����� Ÿ�� ���� Ȯ��(õ�з�)
return

SetSkill SR_RAMPAGEBLASTER //�����ź(SKID_SR_RAMPAGEBLASTER)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP					   150	   150	   150	   150	   150 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 3		 3		 3		 3		 3 // ���� 7*7
return

SetSkill SR_KNUCKLEARROW //�����ź(SKID_SR_KNUCKLEARROW)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK	
	SkillSP					    10		15		20		25		30 // SP�Ҹ�
	SkillRange					 7		 8		 9		10		11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1					 2		 3		 4		 5		 6 // �˹� �Ÿ�
return

SetSkill SR_FALLENEMPIRE // ��������(SKID_SR_FALLENEMPIRE)
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						20		30		40		50		60 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	     0	     0	     0	     0	     0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�
	SkillData1				   500	  1000	  1500    2000	  2500 // �����ð�
return

SetSkill SR_TIGERCANNON //ȣ��(SKID_SR_TIGERCANNON)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK	
	SkillSP						 1		1		1		1		1		1		1	    1	    1	    1 // SP�Ҹ�(0�϶� �������ϵ��� ���Ǽ���)
	SkillRange					 1		1		1		1		1		1		1		1		1		1 // ��ų �����Ÿ�
	SkillCastFixedDelay          0		0		0		0		0		0		0		0		0		0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1100	 1200	 1300	 1400	 1500	 1600	 1700	 1800	 1900	 2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					12     14	   16	   18	   20	   22	   24	   26	   28	   30 // ��ų ���� �Ҹ�Ǵ� HP %
	SkillData2					 6		7		8		9	   10	   11	   12	   13	   14	   15 // ��ų ���� �Ҹ�Ǵ� SP %
	SkillData3					 1		1		1		1		1		2		2		2		2		2 // ���� 7*7
return

SetSkill SR_GATEOFHELL //������Ȳ��(SKID_SR_GATEOFHELL)
OnInit:
	SkillMaxLv		10
	SkillType		TOCHARACTER
	SkillFlag		SKFLAG_NODISPEL
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange					 1		2		3		3		4		4		5		5		6		7 // ��ų �����Ÿ�
	SkillSP						11	   12	   13	   14	   15	   16	   17	   18	   19	   20 // SP�Ҹ�(0�϶� ������� ���ϵ��� ���Ǽ���)
	SkillCastFixedDelay          0	    0	    0	    0	    0	    0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	 1200	 1400	 1600	 1800	 2000	 2200	 2400	 2600	 2800 // ��ų ĳ���� ���ݿ� ����޴� delay��
//	SkillSinglePostDelay	  5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000	 5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       100	  200	  300	  400	  500	  600	  700	  800	  900	 1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					12	   14	   16	   18	   20	   22	   24	   26      28	   30 // ���������� FACTOR 		
return

SetSkill SR_CRESCENTELBOW //�ļ���(SKID_SR_CRESCENTELBOW)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						80		80		80		80		80 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				  3000    4000    5000    6000    7000 // ���ӽð�	
	SkillData2				    55      60      65      70      75 // �ߵ�Ȯ��
return

SetSkill SR_CRESCENTELBOW_AUTOSPELL //�ļ���-��Ʈ����(SKID_SR_CRESCENTELBOW_AUTOSPELL)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK	
	SkillData1				   200     400     600     800    1000 // �˹�� �߰� ������(%)
return

SetSkill SR_WINDMILL //��ǳ��(SKID_SR_WINDMILL)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillSP						45
	SkillCastFixedDelay          0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000  // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  3000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay       500 // ��ų����� ��ü��ų�������ð�
	SkillData1					 2 // ���� 5*5
return


SetSkill SR_CURSEDCIRCLE //�ֹ���(SKID_SR_CURSEDCIRCLE)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						40		60		80	   100	   120 // SP�Ҹ�	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 1		 2		 3		 4		 5 // HP�Ҹ�(%)
	SkillData2					 1		 1		 2		 2		 3 // ���� 5*5 
	SkillData3				  3000	  4000	  5000	  6000	  7000 // ���ӽð�
return

SetSkill SR_LIGHTNINGWALK //������(SKID_SR_LIGHTNINGWALK)
OnInit:
	SkillMaxLv	5
	SkillType	TOME
	SkillSP						80		70		60		50		40 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000	  5000	  5000	  5000	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay	  1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�		
	SkillData1					45		50		55		60		65 // �ߵ�Ȯ��(%)
	SkillData2				  5000	  6000	  7000	  8000	  9000 // ȿ�� ���� �ð�

return

SetSkill SR_RAISINGDRAGON // ����õ(SKID_SR_RAISINGDRAGON)
OnInit:
	SkillMaxLv		10
	SkillType		TOME
	SkillSP					   120	  120	  120	  120	  120	  120	  120	  120	  120	  120 // SP�Ҹ�
	SkillCastFixedDelay          0	    0		0		0		0		0		0		0		0		0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0		0		0		0		0		0		0		0		0		0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 30000	30000	30000	30000	30000	30000	30000	30000	30000	30000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000	 1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				 30000	45000	60000	75000	90000  105000  120000  135000  150000  165000 // ���ӽð�
	SkillData2					 1		2		3	    4	    5	    6	    7	    8	   9	   10 // �߰��Ŵ� �ִ�ⱸü����(������ ��⿡ ���Ѱ��� �߰��Ŵ°�)
	SkillData3					 3		4		5		6		7		8		9	   10	   11	   12 // HP / SP ����(%)	
return

SetSkill SR_GENTLETOUCH_QUIET //����-��(SKID_SR_GENTLETOUCH_QUIET)
OnInit:
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillRange					 2		 2		 2		 2		 2 // �����Ÿ�
	SkillSP						20		25		30		35		40 // SP�Ҹ�
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  1000	  1500	  2000	  2500	  3000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0		 0		 0		 0		 0 // ��ų����� ��ü��ų�������ð�
	SkillData1				  5000    7000    9000   11000   13000 // ħ�� ���ӽð�
return


SetSkill SR_GENTLETOUCH_CURE //����-��(SKID_SR_GENTLETOUCH_CURE)
OnInit:
	SkillMaxLv		5
	SkillType		TOALL				// �ڽ��� ������ ��� �ɸ������� 
	SkillRange					 2		 2		 2		 2		 2 // �����Ÿ�
	SkillSP						40		50		60		70		80 // SP�Ҹ�	
	SkillCastFixedDelay          0	     0	     0	     0	     0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		     0	     0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  1000	  1500	  2000    2500    3000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�	
return

SetSkill SR_GENTLETOUCH_ENERGYGAIN //����-��(SKID_SR_GENTLETOUCH_ENERGYGAIN)
OnInit:
	SkillMaxLv		5
	SkillType		TOME	
	SkillSP						40		50		60		70		80 // SP�Ҹ�
	SkillCastFixedDelay       1000	  1500	  2000	  2500	  3000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0		 0		 0		 0		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1					 1		 2		 3		 4	     5 // HP�Ҹ�(%)
	SkillData2					15		20		25		30		35 // �ⱸü�� ����Ȯ��	
	SkillData3			    240000  240000  240000  240000  240000 // ���ӽð�
return

SetSkill SR_GENTLETOUCH_CHANGE //����-��(SKID_SR_GENTLETOUCH_CHANGE)
OnInit:
	SkillMaxLv 5
	SkillType TOALL
	SkillRange		     2       2       2       2	     2 // �����Ÿ�
	SkillSP			    40      50      60      70      80 // SP�Ҹ�
	SkillCastFixedDelay       1000	  1000	  1000	  1000    1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	200000  180000  160000	140000  120000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1		     1       2      3        4       5 // HP�Ҹ�(%)
	SkillData2	        240000  240000  240000  240000  240000 // ���ӽð�
return

SetSkill SR_GENTLETOUCH_REVITALIZE //����-Ȱ(SKID_SR_GENTLETOUCH_REVITALIZE)
OnInit:
	SkillMaxLv		5
	SkillType		TOALL
	SkillRange		     2	     2       2       2       2 // ��ų�����Ÿ�
	SkillSP			    40	    50	    60	    70	    80 // SP�Ҹ�
	SkillCastFixedDelay       1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	200000  180000  160000	140000 	120000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000	  1000	  1000	  1000	  1000 // ��ų����� ��ü��ų�������ð�
	SkillData1	        240000  240000  240000  240000  240000 // ���ӽð�
return

SetSkill SR_ASSIMILATEPOWER //����(SKID_SR_ASSIMILATEPOWER)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillSP						10
	SkillCastFixedDelay			 0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay			 0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  5000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay      1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1					 1 // �ⱸü �ϳ��� SP ȸ����: MSP������ ����
	SkillData2					 2 // �ݰ�(5x5)
return

SetSkill SR_POWERVELOCITY //��������(SKID_SR_POWERVELOCITY)
OnInit:
	SkillMaxLv	1
	SkillType	TOALL
	SkillRange					 3 // ��ų�����Ÿ�
	SkillSP						50 // SP�Ҹ�
	SkillCastFixedDelay        500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1500 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay		 0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0 // ��ų����� ��ü��ų�������ð�
return

SetSkill SR_HOWLINGOFLION //������(SKID_SR_HOWLINGOFLION)
OnInit:
	SkillMaxLv			5
	SkillType			TOME
	SkillPattern		SKILLPATT_DIRECTATTACK
	SkillFlag			SKFLAG_NODISPEL //ĳ���� �� �������� �Ծ ������ �ʴ´�.
	SkillSP						80		90	   100     110     120 // SP�Ҹ�
	SkillCastFixedDelay        500	   500	   500	   500	   500 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		  1000	  1000	  1000	  1000	  1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 10000	 10000	 10000	 10000	 10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0	     0	     0	     0	     0 // ��ų����� ��ü��ų�������ð�
	SkillData1					 3		 4		5		 6		 7 // ����������ݰ� 
	SkillData2					10		15		20		25		30 // �����̻�[����] ����Ȯ��(%) 
return

SetSkill SR_RIDEINLIGHTNING //����ź(SKID_SR_RIDEINLIGHTNING)
OnInit:
	SkillMaxLv			5
	SkillType			TOGROUND
	SkillPattern		SKILLPATT_DIRECTATTACK
	SkillSP			    22	  24	  26	  28	  30 // SP�Ҹ�
	SkillRange		    11	  11	  11	  11	  11 // ��ų�����Ÿ�
	SkillCastFixedDelay          0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	  1000	2000	3000	4000	5000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	  1000	1000	1000	1000	1000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay         0     0       0       0       0 // ��ų����� ��ü��ų�������ð�	
	SkillData1		     1	   1	   2	   2	   3 // ����������ݰ� 
	SkillData2                   1	   2       3	   4	   5 // �Ҹ��ϴ� �ⱸü�� ����
	SkillData3                  50	 100	 150	 200	 250 // ǳ�Ӽ����� ����� �߰� �������ݷ�(%) 
return

//�ο�����
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
	SkillData1				  50      75     100 // ����Ȯ��	
return

SetSkill LG_SHIELDPRESS
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK
	SkillSP					  10	  12      14      16      18
	SkillData1				 700     750     800     850     900 // ����Ȯ��(õ����)
	SkillSinglePostDelay	2000	2000	2000	2000	2000
return

SetSkill LG_REFLECTDAMAGE
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillSP				        60		80     100     120     140
	SkillData1			    300000  300000  300000  300000  300000 // ���ӽð�
	SkillData2					20		25		30		35 		40 // �ݻ絥���� %
	SkillData3					30		40		50		60      70 // 10�ʴ� �Ҹ� SP
	SkillData4					40		50		60		70		80 // �ݻ�Ȯ��
	SkillData5					30		35		40		45		50 // ���� Ƚ���� ������ ������ ȿ�� ����
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
	SkillData1			     7	     9	    11	    13	    15 // �ⱸü �ִ� ����	
	SkillData2			    20      16      12       8       4 // 10�ʴ� �Ҹ� SP
	SkillData3			    20      32      44      56      68 // �ⱸü ȹ�� ����, �������� ������ ��% Ȯ���� ��°�
	
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
	SkillData1		   300000  300000  300000  300000  300000 // ȿ�����ӽð�
	SkillData2			   50	   40	   30	   20	   10 // ĳ������ �̵��ӵ�����
return

SetSkill LG_OVERBRAND
OnInit:
	SkillMaxLv 5
	SkillType TOGROUND
	SkillPattern SKILLPATT_DIRECTATTACK	
	SkillSP				   20	   30	   40	   50	   60
	SkillCastStatDelay    500     500     500     500     500
	SkillGlobalPostDelay 2000    2000    2000    2000    2000
	SkillData1			    3       4       5       6       7 // �˹�
return

SetSkill LG_OVERBRAND_BRANDISH
OnInit:
	SkillMaxLv 5
	SkillType TOGROUND
	SkillPattern SKILLPATT_DIRECTATTACK	
	SkillData1			    3       4       5       6       7 // �˹�
return

SetSkill LG_OVERBRAND_PLUSATK
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK	
	SkillData1			    3       4       5       6       7 // �˹�
return

SetSkill LG_PRESTIGE
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillCastFixedDelay	 2000	 2000	 2000	 2000    2000
	SkillCastStatDelay   1000    1000    1000    1000    1000
	SkillSinglePostDelay 60000  60000   60000   60000   60000
	SkillSP                75      80      85      90      95
	SkillData1          30000   45000   60000   75000   90000 // ���ӽð�
return

SetSkill LG_BANDING
OnInit:
	SkillMaxLv 5
	SkillType TOME
	SkillSP				   30	   36	   42	   48	   54
	SkillData1			    6	    5	    4	    3	    2 // 5�ʴ� SP �Ҹ�
	SkillData2	           20	   30	   40	   50	   60 // �ο��� ���ݷ� ����
	SkillData3	            6	    7       8       9      10 // �ο��� ���� ����
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
	SkillData2			   40	   48	   56	   64	   72 // ������
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
	SkillData1			    3	    6	    9	   12	   15 //MHP �Ҹ�%
	SkillData2			    5		5		5		5		5 //11*11	
return

SetSkill LG_PIETY
OnInit:
	SkillMaxLv 5
	SkillType TOALL
	SkillSP				   40	   45	   50	   55	   60
	SkillCastStatDelay   3000	 2500	 2000	 1500	 1000
	SkillData1		    60000   80000  100000  120000  140000 // ȿ�� ���ӽð�
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
	SkillData2				5		5		5		5		5 // ��ŸȽ��
	SkillData3			   25	   25	   25	   25	   25 // ��������, ���� �϶� Percent
	SkillData4			 3000	 6000	 9000	12000	15000 // ��������, ���� �϶� ���ӽð�
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
	SkillData1			   30	   25	   20	   15	   10 //5�ʴ� HP �Ҹ� õ�з�
	SkillData2			   40	   35	   30	   25	   20 //5�ʴ� SP �Ҹ� õ�з�
	SkillData3			30000   45000	60000	75000	90000 // ���ӽð�
return

//__THIRDJOB2 ********************************************************************************* */















// ����(elemental)�� ��ų
SetSkill EL_CIRCLE_OF_FIRE //��Ŭ ���� ���̾�(EL_CIRCLE_OF_FIRE)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillProperty	PROPERTY_Fire
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillAtkPer		300
	SkillSP         40    // SP�Ҹ�
	SkillData1		60000 // ȿ�����ӽð�	
	SkillData2		5	  // �ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_FIRE_CLOAK // ���̾� Ŭ��(SKID_EL_FIRE_CLOAK)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE
	SkillSP         60   // SP�Ҹ�
	SkillData1		60000 // ȿ�����ӽð�	
	SkillData2		5	  // �ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_FIRE_MANTLE //���̾� ��Ʋ(SKID_EL_FIRE_MANTLE)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Fire         //ȭ�Ӽ�
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillSP         80   // SP�Ҹ�
	SkillAtkPer		1000
return


SetSkill EL_WATER_SCREEN //���� ��ũ��(SKID_EL_WATER_SCREEN)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         40   // SP�Ҹ�
	SkillData1		60000 // ȿ�����ӽð�	
	SkillData2		5	  // �ʴ� �Ҹ�Ǵ� SP ��	
return


SetSkill EL_WATER_DROP //���� ���(SKID_EL_WATER_DROP)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         60   // SP�Ҹ�
	SkillData1		60000 // ȿ�����ӽð�	
	SkillData2		5	  // �ʴ� �Ҹ�Ǵ� SP ��	
return


SetSkill EL_WATER_BARRIER //���� ������(SKID_EL_WATER_BARRIER)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         80				  // SP�Ҹ�
	SkillData1		15000			  // ȿ�����ӽð�	
return


SetSkill EL_WIND_STEP //���� ����(SKID_EL_WIND_STEP)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         40   // SP�Ҹ�
	SkillData1		60000 // ȿ�����ӽð�	
	SkillData2		5	  // �ʴ� �Ҹ�Ǵ� SP ��	
return


SetSkill EL_WIND_CURTAIN //���� Ŀư(SKID_EL_WIND_CURTAIN)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         60   // SP�Ҹ�
	SkillData1		60000 // ȿ�����ӽð�	
	SkillData2		5	  // �ʴ� �Ҹ�Ǵ� SP ��	
return



SetSkill EL_ZEPHYR //���Ǹ�(SKID_EL_ZEPHYR)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         80   // SP�Ҹ�
	SkillData1		15000			  // ȿ�����ӽð�	
return

SetSkill EL_SOLID_SKIN //�ָ��� ��Ų(SKID_EL_SOLID_SKIN)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         40				  // SP�Ҹ�
	SkillData1		60000			  // ȿ�����ӽð�	
	SkillData2		5	  // �ʴ� �Ҹ�Ǵ� SP ��	
return


SetSkill EL_STONE_SHIELD //���� ����(SKID_EL_STONE_SHIELD)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         60				  // SP�Ҹ�
	SkillData1		60000			  // ȿ�����ӽð�	
	SkillData2		5				  // �ʴ� �Ҹ�Ǵ� SP ��	
return


SetSkill EL_POWER_OF_GAIA //�Ŀ� ���� ���̾�(SKID_EL_POWER_OF_GAIA)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         80				  // SP�Ҹ�
	SkillData1		15000			  // ȿ�����ӽð�	
return

SetSkill EL_PYROTECHNIC // ���̷���ũ��(SKID_EL_PYROTECHNIC)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		10				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_HEATER // ����(SKID_EL_HEATER)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		20				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_TROPIC // Ʈ����(SKID_EL_TROPIC)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		30				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_AQUAPLAY //������÷���(SKID_EL_AQUAPLAY)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		10				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_COOLER //��(SKID_EL_COOLER)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		20				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_CHILLY_AIR //ĥ�� ����(SKID_EL_CHILLY_AIR)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		30				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_GUST //�Ž�Ʈ(SKID_EL_GUST)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		10				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_BLAST //����Ʈ(SKID_EL_BLAST)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		20				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_WILD_STORM //���ϵ� ����(SKID_EL_WILD_STORM)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		30				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_PETROLOGY //��Ʈ�ѷ���(SKID_EL_PETROLOGY)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		10				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_CURSED_SOIL //Ŀ��� ����(SKID_EL_CURSED_SOIL)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		20				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_UPHEAVAL //������(SKID_EL_UPHEAVAL)
OnInit:
	SkillMaxLv		1
	SkillType		TOME	
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillPattern	SKILLPATT_NONE    // ���ݽ�ų�ƴ�	
	SkillSP         0				  // SP�Ҹ�
	SkillData1		300000			  // ȿ�����ӽð�	
	SkillData2		30				  // 10�ʴ� �Ҹ�Ǵ� SP ��	
return

SetSkill EL_FIRE_ARROW //���̾� �ַο�(SKID_EL_FIRE_ARROW)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������	
	SkillProperty	PROPERTY_Fire  // ȭ�Ӽ�	
	SkillSP         40	// SP�Ҹ�
	SkillAtkPer		300 // ���ݵ�����������(%)
	SkillRange      6   // ��ų�����Ÿ�	
return

SetSkill EL_FIRE_BOMB // ���̾� ��(SKID_EL_FIRE_BOMB)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������	
	SkillProperty	PROPERTY_Fire  // ȭ�Ӽ�	
	SkillSP         60	// SP�Ҹ�
	SkillAtkPer		500 // ���ݵ�����������(%)
	SkillRange      6   // ��ų�����Ÿ�	
return

SetSkill EL_FIRE_BOMB_ATK // ���̾� ��(SKID_EL_FIRE_BOMB_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��	
	SkillProperty	PROPERTY_Fire  // ȭ�Ӽ�
	SkillAtkPer		300 // ���ݵ�����������(%)
	SkillRange      6   // ��ų�����Ÿ�	
return

SetSkill EL_FIRE_WAVE // ���̾� ���̺�(SKID_EL_FIRE_WAVE)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������	
	SkillProperty	PROPERTY_Fire  // ȭ�Ӽ�	
	SkillSP         80	// SP�Ҹ�
	SkillAtkPer		1200 // ���ݵ�����������(%)
	SkillRange      6   // ��ų�����Ÿ�	
return

SetSkill EL_FIRE_WAVE_ATK // ���̾� ���̺�(SKID_EL_FIRE_WAVE_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��	
	SkillProperty	PROPERTY_Fire  // ȭ�Ӽ�
	SkillAtkPer		600 // ���ݵ�����������(%)
	SkillRange      6   // ��ų�����Ÿ�	
return

SetSkill EL_ICE_NEEDLE // ���̽� �ϵ�(SKID_EL_ICE_NEEDLE)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������	
	SkillProperty	PROPERTY_Water //���Ӽ�
	SkillSP         40	// SP�Ҹ�
	SkillAtkPer		500 // ���ݵ�����������(%)
	SkillRange      9   // ��ų�����Ÿ�	
return

SetSkill EL_WATER_SCREW // ���� ��ũ��(SKID_EL_WATER_SCREW)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������	
	SkillProperty	PROPERTY_Water //���Ӽ�
	SkillSP         60	// SP�Ҹ�
	SkillAtkPer		1000 // ���ݵ�����������(%)
	SkillRange      9   // ��ų�����Ÿ�	
return

SetSkill EL_WATER_SCREW_ATK // ���� ��ũ��(SKID_EL_WATER_SCREW_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillProperty	PROPERTY_Water //���Ӽ�
	SkillAtkPer		1000 // ���ݵ�����������(%)
	SkillRange      9   // ��ų�����Ÿ�	
return

SetSkill EL_TIDAL_WEAPON // Ÿ�̴� ����(SKID_EL_TIDAL_WEAPON)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��	
	SkillProperty	PROPERTY_Water //���Ӽ�
	SkillSP         80	// SP�Ҹ�
	SkillAtkPer		1500 // ���ݵ�����������(%)
	SkillRange      9   // ��ų�����Ÿ�	
return

SetSkill EL_WIND_SLASH // ���� ������(SKID_EL_WIND_SLASH)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��	
	SkillProperty   PROPERTY_Wind //ǳ�Ӽ�
	SkillSP         40	// SP�Ҹ�
	SkillAtkPer		200 // ���ݵ�����������(%)
	SkillRange      11  // ��ų�����Ÿ�	
return

SetSkill EL_HURRICANE // �㸮���� ������(SKID_EL_HURRICANE)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��	
	SkillProperty   PROPERTY_Wind //ǳ�Ӽ�
	SkillSP         60	// SP�Ҹ�
	SkillAtkPer		700 // ���ݵ�����������(%)
	SkillRange      11  // ��ų�����Ÿ�	
return

SetSkill EL_HURRICANE_ATK // �㸮���� ������(SKID_EL_HURRICANE_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillProperty   PROPERTY_Wind //ǳ�Ӽ�
	SkillAtkPer		500 // ���ݵ�����������(%)
	SkillRange      7  // ��ų�����Ÿ�
return

SetSkill EL_TYPOON_MIS // Ÿ��Ǭ �̻���(SKID_EL_TYPOON_MIS)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��	
	SkillProperty   PROPERTY_Wind //ǳ�Ӽ�
	SkillSP         80	// SP�Ҹ�
	SkillAtkPer		1000 // ���ݵ�����������(%)
	SkillRange      11  // ��ų�����Ÿ�	
return

SetSkill EL_TYPOON_MIS_ATK // Ÿ��Ǭ �̻���(SKID_EL_TYPOON_MIS_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillProperty   PROPERTY_Wind //ǳ�Ӽ�
	SkillAtkPer		1200 // ���ݵ�����������(%)
	SkillRange      11  // ��ų�����Ÿ�	
return

SetSkill EL_STONE_HAMMER // ���� �ظ�(SKID_EL_STONE_HAMMER)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��	
	SkillProperty	PROPERTY_Ground //���Ӽ�
	SkillSP         40	// SP�Ҹ�
	SkillAtkPer		500 // ���ݵ�����������(%)
	SkillRange      5  // ��ų�����Ÿ�	
return

SetSkill EL_ROCK_CRUSHER // �� ũ����(SKID_EL_ROCK_CRUSHER)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��	
	SkillProperty	PROPERTY_Ground //���Ӽ�
	SkillSP         60	// SP�Ҹ�
	SkillAtkPer		800 // ���ݵ�����������(%)
	SkillRange      3  // ��ų�����Ÿ�	
return

SetSkill EL_ROCK_CRUSHER_ATK // �� ũ����(SKID_EL_ROCK_CRUSHER_ATK)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillProperty	PROPERTY_Ground //���Ӽ�
	SkillAtkPer		300 // ���ݵ�����������(%)
	SkillRange      5  // ��ų�����Ÿ�	
return

SetSkill EL_STONE_RAIN //���� ����(SKID_EL_STONE_RAIN)
OnInit:
	SkillMaxLv		1
	SkillType		TOCHARACTER //�÷��̾�&����
	SkillPattern	SKILLPATT_DIRECTATTACK // ������ ���� ���� ��ųŸ��	
	SkillProperty	PROPERTY_Ground //���Ӽ�
	SkillSP         80	// SP�Ҹ�
	SkillAtkPer		300 // ���ݵ�����������(%)
	SkillRange      9  // ��ų�����Ÿ�	
return


//*---------------------------ȣ������---------------------------------------

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
	SkillData1				2158	2159	2159	2160	2160	//��ȯ���� ȣ�� ���̾�Ʈ_ȣ�� ��ÿö�_������
	SkillData2				3		3		4		4		5		//��ȯ������
	SkillData3				20000	30000	40000	50000	60000	//���ӽð�
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
	SkillData2				2300	2100	1900	1700	1500	//������ ?�ʴ� 1ȸ
	SkillData3				12000	14000	16000	18000	20000	//�̽�Ʈ ���ӽð�
	SkillData4				4000	6000	8000	10000	12000	//�������ӽð�
	SkillData5				200		300		400		500		600		//����Ȯ��(õ�з�)
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
	SkillData1				360000	420000	480000	540000	600000	//���ӽð�	
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
	SkillData3				30000	45000	60000	75000	90000	//���ӽð�	
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
	SkillData1				9000	12000	15000	18000	21000		//���ӽð�

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
	SkillData1				25		30		35		40		45		//����Ȯ��	
return

SetSkill MH_MIDNIGHT_FRENZY
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillSP					8		16		24		32		40
	SkillSinglePostDelay	2000	2000	2000	2000	2000
	SkillRange				1		1		1		1		1
	SkillData1				12		14		16		18		20		//����Ȯ��	
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
	SkillData1				3		3		3		3		3		//�˹�Ÿ�
	SkillData2				20		24		28		32		36		//����Ȯ��
return

SetSkill MH_GOLDENE_FERSE
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					60		65		70		75		80
	SkillCastStatDelay		1000	1200	1400	1600	1800
	SkillData1				20		30		40		50		60		//ȸ�������
	SkillData2				10		14		18		22		26		//���ӻ��
	SkillData3				4		6		8		10		12		//���Ӽ� �ߵ� Ȯ��
	SkillData4				30000	45000	60000	75000	90000	//���ӽð�		
return

SetSkill MH_STEINWAND
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					80		90		100		110		120
	SkillCastStatDelay		1000	1000	1000	1000	1000
	SkillData1				5		6		7		8		9		//ȸ��Ƚ��
	SkillData2				30000	45000	60000	75000	90000	//���ӽð�		
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
	SkillData1				1		1		1		1		2		//ȿ������ 3*3 ....	5*5
return

SetSkill MH_ANGRIFFS_MODUS
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					60		65		70		75		80
	SkillCastStatDelay		200		400		600		800		1000
	SkillData1				70		90		110		130		150		//ATK ���
	SkillData2				50		70		90		110		130		//DEF �϶�
	SkillData3				60		80		100		120		140		//FLEE �϶�
	SkillData4				30000	45000	60000	75000	90000	//���ӽð�
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
	SkillData1				30000	45000	60000	75000	90000	//���ӽð�
	SkillData2				3		6		9		12		15		//�ߵ�Ȯ��
	SkillData3				1		1		1		2		2		//ȿ������ 3*3, 5*5
return

SetSkill MH_GRANITIC_ARMOR
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					54		58		62		66		70
	SkillCastFixedDelay		1000	1000	1000	1000	1000
	SkillCastStatDelay		5000	4500	4000	3500	3000
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	
	SkillData1				60000	60000	60000	60000	60000	//���ӽð�
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
	SkillData1				12000	14000	16000	18000	20000	//���ӽð�
	SkillData2				1		1		2		2		3		//ȿ������ 3*3 5*5 7*7	
return

SetSkill MH_PYROCLASTIC
OnInit:
	SkillMaxLv				5
	SkillType				TOME
	SkillSP					20		28		36		44		52
	SkillCastFixedDelay		200		200		200		200		200
	SkillCastStatDelay		1000	1500	2000	2500	3000
	SkillGlobalPostDelay	1000	1000	1000	1000	1000	
	SkillData1				60000	90000	120000	150000	180000 //���ӽð�	
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

//---------------------------ȣ������---------------------------------------*/


SetSkill NPC_ASSASSINCROSS //npc�� ������ ��� ũ�ν�
OnInit:
	SkillType TOME
	SkillMaxLv 10
	SkillData1	25	30	35	40 	45	50	55	60	65	70 //���ݼӵ�����
	
return

SetSkill NPC_DISSONANCE //npc�� ����ȭ��
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillData1	40	50	60	70 	80 //�⺻������
	
return

SetSkill NPC_UGLYDANCE //npc�� ����
OnInit:
	SkillType TOME
	SkillMaxLv 5
	SkillData1	10	15	20	25 	30 //�⺻������
	
return

SetSkill MC_CARTDECORATE // īƮ�ٹ̱�(SKID_MC_CARTDECORATE)
OnInit:
	SkillMaxLv			1
	SkillType			TOME
	SkillEvent
	SkillPattern		SKILLPATT_NONE // ������ �ƴ� ��ųŸ��
	SkillSP				40 // SP�Ҹ�
	SkillData1			658188 // īƮ������(����Ʈ) �ڵ��� IsAbleChangeCart()�Լ��� �������� �̰��� �߰� �Ͽ��� �Ѵ�.
return

/////////////////////���� Ȯ�� ��ų/////////////////////////
SetSkill KO_YAMIKUMO	//�Ͽ� (���)
OnInit:
	SkillType 	TOME
	SkillMaxLv 	1
	SkillSP		10
return 

SetSkill KO_RIGHT	//������ ���� (�нú�) [KO_RIGHT] 
OnInit:
	SkillType 	PASSIVE			
	SkillMaxLv 	5
return 

SetSkill KO_LEFT
OnInit:
	SkillType 	PASSIVE			
	SkillMaxLv 	5
return 

SetSkill KO_JYUMONJIKIRI //���� ���� (�ڦ���)
OnInit:
	SkillType	TOCHARACTER
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillMaxLv 	5
	SkillRange			3	4	5	6	7 
	SkillSP				10	12	14	16	18
	SkillCastFixedDelay		0	0	0	0	0		//��ų ĳ����
	SkillCastStatDelay		0	0	0	0	0		//���� ĳ����
	SkillSinglePostDelay		5000	4500	4000	3500	3000		//��ų ��Ÿ��
	SkillGlobalPostDelay		500	500	500	500	500		//�۷ι� ��Ÿ��
return 

SetSkill KO_SETSUDAN	//��ȥ ���� (?���Ө)
OnInit:
	SkillType	TOCHARACTER
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillMaxLv 	5
	SkillRange			2	2	2	2	2 
	SkillSP				12	16	20	24	28
	SkillCastFixedDelay		0	0	0	0	0		//��ų ĳ����
	SkillCastStatDelay		0	0	0	0	0		//���� ĳ����
	SkillSinglePostDelay		3000	3000	3000	3000	3000		//��ų ��Ÿ��
	SkillGlobalPostDelay		0	0	0	0	0		//�۷ι� ��Ÿ��
return 

SetSkill KO_BAKURETSU	//���� ���� (��?����) 
OnInit:
	SkillType	TOGROUND
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillMaxLv 	5
	SkillRange			7	8	9	10	11
	SkillSP				5	6	7	8	9
	SkillCastFixedDelay		0	0	0	0	0		//��ų ĳ����
	SkillCastStatDelay	     1000    1400    1800    2200    2600		//���� ĳ����
	SkillSinglePostDelay	     3000    3000    3000    3000    3000		//��ų ��Ÿ��
	SkillGlobalPostDelay 	     1000    1000    1000    1000    1000		//�۷ι� ��Ÿ��
	SkillData1			1	1	1	1 	1 		//ȿ������
	
return 

SetSkill KO_HAPPOKUNAI	//�ȹ� ���� (��۰����)
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillRange			0	0	0	0	0
	SkillSP				12	14	16	18	20
	SkillCastFixedDelay		0	0	0	0	0		//��ų ĳ����
	SkillCastStatDelay		0	0	0	0	0		//���� ĳ����
	SkillSinglePostDelay		0	0	0	0	0		//��ų ��Ÿ��
	SkillGlobalPostDelay		500	500	500	500	500		//�۷ι� ��Ÿ��
	SkillData1			4	4	4	4 	5 		//ȿ������
return 

SetSkill	KO_MUCHANAGE	//���� ������ (�����᪲)
OnInit:
	SkillType	TOGROUND
	SkillMaxLv 	10
	SkillRange			11	11	11	11	11	11	11	11	11	11
	SkillSP				50	50	50	50	50	50	50	50	50	50
	SkillCastStatDelay		1000	1000	1000	1000	1000	1000	1000	1000	1000	1000	//���� ĳ����
	SkillSinglePostDelay		10000	10000	10000	10000	10000	10000	10000	10000	10000	10000	//��ų ��Ÿ��
	SkillData1			10000	20000	30000	40000 	50000	60000	70000	80000	90000	100000 	//���ϼҸ�
	SkillData2			1	1	1	1	1	1	1	1	1	2	//ȿ������

return 

SetSkill KO_HUUMARANKA	//ǳ�������� ��ȭ
OnInit:
	SkillType	TOGROUND
	SkillMaxLv 	5
	SkillRange		    9	   10      11      12      13 // �����Ÿ�
	SkillSP			   24	   28      32      36      40 // �Ҹ�SP
	SkillCastFixedDelay         0 	    0	    0	    0 	    0  // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	 1000 	 1200	 1400	 1600 	 1800 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	 3000	 3000	 3000	 3000	 3000  // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000	 1000	 1000	 1000	 1000  // ��ų����� ��ü��ų�������ð�
return 

SetSkill KO_MAKIBISHI	//��Ű���
OnInit:
	SkillType				TOME
	SkillMaxLv 				5	
	SkillProperty			PROPERTY_Nothing  // �Ӽ�����
	SkillSP					    9	   12      15      18      21 // �Ҹ�SP
	SkillCastFixedDelay         0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		    0	    0	    0	    0	    0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0	    0	    0	    0	    0 // ��ų����� ��ü��ų�������ð�
	SkillData1				    3       4       5       6       7 // �Ѹ� ��Ű��ð���
	SkillData2				12000   14000   16000   18000   20000 // ���ӽð�
	SkillData3				    3       4       5       6       7 // ��Ű���
return 

SetSkill KO_MEIKYOUSISUI	//�������
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillSP					  100	  100     100     100     100 // �Ҹ�SP
	SkillCastFixedDelay         0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		 3000	 3000	 3000	 3000	 3000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0	    0	    0	    0	    0 // ��ų����� ��ü��ų�������ð�
	SkillData1				10000   10000   10000   10000   10000 // ���ӽð�
return 

SetSkill KO_ZANZOU	// ȯ��-�ܿ�
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillSP					   40      44      48      52	   56 // �Ҹ�SP
	SkillCastFixedDelay         0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		    0	    0	    0	    0	    0 // ��ų ĳ���� ���ݿ� ����޴� delay��	
	SkillSinglePostDelay	30000	27000	24000	21000	18000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				27000   24000   21000   18000   15000 // ���ð����� ���ӽð�
return 


SetSkill KO_KAHU_ENTEN	////ȭ�� : ��õ
OnInit:
	SkillType	TOME
	SkillMaxLv 	1
	SkillSP			   20 // �Ҹ�SP
	SkillCastFixedDelay         0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	 2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0 // ��ų����� ��ü��ų�������ð�
return 

SetSkill KO_HYOUHU_HUBUKI ////���� : �뼳
OnInit:
	SkillType	TOME
	SkillMaxLv 	1
	SkillSP			   20 // �Ҹ�SP
	SkillCastFixedDelay         0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	 2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0 // ��ų����� ��ü��ų�������ð�
return 

SetSkill KO_KAZEHU_SEIRAN ////ǳ�� : û��
OnInit:
	SkillType	TOME
	SkillMaxLv 	1
	SkillSP			   20 // �Ҹ�SP
	SkillCastFixedDelay         0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	 2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0 // ��ų����� ��ü��ų�������ð�
return 

SetSkill KO_DOHU_KOUKAI ////��� : ����
OnInit:
	SkillType	TOME
	SkillMaxLv 	1
	SkillSP			   20 // �Ҹ�SP
	SkillCastFixedDelay         0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	 2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay	    0 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0 // ��ų����� ��ü��ų�������ð�
return 

SetSkill KO_KAIHOU ////�����ع�
OnInit:
	SkillType	TOCHARACTER
	SkillPattern 	SKILLPATT_ATTACKSPELL
	SkillMaxLv 	1
	SkillRange		   11 // �����Ÿ�
	SkillSP			   10 // �Ҹ�SP
return

SetSkill KO_ZENKAI	//��������
OnInit:
	SkillType		TOGROUND
	SkillMaxLv 		       1
	SkillGlobalPostDelay        1000 // ��ų����� ��ü��ų�������ð�
	SkillRange		   7 // �����Ÿ�
	SkillSP			      30 // �Ҹ�SP	
return


SetSkill KO_KYOUGAKU	// ȯ��-���
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP					   40      44      48      52	   56 // �Ҹ�SP
	SkillRange				    5		5       5       5       5 // �����Ÿ�
	SkillCastFixedDelay         0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		 3000    2500    2000    1500    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��	
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				12000   14000   16000   18000   20000 // ȿ�����ӽð�
	SkillData2				   50      55      60      65      70 // ����Ȯ��
return 

SetSkill KO_JYUSATSU	// ȯ��-�ֻ�
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP					   40      44      48      52	   56 // �Ҹ�SP
	SkillRange		    5	    5       5       5       5 // �����Ÿ�
	SkillCastFixedDelay         0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	 3000    2500    2000    1500    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��	
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1		 8000   10000	12000	14000	16000 // ����ð�
	SkillData2		   50      55	   60	   65	   70 // ����Ȯ��

return 


SetSkill KO_GENWAKU	// ȯ��-ȯȤ
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP					   40      44      48      52	   56 // �Ҹ�SP
	SkillRange				    5		6       7       8       9 // �����Ÿ�
	SkillCastFixedDelay         0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		 3000    2500    2000    1500    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��	
	SkillSinglePostDelay	10000	10000	10000	10000	10000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1				   50      55      60      65      70 // ����Ȯ��
return 

SetSkill KO_IZAYOI // �� ������°�� ��
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillSP					   70      75      80      85	   90 // �Ҹ�SP
	SkillCastFixedDelay         0	    0	    0	    0	    0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		    0       0       0       0       0 // ��ų ĳ���� ���ݿ� ����޴� delay��	
	SkillSinglePostDelay	60000   60000   60000   60000   60000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay        0       0       0       0       0 // ��ų����� ��ü��ų�������ð�	
	SkillData1				30000   45000   60000   75000   90000 // ���ӽð�
return 

SetSkill KG_KAGEHUMI // �׸��� ���
OnInit:
	SkillType	TOME
	SkillMaxLv 	5
	SkillSP			25      30      35      40	45 // �Ҹ�SP
	SkillData1		2        3       4       5      6 // ȿ������
	SkillData2		5000  6000    7000    8000   9000 // ���ӽð�

return 

SetSkill KG_KYOMU // �㹫�Ǳ׸���
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP			50      50      50      50	50 // �Ҹ�SP
	SkillSinglePostDelay	20000   20000   20000   20000   20000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1		10000  15000    20000   25000  30000 // ���ӽð�

return 


SetSkill KG_KAGEMUSYA // �׸��ڹ���
OnInit:
	SkillType	TOALL
	SkillMaxLv 	5
	SkillSP			60      65      70      75	80 // �Ҹ�SP
	SkillSinglePostDelay	20000   20000   20000   20000   20000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1		60000   90000  120000  150000  180000 // ���ӽð�

return 

SetSkill OB_ZANGETSU // �ϱ׷��� �ʽ´�
OnInit:
	SkillType	TOALL
	SkillMaxLv 	5
	SkillSP			60      70      80      90	100 // �Ҹ�SP
	SkillRange		   7	7       7       7       7 // �����Ÿ�
	SkillCastFixedDelay     2000	 2000	 2000	 2000	2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	1000    1500    2000    2500    3000 // ��ų ĳ���� ���ݿ� ����޴� delay��	
	SkillSinglePostDelay	30000   30000   30000   30000   30000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1		60000   75000   90000  105000  120000 // ���ӽð�

return 


SetSkill OB_OBOROGENSOU	//�帰�޺��� ȯ��
OnInit:
	SkillType	TOALL
	SkillMaxLv 	5
	SkillSP					55		60		65     70		75 // �Ҹ�SP
	SkillRange			 	 7		 7       7      7       7 // �����Ÿ�	
	SkillCastStatDelay	   1000    1000    1000    1000    1000 // ��ų ĳ���� ���ݿ� ����޴� delay��	
	SkillSinglePostDelay      15000   15000   15000   15000   15000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay   1000    1000    1000    1000    1000 // ��ų����� ��ü��ų�������ð�	
	SkillData1			  10000   15000   20000   25000   30000 // ���ӽð�
	SkillData2			  30   35   40   45   50 // �⺻������ġ

return 

SetSkill OB_AKAITSUKI // �ұ��� ���� �޺�(SKID_OB_AKAITSUKI)
OnInit:
	SkillType	TOCHARACTER
	SkillMaxLv 	5
	SkillSP					   20      30      40      50	   60 // �Ҹ�SP
	SkillRange				    7		7       7       7       7 // �����Ÿ�
	SkillCastFixedDelay      2000	 2000	 2000	 2000	 2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		 1000    1500    2000    2500    3000 // ��ų ĳ���� ���ݿ� ����޴� delay��	
	SkillSinglePostDelay	30000	30000	30000	30000	30000 // ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay     1000    1000    1000    1000    1000 // ��ų����� ��ü��ų�������ð�
	SkillData1				10000   15000   20000   25000   30000 // ���ӽð�
return
/////////////////////���� Ȯ�� ��ų  ��/////////////////////////
SetSkill	ALL_FULL_THROTTLE // Ǯ ����Ʋ (���� 3����ų)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSinglePostDelay 	3000000 3000000	3000000	3000000	3000000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	6	4	3	2	1 	// 1�ʴ� MSP�� �ۼ�Ʈ ������ �Ҹ��Ѵ�
	SkillData2	 	10000	15000	20000	25000	30000 	// �����ð�
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
	SkillData1 	1 1 1 2 2 2 3 3 4 4 // ȿ������, 3*3, 3*3, 3*3, 5*5, 5*5, 5*5, 7*7, 7*7, 9*9, 9*9
return

SetSkill RK_LUXANIMA	// �齺ų : �����ƴϸ� (SKID_RK_LUXANIMA)
	SkillMaxLv		1
	SkillType TOME
	SkillGlobalPostDelay 1000
return

SetSkill	LG_KINGS_GRACE // ���� ��ȣ(�ξⰡ�彺ų)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			200	180	160	140	120
	SkillSinglePostDelay 	100000 	90000	80000	70000	60000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	4	5	6	7	8 	//�ʴ� HP ȸ�� �ۼ�Ʈ
return

SetSkill	WL_TELEKINESIS_INTENSE	//�ڷ�Ű��ƽ ���ٽ�
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			100	150	200	250	300	
	SkillSinglePostDelay 	300000  	300000	300000	300000	300000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	60000	60000	60000	60000	60000 	// ���ӽð�
	SkillData2	 	140	180	220	260	300 	// ���Ӽ� ���� �������ݷ�����
	SkillData3	 	10	20	30	40	50 	// ����ĳ���� ����
	SkillData4	 	10	20	30	40	50 	// ���Ӽ����� �Ҹ�sp����
return

SetSkill	SO_ELEMENTAL_SHIELD
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME			
	SkillSP 		120	120	120	120	120	
	SkillSinglePostDelay 0	0	0	0	0
	SkillGlobalPostDelay 0 	0	0 	0	0
	SkillData1	  7	8	9	10	11 	// ���Ƚ��
	SkillData2	  30000	35000	40000	45000	50000 	// ���ӽð�
	SkillData3	 1800	2100	2400	2700	3000 	// �⺻ ������
return

SetSkill	AB_OFFERTORIUM	//���丣�丮��
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			30	60	90	120	150	
	SkillCastStatDelay  	5000	4000	3000	2000	1000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	130	160	190	220	250 	// �� ȸ����(100����)
	SkillData2	 	220	240	260	280	300 	// ��� ��ų ���� sp �Ҹ�(100�з�)
	SkillData3		90000	90000	90000	90000	90000	// ���� ���ӽð�	
return

SetSkill	SR_FLASHCOMBO	//��������
OnInit:
	SkillMaxLv 	5
	SkillType 		TOCHARACTER
	SkillSP 		65	65	65	65	65	
	SkillSinglePostDelay 12000  	10000	8000	6000	4000
	SkillGlobalPostDelay 1000 	1000	1000 	1000	1000
	SkillData1	  4000	4000	4000	4000	4000 	// ���ӽð�
	SkillData2	  5	5	4	4	3 	// �Ҹ� �ⱸü ��
	SkillData3	 40	60	80	100	120 	// atk����
return

SetSkill	RA_UNLIMIT // �𸮹�(��������ų)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			100	120	140	160	180
	SkillCastFixedDelay		1000	1000	1000	1000	1000
	SkillSinglePostDelay 	300000 	300000	300000	300000	300000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	150	200	250	300	350 	// ���ݷ»��(100����)

return

SetSkill WM_FRIGG_SONG
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME			
	SkillSP 		200	230	260	290	320
	SkillCastStatDelay  1000	1000	1000	1000	1000
	SkillGlobalPostDelay 2000 	2000	2000 	2000	2000
	SkillData1	  3	4	5	6	7 	// ȿ������, 11*11, 13*13, 15*15, 17*17,19*19
	SkillData2	  5	10	15	20	25 	// 10�ʴ� MHP %ȸ��
	SkillData3	 100	120	140	160	180 	//  10�ʴ� HPȸ�� ���밪
return

SetSkill	GC_DARKCROW // ���� ����(���ƾũ�ν���ų) (SKID_GC_DARKCROW)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOCHARACTER
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillAtkPer 		100 	200 	300 	400 	500
	SkillSP 			22	34	46	58	70
	SkillSinglePostDelay 	60000 	60000	60000	60000	60000
	SkillData1	  	130	160	190	220	250 	// �ٰŸ� ���������� ������

return

SetSkill	SC_ESCAPE	//��� Ż��(SKID_SC_ESCAPE )
OnInit:
	SkillMaxLv 	5
	SkillType 		TOME
	SkillSP 			30	26	22	18	14	
	SkillSinglePostDelay 	10000  	8000	6000	4000	2000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	5	6	7	8	9 	// �ݴ���⼿�̵�
return

SetSkill NC_MAGMA_ERUPTION
OnInit:
	SkillMaxLv 	5
	SkillType 		TOGROUND
	SkillFlag 		SKFLAG_NODISPEL
	SkillPattern 	SKILLPATT_DIRECTATTACK
	SkillProperty 	PROPERTY_Nothing  // �Ӽ�����
	SkillSP 		60	70	80	90	100
	SkillRange 	1	1	1	1	1
	SkillCastFixedDelay 0	0	0	0	0
	SkillCastStatDelay  1000	1000	1000	1000	1000
	SkillGlobalPostDelay 500 	500	500 	500	500
	SkillSinglePostDelay 10000	9000	8000	7000	6000
	SkillData1	  500	550	600	650	700 // ��ų������ ATK
	SkillData2	  1000	1200	1400	1600	1800 // ��ϴ����� ����������
	SkillData3	  100	200	300	400	500 // ��ȭȮ��(1000�з�)
return

SetSkill	GN_ILLUSIONDOPING // ȯ������ (���׸���ų)
OnInit:
	SkillMaxLv 	5
	SkillType 		TOCHARACTER
	SkillSP 			60	70	80	90	100	
	SkillCastFixedDelay		1000	1000	1000	1000	0
	SkillSinglePostDelay 	5000 	4000	3000	2000	1000
	SkillGlobalPostDelay 	500 	500	500 	500	500
	SkillData1	  	4	5	6	7	18 	// ���뼿
	SkillData2	 	900	800	700	650	500 	// ȯ�� �ۼ�Ʈ
return
SetSkill ECLAGE_RECALL								
OnInit:								
	SkillMaxLv 1							
	SkillSP 0							
	SkillType TOME							
	SkillCastFixedDelay  3000			// ����ĳ����				
	SkillSinglePostDelay 300000			//��ų������				
	SkillDataString			"ecl_in01.gat"		 // ���̸�		
	SkillData1			47 31			 // x, y	
return

SetSkill ALL_RAY_OF_PROTECTION  //��ȣ�� ��
OnInit:
	SkillMaxLv 1
	SkillType  TOME
return
SetSkill NPC_COMET //Ŀ��Ʈ-����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillType		TOGROUND
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillFlag		SKFLAG_APPLY_PLUSRNG //��ų�����Ÿ������ɼ�
	SkillRange                  11	    11	    11	    11	    11 // ��ų�����Ÿ�	
	SkillData1	  3000	  3500	  4000	  4500	  5000 // ����1�� MATK ����������
	SkillData2	  2500    3000    3500    4000    4500 // ����2�� MATK ����������
	SkillData3	  2000    2500    3000    3500    4000 // ����3�� MATK ����������
	SkillData4	  1500    2000    2500    3000    3500 // ����4�� MATK ����������
return



SetSkill NPC_FLAMECROSS //�÷���ũ�ν�
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillData1	  20	    40	  60	  80	  100 // ������ * atk
	SkillData2	  3000   3000    3000    3000    3000    // ���� �ð� 1/1000 ����
return


SetSkill NPC_ICEMINE //���� ����
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Nothing  // �Ӽ�����
	SkillSplash SQUARE 3 3 3 3 3	//��ų ȿ�� ����
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillData1	  20	    40	  60	  80	  100 // ������ * atk
	SkillData2	  10000   10000    10000    10000    10000    // ���� �ð� 1/1000 ����
return

SetSkill NPC_PULSESTRIKE2
OnInit:
	SkillMaxLv		1
	SkillProperty	PROPERTY_Darkness  // �Ӽ�����
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL //��������
	SkillAtkPer	200
	SkillData1	1000	//���ݽð� ��(��), 1/1000 ����
	SkillData2	3	//���� Ƚ�� 
	
return


SetSkill NPC_DANCINGBLADE // ���ߴ� Į��(������ų, ���������� NPC_DANCINGBLADE_ATK �� �Ѵ�)
OnInit:
	SkillMaxLv				1						// �ִ� ����
	SkillProperty			PROPERTY_Nothing		// ���Ӽ�
	SkillType				TOCHARACTER				// �� 1ü
	SkillPattern    		SKILLPATT_NONE			// ���ݽ�ų �ƴ�
	SkillRange				10						// ��ų�����Ÿ�
	SkillCastFixedDelay     1000					// ��ų ĳ���� ���� delay��
	SkillCastStatDelay		3500					// ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay    0						// ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay    3000					// ��ų����� ��ü��ų�������ð� 	
	SkillData1				4						// ����Ƚ��(�ٸ�Ÿ������)
return

SetSkill NPC_DANCINGBLADE_ATK // ���ߴ� Į��(�������ݽ�ų)
OnInit:
	SkillMaxLv				1						// �ִ� ����
	SkillProperty			PROPERTY_Nothing		// ���Ӽ�
	SkillType				TOCHARACTER				// �� 1ü
	SkillPattern			SKILLPATT_DIRECTATTACK	// ���� ���� ��ųŸ��
	SkillAtkPer				100						// ���ݵ�����������(%)
	SkillRange              10						// ��ų�����Ÿ�
	SkillCastFixedDelay     0						// ��ų ĳ���� ���� delay��
	SkillCastStatDelay		0						// ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay    0 						// ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay    0						// ��ų����� ��ü��ų�������ð�
return


SetSkill NPC_DARKPIERCING // ��ũ�Ǿ
OnInit:
	SkillMaxLv				1						// �ִ� ����
	SkillProperty			PROPERTY_Nothing		// ���Ӽ�
	SkillType				TOCHARACTER				// �� 1ü
	SkillPattern    		SKILLPATT_DIRECTATTACK	// ���� ���� ��ųŸ��
	SkillAtkPer				100						// ���ݵ�����������(%)
	SkillRange				3						// ��ų�����Ÿ�
	SkillCastFixedDelay     0						// ��ų ĳ���� ���� delay��
	SkillCastStatDelay		0						// ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay    2000					// ��ų����� �ش罺ų�� �����ϴµ� �ʿ��� �ð�
	SkillGlobalPostDelay    0						// ��ų����� ��ü��ų�������ð�
return

SetSkill NPC_VENOMFOG						// +����, OnUse:�ٴڽ�ų
OnInit:
	SkillProperty	PROPERTY_Poison  // ���Ӽ�
	SkillMaxLv 10
	SkillType TOME
	SkillSplash SQUARE 2 2 2 2 2 2 2 2 2 5			// 
	SkillData1              3000 3000 3000 3000 3000 3000 3000 3000 3000 3000			// �ٴڽ�ų ���ӽð�
	SkillData2             50 100 150 200 250 300 350 400 450 500 				// ��ȿ��(HEALTHHeavyPoison)
return
SetSkill NPC_JACKFROST // ���ͽ�ų(�����ν�Ʈ)
OnInit:
	SkillMaxLv		5
	SkillProperty	PROPERTY_Water // ���Ӽ�
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL // ��������
	SkillRange                 11	   11	   11	   11	   11 // ��ų�����Ÿ�
	SkillAtkPer	 1300	 1600    1900	 2200    2500
	SkillData1	    5	    6	    7       8       9 // ȿ������(�ݰ�)
	SkillData2	10000	15000	20000	25000	30000 // ���������ð�
return

SetSkill NPC_LEX_AETERNA	// ���� ���� ���׸��� (NPC_LEX_AETERNA)
OnInit:
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillData1		2	5	8	11	14	// ���� �ݰ�(5*5, 11*11, 17*17, 23*23, 29*29)
return

SetSkill NPC_REVERBERATION //���� ���� (SKID_NPC_REVERBERATION)
OnInit:
	SkillPattern		SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOME
	SkillAtkPer		600	800	1000	1200	1400
return

SetSkill NPC_WIDEWEB	//���� ��(NPC_WIDEWEB)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillData1		7		// ���� �ݰ��� 7��(15 x 15)
return

SetSkill NPC_FIRESTORM	// ȭ�� ��ǳ (NPC_FIRESTORM)
OnInit:
	SkillPattern	SKILLPATT_ATTACKSPELL
	SkillMaxLv		3
	SkillType		TOME
	SkillProperty	PROPERTY_Fire
	SkillAtkPer		300		300		300
	SkillData1		3		3		3	// ���� �ݰ��� 3�� (7 x 7)
	SkillData2		1		3		5	// ��Ʈ ��
	SkillData3		2000	2000	2000	// ȭ��ȿ�� Tick ������
return


SetSkill NPC_WIDESUCK //���� ����
OnInit:
	SkillMaxLv	1
	SkillType 		TOGROUND
	SkillData1	13	//�������
	SkillData2	15	//MHP �������
	SkillData3	3	//��� ��� �Ұ��ΰ� (1�ʴ� �����)
return

SetSkill NPC_HELLBURNING
OnInit:
	SkillMaxLv	1
	SkillType		TOME
	SkillPattern	SKILLPATT_ATTACKSPELL 	//��������
	SkillProperty	PROPERTY_Fire		//�ҼӼ�
	SkillAtkPer	1000			// ���ݵ�����������(%)
	SkillData1	3000			//���ӽð�
return



SetSkill NPC_MAXPAIN	//�ƽ�����
OnInit:
	SkillMaxLv	10
	SkillType		TOME
	SkillData1	10	20	30 	40 	50	60 	70	80	90	100	// �������� �ݻ�Ǵ� ������  ���� (�����)	
return

SetSkill ALL_NIFLHEIM_RECALL
OnInit:
	SkillMaxLv 1
	SkillSP 10
	SkillType TOME	
	SkillCastFixedDelay  1000			// ����ĳ����
	SkillSinglePostDelay 300000			//��ų������
	SkillDataString			"niflheim.gat"		 // ���̸�
	SkillData1			193 186			 // x, y
return
//�ǽ����� Ȯ�� ���� ������ ��������
SetSkill RL_RICHS_COIN	//��ġ�� ���� : (������ ���� �繰)
OnInit:
	SkillMaxLv		1
	SkillType		TOME
	SkillSP					10
	SkillSinglePostDelay 	3000
	SkillGlobalPostDelay 	1000
	SkillData1		100	// ���ϼҸ�
	SkillData2		10	// ���λ�������
return

SetSkill RL_MASS_SPIRAL  //�Ž� �����̷�
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOCHARACTER	
	SkillRange				15		15		15		15		15
	SkillSP					80		84		88		92		96
	SkillCastFixedDelay     2000	2000	2000	2000	2000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		1000	1000	1000	1000	1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	10000 	10000	10000	10000	10000
	SkillGlobalPostDelay 	1000 	1000	1000 	1000	1000
	SkillData1		1	1	1	1	1	// �Ҹ����μ�	
	SkillData2		400	500	600	700	800	// ����Ȯ��(õ����)
return


SetSkill RL_BANISHING_BUSTER  //��Ͻ� ������ 
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOCHARACTER	
	SkillRange				9		9		9		9		9
	SkillSP					55		60		65		70		75
	SkillCastFixedDelay     1000	1000	1000	1000	1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	    3000	2500	2000	1500	1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	6000 	7000	8000	9000	10000
	SkillGlobalPostDelay 	2000 	2000	2000 	2000	2000
	SkillData1		1	1	1	1	1	// �Ҹ����μ�
	SkillData2		2	2	2	2	2	// ������ ȿ�� ����
	SkillData3		1	2	3	4	5	// ���� �Ǵ� ������
return


SetSkill RL_B_TRAP  //���ε� Ʈ�� 
OnInit:	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOME		
	SkillSP					30		32		34		36		38	
	SkillCastFixedDelay     0		0		0		0		0	// ��ų ĳ���� ���� delay��
	SkillCastStatDelay		2000	1600	1200	800		400	// ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	0 		0		0		0		0
	SkillGlobalPostDelay 	2500 	2000	1500 	1000	500
	SkillData1		1		1		1		1		1		// �Ҹ����μ�
	SkillData2		10000	11000	12000	13000	14000	// �̵��ӵ����� �ð�
	SkillData3		1		2		2		3		3		// ȿ������
return



SetSkill RL_FLICKER  //�ø���
OnInit:		
	SkillMaxLv		1
	SkillType		TOME		
	SkillSP					2
	SkillCastFixedDelay     0
	SkillCastStatDelay		0
	SkillSinglePostDelay 	10000
	SkillGlobalPostDelay 	0
	SkillData1				15	//ȿ������
return

SetSkill RL_S_STORM  //���� ����
OnInit:	
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOCHARACTER		
	SkillRange				9		9		9		9		9
	SkillSP					50		55		60		65		70	
	SkillCastFixedDelay     1000	1000	1000	1000	1000	// ��ų ĳ���� ���� delay��
	SkillCastStatDelay		3000	2500	2000	1500	1000	// ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	6000    7000	8000	9000	10000
	SkillGlobalPostDelay 	2000 	2000	2000 	2000	2000
	SkillData1		3		3		3		3		3		// �Ҹ����μ�
	SkillData2		2		2		2		2		2		// ȿ������
	SkillData3		1		1		1		1		1		// �ı��Ǵ� ����	
return

SetSkill RL_E_CHAIN  //���ͳ�ü��( ���ѿ���)
OnInit:	
	SkillMaxLv		10
	SkillType		TOME
	SkillSP			            45     45	    45	    45	    45	    45	    45	    45	    45	    45
	SkillCastFixedDelay          0      0        0       0       0       0       0       0       0       0
	SkillCastStatDelay		  1000	 1000     1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000
	SkillSinglePostDelay 	     0      0        0       0       0       0       0       0       0       0  
	SkillGlobalPostDelay 	  1000	 1000     1000	  1000	  1000	  1000	  1000	  1000	  1000	  1000
	SkillData1				 45000   60000   75000   90000  105000  120000  135000  150000  165000  180000	//���ӽð�	
return

SetSkill RL_QD_SHOT  //����ο켦
OnInit:	
	SkillMaxLv		1
	SkillType		TOME
	SkillSP					5
	SkillCastFixedDelay     0
	SkillCastStatDelay		0
	SkillSinglePostDelay 	0
	SkillGlobalPostDelay 	0
	SkillData1		10		//21*21 �������	
return


SetSkill RL_C_MARKER  //ũ����Ŀ(���ǳ���)
OnInit:	
	SkillMaxLv		1
	SkillType		TOCHARACTER
	SkillRange				11
	SkillSP					10
	SkillCastFixedDelay     0
	SkillCastStatDelay		0
	SkillSinglePostDelay 	1000
	SkillGlobalPostDelay 	0
	SkillData1				1		//���μҺ�
	SkillData2				30000	//���ӽð�
	SkillData3				10		//Flee ���Ҽ�ġ
return

SetSkill RL_FIREDANCE //���̾��(������ ��)
OnInit:
	SkillMaxLv				5
	SkillType				TOME	
	SkillSP					10	10	10	10	10
	SkillGlobalPostDelay 	500	500	500	500	500
	SkillData1				3	3	3	3	3		//���� 	
	SkillData2				5	5	5	5	5		//�Ѿ˼�
	SkillData3				1	1	1	1	1		//���μҸ��
return

SetSkill RL_H_MINE // �Ͽ︵ ����(�ı��� ����)
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOCHARACTER	
	SkillRange		7	8	9	10	11
	SkillSP			45	50	55	60	65
	SkillCastFixedDelay        0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	    1000	1000	1000	1000	1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	5000 	4500	4000	3500	3000
	SkillGlobalPostDelay 	1000 	1000	1000 	1000	1000
	SkillData1		           2	   2	   2	   2	   2 // ȿ������
	SkillData2		           1	   1	   1	   1	   1 // ���μҸ𰹼�
return

SetSkill RL_P_ALTER	// �÷�Ƽ�� ����
OnInit:
	SkillMaxLv		5
	SkillType		TOME
	SkillSP			20	24	28	32	36
	SkillCastFixedDelay     0	0	0	0	0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	2000	2000	2000	2000	2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	0 	0	0	0	0
	SkillGlobalPostDelay 	0 	0	0 	0	0
	SkillData1				30000	45000	60000	75000	90000		// ���� ���ӽð�
return

SetSkill RL_FALLEN_ANGEL // �޸�����(Ÿõ��)
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillFlag SKFLAG_NODISPEL	// ĳ������ ������ �ʵ��� ����
	SkillMaxLv		5
	SkillType		TOGROUND
	SkillRange		            9	   9	   9	   9	   9
	SkillSP			           10	  10	  10	  10	  10
	SkillCastFixedDelay       500	 500	 500	 500	 500 
	SkillSinglePostDelay 	10000	8000	6000	4000	2000
	SkillGlobalPostDelay 	 3000	2500	2000	1500	1000
	SkillData1				    1      1       1       1       1 // ���μҸ𰹼�
return

SetSkill RL_R_TRIP // ���� Ʈ��
OnInit:
	SkillPattern	SKILLPATT_DIRECTATTACK
	SkillMaxLv		5
	SkillType		TOME	
	SkillSP			20	25	30	35	40
	SkillCastFixedDelay     0	0	0	0	0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	0	0	0	0	0 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	3000 	2500	2000	1500	1000
	SkillGlobalPostDelay 	1000 	1000	1000 	1000	1000
	SkillData1		3	3	4	5	6	// ȿ������
	SkillData2		3	3	3	3	3	// �˹�Ÿ�
return

SetSkill RL_R_TRIP_PLUSATK
OnInit:
	SkillMaxLv 5
	SkillType TOCHARACTER
	SkillPattern SKILLPATT_DIRECTATTACK	
return

SetSkill RL_D_TAIL // �巡�� ����(������ ����)
OnInit:
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillMaxLv				5
	SkillType				TOME	
	SkillSP					60	70	80	90	100	
	SkillCastStatDelay		1200	1400	1600	1800	2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	5000	5000	5000	5000	5000
	SkillGlobalPostDelay 	2000	2000	2000	2000	2000
	SkillData1		15		15		15		15		15	// �������

return

SetSkill RL_FIRE_RAIN	// ���̾� ����
OnInit:
	SkillPattern			SKILLPATT_DIRECTATTACK
	SkillMaxLv				5
	SkillType				TOGROUND
	SkillSP					70	70	70	70	70
	SkillCastFixedDelay        0	   0	   0	   0	   0 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay		1800	1600	1400	1200	1000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	5000    5000    5000    5000    5000
	SkillGlobalPostDelay 	1000	1000	1000	1000	1000
	SkillRange		           3	   3	   3	   3	   3
	SkillData1		           1	   1	   1       1       1 // ���μҸ𰹼�
return

SetSkill RL_HEAT_BARREL // ��Ʈ�跲(������ź)
OnInit:	
	SkillMaxLv			5
	SkillType			TOME	
	SkillSP				30	30	30	30	30
	SkillCastStatDelay		2000	2000	2000	2000	2000
	SkillSinglePostDelay 		100000	95000	90000	85000	80000
	SkillGlobalPostDelay 		1000	1000	1000	1000	1000
	SkillData1			70	65	60	55	50	// Flee - �г�Ʈ��
	SkillData2			8	10	12	14	16	// ATK+ ( �Ҹ������ΰ��� * SkillData2�� )
	SkillData3			60000	60000	60000	60000	60000	// ���ӽð�
return

SetSkill RL_AM_BLAST	//��Ƽ���͸��� ����Ʈ
OnInit:	
	SkillMaxLv		5
	SkillType		TOCHARACTER
	SkillPattern            SKILLPATT_DIRECTATTACK
	SkillRange		15	15	15	15	15
	SkillSP			80	84	88	92	96			
	SkillCastFixedDelay      1000	1000   1000	  1000	 1000 // ��ų ĳ���� ���� delay��
	SkillCastStatDelay	     2000	2000   2000	  2000	 2000 // ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	 5000  5000  5000	 5000  5000
	SkillGlobalPostDelay 	 1000	1000   1000	  1000	 1000
	SkillData1		            1	   1	  1	     1	    1 // ���μҸ�
	SkillData2				 6000   7000   8000   9000  10000 // ���ӽð�
	SkillData3		           10	  20	 30	    40	   50 // �÷��̾��� ����ȿ������
return

SetSkill RL_SLUGSHOT	//�����׼�
OnInit:	
	SkillMaxLv				5
	SkillType				TOCHARACTER
	SkillRange				9		9		9		9		9
	SkillSP					80		84		88		92		96			
	SkillCastFixedDelay     1000	1000	1000	1000	1000	// ��ų ĳ���� ���� delay��
	SkillCastStatDelay		5000	6000	7000	8000	9000	// ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	5000	5000	5000	5000	5000
	SkillGlobalPostDelay 	1000	1000	1000	1000	1000
	SkillData1				1		1		1		1		1		// ���μҸ�
	SkillData2				10		9		8		7		6		// 1���� ���߷� �϶� ��ġ
return

SetSkill RL_HAMMER_OF_GOD	//�ظӿ��갫(���Ǻг�)
OnInit:	
	SkillMaxLv				5
	SkillType				TOCHARACTER
	SkillRange				7		8		9		10		11
	SkillSP					35		40		45		50		55			
	SkillCastFixedDelay     5000	5000	5000	5000	5000	// ��ų ĳ���� ���� delay��
	SkillCastStatDelay		2000	4000	6000	8000	10000	// ��ų ĳ���� ���ݿ� ����޴� delay��
	SkillSinglePostDelay 	30000	30000	30000	30000	30000
	SkillGlobalPostDelay 	2000	2000	2000	2000	2000
	SkillData2				2		2		2		2		2		// �������
	SkillData3				3000	3000	4000	4000	5000	// �������ӽð� 1/1000��
return
//�������� ��