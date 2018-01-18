// [��1]
// Buff "EFST_BLESSING"
//	event OnStartEquip:
//		AddExtParam User VAR_ATTPOWER 3800
//		AddHPdrain 100 100
//	return
//	event OnFinishEquip:
//		SubExtParam User VAR_ATTPOWER 3800
//		SubHPdrain 100 100
//	return

// [��2]
// SetBuff "EFST_PROTECT_MDEF" 15000 1
// var value = GetBuffValue["EFST_PROTECT_DEF"]


Buff "EFST_PROTECT_DEF"		// ���� / ���� ���� ��� ����
	event OnStartEquip:
		AddAttrTolerace PROPERTY_All 3 MELEE
	return
	event OnFinishEquip:
		SubAttrTolerace PROPERTY_All 3 MELEE
	return

Buff "EFST_PROTECT_MDEF"	// ���� / ���� ���� ��� ����
	event OnStartEquip:
		AddAttrTolerace PROPERTY_All 3 MAGIC
	return
	event OnFinishEquip:
		SubAttrTolerace PROPERTY_All 3 MAGIC
	return

Buff "EFST_HEALPLUS"		// HP ȸ���� ��� ����
	event OnStartEquip:
		AddHealModifyPercent 20
	return
	event OnFinishEquip:
		SubHealModifyPercent 20
	return

Buff "EFST_S_LIFEPOTION"	// Small_Life_Potion
	event OnStartEquip:
		SetHPPercentTime Small_Life_Potion 5000 5			
	return
	event OnFinishEquip:
		ResetHPPercentTime Small_Life_Potion 5000 5
	return

Buff "EFST_L_LIFEPOTION"	// Med_Life_Potion
	event OnStartEquip:
		SetHPPercentTime Med_Life_Potion 4000 7
	return
	event OnFinishEquip:
		ResetHPPercentTime Med_Life_Potion 4000 7
	return

Buff "EFST_CRITICALPERCENT"	// ������
	event OnStartEquip:
		AddExtParam User VAR_CRITICALSUCCESSVALUE 300
	return
	event OnFinishEquip:
		SubExtParam User VAR_CRITICALSUCCESSVALUE 300
	return

Buff "EFST_PLUSAVOIDVALUE"	// ȯ���� ����
	event OnStartEquip:
		AddExtParam User VAR_PLUSAVOIDSUCCESSVALUE 200	// ����ȸ���� ����
	return
	event OnFinishEquip:
		SubExtParam User VAR_PLUSAVOIDSUCCESSVALUE 200
	return

Buff "EFST_ATKER_ASPD"		// ���������� (�����)
	event OnStartEquip:
		SetTargetAttacked_Buff 100 Target "EFST_TARGET_ASPD" 5000 1
	return
	event OnFinishEquip:
		ResetTargetAttacked_Buff 100 Target "EFST_TARGET_ASPD" 5000 1
	return

Buff "EFST_TARGET_ASPD"		// ���������� (Ÿ���� �� ���)
	event OnStartEquip:
		SubExtParam User VAR_PLUSASPDPERCENT 20
	return
	event OnFinishEquip:
		AddExtParam User VAR_PLUSASPDPERCENT 20
	return

Buff "EFST_TARGET_ASPD"		// ��Ż����
	event OnStartEquip:
		SubSPconsumption 10
		AddExtParam User VAR_MAXSPPERCENT 10
	return
	event OnFinishEquip:
		AddSPconsumption 10
		SubExtParam User VAR_MAXSPPERCENT 10
	return

Buff "EFST_ATKER_ASPD"  // PC�� �����̾� ���񽺿�1
	event OnStartEquip:
		AddExtParam User VAR_MAXHPPERCENT 5
		AddExtParam User VAR_HPACCELERATION 10
	return
	event OnFinishEquip:
		SubExtParam User VAR_MAXHPPERCENT 5
		SubExtParam User VAR_HPACCELERATION 10
	return

Buff "EFST_ATKER_MOVESPEED" // PC�� �����̾� ���񽺿�2
	event OnStartEquip:
		AddExtParam User VAR_MAXSPPERCENT 5
		AddExtParam User VAR_SPACCELERATION 10
	return
	event OnFinishEquip:
		SubExtParam User VAR_MAXSPPERCENT 5
		SubExtParam User VAR_SPACCELERATION 10
	return

/*  PC�� �����̾� ���������� ���� �ּ�ó�� ���� �߰����� ���� �κ�
Buff "EFST_ATKER_MOVESPEED"	// ��Ÿ�������� (�����)
	event OnStartEquip:
		SetTargetAttacked_Buff 100 Target "EFST_MOVESLOW_POTION" 5000 20
	return
	event OnFinishEquip:
		ResetTargetAttacked_Buff 100 Target "EFST_MOVESLOW_POTION" 5000 20
	return

Buff "EFST_ATKER_BLOOD"		// ���������� (�����)
	event OnStartEquip:
		SetTargetAttacked_Buff 50 Target "EFST_TARGET_BLOOD" 20000 20
	return
	event OnFinishEquip:
		ResetTargetAttacked_Buff 50 Target "EFST_TARGET_BLOOD" 20000 20
	return

Buff "EFST_TARGET_BLOOD"	// ���������� (Ÿ���� �� ���)
	event OnStartEquip:
		Condition HEALTHBlooding 20 1000
	return
	event OnFinishEquip:
	return
*/

