package configuration.yaml.model;

public class BaseModel{
    private String url;
    private String title;

    public BaseModel(){
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        BaseModel baseModel = (BaseModel) obj;
        return url.equals(baseModel.url) &&
                title.equals(baseModel.title);
    }

    @Override
    public String toString(){
        return "BaseModel{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
