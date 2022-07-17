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

import com.newbieandy.model.TableInfo;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
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
        DbUtils.loadDriver("com.mysql.jdbc.Driver");
        String url = "";
        String user = "";
        String password = "";
        connection = DriverManager.getConnection(url, user, password);
        String sql = "";
        ResultSetHandler<TableInfo> setHandler = rs -> {
            boolean next = rs.next();
            if (next) {
                TableInfo tableInfo = new TableInfo();
                String table_name = rs.getString("TABLE_NAME");
                String table_comment = rs.getString("TABLE_COMMENT");
                tableInfo.setTableName(table_name);
                tableInfo.setTableComment(table_comment);
                return tableInfo;
            }
            return null;
        };
        List<TableInfo> list = new QueryRunner().execute(connection, DATABASE_ALL_TABLE_COMMENT_SQL, setHandler, "mashifu");
        System.out.println(list);
        DbUtils.close(connection);
    }
}