Buff "EFST_ATKER_BLOOD"		// SP �Ҹ��� ���� PC��
	event OnStartEquip:
		SubSPconsumption 15
	return
	event OnFinishEquip:
		AddSPconsumption 15
	return

Buff "EFST_TARGET_BLOOD"	// 10�� ��������
	event OnStartEquip:
		AddStateTolerace BODYStun 10
		AddStateTolerace BODYFreezing 10
		AddStateTolerace BODYStoneCurse 10
		AddStateTolerace HEALTHCurse 10
		AddStateTolerace HEALTHPoison 10
		AddStateTolerace HEALTHSilence 10
		AddStateTolerace HEALTHBlind 10
		AddStateTolerace BODYSleep 10
		AddStateTolerace HEALTHBlooding 10
		AddStateTolerace HEALTHConfusion 10
	return 
	event OnFinishEquip:
		SubStateTolerace BODYStun 10
		SubStateTolerace BODYFreezing 10
		SubStateTolerace BODYStoneCurse 10
		SubStateTolerace HEALTHCurse 10
		SubStateTolerace HEALTHPoison 10
		SubStateTolerace HEALTHSilence 10
		SubStateTolerace HEALTHBlind 10
		SubStateTolerace BODYSleep 10
		SubStateTolerace HEALTHBlooding 10
		SubStateTolerace HEALTHConfusion 10
	return

Buff "EFST_STEAMPACK"	// ������(����ĵ��)
	event OnStartEquip:
		SetDisappearHPAmount "EFST_STEAMPACK" 10 100
		AddExtParam User VAR_ATTPOWER 20
		AddExtParam User VAR_PLUSASPDPERCENT 25
		Condition EFFECTEndure 9999 100
	return
	event OnFinishEquip:
		ResetDisappearHPAmount "EFST_STEAMPACK"
		SubExtParam User VAR_ATTPOWER 20
		SubExtParam User VAR_PLUSASPDPERCENT 25
		Cure EFFECTEndure 100
	return

//Ep 13.2 ������ �߰� 081217
Buff "EFST_MANU_ATK"
	event OnStartEquip:
		AddDamage_Name Target NEPENTHES 10
		AddDamage_Name Target HILLSRION 10
		AddDamage_Name Target CENTIPEDE 10
		AddDamage_Name Target CENTIPEDE_LARVA 10
		AddDamage_Name Target TATACHO 10
		AddDamage_Name Target HARDROCK_MOMMOTH 10
	return
	event OnFinishEquip:
		SubDamage_Name Target NEPENTHES 10
		SubDamage_Name Target HILLSRION 10
		SubDamage_Name Target CENTIPEDE 10
		SubDamage_Name Target CENTIPEDE_LARVA 10
		SubDamage_Name Target TATACHO 10
		SubDamage_Name Target HARDROCK_MOMMOTH 10
	return

Buff "EFST_MANU_DEF"
	event OnStartEquip:
		SubDamage_Name User NEPENTHES 10
		SubDamage_Name User HILLSRION 10
		SubDamage_Name User CENTIPEDE 10
		SubDamage_Name User CENTIPEDE_LARVA 10
		SubDamage_Name User TATACHO 10
		SubDamage_Name User HARDROCK_MOMMOTH 10
	return
	event OnFinishEquip:
		AddDamage_Name User NEPENTHES 10
		AddDamage_Name User HILLSRION 10
		AddDamage_Name User CENTIPEDE 10
		AddDamage_Name User CENTIPEDE_LARVA 10
		AddDamage_Name User TATACHO 10
		AddDamage_Name User HARDROCK_MOMMOTH 10
	return

Buff "EFST_SPL_ATK"
	event OnStartEquip:
		AddDamage_Name Target PINGUICULA 10
		AddDamage_Name Target LUCIOLA_VESPA 10
		AddDamage_Name Target CORNUS 10
		AddDamage_Name Target NAGA 10
		AddDamage_Name Target TENDRILRION 10
	return
	event OnFinishEquip:
		SubDamage_Name Target PINGUICULA 10
		SubDamage_Name Target LUCIOLA_VESPA 10
		SubDamage_Name Target CORNUS 10
		SubDamage_Name Target NAGA 10
		SubDamage_Name Target TENDRILRION 10
	return

Buff "EFST_SPL_DEF"
	event OnStartEquip:
		SubDamage_Name User PINGUICULA 10
		SubDamage_Name User LUCIOLA_VESPA 10
		SubDamage_Name User CORNUS 10
		SubDamage_Name User NAGA 10
		SubDamage_Name User TENDRILRION 10
	return
	event OnFinishEquip:
		AddDamage_Name User PINGUICULA 10
		AddDamage_Name User LUCIOLA_VESPA 10
		AddDamage_Name User CORNUS 10
		AddDamage_Name User NAGA 10
		AddDamage_Name User TENDRILRION 10
	return

Buff "EFST_MANU_MATK"
	event OnStartEquip:
		AddMDamage_Name Target NEPENTHES 10
		AddMDamage_Name Target HILLSRION 10
		AddMDamage_Name Target CENTIPEDE 10
		AddMDamage_Name Target CENTIPEDE_LARVA 10
		AddMDamage_Name Target TATACHO 10
		AddMDamage_Name Target HARDROCK_MOMMOTH 10
	return
	event OnFinishEquip:
		SubMDamage_Name Target NEPENTHES 10
		SubMDamage_Name Target HILLSRION 10
		SubMDamage_Name Target CENTIPEDE 10
		SubMDamage_Name Target CENTIPEDE_LARVA 10
		SubMDamage_Name Target TATACHO 10
		SubMDamage_Name Target HARDROCK_MOMMOTH 10
	return

