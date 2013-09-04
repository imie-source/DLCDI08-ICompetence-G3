--fonction de l'appel du client
create or replace function arbo(comp_pere integer) returns varchar as $$
declare 

tab[] = null;
niveau integer = 0;

begin
execute function initarbo(comp_pere, niveau, tab[])

end;
$$ language plpgsql;





--Fonction avec tableau
create or replace function initArboTableau(comp integer, niveau integer, res_en_cours tab[])

declare

	res_en_cours := res_en_cours + niveau + comp

	cursor cursor1 is 	select num
				from competence
				where comp=competence_domaine;

	begin

	open cursor1; c
	loop;
		
		select function initArbo(comp_pk, niveau+1, res_en_cours) 

		fetch cursor1 into res_en_cours


		exit when cursor1%notfound
	end loop;

	close cursor1;

return res_en_cours

end;
$$ language plpgsql;




--Fonction avec table temporaire
create or replace function initArboTable(comp integer, niveau integer)

declare

	if(niveau == 0)
	(
	create temp table tab_res(niveau integer, pk_comp integer)
	insert into tab_res values (niveau, comp)
	)

	cursor cursor1 is 	select num
				from competence
				where comp=competence_domaine;

	begin

	open cursor1;
	loop;
		
		fetch cursor1 into tab_res
		select initArboTable(num, niveau+1)
		insert dans tab_res
		

		exit when cursor1%notfound
	end loop;

	close cursor1;

return tab_res

end;
$$ language plpgsql;