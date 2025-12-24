package apphub.model;

public class Application
{
	private int id;
	private String name;
	private String link;
	private String emoji;
	
	public Application(int id,String name,String link,String emoji)
	{
		this.id=id;
		this.name=name;
		this.link=link;
		this.emoji=emoji;
	}
	
	public int getid()
	{
		return id;
	}
	public String getname()
	{
		return name;
	}
	public String getlink()
	{
		return link;
	}
	public String getemoji()
	{
		return emoji;
	}
}