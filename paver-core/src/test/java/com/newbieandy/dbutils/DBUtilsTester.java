/*
 * Copyright (C) 2022 Andy Ma.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.newbieandy.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author andy
 * @description DBUtilsTester
 * @date 2022/6/11 20:23
 */
public class DBUtilsTester {

    private static final String DATABASE_ALL_TABLE_COMMENT_SQL = "SELECT TABLE_SCHEMA,TABLE_NAME,TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_TYPE = 'BASE TABLE'";


    @Test
    public void dbutilsTest() throws SQLException {
        Connection connection = null;
        DbUtils.loadDriver("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://rm-2zeh154ry782dfp92po.mysql.rds.aliyuncs.com:3306/test_db";
        String user = "tester";
        String password = "test_1234";
        connection = DriverManager.getConnection(url, user, password);
        String sql = "select int_val,long_val from sample1 where int_val < 4";
        QueryRunner queryRunner = new QueryRunner();
        List<TableInfo> list = queryRunner.query(connection, sql, new BeanListHandler<TableInfo>(TableInfo.class));
        System.out.println(list);
        DbUtils.close(connection);
    }

    public static class TableInfo {
        public TableInfo() {
        }

        private int int_val;
        private long long_val;

        public int getInt_val() {
            return int_val;
        }

        public void setInt_val(int int_val) {
            this.int_val = int_val;
        }

        public long getLong_val() {
            return long_val;
        }

        public void setLong_val(long long_val) {
            this.long_val = long_val;
        }
    }
}
