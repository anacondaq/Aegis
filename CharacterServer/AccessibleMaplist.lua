
-- �������� lua ������ ���� �ۼ��Ǿ�� �մϴ�.
-- �������� ����Ż��ý��ۿ��� ���Ǵ� Ż���� ����Ʈ�Դϴ�.


function main()

	-- �������̻����� �ɸ��Ͱ� ���Ǿ� �ִ°�� 
	-- �Ʒ� ���̺� �����ϴ� ������ �̵��� �����մϴ�.
	escapetbl ={ 
		{[[prontera.gat]],116,73},
		{[[payon.gat]],162,58},
		{[[geffen.gat]],121,37},
		{[[aldebaran.gat]],167,112},
		{[[morocc.gat]],157,45},
		{[[comodo.gat]],179,152},
		{[[veins.gat]],204,103},
		{[[ayothaya.gat]],218,187},
		{[[lighthalzen.gat]],159,95},
	    {[[mora.gat]],57,143},		
	};

	-- �����ʿ� �����ϴ� �ɸ��� Ż���󿡼� ���� �˴ϴ�.
	jailtbl = {
		[[sec_pri.gat]],
	};


	-- Ż��ʵ��� ����Ѵ�.
	for k,v in pairs(escapetbl) do
		result,msg = InsertEscape(v[1],v[2],v[3]);
		if( not result) then return false,msg; end		
	end	

	-- ������ ����Ѵ�.
	for k,v in pairs(jailtbl) do
		result,msg = InsertJail(v);
		if( not result) then return false,msg; end		
	end	
	
	return true,"good";
end

	