Buff "EFST_SPL_MATK"
	event OnStartEquip:
		AddMDamage_Name Target PINGUICULA 10
		AddMDamage_Name Target LUCIOLA_VESPA 10
		AddMDamage_Name Target CORNUS 10
		AddMDamage_Name Target NAGA 10
		AddMDamage_Name Target TENDRILRION 10
	return
	event OnFinishEquip:
		SubMDamage_Name Target PINGUICULA 10
		SubMDamage_Name Target LUCIOLA_VESPA 10
		SubMDamage_Name Target CORNUS 10
		SubMDamage_Name Target NAGA 10
		SubMDamage_Name Target TENDRILRION 10
	return
//Ep 13.2 ������ �߰��� 081217
//ũ�������� �̺�Ʈ �߰� 081217
Buff "EFST_BUCHEDENOEL"
	event OnStartEquip:
		AddExtParam User VAR_HPACCELERATION 3
		AddExtParam User VAR_SPACCELERATION 3
		AddExtParam User VAR_HITSUCCESSVALUE 3
		AddExtParam User VAR_CRITICALSUCCESSVALUE 70
	return
	event OnFinishEquip:
		SubExtParam User VAR_HPACCELERATION 3
		SubExtParam User VAR_SPACCELERATION 3
		SubExtParam User VAR_HITSUCCESSVALUE 3
		SubExtParam User VAR_CRITICALSUCCESSVALUE 70
	return 
//ũ�������� �̺�Ʈ �߰� 081217  ��
//�� �̺�Ʈ �߰� 090114
Buff "EFST_POPECOOKIE"		
	event OnStartEquip:	
		ClassAddDamage 0 Target 3
		ClassAddDamage 1 Target 3
		ClassAddDamage 2 Target 3
		AddExtParam User VAR_MAGICATKPERCENT 3
		AddAttrTolerace PROPERTY_All 3
	return	
	event OnFinishEquip:	
		ClassSubDamage 0 Target 3
		ClassSubDamage 1 Target 3
		ClassSubDamage 2 Target 3
		SubExtParam User VAR_MAGICATKPERCENT 3
		SubAttrTolerace PROPERTY_All 3
	return	
//�� �̺�Ʈ �߰� 090114 ��

//EP Renew ���� �߰�

//20120720_���� ����		
//Buff "EFST_ASSUMPTIO2"		// �� �Ƽ��ڶ�� 
//	event OnStartEquip:	
//		ClassSubDamage 0 User 50
//		ClassSubDamage 1 User 50
//		ClassSubDamage 2 User 50
//	return	
//	event OnFinishEquip:	
//		ClassAddDamage 0 User 50
//		ClassAddDamage 1 User 50
//		ClassAddDamage 2 User 50
//	return	
			
Buff "EFST_MVPCARD_ORCHERO"	// Orc_Hero _Scroll			
	event OnStartEquip:			
		AddStateTolerace BODYStun 100		
	return			
	event OnFinishEquip:			
		SubStateTolerace BODYStun 100		
	return			
				
Buff "EFST_MVPCARD_ORCLORD"	// Orc_Load _Scroll			
	event OnStartEquip:			
		AddMeleeAttackReflect 30	
	return		
	event OnFinishEquip:		
		SubMeleeAttackReflect 30	
	return		

Buff "EFST_MORA_BUFF"  // ��� ����
	event OnStartEquip:
		SubDamage_Name User MIMIC 50
		SubDamage_Name User LITTLE_FATUM 50
		SubDamage_Name User PARUS 50
		SubDamage_Name User ANGRA_MANTIS 50
		SubDamage_Name User POM_SPIDER 50
		AddExtParam User VAR_SP 50
	return
	event OnFinishEquip:
		AddDamage_Name User MIMIC 50
		AddDamage_Name User LITTLE_FATUM 50
		AddDamage_Name User PARUS 50
		AddDamage_Name User ANGRA_MANTIS 50
		AddDamage_Name User POM_SPIDER 50
	return
	
Buff "EFST_VITALIZE_POTION" //Ȱ��ȭ����
	event OnStartEquip:
		ClassAddDamage 0 Target 2
		ClassAddDamage 1 Target 2
		ClassAddDamage 2 Target 2
		AddExtParam User VAR_MAGICATKPERCENT 2
		AddHealModifyPercent 10
	return
	event OnFinishEquip:
		ClassSubDamage 0 Target 2
		ClassSubDamage 1 Target 2
		ClassSubDamage 2 Target 2
		SubExtParam User VAR_MAGICATKPERCENT 2
		SubHealModifyPercent 10
	return

Buff "EFST_G_LIFEPOTION" // �ż��ѻ����
	event OnStartEquip:
		SetHPPercentTime Rapid_Life_Water 3000 6
	return
	event OnFinishEquip:
		ResetHPPercentTime Rapid_Life_Water 3000 6
	return

Buff "EFST_ACARAJE"		
	event OnStartEquip:	
		AddExtParam User VAR_HITSUCCESSVALUE 5
		AddExtParam User VAR_PLUSASPDPERCENT 10
	return	
	event OnFinishEquip:	
		SubExtParam User VAR_HITSUCCESSVALUE 5
		SubExtParam User VAR_PLUSASPDPERCENT 10
	return	

