package ma.emsi.todo_pfa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "users_group")
public class Group {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int groupId;
	@ManyToOne
	private AppUser admin;
	@ManyToMany
	private List<AppUser> members;
	
}
