package apphub.model;

public class Category
{
	private int id;
	private String name;
	private String emoji;
	
	public Category(int id,String name,String emoji)
	{
		this.id=id;
		this.name=name;
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
	public String getemoji()
	{
		return emoji;
	}
}