Buff "EFST_2011RWC" 
	event OnStartEquip:	
		AddExtParam User VAR_STRAMOUNT 3
		AddExtParam User VAR_VITAMOUNT 3
		AddExtParam User VAR_INTAMOUNT 3
		AddExtParam User VAR_DEXAMOUNT 3
		AddExtParam User VAR_AGIAMOUNT 3
		AddExtParam User VAR_LUKAMOUNT 3
		ClassAddDamage 0 Target 5
		ClassAddDamage 1 Target 5
		ClassAddDamage 2 Target 5
		AddExtParam User VAR_MAGICATKPERCENT 5
	return	
	event OnFinishEquip:	
		SubExtParam User VAR_STRAMOUNT 3
		SubExtParam User VAR_VITAMOUNT 3
		SubExtParam User VAR_INTAMOUNT 3
		SubExtParam User VAR_DEXAMOUNT 3
		SubExtParam User VAR_AGIAMOUNT 3
		SubExtParam User VAR_LUKAMOUNT 3
		ClassSubDamage 0 Target 5
		ClassSubDamage 1 Target 5
		ClassSubDamage 2 Target 5
		SubExtParam User VAR_MAGICATKPERCENT 5
	return	

Buff "EFST_MTF_ASPD" 
	event OnStartEquip:
		AddExtParam User VAR_PLUSASPD 1
		AddExtParam User VAR_HITSUCCESSVALUE 5
	return
	event OnFinishEquip:
		SubExtParam User VAR_PLUSASPD 1
		SubExtParam User VAR_HITSUCCESSVALUE 5
	return

Buff "EFST_MTF_RANGEATK" // ���ͺ���_���Ÿ�����
	event OnStartEquip:
		AddBowAttackDamage Target 25
	return
	event OnFinishEquip:
		SubBowAttackDamage Target 25
	return

Buff "EFST_MTF_MATK"
	event OnStartEquip:
	  	AddExtParam User VAR_ATTMPOWER 25
	return
	event OnFinishEquip:
		SubExtParam User VAR_ATTMPOWER 25
	return

Buff "EFST_MTF_MLEATKED"
	event OnStartEquip:
		SetAutoSpell2_MLEATKED User SM_ENDURE 5 50
		AddAttrTolerace PROPERTY_Nothing 2
	return
	event OnFinishEquip:
		SetAutoSpell2_MLEATKED User SM_ENDURE 0 0
		SubAttrTolerace PROPERTY_Nothing 2
	return

Buff "EFST_MTF_CRIDAMAGE"
	event OnStartEquip:
		AddDamage_CRI Target 5
	return
	event OnFinishEquip:
		SubDamage_CRI Target 5
	return

// EP14.1 ���� �߰�

Buff "EFST_MAGIC_CANDY"
	event OnStartEquip:
		AddExtParam User VAR_ATTMPOWER 30
		SubSFCTEquipPermill Magic_Candy 700 0
		NoDispell 1
		SetDisappearSPAmount Magic_Candy 10 90
	return
	event OnFinishEquip:
		SubExtParam User VAR_ATTMPOWER 30
		AddSFCTEquipPermill Magic_Candy 700 0
		NoDispell 0
		ResetDisappearSPAmount Magic_Candy 10 90
	return

Buff "EFST_PC_IZ_DUN05" // PC��_��������� ����ġ50%
	event OnStartEquip:
		if ((IsPremiumPcCafe == 2) | (IsPremiumPcCafe == 10) | (IsPremiumPcCafe == 65))
		if GetMapName == "iz_dun05"
			AddEXPPercent_KillRace RACE_All 50
		endif
		endif
	return
	event OnFinishEquip:
		if ((IsPremiumPcCafe == 2) | (IsPremiumPcCafe == 10) | (IsPremiumPcCafe == 65))
		if GetMapName == "iz_dun05"
			AddEXPPercent_KillRace RACE_All 50
		endif
		endif
	return

Buff "EFST_OVERLAPEXPUP" // ������ ����� ĵ
	event OnStartEquip:
		AddEXPPercent_KillRace RACE_All 100
		AddReceiveItem_Equip 20
	return
	event OnFinishEquip:
		SubEXPPercent_KillRace RACE_All 100
		SubReceiveItem_Equip 20
	return

Buff "EFST_SKF_CAST" // 2011��3��_�±�_��ũ��ĳ����Ÿ��
	event OnStartEquip:
		SubSpellCastTime 5
	return
	event OnFinishEquip:
		AddSpellCastTime 5
	return

Buff "EFST_SKF_ASPD" // 2011��3��_�±�_��ũ�����ݼӵ�
	event OnStartEquip:
		AddExtParam User VAR_PLUSASPDPERCENT 3
	return	
	event OnFinishEquip:
		SubExtParam User VAR_PLUSASPDPERCENT 3
	return

Buff "EFST_SKF_ATK" // 2011��3��_�±�_��ũ����������
	event OnStartEquip:
		AddExtParam User VAR_ATTPOWER 24
	return
	event OnFinishEquip:
		SubExtParam User VAR_ATTPOWER 24
	return

Buff "EFST_SKF_MATK" // 2011��3��_�±�_��ũ����������
	event OnStartEquip:
		AddExtParam User VAR_ATTMPOWER 24
	return
	event OnFinishEquip:
		SubExtParam User VAR_ATTMPOWER 24
	return

//20120720_���� ����		
Buff "EFST_PHI_DEMON" // 2012��8�� �ʸ��� ���� ���������		
	event OnStartEquip:	
		RaceAddDamage RACE_Demon 10
		AddMdamage_Race RACE_Demon 10
	return	
	event OnFinishEquip:	
		RaceSubDamage RACE_Demon 10
		SubMdamage_Race RACE_Demon 10
	return	


