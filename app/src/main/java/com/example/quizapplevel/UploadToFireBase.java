package com.example.quizapplevel;

public class UploadToFireBase {
    private String mName;
    private String mImageUrl;

    public UploadToFireBase(){

    }

    public UploadToFireBase(String name,String imageUrl){
        if(name.trim().equals("")){
            name = "No Name";
        }
        mName = name;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.mImageUrl = imageUrl;
    }
}
