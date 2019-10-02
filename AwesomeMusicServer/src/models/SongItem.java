package models;

import javafx.beans.property.SimpleStringProperty;

public class SongItem {
	
	private SimpleStringProperty title;
	private SimpleStringProperty id;
	private SimpleStringProperty artist;
	private SimpleStringProperty record;
    
    public SongItem(String title, String artist, String id, String record) {
    	this.title = new SimpleStringProperty(title);	
		this.id = new SimpleStringProperty(id);
		this.artist = new SimpleStringProperty(artist);
		this.record = new SimpleStringProperty(record);
	}

	@Override
	public String toString() {
		return "Song [title=" + title.getValue() + ", artist=" + artist.getValue() +  ", id=" + id.getValue() + "]";
	}

	public String getTitle() {
		return title.get();
	}

	public String getId() {
		return id.get();
	}

	public String getArtist() {
		return artist.get();
	}

	public String getRecord() {
		return record.get();
	}


}
