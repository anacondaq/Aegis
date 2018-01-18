--鼠渾婦溼 薑爾--
--陝 釭塭葆棻 僥濠陛 殖塭 luaだ橾縑 轎溘й 臢蝶お蒂 雖薑и棻
--NPC 檜葷 紫 罹晦憮 雖薑и棻
function main()
	tbl={
		[[墳墓]],--npc名稱
		[[在此結束了短暫的生命]],        --對話訊息#1
		[[死亡時間]],			--對話訊息#2
		[[送安息禮物的人]],               --對話訊息#3
		};	
		
	if not SetMobTombInfo(tbl[1],tbl[2],tbl[3],tbl[4]) then return false,tbl[1];end
	return true,"success";
end