Buff "EFST_GM_BATTLE" 
	event OnStartEquip:
		ClassAddDamage 0 Target 5
		ClassAddDamage 1 Target 5
		ClassAddDamage 2 Target 5
		AddExtParam User VAR_MAGICATKPERCENT 5
		SubExtParam User VAR_MAXHPPERCENT 3
		SubExtParam User VAR_MAXSPPERCENT 3
	return
	event OnFinishEquip:
		ClassSubDamage 0 Target 5
		ClassSubDamage 1 Target 5
		ClassSubDamage 2 Target 5
		SubExtParam User VAR_MAGICATKPERCENT 5
		AddExtParam User VAR_MAXHPPERCENT 3
		AddExtParam User VAR_MAXSPPERCENT 3
	return

Buff "EFST_GM_BATTLE2"
	event OnStartEquip:
		ClassAddDamage 0 Target 10
		ClassAddDamage 1 Target 10
		ClassAddDamage 2 Target 10
		AddExtParam User VAR_MAGICATKPERCENT 10
		SubExtParam User VAR_MAXHPPERCENT 5
		SubExtParam User VAR_MAXSPPERCENT 5
	return
	event OnFinishEquip:
		ClassSubDamage 0 Target 10
		ClassSubDamage 1 Target 10
		ClassSubDamage 2 Target 10
		SubExtParam User VAR_MAGICATKPERCENT 10
		AddExtParam User VAR_MAXHPPERCENT 5
		AddExtParam User VAR_MAXSPPERCENT 5
	return

Buff "EFST_ZONGZI_POUCH_TRANS" // ���� ���ſɼ�		
	event OnStartEquip:	
		AddExtParam User VAR_STRAMOUNT 5
		AddExtParam User VAR_VITAMOUNT 5
		AddExtParam User VAR_INTAMOUNT 5
		AddExtParam User VAR_DEXAMOUNT 5
		AddExtParam User VAR_AGIAMOUNT 5
		AddExtParam User VAR_LUKAMOUNT 5
	return	
	event OnFinishEquip:	
		SubExtParam User VAR_STRAMOUNT 5
		SubExtParam User VAR_VITAMOUNT 5
		SubExtParam User VAR_INTAMOUNT 5
		SubExtParam User VAR_DEXAMOUNT 5
		SubExtParam User VAR_AGIAMOUNT 5
		SubExtParam User VAR_LUKAMOUNT 5
	return	
Buff "EFST_GLASTHEIM_ATK"	// �۷���Ʈ���Ӹ޸𸮾�_����
	event OnStartEquip:
		AddDamage_Name Target MG_CORRUPTION_ROOT 100
		AddDamage_Name Target MG_AMDARAIS 100
		SetIgnoreMdefRace RACE_Undead 100
		SetIgnoreMdefRace RACE_Demon 100
	return
	event OnFinishEquip:
		SubDamage_Name Target MG_CORRUPTION_ROOT 100
		SubDamage_Name Target MG_AMDARAIS 100
		ResetIgnoreMdefRace RACE_Undead 100
		ResetIgnoreMdefRace RACE_Demon 100
	return

Buff "EFST_GLASTHEIM_DEF"	// �۷���Ʈ���Ӹ޸𸮾�_���
	event OnStartEquip:
		SubDamage_Name User MG_AMDARAIS 100
		SubDamage_Name User MG_CORRUPTION_ROOT 100
	return
	event OnFinishEquip:
		AddDamage_Name User MG_AMDARAIS 100
		AddDamage_Name User MG_CORRUPTION_ROOT 100
	return

Buff "EFST_GLASTHEIM_HEAL"	// �۷���Ʈ���Ӹ޸𸮾�_��
	event OnStartEquip:
		AddHealValue 100
		AddHealModifyPercent 50
	return
	event OnFinishEquip:
		SubHealValue 100
		SubHealModifyPercent 50
	return

Buff "EFST_GLASTHEIM_HIDDEN"	// �۷���Ʈ���Ӹ޸𸮾�_�������
	event OnStartEquip:
		SubDamage_Name User HIDDEN_MOB_W 90
		SubDamage_Name User HIDDEN_MOB2 90
		SubDamage_Name User HIDDEN_MOB 90
	return
	event OnFinishEquip:
		AddDamage_Name User HIDDEN_MOB_W 90
		AddDamage_Name User HIDDEN_MOB2 90
		AddDamage_Name User HIDDEN_MOB 90
	return

Buff "EFST_GLASTHEIM_STATE"	// �۷���Ʈ���Ӹ޸𸮾�_�ɷ�ġ����
	event OnStartEquip:
		AddExtParam User VAR_STRAMOUNT 20
		AddExtParam User VAR_AGIAMOUNT 20
		AddExtParam User VAR_DEXAMOUNT 20
		AddExtParam User VAR_VITAMOUNT 20
		AddExtParam User VAR_INTAMOUNT 20
		AddExtParam User VAR_LUKAMOUNT 20
	return
	event OnFinishEquip:
		SubExtParam User VAR_STRAMOUNT 20
		SubExtParam User VAR_AGIAMOUNT 20
		SubExtParam User VAR_DEXAMOUNT 20
		SubExtParam User VAR_VITAMOUNT 20
		SubExtParam User VAR_INTAMOUNT 20
		SubExtParam User VAR_LUKAMOUNT 20
	return

