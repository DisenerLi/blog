package com.baj.common.test;

import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.spring.annotation.SpringApplicationContext;

/**
 * Created by liqiang on 2017/6/20.
 */

@SpringApplicationContext({"spring-context.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring-data.xml", "classpath:spring-context.xml", "classpath:spring-mvc-context.xml"})
@Transactional(TransactionMode.COMMIT)
public abstract class AbstractTest extends UnitilsJUnit4 {

}

