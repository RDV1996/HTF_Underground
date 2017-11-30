package be.thomasmore.underground;

public class Terrorist {
    private String id;
    private String name;
    private String image;
    private String riskLevel;
    private int rank;

    public Terrorist() {
    }

    public Terrorist(String id, String name, String image, String riskLevel, int rank) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.riskLevel = riskLevel;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
