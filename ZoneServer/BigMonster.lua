-- ���� ���� �ݰ� ����

BigMonsterTable =
{
--	[ [[�г���_Ż����_ǻ����]] ] = 1,
--	[ [[������_�ζ�]] ] = 1,
--	[ [[�����̾�]] ] = 1,
--	[ [[�����]] ] = 2,
--	[ [[�屺_����]] ] = 1,
--	[ [[ȣ��_����_����]] ] =1,
--	[ [[������_��ȣ��_ī����]] ] = 1,
	[ [[�ٵ�X]] ] = 2,
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
