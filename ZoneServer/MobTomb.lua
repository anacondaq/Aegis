--�������� ����--
--�� ���󸶴� ���ڰ� �޶� lua���Ͽ� ����� �ؽ�Ʈ�� �����Ѵ�
--NPC �̸� �� ���⼭ �����Ѵ�
function main()
	tbl={
		[[�X��]],--npc�W��
		[[�b�������F�u�Ȫ��ͩR]],        --��ܰT��#1
		[[���`�ɶ�]],			--��ܰT��#2
		[[�e�w��§�����H]],               --��ܰT��#3
		};	
		
	if not SetMobTombInfo(tbl[1],tbl[2],tbl[3],tbl[4]) then return false,tbl[1];end
	return true,"success";
end


