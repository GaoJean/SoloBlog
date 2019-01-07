package com.solo;

/**
 * @Author gaojian
 * @Date 2018/10/16
 */
public class GroupVo {
    private int id;
     private String name;
     private String path;
     private String description;
     private String visibility;
     private boolean lfs_enabled;
     private String avatar_url;
     private String web_url;
     private boolean request_access_enabled;
     private String full_name;
     private String full_path;
     private int parent_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public boolean isLfs_enabled() {
        return lfs_enabled;
    }

    public void setLfs_enabled(boolean lfs_enabled) {
        this.lfs_enabled = lfs_enabled;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public boolean isRequest_access_enabled() {
        return request_access_enabled;
    }

    public void setRequest_access_enabled(boolean request_access_enabled) {
        this.request_access_enabled = request_access_enabled;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFull_path() {
        return full_path;
    }

    public void setFull_path(String full_path) {
        this.full_path = full_path;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }
}
