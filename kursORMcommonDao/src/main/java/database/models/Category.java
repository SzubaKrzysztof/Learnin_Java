package database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "CATEGORIES")
public class Category implements BaseModel {

    public Category () {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAME", canBeNull = false)
    private String name;

    @ForeignCollectionField(eager = true)
    public ForeignCollectionField books;


    public void setId ( int id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public ForeignCollectionField getBooks () {
        return books;
    }

    public void setBooks ( ForeignCollectionField books ) {
        this.books = books;
    }

    public int getId(){
        return id;
    }

}

