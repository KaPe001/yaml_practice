package configuration.yaml.model;

public class BaseModel{
    private final String url;
    private final String title;

    public BaseModel(String url, String title){
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
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
