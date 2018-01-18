

--//////////////////////////////////////////////////////////////////////////////////
-- Title : Play Time LogDB MapList Configuration.
-- Date : 2012/11/20
-- Author : InGeon, Kim (Program/RO1/Gravity)
--//////////////////////////////////////////////////////////////////////////////////


--// ex. { [[MapName]], MapID }, 
PLAYTIME_LOGDB_MAPLIST = {
	--{ [[new_1-1.gat]], 1001 }, 
}



function main()

	for i, v in ipairs( PLAYTIME_LOGDB_MAPLIST ) do
	
		result, msg = SetPlayTimeMapList( v[ 1 ], v[ 2 ] );
		if( not result ) then return false, msg end
	
	end
	
	return true, "good";

end