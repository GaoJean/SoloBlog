package com.gao.soloblog.common.util.logger.slf4j;

import java.io.File;

import com.gao.soloblog.common.util.logger.Level;
import com.gao.soloblog.common.util.logger.Logger;
import com.gao.soloblog.common.util.logger.LoggerAdapter;


public class Slf4jLoggerAdapter implements LoggerAdapter {
    
    public Logger getLogger(final String key) {
		return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(key));
	}

    public Logger getLogger(final Class<?> key) {
        return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(key));
    }

    private Level level;
    
    private File file;

    public void setLevel(final Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public File getFile() {
        return file;
    }

    public void setFile(final File file) {
        this.file = file;
    }

}