Buff "EFST_GLASTHEIM_ITEMDEF"	// �۷���Ʈ���Ӹ޸𸮾�_�������
	event OnStartEquip:
		AddExtParam User VAR_ITEMDEFPOWER 200
		AddExtParam User VAR_MDEFPOWER 50
	return
	event OnFinishEquip:
		SubExtParam User VAR_ITEMDEFPOWER 200
		SubExtParam User VAR_MDEFPOWER 50
	return

Buff "EFST_GLASTHEIM_HPSP"	// �۷���Ʈ���Ӹ޸𸮾�_HPSP����
	event OnStartEquip:
		AddExtParam User VAR_MAXHPAMOUNT 10000
		AddExtParam User VAR_MAXSPAMOUNT 1000
	return
	event OnFinishEquip:
		SubExtParam User VAR_MAXHPAMOUNT 10000
		SubExtParam User VAR_MAXSPAMOUNT 1000
	return

//������TE
Buff "EFST_ALMIGHTY"	// �ѱ�ĳ��
	event OnStartEquip:
		AddExtParam User VAR_ATTPOWER 30
		AddExtParam User VAR_ATTMPOWER 30
	return
	event OnFinishEquip:
		SubExtParam User VAR_ATTPOWER 30
		SubExtParam User VAR_ATTMPOWER 30
	return

Buff "EFST_GVG_BLIND"	// ���������
	event OnStartEquip:
		SubExtParam User VAR_HP 3000
		AddStateTolerace HEALTHBlind 100
	return
	event OnFinishEquip:
		SubStateTolerace HEALTHBlind 100
	return
Buff "EFST_GVG_SILENCE"	// ���������
	event OnStartEquip:
		SubExtParam User VAR_HP 3000
		AddStateTolerace HEALTHSilence 100
	return
	event OnFinishEquip:
		SubStateTolerace HEALTHSilence 100
	return
	
Buff "EFST_GVG_CURSE"	// ���������
	event OnStartEquip:
		SubExtParam User VAR_HP 3000
		AddStateTolerace HEALTHCurse 100
	return
	event OnFinishEquip:
		SubStateTolerace HEALTHCurse 100
	return

Buff "EFST_GVG_SLEEP"	// ���������
	event OnStartEquip:
		SubExtParam User VAR_HP 3000
		AddStateTolerace BODYSleep 100
	return
	event OnFinishEquip:
		SubStateTolerace BODYSleep 100
	return

Buff "EFST_GVG_FREEZ"	// ���������
	event OnStartEquip:
		SubExtParam User VAR_HP 3000
		AddStateTolerace BODYFreezing 100
	return
	event OnFinishEquip:
		SubStateTolerace BODYFreezing 100
	return

Buff "EFST_GVG_STONE"	// ���������
	event OnStartEquip:
		SubExtParam User VAR_HP 3000
		AddStateTolerace BODYStoneCurse 100
	return
	event OnFinishEquip:
		SubStateTolerace BODYStoneCurse 100
	return

Buff "EFST_GVG_STUN"	// ���������
	event OnStartEquip:
		SubExtParam User VAR_HP 3000
		AddStateTolerace BODYStun 100
	return
	event OnFinishEquip:
		SubStateTolerace BODYStun 100
	return

Buff "EFST_GVG_GOLEM"	// ���������
	event OnStartEquip:
		SubExtParam User VAR_SP 300
		AddRaceTolerace RACE_Player 50
	return
	event OnFinishEquip:
		SubRaceTolerace RACE_Player 50
	return
Buff "EFST_GVG_GIANT"	// ���������
	event OnStartEquip:
		SubExtParam User VAR_HP 3000
		RaceAddDamage RACE_Player 100
		AddMdamage_Race RACE_Player 100
	return
	event OnFinishEquip:
		RaceSubDamage RACE_Player 100
		SubMdamage_Race RACE_Player 100
	return
Buff "EFST_S_HEALPOTION"		// Heal_Potion
event OnStartEquip:		
	SetHPAmountTime Heal_Potion 10000 1000	
	SetSPAmountTime Heal_Potion 10000 15	
return		
event OnFinishEquip:		
	ResetHPAmountTime Heal_Potion 10000 1000	
	ResetSPAmountTime Heal_Potion 10000 15	
return	
Buff "EFST_GEFFEN_MAGIC1"	// ���渶����ȸ ����1
	event OnStartEquip:
		RaceAddDamage RACE_Human 10
	return
	event OnFinishEquip:
		RaceSubDamage RACE_Human 10
	return
Buff "EFST_GEFFEN_MAGIC2"	// ���渶����ȸ ����2
	event OnStartEquip:
		AddMdamage_Race RACE_Human 10
	return
	event OnFinishEquip:
		SubMdamage_Race RACE_Human 10
	return
Buff "EFST_GEFFEN_MAGIC3"	// ���渶����ȸ ����3
	event OnStartEquip:
		AddRaceTolerace RACE_Human 10
	return
	event OnFinishEquip:
		SubRaceTolerace RACE_Human 10
	return
Buff "EFST_FENRIR_CARD"	// �渱ī�� ����
	event OnStartEquip:	
		AddExtParam User VAR_ATTMPOWER 25
		SubSFCTEquipPermill Fenrir_Card__ 500 0
	return	
	event OnFinishEquip:	
		SubExtParam User VAR_ATTMPOWER 25
		AddSFCTEquipPermill Fenrir_Card__ 500 0
	return
