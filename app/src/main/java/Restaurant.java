// Restaurant.java
public class Restaurant {
    private String name;
    private String websiteUrl;
    private int imageResource;

    public Restaurant(String name, String websiteUrl, int imageResource) {
        this.name = name;
        this.websiteUrl = websiteUrl;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public int getImageResource() {
        return imageResource;
    }
}
