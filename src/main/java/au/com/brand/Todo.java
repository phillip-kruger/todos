package au.com.brand;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Todo extends PanacheEntity{
    public String title;
    public String description;
    public boolean isDone = false;
}
