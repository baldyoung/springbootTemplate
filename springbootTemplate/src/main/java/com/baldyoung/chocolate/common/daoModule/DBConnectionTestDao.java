package com.baldyoung.chocolate.common.daoModule;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface DBConnectionTestDao {

    Map showDataBaseCreateSQL();
}
