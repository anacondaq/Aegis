

-- �������� lua ������ ���� �ۼ��ؾ� �մϴ�.
-- �� ������ ���͵�� �������� Ư���Ѿ������� ȹ�������� ��ε�ĳ���ø޼����� �����ش�.
-- �ּ��� -- ǥ���Դϴ�.
-- ����ϴ� ���Ϳ� ������ ������ ȹ��ÿ� ����� ������, ������ ������Ʈ ī�带 ������ ����ϰ� �Ǵ���
-- '���� : ������ ����Ͽ� ������Ʈ ī�带 ȹ���Ͽ����ϴ�.' ��� ���·� ����� ������ �˴ϴ�.
-- ȹ�� ĳ���� ���� ����Ʈ�� ĳ���� ���� ���� ���� 2���� **�� ǥ�ð��Ǹ�, Ro.inf�� �����Ͽ� �̸��� ��� ǥ�õǵ���
-- ���� �����մϴ�.
-- ��� ����� �־
--	tbl={	
--		{ID,"DB NAME"},
--		{738,"���ʲ���"},
--	};
-- ��� �������� ID�� DB Name�� ������ �׸��� �����ϸ� �ȵ˴ϴ�.

--function main()
--
--	tbl={	
--		{ID,"DB NAME"},
--		{738,"���ʲ���"},
--	};
--	
--	for k,v in pairs(tbl) do
--		result,msg = InsertItem(v);
--		if( not result) then return false,msg; end		
--	end	
--	
--	return true,"����";
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

