package com.baj.dao;

import com.baj.entity.PojoDO;
import java.util.List;

/**
 * Created by liqiang on 2017/6/16.
 */
public interface PojoDAO {

	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	PojoDO getById(Long id);

	/**
	 *
	 */
	Long insert(PojoDO pojoDO);

	Long deleteById(PojoDO pojoDO);

	boolean update(PojoDO pojoDO);

	void batchInsert(List<PojoDO> list);

	void batchUpdate(List<PojoDO> list);

	void batchDelete(List<PojoDO> list);
}
