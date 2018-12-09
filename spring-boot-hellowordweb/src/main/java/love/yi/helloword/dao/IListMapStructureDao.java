package love.yi.helloword.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IListMapStructureDao {
	List<Map<String,String>> getInfoById();
}
