package com.zwl9517.zutillibrary.sample.adpater;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/06
 *      version:
 *      desc   : for ListView item entity
 * </pre>
 */
public class ItemData {

    private String title;
    private int tag;
    private int icon;

    public ItemData(String title, int tag) {
        this(title, tag, 0);
    }

    public ItemData(String title, int tag, int icon) {
        this.title = title;
        this.tag = tag;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
