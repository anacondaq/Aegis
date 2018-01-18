-- 투자 주기 시간표
TypeTBL = { Init = 0, Begin = 1, End = 2, Announce = 3 }
DayTBL  = { Sun = 0, Mon = 1, Tue = 2, Wed = 3, Thu = 4, Fri = 5, Sat = 6 }

CycleTBL = 
{
	{ TypeTBL.Init,     DayTBL.Wed, 20, 00, 00 },
	{ TypeTBL.Begin,    DayTBL.Thu, 00, 00, 00 },
	{ TypeTBL.End,      DayTBL.Sat, 12, 00, 00 },
	{ TypeTBL.Announce, DayTBL.Sat, 14, 00, 00 },
}

function main()

	for key, value in pairs(CycleTBL) do
		result, msg = LoadCycleTBL(value[1], value[2], value[3], value[4], value[5]);
		if( not result ) then return false, msg;
		end
	end
		
	return true, "success";
end