/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gao.soloblog.common.util.logger;

/**
 * 日志接口 <p/> 声明：引用自commons-logging
 *
 * @author william.liangf
 */
public interface Logger {

    /**
     * 输出跟踪信息
     *
     * @param msg 信息内容
     */
    public void trace(String msg);
    
    /**
     * 输出带一个参数的跟踪信息
     * @param pattern 信息模板
     * @param param
     */
    public void trace(String pattern, Object param);

    /**
     * 输出带两个参数的跟踪信息
     * @param pattern 信息模板
     * @param param1
     * @param param2
     */
    public void trace(String pattern, Object param1, Object param2);

    /**
     * 输出带多个(两个以上)参数的跟踪信息
     * @param pattern 信息模板
     * @param paramArray
     */
    public void trace(String pattern, Object... paramArray);

    /**
     * 输出跟踪信息
     *
     * @param e 异常信息
     */
    public void trace(Throwable e);
    
    /**
     * 输出跟踪信息
     *
     * @param msg 信息内容
     * @param e 异常信息
     */
    public void trace(String msg, Throwable e);

	/**
	 * 输出调试信息
	 *
	 * @param msg 信息内容
	 */
	public void debug(String msg);
	
	/**
     * 输出带一个参数的调试信息
     * @param pattern 信息模板
     * @param param
     */
    public void debug(String pattern, Object param);

    /**
     * 输出带两个参数的调试信息
     * @param pattern 信息模板
     * @param param1
     * @param param2
     */
    public void debug(String pattern, Object param1, Object param2);

    /**
     * 输出带多个(两个以上)参数的调试信息
     * @param pattern 信息模板
     * @param paramArray
     */
    public void debug(String pattern, Object... paramArray);

	/**
     * 输出调试信息
     *
     * @param e 异常信息
     */
	public void debug(Throwable e);
	
	/**
	 * 输出调试信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	public void debug(String msg, Throwable e);

	/**
	 * 输出普通信息
	 *
	 * @param msg 信息内容
	 */
	public void info(String msg);
	
	/**
	 * 输出带一个参数的信息
	 * @param pattern 信息模板
	 * @param param
	 */
    public void info(String pattern, Object param);

    /**
     * 输出带两个参数的信息
     * @param pattern 信息模板
     * @param param1
     * @param param2
     */
    public void info(String pattern, Object param1, Object param2);

    /**
     * 输出带多个(两个以上)参数的信息
     * @param pattern 信息模板
     * @param paramArray
     */
    public void info(String pattern, Object... paramArray);

	/**
     * 输出普通信息
     *
     * @param e 异常信息
     */
	public void info(Throwable e);
	
	/**
	 * 输出普通信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	public void info(String msg, Throwable e);

	/**
	 * 输出警告信息
	 *
	 * @param msg 信息内容
	 */
	public void warn(String msg);
	
	   /**
     * 输出带一个参数的警告信息
     * @param pattern 信息模板
     * @param param
     */
    public void warn(String pattern, Object param);

    /**
     * 输出带两个参数的警告信息
     * @param pattern 信息模板
     * @param param1
     * @param param2
     */
    public void warn(String pattern, Object param1, Object param2);

    /**
     * 输出带多个(两个以上)参数的警告信息
     * @param pattern 信息模板
     * @param paramArray
     */
    public void warn(String pattern, Object... paramArray);
    
	/**
     * 输出警告信息
     *
     * @param e 异常信息
     */
	public void warn(Throwable e);

	/**
	 * 输出警告信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	public void warn(String msg, Throwable e);

	/**
	 * 输出错误信息
	 *
	 * @param msg 信息内容
	 */
	public void error(String msg);
	   
    /**
     * 输出带一个参数的错误信息
     * @param pattern 信息模板
     * @param param
     */
     public void error(String pattern, Object param);
    
     /**
      * 输出带两个参数的错误信息
      * @param pattern 信息模板
      * @param param1
      * @param param2
      */
     public void error(String pattern, Object param1, Object param2);
    
     /**
      * 输出带多个(两个以上)参数的错误信息
      * @param pattern 信息模板
      * @param paramArray
      */
     public void error(String pattern, Object... paramArray);
 
	/**
     * 输出错误信息
     *
     * @param e 异常信息
     */
	public void error(Throwable e);

	/**
	 * 输出错误信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	public void error(String msg, Throwable e);
}