package model;

public class catagory {
    private String _id;
    private String loaitype;
    private String picture;

    public catagory() {
    }

    public catagory(String _id, String loaitype, String picture) {
        this._id = _id;
        this.loaitype = loaitype;
        this.picture = picture;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
}
