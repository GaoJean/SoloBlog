package com.gao.soloblog.common.util.logger.slf4j;

import java.io.Serializable;

import com.gao.soloblog.common.util.logger.Logger;


public class Slf4jLogger implements Logger, Serializable {

	private static final long serialVersionUID = 1L;

	private final org.slf4j.Logger logger;

	public Slf4jLogger(final org.slf4j.Logger logger) {
		this.logger = logger;
	}

    public void trace(final String msg) {
        logger.trace(msg);
    }
    
    public void trace(final String pattern, final Object param){
        logger.trace(pattern,param);
    }
    
    public void trace(final String pattern, final Object param1, final Object param2){
        logger.trace(pattern,param1,param2);
    }
    
    public void trace(final String pattern, final Object... paramArray){
        logger.trace(pattern,paramArray);
    }

    public void trace(final Throwable e) {
        logger.trace(e.getMessage(), e);
    }

    public void trace(final String msg, final Throwable e) {
        logger.trace(msg, e);
    }

    public void debug(final String msg) {
        logger.debug(msg);
    }
    
    public void debug(final String pattern, final Object param){
        logger.debug(pattern,param);
    }
    
    public void debug(final String pattern, final Object param1, final Object param2){
        logger.debug(pattern,param1,param2);
    }
    
    public void debug(final String pattern, final Object... paramArray){
        logger.debug(pattern,paramArray);
    }

    public void debug(final Throwable e) {
        logger.debug(e.getMessage(), e);
    }

    public void debug(final String msg, final Throwable e) {
        logger.debug(msg, e);
    }

    public void info(final String msg) {
        logger.info(msg);
    }

    public void info(final Throwable e) {
        logger.info(e.getMessage(), e);
    }

    public void info(final String msg, final Throwable e) {
        logger.info(msg, e);
    }
    
    public void info(final String pattern, final Object param){
        logger.info(pattern,param);
    }
    
    public void info(final String pattern, final Object param1, final Object param2){
        logger.info(pattern,param1,param2);
    }
    
    public void info(final String pattern, final Object... paramArray){
        logger.info(pattern,paramArray);
    }

    public void warn(final String msg) {
        logger.warn(msg);
    }
    
    public void warn(final String pattern, final Object param){
        logger.warn(pattern,param);
    }
    
    public void warn(final String pattern, final Object param1, final Object param2){
        logger.warn(pattern,param1,param2);
    }
    
    public void warn(final String pattern, final Object... paramArray){
        logger.warn(pattern,paramArray);
    }
    
    public void warn(final Throwable e) {
        logger.warn(e.getMessage(), e);
    }

    public void warn(final String msg, final Throwable e) {
        logger.warn(msg, e);
    }

    public void error(final String msg) {
        logger.error(msg);
    }
    
    public void error(final String pattern, final Object param){
        logger.error(pattern,param);
    }
    
    public void error(final String pattern, final Object param1, final Object param2){
        logger.error(pattern,param1,param2);
    }
    
    public void error(final String pattern, final Object... paramArray){
        logger.error(pattern,paramArray);
    }
    
    public void error(final Throwable e) {
        logger.error(e.getMessage(), e);
    }

    public void error(final String msg, final Throwable e) {
        logger.error(msg, e);
    }
}
