package ma.dph.fpp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import ma.dph.fpp.domain.facilities.RenewalsView;

public interface RenewalsViewRepository extends JpaRepository<RenewalsView, Integer> {
	
	List<RenewalsView> findByCatShortOrderByDendDesc(String catShort);
	List<RenewalsView> findTop48ByCatShortOrderByDendDesc(String catShort);
	
	
	
	@Query(value="select cat_short , \r\n" + 
			"--rtrim(cat_short)+ convert(char(10), dstart,101)+convert(char(10), dend,101) as cGroup,\r\n" + 
			"max(dstart) as dstart, \r\n" + 
			"max(dend) as dend,\r\n" + 
			"count(run_1st) as totalsent,\r\n" + 
			"count(run_2nd) as secondsent, \r\n" + 
			"count(run_3rd) as thirdsent, \r\n" + 
			"max(isnull(runby_1st,' ')) as whosent1,\r\n" + 
			"max(isnull(runby_2nd,' ')) as whosent2,\r\n" + 
			"max(isnull(runby_3rd,' ')) as whosent3,\r\n" + 
			"max(run_1st) as run_1st, \r\n" + 
			"max(run_2nd) as run_2nd, \r\n" + 
			"max(run_3rd) as run_3rd\r\n" + 
			"from renewalsfood with (nolock)\r\n" + 
			"where cat_short= :catShort\r\n" + 
			"group by  cat_short, convert(char(10), dstart, 101), convert(char(10), dend,101)\r\n" + 
			"order by dstart desc", nativeQuery = true)
	List<RenewalsView> findByCatShort(@Param("catShort") String catShort);
	

}