Buff "EFST_SWORDCLAN" 
	event OnStartEquip:
		AddExtParam User VAR_STRAMOUNT 1
		AddExtParam User VAR_VITAMOUNT 1
		AddExtParam User VAR_MAXHPAMOUNT 30
		AddExtParam User VAR_MAXSPAMOUNT 10
	return
	event OnFinishEquip:
		SubExtParam User VAR_STRAMOUNT 1
		SubExtParam User VAR_VITAMOUNT 1
		SubExtParam User VAR_MAXHPAMOUNT 30
		SubExtParam User VAR_MAXSPAMOUNT 10
	return
Buff "EFST_ARCWANDCLAN" 
	event OnStartEquip:
		AddExtParam User VAR_INTAMOUNT 1
		AddExtParam User VAR_DEXAMOUNT 1
		AddExtParam User VAR_MAXHPAMOUNT 30
		AddExtParam User VAR_MAXSPAMOUNT 10
	return
	event OnFinishEquip:
		SubExtParam User VAR_INTAMOUNT 1
		SubExtParam User VAR_DEXAMOUNT 1
		SubExtParam User VAR_MAXHPAMOUNT 30
		SubExtParam User VAR_MAXSPAMOUNT 10
	return

Buff "EFST_GOLDENMACECLAN" 
	event OnStartEquip:
		AddExtParam User VAR_LUKAMOUNT 1
		AddExtParam User VAR_INTAMOUNT 1
		AddExtParam User VAR_MAXHPAMOUNT 30
		AddExtParam User VAR_MAXSPAMOUNT 10
	return
	event OnFinishEquip:
		SubExtParam User VAR_LUKAMOUNT 1
		SubExtParam User VAR_INTAMOUNT 1
		SubExtParam User VAR_MAXHPAMOUNT 30
		SubExtParam User VAR_MAXSPAMOUNT 10
	return

Buff "EFST_CROSSBOWCLAN" 
	event OnStartEquip:
		AddExtParam User VAR_DEXAMOUNT 1
		AddExtParam User VAR_AGIAMOUNT 1
		AddExtParam User VAR_MAXHPAMOUNT 30
		AddExtParam User VAR_MAXSPAMOUNT 10
	return
	event OnFinishEquip:
		SubExtParam User VAR_DEXAMOUNT 1
		SubExtParam User VAR_AGIAMOUNT 1
		SubExtParam User VAR_MAXHPAMOUNT 30
		SubExtParam User VAR_MAXSPAMOUNT 10
	return

Buff "EFST_MTF_MHP" // ���ͺ���_MHP		
	event OnStartEquip:	
		AddExtParam User VAR_MAXHPAMOUNT 1000
	return	
	event OnFinishEquip:	
		SubExtParam User VAR_MAXHPAMOUNT 1000
	return	
Buff "EFST_MTF_MSP" // ���ͺ���_MSP		
	event OnStartEquip:	
		AddExtParam User VAR_MAXSPAMOUNT 100
	return	
	event OnFinishEquip:	
		SubExtParam User VAR_MAXSPAMOUNT 100
	return	
Buff "EFST_MTF_PUMPKIN" // ���ͺ���_ȣ��		
	event OnStartEquip:	
		AddHealPercent_ITEM VAR_HP Pumpkin 2000
	return	
	event OnFinishEquip:	
		SubHealPercent_ITEM VAR_HP Pumpkin 2000
	return	
Buff "EFST_MTF_HITFLEE" // ���ͺ���_����ȸ��		
	event OnStartEquip:	
		AddExtParam User VAR_AVOIDSUCCESSVALUE 20
		AddExtParam User VAR_HITSUCCESSVALUE 10
	return	
	event OnFinishEquip:	
		SubExtParam User VAR_AVOIDSUCCESSVALUE 20
		SubExtParam User VAR_HITSUCCESSVALUE 10
	return	
Buff "EFST_CHERRY_BLOSSOM_CAKE"		
	event OnStartEquip:	
		SubDamage_Size User Small 5
		SubDamage_Size User Medium 5
		SubDamage_Size User Large 5
	return	
	event OnFinishEquip:	
		AddDamage_Size User Small 5
		AddDamage_Size User Medium 5
		AddDamage_Size User Large 5
	return	

Buff "EFST_MVPCARD_TAOGUNKA"	// Ÿ����ī ��ũ��	
	event OnStartEquip:	
		AddExtParam User VAR_MAXHPPERCENT 100
		SubExtParam User VAR_MDEFPOWER 50
		SubExtParam User VAR_ITEMDEFPOWER 50
	return	
	event OnFinishEquip:	
		SubExtParam User VAR_MAXHPPERCENT 100
		AddExtParam User VAR_MDEFPOWER 50
		AddExtParam User VAR_ITEMDEFPOWER 50
	return	
		
Buff "EFST_MVPCARD_MISTRESS"	// �̽�Ʈ���� ��ũ��	
	event OnStartEquip:	
		NoJamstone 1
		AddSPconsumption 25
	return	
	event OnFinishEquip:	
		NoJamstone 0
		SubSPconsumption 25
	return	
//���� ������ ���� ȿ��				
Buff "EFST_RUNEHELM"				
	event OnStartEquip:			
	return			
	event OnFinishEquip:			
	return			
				
