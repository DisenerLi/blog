package com.baj.dao.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import javax.management.MBeanRegistration;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceMXBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by liqiang on 2017/6/16.
 */
public class DataSourcePool implements DataSource, BasicDataSourceMXBean, MBeanRegistration, AutoCloseable {
	private static final Log log = LogFactory.getLog(DataSourcePool.class);

	@Override
	public void close() throws Exception {

	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	@Override
	public ObjectName preRegister(MBeanServer server, ObjectName name) throws Exception {
		return null;
	}

	@Override
	public void postRegister(Boolean registrationDone) {

	}

	@Override
	public void preDeregister() throws Exception {

	}

	@Override
	public void postDeregister() {

	}

	@Override
	public Connection getConnection() throws SQLException {
		return null;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public boolean getAbandonedUsageTracking() {
		return false;
	}

	@Override
	public Boolean getDefaultAutoCommit() {
		return null;
	}

	@Override
	public Boolean getDefaultReadOnly() {
		return null;
	}

	@Override
	public int getDefaultTransactionIsolation() {
		return 0;
	}

	@Override
	public String getDefaultCatalog() {
		return null;
	}

	@Override
	public boolean getCacheState() {
		return false;
	}

	@Override
	public String getDriverClassName() {
		return null;
	}

	@Override
	public boolean getLifo() {
		return false;
	}

	@Override
	public int getMaxTotal() {
		return 0;
	}

	@Override
	public int getMaxIdle() {
		return 0;
	}

	@Override
	public int getMinIdle() {
		return 0;
	}

	@Override
	public int getInitialSize() {
		return 0;
	}

	@Override
	public long getMaxWaitMillis() {
		return 0;
	}

	@Override
	public boolean isPoolPreparedStatements() {
		return false;
	}

	@Override
	public int getMaxOpenPreparedStatements() {
		return 0;
	}

	@Override
	public boolean getTestOnCreate() {
		return false;
	}

	@Override
	public boolean getTestOnBorrow() {
		return false;
	}

	@Override
	public long getTimeBetweenEvictionRunsMillis() {
		return 0;
	}

	@Override
	public int getNumTestsPerEvictionRun() {
		return 0;
	}

	@Override
	public long getMinEvictableIdleTimeMillis() {
		return 0;
	}

	@Override
	public long getSoftMinEvictableIdleTimeMillis() {
		return 0;
	}

	@Override
	public boolean getTestWhileIdle() {
		return false;
	}

	@Override
	public int getNumActive() {
		return 0;
	}

	@Override
	public int getNumIdle() {
		return 0;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUrl() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public String getValidationQuery() {
		return null;
	}

	@Override
	public int getValidationQueryTimeout() {
		return 0;
	}

	@Override
	public String[] getConnectionInitSqlsAsArray() {
		return new String[0];
	}

	@Override
	public boolean isAccessToUnderlyingConnectionAllowed() {
		return false;
	}

	@Override
	public long getMaxConnLifetimeMillis() {
		return 0;
	}

	@Override
	public boolean getLogExpiredConnections() {
		return false;
	}

	@Override
	public boolean getRemoveAbandonedOnBorrow() {
		return false;
	}

	@Override
	public boolean getRemoveAbandonedOnMaintenance() {
		return false;
	}

	@Override
	public int getRemoveAbandonedTimeout() {
		return 0;
	}

	@Override
	public boolean getLogAbandoned() {
		return false;
	}

	@Override
	public boolean isClosed() {
		return false;
	}

	@Override
	public boolean getFastFailValidation() {
		return false;
	}

	@Override
	public String[] getDisconnectionSqlCodesAsArray() {
		return new String[0];
	}
}
