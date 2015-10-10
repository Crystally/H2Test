package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Foo")
public class Foo {
	public Foo(){
		super();
	}
	@Id
	@Column(name="id")
	private String id;
	@Column(name="name")
	private String name;
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
	public Foo(String id,String name){
		this.id=id;
		this.name=name;
	}
}
