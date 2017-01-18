package net.jplugin.core.mtenant.impl.kit.utils;

import java.util.List;
import java.util.Map;

/**
 * @author gaojh
 * @date 2017/1/7
 */
public class SqlHelper {

	 public static String format(String sourceSql) {

	        sourceSql = StringUtils.replaceAll(sourceSql, "\\t", " ");
	        sourceSql = StringUtils.replaceAll(sourceSql, "\\r", " ");
	        sourceSql = StringUtils.replaceAll(sourceSql, "\\n", " ");
	        sourceSql = StringUtils.replaceAll(sourceSql, "= ", "=");
	        sourceSql = StringUtils.replaceAll(sourceSql, " =", "=");
	        sourceSql = StringUtils.replaceAll(sourceSql, "\\(", " ( ");
	        sourceSql = StringUtils.replaceAll(sourceSql, "\\)", " ) ");
	        sourceSql = StringUtils.replaceAll(sourceSql, ",", " , ");

	        while (true) {
	            if (StringUtils.contains(sourceSql, "  ")) {
	                sourceSql = StringUtils.replaceAll(sourceSql, "  ", " ");
	            } else {
	                break;
	            }
	        }

	        return sourceSql.toLowerCase().trim();
	    }

	    public static String toSql(List<String> list) {
	        StringBuilder sb = new StringBuilder();
	        for (String s : list) {
	            sb.append(s).append(" ");
	        }
	        String sql = sb.toString().trim();
	        while (true) {
	            if (StringUtils.contains(sql, "  ")) {
	                sql = StringUtils.replaceAll(sql, "  ", " ");
	            } else {
	                break;
	            }
	        }
	        sql = StringUtils.replaceAll(sql, "\\( ", "(");
	        sql = StringUtils.replaceAll(sql, " \\)", ")");
	        sql = StringUtils.replaceAll(sql, " , ", ", ");
	        return sql;
	    }

	    public static String createWhere(Map<String, Object> params, String flag) {
	        StringBuilder sb = new StringBuilder();
	        if ("N".equalsIgnoreCase(flag)) {
	            sb.append("where ");
	        }
	        for (String key : params.keySet()) {
	            Object value = params.get(key);
	            if (value instanceof Integer) {
	                sb.append(key).append("=").append(value).append(" and ");
	            } else if (value instanceof Long) {
	                sb.append(key).append("=").append(value).append(" and ");
	            } else if (value instanceof Float) {
	                sb.append(key).append("=").append(value).append(" and ");
	            } else if (value instanceof Double) {
	                sb.append(key).append("=").append(value).append(" and ");
	            } else {
	                sb.append(key).append("='").append(value).append("' and ");
	            }
	        }

	        if ("N".equalsIgnoreCase(flag)) {
	            return StringUtils.substringBeforeLast(sb.toString(), " and ");
	        } else {
	            return sb.toString();
	        }
	    }


	    public static String createWheres(Map<String, String> aliasmap, List<String> tables, Map<String, Object> params, String flag) {
	        if (tables == null || tables.size() == 0) {
	            return "";
	        }
	        StringBuilder sb = new StringBuilder();
	        if ("N".equalsIgnoreCase(flag)) {
	            sb.append("where ");
	        }

	        for (String t : tables) {
	            for (String key : params.keySet()) {
	                Object value = params.get(key);
	                if (value instanceof Integer || value instanceof Long || value instanceof Float || value instanceof Double) {
	                    if (aliasmap.containsKey(t)) {
	                        sb.append(aliasmap.get(t)).append(".").append(key).append("=").append(value).append(" and ");
	                    } else {
	                        sb.append(key).append("=").append(value).append(" and ");
	                    }
	                } else {
	                    if (aliasmap.containsKey(t)) {
	                        sb.append(aliasmap.get(t)).append(".").append(key).append("='").append(value).append("' and ");
	                    } else {
	                        sb.append(key).append("='").append(value).append("' and ");
	                    }
	                }
	            }
	        }

	        if ("N".equalsIgnoreCase(flag)) {
	            return StringUtils.substringBeforeLast(sb.toString(), " and ");
	        } else {
	            return sb.toString();
	        }
	    }
}
