-- �������� lua ������ ���� �ۼ��ؾ� �մϴ�.
-- �� ������ �������� ���������׸���� �����մϴ�.

function main()
           -- ���� -1 �� �����Ұ�� ����Ÿ���̽��� ������ IP�� ������ �Ѱ����� �����ؾ߸��մϴ�.
           result, msg = SetZsvrID( 101 ); -- �������� ZSID �� �����Ѵ�.
           if( not result ) then return false, msg; end

           result, msg = SetCharacterCount(100); -- �ִ� ���� ��� �ο���
           if( not result ) then return false, msg; end
            
           return true, "good";
end