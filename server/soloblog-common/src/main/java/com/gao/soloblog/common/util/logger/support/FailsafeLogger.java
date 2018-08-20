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
package com.gao.soloblog.common.util.logger.support;

import com.gao.soloblog.common.util.logger.Logger;

public class FailsafeLogger implements Logger {

	private Logger logger;

	public FailsafeLogger(final Logger logger) {
		this.logger = logger;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(final Logger logger) {
		this.logger = logger;
	}
	
    private String getLineNumber() {
        return Thread.currentThread().getStackTrace()[3].getLineNumber() + " - " ;
    }

    public void trace(final String msg, final Throwable e) {
        try {
            logger.trace(this.getLineNumber() + msg, e);
        } catch (Throwable t) {
        }
    }

    public void trace(final Throwable e) {
        try {
            logger.trace(e);
        } catch (Throwable t) {
        }
    }

    public void trace(final String msg) {
        try {
            logger.trace(this.getLineNumber() + msg);
        } catch (Throwable t) {
        }
    }
    
    public void trace(final String pattern, final Object param){
        try {
            logger.trace(this.getLineNumber() + pattern,param);
        } catch (Throwable t) {
        }
    }
    
    public void trace(final String pattern, final Object param1, final Object param2){
        try {
            logger.trace(this.getLineNumber() + pattern,param1,param2);
        } catch (Throwable t) {
        }
    }
    
    public void trace(final String pattern, final Object... paramArray){
        try {
            logger.trace(this.getLineNumber() + pattern,paramArray);
        } catch (Throwable t) {
        }
    }

    public void debug(final String msg, final Throwable e) {
		try {
			logger.debug(this.getLineNumber() + msg, e);
		} catch (Throwable t) {
		}
	}

    
    public void debug(final Throwable e) {
        try {
            logger.debug(e);
        } catch (Throwable t) {
        }
    }

	
    public void debug(final String msg) {
		try {
			logger.debug(this.getLineNumber() + msg);
		} catch (Throwable t) {
		}
	}
	
     
    public void debug(final String pattern, final Object param){
        try {
            logger.debug(this.getLineNumber() + pattern,param);
        } catch (Throwable t) {
        }
    }
    
    
    public void debug(final String pattern, final Object param1, final Object param2){
        try {
            logger.debug(this.getLineNumber() + pattern,param1,param2);
        } catch (Throwable t) {
        }
    }
    
    
    public void debug(final String pattern, final Object... paramArray){
        try {
            logger.debug(this.getLineNumber() + pattern,paramArray);
        } catch (Throwable t) {
        }
    }

	
    public void info(final String msg, final Throwable e) {
		try {
			logger.info(this.getLineNumber() + msg, e);
		} catch (Throwable t) {
		}
	}

	
    public void info(final String msg) {
		try {
			logger.info(this.getLineNumber() + msg);
		} catch (Throwable t) {
		}
	}
	
	 
	public void info(final String pattern, final Object param){
        try {
            logger.info(this.getLineNumber() + pattern,param);
        } catch (Throwable t) {
        }
	}
	
	
	public void info(final String pattern, final Object param1, final Object param2){
        try {
            logger.info(this.getLineNumber() + pattern,param1,param2);
        } catch (Throwable t) {
        }
	}
	
	
	public void info(final String pattern, final Object... paramArray){
        try {
            logger.info(this.getLineNumber() + pattern,paramArray);
        } catch (Throwable t) {
        }
	}

	
    public void warn(final String msg, final Throwable e) {
		try {
			logger.warn(this.getLineNumber() + msg, e);
		} catch (Throwable t) {
		}
	}

	
    public void warn(final String msg) {
		try {
			logger.warn(this.getLineNumber() + msg);
		} catch (Throwable t) {
		}
	}
	
     
    public void warn(final String pattern, final Object param){
        try {
            logger.warn(this.getLineNumber() + pattern,param);
        } catch (Throwable t) {
        }
    }
    
    
    public void warn(final String pattern, final Object param1, final Object param2){
        try {
            logger.warn(this.getLineNumber() + pattern,param1,param2);
        } catch (Throwable t) {
        }
    }
    
    
    public void warn(final String pattern, final Object... paramArray){
        try {
            logger.warn(this.getLineNumber() + pattern,paramArray);
        } catch (Throwable t) {
        }
    }

	
    public void error(final String msg, final Throwable e) {
		try {
			logger.error(this.getLineNumber() + msg, e);
		} catch (Throwable t) {
		}
	}

	
    public void error(final String msg) {
		try {
			logger.error(this.getLineNumber() + msg);
		} catch (Throwable t) {
		}
	}
    
     
    public void error(final String pattern, final Object param){
        try {
            logger.error(this.getLineNumber() + pattern,param);
        } catch (Throwable t) {
        }
    }
    
    
    public void error(final String pattern, final Object param1, final Object param2){
        try {
            logger.error(this.getLineNumber() + pattern,param1,param2);
        } catch (Throwable t) {
        }
    }
    
    
    public void error(final String pattern, final Object... paramArray){
        try {
            logger.error(this.getLineNumber() + pattern,paramArray);
        } catch (Throwable t) {
        }
    }
    
    
    public void error(final Throwable e) {
        try {
            logger.error(e);
        } catch (Throwable t) {
        }
    }

    
    public void info(final Throwable e) {
        try {
            logger.info(e);
        } catch (Throwable t) {
        }
    }

    
    public void warn(final Throwable e) {
        try {
            logger.warn(e);
        } catch (Throwable t) {
        }
    }
}