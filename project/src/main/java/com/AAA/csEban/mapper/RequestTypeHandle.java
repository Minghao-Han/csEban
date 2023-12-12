package com.AAA.csEban.mapper;

import com.AAA.csEban.pojo.RequeseType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes({JdbcType.INTEGER})
@MappedTypes({RequeseType.class})
public class RequestTypeHandle extends BaseTypeHandler<RequeseType> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, RequeseType parameter, JdbcType jdbcType) throws SQLException {
        switch (parameter){
            case E_AbsentRequest_Type:
                ps.setInt(i, 1);
                break;
            case E_LeaveRequest_Type:
                ps.setInt(i, 2);
                break;
        }
    }

    @Override
    public RequeseType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int type = rs.getInt(columnName);
        switch (type){
            case 1:
                return RequeseType.E_AbsentRequest_Type;
            case 2:
                return RequeseType.E_LeaveRequest_Type;
        }
        return null;
    }

    @Override
    public RequeseType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public RequeseType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
