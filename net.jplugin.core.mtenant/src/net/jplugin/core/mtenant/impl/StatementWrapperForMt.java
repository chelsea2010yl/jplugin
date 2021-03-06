//package net.jplugin.core.mtenant.impl;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.SQLWarning;
//import java.sql.Statement;
//
//public class StatementWrapperForMt implements Statement{
//	Statement inner;
//	private String dataSourceName;
//	public StatementWrapperForMt(String dsname, Statement s){
//		this.inner = s;
//		this.dataSourceName = dsname;
//	}
//	public ResultSet executeQuery(String sql) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.executeQuery(sql);
//	}
//	public int executeUpdate(String sql) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.executeUpdate(sql);
//	}
//	public boolean execute(String sql) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.execute(sql);
//	}
//	public void addBatch(String sql) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		inner.addBatch(sql);
//	}
//	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.executeUpdate(sql, autoGeneratedKeys);
//	}
//	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.executeUpdate(sql, columnIndexes);
//	}
//	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.executeUpdate(sql, columnNames);
//	}
//	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.execute(sql, autoGeneratedKeys);
//	}
//	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.execute(sql, columnIndexes);
//	}
//	public boolean execute(String sql, String[] columnNames) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.execute(sql, columnNames);
//	}
//	public  long executeLargeUpdate(String sql) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.executeLargeUpdate(sql);
//	}
//	public  long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.executeLargeUpdate(sql, autoGeneratedKeys);
//	}
//	public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.executeLargeUpdate(sql, columnIndexes);
//	}
//	public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
//		sql = AbstractSqlMultiTenantHanlder.handleSql(this.dataSourceName,sql,inner.getConnection());
//		return inner.executeLargeUpdate(sql, columnNames);
//	}
//	
//	//下面是用来wrapper的方法
//	public <T> T unwrap(Class<T> iface) throws SQLException {
//		return inner.unwrap(iface);
//	}
//	public boolean isWrapperFor(Class<?> iface) throws SQLException {
//		return inner.isWrapperFor(iface);
//	}
//
//	public void close() throws SQLException {
//		inner.close();
//	}
//	public int getMaxFieldSize() throws SQLException {
//		return inner.getMaxFieldSize();
//	}
//	public void setMaxFieldSize(int max) throws SQLException {
//		inner.setMaxFieldSize(max);
//	}
//	public int getMaxRows() throws SQLException {
//		return inner.getMaxRows();
//	}
//	public void setMaxRows(int max) throws SQLException {
//		inner.setMaxRows(max);
//	}
//	public void setEscapeProcessing(boolean enable) throws SQLException {
//		inner.setEscapeProcessing(enable);
//	}
//	public int getQueryTimeout() throws SQLException {
//		return inner.getQueryTimeout();
//	}
//	public void setQueryTimeout(int seconds) throws SQLException {
//		inner.setQueryTimeout(seconds);
//	}
//	public void cancel() throws SQLException {
//		inner.cancel();
//	}
//	public SQLWarning getWarnings() throws SQLException {
//		return inner.getWarnings();
//	}
//	public void clearWarnings() throws SQLException {
//		inner.clearWarnings();
//	}
//	public void setCursorName(String name) throws SQLException {
//		inner.setCursorName(name);
//	}
//
//	public ResultSet getResultSet() throws SQLException {
//		return inner.getResultSet();
//	}
//	public int getUpdateCount() throws SQLException {
//		return inner.getUpdateCount();
//	}
//	public boolean getMoreResults() throws SQLException {
//		return inner.getMoreResults();
//	}
//	public void setFetchDirection(int direction) throws SQLException {
//		inner.setFetchDirection(direction);
//	}
//	public int getFetchDirection() throws SQLException {
//		return inner.getFetchDirection();
//	}
//	public void setFetchSize(int rows) throws SQLException {
//		inner.setFetchSize(rows);
//	}
//	public int getFetchSize() throws SQLException {
//		return inner.getFetchSize();
//	}
//	public int getResultSetConcurrency() throws SQLException {
//		return inner.getResultSetConcurrency();
//	}
//	public int getResultSetType() throws SQLException {
//		return inner.getResultSetType();
//	}
//
//	public void clearBatch() throws SQLException {
//		inner.clearBatch();
//	}
//	public int[] executeBatch() throws SQLException {
//		return inner.executeBatch();
//	}
//	public Connection getConnection() throws SQLException {
//		return inner.getConnection();
//	}
//	public boolean getMoreResults(int current) throws SQLException {
//		return inner.getMoreResults(current);
//	}
//	public ResultSet getGeneratedKeys() throws SQLException {
//		return inner.getGeneratedKeys();
//	}
//
//
//
//	public int getResultSetHoldability() throws SQLException {
//		return inner.getResultSetHoldability();
//	}
//	public boolean isClosed() throws SQLException {
//		return inner.isClosed();
//	}
//	public void setPoolable(boolean poolable) throws SQLException {
//		inner.setPoolable(poolable);
//	}
//	public boolean isPoolable() throws SQLException {
//		return inner.isPoolable();
//	}
//	public void closeOnCompletion() throws SQLException {
//		inner.closeOnCompletion();
//	}
//	public boolean isCloseOnCompletion() throws SQLException {
//		return inner.isCloseOnCompletion();
//	}
//	public  long getLargeUpdateCount() throws SQLException {
//		return inner.getLargeUpdateCount();
//	}
//	public  void setLargeMaxRows(long max) throws SQLException {
//		inner.setLargeMaxRows(max);
//	}
//	public  long getLargeMaxRows() throws SQLException {
//		return inner.getLargeMaxRows();
//	}
//	public  long[] executeLargeBatch() throws SQLException {
//		return inner.executeLargeBatch();
//	}
//	
//
//}
