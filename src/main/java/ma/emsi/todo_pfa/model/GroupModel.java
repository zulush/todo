package ma.emsi.todo_pfa.model;

import ma.emsi.todo_pfa.entity.Group;

public class GroupModel {
	
	private int id;
	private String name;
	
	public GroupModel(Group data){
		this.id = data.getGroupId();
		this.name = data.getName();
	}

	@Override
	public String toString() {
		return "GroupModel [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
