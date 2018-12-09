package love.yi.helloword.dao;

import org.springframework.data.repository.CrudRepository;

import love.yi.helloword.bean.Demo;

public interface DemoRepository extends CrudRepository<Demo, Long> {
}