Buff "EFST_HELM_VERKANA"				
	event OnStartEquip:			
		ClassSubDamage 0 Target 50		
		ClassSubDamage 1 Target 50		
		ClassSubDamage 2 Target 50		
		SubRangeAttackDamage Target 50		
		SubExtParam User VAR_MAGICATKPERCENT 50		
		//�� �︧[1]�� ����ġ ���		
		var temp_ref = GetBuffValue["EFST_RUNEHELM"]		
		if temp_ref > 8		
			SetAutoSpell2_MLEATKED_Short User RK_MILLENNIUMSHIELD 1 500	
		elseif temp_ref > 6		
			SetAutoSpell2_MLEATKED_Short User RK_MILLENNIUMSHIELD 1 300	
		else		
			SetAutoSpell2_MLEATKED_Short User RK_MILLENNIUMSHIELD 1 100	
		endif		
	return			
	event OnFinishEquip:			
		ClassAddDamage 0 Target 50		
		ClassAddDamage 1 Target 50		
		ClassAddDamage 2 Target 50		
		AddRangeAttackDamage Target 50		
		ResetAutoSpell2_MLEATKED_Short User RK_MILLENNIUMSHIELD		
	return			
				
Buff "EFST_HELM_RHYDO"				
	event OnStartEquip:			
		AddNeverknockback 1		
	return			
	event OnFinishEquip:			
		SubNeverknockback 1		
	return			
				
Buff "EFST_HELM_TURISUS"				
	event OnStartEquip:			
		AddExtParam User VAR_STRAMOUNT 30		
		SubExtParam User VAR_INTAMOUNT 30		
				
	return			
	event OnFinishEquip:			
		SubExtParam User VAR_STRAMOUNT 30		
		AddExtParam User VAR_INTAMOUNT 30		
	return			
				
Buff "EFST_HELM_HAGALAS"				
	event OnStartEquip:			
		AddMeleeAttackReflect 10		
	return			
	event OnFinishEquip:			
		SubMeleeAttackReflect 10		
	return			
				
Buff "EFST_HELM_ISIA"				
	event OnStartEquip:			
		SetHPAmountTime RuneHelm 10000 500		
	return			
	event OnFinishEquip:			
		ResetHPAmountTime RuneHelm 10000 500		
	return			
				
Buff "EFST_HELM_ASIR"				
	event OnStartEquip:			
		AddExtParam User VAR_ATTPOWER 10		
		AddExtParam User VAR_PLUSASPDPERCENT 10		
	return			
	event OnFinishEquip:			
		SubExtParam User VAR_ATTPOWER 10		
		SubExtParam User VAR_PLUSASPDPERCENT 10		
	return			
				
Buff "EFST_HELM_URJ"				
	event OnStartEquip:			
		SetSPAmountTime RuneHelm 10000 40		
	return			
	event OnFinishEquip:			
		ResetSPAmountTime RuneHelm 10000 40		
	return			
Buff "EFST_PACKING_ENVELOPE1"// ����Ⱥ���1
	event OnStartEquip:
		AddExtParam User VAR_ATTPOWER 33
	return
	event OnFinishEquip:
		SubExtParam User VAR_ATTPOWER 33
	return
Buff "EFST_PACKING_ENVELOPE2"	// ����Ⱥ���2
	event OnStartEquip:
		AddExtParam User VAR_ATTMPOWER 33
	return
	event OnFinishEquip:
		SubExtParam User VAR_ATTMPOWER 33
	return
Buff "EFST_PACKING_ENVELOPE3"// ����Ⱥ���3
	event OnStartEquip:
		AddExtParam User VAR_MAXHPPERCENT 3
	return
	event OnFinishEquip:
		SubExtParam User VAR_MAXHPPERCENT 3
	return
Buff "EFST_PACKING_ENVELOPE4"// ����Ⱥ���4
	event OnStartEquip:
		AddExtParam User VAR_MAXSPPERCENT 3
	return
	event OnFinishEquip:
		SubExtParam User VAR_MAXSPPERCENT 3
	return
Buff "EFST_PACKING_ENVELOPE5"// ����Ⱥ���5
	event OnStartEquip:
		AddExtParam User VAR_AVOIDSUCCESSVALUE 33
	return
	event OnFinishEquip:
		SubExtParam User VAR_AVOIDSUCCESSVALUE 33
	return
Buff "EFST_PACKING_ENVELOPE6"// ����Ⱥ���6
	event OnStartEquip:
		AddExtParam User VAR_PLUSASPD 3
	return
	event OnFinishEquip:
		SubExtParam User VAR_PLUSASPD 3
	return
Buff "EFST_PACKING_ENVELOPE7"// ����Ⱥ���7
	event OnStartEquip:
		AddExtParam User VAR_ITEMDEFPOWER 33
	return
	event OnFinishEquip:
		SubExtParam User VAR_ITEMDEFPOWER 33
	return
Buff "EFST_PACKING_ENVELOPE8"// ����Ⱥ���8
	event OnStartEquip:
		AddExtParam User VAR_MDEFPOWER 33
	return
	event OnFinishEquip:
		SubExtParam User VAR_MDEFPOWER 33
	return
Buff "EFST_PACKING_ENVELOPE9"// ����Ⱥ���9
	event OnStartEquip:
		AddExtParam User VAR_CRITICALSUCCESSVALUE 330
	return
	event OnFinishEquip:
		SubExtParam User VAR_CRITICALSUCCESSVALUE 330
	return
Buff "EFST_PACKING_ENVELOPE10"// ����Ⱥ���10
	event OnStartEquip:
		AddExtParam User VAR_HITSUCCESSVALUE 33
	return
	event OnFinishEquip:
		SubExtParam User VAR_HITSUCCESSVALUE 33
	return
