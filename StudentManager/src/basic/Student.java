package basic;
//객체직렬호를 위해서 Serializable 인터페이스를 구현해주어야 한다.

public class Student implements Serializable{
	private String id;
	private String name;
	private int score;

	public Student(String id, String name, int score)
	{
		this.id=id;
		this.name=name;
		this.score=score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	//두 객체의 id가 같으면 같은객체로 인식
	//객체끼리 같은지 아닌지 비교할때 equals 메소드로 비교
	public boolean equals(Object obj)
	{
		boolean result = true;
		
		if(obj instanceof Student) {
			Student stu = (Student) obj;
			return id.equals(stu.id);
		}
		return result;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	
	
}
