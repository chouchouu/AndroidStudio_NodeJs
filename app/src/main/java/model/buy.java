package model;

import com.google.gson.annotations.SerializedName;

public class buy {
    private String _id;
    private String name;
    private String tentype;
    private String loaitype;
    private String picture;
    private String price;
    private String describe;
    private String image;


    public buy() {
    }

    public buy(String _id, String name, String tentype, String loaitype, String picture, String price, String describe, String image) {
        this._id = _id;
        this.name = name;
        this.tentype = tentype;
        this.loaitype = loaitype;
        this.picture = picture;
        this.price = price;
        this.describe = describe;
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTentype() {
        return tentype;
    }

    public void setTentype(String tentype) {
        this.tentype = tentype;
    }

    public String getLoaitype() {
        return loaitype;
    }

    public void setLoaitype(String loaitype) {
        this.loaitype = loaitype;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
