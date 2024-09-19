package app;

public class News implements INews {
    private int ID;
    private String Title;
    private String PublishDate;
    private String Author;
    private String Content;
    private float AverageRate;
	
	private int[] RateList = new int[3];

    // Constructor
    public News(int ID, String Title, String PublishDate, String Author, String Content, float AverageRate) {
        this.ID = ID;
        this.Title = Title;
        this.PublishDate = PublishDate;
        this.Author = Author;
        this.Content = Content;
        this.AverageRate = AverageRate;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(String PublishDate) {
        this.PublishDate = PublishDate;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public float getAverageRate() {
        return AverageRate;
    }
    
    public int[] getRateList() {
        return getRateList();
    }

    public void setRateList(int[] RateList) {
        this.RateList = RateList;
    }
	@Override
	public void Display() {
		// TODO Auto-generated method stub
		System.out.println("Title: " + Title);
        System.out.println("Publish Date: " + PublishDate);
        System.out.println("Author: " + Author);
        System.out.println("Content: " + Content);
        System.out.println("Average Rate: " + AverageRate);
		
	}
	
	public void Calculate() {
		int sum =0;
		for( int rate : RateList) {
			sum += rate;
		}
		this.AverageRate = sum /(float)RateList.length;
	}
    
    
}
